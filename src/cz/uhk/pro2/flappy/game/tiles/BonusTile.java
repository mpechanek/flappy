package cz.uhk.pro2.flappy.game.tiles;

import java.awt.Graphics;
import java.awt.Image;

import cz.uhk.pro2.flappy.game.Tile;

public class BonusTile extends AbstractTile {
	private Tile emptyTile;
	private boolean on = true;
	
public BonusTile(Image image,Tile emptyTile){
	
	super(image);
	this.emptyTile = emptyTile;
}
@Override
public void draw(Graphics g, int x, int y) {
	if (on) {
		super.draw(g, x, y);
	} else {
		emptyTile.draw(g, x, y);
	}
}

public void setOn(boolean value) {
	on = value;
}
}
