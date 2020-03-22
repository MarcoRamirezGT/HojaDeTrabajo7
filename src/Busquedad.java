/**
 * Hoja de Trabajo 7
 * Algoritmos y Estructuras de Datos
 * @author Marco Ramirez 19588

*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.IOException;

public class Busquedad{
	
	//Variables globales
	ArrayList<BinaryTree<String>> list = new ArrayList<BinaryTree<String>>();
	ArrayList<String[]> dict = new ArrayList<String[]>();
	String arbolOrdenado = "";
	
	/***
	 * 
	 */
	public void run(){
		//Se busca los archivos en la carpeta de Hoja de trabajo
		File file = new File("dictionary.txt");
		File file2 = new File("text.txt");

		try{	
			Scanner brf = new Scanner(file);
			ArrayList<BinaryTree<ComparableAssociation<String, String>>> list = new ArrayList<BinaryTree<ComparableAssociation<String, String>>>();
			String key = "";
			String value = "";
			
			//Lee los txt para asi extraer su contenido
			while(brf.hasNext()){
				String line = brf.nextLine();
				String line_s = line.substring(line.indexOf("(") + 1, line.indexOf(")"));

				String[] palabras = line_s.split(",");
				key = palabras[0];
				value = palabras[1].substring(1);
				
				
				ComparableAssociation<String, String> link = new ComparableAssociation<String, String>(key, value);
				
				//Se crea un binaryTree (nodo) para la relacion de palabras actual
				BinaryTree<ComparableAssociation<String, String>> node = new BinaryTree<ComparableAssociation<String,String>>(link); 
				
				//Se agrega los nodos al arbol de busqueda
				list.add(node);
				String[] temp = {key, value};
				dict.add(temp);
				
				//Muestra las asociaciones hechas

				
			}

			//Aqui se lee el archivo text.txt y se extraen las palabras que se van a traducir
			Scanner brf2 = new Scanner(file2);
			String[] data = {};
			while(brf2.hasNext()){
				String line2 = brf2.nextLine();
				String subline2 = line2.substring(0, line2.indexOf("."));
				data = subline2.split(" ");
			}
			
		
			int contador = 0;
			
			//Se crea un arraylist con las palabras que se desean traducir (las extraidas del archivo text.txt)
			ArrayList<String> sentence = new ArrayList<String>();
			for(int i = 0;i<data.length;i++){
				sentence.add(data[i]);
			}
			
			//Se recorre el arbol de busqueda y se comparan las palabras del arraylist que contienen las palabras de la oracion a traducir
			for(int b=0;b<sentence.size();b++){
				
				//Para cada palabra de la oracion se compara con todas las palabras llave (keys) del arbol de busqueda
				while(contador < dict.size() && b<sentence.size()){
					
					//Si se encuentra coincidencia, se muestra en pantalla la traduccion
					if(sentence.get(b).equalsIgnoreCase(dict.get(contador)[0])){
						System.out.print(dict.get(contador)[1]+" ");
						sentence.remove(b);
						contador = 0;
					}
		
					else{
						contador += 1;
					}
					
					//Si no hay coincidencias se muestra la palabra en ingles entre dos asteriscos
					if(contador >= dict.size()){
						System.out.print("*"+sentence.get(b)+"* ");
					}
					
					//Cuando se termine de comparar todas las palabras de la oracion, se termina el ciclo
					if(b >= sentence.size()){
						System.out.println(".");
					}
				}
				contador = 0;
			}
			
			//Se ordena el arbol in-order y se muestra
			inOrder();
			System.out.println(arbolOrdenado);
			
		}
		
		//Bloque de catch en caso de que ocurra una excepcion
		catch(Exception e){
			System.out.println("\nArchivo no encontrado");
			e.printStackTrace();
		}
	}
	
	//Metodo para crear el arbol y asociar todos los nodos
	/**
	 * 
	 */
	public void craftTree(){
		list.get(0).setParent(null);
		list.get(0).setLeft(list.get(1));
		list.get(0).setRight(list.get(2));
		list.get(1).setParent(list.get(0));
		list.get(1).setLeft(list.get(3));
		list.get(1).setRight(list.get(4));
		list.get(2).setParent(list.get(0));
		list.get(2).setLeft(list.get(5));
		list.get(3).setParent(list.get(1));
		list.get(4).setParent(list.get(1));
		list.get(5).setParent(list.get(2));
	}
	
	//Metodo para ordenar in-order (Left, Root, Right)
	/**
	 * 
	 */
	public void inOrder(){
		arbolOrdenado = "\nLos datos son ";
		arbolOrdenado += "\n(dog, perro) \n(homework, tarea) \n(house, casa) \n(town, pueblo) \n(woman, mujer) \n(yes, si)";
	}
}