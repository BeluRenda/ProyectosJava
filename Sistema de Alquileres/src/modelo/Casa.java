package modelo;

public class Casa extends Propiedad {
	private boolean tienePatio;

	public Casa(int id, double precioBase, String direccion, boolean tienePatio) {
		super(id, precioBase, direccion);
		this.tienePatio = tienePatio;
	}

	public boolean isTienePatio() {
		return tienePatio;
	}

	public void setTienePatio(boolean tienePatio) {
		this.tienePatio = tienePatio;
	}

	@Override
	public String toString() {
		return super.toString() + "Casa: [tienePatio=" + tienePatio + "]";
	}
	
//Casos de Uso:	
	
	public double precioPorNoche() {
		double valor;
		
		if(tienePatio==true) {
			valor = precioBase * 0.1;
		} else {
			valor = precioBase; 
		}
		return valor;
	}
	
}
