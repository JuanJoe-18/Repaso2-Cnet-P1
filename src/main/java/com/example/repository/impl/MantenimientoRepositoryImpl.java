package com.example.repository.impl;

import com.example.model.Mantenimiento;
import com.example.repository.IMantenimientoRepository;

import java.util.ArrayList;
import java.util.List;

public class MantenimientoRepositoryImpl implements IMantenimientoRepository {
    private final List<Mantenimiento> mantenimientos = new ArrayList<>();

    @Override
    public void add(Mantenimiento mantenimiento) {
        mantenimientos.add(mantenimiento);
    }

    @Override
    public List<Mantenimiento> list() {
        return new ArrayList<>(mantenimientos);
    }
}
