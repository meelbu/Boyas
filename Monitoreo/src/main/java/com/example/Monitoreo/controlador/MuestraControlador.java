package com.example.Monitoreo.controlador;

import com.example.Monitoreo.entidad.Muestra;
import com.example.Monitoreo.servicio.MuestraServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/muestras")
public class MuestraControlador {

    private final MuestraServicio muestraServicio;


    public MuestraControlador(MuestraServicio muestraServicio) {
        this.muestraServicio = muestraServicio;
    }

    @PostMapping
    public ResponseEntity<Muestra> registrarMuestra(@RequestBody Muestra muestra) {
        Muestra nuevaMuestra = muestraServicio.registrarMuestra(muestra);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaMuestra);
    }

    @GetMapping
    public ResponseEntity<List<Muestra>> listarMuestras() {
        List<Muestra> muestras = muestraServicio.listarMuestras();
        return ResponseEntity.ok(muestras);
    }

    @GetMapping("/boyas/{idBoya}")
    public ResponseEntity<List<Muestra>> obtenerMuestraPorIdDeBoya(@PathVariable Long idBoya) {
      List<Muestra> muestras = muestraServicio.obtenerMuestraPorIdDeBoya(idBoya);
      return ResponseEntity.ok(muestras);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarMuestra(@PathVariable Long id) {
        muestraServicio.eliminarMuestra(id);
        return ResponseEntity.ok("La muestra ha sido eliminada correctamente");
    }
}
