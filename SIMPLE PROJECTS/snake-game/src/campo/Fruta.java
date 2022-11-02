
package campo;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;


public class Fruta extends Posicao{
    public static BufferedImage frutinha = null;
  
    public Fruta(int x, int y) {
    	super(x, y);
    	//System.out.println("Fruta: "+ x+" , "+y);
    
    	
        try{
            frutinha = ImageIO.read(new File("fruta.png"));
        }catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public void novaFruta(int quantas){
        
   	Random rng = new Random(); //usar rng para Random padrão
   	for(int i = 0; i < quantas; i++) {
        x= 20*rng.nextInt(38)+20;
        y= 20*rng.nextInt(26)+40;
        
        //easy debug settings:
        //x= 20*rng.nextInt(5)+20+100;
        //y= 20*rng.nextInt(5)+40+100;
    	
    	//System.out.println("Fruta: "+ x+" , "+y);
    	}
    }
    
     public static BufferedImage getImagem()
    {
        return frutinha;
    }
    
}
