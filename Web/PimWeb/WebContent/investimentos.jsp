<%@ page
	import="br.unip.model.Usuario"
	import="br.unip.model.Ordem"
	import="br.unip.dao.OrdemDAO"
	import="br.unip.model.Saldo"
	import="br.unip.dao.SaldoDAO"
	import="java.util.ArrayList"
	%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%

	if (session.getAttribute("usuario") == null){
		response.sendRedirect("login.jsp");
	} else{
		Usuario u = new Usuario();
		u = (Usuario)session.getAttribute("usuario");
	
		//Listar ordens como livro de oferta
		ArrayList<Ordem> ordens = new ArrayList<>();
		OrdemDAO ordemDao = new OrdemDAO();
		ordens = ordemDao.listarMinhasOrdens(u.getId());
		
		//Investimento em moedas
		ArrayList<Saldo> saldos = new ArrayList<>();
		SaldoDAO saldoDao = new SaldoDAO();
		saldos = saldoDao.listarMeusSaldos(u.getId());
		
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BlockExchange</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/investimentos.css">
<link rel="stylesheet" type="text/css" href="css/global.css">
</head>
<body>



	<div class="bar">
		<strong><%= u.getNome()%></strong>
		
		<%@include file="menu.html"%>
		
	</div>
	<div class="conteudo">
		<div class="box_content">
			<div class="box_image">
				<img src="images/logo.png" class="logo">
			</div>
			
			<h1>Meus Investimentos</h1>
			
			<div class="align_center">
				<span>Saldo em quantidade de Criptomoedas</span>
				<table class="table table-hover">
				    <tbody>
				      <%
					for(Saldo s : saldos){
						out.print("<tr>");
							out.print("<td>"+s.getNome()+"</td>");
							out.print("<td>"+s.getQuantidade()+"</td>");
						out.print("</tr>");
					}
				    
				    %>
				     
				    </tbody>
				 </table>
				 
				 <span>Minhas Ordens</span>
				 
				 <div style="height:200px; overflow-y:auto;">
				 	 <table class="table table-hover">
				    <thead>
				      <tr>
				        <th>Data</th>
				        <th>Ativo</th>
				        <th>Qtd.</th>
				        <th>Valor</th>
				        <th>Tipo</th>
				      </tr>
				    </thead>
				    <tbody>
				    
				    <%
					for(Ordem o : ordens){
						out.print("<tr>");
							out.print("<td>"+o.getData()+"</td>");
							out.print("<td>"+o.getCriptoname()+"</td>");
							out.print("<td>"+o.getQuantidade()+"</td>");
							out.print("<td>R$"+o.getPreco()+"</td>");
							out.print("<td>"+o.getTipo()+"</td>");
						out.print("</tr>");
					}
				    
				    %>
				    </tbody>
				  </table>
				 
				 </div>
				   
			</div>
			
			
			
			<table>
			
			</table>
		</div>
	</div>

</body>
</html>

<%
	}
%>