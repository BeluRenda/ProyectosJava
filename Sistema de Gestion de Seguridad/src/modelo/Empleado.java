package modelo;

public class Empleado extends Persona {
	private int legajo;
	
	public Empleado(int id, String apellido, String nombre, int dni, int legajo) {
		super(id, apellido, nombre, dni);
		this.legajo = legajo;
	}
	
	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Empleado: [legajo= " + legajo + "]";
	}
}
