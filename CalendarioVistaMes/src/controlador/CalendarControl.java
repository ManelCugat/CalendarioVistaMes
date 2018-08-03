package controlador;


import java.awt.event.*;
import modelo.Hora;
import modelo.Month;
import vista.UICalendar;


public class CalendarControl {
	
	private CalendarControlYear mcy;
	private CalendarControlMonth mcm;
	private MonthControlWindow mcw;
	private Month month;



	private UICalendar ventanaCalendarioMes;
	private Hora hora;
	


	public CalendarControl(Month month, UICalendar uiMonth) {
		
		this.month=month;
		this.ventanaCalendarioMes=uiMonth;
		this.ventanaCalendarioMes.setCalendarControl(this);
		this.month.setCalendarControl(this);
		mcy =  new CalendarControlYear();
		mcm =  new CalendarControlMonth();
		mcw = new MonthControlWindow();
		uiMonth.drawMonthFirstTime();
		
	}
	
	public String generarHora () {
	
		hora = new Hora ();
		String horaGenerada = hora.contruccionHora();
		return horaGenerada;
		
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
	
	
	public CalendarControl () {
		

		mcy =  new CalendarControlYear();
		mcm =  new CalendarControlMonth();
		
	}
	
	public CalendarControlYear getMonthControlYear() {
		
		return mcy;
	
	}
	
	public CalendarControlMonth getMonthControlMonth() {
		
		return mcm;
	}
	
	public MonthControlWindow getMonthControlWindow() {
		
		return mcw;
		
	}
	
	
	private class CalendarControlYear implements ActionListener{
		
		public CalendarControlYear() {
			
		}
		
		public void actionPerformed(ActionEvent e) {
			
			
			int year = Integer.parseInt(ventanaCalendarioMes.getYearText().getText());
			
			String bp = e.getActionCommand();
			
			
			if (bp.equals("<")){
				
				year--;
		
			}else year++;
			
			String m = ventanaCalendarioMes.getMonthText().getText();
			int mes = month.monthToInt(m);
			Month newMonth = new Month (mes,year);
			ventanaCalendarioMes.drawUpdate(newMonth);
			
		}

		
	}
	
	public class CalendarControlMonth implements ActionListener{
		
		int year;
		int mes;
		
		
		public CalendarControlMonth() {
			
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
			
			Month newMonth = new Month ();
			ventanaCalendarioMes.drawUpdate(newMonth);
			
		}
		
		public void actualizaMes(int mes, int year) {
			
			Month newMonth = new Month (mes,year);
			ventanaCalendarioMes.drawUpdate(newMonth);
			
		}
		
	}
		
		
	private class MonthControlWindow implements WindowListener{


		public void windowActivated(WindowEvent e) {
			
		}

		public void windowClosed(WindowEvent e) {}
		public void windowClosing(WindowEvent e) {}
		public void windowDeactivated(WindowEvent e) {}
		public void windowDeiconified(WindowEvent e) {}
		public void windowIconified(WindowEvent e) {}
		public void windowOpened(WindowEvent e) {}
		
	
	}
		
		
		
	}
	

