package com.formation.proxibanque.presentation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.formation.proxibanque.model.Client;
import com.formation.proxibanque.model.CompteCourant;
import com.formation.proxibanque.model.CompteEpargne;
import com.formation.proxibanque.model.TypeClient;
import com.formation.proxibanque.service.ServiceClient;
import com.formation.proxibanque.service.ServiceCompteCourant;
import com.formation.proxibanque.service.ServiceCompteEpargne;

/**
 * Servlet implementation class ServletModifClient
 */
@WebServlet("/ServletModifClient")
public class ServletModifClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
	ServiceClient servCli = new ServiceClient();
	ServiceCompteCourant servCC = new ServiceCompteCourant();
	ServiceCompteEpargne servCE = new ServiceCompteEpargne();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletModifClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		session = request.getSession();

		int idClient = Integer.parseInt(request.getParameter("idclient"));

		Client myClient = servCli.selectById(idClient);
		CompteCourant CCmyClient = servCC.selectByIdClient(idClient);
		CompteEpargne CEmyClient = servCE.selectByIdClient(idClient);

		session.setAttribute("InfoClient", myClient);
		session.setAttribute("InfoCompteCourant", CCmyClient);
		session.setAttribute("InfoCompteEpargnet", CEmyClient);

		session.setAttribute("InfoConseiller", myClient.getIdConseiller());

		request.getRequestDispatcher("modifierClient.jsp").forward(request, response);

	}

	/**
	 * Recuperer l'ensemble des informations issues de la JSP (modifierClient.jsp)
	 * relatives au Client, le compte courant et le compte epargne
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// Update Client
		int idClient = Integer.parseInt(request.getParameter("idclient"));
		String nomClient = request.getParameter("nom");
		String prenomClient = request.getParameter("prenom");
		String adresseClient = request.getParameter("adresse");
		int codePostalClient = Integer.parseInt(request.getParameter("codePostal"));
		String villeClient = request.getParameter("ville");
		String telClient = request.getParameter("telephone");
		String emailClient = request.getParameter("email");
		TypeClient typeClient;
		int IdConseiller = Integer.parseInt(request.getParameter("idConseiller"));

		if (request.getParameter("typeClient") == "particulier") {
			typeClient = TypeClient.PARTICULIER;
		} else {
			typeClient = TypeClient.ENTREPRISE;
		}

		Client updateCli = new Client(idClient, nomClient, prenomClient, adresseClient, codePostalClient, villeClient,
				telClient, emailClient, typeClient);

		updateCli.setMonConseiller(IdConseiller);
		servCli.update(updateCli);

		CompteCourant CC = null;
		CompteEpargne CE = null;

		// Update Compte Courant
		float soldeCC = Float.parseFloat(request.getParameter("soldeCC"));
		float decouvert = Float.parseFloat(request.getParameter("decouvertA"));
		String dateCreatC = request.getParameter("dateOuvertureCC");
		if (soldeCC != 0.0f) {
			if (dateCreatC != "") {
				CC = new CompteCourant(soldeCC, dateCreatC, decouvert);
			} else {
				CC = new CompteCourant(soldeCC, decouvert);
			}
		}
		CC.setIdClient(idClient);
		servCC.update(CC);

		// Update Compte Epargne
		float soldeCE = Float.parseFloat(request.getParameter("soldeCE"));
		float tauxRemun = Float.parseFloat(request.getParameter("tauxRemun"));
		String dateCreatCE = request.getParameter("dateOuvertureCE");
		if (soldeCE != 0.0f) {
			if (dateCreatC != "") {
				CE = new CompteEpargne(soldeCE, dateCreatCE, tauxRemun);
			} else {
				CE = new CompteEpargne(soldeCE, tauxRemun);
			}
		}
		CE.setIdClient(idClient);
		servCE.update(CE);

		String message = "<h2>Felicitations</h2> <br/><em><i> Les modifications ont été effectuées avec succès</i></em></br>";
		session.setAttribute("InfoTraitement", message);
		request.getRequestDispatcher("pageValidation.jsp").forward(request, response);

	}

}
