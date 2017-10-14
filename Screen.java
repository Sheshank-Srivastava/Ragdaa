
package ssdn_pro_game.grahics;


public class Screen {
    
    private int width, height;
    public int[] pixels;
    
    int timer =0;
    int counter =0;
    
    public Screen(int width, int height){
        this.width = width;
        this.height = height;
        
        pixels = new int[width * height];
    }
    
    public void clear(){
        for(int i= 0; i < pixels.length;i++){
            pixels[i]=0;
        }
    }
    
    public void render(){
        counter++;
        if(counter%20 == 0){
            timer++;
        }
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                pixels[timer + timer * width] = 0xfffff;
            }
        }
    }
    
}
