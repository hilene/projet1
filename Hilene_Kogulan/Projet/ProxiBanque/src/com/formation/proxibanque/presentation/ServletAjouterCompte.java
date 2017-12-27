package com.formation.proxibanque.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.formation.proxibanque.model.CompteCourant;
import com.formation.proxibanque.model.CompteEpargne;
import com.formation.proxibanque.service.ServiceCompteCourant;
import com.formation.proxibanque.service.ServiceCompteEpargne;

/**
 * Servlet implementation class ServletAjouterCompte
 */
@WebServlet("/ServletAjouterCompte")
public class ServletAjouterCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServiceCompteCourant servCC = new ServiceCompteCourant();
	ServiceCompteEpargne servCE = new ServiceCompteEpargne();
	HttpSession session;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAjouterCompte() {
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
		processServ(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processServ(request, response);
	}

	/**
	 * Enregistrer dans la BDD un compte courant ET/OU un compte epargne et redirige
	 * vers les pages de Validation ou d'echec
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void processServ(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CompteCourant CC = null;
		CompteEpargne CE = null;
		boolean result = false;

		if (request.getParameter("checkboxCC") != null) {
			int idClient = Integer.parseInt(request.getParameter("idClient"));
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
			servCC.insert(CC);
			result = true;

		}

		if (request.getParameter("checkboxCE") != null) {
			int idClient = Integer.parseInt(request.getParameter("idClient"));
			float soldeCE = Float.parseFloat(request.getParameter("soldeCE"));
			float tauxRemun = Float.parseFloat(request.getParameter("tauxRemun"));
			String dateCreatC = request.getParameter("dateOuvertureCE");
			if (soldeCE != 0.0f) {
				if (dateCreatC != "") {
					CE = new CompteEpargne(soldeCE, dateCreatC, tauxRemun);
				} else {
					CE = new CompteEpargne(soldeCE, tauxRemun);
				}
			}
			CE.setIdClient(idClient);
			servCE.insert(CE);
			result = true;
		}

		if (result) {
			String message = "<h2>Felicitations</h2> <br/><em><i> Votre demande a été correctement envoyé</i></em></br>";
			session.setAttribute("InfoTraitement", message);
			request.getRequestDispatcher("pageValidation.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("pageEchec.jsp").forward(request, response);
		}

	}
}
