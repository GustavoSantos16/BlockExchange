package br.unip.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.unip.dao.UsuarioDAO;
import br.unip.model.Usuario;

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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("txtEmail");
		String senha = request.getParameter("txtSenha");
		
		UsuarioDAO uDAO = new UsuarioDAO();
		Usuario u = new Usuario();
		
		u = uDAO.autenticar(email, senha);
		if (u != null ) {

			/* SESSÃO DO USUÁRIO */
						
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuario", u);
			
			response.sendRedirect("investir.jsp");
		} else {
			PrintWriter out = response.getWriter();  
			response.setContentType("text/html");  
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Usuário ou senha incorretos, tente novamente.');");  
			out.println("window.location.replace('login.jsp')");  
			out.println("</script>");
		}

		
	}

}
