package Activity.LeaderBoard;

import Ball.Ball;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import sample.Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LeaderBoard extends Main implements Serializable {
    private static final long serialVersionUID = 2L;
    private List<Map.Entry<String, Integer>> list;

    public LeaderBoard(List<Map.Entry<String, Integer>> list) {
        this.list = list;
    }

    public void show () {
        Group group = new Group();
        ArrayList<Thread > th = new ArrayList<>();
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

        BackButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                stop(th);
                Main.goToMainScreen();
            }
        });

        group.getChildren().addAll(BackButton);




        int size = Math.min(7,list.size());

        Text Button=new Text("Rank"+"                 "+"Name"+"                 "+"Score");
        Button.setLayoutX(750);
        Button.setLayoutY(120);
        Button.setFill(Color.GOLD);
        Button.setScaleX(2);
        Button.setScaleY(2);
        group.getChildren().addAll(Button);
        for (int i = 0; i < size; i++) {

            String Name = list.get(i).getKey();
            int score = list.get(i).getValue();
            Text button = new Text((i+1) +  "                 " + Name + "                 " + score);

            button.setLayoutX(750);
            button.setLayoutY(220 + i*80);
            button.setScaleX(2);
            button.setScaleY(2);

            button.setFill(Paint.valueOf("#FFFFFF"));
            group.getChildren().add(button);

            /////////////////////////////////////
            Paint[] paints = new Paint[7];
            paints[0] = Color.WHITE;
            paints[1] = Color.YELLOW;
            paints[2] = Color.RED;
            paints[3] = Color.GREEN;
            paints[4] = Color.WHEAT;
            paints[5] = Color.GOLD;
            paints[6] = Color.RED;

            Runnable runnable = () -> {
                long j = 0;
                int step = 0;
                while (j < 10000000000L) {
                    j++;

                    if (j == 1000000000L - 1) {
                        j=0;
                        step ++;
                        step = step%7;
                        button.setFill(paints[step]);
                    }
                }
            };

            Thread thread = new Thread(runnable);
            thread.start();
            th.add(thread);


        }

        if (size == 0) {
            Text text = new Text("No Score Available");
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


//        TableView table = new TableView();
//        final Label label = new Label("Address Book");
//        label.setFont(new Font("Arial", 20));
//
//        table.setEditable(false);
//        table.setLayoutX(755);
//        table.setLayoutY(600);
//        table.setScaleX(2);
//        table.setScaleY(2);
//
//        TableColumn firstNameCol = new TableColumn("Name");
//        TableColumn lastNameCol = new TableColumn("Score Name");
//
//
//        table.getColumns().addAll(firstNameCol, lastNameCol);
//
//
//        final ObservableList<String> data = FXCollections.observableArrayList(
//
//        );
//
//
////        firstNameCol.getColumns().add("Hello");
//
////        final VBox vbox = new VBox();
////        vbox.setSpacing(5);
////        vbox.setPadding(new Insets(10, 0, 0, 10));
////        vbox.getChildren().addAll(label, table);

//        table.setItems(data);
//        group.getChildren().addAll(label,table);
        Main.udpateScene(group);

    }

    private ArrayList<String> giveData (String s) {

        ArrayList<String >l = new ArrayList<>();

        String name = "";
        String score = "";
        boolean tag = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='=') {
                i++;
                tag = true;
            }
            else if (tag) {
                score += s.charAt(i);
            }
            else {
                name += s.charAt(i);
            }



        }

        l.add(name);
        l.add(score);


        return l;

    }

    private void stop (ArrayList<Thread> th) {
        for (int i = 0; i < th.size(); i++) {
            th.get(i).stop();
        }
    }
}
