/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.util.Scanner;

/**
 *
 * @author esther
 */
public class Practica2 {

    public static Scanner sc = new Scanner(System.in);

    public static String introducirNumero() {
        String numero1 = "";
        do {
            System.out.println("\nIntrodueix un numero. ");
            numero1 = sc.nextLine();
        } while (!numero1.matches("[+-]?[\\d]*[.]?[\\d]+"));

        return numero1;
    }

    public static String IndicarSimbolo(String operacion, boolean comprobar) {
        do {
            System.out.println("\nOperació? (Indica el signe)");
            System.out.println("+ = sumar \n" + "- = restar \n"
                    + "x = multiplicar \n" + "/ = dividir \n"
                    + "* = elevar primer num al segon num. \n"
                    + "% = residu");
            operacion = sc.nextLine();
            if (operacion.equals("+") || operacion.equals("-") || operacion.equals("x")
                    || operacion.equals("X") || operacion.equals("/") || operacion.equals("%")
                    || operacion.equals("*")) {
                comprobar = true;
            } else {
                comprobar = false;
            }
        } while (comprobar != true);
        
        return operacion; 
    }

    public static void Operacion(boolean comprobar, String operacion) {
        double res = 0;
        String simbolo;

        String numero1;
        numero1 = introducirNumero();

        double nume1 = Double.parseDouble(numero1);
        double n1 = new Double(numero1);

        simbolo = IndicarSimbolo(operacion, comprobar);

        String numero2;
        numero2 = introducirNumero();

        double nume2 = Double.parseDouble(numero2);
        double n2 = new Double(numero2);

        do {
            comprobar = true;
            switch (simbolo) {
                case "+":
                    res = n1 + n2;
                    break;
                case "-":
                    res = n1 - n2;
                    break;
                case "x":
                case "X":
                    res = n1 * n2;
                    break;
                case "/":
                    while (n2 == 0) {
                        do {
                            System.err.println("Al denominador hi ha un zero \n"
                                    + "per a evitar errors coloca un altre valor.");
                            numero2 = sc.nextLine();
                        } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
                        nume2 = Double.parseDouble(numero2);
                        n2 = new Double(numero2);
                    }
                    res = n1 / n2;
                    break;
                case "*":
                    res = Math.pow(n1, n2);
                    break;
                case "%":
                    while (n2 == 0) {
                        do {
                            System.err.println("Al denominador hi ha un zero \n"
                                    + "per a evitar errors coloca un altre valor.");
                            numero2 = sc.nextLine();
                        } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
                        nume2 = Double.parseDouble(numero2);
                        n2 = new Double(numero2);
                    }
                    res = n1 % n2;
                    break;
            }
        } while (comprobar != true);

        System.out.println("Resultat: "+ numero1 + " " + simbolo + " " + numero2 + " = " + res);
    }

    public static String Continuar(boolean comprobar, String operacion) {
        System.out.println("\nVols continuar operant?[s/n]");
        do {
            comprobar = true;
            operacion = sc.nextLine();

            switch (operacion) {
                case "s":
                case "S":
                case "n":
                case "N":
                    break;
                default:
                    System.err.println("\nError, posa un valor vàlid. \n");
                    comprobar = false;
            }
        } while (comprobar != true);

        return operacion;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String operacion = "";
        boolean comprobar = false;
        String continuar;

        do {
            Operacion(comprobar, operacion);

            continuar = Continuar(comprobar, operacion);
        } while (continuar.equals("s") || continuar.equals("S"));
    }
}
