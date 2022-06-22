package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.AutomobilManager;
import managers.IznajmljivanjeManager;

/**
 * Servlet implementation class RezervacijaAutomobilaServlet
 */
@WebServlet("/RezervacijaAutomobilaServlet")
public class RezervacijaAutomobilaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RezervacijaAutomobilaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/RezervacijaAutomobilaJSP.jsp");
		rd.forward(request, response);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idiznajmljivanje = request.getParameter("idiznajmljivanje");
		int idIznajmljen = Integer.parseInt(idiznajmljivanje);
		String idautomobil = request.getParameter("idautomobil");
		int idAuto = Integer.parseInt(idautomobil);
		String cenaPoDanu = request.getParameter("cenaPoDanu");
		int cena = Integer.parseInt(cenaPoDanu);
		
		String marka = request.getParameter("marka");
		String model = request.getParameter("model");
		String gorivo = request.getParameter("gorivo");
		String datum_od =request.getParameter("datum_od");
		
		IznajmljivanjeManager im = new IznajmljivanjeManager();
		
		AutomobilManager am = new AutomobilManager();
		boolean zauzeto = am.deleteAutomobilLog(idAuto);
		if(zauzeto) {
			request.setAttribute("poruka", "Uspesno ste zakazali termin. Cena termina iznosi " + cena 
					 + im.rezervacija(idIznajmljen));
		}
		else {
			request.setAttribute("poruka", "Dogodila se greska prilikom rezervacije");

		}

			
		
		
		
		
		
		
		
	}

}
