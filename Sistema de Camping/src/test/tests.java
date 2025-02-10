package test;

import modelo.Sistema;

import java.time.LocalDate;

public class tests {

	public static void main(String[] args) {
		
		Sistema sistema = new Sistema();
		
		System.out.println("Agregar personas: ");
		try {
			System.out.println(sistema.agregarPersona("Sergio", "Lopez", 11111111));
			System.out.println(sistema.agregarPersona("Juan", "Rodriguez", 22222222));
			System.out.println(sistema.agregarPersona("Maria", "Fernandez", 33333333));
			System.out.println(sistema.agregarPersona("Juan", "Vazquez", 44444444));
			System.out.println(sistema.agregarPersona("Ana", "Martinez", 55555555));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Agregar Recreo o Campamento: ");
		try {
			System.out.println(sistema.agregarRecreo("7358902", LocalDate.of(2022, 9, 02), false, sistema.traerPersona(11111111), 5, 300));
			System.out.println(sistema.agregarCampamento("6573540", LocalDate.of(2022, 9, 03), false, sistema.traerPersona(22222222), null, 1, 1500));
			System.out.println(sistema.agregarRecreo("3571398", LocalDate.of(2022, 9, 3), false, sistema.traerPersona(33333333), 10, 300));
			System.out.println(sistema.agregarCampamento("2583941", LocalDate.of(2022, 9, 3), false, sistema.traerPersona(44444444), LocalDate.of(2022, 9, 8), 2, 1500));
			System.out.println(sistema.agregarRecreo("5243925", LocalDate.of(2022, 9, 3), true, sistema.traerPersona(55555555), 8, 300));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Traer servicio por precio final, valor de 500: ");
		System.out.println(sistema.traerServiciosPorPrecioFinal(500));
		
		System.out.println("Traer campamento por cantidad de dias, 4 dias: ");
		System.out.println(sistema.traerCampamentosPorDias(4));
		
		System.out.println("Intentar agregar persona con DNI falso (DEBE FALLAR): ");
		try {
			sistema.agregarPersona("Vazquez", "Juan", 44444444);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Intentar agregar recreo con codigo de ingreso invalido (DEBE FALLAR): ");
		try {
			sistema.agregarRecreo("3571394", LocalDate.of(2022, 9, 10), false, sistema.traerPersona(33333333), 5, 300);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
