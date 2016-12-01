package cz.uhk.pro2.flappy.game;

import java.awt.Graphics;

/**
 * Reprezentuje herní objekt umisteny do matice
 * herni plochy.
 * @author pechami2
 *
 */
public interface Tile {
	/**
	 * Sirka a vyska dlazdice v pixelech - konstanta!
	 */
	static final int SIZE = 20;
	
	
	/**
	 * Kresli herni objekt na platno g.
	 * @param x x-ova souradnice v pixelech na obrazovce, kam se dlazdice vykresli¨
	 * @param y y-ova souradnice v pixelech na obrazovce, kam se dlazdice vykresli
	 * @param g
	 */
	void draw(Graphics g, int x, int y);
}
