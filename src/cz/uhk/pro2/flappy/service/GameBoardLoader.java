package cz.uhk.pro2.flappy.service;

import cz.uhk.pro2.flappy.game.GameBoard;

/**
 * Spolecne rozhrani pro tridy umoznujici nacitat level.
 * @author pechami2
 *
 */
public interface GameBoardLoader {
	GameBoard loadLevel();
	/**
	 * Nacte level(herni plochu).
	 */

}
