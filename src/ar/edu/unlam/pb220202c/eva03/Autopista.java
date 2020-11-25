package ar.edu.unlam.pb220202c.eva03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Autopista {

	private HashMap<Integer, Vehiculo> telepase;
	private HashSet<Vehiculo> vehiculosEnCirculacion;
	private String nombre;
	// Si es necesario Utilice herencia o implemente de Interfaces
	// Se debe crear contructeres getters y Setters y los atributos o metodos que
	// crean convenientes
	
	public Autopista(String nombre) {
		this.nombre = nombre;
		telepase = new HashMap<Integer, Vehiculo>();
		vehiculosEnCirculacion = new HashSet<>();
	}

	public Boolean registrarTelepase(Integer numeroTelpase, Vehiculo vehiculo) {
		if (vehiculo != null && numeroTelpase != null) {
			telepase.put(numeroTelpase, vehiculo);
			return true;
		} else {
			return false;
		}
	}

	// si el telepase no esta registrado lanza una Exceptios del tipo
	// VehiculoNotFounException
	// y no permite ingresar al autopista

	public Boolean ingresarAutopista(Integer numeroTelepase) throws VehiculoNotFoundException {
		if (telepase.containsKey(numeroTelepase)) {
			vehiculosEnCirculacion.add(telepase.get(numeroTelepase));
		} else {
			throw new VehiculoNotFoundException();
		}
		return null;
	}

	public void salirAutpista(Vehiculo vehiculo) throws VehiculoNotFoundException {
		// lanza Una exception VehiculoNotFounException si no esta en circulacion
		if (telepase.containsValue(vehiculo)==false) {
			throw new VehiculoNotFoundException();
		}
		vehiculosEnCirculacion.remove(vehiculo);
	}

	public HashSet<Vehiculo> vehiculosConExceso() {
		HashSet<Vehiculo> vehiculosConExcesoDeVelocidad = new HashSet<>();
		for (Vehiculo vehiculo : vehiculosEnCirculacion) {
			if (vehiculo instanceof Automovil) {
				if (((Automovil) vehiculo).enInfraccion())
					vehiculosConExcesoDeVelocidad.add(vehiculo);
			}
			if (vehiculo instanceof Camion) {
				if (((Camion) vehiculo).enInfraccion())
					vehiculosConExcesoDeVelocidad.add(vehiculo);
			}
		}
		return vehiculosConExcesoDeVelocidad;
	}

	public TreeSet<Vehiculo> obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente() {
		TreeSet<Vehiculo> VehiculosExcedidosOrdenados = new TreeSet<Vehiculo>();
		VehiculosExcedidosOrdenados.addAll(vehiculosConExceso());
		return VehiculosExcedidosOrdenados;
	}

	public Integer cantidadDeVehiculosENCirculacion() {
		return vehiculosEnCirculacion.size();
	}
}