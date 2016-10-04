package rubrica;
import java.util.ArrayList;
import java.util.List;


public class Rubrica {
	
	//ATTRIBUTI
	private String nome;
	private List<Voce> voci = new ArrayList<>();
	

	//COSTRUTTORE
	public Rubrica(String nome){
		this.nome = nome;
	}
	public Rubrica(){
		
	}
	
	//INSERIMENTO
	public void inserisciVoce(Voce v){
		voci.add(v);
	}

	// GET E SET
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Voce> getVoci() {
		return voci;
	}

	public void setVoci(List<Voce> voci) {
		this.voci = voci;
	}
}
