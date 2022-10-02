package HighScore;

import SaveGame.SaveGame;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.SplittableRandom;

public class HighScore implements Serializable {
     private String name;
     private int Score;
     private static final long serialVersionUID = 2L;
     private static HighScore instance;
     public static HighScore getInstance(String name, int score) {
         if (instance == null) {
             instance = new HighScore(name,score);
         }
         return instance;
     }

    public static HighScore getInstance() {
        if (instance == null) {
            instance = new HighScore();
        }
        return instance;
    }

     public static HighScore giveCopy() {
         return instance;
     }

     public void addUserScore(String name, int score) {
         if (hashMap.containsKey(name)) {
             int d = hashMap.get(name);
             if (d< score) {
                 hashMap.remove(name);
                 hashMap.put(name,score);
             }
         }
         else {
             hashMap.put(name,score);
         }
         write();
     }

     public void init () {
         read();
     }

    public void setHashMap(HashMap<String, Integer> hashMap) {
        this.hashMap = hashMap;
    }

    private HashMap<String,Integer> hashMap= new HashMap<>();

    public HashMap<String, Integer> getHashMap() {
        return hashMap;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        Score = score;
    }

    private HighScore(String name, int score) {
        this.name = name;
        Score = score;
    }

    private HighScore () {}


    public String getName() {
        return name;
    }

    public int getScore() {
        return Score;
    }

    public void write () {
        writeToFile("dhananjay.singh", hashMap);
    }

    public void read () {
        String Path = "dhananjay.singh";
        this.hashMap = readToFiles(Path);
    }

    private HashMap<String,Integer> readToFiles (String Path) {

        try {

            // read object from file
            FileInputStream fis = new FileInputStream(Path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            HashMap<String,Integer> result = (HashMap<String,Integer>) ois.readObject();
            ois.close();

            System.out.println("Score read successfully");

            return result;

        } catch (Exception e) {

            e.printStackTrace();

            return new HashMap<>();
        }
    }

    private void writeToFile (String Path, HashMap<String,Integer> games) {
        try {

            FileOutputStream fileOut = new FileOutputStream(Path);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(games);
            objectOut.close();
            System.out.println("The Score was successfully written to a file");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


}
