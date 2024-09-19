
// Libreria comun
// Libreria AWT
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.InputStream;

// Libreria Imageiio
import javax.imageio.ImageIO;
// Libreria Swing
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VideoSeparator extends JFrame {
    JPanel contenedor;

    // Las objetos para la pantalla principal
    JPanel contenedorElegirVideo;
    JPanel contenedorVideo;

    JLabel labelImgEnlace;
    JLabel textoElegirVideo;
    JLabel labelArrastrarVideo;

    // Los objetos para la pantalla secundaria
    JPanel contenedorOpcionVideo;
    JPanel contenedorOpcionAudio;

    JLabel labelLogoVideo;
    JLabel labelLogoAudio;

    JButton btnDescargaVideo;
    JButton btnDescargaAudio;

    JLabel textoVideoNombre;
    JLabel textoVideoTamaño;

    JLabel textoAudioNombre;
    JLabel textoAudioTamaño;

    // Cargos los ajustes necesarios
    Settings settings = new Settings();

    eventHandler eventos = new eventHandler(this);

    public VideoSeparator() {
        setSize(settings.TAMAÑO_FRAME);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Video Separator");
        setIconImage(loadImages("assets/icono.png").getImage());

        // Contenedor principal
        contenedor = new JPanel();
        contenedor.setPreferredSize(settings.TAMAÑO_FRAME);
        contenedor.setBackground(settings.COLOR_TERCIARIO);
        contenedor.setLayout(null);
        add(contenedor);
        pack();

        // Añado los components necesarios al frame
        addPrincipalComponents();

        // Añado los componentes secundarios
        // addSecondaryComponents();

        // añado los componentes finales
        // addFinallyComponents();
    }

    public void addPrincipalComponents() {
        // El contenedor oscuro que guarda el boton de obtenedor link
        contenedorElegirVideo = new JPanel();
        contenedorElegirVideo.setBackground(settings.COLOR_SECUNDARIO);
        contenedorElegirVideo.setBounds(50, 45, settings.TAMAÑO_CONTENIDO_VIDEO.width,
                settings.TAMAÑO_CONTENIDO_VIDEO.height);
        contenedorElegirVideo.setLayout(null);
        contenedor.add(contenedorElegirVideo);

        // Contenedor de la imagen y el texto de elegir video
        contenedorVideo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(settings.COLOR_PRIMARIO);
                g.fillRoundRect(0, 0, 192, 46, 20, 20);
            }
        };
        contenedorVideo.setBounds(154, 121, 192, 46);
        contenedorVideo.setBackground(settings.COLOR_PRIMARIO);
        contenedorVideo.setLayout(null);
        contenedorVideo.addMouseListener(eventos);
        contenedorElegirVideo.add(contenedorVideo);

        // Imagen del enlace
        labelImgEnlace = new JLabel(loadImages("/assets/link.png", 26, 26));
        labelImgEnlace.setBounds(12, 10, 26, 26);
        contenedorVideo.add(labelImgEnlace);

        // Texto de elegir archivo
        textoElegirVideo = new JLabel("Elige un archivo");
        textoElegirVideo.setBounds(50, 15, 122, 15);
        textoElegirVideo.setForeground(settings.COLOR_DEFAULT_WHITE);
        textoElegirVideo.setFont(settings.FUENTE_TITULO);
        textoElegirVideo.setBackground(null);
        contenedorVideo.add(textoElegirVideo);

        // Texto de arrastrar video
        labelArrastrarVideo = new JLabel("o arrastra un archivo");
        labelArrastrarVideo.setBounds(190, 177, 162, 15);
        labelArrastrarVideo.setBackground(null);
        labelArrastrarVideo.setFont(settings.FUENTE_PREDETERMINADO);
        labelArrastrarVideo.setForeground(settings.COLOR_DEFAULT_BLACK);
        contenedorElegirVideo.add(labelArrastrarVideo);

        setVisible(true);
    }

    public void addSecondaryComponents() {
        contenedor.removeAll();
        contenedor.revalidate();
        contenedor.repaint();

        // Contenedor de la opcion de video
        contenedorOpcionVideo = new JPanel();
        contenedorOpcionVideo.setBackground(settings.COLOR_DEFAULT_WHITE);
        contenedorOpcionVideo.setBounds(77, 98, settings.TAMAÑO_CONTENEDOR_OPCION.width,
                settings.TAMAÑO_CONTENEDOR_OPCION.height);
        contenedorOpcionVideo.setLayout(new BorderLayout());
        contenedor.add(contenedorOpcionVideo);

        labelLogoVideo = new JLabel(loadImages("/assets/video.png"));
        labelLogoVideo.setPreferredSize(settings.TAMAÑO_LOGO);
        contenedorOpcionVideo.add(labelLogoVideo, BorderLayout.CENTER);

        btnDescargaVideo = new JButton(loadImages("assets/descarga.png"));
        btnDescargaVideo.setBounds(77, 236, settings.TAMAÑO_BTN_DESCARGA.width, settings.TAMAÑO_BTN_DESCARGA.height);
        btnDescargaVideo.setBackground(settings.COLOR_DEFAULT_WHITE);
        btnDescargaVideo.addMouseListener(eventos);
        contenedor.add(btnDescargaVideo);

        // Texto de caracteristicas del video
        textoVideoNombre = new JLabel("Procesando...");
        textoVideoNombre.setBounds(52, 294, settings.TAMAÑO_TEXTO_DESCARGA.width,
                settings.TAMAÑO_TEXTO_DESCARGA.height);
        textoVideoNombre.setBackground(null);
        textoVideoNombre.setFont(settings.FUENTE_PREDETERMINADO);
        contenedor.add(textoVideoNombre);

        textoVideoTamaño = new JLabel("Procesando...");
        textoVideoTamaño.setBounds(52, 312, settings.TAMAÑO_TEXTO_DESCARGA.width,
                settings.TAMAÑO_TEXTO_DESCARGA.height);
        textoVideoTamaño.setBackground(null);
        textoVideoTamaño.setFont(settings.FUENTE_PREDETERMINADO);
        contenedor.add(textoVideoTamaño);

        // Contenedor de la opcion de audio
        contenedorOpcionAudio = new JPanel();
        contenedorOpcionAudio.setBackground(settings.COLOR_DEFAULT_WHITE);
        contenedorOpcionAudio.setBounds(363, 98, settings.TAMAÑO_CONTENEDOR_OPCION.width,
                settings.TAMAÑO_CONTENEDOR_OPCION.height);
        contenedorOpcionAudio.setLayout(new BorderLayout());
        contenedor.add(contenedorOpcionAudio);

        labelLogoAudio = new JLabel(loadImages("/assets/audio.png"));
        labelLogoAudio.setPreferredSize(settings.TAMAÑO_LOGO);
        contenedorOpcionAudio.add(labelLogoAudio, BorderLayout.CENTER);

        btnDescargaAudio = new JButton(loadImages("assets/descarga.png"));
        btnDescargaAudio.setBounds(363, 236, settings.TAMAÑO_BTN_DESCARGA.width, settings.TAMAÑO_BTN_DESCARGA.height);
        btnDescargaAudio.setBackground(settings.COLOR_DEFAULT_WHITE);
        btnDescargaVideo.addMouseListener(eventos);
        contenedor.add(btnDescargaAudio);

        // Texto de caracteristicas del audio
        textoAudioNombre = new JLabel("Procesando...");
        textoAudioNombre.setBounds(346, 294, settings.TAMAÑO_TEXTO_DESCARGA.width,
                settings.TAMAÑO_TEXTO_DESCARGA.height);
        textoAudioNombre.setBackground(null);
        textoAudioNombre.setFont(settings.FUENTE_PREDETERMINADO);
        contenedor.add(textoAudioNombre);

        textoAudioTamaño = new JLabel("Procesando...");
        textoAudioTamaño.setBounds(346, 312, settings.TAMAÑO_TEXTO_DESCARGA.width,
                settings.TAMAÑO_TEXTO_DESCARGA.height);
        textoAudioTamaño.setForeground(settings.COLOR_DEFAULT_BLACK);
        textoAudioTamaño.setBackground(null);
        textoAudioTamaño.setFont(settings.FUENTE_PREDETERMINADO);
        contenedor.add(textoAudioTamaño);

        setVisible(true);
    }

    public void addFinallyComponents() {
        contenedor.removeAll();

        // El contenedor oscuro que guarda el boton de obtenedor link
        contenedorElegirVideo = new JPanel();
        contenedorElegirVideo.setBackground(settings.COLOR_SECUNDARIO);
        contenedorElegirVideo.setBounds(82, 92, settings.TAMAÑO_CONTENIDO_DESCARGADO.width,
                settings.TAMAÑO_CONTENIDO_DESCARGADO.height);
        contenedorElegirVideo.setLayout(null);
        contenedor.add(contenedorElegirVideo);

        // Contenedor de la imagen de descarga
        contenedorVideo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.setColor(settings.COLOR_PRIMARIO);
                g.fillRoundRect(0, 0, 94, 94, 200, 200);
                setBackground(null);
            }
        };
        contenedorVideo.setBounds(77, 61, 94, 94);
        contenedorVideo.setLayout(null);
        contenedorElegirVideo.add(contenedorVideo);

        // Imagen logo descargado
        labelImgEnlace = new JLabel(loadImages("/assets/check.png", 62, 62));
        labelImgEnlace.setBounds(16, 16, 62, 62);
        contenedorVideo.add(labelImgEnlace);

        // Texto de elegir archivo
        textoElegirVideo = new JLabel("Video Descargado");
        textoElegirVideo.setBounds(185, 96, 204, 36);
        textoElegirVideo.setForeground(settings.COLOR_DEFAULT_WHITE);
        textoElegirVideo.setFont(settings.FUENTE_DESCARGADO);
        textoElegirVideo.setBackground(null);
        contenedorElegirVideo.add(textoElegirVideo);

        setVisible(true);
    }

    private ImageIcon loadImages(String rutaImg) {
        JLabel imgContainer;
        BufferedImage bufferImg;
        ImageIcon img;

        try {
            InputStream input = this.getClass().getResourceAsStream(rutaImg);
            bufferImg = ImageIO.read(input);
            img = new ImageIcon(bufferImg);

            return img;

        } catch (Exception e) {
            System.err.println("Error: " + e);
            return null;
        }
    }

    private ImageIcon loadImages(String rutaImg, int ancho, int alto) {
        JLabel imgContainer;
        BufferedImage bufferImg;
        ImageIcon img;

        try {
            InputStream input = this.getClass().getResourceAsStream(rutaImg);
            bufferImg = ImageIO.read(input);
            img = new ImageIcon(bufferImg.getScaledInstance(alto, ancho, 0));

            return img;

        } catch (Exception e) {
            System.err.println("Error: " + e);
            return null;
        }
    }
}
