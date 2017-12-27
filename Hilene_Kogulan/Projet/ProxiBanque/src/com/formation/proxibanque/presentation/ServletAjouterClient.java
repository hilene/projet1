package com.formation.proxibanque.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.formation.proxibanque.model.Client;
import com.formation.proxibanque.model.TypeClient;
import com.formation.proxibanque.service.ServiceClient;

/**
 * Servlet implementation class ServletAjouterClient
 */
@WebServlet("/ServletAjouterClient")
public class ServletAjouterClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServiceClient servCli = new ServiceClient();
	HttpSession session;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAjouterClient() {
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
	 * Recuperer les données saisies par l'utilisateur via la méthode POST dans la
	 * JSP (ajouterClient.jsp), appel la méthode insert(Client c), et redirige vers
	 * les pages de Validation ou d'echec
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void processServ(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TypeClient typeClient = null;

		try {

			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String adresse = request.getParameter("adresse");
			int codepostal = Integer.parseInt(request.getParameter("codePostal"));
			String ville = request.getParameter("ville");
			String telephone = request.getParameter("telephone");
			String email = request.getParameter("email");

			if (request.getParameter("typeClient") == "particulier") {
				typeClient = TypeClient.PARTICULIER;
			} else {
				typeClient = TypeClient.ENTREPRISE;
			}
			System.out.println(":" + nom + prenom + adresse + codepostal + ville + telephone + email + typeClient);

			Client c1 = new Client(nom, prenom, adresse, codepostal, ville, telephone, email, typeClient);
			c1.setMonConseiller(Integer.parseInt(request.getParameter("idConseiller")));

			servCli.insert(c1);

			// Message
			String message = "<h2>Felicitations</h2> <br/><em>Le client a été ajouté à la base de données<i></i></em></br>";
			session.setAttribute("InfoTraitement", message);
			request.getRequestDispatcher("pageValidation.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			request.getRequestDispatcher("pageEchec.jsp").forward(request, response);
			e.printStackTrace();
		}

	}
}
