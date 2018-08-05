package controlador;

import modelo.Month;
import vista.UICalendar;

public class Inicio {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		Month month = new Month();
		UICalendar uiMonth = new UICalendar();
		CalendarControl mc = new CalendarControl(month, uiMonth);
	
	}

}
