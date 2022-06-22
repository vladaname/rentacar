package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.KorisnikMenager;
import model.Korisnik;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/LoginJSP.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String username = request.getParameter("username");
		String pass = request.getParameter("pass");
		
		KorisnikMenager km = new KorisnikMenager();
		
		Korisnik k = km.logovanje(username, pass);
		if(k != null) {
			
			request.getSession().setAttribute("korisnik", k);
			//redirekcija na neku stranicu
			RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/SelektujDatume.jsp");
			rd.forward(request, response);
		}
		else {
			//vracanje na login
			RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/LoginJSP.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
