
// Libreria comun
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

// Libreria JavaCV
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FFmpegFrameGrabber.Exception;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameConverter;
import org.bytedeco.javacv.Java2DFrameConverter;

public class Separator {
    File video;
    File audio;
    File videoMute;

    public Separator(File video) {
        this.video = video;

        try {
            separar();
        } catch (Exception e) {
            System.err.println("Error al separar video: " + e);
        }

    }

    private void separar() throws Exception {
        // Este objeto me permite transformar un video a bufferedImage
        Java2DFrameConverter conversor = new Java2DFrameConverter();

        FrameConverter conversorFrames = new FrameConverter<AudioInputStream>() {

            @Override
            public Frame convert(AudioInputStream f) {
                return null;
            }

            // Metodo para convertir un frame a audio
            @Override
            public AudioInputStream convert(Frame frame) {

                try {
                    AudioInputStream audio = AudioSystem.getAudioInputStream(video);

                    return audio;
                } catch (UnsupportedAudioFileException u) {
                    System.out.println("Archivo de audio no soportado: " + u);
                    return null;
                } catch (IOException e) {
                    System.out.println("Error al convertir a audio: " + e);
                    return null;
                }
            }

        };

        // Este objeto me permite obtener los frames del video
        FFmpegFrameGrabber graber = new FFmpegFrameGrabber(video);
        graber.start();

        // Objeto que me guarda el video
        Frame frameVideo = graber.grabFrame(false, true, true, true);
        Frame frameAudio = graber.grabFrame(true, false, true, false);

        AudioInputStream audioFinal = (AudioInputStream) conversorFrames.convert(frameAudio);
        try {
            AudioSystem.write(audioFinal, AudioFileFormat.Type.WAVE, new File("/assets/"));

        } catch (IOException e) {
            System.out.println("Error al escribir archivo de audio");
        }

    }
}
