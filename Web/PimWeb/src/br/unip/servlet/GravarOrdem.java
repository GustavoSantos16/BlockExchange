package br.unip.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unip.dao.OrdemDAO;
import br.unip.model.Ordem;

/**
 * Servlet implementation class GravarOrdem
 */
@WebServlet("/GravarOrdem")
public class GravarOrdem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GravarOrdem() {
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
		Ordem ordem = new Ordem();
		
		ordem.setTipo(request.getParameter("txtTipo"));
		ordem.setQuantidade(Double.parseDouble(request.getParameter("txtQuantidade")));
		ordem.setPreco(Double.parseDouble(request.getParameter("txtPreco")));
		ordem.setUsuario_id(Integer.parseInt(request.getParameter("txtIdUser")));
		ordem.setCripto_id(Integer.parseInt(request.getParameter("txtCriptoId")));
		
		OrdemDAO ordemDao = new OrdemDAO();
		ordemDao.gravar(ordem);
		
		PrintWriter out = response.getWriter();  
		response.setContentType("text/html");  
		out.println("<script type=\"text/javascript\">");  
		out.println("alert('Ordem cadastrada com sucesso!!');");  
		out.println("window.location.replace('investir.jsp')");  
		out.println("</script>");
		
		//response.sendRedirect("investir.jsp");
		
	}

}
