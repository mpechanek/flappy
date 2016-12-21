package cz.uhk.pro2.flappy.game;

import java.awt.Graphics;
import java.awt.Image;

import cz.uhk.pro2.flappy.game.tiles.BonusTile;
import cz.uhk.pro2.flappy.game.tiles.WallTile;
import cz.uhk.pro2.flappy.game.Tile;

/**
 * 
 * @author pechami2
 *
 */
public class GameBoard implements TickAware {
	Tile[][] tiles;
	int shiftX;
	int viewportWidth = 200;// TODO
	Bird bird;
	boolean gameOver = false;
	

	public GameBoard(Tile[][] tiles, Image imageOfTheBird) {
		this.tiles = tiles;
		bird = new Bird(viewportWidth / 2, tiles.length * Tile.SIZE / 2, imageOfTheBird);

	}

	/**
	 * Kresli cely herni svet(zdi,bonusy,ptaka) na platno g. a kontroluje, zda
	 * nedoslo ke kolizi ptaka s dlazdici.
	 * 
	 * @param g
	 */
	public void drawAndTestCollisions(Graphics g) {
		// spocitame prvni j-index bunky,kterou ma smysl kreslit(je videt ve
		// wiewportu, tj. na obrazovce)
		int minJ = shiftX / Tile.SIZE;
		// +2 protoze celociselne delime jak shift X tak viewportSize, ale
		// chceme "zaokrouhlit" nahoru
		int maxJ = minJ + viewportWidth / Tile.SIZE + 2;

		for (int i = 0; i < tiles.length; i++) {
			// chceme, aby se svet "tocil" dokola,
			// j2 se pohybuje 0.... pocet sloupcu -1
			for (int j = minJ; j < maxJ; j++) {
				int j2 = j % tiles[i].length;

				Tile t = tiles[i][j2];
				
				if (t != null){// je na souradnicich i,j dlazdice??
					int screenX = j * Tile.SIZE - shiftX;
					int screenY = i * Tile.SIZE;
					// nakreslime dlazdici
					t.draw(g, screenX, screenY);
					
					if(t instanceof BonusTile){
						if (bird.collidesWithRectangle(screenX, screenY, Tile.SIZE, Tile.SIZE)) {
							((BonusTile) t).setOn(false);

						}
						if (shiftX % 200 == 0) {
							((BonusTile) t).setOn(true);
						}
						
						
						
					}
					// otestujeme moznou kolizi dlazdice s ptakem
					if (t instanceof WallTile){
						//dlazdice je typu zed
					if (bird.collidesWithRectangle(screenX, screenY, Tile.SIZE, Tile.SIZE)){
						//doslo ke kolizi ptaka s dlazdici
						System.out.println("Kolize");
						 gameOver = true;
					}
					}
				}

			}

		}
		// TODO ptak
		bird.draw(g);
	}

	@Override
	public void tick(long tickSinceStart) {
		if(!gameOver){
		// s kazdym tickem ve hre posuneme hru o jeden pixel
		// tj. pocet ticku a pixelu posunu se rovnaji
		shiftX = (int) tickSinceStart;
		// dame vedet jeste ptakovi, ze hodiny tickly
		bird.tick(tickSinceStart);
		}
	}

	public void kickTheBird() {
		bird.kick();

	}

	public int getHeightPix() {
		return tiles.length * Tile.SIZE;

	}
}
