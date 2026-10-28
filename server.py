import os
import subprocess
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

            cmd = ["python3", "bazilio.py", ruta_bzl]
            res = subprocess.run(cmd, capture_output=True, text=True)

            self.send_response(200)
            self.send_header('Content-Type', 'application/json')
            self.end_headers()
            
            salida = res.stderr.strip() if res.stderr else res.stdout.strip()
            msg = f"Guardado y procesado en: {dir_propio}/\n\n{salida or 'Procesado correctamente.'}"
            self.wfile.write(json.dumps({'resultado': msg}).encode('utf-8'))

if __name__ == '__main__':
    # Render asigna un puerto dinámico mediante os.environ.get("PORT") (por defecto 8000 localmente)
    port = int(os.environ.get("PORT", 8000))
    
    # IMPORTANTE: En la nube se usa "0.0.0.0" en lugar de "localhost" para aceptar peticiones externas
    servidor = ('0.0.0.0', port)
    
    print(f"Servidor Bazilio corriendo en el puerto {port}")
    httpd = HTTPServer(servidor, Handler)
    httpd.serve_forever()