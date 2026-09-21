# 🧪 Pruebas Unitarias JUnit 5  
## Descripción

Proyecto de pruebas unitarias en **Java con JUnit 5**, enfocado en comprobar reglas de negocio, casos límite y errores mediante el patrón **Arrange-Act-Assert**. Incluye la aplicación de principios **SOLID**, refactorización del código y creación de pruebas para verificar su correcto funcionamiento.

## Tecnologías utilizadas

* Java
* JUnit 5
* Gradle
* IntelliJ IDEA

## Conceptos aplicados

* Pruebas unitarias
* Patrón Arrange-Act-Assert (AAA)
* Reglas de negocio
* Casos límite
* Casos de error
* Principio de Responsabilidad Única (SRP)
* Principios SOLID
* Refactorización

## Estructura del proyecto

```text
src/
├── main/
│   └── java/
│       └── org/
│           └── example/
│               └── Main.java
│
└── test/
    └── java/
        └── ...
```

Las pruebas unitarias se encuentran dentro de la carpeta `src/test/java`.

## Pruebas unitarias

Se diseña considerando las reglas de negocio relevantes, los valores límite donde cambia el comportamiento y los casos de error que deben generar excepciones.

Cada prueba sigue el patrón:

1. **Arrange:** preparación de los datos.
2. **Act:** ejecución del método que se desea probar.
3. **Assert:** comprobación del resultado esperado.

## Refactorización

Incluye una etapa de refactorización para mejorar la estructura del código y aplicar el principio **SRP  Single Responsibility Principle**, manteniendo el comportamiento original del programa.
