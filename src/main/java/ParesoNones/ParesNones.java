/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package ParesoNones;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author eduar
 */
public class ParesNones {

    public static void main(String[] args) {
        String menu, ganador;
        int numero = 0, numRandom = 0;
        do {
            menu = menuParesNones();
            if (menu.equalsIgnoreCase("si")) {
                numero = elegirParesONones();
                numRandom = numeroRandom();
               ganador = elegirElGanador(numero, numRandom);
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

    public static int elegirParesONones() {

        int numero;
        numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número de dedos del 1 al 10 "));

        if (numero % 2 == 0) {
            JOptionPane.showMessageDialog(null,
                    "El número que has elegido es par " + numero);
        } else {
            JOptionPane.showMessageDialog(null,
                    "El número que has elegido es impar " + numero);
        }
        return numero;
    }

    public static int numeroRandom() {
        int numAleatorio;
        Random numRandom = new Random();

        numAleatorio = numRandom.nextInt(0, 11);

        if (numAleatorio % 2 == 0) {
            JOptionPane.showMessageDialog(null,
                    "El número que ha elegido el sistema es par " + numAleatorio);
        } else {
            JOptionPane.showMessageDialog(null,
                    "El número que ha elegido el sistema es impar " + numAleatorio);
        }
        return numAleatorio;
    }
    
    public static String elegirElGanador(int numero, int numRandom){
        String ganador = "";
        if(numero > numRandom){
            JOptionPane.showMessageDialog(null,
                    """
                    ---------------------------
                       ¡¡¡¡¡ENHORABUENA!!!!!
                    ---------------------------
                    Le has ganado al sistema <3
                           """);
        }else{
            JOptionPane.showMessageDialog(null,
                    """
                    ---------------------------
                           Has perdido, 
                    la proxima vez sera campeón
                    ---------------------------
                           """);
            
        }
        return ganador;
    }
}
