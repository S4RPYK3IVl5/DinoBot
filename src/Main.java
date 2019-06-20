import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Main {

    private static Robot robot;
    private static Color white = new Color(247, 247, 247);

    public static void main(String[] args) throws AWTException {

        Coordinates restartButton = new Coordinates(481, 408);
        Coordinates getPixelCoordinates = new Coordinates(280, 425);
        robot = new Robot();

        clickRestartButton(restartButton);

        while(true)
            conditionJump(getPixelCoordinates);
    }

    private static void conditionJump(Coordinates getPixelCoordinates) {
        if (!robot.getPixelColor(getPixelCoordinates.getX(), getPixelCoordinates.getY())
                .equals(white))
            robot.keyPress(KeyEvent.VK_SPACE);
    }

    private static void clickRestartButton(Coordinates restartButton){
        robot.mouseMove(restartButton.getX(), restartButton.getY());

        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
}
