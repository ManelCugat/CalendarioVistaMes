package vista;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class LaminaCustom extends JPanel{
	
	private String url;
	
	private static final long serialVersionUID = 1L;

	public LaminaCustom(String url, int x, int y) {
		
		this.setMinimumSize(new Dimension(x,y));
		this.url=url;
	
	}
	
	public void paintComponent (Graphics g) {
		
		super.paintComponent(g);
		
		Dimension dimension = this.getSize();
		ImageIcon img = new ImageIcon (url);
		g.drawImage(img.getImage(), 0, 0, dimension.width, dimension.height, null);
		this.setOpaque(false);
	
	}

}
