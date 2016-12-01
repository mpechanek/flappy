package cz.uhk.pro2.flappy.game;
/**
 * Rozhrani pro objekty, ktere potrebuji vedet, kolik casu(ticku) ubehlo od zacatku hry
 * @author pechami2
 *
 */
public interface TickAware {
	
	/**
	 * zmeni stav herni entity s ohledem na zmenu herniho casu
	 *  ticksSinceStart cas(pocet ticku) od zahajeni hry
	 * @param tickSinceStart
	 */
void tick(long tickSinceStart);


}
