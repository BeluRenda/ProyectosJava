package modelo;

import java.time.LocalDate;

public class Teletrabajo extends Asistencia {
	private String motivo;
	private int tareasRealizadas;

	public Teletrabajo(int idAsistencia, LocalDate fecha, String legajo, String motivo, int tareasRealizadas) {
		super(idAsistencia, fecha, legajo);
		this.motivo = motivo;
		this.tareasRealizadas = tareasRealizadas;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public int getTareasRealizadas() {
		return tareasRealizadas;
	}

	public void setTareasRealizadas(int tareasRealizadas) throws Exception {
		if(tareasRealizadas>8) {
			throw new Exception("No se pueden realizar mas de 8 tareas diarias.");
		}
		this.tareasRealizadas = tareasRealizadas;
	}

	@Override
	public String toString() {
		return super.toString() + "Teletrabajo: [motivo=" + motivo + ", tareasRealizadas=" + tareasRealizadas + "]";
	}
	
//Casos de Uso:	
	
	public double calcularHorasTrabajadas() {
		double valorHorasTrabajadas=0;
		
		valorHorasTrabajadas += tareasRealizadas * 1.5;
		
		return valorHorasTrabajadas;
	}
	
}
