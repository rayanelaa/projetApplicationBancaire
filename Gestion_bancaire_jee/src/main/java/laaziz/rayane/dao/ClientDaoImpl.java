package laaziz.rayane.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import laaziz.rayane.metier.Client;

public class ClientDaoImpl implements IClientDao {


	Connection cnx = SingletonConnection.getConnection(); 
	public Client save(Client c) {
		Connection cnx = SingletonConnection.getConnection();
		try {
			PreparedStatement cps = cnx.prepareStatement("Insert into client (nom, "
																			+ "prenom, "
																			+ "date_naissance, "
																			+ "tel, "
																			+ "adresse, "
																			+ "mail, "
																			+ "civilite) values(?,?,?,?,?,?,?)");
			cps.setString(1, c.getNom());
			cps.setString(2, c.getPrenom());
			cps.setDate(3, c.getDateNaissance());
			cps.setString(4, c.getTel());
			cps.setString(5, c.getAdresse());
			cps.setString(6, c.getMail());
			cps.setString(7, c.getCivilite());
			
			cps.executeUpdate();
			cps =cnx.prepareStatement("select max(id) as last_id from client");
			ResultSet crs = cps.executeQuery();
			
			if(crs.next()) {
				c.setId(crs.getInt("last_id"));
				return c;
			}

			
			return c;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	public Client update(Client c) {
		
		try {
			PreparedStatement cps = cnx.prepareStatement("update client set"
					+ " nom = ?,"
					+ " prenom = ?,"
					+ " tel = ?,"
					+ " adresse= ?,"
					+ " mail = ?,"
					+ " civilite = ?,"
					+ " date_naissance = ?"
					+ " where id = ?");
			
			cps.setString(1, c.getNom());
			cps.setString(2, c.getPrenom());
			cps.setDate(7, c.getDateNaissance());
			cps.setString(3, c.getTel());
			cps.setString(4, c.getAdresse());
			cps.setString(5, c.getMail());
			cps.setString(6, c.getCivilite());
			cps.setInt(8, c.getId());
			
			cps.executeUpdate();
			cps.close();
			
			return this.find(c.getId());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public int delete(Client c) {
		try {
			PreparedStatement cps = cnx.prepareStatement("delete from client where id = ?");
			
			cps.setInt(1, c.getId());
			
			return cps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return 0;
		
	}

	
	public ArrayList<Client> getAll() {
		
		ArrayList<Client> listClient =  new ArrayList<Client>();
		try {
			PreparedStatement cps = cnx.prepareStatement("select * from client");
			
			
			ResultSet crs = cps.executeQuery();
			
			Client c ;
			
			while(crs.next()) {
				c = new Client();
				c.setId(crs.getInt("id"));
				c.setNom(crs.getString("nom"));
				c.setPrenom(crs.getString("prenom"));
				c.setAdresse(crs.getString("adresse"));
				c.setMail(crs.getString("mail"));
				c.setTel(crs.getString("Tel"));
				c.setCivilite(crs.getString("civilite"));
				c.setDateNaissance(crs.getDate("date_naissance"));
				listClient.add(c);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listClient;
	
	}

	
	public ArrayList<Client> getAll(String nom) {
		ArrayList<Client> listClient =  new ArrayList<Client>();
		try {
			PreparedStatement cps = cnx.prepareStatement("select * from client where nom like ?");
			
			cps.setString(1, '%' + nom + '%');
			ResultSet crs = cps.executeQuery();
			
			Client c ;
			
			while(crs.next()) {
				c = new Client();
				c.setId(crs.getInt("id"));
				c.setNom(crs.getString("nom"));
				c.setPrenom(crs.getString("prenom"));
				c.setAdresse(crs.getString("adresse"));
				c.setMail(crs.getString("mail"));
				c.setTel(crs.getString("Tel"));
				c.setCivilite(crs.getString("civilite"));
				c.setDateNaissance(crs.getDate("date_naissance"));
				listClient.add(c);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listClient;
	}
	
	public ArrayList<Client> getAll(String nom, String prenom) {
		ArrayList<Client> listClient =  new ArrayList<Client>();
		try {
			PreparedStatement cps = cnx.prepareStatement("select * from client where nom like ? and prenom like ?");
			
			cps.setString(1, '%' + nom + '%');
			cps.setString(2, '%' + prenom + '%');
			ResultSet crs = cps.executeQuery();
			
			Client c ;
			
			while(crs.next()) {
				c = new Client();
				c.setId(crs.getInt("id"));
				c.setNom(crs.getString("nom"));
				c.setPrenom(crs.getString("prenom"));
				c.setAdresse(crs.getString("adresse"));
				c.setMail(crs.getString("mail"));
				c.setTel(crs.getString("Tel"));
				c.setCivilite(crs.getString("civilite"));
				c.setDateNaissance(crs.getDate("date_naissance"));
				listClient.add(c);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listClient;
	}


	public Client find(int id) {
		try {
			PreparedStatement cps = cnx.prepareStatement("select* from client where id = ?");
			
			cps.setInt(1, id);
			ResultSet crs =cps.executeQuery();
			
			if (crs.next()) {
				Client c  = new Client ();
				c.setId(crs.getInt("id"));
				c.setNom(crs.getString("nom"));
				c.setPrenom(crs.getString("prenom"));
				c.setAdresse(crs.getString("adresse"));
				c.setMail(crs.getString("mail"));
				c.setTel(crs.getString("tel"));
				c.setCivilite(crs.getString("civilite"));
				c.setDateNaissance(crs.getDate("date_naissance"));
				return c;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	
		return null;
	}


	public Client find(String nom) {
		try {
			PreparedStatement cps = cnx.prepareStatement("select*from client where nom = ?");
			
			cps.setString(1, nom);
			ResultSet crs = cps.executeQuery();
			if(crs.next()) {
				Client c = new Client();
				c.setId(crs.getInt("id"));
				c.setNom(crs.getString("nom"));
				c.setPrenom(crs.getString("prenom"));
				c.setAdresse(crs.getString("adresse"));
				c.setMail(crs.getString("mail"));
				c.setTel(crs.getString("tel"));
				c.setCivilite(crs.getString("civilite"));
				c.setDateNaissance(crs.getDate("date_naissance"));
				return c;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		
		}
		
		return null;
	}

	@Override
	public Client find(String nom, String prenom) {
		try {
			PreparedStatement cps = cnx.prepareStatement("select * from client where nom = ? and prenom = ?");
			
			cps.setString(1, nom);
			cps.setString(2, prenom);
			ResultSet crs = cps.executeQuery();
			
			if(crs.next()) {
				Client c = new Client();
				c.setId(crs.getInt("id"));
				c.setNom(crs.getString("nom"));
				c.setPrenom(crs.getString("prenom"));
				c.setAdresse(crs.getString("adresse"));
				c.setMail(crs.getString("mail"));
				c.setTel(crs.getString("Tel"));
				c.setCivilite(crs.getString("civilite"));
				c.setDateNaissance(crs.getDate("date_naissance"));
				return c;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int count() {
		try {
			PreparedStatement cps = cnx.prepareStatement("select count(*) as total from client");
			
			ResultSet crs = cps.executeQuery();
			
			if(crs.next()) return crs.getInt("total");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	

}


//Client ----> IClientDao ----> ClientDaoImpl ----> SigletonConnection ----> Jdbc ----> Mysql(SGBDR)


//Requete:   connextion ----> PreparedStatement(requete) ----> Remplacer les paramètres ----> ExecuteQuery (Update)
//			|-----> ResultSet	

//Framwork : Jpa Hibernate (DATA)


//Besoins fonctionnels
//Besoins techniques

