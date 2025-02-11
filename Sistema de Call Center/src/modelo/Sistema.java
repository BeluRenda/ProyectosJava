package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Llamada> lstLlamadas = new ArrayList<Llamada>();
	private List<Persona> lstPersonas = new ArrayList<Persona>();
	
	public Sistema() {}

	public List<Llamada> getLstLlamadas() {
		return lstLlamadas;
	}

	public List<Persona> getLstPersonas() {
		return lstPersonas;
	}

//Casos de Uso:
	
	public Persona traerPersona(long dni) {
		Persona pAux=null;
		int i=0;
		
		while(i<lstPersonas.size()&&pAux==null) {
			if(dni==lstPersonas.get(i).getDni()) {
				pAux = lstPersonas.get(i);
			}
			i++;
		}
		return pAux;
	}
	
	
	public boolean agregarCliente(String nombre, String apellido, long dni, LocalDate fechaDeAlta, boolean activo) throws Exception {
		int id=1;
		Persona pAux = traerPersona(dni);
		
		if(pAux!=null) {
			throw new Exception("Error: Ya existe una persona con ese DNI.");
		}
		
		if(lstPersonas.size()>0) {
			id = lstPersonas.get(lstPersonas.size()-1).getIdPersona()+1;
		}	
		System.out.println("Se agrego el cliente.");
		return lstPersonas.add(new Cliente(id, nombre, apellido, dni, fechaDeAlta, activo));
	}
	
	
	public boolean agregarEmpleado(String nombre, String apellido, long dni, LocalDate fechaDeAlta, int sueldoBase) throws Exception {
		int id=1;
		Persona pAux = traerPersona(dni);
		
		if(pAux!=null) {
			throw new Exception("Error: Ya existe una persona con ese DNI.");
		}
		
		if(lstPersonas.size()>0) {
			id = lstPersonas.get(lstPersonas.size()-1).getIdPersona()+1;
		}
		System.out.println("Se agrego el empleado.");
		return lstPersonas.add(new Empleado(id, nombre, apellido, dni, fechaDeAlta, sueldoBase));
	}
	
	
	public boolean agregarLlamada(LocalDate fecha, LocalTime hora, Cliente cliente, Empleado empleado, int nivelDeSatisfaccion) throws Exception {
		int id=1;
		
		if(lstLlamadas.size()>0) {
			id = lstLlamadas.get(lstLlamadas.size()-1).getIdLlamada()+1;
		}
		System.out.println("Se agrego la llamada.");
		return lstLlamadas.add(new Llamada(id, fecha, hora, cliente, empleado, nivelDeSatisfaccion));
	}
	
	
	public List<Cliente> traerClientes(boolean estadoCliente) {
		List<Cliente> lstCAux = new ArrayList<Cliente>();
		
		for(Persona p : lstPersonas) {
			if(p instanceof Cliente && ((Cliente) p).isActivo()) {
				lstCAux.add((Cliente) p);
			}
		}
		return lstCAux;
	}
	
	
	public List<Persona> traerPersonasAntiguedad(int mayorIgualA) {
		List<Persona> lstPAux = new ArrayList<Persona>();
		
		for(Persona p : lstPersonas) {
			if(p instanceof Cliente || p instanceof Empleado && p.antiguedadEnAnios()>=mayorIgualA) {
				lstPAux.add(p);
			}
		}
		return lstPAux;
	}
	
	
	public List<Llamada> traerLlamadas(LocalDate fecha, LocalTime horaDesde, LocalTime horaHasta) {
		List<Llamada> lstLAux = new ArrayList<Llamada>();
		
		for(Llamada l : lstLlamadas) {
			if(l.getFecha().isEqual(fecha) && l.getHora().isAfter(horaDesde) || l.getHora().equals(horaDesde) && l.getHora().equals(horaHasta) || l.getHora().isBefore(horaHasta)) {
				lstLAux.add(l);
			}
		}
		return lstLAux;
	}
	
}
