package controller;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;

public class Controller {

	/* Instancia del Modelo del mundo */
	private static IArregloDinamico<String> modelo = new ArregloDinamico<String>(7);
	
	/**
	 * Requerimiento crear Arreglo Dinamico
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public static void crearModelo(int capacidad)
	{
		modelo = new ArregloDinamico(capacidad);
	}
	
	/**
	 * Requerimiento agregar elemento
	 * @param dato Dato a agregar al final del arreglo
	 */
	public static void agregar(String dato)
	{
		modelo.agregar(dato);
	}
	
	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public static String buscar(String dato)
	{
		return modelo.buscar(dato);
	}
	
	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public static String eliminar(String dato)
	{
		return modelo.eliminar(dato);
	}
	
	
	/**
	 * Servicio de consulta de numero de elementos presentes en el arreglo 
	 * @return numero de elementos presentes en el arreglo
	 */
	public static int darTamano()
	{
		return modelo.darTamano();
	}
	
}
