<%@ page
	import="br.unip.model.Criptomoeda"
	import="br.unip.model.Usuario"
	import="br.unip.model.Ordem"
	import="br.unip.dao.CriptomoedaDAO"
	import="br.unip.dao.OrdemDAO"
	import="java.util.ArrayList"
	import="java.util.Date"
	import="java.text.SimpleDateFormat" 
	%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BlockExchange</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/cadastro.css">
<link rel="stylesheet" type="text/css" href="css/global.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.js"></script>
</head>
<body>

<script>
         $(document).ready(function(){
             $('#celular').mask('00 00000-0000');
             $('#cpf').mask('000.000.000-00');
             $('#rg').mask('00.000.000-0');
             $('#dt_nasc').mask('00/00/0000');
         });
         
         
         function verificarSenha(){
        	 
        	 if($('#confirma_senha').val() != $('#senha').val()){
        		 $("#confirma_senha").css("background-color", "pink");
        		 $("#btn_cadastro").prop('disabled', true);
        		 
        	 }else{
        		 $("#confirma_senha").css("background-color", "#fff");
        		 $("#btn_cadastro").prop('disabled', false);
        	 }
         }
      </script>
      
<%

	if (session.getAttribute("usuario") == null){
		response.sendRedirect("login.jsp");
	} else{
		Usuario u = new Usuario();
		u = (Usuario)session.getAttribute("usuario");
		
		String[] dt = null;
		String nascimento_formatado = "";
		
		if(u.getData_nascimento().contains("-")){
			dt = u.getData_nascimento().split("-");
			nascimento_formatado = dt[2]+"/"+dt[1]+"/"+dt[0];
		}else{
			nascimento_formatado = u.getData_nascimento();
		}
		
		

%>
	<div class="bar">
		<strong><%=u.getNome()%></strong>
		<%@include file="menu.html"%>
	</div>
	<div class="conteudo">
		<div class="box_content">
			<div class="box_image">
				<img src="images/logo.png" class="logo">
			</div>
			
			<h1>Meu perfil</h1>
			<form class="form" action="EditarUsuarioServlet" method="post">
			
				<div class="row">
			
				<div class="col-md-4">
				  <div class="form-group">
				    <label for="nome">Nome*:</label>
				    <input type="text" class="form-control" value="<%=u.getNome()%>" name="txtNome" id="nome" required placeholder="Digite seu nome">
				  </div>
				</div>
				
				<div class="col-md-4">
				  <div class="form-group">
				    <label for="cpf">CPF*:</label>
			
				    <input type="text" class="form-control" value="<%=u.getCpf()%>" name="txtCpf" id="cpf" required placeholder="Digite seu CPF">
				  </div>
				</div>
				
				<div class="col-md-4">
				  <div class="form-group">
				    <label for="rg">RG*:</label>
				    <input type="text" class="form-control" value="<%=u.getRg()%>" name="txtRg" id="rg" required placeholder="Digite seu RG">
				  </div>
				</div>
				
				<div class="col-md-4">
				  <div class="form-group">
				    <label for="dt_nasc">Data de nascimento*:</label>
				    <input type="text" class="form-control" name="txtDtNasc" value="<%=nascimento_formatado%>" id="dt_nasc" required placeholder="00/00/0000">
				  </div>
				</div>
				
				<div class="col-md-4">
				  <div class="form-group">
				    <label for="email">Email*:</label>
				    <input type="email" class="form-control" name="txtEmail" value="<%=u.getEmail()%>" id="email" required placeholder="Digite seu email">
				  </div>
				</div>
				
				<div class="col-md-4">
				  <div class="form-group">
				    <label for="celular">Celular:</label>
				    <input type="tel" class="form-control" value="<%=u.getCelular()%>" name="txtCelular" id="celular" placeholder="Digite seu celular">
				  </div>
				</div>
				
				
				<div class="col-md-4">
				  <div class="form-group">
				    <label for="senha">Senha*:</label>
				    <input type="password" onKeyUp="verificarSenha()" value="<%=u.getSenha()%>" class="form-control" required name="txtSenha" id="senha"  placeholder="Digite seu senha">
				  </div>
				</div>
				
				<div class="col-md-4">
				  <div class="form-group">
				    <label for="confirma_senha">Confirmar Senha*:</label>
				    <input type="password" onKeyUp="verificarSenha()" value="<%=u.getSenha()%>" class="form-control" name="txtConfirmaSenha" id="confirma_senha"  placeholder="Confirme sua senha">
				  </div>
				</div>
				
				<input type="hidden" name="txtId" value="<%=u.getId()%>">
				
					
				<div class="form-group">
				    <div class="col-md-12">
				      <input type="submit" class=" orange-btn" id="btn_cadastro" value="Editar">
				    </div>
			  	</div>
			</div>
			 
			 
			
			
			</form>
		
		</div>
	</div>

</body>
</html>

<%
	}
%>