package modelo;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Audiovisual> lstAudiovisual = new ArrayList<Audiovisual>();

	public Sistema() {}

	public List<Audiovisual> getLstAudiovisual() {
		return lstAudiovisual;
	}

	public void setLstAudiovisual(List<Audiovisual> lstAudiovisual) {
		this.lstAudiovisual = lstAudiovisual;
	}

	@Override
	public String toString() {
		return "Sistema: [lstAudiovisual=" + lstAudiovisual + "]";
	}
	
//Casos de Uso: 
	
	public boolean agregarPelicula(String codAudiovisual, String audiovisual, int anio, boolean estreno, String genero, int duracion) throws Exception {
		System.out.println("Se agrego la pelicula.");
		return lstAudiovisual.add(new Pelicula(codAudiovisual, audiovisual, anio, estreno, genero, duracion));
	}
	
	public boolean agregarSerie(String codAudiovisual, String audiovisual, int anio, boolean estreno, String genero, boolean capitulosUnitarios) throws Exception {
		System.out.println("Se agrego la serie.");
		return lstAudiovisual.add(new Serie(codAudiovisual, audiovisual, anio, estreno, genero, capitulosUnitarios));
	}
	
	public Audiovisual traerAudiovisual(String codAudiovisual) {
		Audiovisual audAux = null;
		int i=0;
	
		while(i<lstAudiovisual.size() && audAux==null) {
			if(codAudiovisual.equalsIgnoreCase(lstAudiovisual.get(i).getCodAudiovisual())) {
				audAux = lstAudiovisual.get(i);
			}
			i++;
		}
		return audAux;
	}
	
	public boolean agregarCapitulo(String capitulo, int nroCapitulo, int duracion, Serie serie) {
		Serie s = (Serie) traerAudiovisual(serie.getCodAudiovisual());
		
		System.out.println("Se agrego el capitulo.");
		return s.agregarCapitulo(capitulo, nroCapitulo, duracion, serie);
	}
	
}
