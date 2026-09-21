import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculadoraDescuentoTest {

    @Test
    void aplicarDescuento_totalMenorA50_retornaTotalSinDescuento() {
        // Arrange: se crean los datos necesarios de la prueba
        CalculadoraDescuento cal = new CalculadoraDescuento();
        double total = 30.0;
        String categoria = "ropa";
        // Act: Se ejecuta el metodo que se quiere probar
        double resultado = cal.aplicarDescuento(total, categoria);
        // Assert: se verifica que el resultado sea el esperado
        assertEquals(30.0, resultado);
    }
    @Test
    void aplicarDescuento_totalMayorA100CategoriaGenerica_aplicaDescuentoDel10() {
        // Arrange
        CalculadoraDescuento calc = new CalculadoraDescuento();
        double total = 200.0;
        String categoria = "ropa";
        // Act
        double resultado = calc.aplicarDescuento(total, categoria);
        // Assert
        assertEquals(180.0, resultado);
    }
    @Test
    void aplicarDescuento_totalEn4999_retornaTotalSinDescuento() {
        // Arrange
        CalculadoraDescuento calc = new CalculadoraDescuento();
        double total = 49.99;
        String categoria = "ropa";
        // Act
        double resultado = calc.aplicarDescuento(total, categoria);
        // Assert
        assertEquals(49.99, resultado);
    }
    @Test
    void aplicarDescuento_totalNegativo_lanzaIllegalArgumentException(){
        // Arrange
        CalculadoraDescuento calc = new CalculadoraDescuento();
        //Act & Assert
        assertThrows(IllegalArgumentException.class, () ->{
            calc.aplicarDescuento(-10.0, "ropa");
        });

    }
    @Test
    void aplicarDescuento_TotalConCategoriaelectonica(){
        CalculadoraDescuento calc = new CalculadoraDescuento();
        double total = 80.0;
        String categoria = "electronica";
        double resultado = calc.aplicarDescuento(total, categoria);
        assertEquals(64.00, resultado);
    }
    @Test
    void  aplicarDescuento_AmbasReglasActivas_GanaElMayorDescuento(){
        CalculadoraDescuento calc = new CalculadoraDescuento();
        double total = 200.00;
        String categoria = "electronica";
        double resultado = calc.aplicarDescuento(total, categoria);
        assertEquals(160.00, resultado);
    }
    @Test
    void CalcularTotal_EnElValorLimite(){
        CalculadoraDescuento calc = new CalculadoraDescuento();
        double total = 50.00;
        String categoria = "ropa";
        double resultado = calc.aplicarDescuento(total, categoria);
        assertEquals(50.00, resultado);
    }
}

