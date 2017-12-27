package com.formation.proxibanque.presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.formation.proxibanque.service.ServiceConseiller;

/**
 * Servlet implementation class ServletVirement
 */
@WebServlet("/ServletVirement")
public class ServletVirement extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ServiceConseiller servCons = new ServiceConseiller();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVirement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processServ(request, response);
	}

	/**
	 * Appel la méthode permettant d'effectuer le virement en un Compte courant et un Compte Epargne
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processServ(request, response);
	}
	protected void processServ(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		servCons.transfer(Integer.parseInt(request.getParameter("numCompteDebit")), Integer.parseInt(request.getParameter("numCompteCredit")), Float.parseFloat(request.getParameter("montant")));
		
	}
}
