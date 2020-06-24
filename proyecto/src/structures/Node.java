/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

/**
 *
 * @author 84803
 */


public class Node<T>{
    
    private T dato;
    private Node<T> siguiente;
 
    /**
     * Constructor por defecto
     */
    public Node(){
        siguiente=null;
     }
 
    /**
     * Le pasamos un dato al nodo
     * @param p 
     */
    public Node(T p){
        siguiente=null;
        dato = p;
    }
 
    /**
     * Le pasamos un dato y su siguiente nodo al nodo
     * @param t Dato a insertar
     * @param siguiente Su sisguiente nodo
     */
    public Node(T t, Node<T> siguiente){
        this.siguiente=siguiente;
        dato = t;
    }
     
    public T getDato() {
        return dato;
    }
 
    public void setDato(T dato) {
        this.dato = dato;
    }
 
    public Node<T> getSiguiente() {
        return siguiente;
    }
 
    public void setSiguiente(Node<T> siguiente) {
        this.siguiente = siguiente;
    }
     
}
    

