package com.example.Monitoreo.controlador;

import com.example.Monitoreo.entidad.Boya;
import com.example.Monitoreo.entidad.Muestra;
import com.example.Monitoreo.servicio.BoyaServicio;
import com.example.Monitoreo.servicio.MuestraServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/muestras")
public class MuestraControlador {

    private final MuestraServicio muestraServicio;

    private final BoyaServicio boyaServicio;

    @Autowired
    public MuestraControlador(MuestraServicio muestraServicio, BoyaServicio boyaServicio) {
        this.muestraServicio = muestraServicio;
        this.boyaServicio = boyaServicio;
    }

    @PostMapping("/muestras")
    public ResponseEntity<Muestra> registrarMuestra(@PathVariable Long boyaId, @RequestBody Muestra muestra) {
        Boya boya = boyaServicio.obtenerBoyaPorId(boyaId);
        if (boya != null) {
            muestra.setBoya(boya);
            Muestra nuevaMuestra = muestraServicio.registrarMuestra(muestra);
            if (nuevaMuestra != null) {
                String color = obtenerColor(nuevaMuestra.getAlturaNivelDelMar());
                boya.setColorLuz(color);
                boyaServicio.actualizarBoya(boya);

                return ResponseEntity.status(HttpStatus.CREATED).body(nuevaMuestra);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private String obtenerColor(double alturaNivelDelMar) {
        if (alturaNivelDelMar < -100 || alturaNivelDelMar > 100) {
            return "ROJO";
        } else if (alturaNivelDelMar < -50 || alturaNivelDelMar > 50) {
            return "AMARILLO";
        } else {
            return "VERDE";
        }
    }

    @GetMapping("/boyas/{idBoya}/muestras")
    public ResponseEntity<List<Muestra>> obtenerMuestrasPorIdDeBoya(@PathVariable Long idBoya) {
        List<Muestra> muestras = muestraServicio.obtenerMuestraPorIdDeBoya(idBoya);
        return ResponseEntity.ok(muestras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Muestra> obtenerMuestraPorId(@PathVariable Long id) {
        Muestra muestra = muestraServicio.obtenerMuestraPorId(id);
        if (muestra != null) {
            return ResponseEntity.ok(muestra);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/boyas/{id}")
    public ResponseEntity<String> eliminarMuestra(@PathVariable Long id) {
        Muestra muestra = muestraServicio.obtenerMuestraPorId(id);
        if (muestra != null) {
            muestraServicio.eliminarMuestra(id);
            Boya boya = muestra.getBoya();
            boya.setColorLuz("AZUL");
            boyaServicio.actualizarBoya(boya);
            return ResponseEntity.ok("La muestra ha sido eliminada correctamente");
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
