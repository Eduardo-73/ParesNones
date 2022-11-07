/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package ParesoNones;

import java.util.InputMismatchException;
import java.util.Random;

import javax.swing.JOptionPane;

/**
 *
 * @author eduar
 */
public class ParesNones {

    public static void main(String[] args) {
        String menu, saberParesNones, elegir;
        int numero = 0, numRandom = 0, suma = 0;
        //número es el jugador y numRandom la máquina;
        do {
            menu = menuParesNones();
            if (menu.equalsIgnoreCase("si")) {
                elegir = elegirParesNones();
                numero = elegirNumeroDedos();
                numRandom = numeroRandom();
                suma = sumaParesNones(numero, numRandom);
                saberParesNones = conocerParesNones(suma);
            }
        } while (!menu.equalsIgnoreCase("no"));
    }

    public static String menuParesNones() {

        String txt = """
                     ------------------------
                          Pares o Nones
                     ------------------------
                     ¿Quieres jugar al juego?
                     ------------------------
                     """;
        JOptionPane.showMessageDialog(null, txt);
        return JOptionPane.showInputDialog("¿Si o No?");
    }

    public static String elegirParesNones() {
        String paresNones = "";
        do {
            try {
                paresNones = JOptionPane.showInputDialog("Elige pares o nones ");
            } catch (InputMismatchException ime) {
                JOptionPane.showMessageDialog(null, "No has elegido pares o nones");
            }
        } while (!(paresNones.equalsIgnoreCase("pares") || paresNones.equalsIgnoreCase("nones")));
        return paresNones;
    }

    public static int elegirNumeroDedos() {

        int numero;

        numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número de dedos del 1 al 10 "));
        do {
            try {
             if(numero <= 1 || numero >= 10){ 
                numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número de dedos del 1 al 10 "));
            }
             }catch(NumberFormatException nfe){
             JOptionPane.showMessageDialog(null, "Escribe un número ");
            }
            break;
        } while (true);
        JOptionPane.showMessageDialog(null, "El número de dedos que has elegido es el " + numero);

        return numero;
    }

    public static int numeroRandom() {
        int numAleatorio;

        Random numRandom = new Random();

        numAleatorio = numRandom.nextInt(0, 11);

        JOptionPane.showMessageDialog(null, "El número de dedos que ha elegido el sistema es el " + numAleatorio);

        return numAleatorio;
    }

    public static int sumaParesNones(int numero, int numRandom) {
        int suma = numero + numRandom;

        return suma;
    }

    public static String conocerParesNones(int suma) {
        String conocerParesNones = "";
        if (suma % 2 == 0) {
            JOptionPane.showMessageDialog(null,
                    """
                    ----------------------------
                        El resultado es PAR
                    ----------------------------
                                %d
                           """.formatted(suma));
        } else {
            JOptionPane.showMessageDialog(null,
                    """
                   ------------------------------
                       El resultado es IMPAR
                   ------------------------------
                                %d
                           """.formatted(suma));

        }
        return conocerParesNones;
    }
    
}
