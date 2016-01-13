package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class MyWindow extends JFrame implements KeyListener{

	int width = 500;
	int height = 500;
	BufferedImage landscape;
	Boolean itemPickedUp;
	Hero hero1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyWindow();
	}
	public MyWindow(){
		//the following are JFrammethods
		hero1 = new Hero("Doraemon", "/images/heroes/Doraemon.jpg",200,200);
		landscape = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 =(Graphics2D)landscape.getGraphics();
		//paintLandscape(g2);
		itemPickedUp = false;
		setVisible(true);
		setSize(width,height); //units in px
		setLocation(200,150);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //static constant reference for special close operation
		addKeyListener(this);
	}
	
	public void paint(Graphics g){ //Graphics is a crayon box; Graphics2d is like an art kit
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D)image.getGraphics();
		//Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.white);
		g2.fillRect(0,0,width,height);
		g2.setColor(Color.pink);
		g2.drawOval(50, 50, width-100, height-100);
		g2.drawOval(175, 175, width-490, height-490);
		g2.drawOval(375, 175, width-490, height-490);
		g2.drawLine(0,10,height,0);
		g2.drawArc(175, 250, 250, 130, 200, 90);
		Hero hero2 = new Hero("Dorami", "/images/heroes/Dorami.jpg",100,100);

		if(Math.abs(hero1.getX()-hero2.getX()) + Math.abs(hero1.getY()-hero2.getY()) <20  ){
			itemPickedUp=true;
		}
		if(!itemPickedUp){g2.drawImage(hero2.getImage(), hero2.getX(), hero2.getY(), null);}
		g2.drawImage(hero1.getImage(), hero1.getX(), hero1.getY(), null);
		//g2.fillOval(50,100,200,100);
		//g2.drawArc(50, 300, 200, 100,0,90);
	/*	int c =0;
		int margin =2;
		int squareD =20;
		for(int x=0; x<width; x+= squareD +margin){
			for(int y=0; y<height; y+= squareD+margin){
				if(c<255) c++;
				else c=0;
				Color local = new Color((int) Math.floor(Math.random() * 256),(int) Math.floor(Math.random() * 256),c);
				g2.setColor(local);
				g2.fillRect(x,y,squareD,squareD);
			}
		}*/
		g.drawImage(image, 0, 0, null);
	}
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int key =arg0.getKeyCode();
		if(key ==KeyEvent.VK_UP){
			hero1.moveUp();
		}
		else if(key ==KeyEvent.VK_DOWN){
			hero1.moveDown();
		}
		else if(key ==KeyEvent.VK_LEFT){
			hero1.moveLeft();
		}
		else if(key ==KeyEvent.VK_RIGHT){
			hero1.moveRight();
		}
		repaint();
	}
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
