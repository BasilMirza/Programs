package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


/*@WebFilter("/*")*/
public class FirstFilter implements Filter {
	static int hits;

    
    public FirstFilter() {
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	    /* long start=System.currentTimeMillis();
	     hits++;
		chain.doFilter(request, response);
		long end=System.currentTimeMillis();
		System.out.println("Time taken: "+(end-start)+" ms and hits are "+hits);*/
		chain.doFilter(request, response);
		response.setContentType("text.html");
		PrintWriter out=response.getWriter();
		String pass=request.getParameter("txtPass");
		if(pass.equals("sa"))
		{
			chain.doFilter(request,response);
		}
		else
		{
			out.println("wrong password");
			RequestDispatcher rd=request.getRequestDispatcher("FilterPage.html");
			rd.include(request, response);
			
			
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		hits=0;
	}

}
