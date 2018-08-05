package controlador;

import modelo.Month;
import vista.UICalendar;

public class Inicio {

	public static void main(String[] args) {

		Month month = new Month();
		UICalendar ventana = new UICalendar();
		CalendarControl mc = new CalendarControl(month, ventana);
		
		month.setCalendarControl(mc);
		ventana.setCalendarControl(mc);
		
		mc.inicializarCalendario();
		
	
	}

}
