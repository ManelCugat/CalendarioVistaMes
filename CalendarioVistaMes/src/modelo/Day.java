package modelo;

import java.util.*;

public class Day {
	
	
	private Date day;
	private Hora hora;
	
	
	public Day () {
		
		day = new Date ();
		
	}
	
	
	public Date getDay () {
		
		return day;
		
	}
	
	public void setDay (Date day) {
		
		this.day = day;
		
	}


	public Hora getHora() {
		return hora;
	}


	public void setHora(Hora hora) {
		this.hora = hora;
	}


}
