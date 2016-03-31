<%-- 
    Document   : index
    Created on : 30/03/2016, 11:32:29
    Author     : 31463738
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teste-do-mercado</title>
    </head>
    <body>

        <fieldset>
            <legend>Escolha o tipo da mercadoria e se é venda ou compra:</legend>
            <form name="form1" action="FrontController" method="POST">

                <p>Tipo do Produto: 
                <select>
                    <c:forEach items="${ListaTm}" var="item">
                        <option value="${item.cod_TipoMercadoria}" > ${item.des_TipoMercadoria}</option>
                        
                    </c:forEach>
                </select>
                </p>
                
                Negócio:
                <select name="negocio" >
                    <option value="venda">Venda</option>
                    <option value="compra">Compra</option>
                </select>

                <p><input type="submit" value="CONTINUAR"</p>
                <input type="hidden" name="command" value="tm.insert"/>
                
            </form>
        </fieldset>

        <fieldset>
            <legend>Inserir produto</legend>
            <form action="FrontController" method="POST">
                <p>Cod_Mercadoria: {$cod_Mercadoria}</p>
                <p>Nome do Produto: <input type="text" name="nome_Mercadoria" maxlength="200" required/> *</p>
                <p>Preço: <input type="number" name="preco" required/> *</p> 

            </form>
        </fieldset>

        <fieldset>
            <legend>Lista dos produtos</legend>
            <form action="FrontController" method="POST">
                <p>Cod_Mercadoria: {$cod_Mercadoria}</p>
                <p>Descrição da Mercadoria: {$nome_Mercadoria}</p>
                <p>Preço: {$cod_Mercadoria}</p>



            </form>
        </fieldset>

    </body>
</html>
