// Prestamo.java // Comentario que indica el nombre del archivo fuente
public class Prestamo { // Define la clase pública Prestamo

    private double monto; // Variable privada para almacenar el capital solicitado
    private double tasaAnual; // Variable privada para almacenar el porcentaje de interés anual
    private int plazoMeses; // Variable privada para almacenar la duración del crédito en meses

    public Prestamo(double monto, double tasaAnual, int plazoMeses) { // Constructor con parámetros de la clase
        if (monto <= 0) throw new IllegalArgumentException("El monto debe ser mayor a cero"); // Valida que el monto sea positivo
        if (tasaAnual < 0) throw new IllegalArgumentException("La tasa no puede ser negativa"); // Valida que la tasa no sea menor a cero
        if (plazoMeses <= 0) throw new IllegalArgumentException("El plazo debe ser al menos 1 mes"); // Valida que el plazo sea positivo

        this.monto = monto; // Asigna el parámetro monto al atributo de la instancia
        this.tasaAnual = tasaAnual; // Asigna el parámetro tasaAnual al atributo de la instancia
        this.plazoMeses = plazoMeses; // Asigna el parámetro plazoMeses al atributo de la instancia
    } // Cierra el constructor Prestamo

    /**
     * Cuota mensual usando fórmula de amortización francesa:
     * C = M * r / (1 - (1 + r)^-n)
     * donde r = tasa mensual, n = plazo en meses
     */
    public double calcularCuotaMensual() { // Método público para obtener el pago de cada mes
        if (tasaAnual == 0) { // Evalúa si el préstamo no incluye intereses
            return monto / plazoMeses; // Devuelve una división simple del dinero entre los meses
        } // Cierra el bloque condicional if

        double tasaMensual = tasaAnual / 12 / 100; // Convierte el porcentaje anual a una tasa decimal mensual
        double factor = Math.pow(1 + tasaMensual, plazoMeses); // Calcula la potencia de la base de amortización (1 + r)^n
        return monto * tasaMensual * factor / (factor - 1); // Aplica la fórmula francesa completa y retorna el resultado
    } // Cierra el método calcularCuotaMensual

    public double calcularTotalPagado() { // Método público para calcular la suma de todas las cuotas
        return calcularCuotaMensual() * plazoMeses; // Multiplica la mensualidad por la cantidad de meses totales
    } // Cierra el método calcularTotalPagado

    public double calcularInteresTotal() { // Método público para saber el costo real del financiamiento
        return calcularTotalPagado() - monto; // Resta el capital original al dinero total pagado
    } // Cierra el método calcularInteresTotal

    public boolean esPagable(double ingresoMensual) { // Método público que analiza el riesgo crediticio del cliente
        if (ingresoMensual <= 0) throw new IllegalArgumentException("Ingreso debe ser positivo"); // Valida que los ingresos declarados sean válidos
        // Regla: la cuota no debe superar el 30% del ingreso
        return calcularCuotaMensual() <= ingresoMensual * 0.30; // Retorna verdadero si el pago mensual no excede el límite del 30%
    } // Cierra el método esPagable
} // Cierra la clase Prestamo
