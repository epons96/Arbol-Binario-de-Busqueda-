/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package abb;

import java.util.List;

/**
 *
 * @author Eduardo
 */
public class ABB {//Arbol de Busqueda Binaria
    protected NodoArbol root;
    protected List preorden;
    protected List postorden;
    protected List eorden;
    
    //constructor vacio
    public ABB() {
        root = null;
    }//fin constructor
    
    //metodo para insertar un nuevo NodoArbol en el ABB
    public void insertarNodo(int valor){
        if(root==null)
            root = new NodoArbol(valor);//incializa el ABB
        else
            root.Insertar(valor);//llama al metodo Insertar()
    }//fin del metodo Insertar()
    
    //recorrido recursivo en Preorden
    public List Preorden(){
        preorden.clear();
        ayudantePreorden(root);
        return preorden;
    }//fin recorrido Preorden
    
    //metodo axuliar para Preorden
    private void ayudantePreorden(NodoArbol nodo){
        if(nodo==null)
            return;
        preorden.add(nodo.dato);
        ayudantePreorden(nodo.NodoIzq);
        ayudantePreorden(nodo.NodoDer);
    }//fin metodo
    
    //recorrido recursivo en Entreorden
    public List Entreorden(){
        eorden.clear();
        ayudanteEntreorden(root);
        return eorden;
    }//fin recorrido Entreorden
    
    //metodo axuliar para Entreorden
    private void ayudanteEntreorden(NodoArbol nodo){
        if(nodo==null)
            return;
        ayudanteEntreorden(nodo.NodoIzq);
        eorden.add(nodo.dato);
        ayudanteEntreorden(nodo.NodoDer);
    }//fin metodo
    
    //recorrido recursivo en Postorden
    public List Postorden(){
        postorden.clear();
        ayudantePostorden(root);
        return postorden;
    }//fin recorrido Postorden
    
    //metodo axuliar para Entreorden
    private void ayudantePostorden(NodoArbol nodo){
        if(nodo==null)
            return;
        ayudantePostorden(nodo.NodoIzq);
        ayudantePostorden(nodo.NodoDer);
        postorden.add(nodo.dato);
    }//fin metodo
    
    //metodo InsertarNodo
    public void InsertarNodo(NodoArbol nodo){
        root.Insertar(nodo.dato);
    }//fin metodo Insertar
    
    //metodo BuscarNodo
    public boolean BuscarNodo(NodoArbol nodo){
        return root.Buscar(nodo);
    }//fin metodo BuscarNodo
    
    
    
}//fin clase ABB
