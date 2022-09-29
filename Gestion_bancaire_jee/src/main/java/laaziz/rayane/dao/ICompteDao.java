package laaziz.rayane.dao;

import java.util.ArrayList;

import laaziz.rayane.metier.Compte;

public interface ICompteDao {
	Compte save(Compte c);
	Compte update(Compte c);
	int delete (Compte c);
	
	ArrayList<Compte>getAll(int id);
	Compte find (String num);
	

	
}
