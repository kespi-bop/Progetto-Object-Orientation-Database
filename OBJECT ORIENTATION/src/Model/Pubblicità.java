package Model;

public class PubblicitĂ  {
	private Conferenza conferenza;
	private Sponsor sponsor;
	private Double spesa;
	
	public PubblicitĂ (){
		
	}
	
	//metodi getter
	public Conferenza getConferenza() {
		return conferenza;
	}
	
	public Sponsor getSponsor() {
		return sponsor;
	}
	
	public Double getSpesa() {
		return spesa;
	}
	
	//metodi setter
	public void setCoferenza(Conferenza conferenza) {
		this.conferenza = conferenza;
	}
	
	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}
	
	public void setSpesa(Double spesa) {
		this.spesa = spesa;
	}
}
