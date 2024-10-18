package model;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Hospedaje extends Servicio {

    // atributos
    private String hospedaje;
    private double precioPorNoche;

    //constructor
    public Hospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) throws Exception {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.hospedaje = hospedaje;
        this.precioPorNoche = precioPorNoche;
    }
    // Geters y seters

    public String getHospedaje() {
        return hospedaje;
    }

    public void setHospedaje(String hospedaje) {
        this.hospedaje = hospedaje;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    // metodo para calcular el precio y si es que esta en promocion
    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        if (enPromocion && (dia.getDayOfWeek() != DayOfWeek.SATURDAY && dia.getDayOfWeek() != DayOfWeek.SUNDAY)) {
            return precioPorNoche * (1 - porcentajeDescuento / 100);
        }
        // en caso de no estar en promocion retorna el precio por noche
        return precioPorNoche;
    }
    
    // to string
    @Override
    public String toString() {
        return "Hospedaje{"
                + "codServicio='" + codServicio + '\''
                + ", porcentajeDescuento=" + porcentajeDescuento
                + ", enPromocion=" + enPromocion
                + ", hospedaje='" + hospedaje + '\''
                + ", precioPorNoche=" + precioPorNoche
                + '}';
    }

}
