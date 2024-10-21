
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Just4Fun extends JPanel {
  private BufferedImage image;
  
  public Just4Fun() {
	  image = new BufferedImage(100,100, BufferedImage.TYPE_INT_ARGB); // tao man anh
	  Graphics2D g2d = image.createGraphics(); //tao but ve
	  g2d.setColor(Color.RED);
	  g2d.fillRect(10,10,50,50); // Ve len anh
	  g2d.dispose();
  }
  
  @Override
  protected void paintComponent(Graphics g) { //Ve noi dung len JPanel
	  super.paintComponent(g);
	  g.drawImage (image, 50,50,null); // ve anh len JPanel
  }
   public static void main (String[] args) {
	   JFrame jframe = new JFrame("Just 4 Fun");
	   jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   jframe.setSize(200,200);
	   jframe.add(new Just4Fun());
	   jframe.setVisible(true);
   }
    
}

