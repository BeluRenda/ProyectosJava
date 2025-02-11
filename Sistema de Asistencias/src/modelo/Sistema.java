package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Asistencia> asistencias = new ArrayList<Asistencia>();
	
	public Sistema() {}

	public List<Asistencia> getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(List<Asistencia> asistencias) {
		this.asistencias = asistencias;
	}

	@Override
	public String toString() {
		return "Sistema: [asistencias=" + asistencias + "]";
	}
	
//Casos de Uso:
	
	public List<Asistencia> traerAsistencia(LocalDate fecha) {
		List<Asistencia> lstAsAux = new ArrayList<Asistencia>();
		
		for(Asistencia a : asistencias) {
			if(a.getFecha().isEqual(fecha)) {
				lstAsAux.add(a);
			}
		}
		return lstAsAux;
	}
	
	
	public Asistencia traerAsistencia(LocalDate fecha, String legajo) {
		Asistencia asAux = null;
		int i=0;
		
		while(i<asistencias.size() && asAux==null) {
			if(fecha.isEqual(asistencias.get(i).getFecha()) && legajo==asistencias.get(i).getLegajo()) {
				asAux = asistencias.get(i);
			}
			i++;
		}
		return asAux;	
	}
	
	
	public List<Asistencia> traerAsistenciaPresencial(boolean esPresencial) {
	//retorna una lista
		List<Asistencia> lstAsAux = new ArrayList<Asistencia>();
		
		for(Asistencia a : asistencias) {
			if(a instanceof TrabajoPresencial && esPresencial==true) {
				lstAsAux.add(a);
			}
		}
		return lstAsAux; 	
	}
	
	
	public List<Asistencia> traerAsistenciaVirtual(boolean esVirtual) {
		//retorna una lista
		List<Asistencia> lstAsAux = new ArrayList<Asistencia>();
			
		for(Asistencia a : asistencias) {
			if(a instanceof Teletrabajo && esVirtual==true) {
				lstAsAux.add(a);
			}
		}
		return lstAsAux; 	
	}
	
	
	public Asistencia traerAsistencia(int id) {
		Asistencia asAux = null;
		int i=0;
		
		while(i<asistencias.size() && asAux == null) {
			if(id == asistencias.get(i).getIdAsistencia()) {
				asAux = asistencias.get(i);
			}
			i++;
		}
		return asAux;
	}
	
	
	public boolean agregarTrabajoPresencial(LocalDate fecha, String legajo, LocalTime horaDesde, LocalTime horaHasta) throws Exception{
		//Valida que aun no exista una asistencia para la misma fecha y legajo, lanza excepcion	
		int id=1;
			
		Asistencia aAux = traerAsistencia(fecha, legajo);
			
		if(aAux !=null){
			throw new Exception ("Ya existe una asistencia para esa fecha y legajo. ");
		}
		if(asistencias.size()>0) {
			id = asistencias.get(asistencias.size()-1).getIdAsistencia()+1;
		}
		System.out.println("Se agrego el trabajo presencial.");
		return asistencias.add(new TrabajoPresencial(id, fecha, legajo, horaDesde, horaHasta));
	}
	
	
	public boolean agregarTeletrabajo(LocalDate fecha, String legajo, String motivo, int tareasRealizadas) throws Exception {
		//retorna una lista con las Asistencias según parámetro	
		int id=1;

		if(asistencias.size()>0) {
			id = asistencias.get(asistencias.size()-1).getIdAsistencia()+1;
		}
		System.out.println("Se agrego el teletrabajo.");
		return asistencias.add(new Teletrabajo(id, fecha, legajo, motivo, tareasRealizadas));
	}
	
}
