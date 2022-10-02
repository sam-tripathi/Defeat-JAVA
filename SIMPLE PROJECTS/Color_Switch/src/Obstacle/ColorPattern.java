package Obstacle;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

public class ColorPattern {
    private final Color[] colors = new Color[4];

    public ColorPattern() {
        colors[0] = Color.rgb(141,19,250);
        colors[1] = Color.rgb(253,0,128);
        colors[2] = Color.rgb(54,225,243);
        colors[3] = Color.rgb(247,222,15);

    }

    public ArrayList<Color> assignrandom(int requiredColors) {
        Random r = new Random();
        ArrayList<Color> assignColor = new ArrayList<>(requiredColors);
        int iterator = 0;

        while (iterator < requiredColors) {
            int index = r.nextInt(colors.length - 1);
            Color currect = colors[index];
            if (! assignColor.contains(currect)) {
                assignColor.add(currect);
                iterator++;
            }
        }
        return assignColor;
    }

    public Color giveNextColor (Color currentColor) {

        while (true) {
            Random r = new Random();
            int i = r.nextInt(colors.length );
            if (! colors[i].equals(currentColor)) {
                return colors[i];
            }
        }
    }





}
