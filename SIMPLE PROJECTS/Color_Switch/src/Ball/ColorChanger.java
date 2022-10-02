package Ball;

import Obstacle.ColorPattern;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.image.Image;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.awt.*;
import java.io.Serializable;

public class ColorChanger extends Dimension implements Serializable {
    private final static int x=775;
    private static final long serialVersionUID = 2L;
    private Ball playerBall;
    private int y;
    public ColorChanger(Ball playerBall, int y) {
        this.playerBall = playerBall;
        this.y = y;
    }

    public static  void changeColor () {
        ColorPattern pattern = new ColorPattern();
        Color nextColor = pattern.giveNextColor(Ball.giveCopy().getBallColor());
        Ball.giveCopy().setBallColor(nextColor);
    }

    public void init (Group group) {
        Circle colorChanger = new Circle();

        Image im = new Image("file:colorchange.png",false);
        colorChanger.setStyle("-fx-background-color: transparent;");
        colorChanger.setFill(new ImagePattern(im));
        colorChanger.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
        //Setting the pattern

        colorChanger.setLayoutX(x);
        colorChanger.setLayoutY(y);

        colorChanger.setRadius(35);
        group.getChildren().add(colorChanger);

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(16), new
                EventHandler<>() {
                    @Override
                    public void handle(final ActionEvent t) {
                        Shape intersect1 = Shape.intersect(playerBall.getCircle(), colorChanger);
                        if (intersect1.getBoundsInParent().getWidth() > 0) {
                            playerBall.changeColor();
                            colorChanger.setVisible(false);
                            colorChanger.setLayoutX(0);
                            colorChanger.setLayoutY(0);
                        }

                    }
                }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}