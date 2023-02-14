package Model;

import java.util.Date;

public class Conferenza {
	private String titoloConferenza;
	private Date dataInizio;
	private Date dataFine;
	private String descrizione;
	private int codConferenza; //Il primo codice conferenza deve essere 1
	private String nomeSede; //chiave esterna
	
	//Costruttori
	
	//Metodi gets
	public String getTitoloConferenza() {
		return titoloConferenza;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public Date getDataInizio() {
		return dataInizio;
	}
	public Date getDataFine() {
		return dataFine;
	}
	public String getNomeSede() {
		return nomeSede;
	}
	
	//Metodi sets
	public void setTitoloCoferenza(String titoloConferenza) {
		this.titoloConferenza = titoloConferenza;
	}
	public void setCodConferenza (int codConferenza) {
		this.codConferenza= codConferenza;
	}
	public void setDataInizio (Date dataInizio) {
		this.dataInizio= dataInizio;
	}
	public void setDataFine (Date dataFine) {
		this.dataFine= dataFine;
	}
	public void setDescrizione (String descrizione) {
		this.descrizione= descrizione;
	}
	public void setNomeSede(String nomeSede) {
		this.nomeSede= nomeSede;
	}
}
