package Activity.ResumeGame;

import Activity.PlayGame.PlayGame;
import SaveGame.SaveGame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import sample.Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ResumeActivity extends  Main {
    public void showScreen () {
        ArrayList<SaveGame> saveGameArrayList = fetchData();

        Group group = new Group();
        Image image=new Image("file:back.jpg");
        ImageView mv =new ImageView(image);
        mv.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        mv.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight()+50);
        group.getChildren().addAll(mv);



        FileInputStream input = null;
        try {
            input = new FileInputStream("previous.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image imageinstagram = new Image(input);
        ImageView imageView = new ImageView(imageinstagram);
        Button BackButton = new Button("",imageView);
        BackButton.setStyle("-fx-background-color: transparent;");
        BackButton.setLayoutX(-50);
        BackButton.setLayoutY(-150);
        BackButton.setScaleX(.2);
        BackButton.setScaleY(.2);



//        BackButton.setStyle("-fx-background-color: linear-gradient(#ffd65b, #e68400), linear-gradient(#ffef84, #f2ba44), linear-gradient(#ffea6a, #efaa22), linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%), linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));"+
//                "-fx-background-radius: 30;"+
//                "-fx-background-insets: 0,1,2,3,0;"+
//                "-fx-text-fill: #654b00;"+
//                "-fx-font-weight: bold;"+
//                "-fx-font-size: 14px;"+
//                "-fx-padding: 10 20 10 20;");

        group.getChildren().add(BackButton);

        BackButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Main.goToMainScreen();
            }
        });


        // I will display only 7 saved games

        int size = Math.min(7,saveGameArrayList.size());


        for (int i = 0; i < size; i++) {
            Button button = new Button((i+1) + " Saved Game " + saveGameArrayList.get(i).getScore ());
            button.setLayoutX(750);
            button.setLayoutY(200 + i*80);
            button.setScaleX(2);
            button.setScaleY(2);
            button.setBackground(Background.EMPTY);
            button.setTextFill(Paint.valueOf("#FFFFFF"));
            group.getChildren().add(button);

            int finalI = i;
            button.setOnAction(actionEvent -> {
                saveGameListener(finalI,saveGameArrayList);
            });
        }

        if (size == 0) {
            Text text = new Text("No Saved Game");
            text.setLayoutX(750);
            text.setLayoutY(480);
            text.setScaleX(4);
            text.setScaleY(4);
            text.setFill(Paint.valueOf("#FFFFFF"));
            group.getChildren().add(text);
            Paint[] paints = new Paint[7];
            paints[0] = Color.WHITE;
            paints[1] = Color.YELLOW;
            paints[2] = Color.RED;
            paints[3] = Color.GREEN;
            paints[4] = Color.WHEAT;
            paints[5] = Color.GOLD;
            paints[6] = Color.RED;

            Runnable runnable = () -> {
                long i = 0;
                int step = 0;
                while (i < 10000000000L) {
                    i++;

                    if (i == 1000000000L - 1) {
                        i=0;
                        step ++;
                        step = step%7;
                        text.setFill(paints[step]);
                    }
                }
            };

            Thread thread = new Thread(runnable);
            thread.start();


        }

        Main.udpateScene(group);


    }
    private void saveGameListener (int index, ArrayList<SaveGame> saveGameArrayList ) {
        PlayGame game = PlayGame.getInstance();
        game.resume(saveGameArrayList.get(index));
    }
    private ArrayList<SaveGame> fetchData () {
        return new SaveGame().fetchData();
    }
}
