import org.junit.jupiter.api.Test; // Importa la anotación Test de JUnit 5

import static org.junit.jupiter.api.Assertions.*; // Importa los métodos estáticos de aserción

class PrestamoTest { // Define la clase de pruebas para Prestamo

    @Test // Indica que el siguiente método es una prueba unitaria
    void montoNegativo() { // Prueba para validar el comportamiento con monto negativo
        assertThrows(IllegalArgumentException.class, // Verifica que se lance la excepción IllegalArgumentException
                () -> new Prestamo(-1000, 10, 12)); // Ejecuta la creación del préstamo con monto de -1000
    } // Cierra el método montoNegativo

    @Test // Indica que el siguiente método es una prueba unitaria
    void el_PlazoCero() { // Prueba para validar el comportamiento con plazo cero
        assertThrows(IllegalArgumentException.class, // Verifica que se lance la excepción IllegalArgumentException
                () -> new Prestamo(5000, 10, 0)); // Ejecuta la creación del préstamo con plazo de 0 meses
    } // Cierra el método el_PlazoCero


    @Test // Indica que el siguiente método es una prueba unitaria
    void calcularCuotaMensual_TasaCero_DevuelveMontoDivididoPlazo() { // Prueba la cuota mensual sin intereses
        Prestamo p = new Prestamo(12000, 0, 12); // Crea un préstamo de 12000 a tasa 0 y 12 meses
        assertEquals(1000.0, p.calcularCuotaMensual(), 0.01); // Verifica que la cuota sea 1000 con margen de error de 0.01
    } // Cierra el método calcularCuotaMensual_TasaCero_DevuelveMontoDivididoPlazo


    @Test // Indica que el siguiente método es una prueba unitaria
    void calcularTotalPagado() { // Prueba el cálculo del total a pagar acumulado
        Prestamo p = new Prestamo(10000, 12, 24); // Crea un préstamo de 10000 con tasa del 12% a 24 meses
        double esperado = p.calcularCuotaMensual() * 24; // Calcula el valor esperado multiplicando la cuota por los meses
        assertEquals(esperado, p.calcularTotalPagado(), 0.001); // Verifica que el total pagado coincida con el esperado
    } // Cierra el método calcularTotalPagado

    // PRUEBA 5: esPagable devuelve true cuando ingreso es suficiente
    @Test // Indica que el siguiente método es una prueba unitaria
    void esPagable_IngresoSuficiente_RetornaTrue() { // Prueba si aprueba el préstamo con buenos ingresos
        Prestamo p = new Prestamo(5000, 10, 12); // Crea un préstamo de 5000 con tasa del 10% a 12 meses
        assertTrue(p.esPagable(2000)); // Verifica que devuelva true para un ingreso de 2000
    } // Cierra el método esPagable_IngresoSuficiente_RetornaTrue


    @Test // Indica que el siguiente método es una prueba unitaria
    void cuota_supera30poci_de_IngresoInsuficiente() { // Prueba si rechaza el préstamo con bajos ingresos
        Prestamo p = new Prestamo(5000, 10, 12); // Crea un préstamo de 5000 con tasa del 10% a 12 meses
        assertFalse(p.esPagable(500)); // Verifica que devuelva false para un ingreso insuficiente de 500
    } // Cierra el método cuota_supera30poci_de_IngresoInsuficiente


    // PRUEBA 7: Interés total es positivo con tasa > 0
    @Test // Indica que el siguiente método es una prueba unitaria
    void calcularInteresTotal_TasaPositiva_InteresPositivo() { // Prueba que el interés generado sea mayor a cero
        Prestamo p = new Prestamo(10000, 12, 24); // Crea un préstamo de 10000 con tasa del 12% a 24 meses
        assertTrue(p.calcularInteresTotal() > 0); // Verifica que el interés total calculado sea un número positivo
    } // Cierra el método calcularInteresTotal_TasaPositiva_InteresPositivo
} // Cierra la clase PrestamoTest
