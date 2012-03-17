package br.com.caelum.fj91.classloader.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MostraDados extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		
		out.printf("Request path: %s", request.getRequestURI());
		out.printf("Request headers: %s", request.getHeaderNames());
		out.printf("Response headers: %s", response.getHeaderNames());
		
		out.println("</html>");
	}

}
