package model;

import java.time.LocalDate;

public class Gastronomia extends Servicio {
    //atributos

    private String gastronomia;
    private double precio;
    private int diaSemDesc;

    // 
    public Gastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) throws Exception {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.gastronomia = gastronomia;
        this.precio = precio;
        this.diaSemDesc = diaSemDesc;
    }

    // Geters y seters
    public String getGastronomia() {
        return gastronomia;
    }

    public void setGastronomia(String gastronomia) {
        this.gastronomia = gastronomia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDiaSemDesc() {
        return diaSemDesc;
    }

    public void setDiaSemDesc(int diaSemDesc) {
        this.diaSemDesc = diaSemDesc;
    }
    // metodo para calcular el precio y si es que esta en promocion

    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        if (enPromocion && dia.getDayOfWeek().getValue() == diaSemDesc) {
            return precio * (1 - porcentajeDescuento / 100);
        }
        return precio;
    }
    // to string
    @Override
public String toString() {
    return "Gastronomia{" +
            "codServicio='" + codServicio + '\'' +
            ", porcentajeDescuento=" + porcentajeDescuento +
            ", enPromocion=" + enPromocion +
            ", gastronomia='" + gastronomia + '\'' +
            ", precio=" + precio +
            ", diaSemDesc=" + diaSemDesc +
            '}';
}

}
