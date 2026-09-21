public class CalculadoraDescuento {

    public double aplicarDescuento(double total, String categoria) {
        validarEntradas(total, categoria);
        if (total < 50) {
            return total;
        }
        double mayorDescuento = Math.max(
                calcularDescuentoPorMonto(total),
                calcularDescuentoPorCategoria(total, categoria)
        );
        return total - mayorDescuento;
    }
    private void validarEntradas(double total, String categoria) {
        if (total < 0) {
            throw new IllegalArgumentException("El total no puede ser negativo.");
        }
        if (categoria == null) {
            throw new IllegalArgumentException("La categoria no puede ser nula.");
        }
    }
    private double calcularDescuentoPorMonto(double total) {
        return total > 100 ? total * 0.10 : 0;
    }
    private double calcularDescuentoPorCategoria(double total, String categoria) {
        return categoria.equalsIgnoreCase("electronica") ? total * 0.20 : 0;
    }
}


