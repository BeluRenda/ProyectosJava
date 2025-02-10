package modelo;

import java.time.LocalDate;

public class Alquiler {
	private Propiedad propiedad;
	private LocalDate fechaDesde;
	private LocalDate fechaHasta;
	private int cantidadNoches;
	
	public Alquiler(Propiedad propiedad, LocalDate fechaDesde, LocalDate fechaHasta, int cantidadNoches) {
		super();
		this.propiedad = propiedad;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.cantidadNoches = cantidadNoches;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) throws Exception {
		if(propiedad == null) {
			throw new Exception ("Error, no puede ser nula.");
		} else {
			this.propiedad = propiedad;
		}
	}


	public LocalDate getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(LocalDate fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public LocalDate getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(LocalDate fechaHasta) throws Exception{
		if(fechaHasta.isBefore(fechaDesde)) {
			throw new Exception("Error, fechaHasta no puede ser anterior a fechaDesde.");
		} else {
			this.fechaHasta = fechaHasta;
		}
	}

	public int getCantidadNoches() {
		return cantidadNoches;
	}

	public void setCantidadNoches(int cantidadNoches) throws Exception{
		if(cantidadNoches <= 0) {
			throw new Exception ("Error, la cantidad de noches no puede ser menor o igual a 0.");
		} else {
			this.cantidadNoches = cantidadNoches;
		}		
	}

	@Override
	public String toString() {
		return "Alquiler: [propiedad=" + propiedad + ", fechaDesde=" + fechaDesde + ", fechaHasta=" + fechaHasta
				+ ", cantidadNoches=" + cantidadNoches + "]";
	}
	
//Casos de Uso:	
	
	public double precioFinal() {
		//Calcula precioPorNoche * cantidadNoches	
		double precioF;
		
		precioF = propiedad.precioPorNoche() * cantidadNoches;	
		return precioF;
	}
	
}
