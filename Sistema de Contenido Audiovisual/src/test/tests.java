package test;

import modelo.Serie;
import modelo.Sistema;

public class tests {

	public static void main(String[] args) {
		Sistema sistema = new Sistema();
		
		System.out.println("Intentar agregar pelicula: ");
		try {
		System.out.println(sistema.agregarPelicula("7389189", "TODOS TENEMOS UN MUERTO...", 2021, true, "COMEDIA DRAMATICA", 103));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Intentar agregar serie: ");
		try {
		System.out.println(sistema.agregarSerie("1732485", "Los Simuladores", 2003, false, "DRAMA SOCIAL", true));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Agregar serie 'CORONADOS DE GLORIA': ");
		try {
			System.out.println(sistema.agregarSerie("3748916", "CORONADOS DE GLORIA", 2019, false, "DOCUMENTAL", false));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Agregar 2 capitulos a 'CORONADOS DE GLORIA': ");
		try {
		System.out.println(sistema.agregarCapitulo("EL PRIMER TITULO", 2, 13, (Serie)sistema.traerAudiovisual("3748916")));
		System.out.println(sistema.agregarCapitulo("LA GENESIS DE LA GENERACION DORADA", 1, 14, (Serie)sistema.traerAudiovisual("3748916")));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Agregar peliculas: ");
		try {	
			sistema.agregarPelicula("4689735", "LUNA DE AVELLANEDA", 2004, false, "COMEDIA DRAMATICA", 103);
			sistema.agregarPelicula("7389182", "TODOS TENEMOS UN MUERTO ...", 2021, true, "COMEDIA DRAMATICA", 103);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Agregar serie 'Los Simuladores' y 2 capitulos: ");
		try {	
			sistema.agregarSerie("1732489", "Los Simuladores", 2003, false, "DRAMA SOCIAL", true);
			sistema.agregarCapitulo("Capitulo 2", 2, 35, (Serie)sistema.traerAudiovisual("1732489"));
			sistema.agregarCapitulo("Capitulo 1", 1, 40, (Serie)sistema.traerAudiovisual("1732489"));
			System.out.println(sistema.traerAudiovisual("3748916"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Traer pelicula id 4689735: ");
		try {
			sistema.traerAudiovisual("4689735");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Traer pelicula id 4689735 y calcular duracion: ");
		try {
			System.out.println(sistema.traerAudiovisual("4689735").calcularDuracion());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Traer pelicula id 3748916");
		try {
			sistema.traerAudiovisual("3748916");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Traer pelicula id 3748916 y calcular duracion: ");
		try {
			System.out.println(sistema.traerAudiovisual("3748916").calcularDuracion());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		
		
		
		
		
		
		
	}
}
