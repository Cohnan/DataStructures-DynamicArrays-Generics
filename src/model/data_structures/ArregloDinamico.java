package model.data_structures;
//import java.io.*;


/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Ks.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico<K extends Comparable<K>> implements IArregloDinamico<K> {
		/**
		 * Capacidad maxima del arreglo
		 */
        private int tamanoMax;
		/**
		 * Numero de elementos en el arreglo (de forma compacta desde la posicion 0)
		 */
        private int tamanoAct;
        /**
         * Arreglo de elementos de tamaNo maximo
         */
        private K[] elementos;

        /**
         * Construir un arreglo con la capacidad maxima inicial.
         * @param max Capacidad maxima inicial
         */
		public ArregloDinamico( int max )
        {
               elementos = (K[]) new Object[max];
               tamanoMax = max;
               tamanoAct = 0;
        }
        
		public void agregar( K dato )
        {
               if ( tamanoAct == tamanoMax )
               {  // caso de arreglo lleno (aumentar tamaNo)
                    tamanoMax = 2 * tamanoMax;
                    K [ ] copia = elementos;
                    elementos = (K[]) new Object[tamanoMax];
                    for ( int i = 0; i < tamanoAct; i++)
                    {
                     	 elementos[i] = copia[i];
                    } 
            	    System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
               }	
               elementos[tamanoAct] = dato;
               tamanoAct++;
       }

		public int darTamano() {
			return tamanoAct;
		}

		public K darElemento(int i) {
			return elementos[i];
		}

		public K buscar(K dato) {
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Ks.
			
			//K message = "Esta en la posicion:";
			Boolean encontrado = false;
	
			for (int i = 0; i < tamanoAct; i++) {
				if (dato.compareTo(elementos[i]) == 0) {
					//message += " " + (i+1) + ",";
					encontrado = true;
				}
			}
			
			//message = message.substring(0, message.length() - 1) + "."; //Regresa un mensaje infomativo
			//message = dato;
			if (encontrado) return dato;
			return null;
		}

		public K eliminar(K dato) {
			
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Ks.
			K[] temp = (K[]) new Object[tamanoMax];
			
			boolean encontrado = false;
			int tempTamanoAct = 0;
			
			int j = 0; // Indice para el nuevo array
			for (int i = 0; i < tamanoAct; i++) {
				if (dato.compareTo(elementos[i]) != 0){
					encontrado = true;
					temp[j] = elementos[i];
					j++;
					tempTamanoAct++;
				}
			}
			
			if (!encontrado) return null;
			
			int nEliminados = tamanoAct - tempTamanoAct;
			tamanoAct = tempTamanoAct;
			while (tempTamanoAct <= tamanoMax/2) tamanoMax = tamanoMax/2;
			
			elementos = (K[]) new Object[tamanoMax];
			for (int i = 0; i < tamanoAct; i++) {
				elementos[i] = temp[i];
			}
			
			//return "se eliminaron " + nEliminados + " veces el dato " + dato; //Regresa un mensaje informativo
			return dato;
		}
}