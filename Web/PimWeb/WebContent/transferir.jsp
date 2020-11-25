<%@ page
	import="br.unip.model.Usuario"
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
    if (session.getAttribute("usuario") == null){
		response.sendRedirect("login.jsp");
	} else{
		Usuario u = new Usuario();
		u = (Usuario)session.getAttribute("usuario");
		
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/transferir.css">
<link rel="stylesheet" type="text/css" href="css/global.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.js"></script>
<title>BlockExchange</title>
</head>
<body>

<script>
         $(document).ready(function(){
             $('#cpf').mask('000.000.000-00');
         });
         
</script>         

	<div class="bar">
		<strong><%= u.getNome()%></strong>
		<%@include file="menu.html"%>
	</div>
	<div class="conteudo">
		<div class="box_content">
			<div class="box_image">
				<img src="images/logo.png" class="logo">
			</div>
			
			<h1>Transferir/depositar</h1>
			<h6 style="position:absolute;bottom:0;"><strong>Dados para depósito</strong><br><br>CPF:<%= u.getCpf()%> <br> Agencia: 0001 <br> Conta: 07656-4</h6>
			
			<div class="box_conta">
				<span class="center">Saldo disponível</span>
				<hr>
				<strong align="right" style="margin-right:10%">R$<%= u.getSaldo()%></strong>
			</div>
			
			
			<div class="formulario">
				<form class="form">
				
				<div class="row">
					
					<div class="col-md-6">
						<div class="form-group">
						    <label class="control-label" for="moeda">CPF destinatário:</label>
						   <input class="form-control" id="cpf" placeholder="000.000.000-00"/>
						 </div>
					</div>
					
					<div class="col-md-6">
						<div class="form-group">
						    <label class="control-label" for="agencia">Agência</label>
						   <input class="form-control" id="agencia" placeholder="0000"/>
						 </div>
					</div>
					
					<div class="col-md-6">
						<div class="form-group">
						    <label class="control-label" for="conta">Conta</label>
						   <input class="form-control" id="conta" placeholder="00000-0"/>
						 </div>
					</div>
					
					<div class="col-md-6">
						<div class="form-group">
						    <label class="control-label" for="moeda">Valor R$:</label>
						   <input class="form-control"/>
						 </div>
					</div>
					
					<button type="submit" class="orange-btn">Transferir</button>
					
					
				</div>
					
				</form>
			</div>
			
		</div>
	</div>
</body>
</html>

<% 
	}
		
%>