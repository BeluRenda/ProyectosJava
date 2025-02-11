package modelo;

import java.time.LocalDate;

public abstract class Asistencia {
	protected int idAsistencia;
	protected LocalDate fecha;
	protected String legajo;
	
	public Asistencia(int idAsistencia, LocalDate fecha, String legajo) {
		super();
		this.idAsistencia = idAsistencia;
		this.fecha = fecha;
		this.legajo = legajo;
	}

	public int getIdAsistencia() {
		return idAsistencia;
	}

	public void setIdAsistencia(int idAsistencia) {
		this.idAsistencia = idAsistencia;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	@Override
	public String toString() {
		return "Asistencia: [idAsistencia=" + idAsistencia + ", fecha=" + fecha + ", legajo=" + legajo + "]";
	}
	
	public abstract double calcularHorasTrabajadas();
	
}
