package laaziz.rayane.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import laaziz.rayane.metier.Client;
import laaziz.rayane.metier.Compte;

public class CompteDaoImpl implements ICompteDao {
	Connection cnx = SingletonConnection.getConnection();

	@Override
	public Compte save(Compte c) {
		try {
			PreparedStatement cps = cnx.prepareStatement("Insert into compte (num, "
																			+ "dateCreation, "
																			+ "solde, "
																			+ "type, "
																			+ "taux, "
																			+ "decouvert, "
																			+ "idclient) values(?,?,?,?,?,?,?)");
			cps.setString(1, c.getNum());
			cps.setDate(2, c.getDateCreation());
			cps.setDouble(3, c.getSolde());
			cps.setString(4, c.getType());
			cps.setDouble(5, c.getTaux());
			cps.setDouble(6, c.getDecouvert());
			cps.setInt(7, c.getClient().getId());
			
			cps.executeUpdate();
			cps =cnx.prepareStatement("select max(id) as last_id from client");
			ResultSet crs = cps.executeQuery();
			
			if(crs.next()) {
				
				return c;
			}

			
			return c;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
		
		
	
		
		
	@Override
	public Compte update(Compte c) {
		try {
			PreparedStatement cps = cnx.prepareStatement("update compte set"
					+ " dateCreation = ?,"
					+ " solde = ?,"
					+ " type = ?,"
					+ " taux= ?,"
					+ " decouvert = ?,"
					+ " where num = ?");
			
			cps.setDate(1, c.getDateCreation());
			cps.setDouble(2, c.getSolde());
			cps.setString(3, c.getType());
			cps.setDouble(4, c.getTaux());
			cps.setDouble(5, c.getDecouvert());
			cps.setString(6, c.getNum());
			
			cps.executeUpdate();
			cps.close();
			
			return this.find(c.getNum());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int delete(Compte c) {
		try {
			PreparedStatement cps = cnx.prepareStatement("delete from compte where id = ?");
			
			cps.setString(1, c.getNum());
			
			return cps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return 0;
		
	}
	





	@Override
	public ArrayList<Compte> getAll(int id) {
		
		ArrayList<Compte> listeCompte =  new ArrayList<Compte>();
		try {
			PreparedStatement cps = cnx.prepareStatement("select * from compte where id =?");
			
			cps.setInt(1,id);
			ResultSet crs = cps.executeQuery();
			
			Compte co ;
			ClientDaoImpl cdi =new ClientDaoImpl();
			Client c = cdi.find(id);
			
			while(crs.next()) {
				co = new Compte();
				co.setClient(c);
				co.setNum(crs.getString("num"));
				co.setDateCreation(crs.getDate("dateCreation"));
				co.setSolde(crs.getDouble("solde"));
				co.setType(crs.getString("type"));
				co.setTaux(crs.getDouble("Taux"));
				co.setDecouvert(crs.getDouble("decouvert"));
				listeCompte.add(co);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeCompte;
	}
	





	@Override
	public Compte find(String num) {
		try {
			PreparedStatement cps = cnx.prepareStatement("select * from compte where num = ?");
			
			cps.setString(1, num);
			ResultSet crs = cps.executeQuery();
			
			if(crs.next()) {
				Compte co = new Compte();
				co.setNum(crs.getString("num"));
				co.setDateCreation(crs.getDate("dateCreation"));
				co.setSolde(crs.getDouble("solde"));
				co.setType(crs.getString("type"));
				co.setTaux(crs.getDouble("taux"));
				co.setDecouvert(crs.getDouble("decouvert"));
				
				return co;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	} 
	
	

}
