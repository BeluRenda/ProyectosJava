package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Propiedad> propiedades =  new ArrayList<Propiedad>();
	private List<Alquiler> alquileres = new ArrayList<Alquiler>();
	
	public Sistema() {}

	public List<Propiedad> getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(List<Propiedad> propiedades) {
		this.propiedades = propiedades;
	}

	public List<Alquiler> getAlquileres() {
		return alquileres;
	}

	public void setAlquileres(List<Alquiler> alquileres) {
		this.alquileres = alquileres;
	}

	@Override
	public String toString() {
		return "Sistema: [propiedades=" + propiedades + ", alquileres=" + alquileres + "]";
	}
	
//Casos de Uso:	
	
	public boolean agregarCasa(double precioBase, String direccion ,boolean tienePatio) {
		//El valor del id de propiedad se debe calcular
		int id=1;
		if(propiedades.size()>0) {
			id = propiedades.get(propiedades.size()-1).getId()+1;
		}
		System.out.println("Se agrego la casa.");
		return propiedades.add(new Casa(id, precioBase, direccion, tienePatio));
	}

	
	public boolean agregarDepartamento(double precioBase, String direccion ,int cantidadAmbientes, int nroPiso, boolean tieneAscensor) {
		//El valor del id de propiedad se debe calcular
		int id=1;
		if(propiedades.size()>0) {
			id = propiedades.get(propiedades.size()-1).getId()+1;
		}	
		System.out.println("Se agrego el departamento.");
		return propiedades.add(new Departamento(id, precioBase, direccion, cantidadAmbientes, nroPiso, tieneAscensor));
	}
	
	
	public Propiedad traerPropiedad(int id) {
		Propiedad prAux = null;
		int i=0;
		
		while(i<propiedades.size() && prAux==null){
			if(id == propiedades.get(i).getId()) {
				prAux = propiedades.get(i);
			}
			i++;
		}
		return prAux;
	}
	
	
	public boolean alquilarPropiedad(Propiedad propiedad, LocalDate fechaDesde, LocalDate fechaHasta, int cantidadNoches) throws Exception {
		//agrega un nuevo alquiler a la lista de alquileres
		System.out.println("Se alquilo la propiedad.");
		return alquileres.add(new Alquiler(propiedad, fechaDesde, fechaHasta, cantidadNoches));
	}
	
	
	public List<Alquiler> traerAlquileres(LocalDate desde, LocalDate hasta){
		//Trae todos los alquileres que tengan una fechaDesde = o post a "desde" y una fechaHasta = o ant a "hasta"
		List<Alquiler> alquileresFiltrados = new ArrayList<>();
        for (Alquiler alquiler : alquileres) {
            if (alquiler.getFechaDesde().isEqual(desde) || alquiler.getFechaDesde().isBefore(desde) 
                    && alquiler.getFechaHasta().isEqual(hasta) || alquiler.getFechaHasta().isBefore(hasta)) {
                alquileresFiltrados.add(alquiler);
            }
        }
        return alquileresFiltrados;
	}
	
	public double calcularRecaudadoEntre(LocalDate desde, LocalDate hasta) {
		//Calcula precio final para alquileres en ese rango
		double recau=0;
			
		for(Alquiler a : alquileres) {
			if(a.getFechaDesde().isEqual(desde) && a.getFechaHasta().isEqual(hasta)) {
				recau = a.precioFinal();
			}
		}	
		return recau;
	}
	
	
	
}
