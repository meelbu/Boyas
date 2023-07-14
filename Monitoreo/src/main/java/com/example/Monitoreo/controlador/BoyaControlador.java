package com.example.Monitoreo.controlador;

import com.example.Monitoreo.entidad.Boya;
import com.example.Monitoreo.entidad.Muestra;
import com.example.Monitoreo.servicio.BoyaServicio;
import com.example.Monitoreo.servicio.MuestraServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/boyas")
public class BoyaControlador {
     private final BoyaServicio boyaServicio;
     private final MuestraServicio muestraServicio;


    public BoyaControlador(BoyaServicio boyaServicio, MuestraServicio muestraServicio) {
        this.boyaServicio = boyaServicio;
        this.muestraServicio = muestraServicio;
    }

    @PostMapping
    public ResponseEntity<Boya> crearBoya(@RequestBody Boya boya) {
        Boya nuevaBoya = boyaServicio.crearBoya(boya);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaBoya);
    }

    @GetMapping
    public ResponseEntity<List<Boya>> obtenerBoyas() {
        List<Boya> boyas = boyaServicio.listarBoyas();
        return ResponseEntity.ok(boyas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boya> obtenerBoyaPorId(@PathVariable Long id) {
        Boya boya = boyaServicio.obtenerBoyaPorId(id);
        if (boya != null) {
            return ResponseEntity.ok(boya);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boya> actualizarColorLuz(@PathVariable Long id, @RequestBody String color) {
        Boya boyaActualizada = boyaServicio.actualizarColorDeLuz(id, color);
        if (boyaActualizada != null) {
            return ResponseEntity.ok(boyaActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{boyaId}/muestras")
    public ResponseEntity<Muestra> registrarMuestra(@PathVariable Long boyaId, @RequestBody Muestra muestra) {
        Muestra nuevaMuestra = muestraServicio.registrarMuestra(boyaId, muestra);
        if (nuevaMuestra != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaMuestra);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{idBoya}/muestras")
    public ResponseEntity<List<Muestra>> obtenerMuestrasPorBoya(@PathVariable Long idBoya) {
        List<Muestra> muestras = boyaServicio.obtenerMuestraPorIdDeBoya(idBoya);
        return ResponseEntity.ok(muestras);
    }

    @DeleteMapping("/{idBoya}/muestras/{idMuestra}")
    public ResponseEntity<String> eliminarMuestra(@PathVariable Long idBoya, @PathVariable Long idMuestra) {
        Muestra muestra = (Muestra) muestraServicio.obtenerMuestraPorIdDeBoya(idBoya, idMuestra);
        if (muestra != null) {
            if (muestra.getBoya().getId().equals(idBoya)) {
                muestraServicio.eliminarMuestra(idMuestra);
                return ResponseEntity.ok("La muestra se eliminó correctamente");
            } else {
                return ResponseEntity.badRequest().body("La muestra no pertenece a la boya especificada");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> reseteararColorDeLuz(@PathVariable Long id) {
        boyaServicio.resetearColorDeLuz(id);
        return ResponseEntity.ok("El color de la luz se ha reseteado exitosamente");
    }
}
