package rubrica;


public class EsempioRubrica {
	public static void main(String[] args) {
		Rubrica r = new Rubrica("Marco");
		
		Voce voce1 = new Voce("Marco", "Boemi", 349645151);
		Voce voce2 = new Voce("Barbara", "Olzia", 34956788);
		Voce voce3 = new Voce("Luca", "Boh", 345576151);
		
//		List<Voce> listaStudenti = new ArrayList<>();
		
//		listaStudenti.add(voce1);
//		listaStudenti.add(voce2);
//		listaStudenti.add(voce3);
		
		r.inserisciVoce(voce1);
		r.inserisciVoce(voce2);
		r.inserisciVoce(voce3);
		
		for (Voce v: r.getVoci()) {
			System.out.println(v.getNome()+" "+v.getCognome()+" - "+v.getTelefono());
		}
	}
}
