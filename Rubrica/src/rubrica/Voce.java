package rubrica;

public class Voce {

	private String nome;
	private String cognome;
	private int telefono;
	
	
	public Voce(String nome, String cognome, int telefono) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

}
