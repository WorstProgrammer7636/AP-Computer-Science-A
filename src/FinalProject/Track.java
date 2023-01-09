package FinalProject;

import javax.imageio.ImageIO;
import java.io.File;
import java.net.URL;
import java.awt.Graphics;
import java.awt.Image;
public class Track extends Block{
    // get x, y, w, h method could be gain from super method.
    private Image image;

    public Track(int x, int y, int w, int h){
        super(x, y, w, h);
        try
        {
            // put url image trak.jpg
            URL url = getClass().getResource("track.jpg");
            image = ImageIO.read(url);
        }
        catch(Exception e)
        {
            //catch exception
            System.out.println("No track image!");
        }
    }
    public void draw(Graphics window){
        window.drawImage(image, super.getX(), super.getY(), super.getWidth(), super.getHeight() ,null);
    }

    public void move(){
        // intended not have a move method
    }

}
