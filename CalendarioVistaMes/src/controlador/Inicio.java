package controlador;

import modelo.Month;

public class Inicio {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		Month month = new Month();
		CalendarControl mc = new CalendarControl(month);
	
	}

}
