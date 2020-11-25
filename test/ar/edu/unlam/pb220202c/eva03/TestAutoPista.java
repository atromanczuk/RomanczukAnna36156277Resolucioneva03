package ar.edu.unlam.pb220202c.eva03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;



public class TestAutoPista {
	
	@Test
	public void queSePuedaRegistrarTelepase () {
		Autopista autopista = new Autopista ("Del Sol");
		Vehiculo vehiculo = new Automovil("xxx000", 50, 130);
		
		assertTrue(autopista.registrarTelepase(1, vehiculo));
	}

	@Test(expected = VehiculoNotFoundException.class)
	public void queAlSalirDelAutopistaNoestaEncirculacionLanceUnaExcepcion() throws VehiculoNotFoundException {
		Autopista autopista = new Autopista("Del Sol");
		Vehiculo vehiculo = new Automovil("xxx000", 50, 130);

		autopista.salirAutpista(vehiculo);

		assertEquals(0, autopista.cantidadDeVehiculosENCirculacion(), 0.01);
	}
	
	@Test
	public void queVerifiqueQueSeObtengaUnaListaDeAutosInsfractoresOrdenadaPorPatente() throws VehiculoNotFoundException{
		Autopista autopista = new Autopista("Del Sol");
		Vehiculo vehiculo01 = new Automovil("yyy000", 180, 130);
		Vehiculo vehiculo02 = new Automovil("zzzz000", 180, 130);
		Vehiculo vehiculo03 = new Automovil("aaa000", 180, 130);

		autopista.registrarTelepase(1, vehiculo01);
		autopista.registrarTelepase(2, vehiculo02);
		autopista.registrarTelepase(3, vehiculo03);

		try {
		autopista.ingresarAutopista(1);
		autopista.ingresarAutopista(2);
		autopista.ingresarAutopista(3);

		}
		catch(VehiculoNotFoundException e) {
			System.out.println(e.getMessage());
		}
		assertEquals(3,autopista.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente().size());
	}
	
	@Test
	public void queSeCreeUnaAutopista() {
		Autopista autopista = new Autopista ("Del Sol");
		assertNotNull(autopista);
	}

		
	@Test
	public void QueSeCreeUnAutomovil() {
		Vehiculo vehiculo = new Automovil("xxx000", 50, 130);
		assertNotNull(vehiculo);
	}
	
}
