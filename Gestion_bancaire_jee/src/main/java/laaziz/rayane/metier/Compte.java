package laaziz.rayane.metier;

import java.sql.Date;

public class Compte {
	private String num;
	private Date dateCreation;
	private double Solde;
	private String type;
	private double taux;
	private double decouvert;
	private Client Client;
	
	
	
	public Compte() {
	}

	public Compte(String num, Date dateCreation, double solde, String type, double taux, double decouvert,
			laaziz.rayane.metier.Client client) {
		super();
		this.num = num;
		this.dateCreation = dateCreation;
		this.Solde = solde;
		this.type = type;
		this.taux = taux;
		this.decouvert = decouvert;
		this.Client = client;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public double getSolde() {
		return Solde;
	}

	public void setSolde(double solde) {
		Solde = solde;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	public Client getClient() {
		return Client;
	}

	public void setClient(Client client) {
		Client = client;
	}

	@Override
	public String toString() {
		return "Compte [num=" + num + ", dateCreation=" + dateCreation + ", Solde=" + Solde + ", type=" + type
				+ ", taux=" + taux + ", decouvert=" + decouvert + ", Client=" + Client + "]";
	}
	
	
	
	

}
