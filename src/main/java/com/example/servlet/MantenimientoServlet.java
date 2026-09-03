package com.example.servlet;

import com.example.model.Mantenimiento;
import com.example.service.IMantenimientoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;

@WebServlet("/mantenimientos")
public class MantenimientoServlet extends HttpServlet {
    private IMantenimientoService service;

    @Override
    public void init() {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        service = context.getBean(IMantenimientoService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("mantenimientos", service.list());
        request.getRequestDispatcher("/mantenimientos.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Mantenimiento m = new Mantenimiento(
                    Integer.parseInt(request.getParameter("id")),
                    request.getParameter("codigoMantenimiento"),
                    request.getParameter("titulo"),
                    request.getParameter("descripcion"),
                    request.getParameter("tipoServicio"),
                    request.getParameter("taller"),
                    Integer.parseInt(request.getParameter("nivelUrgencia")),
                    Integer.parseInt(request.getParameter("vehiculoId"))
            );
            service.add(m);
            response.sendRedirect(request.getContextPath() + "/mantenimientos");
        } catch (IllegalArgumentException ex) {
            request.setAttribute("error", ex.getMessage());
            doGet(request, response);
        }
    }
}
