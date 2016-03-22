
import java.net.*;
import java.util.ArrayList;
import java.io.*;


public class URLReader_iterative{
	

	public static void main(String[] args) throws Exception {
		
		String[] busquedaStr = new String[10]; // numero de busuedas encadenadas
		//ArrayList<String> busquedaStr = new ArrayList<String>();
		busquedaStr[0]="soy%20un"; // quiero/ amo , prueba, este INPUT es por teclado
		
		String sumaInputLine = "";
		String frases=""; //cada resultado de búsqueda aislado
		
		   for (int i = 0; i < 9; i++) { // numero de busquedas encadenadas 
				
			   	int a=0;// contador de posicion de comillasPosicion, cada vez las comillas cambian de cada búsqueda
			   	int b=0;
			   	int longestInit=0; //posicion de caracter de inicio de la busqueda mas larga, de cada busqueda
			   	int longestFinal=0; //posicion de caracter de inicio de la busqueda mas larga, de cada busqueda
			   	String sumaStr=""; // suma del string
		        URL googleQuery = new URL("http://google.com/complete/search?output=toolbar&q=" + busquedaStr[i] +"%20"); // repasar modificacion del espacio "_" da más busquedas3
		        BufferedReader in = new BufferedReader(new InputStreamReader(googleQuery.openStream()));

		        String inputLine; //search actual

		        while ((inputLine = in.readLine()) != null){
		        	
		        char[] arrayCharBusquedas = new char[inputLine.length()]; // todo el XML en un array de caracteres
		       
	        	arrayCharBusquedas= inputLine.toCharArray();
	        	ArrayList<Integer> comillasPosicion = new ArrayList<Integer>();
	        	ArrayList<Integer> espaciosPosicion= new ArrayList<Integer>();
	        	
	        	
		        
	        	
	        	for (int z = 0; z < arrayCharBusquedas.length; z++) {
					// recogemos las posicions de todos los " en un array llamado 'comillasPosicion'
	        		 if (arrayCharBusquedas[z] == '"'){
						comillasPosicion.add(a, z+1);// insert in "a" position, "z" value. (+1 porque z mismo es la comilla)
						a=a+1;
					}
				}	
	        	
	        	// TODO: MIRAR PORQUE AL PONER -8 APARECE UNA MAS LARGA!!!
	        	 for (int j = 2; j < comillasPosicion.size()-2; j++) { // nos quitamos el primer "1.0" de version HACER SIZE -3 O -2
	        		 if (j%2 ==0){ //me interesan los pares
	        			  
	        			 // Seleccionamos el resultado con más caracteres, los comparamos	
	        				 
	        			if (Math.abs(longestInit-longestFinal)< Math.abs(comillasPosicion.get(j)-comillasPosicion.get(j+1))){
	        				longestInit=comillasPosicion.get(j);
	        				longestFinal=comillasPosicion.get(j+1)-1;
	        					}
							}
	        			 }
	        	 char[] arrayCharBusquedaSeleccionada = new char[longestFinal-longestInit];
	        	 for (int k = longestInit; k < longestFinal; k++) {
	        		 if (arrayCharBusquedas[k] ==' '){
	        			 espaciosPosicion.add(b, k -longestInit +1);// insert in "a" position, "z" value. (+1 porque z mismo es el mismo espacio)
	        			 // k-longestInit, valores relativos para la busqueda del indice en el sumaStr.
							b=b+1;
	        		 }
	        		sumaStr = sumaStr + arrayCharBusquedas[k];
	        		
	        		 
    			 }
	        	 System.out.print(" " + sumaStr);
	        	 sumaStr=sumaStr.substring(espaciosPosicion.get(espaciosPosicion.size()-2)); // COGEMOS LAS 2 ULTIMAS PALABRAS(index del penultimo espacio en SumaStr=el valor del el penultimo index de b)
	        	 sumaStr=sumaStr.replaceAll(" ", "%20");// para la busqueda no existen espacios, son reemplazados por %20
	        	busquedaStr[i+1]= sumaStr; //guardamos LAS DOS PALABRAS de la frase larga dentro de la siguiente búsqueda
	        	 
	        		 
	        	 }	
		       
		        //System.out.println(inputLine);
		        
		   
		        in.close();
		      
		        }
		 //  System.out.println(sumaInputLine);
		   
	        
	}
}

		//TO-DO:
		//Cerrar el bucle, implementar: 1. Elegir la opt mas larga y coger sus dos ultimas palabras -> y acumular
		//2. Buscar con esas dos ultima palabras dentro.
		//3. loopear hasta N iteraciones


	


