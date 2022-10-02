package Activity.HomeActivity;

import Activity.PlayGame.PlayGame;
import Activity.ResumeGame.ResumeActivity;
import Ball.Ball;
import HighScore.HighScore;
import Obstacle.Obstacle;
import SaveGame.Score;
import animatefx.animation.Flash;
import animatefx.animation.ZoomIn;
import animatefx.animation.ZoomOut;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.Controller;
import sample.Main;

public class HomeActivity extends Main {
//Play button
    //new game
    //Resume button
    //Save game

    public HomeActivity() {
//        this.scene = scene;
    }



    public static void play() {
        Ball.newGame();
        PlayGame newGame = PlayGame.getInstance();
        newGame.startNewGame();
    }

    public void resume () {
        Ball.newGame();
        ResumeActivity resumeActivity = new ResumeActivity();
        resumeActivity.showScreen();


    }
    private boolean checkStars(){
        return Score.giveCopy().getStars() >=2;
    }

    private void deductStarts(){
        Score.giveCopy().setStars(Score.giveCopy().getStars()-2);
    }


    public void gameOver () {
        Obstacle.GameOver();
//        Ball.stopBall();
        Ball.pauseAtGameOver();
        Group  group = new Group();
        new Controller().playGameOver();
        Text gaveOver = new Text("Game Over");

        int star = Score.giveCopy().getStars();
        Text scoreplay=new Text("Stars won: " + star);
        Text continueGame=new Text("Do you want to continue");

        gaveOver.setFill(Color.RED);
        gaveOver.setLayoutX(500);
        gaveOver.setLayoutY(50);
        gaveOver.setScaleX(5);
        gaveOver.setScaleY(5);

        scoreplay.setFill(Color.GOLD);
        scoreplay.setLayoutX(500);
        scoreplay.setLayoutY(250);
        scoreplay.setScaleX(5);
        scoreplay.setScaleY(5);

        continueGame.setFill(Color.SNOW);
        continueGame.setLayoutX(500-50);
        continueGame.setLayoutY(450);
        continueGame.setScaleX(5);
        continueGame.setScaleY(5);




        Button yes=new Button("YES");
        Button no=new Button("NO");
        Button restart = new Button("Restart");
        restart.setStyle("-fx-background-color: linear-gradient(#ffd65b, #e68400), linear-gradient(#ffef84, #f2ba44), linear-gradient(#ffea6a, #efaa22), linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%), linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));"+
                "-fx-background-radius: 30;"+
                "-fx-background-insets: 0,1,2,3,0;"+
                "-fx-text-fill: #654b00;"+
                "-fx-font-weight: bold;"+
                "-fx-font-size: 14px;"+
                "-fx-padding: 10 20 10 20;");
        yes.setLayoutX(480-300);
        yes.setLayoutY(550);
        yes.setScaleX(2);
        yes.setScaleY(2);
        yes.setStyle("-fx-background-color: linear-gradient(#ffd65b, #e68400), linear-gradient(#ffef84, #f2ba44), linear-gradient(#ffea6a, #efaa22), linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%), linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));"+
                "-fx-background-radius: 30;"+
                "-fx-background-insets: 0,1,2,3,0;"+
                "-fx-text-fill: #654b00;"+
                "-fx-font-weight: bold;"+
                "-fx-font-size: 14px;"+
                "-fx-padding: 10 20 10 20;");
        no.setLayoutX(480+300);
        no.setLayoutY(550);
        no.setScaleX(2);
        no.setScaleY(2);
        no.setStyle("-fx-background-color: linear-gradient(#ffd65b, #e68400), linear-gradient(#ffef84, #f2ba44), linear-gradient(#ffea6a, #efaa22), linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%), linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));"+
                "-fx-background-radius: 30;"+
                "-fx-background-insets: 0,1,2,3,0;"+
                "-fx-text-fill: #654b00;"+
                "-fx-font-weight: bold;"+
                "-fx-font-size: 14px;"+
                "-fx-padding: 10 20 10 20;");
        restart.setLayoutX(480);
        restart.setLayoutY(550);
        restart.setScaleX(2);
        restart.setScaleY(2);
        restart.setStyle("-fx-background-color: linear-gradient(#ffd65b, #e68400), linear-gradient(#ffef84, #f2ba44), linear-gradient(#ffea6a, #efaa22), linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%), linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));"+
                "-fx-background-radius: 30;"+
                "-fx-background-insets: 0,1,2,3,0;"+
                "-fx-text-fill: #654b00;"+
                "-fx-font-weight: bold;"+
                "-fx-font-size: 14px;"+
                "-fx-padding: 10 20 10 20;");
        group.getChildren().addAll(gaveOver,scoreplay,restart);

        Scene scene=new Scene(group);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        scene.setFill(Color.rgb(42, 40, 42));
        stage.setScene(scene);
        stage.setWidth(1000);
        stage.setHeight(700);
        // System.out.println(stage.getX() + " "  + stage.getY());
        stage.setOpacity(0.7);
        stage.setMaximized(false);
        stage.setResizable(false);
        stage.getIcons().add(new Image("file:icon.png"));
        new ZoomOut(group).play();
        new ZoomIn(group).play();
        if (checkStars()) {
            group.getChildren().addAll(continueGame,yes,no);
        }

        stage.show();

        no.setOnMouseClicked(mouseEvent -> {
            //TODO:



            stage.close();



//            new Controller().playMusic();
//            new HomeActivity().exit();

            nameDialog(false);

        });
        yes.setOnMouseClicked(mouseEvent -> {
            //TODO:
            stage.close();
            new Controller().playMusic();
            Score.giveCopy().setStars(Score.giveCopy().getStars()-2);
            Ball.giveCopy().setY(Ball.giveCopy().getY() - 5);
            Obstacle.resume();
            Ball.resumeAtGameOver();

        });

        restart.setOnMouseClicked(mouseEvent -> {
            stage.close();
//            new Controller().playMusic();
//            Ball.destroyBall();
//            Score.destroy();
//            play();

            nameDialog(true);

        });




        System.out.println("Game over");

    }

