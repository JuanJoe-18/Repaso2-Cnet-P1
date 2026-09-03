<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Mantenimientos</title>
</head>
<body>
    <h1>Gestión de Mantenimientos</h1>
    
    <c:if test="${not empty error}">
        <p style="color:red; font-weight:bold;">${error}</p>
    </c:if>

    <h3>Registrar Mantenimiento</h3>
    <form method="post">
        Id: <input name="id" type="number" required> <br>
        Código Mantenimiento: <input name="codigoMantenimiento" required> <br>
        Título: <input name="titulo" required> <br>
        Descripción: <input name="descripcion" required> <br>
        Tipo de Servicio: <input name="tipoServicio" required> <br>
        Taller: <input name="taller" required> <br>
        Nivel de urgencia (1-10): <input name="nivelUrgencia" type="number" required> <br>
        Vehículo ID: <input name="vehiculoId" type="number" required> <br>
        <br>
        <button type="submit">Guardar</button>
    </form>

    <hr>
    
    <h3>Lista de Mantenimientos</h3>
    <ul>
        <c:forEach var="m" items="${mantenimientos}">
            <li>[ID: ${m.id}] ${m.titulo} - Código: ${m.codigoMantenimiento} (Urgencia: ${m.nivelUrgencia}, Vehículo ID: ${m.vehiculoId})</li>
        </c:forEach>
    </ul>
    
    <br>
    <a href="<%= request.getContextPath() %>/">Volver al Inicio</a> | 
    <a href="<%= request.getContextPath() %>/vehiculos">Ver Vehículos</a>
</body>
</html>
