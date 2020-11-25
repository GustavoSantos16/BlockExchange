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
 * Servlet implementation class EditarUsuarioServlet
 */
@WebServlet("/EditarUsuarioServlet")
public class EditarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarUsuarioServlet() {
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
		Usuario usuario = new Usuario();
		
		usuario.setNome(request.getParameter("txtNome"));
		usuario.setCpf(request.getParameter("txtCpf"));
		usuario.setRg(request.getParameter("txtRg"));
		usuario.setData_nascimento(request.getParameter("txtDtNasc"));
		usuario.setEmail(request.getParameter("txtEmail"));
		usuario.setCelular(request.getParameter("txtCelular"));
		usuario.setSenha(request.getParameter("txtSenha"));
		
		usuario.setId(Integer.parseInt(request.getParameter("txtId")));
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		usuarioDao.editar(usuario);
		
		HttpSession sessao = request.getSession();
		sessao.setAttribute("usuario", usuario);
		
		PrintWriter out = response.getWriter();  
		response.setContentType("text/html");  
		out.println("<script type=\"text/javascript\">");  
		out.println("alert('Dados foram salvos com sucesso!!');");  
		out.println("window.location.replace('perfil.jsp')");  
		out.println("</script>");
	
	}

}
