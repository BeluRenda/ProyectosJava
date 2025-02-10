package test;

import java.time.LocalDate;

import modelo.Sistema;

public class tests {

	public static void main(String[] args) {
		Sistema sistema = new Sistema();
		
		System.out.println("Agregar propiedades: ");
		try {
			sistema.agregarCasa(100, "direccion 1", false);
			sistema.agregarCasa(200, "direccion 2", true);
			sistema.agregarDepartamento(300, "direccion 3", 1, 4, true);
			sistema.agregarDepartamento(400, "direccion 4", 2, 1, true);
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		System.out.println("Traer propiedad con id 1: ");
		System.out.println(sistema.traerPropiedad(1));
		
		System.out.println("Intentar agregar propiedades (DEBE FALLAR): ");
		try {
			sistema.alquilarPropiedad(null, LocalDate.of(2022, 03, 01), LocalDate.of(2022, 03, 05), 4);
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		try {
			sistema.alquilarPropiedad(sistema.traerPropiedad(1), LocalDate.of(2022, 03, 05), LocalDate.of(2022, 03, 01), 4);
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		try {
			sistema.alquilarPropiedad(sistema.traerPropiedad(1), LocalDate.of(2022, 03, 01), LocalDate.of(2022, 03, 05), 0);
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		System.out.println("Agregar alquileres: ");
		try {
			System.out.println(sistema.alquilarPropiedad(sistema.traerPropiedad(1), LocalDate.of(2022, 03, 01), LocalDate.of(2022, 03, 05), 4));
			System.out.println(sistema.alquilarPropiedad(sistema.traerPropiedad(2), LocalDate.of(2022, 03, 03), LocalDate.of(2022, 03, 05), 2));
			System.out.println(sistema.alquilarPropiedad(sistema.traerPropiedad(3), LocalDate.of(2022, 03, 05), LocalDate.of(2022, 03, 9), 4));
			System.out.println(sistema.alquilarPropiedad(sistema.traerPropiedad(4), LocalDate.of(2022, 03, 07), LocalDate.of(2022, 03, 10), 2));	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Traer alquileres entre 2022-03-02 y 2022-03-09: ");
		System.out.println(sistema.traerAlquileres(LocalDate.of(2022, 03, 02), LocalDate.of(2022, 03, 9)));
		
		System.out.println("Calcular total recaudado entre 2022-03-02 y 2022-03-09: ");
		System.out.println(sistema.calcularRecaudadoEntre(LocalDate.of(2022, 03, 02), LocalDate.of(2022, 03, 9)));
		
		
		

	}
}
