package com.example.servlet;

import com.example.model.Vehiculo;
import com.example.service.IVehiculoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;

@WebServlet("/vehiculos")
public class VehiculoServlet extends HttpServlet {
    private IVehiculoService service;

    @Override
    public void init() {
        WebApplicationContext context = WebApplicationContextUtils
                .getRequiredWebApplicationContext(getServletContext());
        service = context.getBean(IVehiculoService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("vehiculos", service.list());
        request.getRequestDispatcher("/vehiculos.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Vehiculo vehiculo = new Vehiculo(
                    Integer.parseInt(request.getParameter("id")),
                    request.getParameter("modelo"),
                    request.getParameter("marca"),
                    request.getParameter("placa"),
                    request.getParameter("conductor"),
                    request.getParameter("fechaIngreso"),
                    request.getParameter("estado")
            );
            
            service.add(vehiculo);
            response.sendRedirect(request.getContextPath() + "/vehiculos");
        } catch (IllegalArgumentException ex) {
            request.setAttribute("error", ex.getMessage());
            doGet(request, response);
        }
    }
}
