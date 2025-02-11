package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class TrabajoPresencial extends Asistencia {
	private LocalTime horaDesde;
	private LocalTime horaHasta;

	public TrabajoPresencial(int idAsistencia, LocalDate fecha, String legajo, LocalTime horaDesde,
			LocalTime horaHasta) {
		super(idAsistencia, fecha, legajo);
		this.horaDesde = horaDesde;
		this.horaHasta = horaHasta;
	}

	public LocalTime getHoraDesde() {
		return horaDesde;
	}

	public void setHoraDesde(LocalTime horaDesde) {
		this.horaDesde = horaDesde;
	}

	public LocalTime getHoraHasta() {
		return horaHasta;
	}

	public void setHoraHasta(LocalTime horaHasta) {
		this.horaHasta = horaHasta;
	}

	@Override
	public String toString() {
		return super.toString() + "TrabajoPresencial: [horaDesde=" + horaDesde + ", horaHasta=" + horaHasta + "]";
	}

//Casos de Uso:
	
	public double calcularHorasTrabajadas() {
		//Diferencia entre horario de entrada y salida	
		double valorHorario=0;
			
		if(horaDesde.isBefore(horaHasta)) {
			valorHorario = ((horaHasta.getHour() - horaDesde.getHour() * 60 + horaHasta.getMinute() - horaDesde.getMinute()) / 60);
		}
			
		return valorHorario;
	}

}
