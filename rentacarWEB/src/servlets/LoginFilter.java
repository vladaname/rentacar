package servlets;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import model.Korisnik;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(filterName="filterOne", urlPatterns = { "/OslobodiAuto/*"  })

public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("Uslo je u filter");
		if(((HttpServletRequest)request).getSession().getAttribute("korisnik")!= null) {
			System.out.println("prosao filtriranje");
			Korisnik k = (Korisnik) ((HttpServletRequest)request).getSession().getAttribute("korisnik");
			System.out.println(k.getIme());
			if (k.getIme().equals("zile")) {
				chain.doFilter(request, response);//pusti ga
			}
			else {
				request.getRequestDispatcher("/ZilePristupaStraniciSERVLET").forward(request, response);
			}
			
		}
		else {
			request.getRequestDispatcher("/LoginServlet").forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
