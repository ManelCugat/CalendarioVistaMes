package vista;

import java.awt.*;
import javax.swing.*;
import controlador.CalendarControl;

public class UICalendar implements Runnable{
	
	private CalendarControl calendarControl;
	private JFrame marco;
	private LaminaCustom laminaPrincipal;
	private JPanel laminaSuperior;
	private JPanel laminaOeste;
	private JPanel laminaCentral; 
	private JPanel laminaInferior;
	private TextFieldCustom yearText;
	private TextFieldCustom monthText;
	private TextFieldCustom hourText;
	private Thread hiloHora;
	
	
	public UICalendar () {	
		
	}
	
	
	public void drawMonthFirstTime () {

		generarVentana();
		generarOpcionesSuperiores(laminaSuperior);
		monthText.setText(getCalendarControl().getMonth().getMesesAno()[getCalendarControl().getMonth().getMonth()]);
		yearText.setText(Integer.toString(getCalendarControl().getMonth().getYear()));
		generarCuadriculaMesInicial (laminaCentral,calendarControl);
		generarCuadriculaNumeroSemanasInicial(laminaOeste,calendarControl);
		visualizarHora(laminaInferior);
		marco.add(laminaPrincipal);
		visualizarVentana ();
		hiloHora =  new Thread(this);
		hiloHora.start();
		
		/*System.out.println("Lámina Central: " + laminaPrincipal.getSize());
		System.out.println("Lámina Superior: " + laminaSuperior.getSize());
		System.out.println("Lámina inferior: " + laminaInferior.getSize());*/

	}
	
	public void drawUpdate(CalendarControl calendarControl) {
				
		monthText.setText(calendarControl.getNewMonth().getMesesAno()[calendarControl.getNewMonth().getMonth()]);
		yearText.setText(Integer.toString(calendarControl.getNewMonth().getYear()));
		generarCuadriculaMesUpdate (laminaCentral,calendarControl);
		generarCuadriculaNumeroSemanasUpdate(laminaOeste,calendarControl);
		visualizarHora(laminaInferior);
		marco.add(laminaPrincipal);
		visualizarVentana ();
		
	}
	

	private void generarVentana () {
		
		marco = new JFrame("Calendario");
		marco.setBounds(300, 300, 340, 220);

		laminaPrincipal = new LaminaCustom("src/vista/Calendar_correct_size.png",0,0);
		laminaPrincipal.setLayout(new BorderLayout());
		laminaSuperior = new LaminaOpaca();
		laminaSuperior.setLayout(new FlowLayout());
		laminaCentral = new LaminaOpaca();
		laminaOeste = new LaminaOpaca();
		laminaInferior = new LaminaOpaca();
		laminaPrincipal.add(laminaOeste,BorderLayout.WEST);
		laminaPrincipal.add(laminaSuperior, BorderLayout.NORTH);
		laminaPrincipal.add(laminaCentral, BorderLayout.CENTER);
		laminaPrincipal.add(laminaInferior,BorderLayout.SOUTH);
		
		
	}
		
	
	private void generarOpcionesSuperiores(JPanel laminaSuperior) {
		
		
		JSeparator separador = new JSeparator();
		separador.setPreferredSize(new Dimension(30, 0));
		
		ButtonCustom botonFlechaIzquierda = new ButtonCustom(null,"<",15,20);
		yearText = new TextFieldCustom ("",3,18);
		ButtonCustom botonFlechaDerecha = new ButtonCustom(null,">",15,20);
		
		botonFlechaIzquierda.addActionListener(calendarControl.getMonthControlYear());
		botonFlechaDerecha.addActionListener(calendarControl.getMonthControlYear());
	
		ButtonCustom botonFlechaIzquierda2 = new ButtonCustom(null,"<",15,20);
		monthText = new TextFieldCustom ("",6,15);
		ButtonCustom botonFlechaDerecha2 = new ButtonCustom(null,">",15,20);
		
		JSeparator separador2 = new JSeparator();
		separador2.setPreferredSize(new Dimension(44, 0));
		
		ButtonCustom botonHoy =  new ButtonCustom (null,"",25,22);

				
		botonFlechaIzquierda2.addActionListener(calendarControl.getMonthControlMonth());
		botonFlechaDerecha2.addActionListener(calendarControl.getMonthControlMonth());
		
		botonHoy.addActionListener(calendarControl.getMonthControlMonth());
		
		
		laminaSuperior.add(botonFlechaIzquierda);
		laminaSuperior.add(yearText);
		laminaSuperior.add(botonFlechaDerecha);
		
		laminaSuperior.add(separador);
		
		laminaSuperior.add(botonFlechaIzquierda2);
		laminaSuperior.add(monthText);
		laminaSuperior.add(botonFlechaDerecha2);
		
		laminaSuperior.add(separador2);
		
		laminaSuperior.add(botonHoy);
		
	}
	
	
	private void generarLaminaCuadriculaMes (JPanel laminaCentral) {
		
		GridLayout grid = new GridLayout(7,7);
		laminaCentral.removeAll();		
		laminaCentral.setLayout(grid);
		laminaCentral.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
	}

