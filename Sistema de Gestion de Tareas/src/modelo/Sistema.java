package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Empleado> lstEmpleados = new ArrayList<Empleado>();
	private List<Tarea> lstTareas = new ArrayList<Tarea>();
	
	public Sistema() {}

	public List<Empleado> getLstEmpleados() {
		return lstEmpleados;
	}

	public void setLstEmpleados(List<Empleado> lstEmpleados) {
		this.lstEmpleados = lstEmpleados;
	}

	public List<Tarea> getLstTareas() {
		return lstTareas;
	}

	public void setLstTareas(List<Tarea> lstTareas) {
		this.lstTareas = lstTareas;
	}

	@Override
	public String toString() {
		return "Sistema: [lstEmpleados=" + lstEmpleados + ", lstTareas=" + lstTareas + "]";
	}
	
	//Casos de Uso:
	
	
	public Empleado traerEmpleado(String nroLegajo) {
		
		int i=0;
		
		Empleado empleado = null;
		
		while(empleado==null && i<lstEmpleados.size()) {
			if(lstEmpleados.get(i).getNroLegajo().equals(nroLegajo)) {
				empleado = lstEmpleados.get(i);
			}
			i++;
		}
		return empleado;
	}
	
	public Tarea traerTarea(int id) {
		int i=0;
		
		Tarea tarea = null;
		
		while(tarea==null && i<lstTareas.size()) {
			if(lstTareas.get(i).getIdTarea()==id) {
				tarea = lstTareas.get(i);
			}
			i++;
		}
		return tarea;
	}
	
	public boolean agregarEmpleado(String apellido, String nombre, String nroLegajo, double valorHora) {
		//No implementa excepciones
			boolean existe = false;
			
			Empleado paraAgregar = this.traerEmpleado(nroLegajo); //Reutilizo metodo traer, si es null no existe empleado con ese nroLegajo
			
			if(paraAgregar == null) {
				Empleado aux = new Empleado(apellido, nombre, nroLegajo, valorHora);
				lstEmpleados.add(aux);
			}
			return existe;
		}
	
	public boolean agregarTarea(String tarea, LocalDate fechaInicio, LocalDate fechaFin, Empleado responsable, int cantHorasDiarias, boolean habil) {
		//idTarea es 1 si no hay objetos en lstTareas 
		//de lo contrario se incrementa en 1 el idTarea del ultimo objeto en la lista
		//No implementa excepciones
			int id=0;
			int i=0;
			
			boolean existe = true;
			
			Tarea paraAgregar = new Tarea (0, tarea, fechaInicio, fechaFin, responsable, cantHorasDiarias, habil);
			
			while(existe && i<lstTareas.size()) {
				if(lstTareas.get(i).equals(paraAgregar)) {
					existe = false;
				}
				i++;
			}
			
			if(lstTareas.size()==0 && existe) {
				id = 1;
				paraAgregar.setIdTarea(id);
				lstTareas.add(paraAgregar);
			} else if(existe) {
				id = lstTareas.get(lstTareas.size()-1).getIdTarea()+1;
				paraAgregar.setIdTarea(id);
				lstTareas.add(paraAgregar);
			}
			return existe;
		}

}