    public void exit () {
//    getpStage().hide();
//        System.exit(0);
        Main.goToMainScreen();
    }
    public void exitmain(){
        getpStage().hide();
    }

    private void nameDialog (boolean isRestart) {
        Group group = new Group();



        Scene scene=new Scene(group);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        scene.setFill(Color.rgb(42, 40, 42));
        stage.setScene(scene);
        stage.setWidth(1000);
        stage.setHeight(700);
        // System.out.println(stage.getX() + " "  + stage.getY());
        stage.setOpacity(0.7);
        stage.setMaximized(false);
        stage.setResizable(false);
        stage.getIcons().add(new Image("file:icon.png"));
        stage.show();
        TextField name = new TextField("Enter your name");
        name.setStyle("-fx-background-color: transparent, #909090, transparent, white;\n" +
                "    -fx-background-radius: 0, 0, 0, 0;\n" +
                "    -fx-padding: 0.166667em;");
        name.setLayoutX(-700);
        name.setLayoutY(500);
        name.setScaleX(3);
        name.setScaleY(3);

        name.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (name.getText().equals("Enter your name")) {
                    name.setText("");
                    name.setStyle("-fx-text-inner-color: red;");
                }

            }
        });

        Button ok = new Button("Submit");
        ok.setStyle("-fx-background-color: linear-gradient(#ffd65b, #e68400), linear-gradient(#ffef84, #f2ba44), linear-gradient(#ffea6a, #efaa22), linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%), linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));"+
                "-fx-background-radius: 30;"+
                "-fx-background-insets: 0,1,2,3,0;"+
                "-fx-text-fill: #654b00;"+
                "-fx-font-weight: bold;"+
                "-fx-font-size: 14px;"+
                "-fx-padding: 10 20 10 20;");
        ok.setScaleX(3);
        ok.setScaleY(3);
        name.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (! name.getText().equals("Enter your name")) {

                    ok.setStyle("-fx-background-color: linear-gradient(#ffd65b, #e68400), linear-gradient(#ffef84, #f2ba44), linear-gradient(#ffea6a, #efaa22), linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%), linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));"+
                            "-fx-background-radius: 30;"+
                            "-fx-background-insets: 0,1,2,3,0;"+
                            "-fx-text-fill: #654b00;"+
                            "-fx-font-weight: bold;"+
                            "-fx-font-size: 14px;"+
                            "-fx-padding: 10 20 10 20;");
                    ok.setText("Submit");
                }
            }
        });




        ok.setOnMouseClicked(mouseEvent -> {
            if (name.getText().equals("Enter your name")) {
                ok.setText("Enter your name");
                ok.setStyle("-fx-text-inner-color: red;");
            }
            else {
                //submit


                String nameOfUser = name.getText();
                HighScore.giveCopy().addUserScore(nameOfUser,Score.giveCopy().getStars());
                stage.close();

                if (isRestart) {
                    new Controller().playMusic();
                    Ball.destroyBall();
                    Score.destroy();
                    play();
                }
                else {
                    new Controller().playMusic();
                    new HomeActivity().exit();
                }



            }
        });

        ok.setLayoutY(500);
        ok.setLayoutX(Ball.giveCopy().getX()-300);

        name.setLayoutY(200);
        name.setLayoutX(Ball.giveCopy().getX()-300);

        group.getChildren().addAll(ok,name);

    }

    public Group show () {
        Button NewGame,ResumeGame,Exit;
        new Controller().playMusic();
        // Buttons
        NewGame = new Button("New Game");
        ResumeGame = new Button("Resume Game");
        Exit = new Button("Exit Game");
        NewGame.setStyle(
                "-fx-background-color: linear-gradient(#ffd65b, #e68400), linear-gradient(#ffef84, #f2ba44), linear-gradient(#ffea6a, #efaa22), linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%), linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));"+
        "-fx-background-radius: 30;"+
        "-fx-background-insets: 0,1,2,3,0;"+
        "-fx-text-fill: #654b00;"+
        "-fx-font-weight: bold;"+
        "-fx-font-size: 14px;"+
        "-fx-padding: 10 20 10 20;"
        );
        ResumeGame.setStyle(
                "-fx-background-color: linear-gradient(#ffd65b, #e68400), linear-gradient(#ffef84, #f2ba44), linear-gradient(#ffea6a, #efaa22), linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%), linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));"+
                        "-fx-background-radius: 30;"+
                        "-fx-background-insets: 0,1,2,3,0;"+
                        "-fx-text-fill: #654b00;"+
                        "-fx-font-weight: bold;"+
                        "-fx-font-size: 14px;"+
                        "-fx-padding: 10 20 10 20;"
        );
        Exit.setStyle(
                "-fx-background-color: linear-gradient(#ffd65b, #e68400), linear-gradient(#ffef84, #f2ba44), linear-gradient(#ffea6a, #efaa22), linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%), linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));"+
                        "-fx-background-radius: 30;"+
                        "-fx-background-insets: 0,1,2,3,0;"+
                        "-fx-text-fill: #654b00;"+
                        "-fx-font-weight: bold;"+
                        "-fx-font-size: 14px;"+
                        "-fx-padding: 10 20 10 20;"
        );

        NewGame.setLayoutX(750);
        NewGame.setLayoutY(270);

        ResumeGame.setLayoutX(750);
        ResumeGame.setLayoutY(440);

        Exit.setLayoutX(750);
        Exit.setLayoutY(610);

        NewGame.setScaleX(2);
        NewGame.setScaleY(2);

        ResumeGame.setScaleX(2);
        ResumeGame.setScaleY(2);

        Exit.setScaleX(2);
        Exit.setScaleY(2);


        // click listener

        NewGame.setOnAction(actionEvent -> play());

        ResumeGame.setOnAction(actionEvent -> resume());

        Exit.setOnAction(actionEvent -> exitmain());

        Group group = new Group();
        // Background Image
        Image image=new Image("file:back.jpg");
        ImageView mv =new ImageView(image);
        mv.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        mv.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight()+50);
        group.getChildren().addAll(mv);

        group.getChildren().add(NewGame);
        group.getChildren().add(ResumeGame);
        group.getChildren().add(Exit);

        return  group;
    }


}
