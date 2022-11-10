/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package metodobiseccion;

/**
 *
 * @author Yael
 */
public class MetodoBiseccion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        metodo metodo = new metodo();
        
        metodo.setFuncion("x^2-5");
        double raiz = metodo.biseccion(2, 2.5, 0.001);
        System.out.println("La raiz es: " + raiz);
    }
    
}
