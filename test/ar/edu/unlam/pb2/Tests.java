package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void queSePuedaCrearElMontacargas() {
		MontaCargas actual = new MontaCargas(100.0);

		Double deseado = 100.0;
		Double obtenido = actual.getPeso_maximo();

		assertNotNull(actual);
		assertEquals(obtenido, deseado);
	}

	@Test
	public void queSePuedaMontarUnaCargaEnElMontacargas() throws CargaInexistenteException {
		MontaCargas actual = new MontaCargas(100.0);
		Carga carga = new Carga(10.0);

		assertTrue(actual.cargar(carga));

	}

	@Test(expected = CargaInexistenteException.class)
	public void queNoSePuedaMontarUnaCargaInexistenteEnElMontacargas() throws CargaInexistenteException {
		MontaCargas actual = new MontaCargas(100.0);

		actual.cargar(null);

	}

	@Test
	public void queNoSePuedaMontarUnaCargaEnElMontacargasQueSupereElPesoMaximo() throws CargaInexistenteException {
		MontaCargas actual = new MontaCargas(100.0);
		Carga carga = new Carga(200.0);

		assertFalse(actual.cargar(carga));

	}

	@Test
	public void queNoSePuedaMontarUnaCargaEnElMontacargasQueSupereElPesoMaximoSiSeSumaAlasQueYaTiene()
			throws CargaInexistenteException {
		MontaCargas actual = new MontaCargas(100.0);
		Carga carga = new Carga(50.0);
		Carga carga2 = new Carga(50.0);
		Carga carga3 = new Carga(10.0);

		actual.cargar(carga);
		actual.cargar(carga2);

		assertFalse(actual.cargar(carga3));

	}

	@Test
	public void queSePuedaCalcularElPesoActualDelMontacargas() throws CargaInexistenteException {
		MontaCargas actual = new MontaCargas(100.0);
		Carga carga = new Carga(40.0);
		Carga carga2 = new Carga(30.0);

		actual.cargar(carga);
		actual.cargar(carga2);

		Double deseado = 70.0;
		Double obtenido = actual.getPesoActual();
		assertEquals(deseado, obtenido);

	}

	@Test
	public void queSePuedaDescargarElMontacargas() throws CargaInexistenteException {
		MontaCargas actual = new MontaCargas(100.0);
		Carga carga = new Carga(40.0);
		Carga carga2 = new Carga(30.0);

		actual.cargar(carga);
		actual.cargar(carga2);
		actual.decargar();

		Double deseado = 0.0;
		Double obtenido = actual.getPesoActual();
		assertEquals(deseado, obtenido);

	}

	@Test
	public void queSePuedaCalcularElPesoPromedioDeLasCargasCompletas() throws CargaInexistenteException {
		MontaCargas actual = new MontaCargas(100.0);
		Carga carga = new Carga(40.0);
		Carga carga2 = new Carga(40.0);

		actual.cargar(carga);
		actual.cargar(carga2);
		actual.decargar();

		Double deseado = 40.0;
		Double obtenido = actual.getPesoPromedioCargasCompletas();
		assertEquals(deseado, obtenido);

	}

}
