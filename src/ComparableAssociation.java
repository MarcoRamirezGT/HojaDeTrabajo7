/**
 * Hoja de Trabajo 7
 * Algoritmos y Estructuras de Datos
 * @author Marco Ramirez 19588
*/

	/*
		Referencia para implementacion de ComparableAssociation obtenida del libro de texto "Data Structures in Java for the principled Programmer" (Bailey, 2007),
	*/

import java.util.Map;

public class ComparableAssociation<K,V>
{
	/**
	 * 
	 */
	protected K key;
	protected V value;
	
	/**
	 * 
	 * @param key
	 */
    public ComparableAssociation(K key)
    {
        this.key = key;
		this.value = null;
    }
    /**
     * 
     * @param key
     * @param value
     */
    public ComparableAssociation(K key, V value)
    {
        this.key = key;
		this.value = value;
    }
    /**
     * 
     * @param that
     * @return
     */
    public boolean compareTo(ComparableAssociation<K,V> that)
    {
        return this.getKey().equals(that.getKey());
    }
    /**
     * 
     */
    public String toString()
    {
        return this.key.toString() + ", " + this.value.toString();
    }
	/**
	 * 
	 * @return
	 */
	public K getKey(){
		return this.key;
	}
}
