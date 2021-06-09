package scrapfile.main;

import java.util.ArrayList;
import java.util.List;

public class StopLight {
    private static Colors signalColor;

    private static List<Colors> colors;

    static {
        colors = new ArrayList<Colors>() {
        };
        colors.add(Colors.RED);
        colors.add(Colors.YELLOW);
        colors.add(Colors.GREEN);
        signalColor = colors.get(0);

    }

    public static void main(String[] args) {
        getSignalColor();
        changeSignal();
        getSignalColor();
        changeSignal();
        getSignalColor();
        changeSignal();
        getSignalColor();
        changeSignal();
    }

    public StopLight() {
    }

    public static Colors changeSignal() {
        Colors currentColor = signalColor;

        switch (currentColor) {
        case RED:
            currentColor = colors.get(2);
            break;
        case YELLOW:
            currentColor = colors.get(0);
            break;
        case GREEN:
            currentColor = colors.get(1);
            break;
        default:
            currentColor = colors.get(0);
        }
        signalColor = currentColor;
        return currentColor;
    }

    public static Colors getSignalColor() {
        System.out.println("Current Signal Color: " + signalColor);
        return signalColor;
    }

}
