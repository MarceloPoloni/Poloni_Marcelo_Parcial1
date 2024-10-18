package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {

    // Atributo 
    private List<Servicio> lstServicio;

    // Constructores 
    public Sistema(List<Servicio> lstServicio) {
        this.lstServicio = lstServicio;
    }

    public Sistema() {
        lstServicio = new ArrayList<>();
    }

    
    
    
    // Getter y setter
    public List<Servicio> getLstServicio() {
        return lstServicio;
    }

    public void setLstServicio(List<Servicio> lstServicio) {
        this.lstServicio = lstServicio;
    }


    // Métodos
    public Servicio traerServicio(String codServicio) {
        for (Servicio s : lstServicio) {
            if (s.getCodServicio().equals(codServicio)) { 
                return s;
            }
        }
        return null; 
    }

    public List<Servicio> traerServicio(boolean enPromocion) {
        List<Servicio> result = new ArrayList<>();
        for (Servicio s : lstServicio) {
            if (s.isEnPromocion() == enPromocion) { 
                result.add(s);
            }
        }
        return result; 
    }

    public List<Servicio> traerServicio(boolean enPromocion, LocalDate dia) {
        List<Servicio> result = new ArrayList<>();
        for (Servicio s : lstServicio) {
            if (s.isEnPromocion() == enPromocion && s.calcularPrecioFinal(dia) != 0) { 
                result.add(s);
            }
        }
        return result; 
    }

    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) throws Exception {
        if (traerServicio(codServicio) != null) {
            throw new Exception("El servicio ya existe.");         }
        Gastronomia gastronomiaServicio = new Gastronomia(codServicio, porcentajeDescuento, enPromocion, gastronomia, precio, diaSemDesc);
        lstServicio.add(gastronomiaServicio);
        return true;
    }

    public boolean agregarHospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) throws Exception {
        if (traerServicio(codServicio) != null) {
            throw new Exception("El servicio ya existe."); 
        }
        Hospedaje hospedajeServicio = new Hospedaje(codServicio, porcentajeDescuento, enPromocion, hospedaje, precioPorNoche);
        lstServicio.add(hospedajeServicio); 
        return true;
    }
}
