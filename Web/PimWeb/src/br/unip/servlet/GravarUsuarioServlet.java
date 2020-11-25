package br.unip.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unip.dao.UsuarioDAO;
import br.unip.model.Usuario;

/**
 * Servlet implementation class GravarUsuarioServlet
 */
@WebServlet("/GravarUsuarioServlet")
public class GravarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GravarUsuarioServlet() {
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
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		Usuario usuario = new Usuario();
		
		usuario.setNome(request.getParameter("txtNome"));
		usuario.setCpf(request.getParameter("txtCpf"));
		usuario.setRg(request.getParameter("txtRg"));
		usuario.setData_nascimento(request.getParameter("txtDtNasc"));
		usuario.setEmail(request.getParameter("txtEmail"));
		usuario.setCelular(request.getParameter("txtCelular"));
		usuario.setSenha(request.getParameter("txtSenha"));
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		usuarioDao.gravar(usuario);
		
		PrintWriter out = response.getWriter();  
		response.setContentType("text/html");  
		out.println("<script type=\"text/javascript\">");  
		out.println("alert('Usuario cadastrado com sucesso!!');");  
		out.println("window.location.replace('login.jsp')");  
		out.println("</script>");
		
	}

}
