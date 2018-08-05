package controlador;


import java.awt.event.*;
import modelo.Hora;
import modelo.Month;
import vista.UICalendar;


public class CalendarControl {
	
	private CalendarControlYear mcy;
	private CalendarControlMonth mcm;
	//private MonthControlWindow mcw;
	private Month month;
	private Month newMonth;
	private UICalendar ventanaCalendarioMes;
	private Hora hora;
	
	
	public CalendarControl (Month month, UICalendar uiMonth) {
		
		this.month=month;
		this.ventanaCalendarioMes=uiMonth;
		mcy =  new CalendarControlYear(this);
		mcm =  new CalendarControlMonth(this);
		//mcw = new MonthControlWindow();

	}
	
	public void inicializarCalendario() {
		
		ventanaCalendarioMes.drawMonthFirstTime();
	
	}
	
	public void genenerarNuevoMes (int mes, int year) {
		
		newMonth = new Month (mes,year);
		
	}
	
	public void generaNuevoMes () {
		
		newMonth = new Month();
		
	}
	
	public String generarHora () {
	
		if (hora == null) {
		
			hora = new Hora();
		
		}
		
		String horaGenerada = hora.contruccionHora();
		return horaGenerada;
		
	}
	
	public Month getNewMonth() {
		return newMonth;
	}

	public void setNewMonth(Month newMonth) {
		this.newMonth = newMonth;
	}
	
	public Hora getHora() {
		return hora;
	}

	public void setHora(Hora hora) {
		this.hora = hora;
	}
	
	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month) {
		this.month = month;
	}
	
	
	
	
	public CalendarControlYear getMonthControlYear() {
		
		return mcy;
	
	}
	
	public CalendarControlMonth getMonthControlMonth() {
		
		return mcm;
	}
	
	/*public MonthControlWindow getMonthControlWindow() {
		
		return mcw;
		
	}*/
	

	private class CalendarControlYear implements ActionListener{
		
		
		private CalendarControl calendarControl;
		
		public CalendarControlYear (CalendarControl calendarControl) {
			
			this.calendarControl=calendarControl;
			
		}
		
		public void actionPerformed(ActionEvent e) {
			
			
			int year = Integer.parseInt(ventanaCalendarioMes.getYearText().getText());
			
			String bp = e.getActionCommand();
			
			
			if (bp.equals("<")){
				
				year--;
		
			}else year++;
			
			String m = ventanaCalendarioMes.getMonthText().getText();
			int mes = month.monthToInt(m);
			calendarControl.genenerarNuevoMes(mes, year);
			ventanaCalendarioMes.drawUpdate(calendarControl);
			
		}
		

	}
	
	public class CalendarControlMonth implements ActionListener{
		
		private int year;
		private int mes;
		private CalendarControl calendarControl;
		
		
		public CalendarControlMonth(CalendarControl calendarControl) {
			
			this.calendarControl=calendarControl;
		}

		public void actionPerformed(ActionEvent e) {

			year = Integer.parseInt(ventanaCalendarioMes.getYearText().getText());
			String m = ventanaCalendarioMes.getMonthText().getText();
			mes = month.monthToInt(m);
			String bp = e.getActionCommand();
			
			if (bp.equals("<")){
				
				mes --;
				
				if (mes<0){
					
					mes = 11;
					year--;
				
				}
				
				actualizaMes (mes,year);
			
			}
					
				
			if (bp.equals(">")) {
				
				mes ++;
					
				if (mes>11) {
					
					mes = 0;
					year++;
				
				}
				
				actualizaMes (mes,year);

			}
			
			
			if (bp.equals("")) {
				
				actualizaMes();
				
			}
			
		
			
		}
		
		public void actualizaMes() {
			
			calendarControl.generaNuevoMes();
			ventanaCalendarioMes.drawUpdate(calendarControl);
			System.out.println("actualizo mes blanco");
			
		}
		
		public void actualizaMes(int mes, int year) {
			
			calendarControl.genenerarNuevoMes(mes, year);
			ventanaCalendarioMes.drawUpdate(calendarControl);
			System.out.println("actualizo mes tocadas flechas");
			
		}
		
	}
		
		
	/*private class MonthControlWindow implements WindowListener{


		public void windowActivated(WindowEvent e) {
			
		}

		public void windowClosed(WindowEvent e) {}
		public void windowClosing(WindowEvent e) {}
		public void windowDeactivated(WindowEvent e) {}
		public void windowDeiconified(WindowEvent e) {}
		public void windowIconified(WindowEvent e) {}
		public void windowOpened(WindowEvent e) {}
		
	
	}*/
		
		
		
	}
	