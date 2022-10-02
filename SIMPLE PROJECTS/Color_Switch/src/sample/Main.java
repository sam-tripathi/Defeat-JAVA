package sample;

import Activity.HomeActivity.HomeActivity;
import Activity.LeaderBoard.LeaderBoard;
import Activity.PlayGame.PlayGame;
import Ball.Ball;
import HighScore.HighScore;
import SaveGame.Score;
//import animatefx.animation.*;
import animatefx.animation.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Time;
import java.util.*;

public class Main extends Application {
    private static Stage pStage;
    private static Scene scene;
    @Override
    public void start(Stage primaryStage) throws Exception{

        Controller.init();
        new Controller ().playMusic();
        HighScore.getInstance().init();
//        FXMLLoader loader = new FXMLLoader();
//
//        loader.setLocation(new URL("file:src/sample/sample.fxml"));
        pStage = primaryStage;
        pStage.getIcons().add(new Image("file:icon.png"));


        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        pStage.setFullScreenExitHint("");
//        primaryStage.setFullScreen(true);
        primaryStage.setTitle("Color Switch");
//        Group group = new Group();
////        Ball playerBall  = Ball.getInstance(Color.RED, 700,group);
//        Image image=new Image("file:switch.jpeg");
//        ImageView mv =new ImageView(image);
//        mv.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
//        mv.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
//        group.getChildren().addAll(mv);
//
//        Button roundButton = new Button("Play");
//        roundButton.setLayoutX(685);
//        roundButton.setLayoutY(422);
//        roundButton.setOnAction(actionEvent -> StartButtonOnClick());
//        /*Image imagines=new Image("file:switch.jpeg");
//
//        ImageView bt=new ImageView(imagines);
//        roundButton.setGraphic(bt);*/
//        roundButton.setStyle(
//                "-fx-background-image: url('/switch.jpeg'); " +
//                        "-fx-background-color: transparent;"+
//                        "-fx-background-radius: 200em; " +
//                        "-fx-min-width: 200px; " +
//                        "-fx-min-height: 200px; " +
//                        "-fx-max-width: 200px; " +
//                        "-fx-max-height: 200px;"
//        );
//
        Color black = Color.rgb(42, 40, 42);
//        group.getChildren().add(roundButton);

        Group group = new Group();
        scene = new Scene(group,400,500,black);
        goToMainScreen();


//        scene.setRoot(); // TODO:

        primaryStage.setScene(scene);
        primaryStage.show();
//        new FadeIn(group).play();




        detectKey();

    }

    private static void StartButtonOnClick () {
        // System.out.println("Start Button Pressed");
        HomeActivity homeActivity = new HomeActivity();
        Group g =homeActivity.show();

//        new BounceOut(scene.getRoot()).play();
        udpateScene(g);

    }


    public static Stage getpStage() {
        return pStage;
    }

