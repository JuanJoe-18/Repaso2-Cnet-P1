<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sistema de Gestión de Flota - Inicio</title>
</head>
<body>
    <h1>Gestión de Taller y Vehículos</h1>
    <h2>Seleccione el módulo a gestionar:</h2>
    <ul>
        <li><a href="<%= request.getContextPath() %>/vehiculos">Gestión de Vehículos</a></li>
        <li><a href="<%= request.getContextPath() %>/mantenimientos">Gestión de Mantenimientos</a></li>
    </ul>
</body>
</html>