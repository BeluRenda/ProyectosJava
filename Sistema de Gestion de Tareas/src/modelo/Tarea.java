package modelo;

import java.time.LocalDate;

public class Tarea {
	private int idTarea;
	private String tarea;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private Empleado responsable;
	private int cantHorasDiarias;
	private boolean habil;
	
	public Tarea(int idTarea, String tarea, LocalDate fechaInicio, LocalDate fechaFin, Empleado responsable,
			int cantHorasDiarias, boolean habil) {
		super();
		this.idTarea = idTarea;
		this.tarea = tarea;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.responsable = responsable;
		this.cantHorasDiarias = cantHorasDiarias;
		this.habil = habil;
	}

	public int getIdTarea() {
		return idTarea;
	}

	public void setIdTarea(int idTarea) {
		this.idTarea = idTarea;
	}

	public String getTarea() {
		return tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Empleado getResponsable() {
		return responsable;
	}

	public void setResponsable(Empleado responsable) {
		this.responsable = responsable;
	}

	public int getCantHorasDiarias() {
		return cantHorasDiarias;
	}

	public void setCantHorasDiarias(int cantHorasDiarias) {
		this.cantHorasDiarias = cantHorasDiarias;
	}

	public boolean isHabil() {
		return habil;
	}

	public void setHabil(boolean habil) {
		this.habil = habil;
	}

	@Override
	public String toString() {
		return "Tarea: [idTarea=" + idTarea + ", tarea=" + tarea + ", fechaInicio=" + fechaInicio + ", fechaFin="
				+ fechaFin + ", responsable=" + responsable + ", cantHorasDiarias=" + cantHorasDiarias + ", habil="
				+ habil + "]";
	}
	
	//Casos de Uso:
	
	
	public double calcularJornal() {
		double jornal = 0;
		if(habil) {
			jornal=this.getCantHorasDiarias()*getResponsable().getValorHora();
		} else {
			jornal=this.getCantHorasDiarias()*getResponsable().getValorHora()*1.5;
		}
		return jornal;
	}
	
	//func aux
	public static boolean esBisiesto(int anio) {
		boolean esBisiesto = false;
		if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))) {
			esBisiesto = true;
		}
		return esBisiesto;
	}
	
	//func aux
	public static int traerCantDiasDeUnMes(int anio, int mes) {
		int dias=0;
		if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
			dias =31; 
		}
		
		if ((mes == 4 || mes == 6 || mes == 9 || mes == 11)) {
			dias=30;
		}
		
		if (esBisiesto(anio) && mes == 2) {
			dias=29;}
		
		if (esBisiesto(anio)== false && mes == 2) {
			dias=28;
		}
		return dias;
	}
	
	//func aux
	public static boolean esDiaHabil(LocalDate fecha) {//DIA HABIL
		int n = fecha.getDayOfWeek().getValue();
		return ((n>=1)&&(n<=5));
	}
	
	
	public int calcularCantDiasTrabajados(int mes, int anio) {
		int diasDelMes = traerCantDiasDeUnMes(anio, mes);
		int diasTrabajados = 0;
		int i;
		LocalDate fecha;
		
		if(habil) {
			for(i=1; i<=diasDelMes; i++) {
				fecha = LocalDate.of(anio, mes, i);
				if(esDiaHabil(fecha)) {
					diasTrabajados++;
				}
			}
		} else {
			for(i=1; i<=diasDelMes; i++) {
				fecha = LocalDate.of(anio, mes, i);
				if(!esDiaHabil(fecha)) {
					diasTrabajados++;
				}
			}
		}
		return diasTrabajados;	
	}
		
		
	public double calcularHonorarios(int mes, int anio) {
			double total = 0;
			total = calcularCantDiasTrabajados(mes, anio)*calcularJornal();
			return total;
		}

}