    private static void detectKey () {


        scene.setOnKeyPressed(keyEvent -> PlayGame.keyDetect());



    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void udpateScene (Group group) {

        scene.setRoot(group);
        new FadeIn(group).play();

    }

    public static void goToMainScreen () {
        Group group = new Group();
        Ball.destroyBall();
        Score.destroy();

        Button instagram,facebook,gitHub,Trophy;
        gitHub = new Button();


        FileInputStream input = null;
        try {
            input = new FileInputStream("instagram.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image imageinstagram = new Image(input);
        ImageView imageView = new ImageView(imageinstagram);
        instagram = new Button("",imageView);
        instagram.setStyle("-fx-background-color: transparent;");
        instagram.setLayoutY(-100);
        instagram.setLayoutX(0);
        instagram.setScaleX(0.175);
        instagram.setScaleY(0.175);

        instagram.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                openWeb("https://www.instagram.com/harsh_verma_33/");
            }
        });




        rotationButton(instagram);


        insertImageInButton(gitHub, "github.jpg","https://github.com/Harsh3305/APProjectEndSem");
//        insertImageInButton(Trophy, "trophy.png");








        input = null;
        try {
            input = new FileInputStream("facebook.jpg");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        imageinstagram = new Image(input);
        imageView = new ImageView(imageinstagram);
        facebook = new Button("",imageView);
        facebook.setStyle("-fx-background-color: transparent;");
//        facebook.setLayoutY(-100);
//        facebook.setLayoutX(1000000000);
//        facebook.setScaleX(0.175);
//        facebook.setScaleY(0.175);

        facebook.setOnMouseClicked(mouseEvent -> openWeb("https://www.facebook.com/dhananjaytomar19/about"));

        rotationButton(facebook);



        input = null;
        try {
            input = new FileInputStream("gitHub.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        imageinstagram = new Image(input);
        imageView = new ImageView(imageinstagram);
        gitHub = new Button("",imageView);
        gitHub.setStyle("-fx-background-color: transparent;");
//        gitHub.setLayoutY(-100);
//        gitHub.setLayoutX(0);
//        gitHub.setScaleX(0.175);
//        gitHub.setScaleY(0.175);

        gitHub.setOnMouseClicked(mouseEvent -> openWeb("https://github.com/Harsh3305/APProjectEndSem"));

        rotationButton(gitHub);





        input = null;
        try {
            input = new FileInputStream("trophy.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        imageinstagram = new Image(input);
        imageView = new ImageView(imageinstagram);
        Trophy = new Button("",imageView);
        Trophy.setStyle("-fx-background-color: transparent;");
//
//        Trophy.setLayoutY(-100);
//        Trophy.setLayoutX(0);
//        Trophy.setScaleX(0.175);
//        Trophy.setScaleY(0.175);

//        Trophy.setOnMouseClicked(mouseEvent -> openWeb("https://github.com/Harsh3305/APProjectEndSem"));
        Trophy.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                leaderBoard();
            }
        });

        rotationButton(Trophy);

        facebook.setLayoutY(-100);
        facebook.setLayoutX(1000);
        facebook.setScaleX(0.175);
        facebook.setScaleY(0.175);

        gitHub.setLayoutY(530);
        gitHub.setLayoutX(185);
        gitHub.setScaleX(.8);
        gitHub.setScaleY(.8);

        Trophy.setLayoutY(350);
        Trophy.setLayoutX(1000);
        Trophy.setScaleX(0.175);
        Trophy.setScaleY(0.175);

//        Ball playerBall  = Ball.getInstance(Color.RED, 700,group);
        Image image=new Image("file:switch.jpeg");
        ImageView mv =new ImageView(image);
        mv.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        mv.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
        group.getChildren().addAll(mv);




        group.getChildren().addAll(instagram);
        group.getChildren().addAll(facebook);
        group.getChildren().addAll(gitHub);
        group.getChildren().addAll(Trophy);

        Button roundButton = new Button("Play");
        roundButton.setLayoutX(685);
        roundButton.setLayoutY(422);

        roundButton.setOnAction(actionEvent -> StartButtonOnClick());

        /*Image imagines=new Image("file:switch.jpeg");

        ImageView bt=new ImageView(imagines);
        roundButton.setGraphic(bt);*/
        roundButton.setStyle(
                "-fx-background-image: url('/switch.jpeg'); " +
                        "-fx-background-color: transparent;"+
                        "-fx-background-radius: 200em; " +
                        "-fx-min-width: 200px; " +
                        "-fx-min-height: 200px; " +
                        "-fx-max-width: 200px; " +
                        "-fx-max-height: 200px;"
        );

        Color black = Color.rgb(42, 40, 42);
        group.getChildren().add(roundButton);

        udpateScene(group);
    }



    private static void rotationButton(Button button) {
        Timeline loop = new Timeline(new KeyFrame(Duration.millis(16), new
                EventHandler<>() {

                    double dTheta = 2;

                    @Override
                    public void handle(final ActionEvent t) {

                        button.setRotate(button.getRotate() + dTheta);


                    }
                }));

        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();

    }


    private static void openWeb(String url)  {


        try {

            URI uri= new URI(url);

            java.awt.Desktop.getDesktop().browse(uri);
            // System.out.println("Web page opened in browser");
        }

        catch (URISyntaxException | IOException e)
        {
            e.printStackTrace();
        }


    }

    private static void insertImageInButton (Button button, String Path, String Link) {
//        FileInputStream input = null;
//        try {
//            input = new FileInputStream(Path);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        Image imageinstagram = new Image(input);
//        ImageView imageView = new ImageView(imageinstagram);
//        button = new Button("",imageView);
//
//
//        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                openWeb(Link);
//            }
//        });
//
//
//
//        rotationButton(button);
    }

    private static void leaderBoard () {
//        HighScore.getInstance().init();

        HashMap<String, Integer> map = HighScore.giveCopy().getHashMap();

        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());

        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        print (list);


    }

    private static void print(List<Map.Entry<String, Integer>> list) {
//        System.out.println("Hello Ji");
//        for (Map.Entry<String, Integer> stringIntegerEntry : list) {
//            System.out.println(stringIntegerEntry);
//        }

        new LeaderBoard(list).show();

    }



    public static  Scene getScene() {
        return scene;
    }
}