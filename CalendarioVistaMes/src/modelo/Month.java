package modelo;

import java.util.*;

import controlador.CalendarControl;


public class Month {
	
	private CalendarControl calendarControl;
	private ArrayList <Day> monthCalendar;
	private Calendar calendar;
	private String [] diasSemana = {"Lu","Ma","Mi","Ju","Vi","Sa","Do"};
	private String [] mesesAno = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
	private int month;
	private int year;
	private static int posicionesMaximas=48;
	private int numberDayOfMonth;
	private int diaInicioSemana;
	private int numberOfYearWeek;
	private ArrayList <String> numberOfweeks = new ArrayList <String>();


	public Month () {
		
		Day day = new Day();
		calendar = Calendar.getInstance();
		calendar.setTime(day.getDay());
		month = calendar.get(Calendar.MONTH);
		numberDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		year = calendar.get(Calendar.YEAR);
		calendar.set(year, month, 0);
		diaInicioSemana = calendar.get(Calendar.DAY_OF_WEEK);
		setMonthCalendar(generateMonth (month, numberDayOfMonth, year));

	
	}
	
	public Month (int month, int year) {
		
		this.year=year;
		this.month=month;
		calendar = Calendar.getInstance();
		calendar.set(year, month,1);
		numberDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(year, month, 0);
		diaInicioSemana = calendar.get(Calendar.DAY_OF_WEEK);
		setMonthCalendar(generateMonth (month, numberDayOfMonth, year));
		
	}
	
	private ArrayList <Day> generateMonth (int month, int numberDayOfMonth, int year){
		
		ArrayList <Day> days = new ArrayList<Day>();
		
		calendar.set(year, month, 1);
		numberOfYearWeek = calendar.get(Calendar.WEEK_OF_YEAR);
		int n=0;
		
		numberOfweeks.add(Integer.toString(numberOfYearWeek));
		
		for (int i=1;i<=numberDayOfMonth;i++) {

			Day day = new Day ();
			calendar.set(year,month,i);
			n=calendar.get(Calendar.WEEK_OF_YEAR);
			
			if (numberOfYearWeek!=n) {
				
				numberOfYearWeek=n;
				numberOfweeks.add(Integer.toString(numberOfYearWeek));

			}
				
			day.setDay(calendar.getTime());
			days.add(day);
		
		}
		
		
		return days;
		
	}
	
	public ArrayList<String> monthToDraw (){
	
		ArrayList <String> monthToDraw = new ArrayList<String>();
		ListIterator <Day> listIterator = getMonthCalendar().listIterator();

		for (int i=0;i<=6;i++) {
			
			monthToDraw.add(diasSemana[i]);
		
		}
		
		while (diaInicioSemana>1) {
			
			monthToDraw.add("");
			diaInicioSemana--;
		
		}
		
		while (listIterator.hasNext()) {
			
			calendar.setTime(listIterator.next().getDay());
			
			int day = calendar.get(Calendar.DAY_OF_MONTH);
		
			monthToDraw.add(Integer.toString(day));
	
		}
		
		for (int i=monthToDraw.size();i<=posicionesMaximas;i++) {
			
			monthToDraw.add("");
			
		}
		

	
		return monthToDraw;
				
	}
	
	public ArrayList <String> numberWeekToDraw(){
		
		ArrayList<String> numberWeekToDraw = new ArrayList<String>();
		ListIterator <String> iterator = numberOfweeks.listIterator();

		int numeroCuadriculas = 7;
		int numeroCuadriculasRellenas=0;
		
		numberWeekToDraw.add("WK");
		numeroCuadriculasRellenas++;
	
		
		while (iterator.hasNext()) {
			
			String s = iterator.next();
			numberWeekToDraw.add(s);
			numeroCuadriculasRellenas++;
			
		}
		
		while (numeroCuadriculasRellenas<numeroCuadriculas) {
			
			numberWeekToDraw.add(" ");
			numeroCuadriculasRellenas++;
			
		}
		
		
		return numberWeekToDraw;
		
		
	}


	
	public int monthToInt (String month) {
		
		int mes=0;
		
		for (int i=0;i<=11;i++) {
			
			if (mesesAno[i].equals(month)) {
				
				mes=i;
				
			}
			
		}
		
		return mes;
		
	}
	
	public boolean isCourrentMonth() {
		
		boolean courrentMonth = false;
		
		calendar = Calendar.getInstance();
		int m = calendar.get(Calendar.MONTH);
		int y= calendar.get(Calendar.YEAR);
		
		if (year==y&&month==m) {
			
			courrentMonth=true;
		}
		
		return courrentMonth;
	
	}
	
	public String toDay () {
		
		calendar = Calendar.getInstance();
		int toDay = calendar.get(Calendar.DATE);
		
		
		return Integer.toString(toDay);
		
	}
	
	
	
	public ArrayList <Day> getMonthCalendar() {
		return monthCalendar;
	}

	public void setMonthCalendar(ArrayList <Day> monthCalendar) {
		this.monthCalendar = monthCalendar;
	}

	public String [] getDiasSemana() {
		return diasSemana;
	}
	
	public String getMonthToString(int month) {
		
		return mesesAno[month];
		
	}

	public void setMesesAno(String[] mesesAno) {
		this.mesesAno = mesesAno;
	}
	
	public String[] getMesesAno() {
		return mesesAno;
	}
	
	public int getMonth() {
		return month;
	}


	public int getYear() {
		return year;
	}

	public CalendarControl getCalendarControl() {
		return calendarControl;
	}

	public void setCalendarControl(CalendarControl calendarControl) {
		this.calendarControl = calendarControl;
	}



}
