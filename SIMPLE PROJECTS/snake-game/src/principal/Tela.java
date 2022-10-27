package principal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JPanel;
import campo.Posicao;
import campo.Fruta;
import java.awt.image.BufferedImage;
import personagem.Snake;
import java.util.Random;
import javax.imageio.ImageIO;
import java.io.File;


public class Tela extends JFrame implements KeyListener {

    JPanel painel = null;
    
    public static BufferedImage fundo = null;
   
      
    personagem.Snake snake = new personagem.Snake(380,300); // onde a cobra começa
    BufferedImage cobra = null;
    BufferedImage frutaimg = null;
    Fruta fruta = null;
    String nextmove = null;
   
    Thread thread = null;
        
	public Tela() {	                
		super("SNAKE");
                
     try{fundo = ImageIO.read(new File("fundoimg.png"));}catch(Exception e){}
                
        Random rng = new Random();
		setSize(800, 600);
                snake.Setinicio(380,300);// onde a cobra restarta(de preferência o mesmo de onde ela começa)       
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
		painel = new JPanel();
                
		getContentPane().add(painel);	
                
		addKeyListener(this);   
                
                
                        
        fruta = new Fruta(20*rng.nextInt(38)+20,20*rng.nextInt(26)+40);
        
         thread =  new Thread(new Runnable() {
         public void run() {             
            try { 
                for(snake.speed = 0;; snake.speed++){  
                  
                    if(snake.speed<80){                        
                        Thread.sleep(400);
                            andar(snake.proximadirecao);                        
                    }
                    if(snake.speed>=80 && snake.speed<200){
                        Thread.sleep(300);
                            andar(snake.proximadirecao);
                    }
                    if(snake.speed>=200){
                        Thread.sleep(270); 
                            andar(snake.proximadirecao);
                    }
                  }
                                   
                } catch (Exception ex) {
                     ex.printStackTrace();
                }
         }
        });
                 thread.start();
        
	}

	public void desenhar( Graphics g ){
                if(fruta.x == snake.cabecaCobra.x && fruta.y == snake.cabecaCobra.y){
                    snake.tamanho++;
                    snake.corpoCobra.add( new Posicao(snake.corpoCobra.get(snake.corpoCobra.size()-1).x,snake.corpoCobra.get(snake.corpoCobra.size()-1).y)); 
                    fruta.novaFruta(1);
                    for(int i = 0;i<snake.corpoCobra.size();i++){
                       
                        if((fruta.y == snake.corpoCobra.get(i).y)&& (fruta.x == snake.corpoCobra.get(i).x)){
                            fruta.novaFruta(1);
                        }
                    }
                }
                   
		frutaimg = Fruta.getImagem();
		cobra = snake.getImagem();
		Graphics gPainel = painel.getGraphics();
		
		gPainel.clearRect(0, 0, getWidth(), getHeight());
		
                desenharBordasimg(g);
                
        g.drawImage(frutaimg, fruta.x, fruta.y, null);
       
        
	     
        g.drawImage(cobra,snake.cabecaCobra.x, snake.cabecaCobra.y, null);
        snake.corpoCobra.forEach((posicao) -> desenharCorpo(posicao, g)); 	 
	
		}
        
        public void desenharBordasimg(Graphics g){
            g.drawImage(fundo, 0, 0, null);
        }
        
        public void desenharCorpo(Posicao posicao, Graphics g){
            g.drawImage(snake.corpo,posicao.x, posicao.y, null);
        }
	
        public void paint(Graphics g) {
		  desenhar(g);
	    }

        public void update(Graphics g) {
		  desenhar(g);
	    }

