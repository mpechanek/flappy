package cz.uhk.pro2.flappy.game.tiles;

import java.awt.Graphics;
import java.awt.Image;

import cz.uhk.pro2.flappy.game.Tile;

public class BonusTile extends AbstractTile {
	
	Tile emptyTile;
	
public BonusTile(Image image,Tile emptyTile){
	
	super(image);
	this.emptyTile = emptyTile;
}
public void draw(Graphics g, int x, int y) {
	
	emptyTile.draw(g, x, y);
}

}