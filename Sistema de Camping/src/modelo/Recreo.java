package modelo;

import java.time.LocalDate;

public class Recreo extends Servicio {
	private int cantPersonas;
	private double precioPersona;
	
	public Recreo(int idServicio, String codIngreso, LocalDate fechaIngreso, boolean checkOut, Persona responsable,
			int cantPersonas, double precioPersona) throws Exception {
		super(idServicio, codIngreso, fechaIngreso, checkOut, responsable);
		this.cantPersonas = cantPersonas;
		this.precioPersona = precioPersona;
	}

	public int getCantPersonas() {
		return cantPersonas;
	}

	public void setCantPersonas(int cantPersonas) {
		this.cantPersonas = cantPersonas;
	}

	public double getPrecioPersona() {
		return precioPersona;
	}

	public void setPrecioPersona(double precioPersona) {
		this.precioPersona = precioPersona;
	}

	@Override
	public String toString() {
		return "Recreo: [cantPersonas=" + cantPersonas + ", precioPersona=" + precioPersona + "]";
	}
	
	
//Casos de Uso:
	
	public double calcularPrecioFinal() {
		double precioF;
		
		precioF = precioPersona*cantPersonas;
		
		return precioF;
	}	
}
