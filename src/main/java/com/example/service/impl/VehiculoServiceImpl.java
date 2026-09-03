package com.example.service.impl;

import com.example.model.Vehiculo;
import com.example.repository.IVehiculoRepository;
import com.example.service.IVehiculoService;

import java.util.List;

public class VehiculoServiceImpl implements IVehiculoService {

    private final IVehiculoRepository vehiculos;

    public VehiculoServiceImpl(IVehiculoRepository vehiculoRepository) {
        this.vehiculos = vehiculoRepository;
    }

    @Override
    public void add(Vehiculo vehiculo) {
        if (vehiculo.getPlaca() == null || vehiculo.getPlaca().trim().isEmpty()) {
            throw new IllegalArgumentException("La placa no puede estar vacía");
        }
        for (Vehiculo v : vehiculos.list()) {
            if (v.getId() == vehiculo.getId()) {
                throw new IllegalArgumentException("Ya existe un vehículo con ese ID");
            }
            if (v.getPlaca() != null && v.getPlaca().equalsIgnoreCase(vehiculo.getPlaca())) {
                throw new IllegalArgumentException("Placa duplicada");
            }
        }
        vehiculos.add(vehiculo);
    }

    @Override
    public List<Vehiculo> list() {
        return vehiculos.list();
    }
}
