package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.ListaAutomobilaDatumOdDo;
import managers.AutomobilManager;
import managers.IznajmljivanjeManager;
import model.Iznajmljivanje;

/**
 * Servlet implementation class RezervacijaAutomobilaServletPROBA
 */
@WebServlet("/RezervacijaAutomobilaServletPROBA")
public class RezervacijaAutomobilaServletPROBA extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RezervacijaAutomobilaServletPROBA() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/RezervacijaAutomobilaJspPROBA.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("pogodjen");

//		String idautomobil = request.getParameter("idautomobil");
//		int idAuto = Integer.parseInt(idautomobil);
//		String idiznajmljivanje = request.getParameter("idiznajmljivanje");
//		int idIznajmi = Integer.parseInt(idiznajmljivanje);
//		String marka = request.getParameter("marka");
//		String model = request.getParameter("model");
//		
//		String cenaPoDanu = request.getParameter("cenaPoDanu");
//		int cenaPD = Integer.parseInt(cenaPoDanu);

		String dd = request.getParameter("datum_od");
		String oo = request.getParameter("datum_do");
		String datum_od = dd.replace("T", " ");
		String datum_do = oo.replace("T", " ");
		

		System.out.println(dd + " " + oo);
		System.out.println(datum_od + " " + datum_do);
		
		SimpleDateFormat sdp = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		Date datumOd = null;
		Date datumDo = null;
		try {
			datumOd = sdp.parse(datum_od);
			datumDo = sdp.parse(datum_do);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(datumOd + " " + datumDo);

		IznajmljivanjeManager im = new IznajmljivanjeManager();
		List<ListaAutomobilaDatumOdDo> rent = im.findAllByDateOdDo(datumOd, datumDo);
		
		for (ListaAutomobilaDatumOdDo b : rent) {
			System.out.println(b);
			
		}
		
		if(rent == null) {
			System.out.println("nema nista");
		}
		else {
			System.out.println("ima nesto");
		}

		request.getSession().setAttribute("rent", rent);
		request.getSession().setAttribute("datum_od", datumOd);
		request.getSession().setAttribute("datum_do", datumDo);

		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/RezervacijaAutomobilaJspPROBA.jsp");
		rd.forward(request, response);


	}

}
