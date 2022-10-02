package Ball;

import Dimention.Dimention;
//import SaveGame.SerialCode;
import animatefx.animation.BounceInUp;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.awt.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.TimerTask;

public class Ball extends Dimention implements Serializable {
    private Color ballColor;
    private static final long serialVersionUID = 2L;

    private final static int x=775;
    private static Ball instanceOfBall;
    private static Group group;
    private Circle circle;


    public Circle getCircle() {
        return circle;
    }

    private final Timeline upLoop,downLoop;

    public static Ball getInstance(Color ballColor, int y, Group group) {
        if (instanceOfBall == null) {
            instanceOfBall = new Ball(ballColor, y);
            Ball.group = group;
        }
        return instanceOfBall;
    }



    private final int stepForUp = 20;
    public static void setBall (Ball ball) {
        instanceOfBall = ball;
    }
    private int maxUp = stepForUp;// TODO: Change from 100 to 10
    private Ball(Color ballColor, int y) {
        this.ballColor = ballColor;
        this.downLoop = new Timeline(new KeyFrame(Duration.millis(16), new
                EventHandler<>() {
                    double dx = 0;
                    double dyUp = 6;// TODO:
                    double dyDown = -3;
                    double dy = dyDown;

                    @Override
                    public void handle(final ActionEvent t) {
                        circle.setLayoutX(circle.getLayoutX() + dx);
                        circle.setLayoutY(circle.getLayoutY() + dy);
                        if (circle.getLayoutY()  <= 780)
                            dy = dyUp;

                        else {
                            dy = 0;
                        }

                        setY((int)circle.getLayoutY());
                    }
                }));

        downLoop.setCycleCount(Timeline.INDEFINITE);
        downLoop.play();

        this.upLoop = new Timeline(new KeyFrame(Duration.millis(16), new
                EventHandler<>() {
                    double dx = 0;
                    double dyUp = 6;
                    double dyDown = -3;
                    double dy = dyDown;

                    @Override
                    public void handle(final ActionEvent t) {
                        circle.setLayoutX(circle.getLayoutX() + dx);
                        circle.setLayoutY(circle.getLayoutY() + dy);
                        if (circle.getLayoutY() >= 10 && maxUp > 0) {
                            dy = dyDown;
                            maxUp--;
                        }
                        else {
                            dy=0;
                        }
                        setY((int)circle.getLayoutY());

                    }
                }));
        upLoop.setCycleCount(Timeline.INDEFINITE);

        this.y = y;
    }

    public Color getBallColor() {
        return ballColor;
    }

    public void setBallColor(Color ballColor) {
        this.ballColor = ballColor;
        circle.setFill(ballColor);
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return x == ball.x &&
                y == ball.y &&
                ballColor.equals(ball.ballColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballColor, x, y);
    }

    @Override
    public String toString() {
        return "Ball{" +
                "ballColor=" + ballColor +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public void changeColor () {
        // TODO: Change color randomly
        ColorChanger.changeColor();

    }
    private long slavedMoved = 0;
    public long getSlavedMoved () {
        return slavedMoved;
    }
    private Timeline masterThread;
    public void init (Group slaveGroup) {
        circle = new Circle();
       circle.relocate(x,y);

        circle.setRadius(18);
        circle.setFill(ballColor);

        group.getChildren().addAll(circle);
        masterThread = new Timeline(new KeyFrame(Duration.millis(20), new
                EventHandler<>() {

                    @Override
                    public void handle(final ActionEvent t) {

                        String up = upLoop.getStatus().toString();
                        String down = downLoop.getStatus().toString();

                        System.out.println(up + " " + down);

                        if (up.equals("RUNNING") && !down.equals("RUNNING")) {
                            slaveGroup.setLayoutY(slaveGroup.getLayoutY() + 3);
                            slavedMoved+=3;
                        }

                        if (onPause) {
                            upLoop.pause();
                            downLoop.pause();
                        }


                        else if (up.equals("PAUSED") && down.equals("PAUSED") ) {
                            downLoop.play();
                        }


                        else if (up.equals("RUNNING") && down.equals("RUNNING")) {
                            downLoop.pause();
                        }

                        else if (!up.equals("RUNNING") && ! down.equals("RUNNING")) {
                            maxUp = 0;
                            downLoop.play();
                        }

                        else if (maxUp <= 0) {
                            if (up.equals("RUNNING")) {
                                upLoop.pause();
                            }
                            if (down.equals("STOPPED") || down.equals("PAUSED")) {
                                downLoop.play();
                            }
                        }

                        else if (circle.getLayoutY() <= 10) {
                            if (up.equals("RUNNING")) {
                                upLoop.pause();
                            }
                            if (down.equals("STOPPED") || down.equals("PAUSED")) {
                                downLoop.play();
                            }
                        }
                        else {
                            if (down.equals("RUNNING")) {
                                downLoop.pause();
                            }
                        }



                    }



                }));
        masterThread.setCycleCount(Timeline.INDEFINITE);
        masterThread.play();




    }
    private final int transition = 3500000;
    private volatile boolean isMovingUp = false;


    public static void newGame () {
        stopBall = false;
    }
    private int jumpHight;
    public void jump () {

        if (stopBall) {
            return;
        }
        upLoop.pause();
        maxUp = stepForUp;// TODO: Change from 100 to 10
        upLoop.play();

    }
    private static boolean stopBall = false;
    public static void stopBall () {
        stopBall = true;
        instanceOfBall.upLoop.pause();
        instanceOfBall.downLoop.pause();
//        instanceOfBall.masterThread.stop();
    }
    public static void pauseAtGameOver () {
        stopBall=true;
    }
    public static void resumeAtGameOver () {
        stopBall = false;
    }
    public static void resumeBall(){
        stopBall=false;
        instanceOfBall.upLoop.play();
        instanceOfBall.downLoop.play();
    }

    public static void destroyBall () {
        if (instanceOfBall != null) {
            instanceOfBall.upLoop.stop();
            instanceOfBall.downLoop.stop();
            instanceOfBall = null;
        }
    }

//    private  void changeColor(){
//        ColorChanger changer = new ColorChanger(instanceOfBall);
//        changer.changeColor();
//    }

    public static Ball giveCopy () {
        return instanceOfBall;
    }
    boolean onPause;
    public void pause() {
        onPause = true;
    }
    public void resume () {
        onPause = false;
    }
}
