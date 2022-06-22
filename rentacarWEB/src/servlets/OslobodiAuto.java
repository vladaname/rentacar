package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.AutomobilManager;
import model.Automobil;

/**
 * Servlet implementation class OslobodiAuto
 */
@WebServlet("/OslobodiAuto")
public class OslobodiAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OslobodiAuto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AutomobilManager am = new AutomobilManager();
		List<Automobil> listaRezervisano = am.listZauzeto();
		request.getSession().setAttribute("listaRezervisano", listaRezervisano);
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/OslobodiAutoJSP.jsp");
		rd.forward(request, response);
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idautomobil = request.getParameter("idautomobil");
		int idAuto = Integer.parseInt(idautomobil);
		
		System.out.println(idAuto);
		
		AutomobilManager am = new AutomobilManager();
			boolean auto = am.razduzi(idAuto);

		List<Automobil> au = am.listZauzeto();
		request.getSession().setAttribute("listaRezervisano", au);
		
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/OslobodiAutoJSP.jsp");
		rd.forward(request, response);
		
	}

}