	private void generarCuadriculaMesInicial (JPanel laminaCentral, CalendarControl calendarControl) {
		
		generarLaminaCuadriculaMes (laminaCentral);
		generarMesInicial(laminaCentral, calendarControl);
		
	}
	
	private void generarCuadriculaMesUpdate (JPanel laminaCentral, CalendarControl calendarControl) {
		
		
		generarLaminaCuadriculaMes (laminaCentral);
		generarMesUpdate(laminaCentral, calendarControl);
		
	}
	
	private void generarLaminaCuadriculaNumeroSemanas (JPanel laminaOeste) {
		
		GridLayout grid = new GridLayout(7,1);
		laminaOeste.removeAll();
		laminaOeste.setLayout(grid);
	
	}
	
	private void generarCuadriculaNumeroSemanasInicial (JPanel laminaOeste, CalendarControl calendarControl) {
		
		generarLaminaCuadriculaNumeroSemanas (laminaOeste);

		for (String s: calendarControl.getMonth().numberWeekToDraw()) {
			
			TextFieldCustom tf = new TextFieldCustom (s,2,10);
			laminaOeste.add(tf);
			
		}
		

	}

	
	private void generarCuadriculaNumeroSemanasUpdate (JPanel laminaOeste, CalendarControl calendarControl) {
		
		
		generarLaminaCuadriculaNumeroSemanas (laminaOeste);
		
		for (String s: calendarControl.getNewMonth().numberWeekToDraw()) {
			
			TextFieldCustom tf = new TextFieldCustom (s,2,10);
			laminaOeste.add(tf);
			
		}
		
	}
	
	
	private void visualizarHora (JPanel laminaInferior) {
		
		if (hourText==null) {
		
		hourText = new TextFieldCustom ("",10,12);
		
		}
		
		laminaInferior.setLayout(new FlowLayout(SwingConstants.RIGHT));
		hourText.setText(getCalendarControl().generarHora());	
		laminaInferior.add(hourText);
		
	}
	
	private void actualizarFecha() {
		
		hourText.setText(null);
		hourText.setText(getCalendarControl().generarHora());
		
	}
	
	private void generarMesInicial (JPanel laminaCentral, CalendarControl calendarControl) {
		
		for (String a:calendarControl.getMonth().monthToDraw()) {
			
			TextFieldCustom tf = new TextFieldCustom(a,1,16);
			
			if (calendarControl.getMonth().isCourrentMonth()&&calendarControl.getMonth().toDay().equals(a)) {
				
				tf.setForeground(Color.RED);
			};

			laminaCentral.add(tf);
		}
		
	}
	
	
	
	private void generarMesUpdate (JPanel laminaCentral, CalendarControl calendarControl) {
		
		for (String a:calendarControl.getNewMonth().monthToDraw()) {
			
			TextFieldCustom tf = new TextFieldCustom(a,1,16);
			
			if (calendarControl.getNewMonth().isCourrentMonth()&&calendarControl.getNewMonth().toDay().equals(a)) {
				
				tf.setForeground(Color.RED);
			};

			laminaCentral.add(tf);
		}
		
	}
	
	
	private void visualizarVentana () {
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
		//marco.addWindowListener(calendarControl.getMonthControlWindow());
		
	}
	

	public void run() {
		
		while (true) {
			
			actualizarFecha();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (getCalendarControl().getHora().cambioDia()) {
				calendarControl.getMonthControlMonth().actualizaMes();				
			}
			
		}
	
	}
	
	public JTextField getYearText() {
		return yearText;
	}

	public void setYearText(TextFieldCustom monthText) {
		this.yearText = monthText;
	}
	
	public JTextField getMonthText() {
		return monthText;
	}

	public void setMonthText(TextFieldCustom monthText) {
		this.monthText = monthText;
	}
	
	public CalendarControl getCalendarControl() {
		return calendarControl;
	}

	public void setCalendarControl(CalendarControl mc) {
		this.calendarControl = mc;
	}

}
