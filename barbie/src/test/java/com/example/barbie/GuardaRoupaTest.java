package com.example.barbie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class GuardaRoupaTest {

	private GuardaRoupa guardaRoupa;

	@BeforeEach
	void configurar() {
		guardaRoupa = new GuardaRoupa(500.00);
	}

	@Test
	void calcularComDesconto() {
		double resultado = guardaRoupa.precoComDesconto(100.00, 10.00);
		assertEquals(90.00, resultado, 0.001);
	}

	@Test
	void recusarDescontoMaiorCem() {
		assertThrows(IllegalArgumentException.class, () -> guardaRoupa.precoComDesconto(100.00, 101.00));
	}

	@Test
	void recusarDescontoNegativo() {
		assertThrows(IllegalArgumentException.class, () -> guardaRoupa.precoComDesconto(100.00, -1.00));
	}

	@Test
	void precoAcimaOrcamento() {
		assertFalse(guardaRoupa.cabeNoOrcamento(600.00));
	}

	@Test
	void precoIgualOrcamento() {
		assertTrue(guardaRoupa.cabeNoOrcamento(500.00));
	}

	@Test
	void naoEDeGala() {
		assertFalse(guardaRoupa.ehDeGala(200.00));
	}

	@Test
	void eDeGala() {
		assertTrue(guardaRoupa.ehDeGala(250.00));
	}


}
