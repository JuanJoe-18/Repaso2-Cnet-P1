package com.example.service.impl;

import com.example.model.Mantenimiento;
import com.example.model.Vehiculo;
import com.example.repository.IMantenimientoRepository;
import com.example.repository.IVehiculoRepository;
import com.example.service.IMantenimientoService;

import java.util.ArrayList;
import java.util.List;

public class MantenimientoServiceImpl implements IMantenimientoService {

    private final IMantenimientoRepository mantenimientos;
    private final IVehiculoRepository vehiculos;

    public MantenimientoServiceImpl(IMantenimientoRepository mantenimientos, IVehiculoRepository vehiculos) {
        this.mantenimientos = mantenimientos;
        this.vehiculos = vehiculos;
    }

    @Override
    public void add(Mantenimiento mantenimiento) {
        if (mantenimiento.getNivelUrgencia() < 1 || mantenimiento.getNivelUrgencia() > 10) {
            throw new IllegalArgumentException("Nivel de urgencia fuera de rango (debe ser entre 1 y 10)");
        }
        for (Mantenimiento m : mantenimientos.list()) {
            if (m.getId() == mantenimiento.getId()) {
                throw new IllegalArgumentException("Ya existe un mantenimiento con ese ID");
            }
            if (m.getCodigoMantenimiento() != null && m.getCodigoMantenimiento().equalsIgnoreCase(mantenimiento.getCodigoMantenimiento())) {
                throw new IllegalArgumentException("No se pueden registrar dos mantenimientos con el mismo código");
            }
        }
        Vehiculo vehiculo = findVehiculo(mantenimiento.getVehiculoId());
        if (vehiculo == null) {
            throw new IllegalArgumentException("No existe un vehículo asociado");
        }
        if ("DadoDeBaja".equalsIgnoreCase(vehiculo.getEstado())) {
            throw new IllegalArgumentException("Inválido: el vehículo no puede tener el estado DadoDeBaja");
        }
        mantenimientos.add(mantenimiento);
        vehiculo.addMantenimiento(mantenimiento);
    }

    public Vehiculo findVehiculo(int id) {
        for (Vehiculo v : vehiculos.list()) {
            if (id == v.getId()) return v;
        }
        return null;
    }

    @Override
    public List<Mantenimiento> list() {
        return mantenimientos.list();
    }

    @Override
    public List<Mantenimiento> findByVehiculoId(int vehiculoId) {
        List<Mantenimiento> result = new ArrayList<>();
        for (Mantenimiento m : mantenimientos.list()) {
            if (m.getVehiculoId() == vehiculoId) {
                result.add(m);
            }
        }
        return result;
    }
}
