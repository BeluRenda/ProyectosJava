package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Pedido> pedidos = new ArrayList<Pedido>();

	public Sistema() {}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		return "Sistema: [pedidos=" + pedidos + "]";
	}
	
//Casos de Uso:	
	
	public Pedido traerPedido(int idPedido) {
		Pedido pAux = null;
		int i=0;
		
		while(i<pedidos.size() && pAux==null) {
			if(idPedido == pedidos.get(i).getIdPedido()) {
				pAux = pedidos.get(i);
			}
			i++;
		}
		return pAux;
	}
	
	
	public List<Pedido> traerPedido(String motivo) {
		//retorna una lista del tipo Pedido segun el motivo ingresado	
		List<Pedido> lstPedidosAux = new ArrayList<Pedido>();
		
		for(Pedido p : pedidos) {
			if(p instanceof PedidoElectronico) {
				lstPedidosAux.add((PedidoElectronico) p);
			}
		}
		return lstPedidosAux;
	}
	
	
	public boolean agregarPedidoPapelMensual(LocalDate fechaCreacion, double montoBase, LocalDate fechaEntrega, int cantidadResmas) throws Exception{
	//lanza una excepción en caso de que la cantidad de resmas sea 0	
		int id=1;
			
		if(pedidos.size()>0) {
			id = pedidos.get(pedidos.size()-1).getIdPedido()+1;
		}
			
		if(cantidadResmas==0) {
			throw new Exception("Error: La cantidad de remas no puede ser 0.");
		}
			
		System.out.println("Se agrego el pedido por papel mensual.");
		return pedidos.add(new PedidoPapelMensual(id, fechaCreacion, montoBase, fechaEntrega, cantidadResmas));
	}
	
	
	public boolean agregarPedidoElectronico(LocalDate fechaCreacion, double montoBase, String motivo, double porcentajeExtra) throws Exception {
	//lanza una excepción en caso de que el motivo sea un String vacío	
		int id=1;
		
		if(pedidos.size()>0) {
			id = pedidos.get(pedidos.size()-1).getIdPedido()+1;
		}
			
		if(motivo.isEmpty()) {
			throw new Exception("Error: El motivo no puede estar vacio.");
		}
			
		System.out.println("Se agrego el pedido electronico.");
		return pedidos.add(new PedidoElectronico(id, fechaCreacion, montoBase, motivo, porcentajeExtra));
	}
	
	
	public double calcularTotalGeneral() {
	//retorna un double con el total general a pagar de todos los pedidos
		double valorTotalGeneral=0;
			
		for(Pedido p : pedidos) {
			valorTotalGeneral += p.calcularPrecioFinal();	
		}
		return valorTotalGeneral;
	}
	
	
}
