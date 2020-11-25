<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BlockExchange</title>

<link rel="stylesheet" type="text/css" href="css/global.css">
<link rel="stylesheet" type="text/css" href="css/login.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
</head>
<body>
	<div class="bar"></div>
	<div class="box_login">
		<div class="box_image">
			<img src="images/logo.png" class="logo">
		</div>
		
		<form class="form-horizontal" action="LoginServlet" method="post">
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="email">Email:</label>
		    <div class="col-sm-10">
		      <input type="email" class="form-control" id="email" name="txtEmail" placeholder="Digite seu email">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="pwd">Senha:</label>
		    <div class="col-sm-10">
		      <input type="password" class="form-control" id="pwd" name="txtSenha" placeholder="Digite sua senha">
		    </div>
		  </div>
		  
		
		
		  <div class="form-group">
		    <div class="col-sm-offset-9 col-sm-10">
		      <input type="submit"class=" orange-btn" value="Entrar">
		    </div>
		  </div>
		  
		  <div align="center">
			  <a href="cadastro.jsp">Não possui conta? Cadastre-se</a>	  
		  </div>
		</form>
		
		
	</div>
</body>
</html>