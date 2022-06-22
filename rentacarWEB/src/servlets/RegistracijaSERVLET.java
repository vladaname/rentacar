package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.KorisnikMenager;

/**
 * Servlet implementation class RegistracijaSERVLET
 */
@WebServlet("/RegistracijaSERVLET")
public class RegistracijaSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistracijaSERVLET() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/RegistracijaJSP.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ime = request.getParameter("ime");
		String prezime = request.getParameter("prezime");
		String telefon = request.getParameter("telefon");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String password_confirm = request.getParameter("password_confirm");
		
		String email = request.getParameter("email");
		String jmbg = request.getParameter("jmbg");
		int jmbgINT = 0;
		String message = "";
		try {
			jmbgINT = Integer.parseInt(jmbg);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message += " Invalid jmbg";
		}
		
		if(!password.equals(password_confirm)) {
			message += " Invalid password";
		}
		
		KorisnikMenager km = new KorisnikMenager();
		if(km.findByEmail(email) != null) {
			message += " Email allredy exist";
		}
		
		if(km.findByJMBG(jmbgINT) != null) {
			message += " JMBG allredy exist";
		}
		
		if(!message.equals("")) {
			//Setovati message u request i proslediti ga nazad na formu za registraciju
			request.getSession().setAttribute("message", "Registrujte se ponovo " + message);
			RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/RegistracijaJSP.jsp");
			rd.forward(request, response);
		}
		else {
			km.createKorisnik(email, ime, jmbgINT, password, prezime, telefon, username);
			//ukoliko je uspesno kreirano redirektovagti ga na login
			RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/LoginJSP.jsp");
			rd.forward(request, response);
		}
		
	}

}

