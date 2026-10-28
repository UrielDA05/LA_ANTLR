import os
import subprocess
import shutil
from http.server import HTTPServer, SimpleHTTPRequestHandler
import json

class Handler(SimpleHTTPRequestHandler):
    def do_POST(self):
        if self.path == '/ejecutar':
            length = int(self.headers['Content-Length'])
            data = json.loads(self.rfile.read(length).decode('utf-8'))
            
            nombre_archivo = data['archivo'].strip()
            if not nombre_archivo.endswith('.bzl'):
                nombre_archivo += '.bzl'
                
            notas_simples = data['notas']

            if "Main |:" not in notas_simples:
                codigo_bzl = f"Main |:\n    (:) {{ {notas_simples} }}\n:|"
            else:
                codigo_bzl = notas_simples

            nombre_carpeta = os.path.splitext(nombre_archivo)[0]

            dir_propio = os.path.join("programas", nombre_carpeta)
            os.makedirs(dir_propio, exist_ok=True)

            ruta_bzl = os.path.join(dir_propio, nombre_archivo)
            with open(ruta_bzl, "w", encoding="utf-8") as f:
                f.write(codigo_bzl)

            # Ejecutar tu compilador bazilio.py
            cmd = ["python3", "bazilio.py", ruta_bzl]
            res = subprocess.run(cmd, capture_output=True, text=True)

            salida = res.stderr.strip() if res.stderr else res.stdout.strip()
            
            # Comprimir toda la carpeta de salida en un .zip para enviarla al cliente
            zip_path = f"{dir_propio}"
            shutil.make_archive(zip_path, 'zip', dir_propio)
            
            # Leer el zip en base64 o enviarlo mediante una ruta de descarga directa
            self.send_response(200)
            self.send_header('Content-Type', 'application/json')
            self.end_headers()
            
            msg = f"[ÉXITO] Procesado correctamente.\n\n{salida}"
            
            # Devolvemos la ruta relativa del zip para que la página web lo descargue
            respuesta = {
                'resultado': msg,
                'zip_url': f"/{dir_propio}.zip"
            }
            self.wfile.write(json.dumps(respuesta).encode('utf-8'))

if __name__ == '__main__':
    port = int(os.environ.get("PORT", 8000))
    servidor = ('0.0.0.0', port)
    print(f"Servidor Bazilio corriendo en el puerto {port}")
    httpd = HTTPServer(servidor, Handler)
    httpd.serve_forever()