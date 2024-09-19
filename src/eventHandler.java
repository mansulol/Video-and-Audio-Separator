
// Libreria comun
// Libreria AWT
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

// Libreria Swing
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class eventHandler implements MouseListener {
    File archivo;
    File archivoVideo;
    File archivoAudio;
    VideoSeparator videoSeparator;

    public eventHandler(VideoSeparator v) {
        this.videoSeparator = v;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == videoSeparator.contenedorVideo) {

            JFileChooser elegirArchivo = new JFileChooser();
            // Metodo para solo poder seleccionar archivos
            elegirArchivo.setFileSelectionMode(JFileChooser.FILES_ONLY);

            // Filtro para solo administir videos
            FileNameExtensionFilter filtroVideo = new FileNameExtensionFilter("Videos", "mp4", "mov");
            elegirArchivo.setFileFilter(filtroVideo);

            if (JFileChooser.APPROVE_OPTION == elegirArchivo.showOpenDialog(null)) {
                archivo = elegirArchivo.getSelectedFile();

                // String nombre = archivo.getName();
                // int tamanioBytes = (int) archivo.length();
                // double tamanioMB = tamanioBytes / 1024;

                videoSeparator.addSecondaryComponents();

                Separator separator = new Separator(archivo);

                /*
                 * videoSeparator.textoVideoNombre.setText("Nombre: " + nombre + " (no sound)");
                 * videoSeparator.textoVideoTamaño
                 * .setText("Tamaño: " + String.format("%2.2f MB", tamanioMB / 1000));
                 */
            }

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
