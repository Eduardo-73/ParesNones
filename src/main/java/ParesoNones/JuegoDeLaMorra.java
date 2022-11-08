/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParesoNones;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author eduar
 */
public class JuegoDeLaMorra {

    public static void main(String[] args) {
        String menuJuego, menuExplicativo;
        int numUsuario, numRandom;

        do {

            menuJuego = menuJuegoMorra();

            if (menuJuego.equalsIgnoreCase("como se juega")
                    || menuJuego.equalsIgnoreCase("2")) {
                menuExplicativo = explicacionJuego();
            }
            if (menuJuego.equalsIgnoreCase("jugar")
                    || menuJuego.equalsIgnoreCase("1")) {
                numUsuario = numeroUsuario();
                numRandom = numeroMaquinaAleatorio();
            }

        } while (!(menuJuego.equalsIgnoreCase("salir")
                || menuJuego.equalsIgnoreCase("3")));
    }

    public static String menuJuegoMorra() {
        String menu = JOptionPane.showInputDialog("""
                       ---------------------------
                            JUEGO DE LA MORRA
                       ---------------------------
                        1.JUGAR
                        2.¿CÓMO SE JUEGA?
                        3.SALIR
                       ---------------------------
                       """).toLowerCase();

        return menu;
    }

    public static String explicacionJuego() {
        String explicacion = """
                                La morra es un juego de 2 personas, que consiste 
                                en sacar un número aleatorio del 1 al 5 e 
                                intentar adivinar el número que saca el rival.
                                """;
        JOptionPane.showMessageDialog(null, explicacion);
        return explicacion;
    }

    public static int numeroUsuario() {
        int numero = 0;

        do {
            try {

                numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número del 1 al 5"));
                do {
                    if (numero <= 1 || numero >= 5) {
                        numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número del 1 al 5"));
                    }
                    break;
                } while (true);
                break;
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null,
                        "No has introducido los datos correctos");
            }
        } while (true);

        JOptionPane.showMessageDialog(null, "El número elegido es el " + numero);

        return numero;
    }

    public static int numeroMaquinaAleatorio() {

        Random aleatorio = new Random();

        int numAleatorio;

        numAleatorio = aleatorio.nextInt(1, 6);

        JOptionPane.showMessageDialog(null,
                "El número elegido por la máquina es el " + numAleatorio);

        return numAleatorio;
    }
}
