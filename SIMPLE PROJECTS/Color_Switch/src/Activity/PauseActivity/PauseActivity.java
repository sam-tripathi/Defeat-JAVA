package Activity.PauseActivity;

import Activity.HomeActivity.HomeActivity;
import Activity.PlayGame.PlayGame;
import Ball.*;
import SaveGame.*;
import com.sun.javafx.beans.event.AbstractNotifyListener;
import javafx.beans.Observable;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import sample.Main;

import java.awt.*;
import java.util.Collection;

public class PauseActivity extends  Main{
    // Resume Game
    // Exit
    // Save and Exit

    public void show () {

        Group group = new Group();


        Button resume = new Button("Resume");
        Button saveAndExit = new Button("Save and Exit");
        Button Exit = new Button("Exit");
        Button Restart=new Button("Restart");

        resume.setLayoutX(480);
        resume.setLayoutY(100);
        resume.setScaleX(2);
        resume.setScaleY(2);
        resume.setStyle("-fx-background-color: linear-gradient(#ffd65b, #e68400), linear-gradient(#ffef84, #f2ba44), linear-gradient(#ffea6a, #efaa22), linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%), linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));"+
                "-fx-background-radius: 30;"+
                "-fx-background-insets: 0,1,2,3,0;"+
                "-fx-text-fill: #654b00;"+
                "-fx-font-weight: bold;"+
                "-fx-font-size: 14px;"+
                "-fx-padding: 10 20 10 20;");
        Restart.setLayoutX(480);
        Restart.setLayoutY(250);
        Restart.setScaleX(2);
        Restart.setScaleY(2);
        Restart.setStyle("-fx-background-color: linear-gradient(#ffd65b, #e68400), linear-gradient(#ffef84, #f2ba44), linear-gradient(#ffea6a, #efaa22), linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%), linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));"+
                "-fx-background-radius: 30;"+
                "-fx-background-insets: 0,1,2,3,0;"+
                "-fx-text-fill: #654b00;"+
                "-fx-font-weight: bold;"+
                "-fx-font-size: 14px;"+
                "-fx-padding: 10 20 10 20;");

        saveAndExit.setLayoutX(480);
        saveAndExit.setLayoutY(400);
        saveAndExit.setScaleX(2);
        saveAndExit.setScaleY(2);
        saveAndExit.setStyle("-fx-background-color: linear-gradient(#ffd65b, #e68400), linear-gradient(#ffef84, #f2ba44), linear-gradient(#ffea6a, #efaa22), linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%), linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));"+
                "-fx-background-radius: 30;"+
                "-fx-background-insets: 0,1,2,3,0;"+
                "-fx-text-fill: #654b00;"+
                "-fx-font-weight: bold;"+
                "-fx-font-size: 14px;"+
                "-fx-padding: 10 20 10 20;");
        Exit.setLayoutX(480);
        Exit.setLayoutY(550);
        Exit.setScaleX(2);
        Exit.setScaleY(2);
        Exit.setStyle("-fx-background-color: linear-gradient(#ffd65b, #e68400), linear-gradient(#ffef84, #f2ba44), linear-gradient(#ffea6a, #efaa22), linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%), linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));"+
                "-fx-background-radius: 30;"+
                "-fx-background-insets: 0,1,2,3,0;"+
                "-fx-text-fill: #654b00;"+
                "-fx-font-weight: bold;"+
                "-fx-font-size: 14px;"+
                "-fx-padding: 10 20 10 20;");



        group.getChildren().add(resume);
        group.getChildren().add(saveAndExit);
        group.getChildren().add(Exit);
        group.getChildren().add(Restart);
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


        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                PlayGame.getInstance().onResume();
            }
        });

        resume.setOnMouseClicked(mouseEvent -> {
            stage.close();
            PlayGame.getInstance().onResume();
        });

        Restart.setOnMouseClicked(mouseEvent -> {

            Ball.destroyBall();
            Score.destroy();
            PlayGame.getInstance().startNewGame();
            stage.close();

        });

        saveAndExit.setOnMouseClicked(mouseEvent -> {
            stage.close();
            new SaveGame().SaveGame();
            new HomeActivity().exit();


        });


        Exit.setOnMouseClicked(mouseEvent ->{
                stage.close();
                //            Main.getpStage().hide();
            new HomeActivity().exit();
        });



    }

}
