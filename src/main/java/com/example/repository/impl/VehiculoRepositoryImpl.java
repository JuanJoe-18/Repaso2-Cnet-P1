package com.example.repository.impl;

import com.example.model.Vehiculo;
import com.example.repository.IVehiculoRepository;

import java.util.ArrayList;
import java.util.List;

public class VehiculoRepositoryImpl implements IVehiculoRepository {
    private final List<Vehiculo> vehiculos = new ArrayList<>();

    @Override
    public void add(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    @Override
    public List<Vehiculo> list() {
        return new ArrayList<>(vehiculos);
    }
}
