<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Vehículos</title>
</head>
<body>
    <h1>Gestión de Vehículos</h1>
    
    <c:if test="${not empty error}">
        <p style="color:red; font-weight:bold;">${error}</p>
    </c:if>
    <h3>Registrar Vehículo</h3>
    <form method="post">
        Id: <input name="id" type="number" required> <br>
        Modelo: <input name="modelo" required> <br>
        Marca: <input name="marca" required> <br>
        Placa: <input name="placa" required> <br>
        Conductor: <input name="conductor" required> <br>
        Fecha de Ingreso: <input name="fechaIngreso" required> <br>
        Estado: <input name="estado" required> (ej. Activo, EnTaller, DadoDeBaja) <br>
        <br>
        <button type="submit">Guardar</button>
    </form>

    <hr>
    <h3>Lista de Vehículos</h3>
    <ul>
        <c:forEach var="v" items="${vehiculos}">
            <li>
                [ID: ${v.id}] ${v.marca} ${v.modelo} - Placa: ${v.placa} (Conductor: ${v.conductor}, Estado: ${v.estado})
            </li>
        </c:forEach>
    </ul>
    
    <br>
    <a href="<%= request.getContextPath() %>/">Volver al Inicio</a> | 
    <a href="<%= request.getContextPath() %>/mantenimientos">Ver Mantenimientos</a>
</body>
</html>
