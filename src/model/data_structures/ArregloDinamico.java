package model.data_structures;
//import java.io.*;


/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico implements IArregloDinamico {
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
        private String elementos[ ];

        /**
         * Construir un arreglo con la capacidad maxima inicial.
         * @param max Capacidad maxima inicial
         */
		public ArregloDinamico( int max )
        {
               elementos = new String[max];
               tamanoMax = max;
               tamanoAct = 0;
        }
        
		public void agregar( String dato )
        {
               if ( tamanoAct == tamanoMax )
               {  // caso de arreglo lleno (aumentar tamaNo)
                    tamanoMax = 2 * tamanoMax;
                    String [ ] copia = elementos;
                    elementos = new String[tamanoMax];
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

		public String darElemento(int i) {
			if (i >= tamanoAct) return null;
			return elementos[i];
		}

		public String buscar(String dato) {
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
			
			//String message = "Esta en la posicion:";
			Boolean encontrado = false;
			
			// Los busca todos. Innecesario para lo pedido en la documentacion. Bastaria reemplazar
			// encontrado = true por return true. Util para mensaje informativo
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

		public String eliminar(String dato) {
			
			// Contendra los datos diferentes de dato compactados
			String[] temp = new String[tamanoMax];
			
			// Indica si se elimino algun dato del arreglo. Podria usar buscar(), pero es innecesario
			boolean encontrado = false;
			//Indicara el tamano del nuevo array
			int tempTamanoAct = 0;
			
			// Agrega datos de forma compacta a temp
			int j = 0; // Indice para el nuevo array
			for (int i = 0; i < tamanoAct; i++) {
				if (dato.compareTo(elementos[i]) != 0){
					temp[j] = elementos[i];
					j++;
					tempTamanoAct++;
				} else {
					encontrado = true;
				}
			}
			
			// Previene calculos innecesarios si no se eliminan datos
			if (!encontrado) return null;
			
			// Calculos para reducir el tamano total del array en caso de que se borren muchos datos.
			int nEliminados = tamanoAct - tempTamanoAct;
			
			// Caso especial: se borran todos los elementos
			if (nEliminados == tamanoAct) {
				elementos = new String[1];
				tamanoAct = 0;
				tamanoMax = 1;
				return dato;
			}
			
			// Revalua tamanoAct y el tamanoMax necesario para elementos
			tamanoAct = tempTamanoAct;
			while (tempTamanoAct <= tamanoMax/2) tamanoMax = tamanoMax/2;
			
			// Crea elementos de manera compacta con elementos restantes y tamano apropiado
			elementos = new String[tamanoMax];
			for (int i = 0; i < tamanoAct; i++) {
				elementos[i] = temp[i];
			}
			
			//return "se eliminaron " + nEliminados + " veces el dato " + dato; //Regresa un mensaje informativo
			return dato;
		}
}