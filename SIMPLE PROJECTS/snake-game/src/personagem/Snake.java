package personagem;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import campo.Posicao;
import java.awt.BorderLayout;
import java.util.ArrayList;
import campo.Fruta;
import javax.swing.JOptionPane;


import javax.imageio.ImageIO;
import principal.Savegame;

public class Snake {
    public int tamanho = 1;
    public static ArrayList<Posicao> corpoCobra = new ArrayList();
    public static Posicao cabecaCobra = new Posicao(0,0);
    public static BufferedImage norte = null;
    public static BufferedImage leste = null;
    public static BufferedImage sul = null;
    public static BufferedImage oeste = null;
    public static BufferedImage corpo = null;
    public static String direcao = null; 
    public static String proximadirecao = null; 
    public static int speed = 0;
    Savegame savegame = new Savegame();
    
    private Posicao inicio = new Posicao(0,0);
        
    public void Setinicio(int x, int y){
        inicio.x = x;
        inicio.y = y; 
    }
  
    public Snake(int x,int y) {      //usaremos sempre x DEPOIS y por padrão
      
        cabecaCobra = new Posicao(x,y);
        
        try {
            norte = ImageIO.read(new File("snake_n.png"));
            leste = ImageIO.read(new File("snake_l.png"));
            sul = ImageIO.read(new File("snake_s.png"));
            oeste = ImageIO.read(new File("snake_e.png"));
            corpo = ImageIO.read(new File("snake_body.png"));
        }
        
        catch (IOException e) {
            System.out.println(e);
        }
    }
    

    public BufferedImage getImagem()
    {
        Posicao ultimosqm = null;
        if(corpoCobra.isEmpty()){
            direcao = "norte";
            proximadirecao = "norte";
            return norte;
        }            
        else{            
        ultimosqm = new Posicao(corpoCobra.get(corpoCobra.size() - 1).x,corpoCobra.get(corpoCobra.size() - 1).y);
        //System.out.println(cabecaCobra.x + " , " + cabecaCobra.y);
        if((ultimosqm.x == cabecaCobra.x) && (ultimosqm.y == cabecaCobra.y))
            System.out.println("erro: cobra desincronizada");
        }  
            
         if((ultimosqm.x < cabecaCobra.x) && (ultimosqm.y == cabecaCobra.y)){
             direcao = "leste";
             return leste;            
         }else 
         if((ultimosqm.x > cabecaCobra.x) && (ultimosqm.y == cabecaCobra.y)){
             direcao = "oeste";
             return oeste; 
         }else
         if((ultimosqm.x == cabecaCobra.x) && (ultimosqm.y < cabecaCobra.y)){
             direcao = "sul";
            return sul; 
         }else
             direcao = "norte";
        return norte;
    }
    
    public void reset()
    {
        speed = 0;
        
        if(tamanho> savegame.getHighscore()){
        JOptionPane.showMessageDialog(null, "Seu tamanho: " + tamanho + "\n" +
                "Novo Record!");
        String nome = JOptionPane.showInputDialog("Digite o seu Apelido:");  
        savegame.Salvar(nome,Integer.toString(tamanho));
        }else{
            String mensagem = "Seu tamanho: " + tamanho + "\n" + 
                    "Tamanho record: "+ savegame.getHighscore()+ " de "+ savegame.getNome();
            JOptionPane.showMessageDialog(null, mensagem);
        }       
        
        cabecaCobra.x = inicio.x;
        cabecaCobra.y = inicio.y;
        corpoCobra.clear();
        tamanho = 1;
    }
}


