package Obstacle;

import Activity.HomeActivity.HomeActivity;
import Ball.Ball;
import Dimention.Dimention;
import SaveGame.Score;
import animatefx.animation.FadeIn;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.*;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import sample.Controller;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Obstacle extends  Dimention  implements Serializable {
    private Shape2D shape2D;
//    private int size;
//    private final int xCoor = 0;
//    private int yCoor = 0;
private static final long serialVersionUID = 2L;

    public static void updateList (ArrayList<Obstacle> obstacleArrayList ) {
        Obstacle.obstacleArrayList = obstacleArrayList;
    }

    private ColorPattern pattern;
    private static ArrayList<Obstacle> obstacleArrayList = new ArrayList<Obstacle>();
    private Obstacle(Group group,int y) {
//        this.shape2D = shape2D;
////        this.size = size;
////        this.yCoor = yCoor;
//        this.radius = 0;
        this.y = y;//400
        this.x = Ball.giveCopy().getX();;//center
//        this.pattern = pattern;

        creatObstacle(group,150,1);


    }



    public static Obstacle getInstance(Group group,int y) {
        Obstacle obstacle = new Obstacle(group,y);
        obstacleArrayList.add(obstacle);
        return obstacle;
    }

    public Shape2D getShape() {
        return shape2D;
    }

    public void setShape(Shape2D shape2D) {
        this.shape2D = shape2D;
    }

    public int getSize() {
        return radius;
    }

    public void setSize(int size) {
        this.radius = size;
    }

    public int getxCoor() {
        return x;
    }

    public int getyCoor() {
        return y;
    }

    public void setyCoor(int yCoor) {
        this.y = yCoor;
    }

    public ColorPattern getPattern() {
        return pattern;
    }

    public void setPattern(ColorPattern pattern) {
        this.pattern = pattern;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Obstacle obstacle = (Obstacle) o;
        return Objects.equals(shape2D, obstacle.shape2D) &&
                Objects.equals(pattern, obstacle.pattern);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shape2D, pattern);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void rotate () {
        //TODO:
    }

    public static void createStars () {

    }

    public static ArrayList<Obstacle> giveCopy () {
        return obstacleArrayList;
    }

    private void creatObstacle (Group group,double R,double rotate) {
//        plusObs(group);
        int Cx,Cy;

        Cx = getX();
        Cy = y;

        Arc arc = new Arc();

        arc.setCenterX(Cx);
        arc.setCenterY(Cy);
        arc.setRadiusX(R);
        arc.setRadiusY(R);
        arc.setStartAngle(0.0f);
        arc.setLength(90.0f);

        arc.setType(ArcType.ROUND);
//        group.getChildren().add(arc);

        Arc arc1 = new Arc();
        arc1.setCenterX(Ball.giveCopy().getX());
        arc1.setCenterY(Cy);
        arc1.setRadiusX(R);
        arc1.setRadiusY(R);
        arc1.setStartAngle(90.0f);
        arc1.setLength(90.0f);
//       arc1.setRotate(-90);
        arc1.setType(ArcType.ROUND);

//        group.getChildren().add(arc1);

        Arc arc2 = new Arc();
        arc2.setCenterX(Ball.giveCopy().getX());
        arc2.setCenterY(Cy);
        arc2.setRadiusX(R);
        arc2.setRadiusY(R);
        arc2.setStartAngle(180.0f);
        arc2.setLength(90.0f);
//        arc2.setRotate(-180);
        arc2.setType(ArcType.ROUND);

//        group.getChildren().add(arc2);

        Arc arc3 = new Arc();
        arc3.setCenterX(Ball.giveCopy().getX());
        arc3.setCenterY(Cy);
        arc3.setRadiusX(R);
        arc3.setRadiusY(R);
        arc3.setStartAngle(270.0f);
        arc3.setLength(90.0f);
        arc3.setType(ArcType.ROUND);
//        group.getChildren().add(arc3);

//        System.out.println(arc.getLayoutX() + " ");

        Circle del=new Circle();
        del.setCenterY(Cy);
        del.setCenterX(Ball.giveCopy().getX());
        del.setRadius(R-30);

//        Circle star = new Circle();
//        star.setRadius(50);
////        javafx.scene.image.Image im = new Image("file:star.png",false);
//        star.setCenterX(Ball.giveCopy().getX());
//        star.setCenterY(Cy);
//        star.setFill(Color.RED);
////        star.setFill(new ImagePattern(im));
////        star.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
//
//        group.getChildren().add(star);

        javafx.scene.shape.Shape shape= javafx.scene.shape.Shape.subtract(arc, javafx.scene.shape.Shape.intersect(arc,del));
//        shape.setFill(Paint.valueOf("FF0080"));
        shape.setFill(javafx.scene.paint.Color.rgb(141,19,250));
        javafx.scene.shape.Shape shape1= javafx.scene.shape.Shape.subtract(arc1, javafx.scene.shape.Shape.intersect(arc1,del));
        shape1.setFill(javafx.scene.paint.Color.rgb(247,222,15));
        javafx.scene.shape.Shape shape2= javafx.scene.shape.Shape.subtract(arc2, javafx.scene.shape.Shape.intersect(arc2,del));
        shape2.setFill(javafx.scene.paint.Color.rgb(253,0,128));
        javafx.scene.shape.Shape shape3= javafx.scene.shape.Shape.subtract(arc3, Shape.intersect(arc3,del));
        shape3.setFill(Color.rgb(54,225,243));



        Rotate r1 = new Rotate();
        r1.setPivotX(Ball.giveCopy().getX());
        r1.setPivotY(Cy);


        shape1.getTransforms().add(r1);
        shape2.getTransforms().add(r1);
        shape3.getTransforms().add(r1);
        shape.getTransforms().add(r1);

        group.getChildren().addAll(shape);
        group.getChildren().addAll(shape1);
        group.getChildren().addAll(shape2);
        group.getChildren().addAll(shape3);

        RotateThread(r1,shape,shape1,shape2,shape3,Cy,group,rotate);


    }
    public void infcreater(Group group,double R,double rotate,int x,int y,int Cx,int Cy){

    }
    public void createObstacle (Group group,double R,double rotate,int y,int x) {
//        plusObs(group);
        int Cx,Cy;

//        Cx = getX();
        Cx = x;
        Cy = y;

        Arc arc = new Arc();

        arc.setCenterX(Cx);
        arc.setCenterY(Cy);
        arc.setRadiusX(R);
        arc.setRadiusY(R);
        arc.setStartAngle(0.0f);
        arc.setLength(90.0f);

        arc.setType(ArcType.ROUND);
//        group.getChildren().add(arc);

        Arc arc1 = new Arc();
        arc1.setCenterX(Ball.giveCopy().getX());
        arc1.setCenterY(Cy);
        arc1.setRadiusX(R);
        arc1.setRadiusY(R);
        arc1.setStartAngle(90.0f);
        arc1.setLength(90.0f);
//       arc1.setRotate(-90);
        arc1.setType(ArcType.ROUND);

//        group.getChildren().add(arc1);

        Arc arc2 = new Arc();
        arc2.setCenterX(Ball.giveCopy().getX());
        arc2.setCenterY(Cy);
        arc2.setRadiusX(R);
        arc2.setRadiusY(R);
        arc2.setStartAngle(180.0f);
        arc2.setLength(90.0f);
//        arc2.setRotate(-180);
        arc2.setType(ArcType.ROUND);

//        group.getChildren().add(arc2);

        Arc arc3 = new Arc();
        arc3.setCenterX(Ball.giveCopy().getX());
        arc3.setCenterY(Cy);
        arc3.setRadiusX(R);
        arc3.setRadiusY(R);
        arc3.setStartAngle(270.0f);
        arc3.setLength(90.0f);
        arc3.setType(ArcType.ROUND);
//        group.getChildren().add(arc3);

//        System.out.println(arc.getLayoutX() + " ");

        Circle del=new Circle();
        del.setCenterY(Cy);
        del.setCenterX(Ball.giveCopy().getX());
        del.setRadius(R-30);
//
//        Circle star = new Circle();
//        star.setRadius(50);
////        javafx.scene.image.Image im = new Image("file:star.png",false);
//        star.setCenterX(Ball.giveCopy().getX());
//        star.setCenterY(Cy);
//        star.setFill(Color.RED);
////        star.setFill(new ImagePattern(im));
////        star.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
//
//        group.getChildren().add(star);

        javafx.scene.shape.Shape shape= javafx.scene.shape.Shape.subtract(arc, javafx.scene.shape.Shape.intersect(arc,del));
//        shape.setFill(Paint.valueOf("FF0080"));
        shape.setFill(javafx.scene.paint.Color.rgb(141,19,250));
        javafx.scene.shape.Shape shape1= javafx.scene.shape.Shape.subtract(arc1, javafx.scene.shape.Shape.intersect(arc1,del));
        shape1.setFill(javafx.scene.paint.Color.rgb(247,222,15));
        javafx.scene.shape.Shape shape2= javafx.scene.shape.Shape.subtract(arc2, javafx.scene.shape.Shape.intersect(arc2,del));
        shape2.setFill(javafx.scene.paint.Color.rgb(253,0,128));
        javafx.scene.shape.Shape shape3= javafx.scene.shape.Shape.subtract(arc3, Shape.intersect(arc3,del));
        shape3.setFill(Color.rgb(54,225,243));



        Rotate r1 = new Rotate();
        r1.setPivotX(Ball.giveCopy().getX());
        r1.setPivotY(Cy);


        shape1.getTransforms().add(r1);
        shape2.getTransforms().add(r1);
        shape3.getTransforms().add(r1);
        shape.getTransforms().add(r1);

        group.getChildren().addAll(shape);
        group.getChildren().addAll(shape1);
        group.getChildren().addAll(shape2);
        group.getChildren().addAll(shape3);

        RotateThread(r1,shape,shape1,shape2,shape3,Cy,group,rotate);


    }
    public void doubleCircle(Group group,double R,double rotate,int y,int x){
        Group ek_ka_double=new Group();
        int Cx,Cy;

//        Cx = getX();
        Cx = x;
        Cy = y;
        Arc arc = new Arc();

        arc.setCenterX(Cx);
        arc.setCenterY(Cy);
        arc.setRadiusX(R);
        arc.setRadiusY(R);
        arc.setStartAngle(0.0f);
        arc.setLength(90.0f);

        arc.setType(ArcType.ROUND);
//        group.getChildren().add(arc);

        Arc arc1 = new Arc();
        arc1.setCenterX(Ball.giveCopy().getX());
        arc1.setCenterY(Cy);
        arc1.setRadiusX(R);
        arc1.setRadiusY(R);
        arc1.setStartAngle(90.0f);
        arc1.setLength(90.0f);
//       arc1.setRotate(-90);
        arc1.setType(ArcType.ROUND);

//        group.getChildren().add(arc1);

        Arc arc2 = new Arc();
        arc2.setCenterX(Ball.giveCopy().getX());
        arc2.setCenterY(Cy);
        arc2.setRadiusX(R);
        arc2.setRadiusY(R);
        arc2.setStartAngle(180.0f);
        arc2.setLength(90.0f);
//        arc2.setRotate(-180);
        arc2.setType(ArcType.ROUND);

//        group.getChildren().add(arc2);

        Arc arc3 = new Arc();
        arc3.setCenterX(Ball.giveCopy().getX());
        arc3.setCenterY(Cy);
        arc3.setRadiusX(R);
        arc3.setRadiusY(R);
        arc3.setStartAngle(270.0f);
        arc3.setLength(90.0f);
        arc3.setType(ArcType.ROUND);
//        group.getChildren().add(arc3);

//        System.out.println(arc.getLayoutX() + " ");

        Circle del=new Circle();
        del.setCenterY(Cy);
        del.setCenterX(Ball.giveCopy().getX());
        del.setRadius(R-30);


        javafx.scene.shape.Shape shape= javafx.scene.shape.Shape.subtract(arc, javafx.scene.shape.Shape.intersect(arc,del));
//        shape.setFill(Paint.valueOf("FF0080"));
        shape.setFill(javafx.scene.paint.Color.rgb(141,19,250));
        javafx.scene.shape.Shape shape1= javafx.scene.shape.Shape.subtract(arc1, javafx.scene.shape.Shape.intersect(arc1,del));
        shape1.setFill(javafx.scene.paint.Color.rgb(247,222,15));
        javafx.scene.shape.Shape shape2= javafx.scene.shape.Shape.subtract(arc2, javafx.scene.shape.Shape.intersect(arc2,del));
        shape2.setFill(javafx.scene.paint.Color.rgb(253,0,128));
        javafx.scene.shape.Shape shape3= javafx.scene.shape.Shape.subtract(arc3, Shape.intersect(arc3,del));
        shape3.setFill(Color.rgb(54,225,243));
        ek_ka_double.getChildren().addAll(shape,shape1,shape2,shape3);

        rotateGroup1(ek_ka_double,shape1,shape2,shape3,shape,rotate);

        group.getChildren().add(ek_ka_double);

    }
    public void infinityObs(Group group){
        int x=getX();

        createObstacle(group,200,1,-1150,x - 200);
        createObstacle(group,200,-1,-1150,x + 200);

    }

    public void finalWalaObs (Group group,int y1) {

        Group plus=new Group();

        int x=100;
        int y=100;

        Line L1 = new Line();
        L1.setStartX(x+20); L1.setEndX(x+200);
        L1.setStartY(y); L1.setEndY(y);
        L1.setStrokeWidth(20);
        L1.setStroke(Color.rgb(141,19,250));
        L1.setFill(Color.rgb(141,19,250));
        L1.setStrokeLineCap(StrokeLineCap.ROUND);
        plus.getChildren().add(L1);
        Line L2 = new Line();
        L2.setStartX(x); L2.setEndX(x);
        L2.setStartY(y+20); L2.setEndY(y+200);
        L2.setStrokeWidth(20);
        L2.setStroke(Color.rgb(247,222,15));
        L2.setFill(Color.rgb(247,222,15));
        L2.setStrokeLineCap(StrokeLineCap.ROUND);
        plus.getChildren().add(L2);

        Line L3 = new Line();
        L3.setStartX(x-20); L3.setEndX(x-200);
        L3.setStartY(y); L3.setEndY(y);
        L3.setStrokeWidth(20);
        L3.setStroke(Color.rgb(253,0,128));
        L3.setFill(Color.rgb(253,0,128));
        L3.setStrokeLineCap(StrokeLineCap.ROUND);
        plus.getChildren().add(L3);

        Line L4 = new Line();
        L4.setStartX(x); L4.setEndX(x);
        L4.setStartY(y-20); L4.setEndY(y-200);
        L4.setStrokeWidth(20);
        L4.setStroke(Color.rgb(54,225,243));
        L4.setFill(Color.rgb(54,225,243));
        L4.setStrokeLineCap(StrokeLineCap.ROUND);
        plus.getChildren().add(L4);
//        plus.relocate(Ball.giveCopy().getX()-210,-1700);
        plus.relocate(Ball.giveCopy().getX(),y1);
        group.getChildren().add(plus);
        rotateGroup(plus,L1,L2,L3,L4,-1);

        Group plus2 = new Group();
        Line L5 = new Line();
        L5.setStartX(x+20); L5.setEndX(x+200);
        L5.setStartY(y); L5.setEndY(y);
        L5.setStrokeWidth(20);
        L5.setStroke(Color.rgb(253,0,128));
        L5.setFill(Color.rgb(253,0,128));
        L5.setStrokeLineCap(StrokeLineCap.ROUND);
//        plus.getChildren().add(L5);

        Line L6 = new Line();
        L6.setStartX(x); L6.setEndX(x);
        L6.setStartY(y+20); L6.setEndY(y+200);
        L6.setStrokeWidth(20);
        L6.setStroke(Color.rgb(247,222,15));
        L6.setFill(Color.rgb(247,222,15));
        L6.setStrokeLineCap(StrokeLineCap.ROUND);
//        plus.getChildren().add(L6);

        Line L7 = new Line();
        L7.setStartX(x-20); L7.setEndX(x-200);
        L7.setStartY(y); L7.setEndY(y);
        L7.setStrokeWidth(20);
        L7.setStroke(Color.rgb(141,19,250));
        L7.setFill(Color.rgb(141,19,250));
        L7.setStrokeLineCap(StrokeLineCap.ROUND);
//        plus.getChildren().add(L7);

        Line L8 = new Line();
        L8.setStartX(x); L8.setEndX(x);
        L8.setStartY(y-20); L8.setEndY(y-200);
        L8.setStrokeWidth(20);
        L8.setStroke(Color.rgb(54,225,243));
        L8.setFill(Color.rgb(54,225,243));
        L8.setStrokeLineCap(StrokeLineCap.ROUND);
        plus.getChildren().add(L8);

        plus2.getChildren().addAll(L5,L6,L7,L8);
        plus2.relocate(Ball.giveCopy().getX()-420,y1);
        group.getChildren().add(plus2);
        rotateGroup(plus2,L5,L6,L7,L8,1);



        int Cx,Cy;
        int R = 500;
//        Cx = getX();
        Cx = Ball.giveCopy().getX();
        Cy = y1 + 300;

        Arc arc = new Arc();

        arc.setCenterX(Cx);
        arc.setCenterY(Cy);
        arc.setRadiusX(R);
        arc.setRadiusY(R);
        arc.setStartAngle(0.0f);
        arc.setLength(90.0f);

        arc.setType(ArcType.ROUND);
//        group.getChildren().add(arc);

        Arc arc1 = new Arc();
        arc1.setCenterX(Ball.giveCopy().getX());
        arc1.setCenterY(Cy);
        arc1.setRadiusX(R);
        arc1.setRadiusY(R);
        arc1.setStartAngle(90.0f);
        arc1.setLength(90.0f);
//       arc1.setRotate(-90);
        arc1.setType(ArcType.ROUND);

//        group.getChildren().add(arc1);

        Arc arc2 = new Arc();
        arc2.setCenterX(Ball.giveCopy().getX());
        arc2.setCenterY(Cy);
        arc2.setRadiusX(R);
        arc2.setRadiusY(R);
        arc2.setStartAngle(180.0f);
        arc2.setLength(90.0f);
//        arc2.setRotate(-180);
        arc2.setType(ArcType.ROUND);

//        group.getChildren().add(arc2);

        Arc arc3 = new Arc();
        arc3.setCenterX(Ball.giveCopy().getX());
        arc3.setCenterY(Cy);
        arc3.setRadiusX(R);
        arc3.setRadiusY(R);
        arc3.setStartAngle(270.0f);
        arc3.setLength(90.0f);
        arc3.setType(ArcType.ROUND);
//        group.getChildren().add(arc3);

//        System.out.println(arc.getLayoutX() + " ");

        Circle del=new Circle();
        del.setCenterY(Cy);
        del.setCenterX(Ball.giveCopy().getX());
        del.setRadius(R-30);

//
//        Circle star = new Circle();
//        star.setRadius(50);
////        javafx.scene.image.Image im = new Image("file:star.png",false);
//        star.setCenterX(Ball.giveCopy().getX());
//        star.setCenterY(Cy);
//        star.setFill(Color.RED);
////        star.setFill(new ImagePattern(im));
////        star.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
//
//        group.getChildren().add(star);

        javafx.scene.shape.Shape shape= javafx.scene.shape.Shape.subtract(arc, javafx.scene.shape.Shape.intersect(arc,del));
//        shape.setFill(Paint.valueOf("FF0080"));
        shape.setFill(javafx.scene.paint.Color.rgb(141,19,250));
        javafx.scene.shape.Shape shape1= javafx.scene.shape.Shape.subtract(arc1, javafx.scene.shape.Shape.intersect(arc1,del));
        shape1.setFill(javafx.scene.paint.Color.rgb(247,222,15));
        javafx.scene.shape.Shape shape2= javafx.scene.shape.Shape.subtract(arc2, javafx.scene.shape.Shape.intersect(arc2,del));
        shape2.setFill(javafx.scene.paint.Color.rgb(253,0,128));
        javafx.scene.shape.Shape shape3= javafx.scene.shape.Shape.subtract(arc3, Shape.intersect(arc3,del));
        shape3.setFill(Color.rgb(54,225,243));



        Rotate r1 = new Rotate();
        r1.setPivotX(Ball.giveCopy().getX());
        r1.setPivotY(Cy);


        shape1.getTransforms().add(r1);
        shape2.getTransforms().add(r1);
        shape3.getTransforms().add(r1);
        shape.getTransforms().add(r1);

        group.getChildren().addAll(shape);
        group.getChildren().addAll(shape1);
        group.getChildren().addAll(shape2);
        group.getChildren().addAll(shape3);

        RotateThread(r1,shape,shape1,shape2,shape3,Cy,group,1);



    }


    public void plusObs (Group group,int y1) {
        Group plus=new Group();
        int x=100;
        int y=100;
        Line L1 = new Line();
        L1.setStartX(x+20); L1.setEndX(x+200);
        L1.setStartY(y); L1.setEndY(y);
        L1.setStrokeWidth(20);
        L1.setStroke(Color.rgb(141,19,250));
        L1.setFill(Color.rgb(141,19,250));
        L1.setStrokeLineCap(StrokeLineCap.ROUND);
        plus.getChildren().add(L1);
        Line L2 = new Line();
        L2.setStartX(x); L2.setEndX(x);
        L2.setStartY(y+20); L2.setEndY(y+200);
        L2.setStrokeWidth(20);
        L2.setStroke(Color.rgb(247,222,15));
        L2.setFill(Color.rgb(247,222,15));
        L2.setStrokeLineCap(StrokeLineCap.ROUND);
        plus.getChildren().add(L2);

        Line L3 = new Line();
        L3.setStartX(x-20); L3.setEndX(x-200);
        L3.setStartY(y); L3.setEndY(y);
        L3.setStrokeWidth(20);
        L3.setStroke(Color.rgb(253,0,128));
        L3.setFill(Color.rgb(253,0,128));
        L3.setStrokeLineCap(StrokeLineCap.ROUND);
        plus.getChildren().add(L3);

        Line L4 = new Line();
        L4.setStartX(x); L4.setEndX(x);
        L4.setStartY(y-20); L4.setEndY(y-200);
        L4.setStrokeWidth(20);
        L4.setStroke(Color.rgb(54,225,243));
        L4.setFill(Color.rgb(54,225,243));
        L4.setStrokeLineCap(StrokeLineCap.ROUND);
        plus.getChildren().add(L4);
//        plus.relocate(Ball.giveCopy().getX()-210,-1700);
        plus.relocate(Ball.giveCopy().getX(),y1);//y=150
        group.getChildren().add(plus);
        rotateGroup(plus,L1,L2,L3,L4,-1);

        Group plus2 = new Group();
        Line L5 = new Line();
        L5.setStartX(x+20); L5.setEndX(x+200);
        L5.setStartY(y); L5.setEndY(y);
        L5.setStrokeWidth(20);
        L5.setStroke(Color.rgb(253,0,128));
        L5.setFill(Color.rgb(253,0,128));
        L5.setStrokeLineCap(StrokeLineCap.ROUND);
//        plus.getChildren().add(L5);

        Line L6 = new Line();
        L6.setStartX(x); L6.setEndX(x);
        L6.setStartY(y+20); L6.setEndY(y+200);
        L6.setStrokeWidth(20);
        L6.setStroke(Color.rgb(247,222,15));
        L6.setFill(Color.rgb(247,222,15));
        L6.setStrokeLineCap(StrokeLineCap.ROUND);
//        plus.getChildren().add(L6);

        Line L7 = new Line();
        L7.setStartX(x-20); L7.setEndX(x-200);
        L7.setStartY(y); L7.setEndY(y);
        L7.setStrokeWidth(20);
        L7.setStroke(Color.rgb(141,19,250));
        L7.setFill(Color.rgb(141,19,250));
        L7.setStrokeLineCap(StrokeLineCap.ROUND);
//        plus.getChildren().add(L7);

        Line L8 = new Line();
        L8.setStartX(x); L8.setEndX(x);
        L8.setStartY(y-20); L8.setEndY(y-200);
        L8.setStrokeWidth(20);
        L8.setStroke(Color.rgb(54,225,243));
        L8.setFill(Color.rgb(54,225,243));
        L8.setStrokeLineCap(StrokeLineCap.ROUND);
        plus.getChildren().add(L8);

        plus2.getChildren().addAll(L5,L6,L7,L8);
        plus2.relocate(Ball.giveCopy().getX()-420,y1);
        group.getChildren().add(plus2);
        rotateGroup(plus2,L5,L6,L7,L8,1);



    }


    public void singlePlus (Group group, int y1) {
        Group plus=new Group();
        int x=100;
        int y=100;
        Line L1 = new Line();
        L1.setStartX(x+20); L1.setEndX(x+200);
        L1.setStartY(y); L1.setEndY(y);
        L1.setStrokeWidth(20);
        L1.setStroke(Color.rgb(141,19,250));
        L1.setFill(Color.rgb(141,19,250));
        L1.setStrokeLineCap(StrokeLineCap.ROUND);
        plus.getChildren().add(L1);
        Line L2 = new Line();
        L2.setStartX(x); L2.setEndX(x);
        L2.setStartY(y+20); L2.setEndY(y+200);
        L2.setStrokeWidth(20);
        L2.setStroke(Color.rgb(247,222,15));
        L2.setFill(Color.rgb(247,222,15));
        L2.setStrokeLineCap(StrokeLineCap.ROUND);
        plus.getChildren().add(L2);

        Line L3 = new Line();
        L3.setStartX(x-20); L3.setEndX(x-200);
        L3.setStartY(y); L3.setEndY(y);
        L3.setStrokeWidth(20);
        L3.setStroke(Color.rgb(253,0,128));
        L3.setFill(Color.rgb(253,0,128));
        L3.setStrokeLineCap(StrokeLineCap.ROUND);
        plus.getChildren().add(L3);

        Line L4 = new Line();
        L4.setStartX(x); L4.setEndX(x);
        L4.setStartY(y-20); L4.setEndY(y-200);
        L4.setStrokeWidth(20);
        L4.setStroke(Color.rgb(54,225,243));
        L4.setFill(Color.rgb(54,225,243));
        L4.setStrokeLineCap(StrokeLineCap.ROUND);
        plus.getChildren().add(L4);

        plus.relocate(Ball.giveCopy().getX()-50,y1);//y=150
        group.getChildren().add(plus);
        rotateGroup(plus,L1,L2,L3,L4,-1);
    }

    private void rotateGroup (Group group, Shape L1 , Shape L2 , Shape L3, Shape L4, double rotation) {
//        -1150

        Timeline loop =  new Timeline(new KeyFrame(Duration.millis(16), new
                EventHandler<>() {
                    double dTheta = rotation;

                    @Override
                    public void handle(final ActionEvent t) {
                        group.setRotate(group.getRotate() + dTheta);
                        Ball ball = Ball.giveCopy();
                        Circle circleBall = ball.getCircle();

                        Shape intersect1 = Shape.intersect(circleBall,L1);
                        Shape intersect2 = Shape.intersect(circleBall, L2);
                        Shape intersect3 = Shape.intersect(circleBall, L3);
                        Shape intersect4 = Shape.intersect(circleBall, L4);

                        if (stepAfterResume > 0) {
                            stepAfterResume--;
                            return;
                        }


//                        long moved = Ball.giveCopy().getSlavedMoved();
                        if (intersect1.getBoundsInLocal().getWidth()!=-1) {
//                            System.out.println(ball.getBallColor().toString() + " " + s1.getFill().toString());

                            if (! ball.getBallColor().equals(L1.getFill())) {
                                //Game Over
                                intersect1.setFill(Color.BLACK);
                                new HomeActivity().gameOver();
//                                System.out.println(Math.abs(x-y));

                            }
                            else {
                                System.out.println("Pass");
                            }

                        }

                        else if (intersect2.getBoundsInLocal().getWidth()!=-1) {
//                            System.out.println(ball.getBallColor().toString() + " " + s2.getFill().toString());
                            if (! ball.getBallColor().equals(L2.getFill())) {
                                //Game Over
//                                intersect2.setFill(Color.BLACK);
                                System.out.println(ball.getBallColor().toString()+" "+L2.getFill().toString());
                                new HomeActivity().gameOver();
                                System.out.println(Math.abs(x-y));
                            }
                            else {
                                System.out.println("Pass");

                            }
                        }
                        else if (intersect3.getBoundsInLocal().getWidth()!=-1) {
//                            System.out.println(ball.getBallColor().toString() + " " + s3.getFill().toString());
                            if (!ball.getBallColor().equals(L3.getFill())) {
                                //Game Over
//                                intersect3.setFill(Color.BLACK);
                                System.out.println(Math.abs(x-y));
                                new HomeActivity().gameOver();
                            } else {
                                System.out.println("Pass");

                            }
                        }
                        else if (intersect4.getBoundsInLocal().getWidth()!=-1) {
//                            System.out.println(ball.getBallColor().toString() + " " + s4.getFill().toString());
                            if (!ball.getBallColor().equals(L4.getFill())) {
                                //Game Over
//                                intersect3.setFill(Color.BLACK);
                                new HomeActivity().gameOver();
                                System.out.println(Math.abs(x-y));
                            } else {
                                System.out.println("Pass");
                            }
                        }



                    }
                }));

        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();

        timelines.add(loop);

    }
    private void rotateGroup1 (Group group, Shape L1 , Shape L2 , Shape L3, Shape L4, double rotation) {
//        -1150

        Timeline loop =  new Timeline(new KeyFrame(Duration.millis(16), new
                EventHandler<>() {
                    double dTheta = rotation;

                    @Override
                    public void handle(final ActionEvent t) {
                        group.setRotate(group.getRotate() + dTheta);
                        Ball ball = Ball.giveCopy();
                        Circle circleBall = ball.getCircle();

                        Shape intersect1 = Shape.intersect(circleBall,L1);
                        Shape intersect2 = Shape.intersect(circleBall, L2);
                        Shape intersect3 = Shape.intersect(circleBall, L3);
                        Shape intersect4 = Shape.intersect(circleBall, L4);

                        if (stepAfterResume > 0) {
                            stepAfterResume--;
                            return;
                        }


//                        long moved = Ball.giveCopy().getSlavedMoved();
                        if (intersect1.getBoundsInLocal().getWidth()!=-1) {
//                            System.out.println(ball.getBallColor().toString() + " " + s1.getFill().toString());

                            if (! ball.getBallColor().equals(L1.getFill())) {
                                //Game Over
                                intersect1.setFill(Color.BLACK);
                                new HomeActivity().gameOver();
//                                System.out.println(Math.abs(x-y));

                            }
                            else {
                                System.out.println("Pass");
                            }

                        }

                        else if (intersect2.getBoundsInLocal().getWidth()!=-1) {
//                            System.out.println(ball.getBallColor().toString() + " " + s2.getFill().toString());
                            if (! ball.getBallColor().equals(L2.getFill())) {
                                //Game Over
//                                intersect2.setFill(Color.BLACK);
                                System.out.println(ball.getBallColor().toString()+" "+L2.getFill().toString());
                                new HomeActivity().gameOver();
                                System.out.println(Math.abs(x-y));
                            }
                            else {
                                System.out.println("Pass");

                            }
                        }
                        else if (intersect3.getBoundsInLocal().getWidth()!=-1) {
//                            System.out.println(ball.getBallColor().toString() + " " + s3.getFill().toString());
                            if (!ball.getBallColor().equals(L3.getFill())) {
                                //Game Over
//                                intersect3.setFill(Color.BLACK);
                                System.out.println(Math.abs(x-y));
                                new HomeActivity().gameOver();
                            } else {
                                System.out.println("Pass");

                            }
                        }
                        else if (intersect4.getBoundsInLocal().getWidth()!=-1) {
//                            System.out.println(ball.getBallColor().toString() + " " + s4.getFill().toString());
                            if (!ball.getBallColor().equals(L4.getFill())) {
                                //Game Over
//                                intersect3.setFill(Color.BLACK);
                                new HomeActivity().gameOver();
                                System.out.println(Math.abs(x-y));
                            } else {
                                System.out.println("Pass");
                            }
                        }



                    }
                }));

        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();

        timelines.add(loop);

    }

    private static boolean isGameOver;
    private static ArrayList<Timeline> timelines = new ArrayList<>();
    public static void GameOver () {
        isGameOver = true;
        for (int i = 0; i < timelines.size(); i++) {
            timelines.get(i).pause();
        }
    }
    private static int stepAfterResume = 0;
    public static void resume () {
        isGameOver = false;
        stepAfterResume = 2500;
        for (int i = 0; i < timelines.size(); i++) {
            timelines.get(i).play();
        }
    }
    public static void resume_GameOver(){
        isGameOver = false;
        for (int i = 0; i < timelines.size(); i++) {
            timelines.get(i).playFromStart();
        }
    }




    private void RotateThread (Rotate rotate, Shape s1,Shape s2,Shape s3,Shape s4,int Cy,Group slave,double r) {
        Timeline loop =  new Timeline(new KeyFrame(Duration.millis(16), new
                EventHandler<>() {
                    double dTheta = r;

                    @Override
                    public void handle(final ActionEvent t) {
                        rotate.setAngle(rotate.getAngle() + dTheta);
                        Ball ball = Ball.giveCopy();
                        Circle circleBall = ball.getCircle();

                        Shape intersect1 = Shape.intersect(circleBall, s1);
                        Shape intersect2 = Shape.intersect(circleBall, s2);
                        Shape intersect3 = Shape.intersect(circleBall, s3);
                        Shape intersect4 = Shape.intersect(circleBall, s4);

                        int x = (int)slave.getLayoutY();
                        int y = ball.getY();
                        if (stepAfterResume > 0) {
                            stepAfterResume--;

                            return;
                        }

//                        long moved = Ball.giveCopy().getSlavedMoved();
                        if (intersect1.getBoundsInLocal().getWidth()!=-1) {
//                            System.out.println(ball.getBallColor().toString() + " " + s1.getFill().toString());

                            if (! ball.getBallColor().equals(s1.getFill())) {
                                //Game Over
                                intersect1.setFill(Color.BLACK);
                                new HomeActivity().gameOver();
                                System.out.println(Math.abs(x-y));

                            }
                            else {
                                System.out.println("Pass");
                            }

                        }

                        else if (intersect2.getBoundsInLocal().getWidth()!=-1) {
//                            System.out.println(ball.getBallColor().toString() + " " + s2.getFill().toString());
                            if (! ball.getBallColor().equals(s2.getFill())) {
                                //Game Over
                                intersect2.setFill(Color.BLACK);
                                System.out.println(ball.getBallColor().toString()+" "+s2.getFill().toString());
                                new HomeActivity().gameOver();
                                System.out.println(Math.abs(x-y));
                            }
                            else {
                                System.out.println("Pass");

                            }
                        }
                        else if (intersect3.getBoundsInLocal().getWidth()!=-1) {
//                            System.out.println(ball.getBallColor().toString() + " " + s3.getFill().toString());
                            if (!ball.getBallColor().equals(s3.getFill())) {
                                //Game Over
                                intersect3.setFill(Color.BLACK);
                                System.out.println(Math.abs(x-y));
                                new HomeActivity().gameOver();
                            } else {
                                System.out.println("Pass");

                            }
                        }
                        else if (intersect4.getBoundsInLocal().getWidth()!=-1) {
//                            System.out.println(ball.getBallColor().toString() + " " + s4.getFill().toString());
                            if (!ball.getBallColor().equals(s4.getFill())) {
                                //Game Over
                                intersect3.setFill(Color.BLACK);
                                new HomeActivity().gameOver();
                                System.out.println(Math.abs(x-y));
                            } else {
                                System.out.println("Pass");
                            }
                        }



                    }
                }));

        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();

        timelines.add(loop);
    }


    public void fetchImageOfStar (int x,int y, Group slaveGroup) {
        Circle star = new Circle();
        javafx.scene.image.Image im = new Image("file:star.png",false);
        star.setLayoutX(x);
        star.setFill(new ImagePattern(im));
        star.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
        slaveGroup.getChildren().add(star);

        star.setLayoutY(y);
        star.setStyle("-fx-background-color: transparent;");
        star.setRadius(30);
        Timeline starLoop =  new Timeline(new KeyFrame(Duration.millis(50), new
                EventHandler<>() {
                    @Override
                    public void handle(final ActionEvent t) {

                        Circle ball = Ball.giveCopy().getCircle();

                        Shape intersect = Shape.intersect(ball,star);

                        if ((intersect.getBoundsInParent().getWidth()!=-1)&&(intersect.getBoundsInLocal().getWidth()!=-1)) {
                            Score.giveCopy().increamentScore();
                            new Controller().playStarMusic();
                            star.setLayoutY(0);
                            star.setLayoutX(-1000);
                            star.setDisable(true);
                            star.setVisible(false);
                        }
                    }
                }));

        starLoop.setCycleCount(Timeline.INDEFINITE);
        starLoop.play();


    }



}
