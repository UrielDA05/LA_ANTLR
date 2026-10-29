import os
import subprocess
import shutil
from http.server import HTTPServer, BaseHTTPRequestHandler
import json

HTML_PAGE = """<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Compilador Bazilio</title>
    <style>
        body { font-family: Arial, sans-serif; max-width: 800px; margin: 40px auto; padding: 20px; background-color: #f9f9f9; color: #333; }
        h2 { color: #2c3e50; }
        label { font-weight: bold; display: block; margin-top: 15px; }
        input[type="text"] { width: 100%; padding: 8px; margin-top: 5px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 4px; }
        textarea { width: 100%; height: 150px; padding: 10px; margin-top: 5px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 4px; font-family: monospace; }
        button { margin-top: 15px; padding: 10px 20px; background-color: #007bff; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 16px; }
        button:hover { background-color: #0056b3; }
        pre { background-color: #fff; padding: 15px; border: 1px solid #ddd; border-radius: 4px; white-space: pre-wrap; word-wrap: break-word; margin-top: 20px; font-family: monospace; }
    </style>
</head>
<body>
    <h2>Proyecto Bazilio - Compilador</h2>
    <label for="archivo">Nombre del archivo:</label>
    <input type="text" id="archivo" value="novena_1" placeholder="Ej. novena_1">
    <label for="codigo">Notas / Texto simple:</label>
    <textarea id="codigo" placeholder="Escribe tus notas aquí..."></textarea>
    <button onclick="procesarGramatica()">Ejecutar bazilio.py</button>
    <pre id="salida"></pre>

    <script>
        async function procesarGramatica() {
            let salida = document.getElementById('salida');
            let notas = document.getElementById('codigo').value;
            let archivo = document.getElementById('archivo').value;
            salida.textContent = "Procesando en el servidor de Render...";

            try {
                let response = await fetch('/ejecutar', {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify({ archivo: archivo, notas: notas })
                });
                let data = await response.json();
                salida.textContent = data.resultado;

                if (data.zip_url) {
                    let btnAnterior = document.getElementById('btnDescargarZip');
                    if (btnAnterior) btnAnterior.remove();

                    let btnDescarga = document.createElement('a');
                    btnDescarga.id = 'btnDescargarZip';
                    btnDescarga.href = data.zip_url;
                    btnDescarga.download = true;
                    btnDescarga.textContent = "📥 Descargar resultados comprimidos (.zip)";
                    btnDescarga.style.display = "block";
                    btnDescarga.style.marginTop = "15px";
                    btnDescarga.style.padding = "12px";
                    btnDescarga.style.background = "#28a745";
                    btnDescarga.style.color = "#fff";
                    btnDescarga.style.textAlign = "center";
                    btnDescarga.style.textDecoration = "none";
                    btnDescarga.style.borderRadius = "5px";
                    btnDescarga.style.fontWeight = "bold";

                    salida.parentNode.appendChild(btnDescarga);
                }
            } catch (err) {
                salida.textContent = "Error de conexión: " + err.message;
            }
        }
    </script>
</body>
</html>"""

class Handler(BaseHTTPRequestHandler):
    def do_GET(self):
        if self.path == '/' or self.path == '/index.html':
            self.send_response(200)
            self.send_header('Content-Type', 'text/html; charset=utf-8')
            self.end_headers()
            self.wfile.write(HTML_PAGE.encode('utf-8'))
        elif self.path.endswith('.zip'):
            zip_file = self.path.lstrip('/')
            if os.path.exists(zip_file):
                self.send_response(200)
                self.send_header('Content-Type', 'application/zip')
                self.send_header('Content-Disposition', f'attachment; filename="{os.path.basename(zip_file)}"')
                self.end_headers()
                with open(zip_file, 'rb') as f:
                    self.wfile.write(f.read())
            else:
                self.send_response(404)
                self.end_headers()
                self.wfile.write(b"Archivo ZIP no encontrado.")
        else:
            self.send_response(404)
            self.end_headers()

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

            # Ejecutar el compilador
            cmd = ["python3", "bazilio.py", ruta_bzl]
            res = subprocess.run(cmd, capture_output=True, text=True)
            salida = res.stderr.strip() if res.stderr else res.stdout.strip()
            
            # Comprimir carpeta de resultados
            zip_path = f"{dir_propio}"
            shutil.make_archive(zip_path, 'zip', dir_propio)
            
            self.send_response(200)
            self.send_header('Content-Type', 'application/json')
            self.end_headers()
            
            msg = f"[ÉXITO] Procesado correctamente en el servidor.\n\n{salida}"
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