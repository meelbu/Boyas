package com.example.Monitoreo.servicio;

import com.example.Monitoreo.entidad.Muestra;

import java.util.List;

public interface MuestraServicio {

    Muestra registrarMuestra(Muestra muestra);

    Muestra obtenerColor(Muestra muestra);

    List<Muestra> obtenerMuestraPorIdDeBoya(Long idBoya);
    
    void eliminarMuestra(Long id);

    Muestra obtenerMuestraPorId(Long id);
}
