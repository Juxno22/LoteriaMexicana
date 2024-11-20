import java.util.Iterator;

public interface SetADT<T> {
    //ADD - añadimos un elemento, ignorando duplicados.
    public void add(T elemento);
    //ADDALL - añade los elementos de un conjunto a otro
    public void addAll(SetADT<T> set);
    //removeRandom - elimina y devuelve un elemento aleatorio del conjunto
    public T removeRandom();
    //remove -  elimina y devuelve un elemento especificado
    public T remove(T elemento);
    //union -  deviuelve la union de un conjunto y de parametros
    public SetADT<T> union(SetADT<T> set);
    //contains -  devuelve true si el conjunto contiene un parametro
    public boolean contains(T target);
    //equals - devuelve true si el conjunto y el parametro contienen axactamente los mismo valores
    public boolean equals(SetADT<T> set);
    //isEmpty - devuelve true si el conjunto con contiene ningun elemento
    public boolean isEmpty();
    //size -  devuelve el numero de elementos de un conjunto
    public int size();
    //iterator - proporciona un medio de iterar a traves de la coleccion
    public Iterator<T> iterator();
    //toString - devuelve la representación del conjunto de caracteres
    public String toString();
}