package modelo;

import java.time.LocalDate;
import java.time.Period;

public class Empleado extends Persona {
	private int sueldoBase;
	
	public Empleado(int idPersona, String nombre, String apellido, long dni, LocalDate fechaDeAlta, int sueldoBase) {
		super(idPersona, nombre, apellido, dni, fechaDeAlta);
		this.sueldoBase = sueldoBase;
	}
	
	public int getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(int sueldoBase) {
		this.sueldoBase = sueldoBase;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Empleado: [sueldoBase=" + sueldoBase + "]";
	}
	
//Casos de Uso:
	
	public int antiguedadEnAnios() {
	//fechaDeAlta y el 1er dia habil del mes siguiente
		int aniosAnt;
		
		aniosAnt = Period.between(fechaDeAlta, LocalDate.of(2022, 12, 01)).getDays();
		
		return aniosAnt;
	}
	
}
