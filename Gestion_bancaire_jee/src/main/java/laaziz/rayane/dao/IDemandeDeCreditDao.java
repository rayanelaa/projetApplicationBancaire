package laaziz.rayane.dao;

import java.util.ArrayList;


import laaziz.rayane.metier.DemandeDeCredit;

public interface IDemandeDeCreditDao {
	DemandeDeCredit save(DemandeDeCredit c);
	DemandeDeCredit update(DemandeDeCredit c);
	int delete (DemandeDeCredit c);
	
	ArrayList<DemandeDeCredit>getAll(int id);
	DemandeDeCredit find (String num);
	

}
