/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssdn_pro_game.grahics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Sprite_sheet {
    private String path;

    final int SIZE;
    public int[] pixels;
    public static Sprite_sheet tile = new Sprite_sheet("E:\\guru tagh bahadur\\java\\practice java\\SSDN_PRO_GAME\\res\\texture\\Sprite-1.png", 256);
    
    public Sprite_sheet(String path, int size){
        this.path= path;
        SIZE= size;
        pixels = new int [size*size];
    }
    
    private void loadImage() throws IOException{
        BufferedImage image =ImageIO.read(Sprite_sheet.class.getResource(path));
        int w = image.getWidth(),h=image.getHeight();
        image.getRGB(0 , 0, w, h, pixels, 0, w);
        
    }
    
}
