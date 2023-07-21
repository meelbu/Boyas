package com.example.Monitoreo.servicio;

import com.example.Monitoreo.entidad.Boya;
import com.example.Monitoreo.entidad.Muestra;

import java.util.List;

public interface BoyaServicio {

    public Boya crearBoya(Boya boya);
    public List<Boya> listarBoyas();
    public Boya obtenerBoyaPorId(Long id);
    public Boya actualizarColorLuz();
    void actualizarColorLuz(Long id);
    Boya actualizarBoya(Boya boya);
}
