
package ssdn_pro_game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import ssdn_pro_game.grahics.Screen;

public class Game extends Canvas implements Runnable {

    public static int width = 300; 
    public static int height = width / 16 * 9;
    public static int scale =3;
    
    private Thread thread;
    private boolean running = false;
    
    private BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
    
    private final JFrame frame;
    private Screen screen;
   
    public Game () {
        Dimension size = new Dimension(width * scale , height * scale);
        setPreferredSize(size);
        screen = new Screen(width,height);
        frame = new JFrame();
        
    }
    
    public synchronized void start(){
        running = true;
        thread = new Thread(this,"Display");
        thread.start();
    }
   
    public synchronized void stop(){
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        while(running){
           update();
           render();
        }
    }
    
    public void update(){
        
        
    }
    
    public void render(){
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);
            return;
        }
        screen.clear();
        screen.render();
        
        for(int i = 0; i < pixels.length; i++){
            pixels[i]=screen.pixels[i];
        }
        
        Graphics g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, getWidth(), getHeight(),null);
                
        g.dispose();
        bs.show();
    }
    
    public static void main(String[] args) {
        Game game = new Game();
        game.frame.setResizable(false);
        game.frame.setTitle("Remble with GODS");
        game.frame.add(game);
        game.frame.pack();
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.frame.setLocationRelativeTo(null);
        game.frame.setVisible(true);
        
        game.start();
    }
}
