package com.example.Monitoreo.servicio;

import com.example.Monitoreo.entidad.Muestra;

import java.util.List;

public interface MuestraServicio {

    public Muestra registrarMuestra(Long BoyaId, Muestra muestra);
    public List<Muestra> listarMuestras();

    List<Muestra> obtenerMuestraPorIdDeBoya(Long idBoya, Long idMuestra);

    List<Muestra> obtenerMuestraPorIdDeBoya(Long idBoya);
    void eliminarMuestra(Long id);
    Muestra registrarMuestra(Muestra muestra);
}
