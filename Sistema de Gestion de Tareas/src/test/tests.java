package test;

import modelo.Sistema;

import java.time.LocalDate;

public class tests {

	public static void main(String[] args) {
		Sistema sistema = new Sistema();
		
		System.out.println("Agregar empleados");
		sistema.agregarEmpleado("Melo", "Tomas", "3742", 430);
		sistema.agregarEmpleado("Navarro", "Monica", "3125", 410);
		
		System.out.println("Traer empleado por numero de legajo");
		System.out.println(sistema.traerEmpleado("3125"));
		
		System.out.println("Agregar tarea por empleado");
		sistema.agregarTarea("Reparacion Castelli altura 1700-1800", LocalDate.of(2021, 05, 13), LocalDate.of(2021, 06, 21), sistema.traerEmpleado("3742"), 6, true);
		sistema.agregarTarea("Reparacion semaforo peatonal Alsina y Boedo", LocalDate.of(2021, 06, 17), LocalDate.of(2021, 07, 25), sistema.traerEmpleado("3125"), 6, false);
		
		System.out.println("Traer Tarea id: 1");
		System.out.println(sistema.traerTarea(1));
		
		System.out.println("Calcular jornal de Tarea id: 1");
		System.out.println("Jornal de tarea id=1: " + sistema.traerTarea(1).calcularJornal());
		
		System.out.println("Calcular cant dias trabajados de Tarea id: 1");
		System.out.println("Cant dias trabajados de tarea id=1: " + sistema.traerTarea(1).calcularCantDiasTrabajados(6, 2021));
		
		System.out.println("Calcular honorarios de Tarea id: 1");
		System.out.println("Honorarios de tarea id=1: " + sistema.traerTarea(1).calcularHonorarios(6, 2021));
		
		System.out.println("Traer Tarea id: 2");
		System.out.println(sistema.traerTarea(2));
		
		System.out.println("Calcular jornal de Tarea id: 2");
		System.out.println("Jornal de tarea id=2: " + sistema.traerTarea(2).calcularJornal());
		
		System.out.println("Calcular cant dias trabajados de Tarea id: 2");
		System.out.println("Cant dias trabajados de tarea id=2: " + sistema.traerTarea(2).calcularCantDiasTrabajados(6, 2021));
		
		System.out.println("Calcular honorarios de Tarea id: 2");
		System.out.println("Honorarios de tarea id=2: " + sistema.traerTarea(2).calcularHonorarios(6, 2021));	
		
	}

}
