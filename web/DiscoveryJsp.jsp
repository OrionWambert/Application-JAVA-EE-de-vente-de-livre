<%-- 
    Document   : DiscoveryJsp
    Created on : 1 nov. 2017, 11:25:38
    Author     :Orion WAMBERT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Discovery</title>
    </head>
    <jsp:include page="style2.jsp" />

    <body>

        <header class="container-fluid">

            <div class="pull-left">Discovery <a href="<c:url value="/article" />">go to profile</a> <span class="pull-right">  ${message=!null?message:""}</span></div>

        </header>

        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12 col-md-12">
                    <table class="table table-bordered table-striped table-condensed">
                        <thead>
                        <th>N°</th>
                        <th>Nom</th>
                        <th>dateEdition</th>
                        <th>Auteur</th>
                        <th>nombrePage</th>
                        <th>editeur</th>
                        <th>Quantité</th>

                        </thead>
                        <tbody>

                            <c:forEach items="${livreList}" var="u"  varStatus="i">
                                <tr>

                                    <td>${i.index+1}</td>
                                    <td>${u.nom}</td>
                                    <td>${u.dateEdition}</td>
                                    <td>${u.auteur}</td>
                                    <td>${u.nombrePage}</td>
                                    <td>${u.editeur}</td>

                            <form method="POST" action="<c:url value="/discovery" />">
                                <td><input type="number" name="nombres" class="form-control" ></td>

                                <td><input type="hidden" value="${i.index}" name="item">
                                    <button type="submit" name="envoyer" value="add" class="btn btn-success">ajouter au panier</button>
                                </td>
                            </form>                                         
                            </tr>                                                      
                        </c:forEach>


                        </tbody>
                    </table>
                </div>
            </div>




        </div>

    </body>
    <jsp:include page="/style.jsp" />
</html>
