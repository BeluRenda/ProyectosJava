package modelo;

import java.time.LocalDate;

public abstract class Servicio {
	protected int idServicio;
	protected String codIngreso;
	protected LocalDate fechaIngreso;
	protected boolean checkOut;
	protected Persona responsable;
	
	public Servicio(int idServicio, String codIngreso, LocalDate fechaIngreso, boolean checkOut, Persona responsable) throws Exception {
		super();
		this.idServicio = idServicio;
		setCodIngreso(codIngreso);
		this.fechaIngreso = fechaIngreso;
		this.checkOut = checkOut;
		this.responsable = responsable;
	}
	
	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public String getCodIngreso() {
		return codIngreso;
	}

	public void setCodIngreso(String codIngreso) throws Exception {
		if(esValidoDigitoControl(codIngreso)==true) {
			this.codIngreso = codIngreso;
		} else {
			throw new Exception ("Error: codigo de ingreso invalido.");
		}
		
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public boolean isCheckOut() {
		return checkOut;
	}

	public void setCheckOut(boolean checkOut) {
		this.checkOut = checkOut;
	}

	public Persona getResponsable() {
		return responsable;
	}

	public void setResponsable(Persona responsable) {
		this.responsable = responsable;
	}

	@Override
	public String toString() {
		return "Servicio: [idServicio=" + idServicio + ", codIngreso=" + codIngreso + ", fechaIngreso=" + fechaIngreso
				+ ", checkOut=" + checkOut + ", responsable=" + responsable + "]";
	}	
	
	
//Casos de Uso:	
	
	public boolean esValidoDigitoControl(String codIngreso) {
		boolean codCorrecto = false;
		int suma = 0;
		int digitVerificador = 0;
		int i;
		
		//Revisar cada posicion hasta la 6 (de 0 a 6 entonces hago -1)
		for(i=0; i<codIngreso.length()-1; i++) {
			suma += Character.getNumericValue(codIngreso.charAt(i));
		}
		
		digitVerificador = suma % 10;
		
		if(digitVerificador == Character.getNumericValue(codIngreso.charAt(codIngreso.length()-1))) {
			codCorrecto = true;
		}
		
		return codCorrecto;
	}
	
	public abstract double calcularPrecioFinal();
}
