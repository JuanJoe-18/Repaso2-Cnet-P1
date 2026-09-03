package com.example.repository;

import com.example.model.Mantenimiento;
import java.util.List;

public interface IMantenimientoRepository {
    void add(Mantenimiento mantenimiento);
    List<Mantenimiento> list();
}
