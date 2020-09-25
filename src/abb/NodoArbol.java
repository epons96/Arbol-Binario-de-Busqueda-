/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package abb;

/**
 *
 * @author Eduardo
 */
public class NodoArbol {
    protected NodoArbol NodoIzq;
    protected int dato;
    protected NodoArbol NodoDer;

    //constructor
    public NodoArbol(int dato) {
        this.dato = dato;
        NodoIzq = NodoDer = null;
    }//fin constructor
    
    //metodo para ubicar e insertar el valor
    public void Insertar(int valor){
        if(valor<dato){
            if(NodoIzq==null)
                NodoIzq = new NodoArbol(valor);//inserta nuevo NodoArbol
            else
                NodoIzq.Insertar(valor);//continua recorriendo el subarbol izquierdo
        }else if(valor>dato){
            if(NodoDer==null)
                NodoDer = new NodoArbol(valor);//inserta nuevo NodoArbol
            else
                NodoDer.Insertar(valor);//continua recorriendo el subarbol derecho
        }
    }//fin metodo Insertar
    
    //metodo de busqueda binaria
    public boolean Buscar(NodoArbol nodo){
        if(this==null)
            return false;
        if(this.dato==nodo.dato)
            return true;
        if(this.dato<nodo.dato)
            return this.NodoDer.Buscar(nodo);
        return this.NodoIzq.Buscar(nodo);
    }//fin metodo Buscar
    
    /*public void Eliminar(NodoArbol nodo) throws Exception{
        if(this==null)
            throw new Exception("El elemento a eliminar no existe");
        if(this.dato==nodo.dato)
            
    }*/
    
    //metodo Antecesor
    public NodoArbol Antecesor(NodoArbol nodo) throws Exception{
        if(this==null)//algoritmo para ubicar el nodo
            throw new Exception("Imposible localizar el nodo");
        if(this.dato<nodo.dato)//algoritmo para ubicar el nodo
            return this.NodoDer.Antecesor(nodo);
        if(this.dato>nodo.dato)//algoritmo para ubicar el nodo
            return this.NodoIzq.Antecesor(nodo);
        //pasa de esta linea si encuentra el nodo
        if(this.NodoIzq!=null){//el nodo tiene nodos menores?
            //si existen nodos mayores que NodoIzq y menores que el nodo invocar ayudanteAntecesor
            if(this.NodoIzq.NodoDer!=null)
                return ayudanteAntecesor(nodo, this.NodoIzq.NodoDer);
            //si no devolver NodoIzq
            return this.NodoIzq;
        }
        //pasa de esta linea si no encuentra un antecesor
        throw new Exception("Imposible localizar el antecesor del nodo");
    }//fin metodo
    
    //metodo ayudanteAntecesor
    private NodoArbol ayudanteAntecesor(NodoArbol nodo, NodoArbol actual){
        //se mueve lo mas posible a la derecha
        if(actual.NodoDer==null)
            return actual;
        return ayudanteAntecesor(nodo, actual.NodoDer);
    }//fin metodo
    
    //metodo Sucesor
    public NodoArbol Sucesor(NodoArbol nodo) throws Exception{
        if(this==null)//algoritmo para ubicar el nodo
            throw new Exception("Imposible localizar el nodo");
        if(this.dato<nodo.dato)//algoritmo para ubicar el nodo
            return this.NodoDer.Sucesor(nodo);
        if(this.dato>nodo.dato)//algoritmo para ubicar el nodo
            return this.NodoIzq.Sucesor(nodo);
        //pasa de esta linea si encuentra el nodo
        if(this.NodoDer!=null){//el nodo tiene nodos mayores?
            //si existen nodos menores que NodoDer y mayores que el nodo invocar ayudanteSucesor
            if(this.NodoDer.NodoIzq!=null)
                return ayudanteSucesor(nodo, this.NodoIzq.NodoDer);
            //si no devolver NodoIzq
            return this.NodoDer;
        }
        //pasa de esta linea si no encuentra un sucesor
        throw new Exception("Imposible localizar el sucesor del nodo");
    }//fin metodo
    
    //metodo ayudanteAntecesor
    private NodoArbol ayudanteSucesor(NodoArbol nodo, NodoArbol actual){
        //se mueve lo mas posible a la izquierda
        if(actual.NodoIzq==null)
            return actual;
        return ayudanteSucesor(nodo, actual.NodoDer);
    }//fin metodo
    
}
