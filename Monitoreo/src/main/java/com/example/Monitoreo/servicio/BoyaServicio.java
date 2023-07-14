package com.example.Monitoreo.servicio;

import com.example.Monitoreo.entidad.Boya;
import com.example.Monitoreo.entidad.Muestra;

import java.util.List;

public interface BoyaServicio {

    public Boya crearBoya(Boya boya);
    public List<Boya> listarBoyas();
    public Boya obtenerBoyaPorId(Long id);
    Boya actualizarColorDeLuz(Long id, String color);
    public Muestra registrarMuestra(Muestra muestra);
    List<Muestra> obtenerMuestraPorIdDeBoya(Long idBoya);
    void resetearColorDeLuz(Long id);

    void resetearColor(Long id);
}
