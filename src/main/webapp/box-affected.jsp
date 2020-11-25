<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    </head>
    <body>
        <h2>Affecter une voiture dans le box ${box.label}</h2>
        <form action="${pageContext.request.contextPath}/box/affect" method="POST">
          <input type="hidden" name="box_id" class="form-control" value="${box.id}">
          <div class="form-group">
            <label>Marque</label>
                <input type="text" name="vehicle_brand" class="form-control">
            <label>Immatriculation</label>
                <input type="text" name="vehicle_immatriculation" class="form-control">
          </div>
          <button type="submit" class="btn btn-primary">Valider</button>
        </form>
    </body>
</html>

