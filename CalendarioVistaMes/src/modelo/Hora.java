package modelo;

import java.util.Calendar;

public class Hora {
	
	private Calendar calendario;
	private String hora;
	private String minuto;
	private String segundo;
	private int meridiem;
	private String meridiemString;
	private String formatoHora;
	private Boolean cambioDia = false;
	private int diaActual;
	private int mesActual;
	private int yearActual;
	private int diaConstruccionHora;
	private int mesConstruccionHora;
	private int yearConstruccionHora;
	
	
	public Hora (){
		
		calendario = Calendar.getInstance();
		diaActual = calendario.get(Calendar.DAY_OF_MONTH);
		mesActual = calendario.get(Calendar.MONTH);
		yearActual = calendario.get(Calendar.YEAR);
		
	}
	
	public String contruccionHora() {
		
		calendario = Calendar.getInstance();
		segundo = Integer.toString(calendario.get(Calendar.SECOND));
		minuto = Integer.toString(calendario.get(Calendar.MINUTE));
		hora = Integer.toString(calendario.get(Calendar.HOUR));
		meridiem = calendario.get(Calendar.AM_PM);
		diaConstruccionHora = calendario.get(Calendar.DAY_OF_MONTH);
		mesConstruccionHora = calendario.get(Calendar.MONTH);
		yearConstruccionHora = calendario.get(Calendar.YEAR);
		System.out.println("-----------------------------------");
		System.out.println ("Dia del reloj: "+diaConstruccionHora);
		
		if (meridiem==0) {
			
			meridiemString = "AM";
			
		}else meridiemString= "PM";
		
		if (Integer.parseInt(segundo)<10) {
			
			segundo = "0"+segundo;
			
		}
		
		if (Integer.parseInt(minuto)<10) {
			
			minuto = "0"+minuto;
			
		}
		
		if (Integer.parseInt(hora)<10) {
			
			hora = "0"+hora;
			
		}
		
		formatoHora = hora + ":" + minuto + ":" + segundo + " "+meridiemString;
		return formatoHora;
	}
	
	public Boolean cambioDia() {
	
		
		if (diaConstruccionHora!=diaActual||mesConstruccionHora!=mesActual||yearConstruccionHora!=yearActual) {
			cambioDia=true;
			System.out.println("Dia anterior del calendario: "+diaActual);
			diaActual=diaConstruccionHora;
			mesActual=mesConstruccionHora;
			yearActual=yearConstruccionHora;
			System.out.println("Cambio de dia!!!");
		}
		



		
		return cambioDia;
		
	}

}
