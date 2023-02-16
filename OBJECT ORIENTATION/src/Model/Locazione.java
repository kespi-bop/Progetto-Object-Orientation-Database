package Model;

import java.util.ArrayList;

public class Locazione {
	private String nomeLocazione;
	private String nomeSede;
	public Sede sedeProprietaria;
	
	//Costruttori
	public ArrayList<Sessione> sessioniAccolte = new ArrayList<Sessione>();
	public Locazione() {}
	
	//Trasposizione sessione-locazione (0..*,1)
	public Locazione(Sessione ref$Sessione) {
		sessioniAccolte.add(ref$Sessione);
		ref$Sessione.luogoLocazione=this;
	}
	
	public Locazione (Sede ref$Sede) {
		sedeProprietaria=ref$Sede;
		ref$Sede.locazioniSede.add(this);
	}
	//Metodi gets
	
	public String getNomeLocazione() {
		return nomeLocazione;
	}
	public String getNomeSede() {
		return nomeSede;
	}
	
	//Metodi sets
	
	public void setNomeLocazione(String nomeLocazione) {
		this.nomeLocazione = nomeLocazione;
	}
	public void setNomeSede(String nomeSede) {
		this.nomeSede = nomeSede;
	}
}
