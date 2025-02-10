package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Persona> lstPersonas = new ArrayList<Persona>();
	private List<Seguridad> lstSeguridad = new ArrayList<Seguridad>();
	
	public Sistema() {}
	
	public List<Persona> getLstPersonas() {
		return lstPersonas;
	}

	public void setLstPersonas(List<Persona> lstPersonas) {
		this.lstPersonas = lstPersonas;
	}

	public List<Seguridad> getLstSeguridad() {
		return lstSeguridad;
	}

	public void setLstSeguridad(List<Seguridad> lstSeguridad) {
		this.lstSeguridad = lstSeguridad;
	}

	@Override
	public String toString() {
		return "Sistema: [lstPersonas=" + lstPersonas + ", lstSeguridad=" + lstSeguridad + "]";
	}
	
	public boolean agregarEmpleado(String apellido, String nombre, int dni, int nroLegajo) {
		//No contempla excepcion
			boolean existe = false;
			int id=1;
			
			if(lstPersonas.size()>0) {
				id = lstPersonas.get(lstPersonas.size()-1).getId()+1;
			}
			lstPersonas.add(new Empleado(id, apellido, nombre, dni, nroLegajo));
			
			System.out.println("Se agrego Empleado");
			
			return existe;
	}
	
	public boolean agregarVisita(String apellido, String nombre, int dni, String empresa) {
		//No contempla excepcion
			boolean existe = false;
			int id=1;
			
			if(lstPersonas.size()>0) {
				id = lstPersonas.get(lstPersonas.size()-1).getId()+1;
			}
			lstPersonas.add(new Visita(id, apellido, nombre, dni, empresa));
			
			System.out.println("Se agrego Visita");
			
			return existe;
	}
	
	public Persona traerPersona(int id) {
		Persona aux = null;
		int i=0;
		
		while(i<lstPersonas.size() && aux==null) {
			if(lstPersonas.get(i).id == id) {
				aux = lstPersonas.get(i);
			}
			i++;
		}
		return aux;
	}
	
	public List<Seguridad> traerSeguridad(LocalDate fecha, Persona persona){
		//Trae todos los objetos Seguridad que ese dia haya fichado la persona
			 List<Seguridad> lstAux = new ArrayList<Seguridad>();
			 
			 for(Seguridad s : lstSeguridad) {
				 if(s.getPersona().equals(persona) && s.getFecha().isEqual(fecha)) {
					 lstAux.add(s);
				 }
			 }
			 return lstAux;
	}
	
	public boolean agregarSeguridad(LocalDate fecha, LocalTime hora, boolean entrada, Persona persona) throws Exception {
		//Una persona no puede registrar dos veces la salida o la entrada
			boolean existe = true;
			int id=1;
			int i=0;
			
			List<Seguridad> lstAux = traerSeguridad(fecha, persona);
			
			while(existe && i<lstAux.size()) {
				if(lstAux.get(lstAux.size()-1).isEntrada()==entrada) {
					throw new Exception ("No puede registrar dos veces la entrada o salida");
				}
				i++;
			}
			
			if(lstSeguridad.size()>0 && existe) {
				id = lstSeguridad.get(lstSeguridad.size()-1).getId()+1;
			}
			
			lstSeguridad.add(new Seguridad(id, fecha, hora, entrada, persona));
			
			System.out.println("Se agrego Seguridad");
			
			return existe;
	}
	
	public List<Seguridad> traerVisita(LocalDate fecha){
		//Debe traer todas las visitas de ese dia
			 List<Seguridad> lstAux = new ArrayList<Seguridad>();
			 
			 for(Seguridad s : lstSeguridad) {
				 if(s.getPersona() instanceof Visita && s.getFecha().isEqual(fecha)) {
					 lstAux.add(s);
				 }
			 }
			 return lstAux;
	}
	
}
