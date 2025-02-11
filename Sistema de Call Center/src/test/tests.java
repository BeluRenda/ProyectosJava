package test;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo.Cliente;
import modelo.Empleado;
import modelo.Sistema;

public class tests {

	public static void main(String[] args) {
		Sistema sistema = new Sistema();
		
		System.out.println("-- Agrego 2 empleados y 2 clientes: ");
		try {
			sistema.agregarEmpleado("Pedro", "Gomez", 33333333, LocalDate.of(2022, 02, 11), 10000);
			sistema.agregarEmpleado("Pablo", "Lopez", 44444444, LocalDate.of(2022, 03, 15), 9000);
			sistema.agregarCliente("Luis", "Perez", 11111111, LocalDate.of(2022, 01, 01), true);
			sistema.agregarCliente("Lucas", "Pereyra", 22222222, LocalDate.of(2022, 02, 01), false);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("-- Agrego llamadas: ");
		try {
			sistema.agregarLlamada(LocalDate.of(2022, 11, 06), LocalTime.of(10, 10), (Cliente)sistema.traerPersona(11111111), (Empleado)sistema.traerPersona(33333333), 5);
			sistema.agregarLlamada(LocalDate.of(2022, 11, 07), LocalTime.of(10, 10), (Cliente)sistema.traerPersona(11111111), (Empleado)sistema.traerPersona(33333333), 5);
			sistema.agregarLlamada(LocalDate.of(2022, 11, 07), LocalTime.of(10, 15), (Cliente)sistema.traerPersona(22222222), (Empleado)sistema.traerPersona(33333333), 5);
			sistema.agregarLlamada(LocalDate.of(2022, 11, 07), LocalTime.of(10, 20), (Cliente)sistema.traerPersona(11111111), (Empleado)sistema.traerPersona(44444444), 3);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("-- Traigo clientes activos: ");
		System.out.println(sistema.traerClientes(true));		
		
		System.out.println("-- Traigo personas con 2 años de antiguedad: ");
		System.out.println(sistema.traerPersonasAntiguedad(2));	
		
		System.out.println("-- Traigo llamadas realizadas el 2022-11-17 entre las 10:10 y las 10:18: ");
		System.out.println(sistema.traerLlamadas(LocalDate.of(2022, 11, 17), LocalTime.of(10, 10), LocalTime.of(10, 18)));
		
		System.out.println("-- Intenta agregar cliente con DNI de otro cliente (DEBE FALLAR):");
		try {
			System.out.println(sistema.agregarCliente("Marcos", "Rios", 22222222, LocalDate.of(2022, 02, 01), true));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("-- Intenta agregar empleado con DNI de otro empleado (DEBE FALLAR):");
		try {
			System.out.println(sistema.agregarEmpleado("Miguel", "Martinez", 44444444, LocalDate.of(2022, 02, 11), 9500));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("-- Intenta agregar llamada con valor de satisfaccion invalido (DEBE FALLAR):");
		try {
			sistema.agregarLlamada(LocalDate.of(2022, 11, 07), LocalTime.of(10, 30), (Cliente)sistema.traerPersona(11111111), (Empleado)sistema.traerPersona(33333333), 7);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		
		
		
		
		
		
		
		
		
		
		

	}
}
