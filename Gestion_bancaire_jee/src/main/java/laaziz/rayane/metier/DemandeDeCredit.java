package laaziz.rayane.metier;

import java.sql.Date;

public class DemandeDeCredit {
	
	private String numero;
	private Date date;
	private Double montant;
	private int durée;
	private Double taux;
	private Double mensualité;
	private String etat;
	private Client client;
	
	public DemandeDeCredit() {
	
	}

	public DemandeDeCredit(String numero, Date date, Double montant, int durée, Double taux, Double mensualité,
			String etat, Client client) {
		
		this.numero = numero;
		this.date = date;
		this.montant = montant;
		this.durée = durée;
		this.taux = taux;
		this.mensualité = mensualité;
		this.etat = etat;
		this.client = client;
	}

	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public int getDurée() {
		return durée;
	}

	public void setDurée(int durée) {
		this.durée = durée;
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}

	public Double getMensualité() {
		return mensualité;
	}

	public void setMensualité(Double mensualité) {
		this.mensualité = mensualité;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "DemandeDeCredit [numero=" + numero + ", date=" + date + ", montant=" + montant + ", durée=" + durée
				+ ", taux=" + taux + ", mensualité=" + mensualité + ", etat=" + etat + ", client=" + client + "]";
	}
	
	
	
	
	

}
