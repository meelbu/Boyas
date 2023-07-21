package com.example.Monitoreo.entidad;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "boya")
public class Boya {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String colorLuz;

    private double longitudInstalacion;

    private double latitudInstalacion;

    @OneToMany(mappedBy = "boya", cascade = CascadeType.ALL)
    private List<Muestra> muestras;

    public Boya() {
    }

    public Boya(Long id, String colorLuz, double longitudInstalacion, double latitudInstalacion, List<Muestra> muestras) {
        this.id = id;
        this.colorLuz = colorLuz;
        this.longitudInstalacion = longitudInstalacion;
        this.latitudInstalacion = latitudInstalacion;
        this.muestras = muestras;
    }

    public Long getId() {
        return id;
    }

    public String getColorLuz() {
        return colorLuz;
    }

    public void setColorLuz(String colorLuz) {
        this.colorLuz = colorLuz;
    }

    public double getLongitudInstalacion() {
        return longitudInstalacion;
    }

    public void setLongitudInstalacion(double longitudInstalacion) {
        this.longitudInstalacion = longitudInstalacion;
    }

    public double getLatitudInstalacion() {
        return latitudInstalacion;
    }

    public void setLatitudInstalacion(double latitudInstalacion) {
        this.latitudInstalacion = latitudInstalacion;
    }

    public List<Muestra> getMuestras() {
        return muestras;
    }

    public void setMuestras(List<Muestra> muestras) {
        this.muestras = muestras;
    }
}
