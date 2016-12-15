package cz.uhk.pro2.flappy.game.tiles;

import java.awt.Graphics;
import java.awt.Image;

public class BonusTile extends AbstractTile {
public BonusTile(Image image){
	
	super(image);
}
public void draw(Graphics g, int x, int y) {
	
	g.drawImage(image, x, y, null);
}

}