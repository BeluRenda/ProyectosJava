package modelo;

public class Capitulo {
	private String capitulo;
	private int nroCapitulo;
	private int duracion;
	
	public Capitulo(String capitulo, int nroCapitulo, int duracion) {
		super();
		this.capitulo = capitulo;
		this.nroCapitulo = nroCapitulo;
		this.duracion = duracion;
	}

	public String getCapitulo() {
		return capitulo;
	}

	public void setCapitulo(String capitulo) {
		this.capitulo = capitulo;
	}

	public int getNroCapitulo() {
		return nroCapitulo;
	}

	public void setNroCapitulo(int nroCapitulo) {
		this.nroCapitulo = nroCapitulo;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Capitulo: [capitulo=" + capitulo + ", nroCapitulo=" + nroCapitulo + ", duracion=" + duracion + "]";
	}	
	
}
