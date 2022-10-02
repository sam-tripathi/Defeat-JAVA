package sample;

import javax.sound.sampled.*;
import java.io.*;

public class Controller {

    private static Clip backClip, gameOverClip, coinClip;

    public static void init () {

        Thread back = new Thread(new Runnable() {
            @Override
            public void run() {

                String path = "sound.wav";

                AudioInputStream audioInputStream =
                        null;
                try {
                    audioInputStream = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
                } catch (UnsupportedAudioFileException | IOException e) {
                    e.printStackTrace();
                }

                // create clip reference

                try {

                    backClip = AudioSystem.getClip();
                    backClip.open(audioInputStream);
                    backClip.stop();
                    backClip.loop(Clip.LOOP_CONTINUOUSLY);
//            audioPlayer.play();


                } catch (LineUnavailableException | IOException e) {
                    e.printStackTrace();
                }
            }
        });


        Thread gameover = new Thread(new Runnable() {
            @Override
            public void run() {


                String path = "gameover.wav";

                AudioInputStream audioInputStream =
                        null;
                try {
                    audioInputStream = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
                } catch (UnsupportedAudioFileException | IOException e) {
                    e.printStackTrace();
                }

                // create clip reference

                try {

                    gameOverClip = AudioSystem.getClip();
                    gameOverClip.open(audioInputStream);
                    gameOverClip.stop();
//            gameOverClip.loop(0);
//            audioPlayer.play();



                } catch (LineUnavailableException | IOException e) {
                    e.printStackTrace();
                }

            }
        });

        Thread Coin = new Thread(new Runnable() {
            @Override
            public void run() {


                String path = "coin.wav";

                AudioInputStream audioInputStream =
                        null;
                try {
                    audioInputStream = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
                } catch (UnsupportedAudioFileException | IOException e) {
                    e.printStackTrace();
                }

                // create clip reference

                try {

                    coinClip = AudioSystem.getClip();
                    coinClip.open(audioInputStream);
                    coinClip.stop();
//            coinClip.loop(0);
//            audioPlayer.play();


                } catch (LineUnavailableException | IOException e) {
                    e.printStackTrace();
                }

            }
        });

        back.start();
        Coin.start();
        gameover.start();

        try {
            back.join();
            Coin.join();
            gameover.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void playGameOver () {
        stopBack();
        gameOverClip.start();



        String path = "gameover.wav";

        AudioInputStream audioInputStream =
                null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }

        // create clip reference

        try {

            gameOverClip = AudioSystem.getClip();
            gameOverClip.open(audioInputStream);
            gameOverClip.stop();
//            gameOverClip.loop(0);
//            audioPlayer.play();



        } catch (LineUnavailableException | IOException e) {
            e.printStackTrace();
        }

    }

    public void playStarMusic () {
        coinClip.start();

        String path = "coin.wav";

        AudioInputStream audioInputStream =
                null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }

        // create clip reference

        try {

            coinClip = AudioSystem.getClip();
            coinClip.open(audioInputStream);
            coinClip.stop();
//            coinClip.loop(0);
//            audioPlayer.play();


        } catch (LineUnavailableException | IOException e) {
            e.printStackTrace();
        }

    }

    public void playMusic () {
//        backClip.loop(Clip.LOOP_CONTINUOUSLY);
        if (backClip.isRunning()) {
            return;
        }
        backClip.start();
    }

    private void stopBack () {
        //TODO:
        backClip.stop();
    }

}
