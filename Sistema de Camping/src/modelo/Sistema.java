package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Persona> lstPersonas = new ArrayList<Persona>();
	private List<Servicio> lstServicios = new ArrayList<Servicio>();
	
	public Sistema() {}

	public List<Persona> getLstPersonas() {
		return lstPersonas;
	}

	public void setLstPersonas(List<Persona> lstPersonas) {
		this.lstPersonas = lstPersonas;
	}

	public List<Servicio> getLstServicios() {
		return lstServicios;
	}

	public void setLstServicios(List<Servicio> lstServicios) {
		this.lstServicios = lstServicios;
	}

	@Override
	public String toString() {
		return "Sistema: [lstPersonas=" + lstPersonas + ", lstServicios=" + lstServicios + "]";
	}
	
	//Casos de Uso:
	
	
	public Persona traerPersona(long dni) {
		Persona persAux = null;
		int i=0;
		
		while(i<lstPersonas.size() && persAux==null) {
			if(lstPersonas.get(i).getDni()==dni) {
				persAux = lstPersonas.get(i);
			}
			i++;
		}
		return persAux;
	}
	
	public boolean agregarPersona(String apellido, String nombre, long dni) throws Exception {
		Persona perAgregarAux = traerPersona(dni);
		int id=1;
		
		if(perAgregarAux!=null) {
			throw new Exception("Error: La persona con el DNI ingresado ya existe.");
		}
		
		if(lstPersonas.size()>0) {
			id = lstPersonas.get(lstPersonas.size()-1).getIdPersona()+1;
		}
		return lstPersonas.add(new Persona(id, apellido, nombre, dni));
	}
	
	public boolean agregarRecreo(String codIngreso, LocalDate fechaIngreso, boolean checkOut, Persona responsable, int cantPersonas, double precioPersona) throws Exception {
		//Excepcion: codIngreso invalido	
			int id=1;
			
			if(lstServicios.size()>0) {
				id = lstServicios.get(lstServicios.size()-1).getIdServicio()+1;
			} else {
				System.out.println("Error al intentar agregar recreo.");
			}
		return lstServicios.add(new Recreo(id, codIngreso, fechaIngreso, checkOut, responsable, cantPersonas, precioPersona));
	}
	
	public boolean agregarCampamento(String codIngreso, LocalDate fechaIngreso, boolean checkOut, Persona responsable, LocalDate fechaEgreso, int cantCarpas, double precioCarpa) throws Exception {
		//Excepcion: codIngreso invalido	
				int id=1;
				
				if(lstServicios.size()>0) {
					id = lstServicios.get(lstServicios.size()-1).getIdServicio()+1;
					System.out.println("Se agrego el campamento.");
				} else {
					System.out.println("Error al intentar agregar campamento.");
				}
				
			return lstServicios.add(new Campamento(id, codIngreso, fechaIngreso, checkOut, responsable, fechaEgreso, cantCarpas, precioCarpa));
	}
	
	public List<Servicio> traerServiciosPorPrecioFinal(double mayorIgualA){
		List<Servicio> lstSAux = new ArrayList<Servicio>();
		
		for(Servicio s : lstServicios) {
			if(s.isCheckOut() == true && s.calcularPrecioFinal() >= mayorIgualA) {
				lstSAux.add(s);
			}
		}
		return lstSAux;
	}
	
	public List<Campamento> traerCampamentosPorDias(int mayorIgualA){
		List<Campamento> lstCAux = new ArrayList<Campamento>();
		
		for(Servicio s : lstServicios) {
			if(s instanceof Campamento && ((Campamento) s).cantidadDias() >= mayorIgualA){
				lstCAux.add((Campamento) s);
			}
		}		
		return lstCAux;
	}	
}
