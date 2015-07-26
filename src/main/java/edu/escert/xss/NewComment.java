package edu.escert.xss;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;

/**
 * Servlet implementation class NewComment
 */
public class NewComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> comments=(List<String>)request.getSession().getAttribute("comments");
		if (comments==null) {
			comments=new ArrayList<String>();
			request.getSession().setAttribute("comments",comments);
		}
		String comment=request.getParameter("comment");

		PolicyFactory policy = Sanitizers.FORMATTING;
		comments.add(policy.sanitize(comment));
		response.sendRedirect(response.encodeURL("home"));
	}

}
