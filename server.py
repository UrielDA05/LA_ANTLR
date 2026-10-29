import os
import subprocess
import shutil
from http.server import HTTPServer, BaseHTTPRequestHandler
import json
import urllib.parse

HTML_PAGE = """<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Compilador Bazilio - Descargas</title>
    <style>
        body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; max-width: 800px; margin: 40px auto; padding: 20px; background-color: #f4f6f9; color: #333; }
        h2 { color: #1e293b; border-bottom: 2px solid #cbd5e1; padding-bottom: 10px; }
        label { font-weight: 600; display: block; margin-top: 15px; color: #475569; }
        input[type="text"] { width: 100%; padding: 10px; margin-top: 5px; box-sizing: border-box; border: 1px solid #cbd5e1; border-radius: 6px; font-size: 14px; }
        textarea { width: 100%; height: 160px; padding: 12px; margin-top: 5px; box-sizing: border-box; border: 1px solid #cbd5e1; border-radius: 6px; font-family: 'Courier New', Courier, monospace; font-size: 14px; background-color: #fff; }
        button { margin-top: 15px; padding: 12px 24px; background-color: #2563eb; color: white; border: none; border-radius: 6px; cursor: pointer; font-size: 15px; font-weight: 600; transition: background 0.2s; }
        button:hover { background-color: #1d4ed8; }
        pre { background-color: #0f172a; color: #38bdf8; padding: 15px; border-radius: 6px; white-space: pre-wrap; word-wrap: break-word; margin-top: 20px; font-family: monospace; font-size: 13px; max-height: 200px; overflow-y: auto; }
        
        .seccion-resultados { margin-top: 25px; display: none; background: #ffffff; padding: 20px; border-radius: 8px; box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1); }
        .panel-descargas { display: flex; gap: 10px; flex-wrap: wrap; margin-top: 15px; }
        .btn-download { display: inline-block; padding: 12px 20px; border-radius: 6px; color: #fff; text-decoration: none; font-weight: 600; font-size: 14px; text-align: center; }
        .btn-zip { background-color: #16a34a; }
        .btn-zip:hover { background-color: #15803d; }
        .btn-file { background-color: #0284c7; }
        .btn-file:hover { background-color: #0369a1; }
    </style>
</head>
<body>

    <h2>🎵 Compilador y Generador Musical Bazilio</h2>

    <label for="archivo">Nombre de la obra / archivo:</label>
    <input type="text" id="archivo" value="novena_1" placeholder="Ej. novena_1">

    <label for="codigo">Entrada de Notas o Código (.bzl):</label>
    <textarea id="codigo" placeholder="Main |:&#10;    (:) { C D E F G A B }&#10;:|"></textarea>

    <button onclick="procesarGramatica()">⚡ Procesar y Compilar</button>

    <pre id="salida">Esperando ejecución...</pre>

    <div id="seccionResultados" class="seccion-resultados">
        <h3>📥 Archivos Listos para Descarga</h3>
        <div class="panel-descargas" id="panelDescargas"></div>
    </div>

    <script>
        async function procesarGramatica() {
            let salida = document.getElementById('salida');
            let notas = document.getElementById('codigo').value;
            let archivo = document.getElementById('archivo').value;
            let seccion = document.getElementById('seccionResultados');

            salida.textContent = "Procesando código, partitura y audios en el servidor...";
            seccion.style.display = "none";

            try {
                let response = await fetch('/ejecutar', {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify({ archivo: archivo, notas: notas })
                });

                let data = await response.json();
                salida.textContent = data.resultado;
                seccion.style.display = "block";

                let panel = document.getElementById('panelDescargas');
                panel.innerHTML = "";

                if (data.zip_url) {
                    panel.innerHTML += `<a href="${data.zip_url}" download class="btn-download btn-zip">📦 Descargar Paquete Completo (.ZIP)</a>`;
                }
                if (data.pdf_url) {
                    panel.innerHTML += `<a href="${data.pdf_url}" download class="btn-download btn-file">📄 Descargar PDF</a>`;
                }
                if (data.audio_url) {
                    panel.innerHTML += `<a href="${data.audio_url}" download class="btn-download btn-file">🎧 Descargar MP3</a>`;
                }
                if (data.bzl_url) {
                    panel.innerHTML += `<a href="${data.bzl_url}" download class="btn-download btn-file">📜 Descargar .BZL</a>`;
                }

            } catch (err) {
                salida.textContent = "Error al conectar con el servidor: " + err.message;
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
            return

        ruta_limpia = urllib.parse.unquote(self.path.lstrip('/'))
        if os.path.exists(ruta_limpia) and os.path.isfile(ruta_limpia):
            self.send_response(200)
            if ruta_limpia.endswith('.pdf'):
                self.send_header('Content-Type', 'application/pdf')
            elif ruta_limpia.endswith('.mp3'):
                self.send_header('Content-Type', 'audio/mpeg')
            elif ruta_limpia.endswith('.wav'):
                self.send_header('Content-Type', 'audio/wav')
            elif ruta_limpia.endswith('.zip'):
                self.send_header('Content-Type', 'application/zip')
                self.send_header('Content-Disposition', f'attachment; filename="{os.path.basename(ruta_limpia)}"')
            else:
                self.send_header('Content-Type', 'text/plain; charset=utf-8')
                
            self.end_headers()
            with open(ruta_limpia, 'rb') as f:
                self.wfile.write(f.read())
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

            # Ejecutar compilador bazilio.py
            cmd = ["python3", "bazilio.py", ruta_bzl]
            res = subprocess.run(cmd, capture_output=True, text=True)
            salida_consola = f"STDOUT:\n{res.stdout}\nSTDERR:\n{res.stderr}".strip()
            
            archivos_carpeta = os.listdir(dir_propio) if os.path.exists(dir_propio) else []
            
            pdf_path = next((os.path.join(dir_propio, f) for f in archivos_carpeta if f.endswith('.pdf')), None)
            audio_path = next((os.path.join(dir_propio, f) for f in archivos_carpeta if f.endswith('.mp3')), None)
            if not audio_path:
                audio_path = next((os.path.join(dir_propio, f) for f in archivos_carpeta if f.endswith('.wav')), None)
            
            zip_path = f"{dir_propio}"
            if os.path.exists(dir_propio):
                shutil.make_archive(zip_path, 'zip', dir_propio)
            
            self.send_response(200)
            self.send_header('Content-Type', 'application/json')
            self.end_headers()
            
            msg = f"[EJECUCIÓN COMPLETADA]\n\n{salida_consola}"
            respuesta = {
                'resultado': msg,
                'zip_url': f"/{dir_propio}.zip" if os.path.exists(f"{zip_path}.zip") else None,
                'bzl_url': f"/{ruta_bzl}",
                'pdf_url': f"/{pdf_path}" if pdf_path else None,
                'audio_url': f"/{audio_path}" if audio_path else None
            }
            self.wfile.write(json.dumps(respuesta).encode('utf-8'))

if __name__ == '__main__':
    port = int(os.environ.get("PORT", 8000))
    servidor = ('0.0.0.0', port)
    print(f"Servidor Bazilio corriendo en el puerto {port}")
    httpd = HTTPServer(servidor, Handler)
    httpd.serve_forever()