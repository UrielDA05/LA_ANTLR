# Usar una imagen oficial de Python ligera basada en Debian/Ubuntu
FROM python:3.10-slim

# Instalar dependencias del sistema operativo necesarias para LilyPond y audio
RUN apt-get update && apt-get install -y \
    lilypond \
    fluidsynth \
    timidity \
    && rm -rf /var/lib/apt/lists/*

# Establecer directorio de trabajo en el contenedor
WORKDIR /app

# Copiar e instalar las dependencias de Python
COPY requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt

# Copiar todo el código fuente del proyecto al contenedor
COPY . .

# Puerto por defecto que Render asigna
ENV PORT=8000
EXPOSE 8000

# Comando para iniciar el servidor
CMD ["python", "server.py"]