package model;

import java.time.LocalDate;

public abstract class Servicio {

    // atributos
    protected String codServicio;
    protected double porcentajeDescuento;
    protected boolean enPromocion;

    // constructor
    public Servicio(String codServicio, double porcentajeDescuento, boolean enPromocion) throws Exception {
        // aca verifico que tenga si o si 6 caracteres
        if (codServicio.length() != 6) {
            throw new Exception("El código de servicio debe tener 6 caracteres.Reingrese porfavor");
        }
        this.codServicio = codServicio;
        this.porcentajeDescuento = porcentajeDescuento;
        this.enPromocion = enPromocion;
    }

    // getters y setters
    public String getCodServicio() {
        return codServicio;
    }

    public void setCodServicio(String codServicio) {
        this.codServicio = codServicio;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }
    // verifico si esta en promocion
    public boolean isEnPromocion() {
        return enPromocion;
    }

    public void setEnPromocion(boolean enPromocion) {
        this.enPromocion = enPromocion;
    }

    // es un metodo abstracto para calcular el precio final segun la fecha
    public abstract double calcularPrecioFinal(LocalDate dia);

}
