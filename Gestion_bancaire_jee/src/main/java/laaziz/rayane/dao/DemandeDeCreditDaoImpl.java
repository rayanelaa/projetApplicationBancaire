package laaziz.rayane.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import laaziz.rayane.metier.Client;
import laaziz.rayane.metier.Compte;
import laaziz.rayane.metier.DemandeDeCredit;

public class DemandeDeCreditDaoImpl implements IDemandeDeCreditDao {
	Connection cnx = SingletonConnection.getConnection();

	@Override
	public DemandeDeCredit save(DemandeDeCredit c) {
		PreparedStatement cps;
		try {
			cps = cnx.prepareStatement("Insert into DemandeDeCredit (numero, "
																			+ "date, "
																			+ "montant, "
																			+ "durée, "
																			+ "taux, "
																			+ "mensualité, "
																			+ "etat, "
																			+ "idClient) values(?,?,?,?,?,?,?)");
			
			cps.setString(1, c.getNumero());
			cps.setDate(2, c.getDate());
			cps.setDouble(3, c.getMontant());
			cps.setInt(4, c.getDurée());
			cps.setDouble(5, c.getTaux());
			cps.setDouble(6, c.getMensualité());
			cps.setString(7, c.getEtat());
			cps.setInt(8, c.getClient().getId());
			
			cps.executeUpdate();
			cps = cnx.prepareStatement("select max(id) as last_id from client");
			
			ResultSet crs = cps.executeQuery();
			
			if(crs.next()) {
				return c;
			}
			
			return c;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
				return null;
	}

	@Override
	public DemandeDeCredit update(DemandeDeCredit c) {
		try {
			PreparedStatement cps = cnx.prepareStatement("update DemandeDeCredit  set"
					+ " date = ?,"
					+ " montant = ?,"
					+ " durée= ?,"
					+ " taux = ?,"
					+ " mensualité = ?,"
					+ " etat = ?"
					+ " where numero = ?");
			
			cps.setDate(1, c.getDate());
			cps.setDouble(2, c.getMontant());
			cps.setInt(7, c.getDurée());
			cps.setDouble(3, c.getTaux());
			cps.setDouble(4, c.getMensualité());
			cps.setString(5, c.getEtat());
			cps.setString(6, c.getNumero());
			
			cps.executeUpdate();
			cps.close();
			
			return this.find(c.getNumero());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return null;
	}

	@Override
	public int delete(DemandeDeCredit c) {
		try {
			PreparedStatement cps = cnx.prepareStatement("delete from DemandeDeCredit where id = ?");
			
			cps.setString(1, c.getNumero());

			return cps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return 0;
	}
	
	

	@Override
	public ArrayList<DemandeDeCredit> getAll(int id) {
		ArrayList<DemandeDeCredit> listeCompte =  new ArrayList<DemandeDeCredit>();
		try {
			PreparedStatement cps = cnx.prepareStatement("select * from DeamndeDeCredit where id =?");
			
			cps.setInt(1,id);
			ResultSet crs = cps.executeQuery();
			
			DemandeDeCredit co ;
			DemandeDeCreditDaoImpl cdi =new DemandeDeCreditDaoImpl();
		
			
			while(crs.next()) {
				co = new DemandeDeCredit();
				
				co.setNumero(crs.getString("numero"));
				co.setDate(crs.getDate("date"));
				co.setMontant(crs.getDouble("montant"));
				co.setDurée(crs.getInt("durée"));
				co.setTaux(crs.getDouble("Taux"));
				co.setEtat(crs.getString("etat"));
				listeCompte.add(co);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return listeCompte;
	}
	
	
	@Override
	public DemandeDeCredit find(String numero) {
		
		return null;
	}
	

}
