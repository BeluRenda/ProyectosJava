package modelo;

public abstract class Propiedad {
	protected int id;
	protected double precioBase;
	protected String direccion;
	
	public Propiedad(int id, double precioBase, String direccion) {
		super();
		this.id = id;
		this.precioBase = precioBase;
		this.direccion = direccion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Propiedad: [id=" + id + ", precioBase=" + precioBase + ", direccion=" + direccion + "] ";
	}
	
//Casos de Uso:	
	
	public abstract double precioPorNoche();	
	
}
