/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodobiseccion;

import org.nfunk.jep.JEP;

/**
 *
 * @author Yael
 */
public class Funcion {
    
    
    private String expresion = "";
    
    public Funcion (String expresion){
        this.expresion = expresion;
        
    }
    
    public double evaluar(double x){
        JEP j = new JEP();
        j.addStandardFunctions();
        j.addStandardConstants();
        j.addVariable("x", x);
        j.parseExpression(expresion);
        
        if (!j.hasError()) {
                return j.getValue();
            } else {
                return Double.NaN;
            }
        
    }
}
