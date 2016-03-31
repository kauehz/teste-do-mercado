<%-- 
    Document   : index
    Created on : 30/03/2016, 11:32:29
    Author     : 31463738
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teste-do-mercado</title>
    </head>
    <body>

        <fieldset>
            <legend>Inserir produto</legend>
            <form action="FrontController" method="POST">
                <p>Cod_Mercadoria: {$cod_Mercadoria}</p>
                
                
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
