package modelo;

public class Departamento extends Propiedad {
	private int cantidadAmbientes;
	private int nroPiso;
	private boolean tieneAscensor;
	
	public Departamento(int id, double precioBase, String direccion, int cantidadAmbientes, int nroPiso,
			boolean tieneAscensor) {
		super(id, precioBase, direccion);
		this.cantidadAmbientes = cantidadAmbientes;
		this.nroPiso = nroPiso;
		this.tieneAscensor = tieneAscensor;
	}

	public int getCantidadAmbientes() {
		return cantidadAmbientes;
	}

	public void setCantidadAmbientes(int cantidadAmbientes) {
		this.cantidadAmbientes = cantidadAmbientes;
	}

	public int getNroPiso() {
		return nroPiso;
	}

	public void setNroPiso(int nroPiso) {
		this.nroPiso = nroPiso;
	}

	public boolean isTieneAscensor() {
		return tieneAscensor;
	}

	public void setTieneAscensor(boolean tieneAscensor) {
		this.tieneAscensor = tieneAscensor;
	}

	@Override
	public String toString() {
		return super.toString() + "Departamento: [cantidadAmbientes=" + cantidadAmbientes + ", nroPiso=" + nroPiso + ", tieneAscensor="
				+ tieneAscensor + "]";
	}
	
//Casos de Uso:
	
	public double precioPorNoche() {
		return precioBase + (cantidadAmbientes * 100);
	}
	
}
