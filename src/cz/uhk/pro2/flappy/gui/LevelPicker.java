package cz.uhk.pro2.flappy.gui;

import javax.swing.*;

import cz.uhk.pro2.flappy.game.GameBoard;
import cz.uhk.pro2.flappy.service.CsvGameBoardLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Kriz on 14. 12. 2016.
 */
public class LevelPicker {

    class LevelDescription {
        String title;
        String url;

        public LevelDescription(String title, String url) {
            this.title = title;
            this.url = url;
        }

        @Override
        public String toString() {
            return title;
        }
    }
String levelListUrl;
public LevelPicker(){
	this( "http://edu.uhk.cz/~krizpa1/doku.php?id=flappy_bird_-_levely&do=export_raw");
	
}
    public LevelPicker(String levelListUrl) {
	this.levelListUrl = levelListUrl;
}
	public GameBoard pickAndLoadLevel() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new URL(levelListUrl).openStream(),"UTF-8"));) {

            List<LevelDescription> lines = new ArrayList<>();
            String line = null;
            Pattern p = Pattern.compile("^(.+) (.+?)$"); // rozdelit string podle posledni mezery
            while ((line = reader.readLine()) != null) {
                Matcher m = p.matcher(line);
                if (m.matches()) {
                    LevelDescription ld = new LevelDescription(m.group(1), m.group(2));
                    lines.add(ld);
                }
            }

            LevelDescription[] possibilities = lines.toArray(new LevelDescription[lines.size()]);
            LevelDescription s = (LevelDescription)JOptionPane.showInputDialog(
                    null,
                    "Vyberte level:",
                    "Vyber",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    possibilities,
                    null);
            CsvGameBoardLoader loader = new CsvGameBoardLoader(new URL(s.url).openStream());

            return loader.loadLevel(); //s.url;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
//    public static void main(String[] args) {
//		SwingUtilities.invokeLater(() -> {
//
//			LevelPicker w = new LevelPicker();
//			w.setVisible(true);
//
//		});
//    }

}
