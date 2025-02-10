package test;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo.Sistema;

public class tests {

	public static void main(String[] args) {
		Sistema sistema = new Sistema();
		
		System.out.println("Agregar empleado o visita: ");
		System.out.println(sistema.agregarVisita("Martino", "Marcelo", 44444444, "Coop TIC"));
		System.out.println(sistema.agregarEmpleado("Lopez", "Martin", 33333333, 3829));
		System.out.println(sistema.agregarEmpleado("Rodriguez", "Lucia", 11111111, 3840));
		System.out.println(sistema.agregarVisita("Molina", "Rocio", 22222222, "UNLa"));
		System.out.println(sistema.agregarVisita("Martino", "Marcelo", 44444444, "Coop TIC"));
		
		System.out.println("Traer persona por ID 1: ");
		System.out.println(sistema.traerPersona(1));
		
		System.out.println("Agregar seguridad: ");
		try {
			sistema.agregarSeguridad(LocalDate.of(2021, 9, 06), LocalTime.of(7, 50), true, sistema.traerPersona(1));
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		try {
			sistema.agregarSeguridad(LocalDate.of(2021, 9, 06), LocalTime.of(8, 00), true, sistema.traerPersona(2));
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		try {
			sistema.agregarSeguridad(LocalDate.of(2021, 9, 06), LocalTime.of(18, 10), false, sistema.traerPersona(1));
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		try {
			sistema.agregarSeguridad(LocalDate.of(2021, 9, 06), LocalTime.of(18, 20), false, sistema.traerPersona(2));
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		try {
			sistema.agregarSeguridad(LocalDate.of(2021, 9, 07), LocalTime.of(9, 00), true, sistema.traerPersona(3));
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		try {
			sistema.agregarSeguridad(LocalDate.of(2021, 9, 07), LocalTime.of(9, 10), true, sistema.traerPersona(4));
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		try {
			sistema.agregarSeguridad(LocalDate.of(2021, 9, 07), LocalTime.of(18, 10), false, sistema.traerPersona(3));
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		try {
			sistema.agregarSeguridad(LocalDate.of(2021, 9, 07), LocalTime.of(18, 20), false, sistema.traerPersona(4));
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		System.out.println("Traer seguridad para persona con ID 4 y fecha 2021-09-07: ");
		System.out.println(sistema.traerSeguridad(LocalDate.of(2021, 9, 07), sistema.traerPersona(4)));
		
		System.out.println("Intentar agregar seguridad con doble entrada (DEBE FALLAR): ");
		try {
			sistema.agregarSeguridad(LocalDate.of(2021, 9, 07), LocalTime.of(18, 25), false, sistema.traerPersona(4));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Traer seguridad para visitas de fecha 2021-09-07: ");
		System.out.println(sistema.traerVisita(LocalDate.of(2021, 9, 07)));
		
	}
}
