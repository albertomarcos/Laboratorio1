package es.upm.dit.adsw.pacman1;

/**
 * Singleton. Mantiene los elementos del juego.
 *
 * @author jose a. manas
 * @version 14.11.2014
 */
public class Juego {
    /**
     * Nombre del juego.
     */
    public static final String TITULO = "Pacman I (19.11.2014)";

    private static Juego instance = new Juego();

    /**
     * Constructor privado: inaccesible.
     * Nadie más puede crear objetos de este tipo.
     */
    private Juego() {
    }

    /**
     * Getter.
     *
     * @return el objeto de tipo Juego.
     */
    public static Juego getInstance() {
        return instance;
    }

    /**
     * Dimensiones del cuadrado de juego.
     */
    public static final int N = 15;

    private View view;
    private Terreno terreno;

    /**
     * Setter.
     */
    public void setView(View view) {
        this.view = view;
    }

    /**
     * Para empezar un nuevo juego.
     * Crea un terreno y lo carga en la GUI.
     */
    public void start() {
        terreno = new Terreno(N);
        if (view != null)
            view.setTerreno(terreno);
    }

    /**
     * Para acabar una partida.
     * Para los moviles que haya y vuelve a empezar.
     */
    public void restart() {
        if (terreno != null)
            terreno.paraMoviles();
        start();
    }

    /**
     * Actualiza la pantalla.
     */
    public void pintar() {
        if (view != null)
            view.pintame();
    }

    /**
     * Muestra un mensaje en una ventana emergente.
     *
     * @param texto
     */
    public void mensaje(String texto) {
        if (view != null)
            view.muestra(texto);
    }

    /**
     * Coloca y arranca un nuevo movil en el terreno.
     *
     * @param casilla donde poner el nuevo movil.
     * @param id      tipo de movil.
     */
    public void pon(Casilla casilla, Integer id) {
        switch (id) {
            case 0: {
                Estatua estatua = new Estatua();
                terreno.put(casilla, estatua);
                break;
            }
        }
        pintar();
    }

    /**
     * Para arrancar.
     */
    public static void main(String[] args) {
        Juego juego = getInstance();
        GUI gui = new GUI();
        gui.registra(0, "Patito");
        juego.setView(gui);
        juego.start();
    }
}
