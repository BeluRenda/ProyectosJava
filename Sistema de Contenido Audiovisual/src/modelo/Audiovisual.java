package modelo;

public abstract class Audiovisual {
	protected String codAudiovisual;
	protected String titulo;
	protected int anio;
	protected boolean estreno;
	protected String genero;
	
	public Audiovisual(String codAudiovisual, String titulo, int anio, boolean estreno, String genero) {
		super();
		this.codAudiovisual = codAudiovisual;
		this.titulo = titulo;
		this.anio = anio;
		this.estreno = estreno;
		this.genero = genero;
	}

	public String getCodAudiovisual() {
		return codAudiovisual;
	}

	public void setCodAudiovisual(String codAudiovisual) {
		this.codAudiovisual = codAudiovisual;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public boolean isEstreno() {
		return estreno;
	}

	public void setEstreno(boolean estreno) {
		this.estreno = estreno;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Audiovisual: [codAudiovisual=" + codAudiovisual + ", titulo=" + titulo + ", anio=" + anio + ", estreno="
				+ estreno + ", genero=" + genero + "]";
	}
	
	public boolean codigoVerificador(String codAudiovisual) {
		boolean codCorrecto = false;
		int sumaImpares = 0;
		int sumaPares = 0;
		int digitVerifImpares;
		int sumaParesImpares;
		int variableAux = 0;
		int i;

		for(i=0; i<codAudiovisual.length()-1; i++) {
			if(i%2==0) {
				sumaImpares += Character.getNumericValue(codAudiovisual.charAt(i));
			}	
		}
		
		digitVerifImpares = sumaImpares * 3;
		
		for(i=0; i<codAudiovisual.length()-1; i++) {
			if(i%2!=0) {
				sumaPares += Character.getNumericValue(codAudiovisual.charAt(i));
			}
			
		}
		
		sumaParesImpares = digitVerifImpares + sumaPares;

		while(sumaParesImpares%10!=0) {
			variableAux++;
			sumaParesImpares++;
		}
		
		if(variableAux == Character.getNumericValue(codAudiovisual.charAt(codAudiovisual.length()-1))) {
			codCorrecto=true;
		}		
		return codCorrecto;
	}
	
	public abstract int calcularDuracion();
	
}
