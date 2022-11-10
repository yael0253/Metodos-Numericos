/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package newton;

import java.util.Scanner;

/**
 *
 * @author Yael
 */
public class Newton {

   public static double funcion(double x) {
        return  Math.cos(x) - x * x * x;
    }

    public static double derivada(double x) {
        return -Math.sin(x) - 3.0 * x * x;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Metodo de Newton-Raphson, Cáculo de la función: cos(x) - x^3");
        System.out.print("Ingrese el valor inicial de x0: ");
        double err, x_1, x = in.nextDouble();
        int i=0;
        System.out.println();
        do {
            x_1 = x;
            x = x - funcion(x) / derivada(x);
            err = Math.abs((x - x_1)/x);
            System.out.println("x" + i + " = " + x_1 + "\t\terror = " + err);
            i++;
        } while (x!=x_1 && i<100);
        if (i==100)
            System.out.println("\nLa soluci\242n no es convergente.\n");
        else
            System.out.println("\nLa soluci\242n es " + x + "\n");
    }

}