import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class Settings {
    // Tamaños
    static final Dimension TAMAÑO_FRAME = new Dimension(600, 400);
    static final Dimension TAMAÑO_CONTENIDO_VIDEO = new Dimension(500, 300);
    static final Dimension TAMAÑO_CONTENIDO_DESCARGADO = new Dimension(436, 216);
    static final Dimension TAMAÑO_CONTENEDOR_OPCION = new Dimension(162, 132);
    static final Dimension TAMAÑO_LOGO = new Dimension(68, 78);
    static final Dimension TAMAÑO_BTN_DESCARGA = new Dimension(162, 43);
    static final Dimension TAMAÑO_TEXTO_DESCARGA = new Dimension(230, 30);

    // Fuentes
    static final Font FUENTE_PREDETERMINADO = new Font("Inter", Font.PLAIN, 12);
    static final Font FUENTE_TITULO = new Font("Inter", Font.PLAIN, 15);
    static final Font FUENTE_DESCARGADO = new Font("Inter", Font.BOLD, 20);

    // Colores
    static final Color COLOR_PRIMARIO = Color.decode("#FF6B6B");
    static final Color COLOR_SECUNDARIO = Color.decode("#EEA6A6");
    static final Color COLOR_TERCIARIO = Color.decode("#FFC5C5");

    static final Color COLOR_DEFAULT_WHITE = Color.decode("#FFFFFF");
    static final Color COLOR_DEFAULT_BLACK = Color.decode("#000000");

    Settings() {

    }
}
