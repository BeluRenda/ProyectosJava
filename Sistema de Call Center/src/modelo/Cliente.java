package modelo;

import java.time.LocalDate;
import java.time.Period;

public class Cliente extends Persona {
	private boolean activo;
	
	public Cliente(int idPersona, String nombre, String apellido, long dni, LocalDate fechaDeAlta, boolean activo) {
		super(idPersona, nombre, apellido, dni, fechaDeAlta);
		this.activo = activo;
	}
	
	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Cliente: [activo=" + activo + "]";
	}
	
//Casos de Uso:	

	public int antiguedadEnAnios() {
		int aniosAnt;
		
		if(activo) {
			aniosAnt = Period.between(fechaDeAlta, LocalDate.of(2022, 11, 15)).getDays();
		} else {
			aniosAnt = 0;
		}
		return aniosAnt;
	}

}
