FROM python:3.10-slim

# Instalar LilyPond, sintetizadores, bancos de sonido MIDI y ffmpeg para audio
RUN apt-get update && apt-get install -y \
    lilypond \
    fluidsynth \
    fluid-soundfont-gm \
    timidity \
    ffmpeg \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /app

COPY requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt

COPY . .

ENV PORT=8000
EXPOSE 8000

CMD ["python", "server.py"]