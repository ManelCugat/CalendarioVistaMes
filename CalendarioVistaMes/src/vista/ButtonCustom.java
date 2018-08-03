package vista;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class ButtonCustom extends JButton{
	
	private static final long serialVersionUID = 1L;

	public ButtonCustom (String url, String text, int largo, int ancho) {
		
		ImageIcon image = new ImageIcon (url);
		this.setIcon(image);
		this.setFont(new Font("SansSerif",Font.PLAIN,15));
		this.setText(text);
		this.setForeground(Color.WHITE);
		this.setPreferredSize(new Dimension(largo,ancho));
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setOpaque(false);
		this.setBorder(new EmptyBorder(0,0,0,0));
		this.setFocusable(true);
		
	}
	

}
