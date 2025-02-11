package test;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo.Sistema;

public class tests {

	public static void main(String[] args) {
		Sistema sistema = new Sistema();

		System.out.println("-- Agrego trabajo presencial: ");
		try {
			sistema.agregarTrabajoPresencial(LocalDate.of(2020, 10, 15), "1578", LocalTime.of(9, 00), LocalTime.of(17, 00));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		
		System.out.println("-- Agrego teletrabajo: ");
		try {
			sistema.agregarTeletrabajo(LocalDate.of(2020, 10, 15), "3782", "Pandemia", 5);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("-- Intenta agregar trabajo presencial (DEBE FALLAR): ");
		try {
			sistema.agregarTrabajoPresencial(LocalDate.of(2020, 10, 15), "1578", LocalTime.of(10, 00), LocalTime.of(18, 00));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			sistema.agregarTeletrabajo(LocalDate.of(2020, 10, 16), "3782", "Pandemia", 9);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("-- Traer la cantidad de horas trabajadas para asistencias con id 1 y 2: ");
		System.out.println("cantidad de horas trabajadas: " + sistema.traerAsistencia(1).calcularHorasTrabajadas());
		System.out.println("cantidad de horas trabajadas: " + sistema.traerAsistencia(2).calcularHorasTrabajadas());
		
		System.out.println("-- Agrego 1 trabajo presencial y 2 teletrabajos: ");
		try {
			sistema.agregarTrabajoPresencial(LocalDate.of(2020, 10, 15), "2839", LocalTime.of(9, 00), LocalTime.of(17, 00));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			sistema.agregarTeletrabajo(LocalDate.of(2020, 10, 16), "3452", "Pandemia", 5);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			sistema.agregarTeletrabajo(LocalDate.of(2020, 10, 16), "5243", "Pandemia", 7);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("-- Traigo todas las asistencias del 15-10-2020: ");
		System.out.println(sistema.traerAsistencia(LocalDate.of(2020, 10, 15)));
		
		System.out.println("-- Traigo todas las asistencias de Teletrabajo: ");	
		System.out.println(sistema.traerAsistenciaVirtual(true));
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
