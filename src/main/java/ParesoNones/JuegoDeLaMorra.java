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
     //Juego de la morra
    public static void main(String[] args) {
        String menuJuego, menuExplicativo, datosUsuMaq;
        int numUsuario, numRandom, numUsuarioAdivinar, numMaqAdivinar;
        //creo un do while que se repite hasta que el usuario introduce salir o 3
        do {

            menuJuego = menuJuegoMorra();
        //por si no se sabe como se juega al juego he puesto una explicacion que se accede mediante 2 o como se juega
            if (menuJuego.equalsIgnoreCase("como se juega")
                    || menuJuego.equalsIgnoreCase("2")) {
                menuExplicativo = explicacionJuego();
            }
            if (menuJuego.equalsIgnoreCase("jugar")
                    || menuJuego.equalsIgnoreCase("1")) {
                numUsuario = numeroUsuario();
                numUsuarioAdivinar = adivinarNumeroRival();
                numRandom = numeroMaquinaAleatorio();
                numMaqAdivinar = numMaquinaAdivinar();
                datosUsuMaq = datosUsuario(numUsuario, numUsuarioAdivinar, numRandom, numMaqAdivinar);
            }

        } while (!(menuJuego.equalsIgnoreCase("salir")
                || menuJuego.equalsIgnoreCase("3")));
    }
    //Pongo el menu en un string
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
    //La explicación del juego 
    public static String explicacionJuego() {
        String explicacion = """
                                La morra es un juego de 2 personas, que consiste 
                                en sacar un número aleatorio del 1 al 5 e 
                                intentar adivinar el número que saca el rival.
                                """;
        JOptionPane.showMessageDialog(null, explicacion);
        return explicacion;
    }
    //Números a introdur el usuario y la maquina
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

        return numero;
    }
    //Números que escribe el usuario y la consola para intentar adivinar 
    public static int adivinarNumeroRival() {
        int numeroAdivinar = 0;

        do {
            try {

                numeroAdivinar = Integer.parseInt(JOptionPane.showInputDialog("Vale, ahora tienes que adivinar el número del rival"));
                do {
                    if (numeroAdivinar <= 1 || numeroAdivinar >= 5) {
                        numeroAdivinar = Integer.parseInt(JOptionPane.showInputDialog("Vale, ahora tienes que adivinar el número del rival"));
                    }
                    break;
                } while (true);
                break;
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null,
                        "No has introducido los datos correctos");
            }
        } while (true);

        return numeroAdivinar;
    }

    public static int numeroMaquinaAleatorio() {

        Random aleatorio = new Random();

        int numAleatorio;

        numAleatorio = aleatorio.nextInt(1, 6);

        JOptionPane.showMessageDialog(null,
                "El número elegido por la máquina es el " + numAleatorio);

        return numAleatorio;
    }

    public static int numMaquinaAdivinar() {
        Random aleatorio = new Random();

        int numMaquinaAdivinar;

        numMaquinaAdivinar = aleatorio.nextInt(1, 6);

        return numMaquinaAdivinar;
    }
    //imprimo los datos por JOptionPane
    public static String datosUsuario(int numUsuario, int numUsuarioAdivinar, int numRandom, int numMaqAdivinar) {
        String txt = "";

        JOptionPane.showMessageDialog(null,
                """
                    Has elegido el número %d y el número a adivinar que has 
                    elegido es el %d.
                       """.formatted(numUsuario, numUsuarioAdivinar));
        JOptionPane.showMessageDialog(null,
                """
                    La máquiana ha elegido el número %d y el número a adivinar 
                    que ha elegido es el %d.
                       """.formatted(numRandom, numMaqAdivinar));

        return txt;

    }
}