	 	public void adicionarCorpo(){
              if(snake.corpoCobra.size() <= snake.tamanho)
              {
            	  snake.corpoCobra.add( new Posicao(snake.cabecaCobra.x,snake.cabecaCobra.y)); 
              }else{
                  snake.corpoCobra.get(snake.corpoCobra.size() - 1).x = snake.cabecaCobra.x;
                  snake.corpoCobra.get(snake.corpoCobra.size() - 1).y = snake.cabecaCobra.y;
                  if(snake.tamanho>=1){
                    for(int i = 1; i<snake.corpoCobra.size();i++){
                    snake.corpoCobra.get(i-1).x = snake.corpoCobra.get(i).x;
                    snake.corpoCobra.get(i-1).y = snake.corpoCobra.get(i).y;
                    }
                  }
              }
          }
          
	@Override
	public void keyPressed(KeyEvent e) {
                
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
           
                if(snake.direcao != "oeste")
                snake.proximadirecao = "leste";
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
           
                if(snake.direcao != "leste")
                snake.proximadirecao = "oeste";            
        }
	if (e.getKeyCode() == KeyEvent.VK_UP) {
            
                if(snake.direcao != "sul")
                snake.proximadirecao = "norte";            
        }
	if (e.getKeyCode() == KeyEvent.VK_DOWN) {
           
                if(snake.direcao != "norte")
                snake.proximadirecao = "sul";   
        }
       
        
        }
        
        
        
        public void andar(String direcao){
            if(direcao == "norte"){
                if (snake.cabecaCobra.y > 40)//não passar da borda superior
                {
                    adicionarCorpo();
                    snake.cabecaCobra.y-=20;
                    repaint();
                }else
                {
                // jogo.morreu();
                //scoreboard.add(this.score);//implementações futuras
                    snake.reset();
                }
            }else if(direcao == "leste"){
                if (snake.cabecaCobra.x < 760)  //não passar da borda direita                  
                {
                
                    adicionarCorpo();
                    snake.cabecaCobra.x+=20;
                    repaint();
                }else
                 {
                // jogo.morreu();
                //scoreboard.add(this.score);//implementações futuras
                 snake.reset();
                 }
            }else if(direcao == "oeste"){
                  if (snake.cabecaCobra.x > 20) //não passar da borda esquerda
                {
                    adicionarCorpo();
                    snake.cabecaCobra.x-=20 ;
                    repaint();
                }else
                 {
                // jogo.morreu();
                //scoreboard.add(this.score);//implementações futuras
                snake.reset();
                }
            }else if(direcao == "sul"){
                 if (snake.cabecaCobra.y < 560) //não passar da borda inferior
                 {
                    adicionarCorpo();
                    snake.cabecaCobra.y+=20;
                    repaint();
                 }else
                 {
                 // jogo.morreu();
                 //scoreboard.add(this.score); //implementações futuras
                 snake.reset();
                 }
            }
             for(int i = 0; i < (snake.corpoCobra.size() - 1); i++){
            if((snake.cabecaCobra.x == snake.corpoCobra.get(i).x) && (snake.cabecaCobra.y == snake.corpoCobra.get(i).y))
                snake.reset();
        }
        }
	
	@Override
	public void keyReleased(KeyEvent e) {
	
		}

	@Override
	public void keyTyped(KeyEvent e) {}

    private void desenharBordas(Graphics g) {
         int x = 0;
         int y = 0;
        
        for(y = 0; y < 800; y+=20) {
			g.drawLine(y, 0, y, 600);
	        g.setColor(Color.lightGray);
	     
	         //LIMITE VISUAL
	        if(y <= 0) {
		         g.setColor(Color.black);
	        }
	         
	        if(y == 760 && x <= 750) {
	        	 g.setColor(Color.black);
	        }
		 }
	        
	     for(x = 0;  x < 600; x+=20) {
	        g.drawLine(0, x, 800, x);
	        g.setColor(Color.lightGray);
	        	
	      //LIMITE VISUAL
	        if(x <= 20) {
	        	g.setColor(Color.black);
	        }
	        	
	        if(x == 560 && y <= 800) {
	        	g.setColor(Color.black);
		    }
	        	
	     }
    }
	
}
