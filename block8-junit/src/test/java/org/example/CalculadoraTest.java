package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;


class CalculadoraTest {
    @Test
    void suma() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.suma(32, 94);
        assertThat(resultado, is(126)); //Valor que debería dar, Variable a comparar
    }

    @Test
    @DisplayName("pruebaDisplayResta")
    void resta() {

        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.resta(97, 23);
        assertEquals(4, resultado); //Valor que deberia dar, Variable a comparar

    }

    @Test
    @Tag("avanzada")
    void division() {

        Calculadora calculadora = new Calculadora();
        double resultado = calculadora.division(20, 5);
        assertEquals(4, resultado); //Valor que deberia dar, Variable a comparar
    }

    @Test
    @Tag("avanzada")
    void multiplicacion() {

        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.multiplicacion(100, 6);
        assertEquals(392, resultado); //Valor que deberia dar, Variable a comparar

    }
}