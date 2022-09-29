package laaziz.rayane.web;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import laaziz.rayane.dao.ClientDaoImpl;
import laaziz.rayane.dao.CompteDaoImpl;
import laaziz.rayane.metier.Client;
import laaziz.rayane.metier.Compte;
import laaziz.rayane.metier.DemandeDeCredit;


@WebServlet("/")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      ClientDaoImpl cdi = new ClientDaoImpl();
      private CompteDaoImpl comptedi = new CompteDaoImpl();
    
      protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException{
    	  doGet(req, resp);
      }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		System.out.println(path);
		ArrayList<Client> clients;
		ArrayList<Compte> comptes;
		Client c ;
		Compte compte;
		DemandeDeCredit dmd;
		
		 
		
		

		switch(path){
			case"/list-client":
				 clients = cdi.getAll();
				
				request.setAttribute("clients",clients);
				request.getRequestDispatcher("list-client.jsp").forward(request,response);
				
				break;
				
			case"/new-client":
				request.getRequestDispatcher("new-client.jsp").forward(request,response);
				break;
				
			case"/save-client":
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				String dateNaissance = request.getParameter("date-naissance");
				String tel = request.getParameter("tel");
				String mail = request.getParameter("mail");
				String civilite = request.getParameter("civilite");
				String adresse = request.getParameter("adresse");
				
				 c = new Client(nom,prenom,Date.valueOf(dateNaissance), adresse, tel, mail,civilite);
				 c = cdi.save(c); 
				 //appeler
				 request.setAttribute("client",c);
				 //afficher la page
					request.getRequestDispatcher("confirmation.jsp").forward(request,response);
				 
				
				break;
					
				case "/delete-client":
					//code pour supprimer le client
					
					int id = Integer.parseInt(request.getParameter("idclient"));
					 c = new Client();
					c.setId(id);
					cdi.delete(c);
					
					clients = cdi.getAll();
					
					//passer le tableau des clients a la vue (list-client.jsp)
					request.setAttribute("clients", clients);
					request.getRequestDispatcher("list-client.jsp").forward(request, response);
					break;
					
				case "/details-client":
					int idclient = Integer.parseInt(request.getParameter("idclient"));
					c = cdi.find(idclient);
					
					request.setAttribute("client" , c);
					request.getRequestDispatcher("details.jsp").forward(request, response);
					break;
					
				case "/find":
					nom = request.getParameter("nom");
					prenom = request.getParameter("prenom");
					
					clients = cdi.getAll(nom, prenom);
					
					//Passer le tableau des clients a la vue (list-client.jsp)
					request.setAttribute("clients", clients);
					//afficher une page jsp
					request.getRequestDispatcher("list-client.jsp").forward(request, response);
					
					break;
					
				case"/list-compte":
					idclient = Integer.parseInt(request.getParameter("idclient"));
					comptes = comptedi.getAll(idclient);
					request.setAttribute("comptes", comptes);
					request.getRequestDispatcher("list-compte.jsp").forward(request, response);
					
				case"/new-compte":
					idclient = Integer.parseInt(request.getParameter("idclient"));
					c=cdi.find(idclient);
					request.setAttribute("clients", c);
					request.getRequestDispatcher("new-compte.jsp").forward(request, response);
					break;
					
				case"/save-compte":
					String num = request.getParameter("num");
					String dateCreation = request.getParameter("dateCreation");
					double solde = Double.parseDouble(request.getParameter("solde"));
					String type = request.getParameter("type");
					double taux = Double.parseDouble(request.getParameter("taux"));
					double decouvert = Double.parseDouble(request.getParameter("decouvert"));
					idclient = Integer.parseInt(request.getParameter("idclient"));
			
				
					c=cdi.find(idclient);
					compte = new Compte (num, Date.valueOf(dateCreation), solde, type, decouvert, taux, c);
					 compte = comptedi.save(compte); 
					 c = cdi.save(c);
					 //appeler
					 request.setAttribute("compte",compte);
					 //afficher la page
						request.getRequestDispatcher("compte-confirmation.jsp").forward(request,response);
						break;
						
					
				case"/save-DemandeDeCredit":
					String numero = request.getParameter("numero");
					String date = request.getParameter("date");
					Double montant = Double.parseDouble(request.getParameter("montant"));
					int durée = Integer.parseInt(request.getParameter("durée"));
					Double Taux = Double.parseDouble(request.getParameter("taux"));
					Double mensualité = Double.parseDouble(request.getParameter("mensualité"));
					String etat = request.getParameter("etat");
					idclient = Integer.parseInt(request.getParameter("idclient"));

					c=cdi.find(idclient);
					dmd = new DemandeDeCredit(numero, Date.valueOf(date), montant,durée,Taux,mensualité,etat,c);
					
					 //appeler
					 request.setAttribute("DemandeDeCredit",dmd);
					 //afficher la page
						request.getRequestDispatcher("confirmation-DemandeDeCredit.jsp").forward(request,response);
					 
					
					break; 

					
					
				default:
					request.getRequestDispatcher("index.jsp").forward(request,response);
					break;
					
			
		}
		
	}

}
