package controlador;

import java.awt.event.*;

import modelo.Month;
import vista.UICalendar;


public class CalendarControl {
	
	CalendarControlYear mcy;
	CalendarControlMonth mcm;
	MonthControlWindow mcw;
	Month month;
	UICalendar uiMonth;
	
	public CalendarControl(Month month) {
		
		this.month=month;
		mcy =  new CalendarControlYear();
		mcm =  new CalendarControlMonth();
		mcw = new MonthControlWindow();
		uiMonth = new UICalendar(this);
		uiMonth.drawMonthFirstTime(month);
		
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
			
			
			int year = Integer.parseInt(uiMonth.getYearText().getText());
			
			String bp = e.getActionCommand();
			
			
			if (bp.equals("<")){
				
				year--;
		
			}else year++;
			
			String m = uiMonth.getMonthText().getText();
			int mes = month.monthToInt(m);
			Month newMonth = new Month (mes,year);
			uiMonth.drawUpdate(newMonth);
			
		}

		
	}
	
	public class CalendarControlMonth implements ActionListener{
		
		int year;
		int mes;
		
		
		public CalendarControlMonth() {
			
		}

		public void actionPerformed(ActionEvent e) {

			year = Integer.parseInt(uiMonth.getYearText().getText());
			String m = uiMonth.getMonthText().getText();
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
			uiMonth.drawUpdate(newMonth);
			
		}
		
		public void actualizaMes(int mes, int year) {
			
			Month newMonth = new Month (mes,year);
			uiMonth.drawUpdate(newMonth);
			
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
	

