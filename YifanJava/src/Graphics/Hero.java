package Graphics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Hero {

	BufferedImage sprite;
	String name;
	int x;
	int y;
	
	public Hero(String name, String imageLocation, int locationX, int locationY) {
		// TODO Auto-generated constructor stub
		this.name = name;
		int width =50;
		int height =60;
		x = locationX;
		y = locationY;
		sprite = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
//		"/images/heroes/Doraemon.jpg" WE USE URL BECAUSE IT;S A READ ONLY 
		URL url = getClass().getResource(imageLocation);
		try
		{
			BufferedImage original = ImageIO.read(url);
			//draw the image file into a scaled version on the sprite canvas
			Graphics2D g = (Graphics2D) sprite.getGraphics();
			int w = original.getWidth();
			int h = original.getHeight();
			//what to draw, where to start(x,y), width of canvas & height of canvas (relative to start), 
			//where to start from original (x,y), width of original, height null 
			g.drawImage(original,0,0,width,height,0,0,w,h,null);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public BufferedImage getImage(){
		return sprite;
	}
	public String getName(){
		return name;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void moveUp(){
		y=y-10;
	}
	public void moveDown(){
		y=y+10;
	}
	public void moveLeft(){
		x=x-10;
	}
	public void moveRight(){
		x=x+10;
	}
}
