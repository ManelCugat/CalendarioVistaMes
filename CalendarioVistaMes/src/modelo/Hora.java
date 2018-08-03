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
	private int diaConstruccionHora;
	
	
	public Hora (){
		
		calendario = Calendar.getInstance();
		diaActual = calendario.get(Calendar.DAY_OF_MONTH);
		
	}
	
	public String contruccionHora() {
		
		calendario = Calendar.getInstance();
		segundo = Integer.toString(calendario.get(Calendar.SECOND));
		minuto = Integer.toString(calendario.get(Calendar.MINUTE));
		hora = Integer.toString(calendario.get(Calendar.HOUR));
		meridiem = calendario.get(Calendar.AM_PM);
		diaConstruccionHora = calendario.get(Calendar.DAY_OF_MONTH);
		//System.out.println("El día de hoy es: " + diaConstruccionHora);
		
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
	
		
		if (diaConstruccionHora!=diaActual) {
			cambioDia=true;
			diaConstruccionHora=diaActual;
			System.out.println("Cambio de dia!!!");
			
		}
		
		System.out.println("-----------------------------------");
		System.out.println("Dia inicio calendario: "+diaActual);
		System.out.println ("Dia del reloj: "+diaConstruccionHora);
		
		return cambioDia;
		
	}

}
