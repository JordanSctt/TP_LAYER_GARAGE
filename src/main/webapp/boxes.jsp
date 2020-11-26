<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    </head>
    <body>
        <c:if test="${not empty param.errorMessage}">
           <div class="alert alert-warning">
              <c:choose>
               <c:when test = "${param.errorMessage eq 'AFFECTED_ERROR'}">
                  Une erreur est survenue lors de l'affectation d'un vehicule
               </c:when>
               <c:otherwise>
                  Une erreur inconnue est survenue
               </c:otherwise>
              </c:choose>
           </div>
        </c:if>
        <c:if test="${not empty param.successMessage}">
           <div class="alert alert-success">
             <c:choose>
              <c:when test = "${param.successMessage eq 'AFFECTED_CREATED'}">
                L'affectation s'est passé avec succès.
              </c:when>
             </c:choose>
           </div>
        </c:if>
        <h2>Etats des boxes</h2>
        <table class="table">
          <thead class="thead-dark">
            <tr>
              <th scope="col">Label</th>
              <th scope="col">Véhicules</th>
              <th scope="col">Immatriculation</th>
              <th scope="col">Nom du proprietaire</th>
              <th scope="col">Actions</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${ requestScope.boxes}" var="box">
                <tr>
                    <td><c:out value="${ box.label }" /></td>
                    <td><c:out value="${box.vehicleBrand}" /></td>
                    <td><c:out value="${box.vehicleImmatriculation}" /></td>
                    <td><c:out value="${box.userNom}" /></td>
                    <td><a href="${pageContext.request.contextPath}/box/affect?box_id=<c:out value="${ box.id }" />"/>affecter<a/></td>
                </tr>
            </c:forEach>
          </tbody>
        </table>
<!--
        <h2>Les véhicules enregistrés</h2>
        <table class="table">
          <thead>
            <tr>              
              <th scope="col">Véhicules</th>
              <th scope="col">Immatriculation</th>
              <th scope="col">Proprietaire</th>
              <th scope="col">Actions</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${requestScope.Vehicles}" var="vehicule">
                <tr>
                    <td><c:out value="${box.vehicleBrand}" /></td>
                    <td><c:out value="${box.vehicleImmatriculation}" /></td>
                    <td></td>
                    <td><a href="#" />"/>Supprimer<a/></td>
                </tr>
            </c:forEach>
          </tbody>
        </table>
-->
    </body>
</html>