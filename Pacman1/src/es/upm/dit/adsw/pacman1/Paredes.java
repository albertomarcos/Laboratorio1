package es.upm.dit.adsw.pacman1;

import java.util.HashSet;
import java.util.Set;

/**
 * Paredes entre casillas.
 *
 * @author jose a. manas
 * @version 17.11.2014
 */
public class Paredes {
    // conjunto de paredes actuales.
    private final Set<Pared> paredes = new HashSet<Pared>();

    /**
     * Pone una pared en el lado de la casilla en una cierta direccion.
     * No hace nada si algún argumento es null o si la casilla está al borde.
     *
     * @param c1 casilla.
     * @param d  direccion.
     */
    public void add(Casilla c1, Direccion d) {
        if (c1 == null || d == null)
            return;
        Casilla c2 = c1.siguiente(d);
        if (c2 == null)
            return;
        paredes.add(new Pared(c1, c2));
    }

    /**
     * Elimina una pared.
     *
     * @param pared pared que queremos eliminar.
     */
    public void remove(Pared pared) {
        if (pared == null)
            return;
        paredes.remove(pared);
    }

    /**
     * Elimina en el lado de la casilla en una cierta direccion.
     * No hace nada si algún argumento es null o si la casilla está al borde.
     *
     * @param c1 casilla.
     * @param d  direccion.
     */
    public void remove(Casilla c1, Direccion d) {
        if (c1 == null || d == null)
            return;
        Casilla c2 = c1.siguiente(d);
        if (c2 == null)
            return;
        remove(new Pared(c1, c2));
    }

    /**
     * Devuelve la pared en el borde de la casilla en una cierta direccion.
     * Devuelve null si algún argumento es null o si la casilla está al borde.
     *
     * @param c1 casilla.
     * @param d  direccion.
     * @return pared en la casilla y dirección indicadas.
     */
    public Pared get(Casilla c1, Direccion d) {
        if (c1 == null || d == null)
            return null;
        Casilla c2 = c1.siguiente(d);
        if (c2 == null)
            return null;
        for (Pared pared : paredes) {
            Casilla pc1 = pared.getCasilla1();
            Casilla pc2 = pared.getCasilla2();
            if (pc1.equals(c1) && pc2.equals(c2))
                return pared;
            if (pc1.equals(c2) && pc2.equals(c1))
                return pared;
        }
        return null;
    }

    /**
     * Dice si hay una pared en el borde de la casilla en una cierta direccion.
     * Devuelte TRUE si algún argumento es null o si la casilla está al borde.
     *
     * @param c1 casilla.
     * @param d  direccion.
     * @return true si hay una pared en la casilla y dirección indicadas.
     */
    public boolean hayPared(Casilla c1, Direccion d) {
        if (c1 == null || d == null)
            return true;
        Casilla c2 = c1.siguiente(d);
        if (c2 == null)
            return true;
        return paredes.contains(new Pared(c1, c2));
    }

    /**
     * @return numero de paredes registradas.
     */
    public int size() {
        return paredes.size();
    }

    public void reset() {
        paredes.clear();
    }
}
