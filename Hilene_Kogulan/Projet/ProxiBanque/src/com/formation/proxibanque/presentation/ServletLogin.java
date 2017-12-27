package com.formation.proxibanque.presentation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.formation.proxibanque.model.Client;
import com.formation.proxibanque.model.Conseiller;
import com.formation.proxibanque.service.ServiceConseiller;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServiceConseiller servCons = new ServiceConseiller();
	HttpSession session;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLogin() {
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
		// processServ(request, response);
		// response.getWriter().write(request.getParameter("url"));
		if (session != null) {
			session.invalidate();
		}

		request.getRequestDispatcher("index.html").forward(request, response);
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
	 * Service de l'authentification qui cherche l'information relative aux
	 * Conseillers dans le DAO, si le login et le mdp correspondent, utilisateur est
	 * rediriger vers sa page personnelles, sinon une page "échec d'autentification
	 * s'affiche et invite l'utilisateur à resaisir ces identificants
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void processServ(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		RequestDispatcher requestDispatcher;

		session = request.getSession();
		// if (session.isNew()) {
		String name = request.getParameter("login");
		String password = request.getParameter("password");
		Conseiller c1 = servCons.findMyConseiller(name, password);

		if (c1 != null) {
			System.out.println(c1.getIdEmploye() + " " + c1.getLogin() + " " + c1.getMdp());
			session.setAttribute("Conseiller", c1);
			session.setAttribute("NumConseiller", c1.getIdEmploye());

			// Ajouter la liste des clients à ma BeanConseiller
			List<Client> ListClient = servCons.selectMyClients(c1.getIdEmploye());
			// request.setAttribute("tableauClient", ListClient);
			session.setAttribute("tableauClient", ListClient);
			request.getRequestDispatcher("accueilConseiller.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("echecAuthentification.jsp").forward(request, response);
		}
	}

}
