package test;

import java.time.LocalDate;

import modelo.Sistema;

public class tests {

	public static void main(String[] args) {
		Sistema sistema = new Sistema();
		
		System.out.println("Agregar pedido de papel mensual y pedido electronico: ");
		try {
			sistema.agregarPedidoPapelMensual(LocalDate.of(2020, 10, 10), 1000, LocalDate.of(2020, 10, 15), 4);
			System.out.println("CU 1-2)");
			sistema.agregarPedidoElectronico(LocalDate.of(2020, 10, 11), 3000, "rotura PC", 200);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Intentar agregar pedidos de papel mensual y electronico (DEBEN FALLAR): ");
		try {
			sistema.agregarPedidoPapelMensual(LocalDate.of(2020, 10, 11), 1000, LocalDate.of(2020, 10, 15), 0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			sistema.agregarPedidoElectronico(LocalDate.of(2020, 10, 12), 3000, "", 200);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Traer precio final de pedidos con id 1 y 2: ");
		System.out.println(sistema.traerPedido(1).calcularPrecioFinal());
		System.out.println(sistema.traerPedido(2).calcularPrecioFinal());
		
		System.out.println("Agregar pedidos: ");
		try {
			sistema.agregarPedidoPapelMensual(LocalDate.of(2020, 10, 12), 1200, LocalDate.of(2020, 10, 16), 3);
			sistema.agregarPedidoElectronico(LocalDate.of(2020, 10, 14), 3000, "rotura PC", 200);
			sistema.agregarPedidoElectronico(LocalDate.of(2020, 10, 15), 3100, "rotura Monitor", 210);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Traer pedido con motivo 'rotura PC': ");
		System.out.println(sistema.traerPedido("rotura PC"));
		
		System.out.println("Traer total a pagar de todos los pedidos: ");
		System.out.println(sistema.calcularTotalGeneral());
		
		
	}
}
