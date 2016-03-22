import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class URLReader {
    public static void main(String[] args) throws Exception {
// ToDO: concatenar e iterar en un FOR los años de 14 a 80, búsquedas
        URL oracle = new URL("http://google.com/complete/search?output=toolbar&q=tengo%2015");
        BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));

        String inputLine;
        String frases="";
        
       
       
        int a=0;
        while ((inputLine = in.readLine()) != null){
        	
        	// con el arrayList recogeremos la posicion de todas las comillas, y acontinuacion haremos
        	// cogeremos los pares, que son los que nos dan las frases.
        	

      
       
        	char[] arrayChar = new char[inputLine.length()];
        	arrayChar= inputLine.toCharArray();
        	ArrayList<Integer> comillasPosicion = new ArrayList<Integer>();
        	 
        	 for (int i = 0; i < arrayChar.length; i++) {
				// recogemos las posicions de todos los " en un array llamado 'comillasPosicion'
        		 if (arrayChar[i] == '"'){
					comillasPosicion.add(a, i+1);// insert in "a" position, "i" value.
					a=a+1;
				}
			}
        	 for (int j = 1; j < comillasPosicion.size(); j++) { // nos quitamos el primer "1.0" de version
        		 if (j%2 ==0){ //me interesan los pares
     
        			 if (j<comillasPosicion.size()){ // nos quitamos la primera
        				 String frase="";
        				 for (int i = comillasPosicion.get(j); i < comillasPosicion.get(j+1)-1; i++) {
        				 //se suma la frase al conjunto de frases en el string

        				frase= frase + arrayChar[i];
						
        				 //+"el tengo 15 años" quitarlo aunque solo mantenerlo la primera vez
        			 }
        				 frases=frases+ frase;
        			 
            			 frases += " ";
					}
        			 
        		 }
        	 }	
			}
     
        	// endIndex-> retorna endIndex-1
        	//inputLine.substring(beginIndex, endIndex)
        	
            System.out.println(frases);
        in.close();
    
        }
    }
// mejoras: poner un RANGER para la seleccion de las edades.

// VER FORMA BUENA DE LEER EL XML.
// VER COMO CAMBIAR DE AÑO EN URL
// HACER PETICIONES POR CADA TIEMPO EN UN DELAY.