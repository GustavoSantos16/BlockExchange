<%@ page
	import="br.unip.model.Criptomoeda"
	import="br.unip.model.Usuario"
	import="br.unip.model.Ordem"
	import="br.unip.dao.CriptomoedaDAO"
	import="br.unip.dao.OrdemDAO"
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
		
		//Listar moedas
		ArrayList<Criptomoeda> lista = new ArrayList<>();
		CriptomoedaDAO criptomoedaDao = new CriptomoedaDAO();
		lista = criptomoedaDao.listaCriptomoedas();
		
		//Listar ordens como livro de oferta
		ArrayList<Ordem> ordens = new ArrayList<>();
		OrdemDAO ordemDao = new OrdemDAO();
		ordens = ordemDao.listaOrdem();
		
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BlockExchange</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/investir.css">
<link rel="stylesheet" type="text/css" href="css/global.css">


<script>


	function calcularValores(){
		valorTaxa = document.getElementById("moeda_select").value;
		qtd = document.getElementById("qtd_id").value;
		tipo = document.getElementById("tipo").value;
	
		//Valor id da moeda
		document.getElementById('cripto_id').value = valorTaxa.split(" - ")[0];
		valor = valorTaxa.split(" - ")[1];
		taxa = valorTaxa.split(" - ")[2];
		
		//calculando o valor a pagar pela transação
		totalMoeda = parseFloat(valor) * parseFloat(qtd);
		
		total = (totalMoeda + totalMoeda * (parseFloat(taxa)/100)).toFixed(2);
		totalMoeda = totalMoeda.toFixed(2);
		
		document.getElementById("valor_id").innerHTML = "R$ "+totalMoeda.replace('.',',');
		document.getElementById("taxa_id").innerHTML = taxa+"%";
		document.getElementById("total_id").innerHTML = "R$ "+total.replace('.',',');
		document.getElementById('valor_input').value = totalMoeda;
		
		if(tipo == "venda"){
			document.getElementById("valor_id").innerHTML = "R$ "+totalMoeda.replace('.',',');
			document.getElementById("taxa_id").innerHTML = "0%";
			document.getElementById("total_id").innerHTML = "R$ "+totalMoeda.replace('.',',');
			document.getElementById('valor_input').value = totalMoeda;
		}
	    
	}
	calcularValores();


</script>
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
			
			<h1>Investir</h1>
			
			<div class="align_flex">
				<div class="formulario">
					<form class="form-horizontal" action="GravarOrdem" method="post">
					  <div class="form-group">
					    <label class="control-label col-sm-2" for="moeda">Moeda:</label>
					    <div class="col-sm-10">
					      <select class="form-control" onChange="calcularValores();" id="moeda_select" name="txtCriptomoeda">
					      <%
							for(Criptomoeda c : lista){
								out.print("<option value='"+c.getId()+" - "+c.getValor()+" - "+c.getTaxa() +"'>"+c.getNome()+"</option>");	
							}
							%>
					      </select>
					    </div>
					  </div>
					  <div class="form-group">
					    <label class="control-label col-sm-2" for="ordem">Ordem:</label>
					    <div class="col-sm-10">
					       <select class="form-control" id="tipo" onChange="calcularValores()" name="txtTipo">
						      	<option value="compra">Compra</option>
						      	<option value="venda">Venda</option>
					      </select>
					     </div>
					  </div>
					  
					   <div class="form-group">
					    <label class="control-label col-sm-2" for="ordem">Quantidade:</label>
					    <div class="col-sm-10">
				
					       <input class="form-control" name="txtQuantidade" type="text" value="1" id="qtd_id" onKeyUp="calcularValores()" required />
					     </div>
					  </div>
					  
					  <input type="hidden" id="valor_input" name="txtPreco" />
					   <input type="hidden" name="txtIdUser" value="<%= u.getId()%>" />
					    <input type="hidden" name="txtCriptoId" id="cripto_id"/>
					  
					  <hr>
					  
					  <div class="row">
					  
					  	<div class="col-md-6" >
					  		Preço
					  	</div>
					  	
					  	<div class="col-md-6" align="right" id="valor_id">
					  		R$0,00
					  	</div>
					  	
					  	 <div class="col-md-6">
					  		Taxa %
					  	</div>
					  	
					  	<div class="col-md-6" align="right" id="taxa_id">
					  		0%
					  	</div>
					  	
					  	
					  	
					  	 <div class="col-md-6">
					  		<strong>Total</strong>
					  	</div>
					  	
					  	<div class="col-md-6" align="right" id="total_id">
					  		R$0,00
					  	</div>
					  
					  </div>
					
					   <button type="submit" class="orange-btn">Confirmar</button>
					   
					</form>
				</div>
				
				<div class="livro_ofertas">
				 <span>Livro de ofertas</span>
				 
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
		</div>
	</div>	

</body>
</html>

<%
	}
%>