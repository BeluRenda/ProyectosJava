package modelo;

import java.util.ArrayList;
import java.util.List;

public class Serie extends Audiovisual {
	private boolean capitulosUnitarios;
	private List<Capitulo> lstCapitulos = new ArrayList<Capitulo>();
	
	public Serie(String codAudiovisual, String titulo, int anio, boolean estreno, String genero,
			boolean capitulosUnitarios) {
		super(codAudiovisual, titulo, anio, estreno, genero);
		this.capitulosUnitarios = capitulosUnitarios;
	}

	public boolean isCapitulosUnitarios() {
		return capitulosUnitarios;
	}

	public void setCapitulosUnitarios(boolean capitulosUnitarios) {
		this.capitulosUnitarios = capitulosUnitarios;
	}

	public List<Capitulo> getLstCapitulos() {
		return lstCapitulos;
	}

	public void setLstCapitulos(List<Capitulo> lstCapitulos) {
		this.lstCapitulos = lstCapitulos;
	}

	@Override
	public String toString() {
		return super.toString() + "Serie: [capitulosUnitarios=" + capitulosUnitarios + ", lstCapitulos=" + lstCapitulos + "]";
	}
	
	public int calcularDuracion() {
		int sumatoria = 0;

		for(Capitulo c : lstCapitulos) {
			sumatoria += c.getDuracion();
		}
		return sumatoria;
	}
	
	public boolean agregarCapitulo(String capitulo, int nroCapitulo, int duracion, Serie serie) {
	    
		// Verificar si el capitulo ya existe
	    for (Capitulo c : serie.getLstCapitulos()) {
	        if (c.getNroCapitulo() == nroCapitulo) {
	            return false;
	        }
	    }

	    Capitulo nuevoCapitulo = new Capitulo(capitulo, nroCapitulo, duracion);
	    serie.getLstCapitulos().add(nuevoCapitulo);

	    return true;
	}
	
}
