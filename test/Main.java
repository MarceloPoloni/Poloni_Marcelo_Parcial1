package test;

import java.time.LocalDate;
import model.Servicio;
import model.Sistema;

public class Main {

    public static void main(String[] args) {
        try {
            Sistema sistema = new Sistema();

            // 1-1 Intentar crear el objeto Gastronomia con código inválido
            System.out.println("1-1");
            try {
                sistema.agregarGastronomia("4892", 15.0, true, "Hamburguesa criolla", 180.0, 4);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            // 1-2 Crear el objeto Gastronomia
            System.out.println("1-2");
            sistema.agregarGastronomia("489235", 15.0, true, "Hamburguesa criolla", 180.0, 4);

            // 1-3 Intentar crear el objeto Hospedaje con código inválido
            System.out.println("1-3");
            try {
                sistema.agregarHospedaje("2872", 10.0, true, "Cabaña 3 personas", 1500.0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            // 1-4 Crear el objeto Hospedaje
            System.out.println("1-4");
            sistema.agregarHospedaje("287282", 10.0, true, "Cabaña 3 personas", 1500.0);

            // 2-1 Calcular e imprimir precio final Gastronomia
            System.out.println("2-1");
            Servicio gastronomia = sistema.traerServicio("489235");
            System.out.println("Precio final: " + gastronomia.calcularPrecioFinal(LocalDate.of(2020, 10, 28)));

            // 2-2 Calcular e imprimir precio final Hospedaje
            System.out.println("2-2");
            Servicio hospedaje = sistema.traerServicio("287282");
            System.out.println("Precio final: " + hospedaje.calcularPrecioFinal(LocalDate.of(2020, 10, 27)));

            // 3 Agregar servicios e imprimir lista
            System.out.println("3");
            sistema.agregarGastronomia("858927", 15.0, true, "Milanesa con puré", 350.0, 3);
            sistema.agregarHospedaje("489259", 10.0, true, "Habitación triple", 2200.0);
            sistema.agregarGastronomia("182835", 20.0, false, "Gaseosa", 120.0, 3);
            sistema.agregarHospedaje("758972", 15.0, false, "Habitación simple", 1000.0);
            
            // 4-1 Traer servicios en promoción
            System.out.println("4-1");
            for (Servicio s : sistema.traerServicio(true)) {
                System.out.println(s.toString()); // Asegúrate de llamar al método toString
            }

            // 4-2 Traer servicios en promoción para un día específico
            System.out.println("4-2");
            for (Servicio s : sistema.traerServicio(true, LocalDate.of(2020, 10, 28))) {
                System.out.println(s.toString()); // Asegúrate de llamar al método toString
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
