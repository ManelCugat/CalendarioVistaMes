package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TextFieldCustom extends JTextField{
	
	private static final long serialVersionUID = 1L;

	public TextFieldCustom (String texto, int columnas, int fontSize) {
		
		this.setText(texto);
		this.setColumns(columnas);
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setOpaque(false);
		this.setBorder(new EmptyBorder(0,0,0,0));
		this.setFocusable(false);
		this.setFont(new Font ("SansSerif",Font.PLAIN,fontSize));
		this.setForeground(Color.white);
		
	}
	
	

}
