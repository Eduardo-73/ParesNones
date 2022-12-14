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
        int numUsuario, numRandom, numUsuarioAdivinar, numMaqAdivinar, sumaNumero, elegirGanador;
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
                for (int ronda = 0; ronda < 5; ronda++) {
                numUsuario = numeroUsuario();
                numUsuarioAdivinar = adivinarNumeroRival();
                numRandom = numeroMaquinaAleatorio();
                numMaqAdivinar = numMaquinaAdivinar();
                datosUsuMaq = datosUsuario(numUsuario, numUsuarioAdivinar, numRandom, numMaqAdivinar);
                sumaNumero = sumaDedos(numUsuario, numRandom);
                elegirGanador = elegirGanador(sumaNumero, numUsuarioAdivinar, numMaqAdivinar);
                }
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
                        2.??C??MO SE JUEGA?
                        3.SALIR
                       ---------------------------
                       """).toLowerCase();

        return menu;
    }

    //La explicaci??n del juego 
    public static String explicacionJuego() {
        String explicacion = """
                                La morra es un juego de 2 personas, que consiste 
                                en sacar un n??mero aleatorio del 1 al 5 e 
                                intentar adivinar el n??mero que saca el rival.
                                """;
        JOptionPane.showMessageDialog(null, explicacion);
        return explicacion;
    }

    //N??meros a introdur el usuario y la maquina
    public static int numeroUsuario() {
        int numero = 0;

        do {
            try {

                numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un n??mero del 1 al 5"));
                do {
                    if (numero <= 1 || numero >= 5) {
                        numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un n??mero del 1 al 5"));
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

    //N??meros que escribe el usuario y la consola para intentar adivinar 
    public static int adivinarNumeroRival() {
        int numeroAdivinar = 0;

        do {
            try {

                numeroAdivinar = Integer.parseInt(JOptionPane.showInputDialog("Vale, ahora tienes que adivinar el total "));
                do {
                    if (numeroAdivinar <= 1 || numeroAdivinar >= 10) {
                        numeroAdivinar = Integer.parseInt(JOptionPane.showInputDialog("Vale, ahora tienes que adivinar el total "));
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

        numAleatorio = aleatorio.nextInt(0, 6);

        return numAleatorio;
    }

    public static int numMaquinaAdivinar() {
        Random aleatorio = new Random();

        int numMaquinaAdivinar;

        numMaquinaAdivinar = aleatorio.nextInt(1, 10);

        return numMaquinaAdivinar;
    }

    //imprimo los datos por JOptionPane
    public static int sumaDedos(int numUsuario, int numRandom) {
        int sumaNum = numUsuario + numRandom;
        JOptionPane.showMessageDialog(null, sumaNum);
        return sumaNum;
    }

    public static String datosUsuario(int numUsuario, int numUsuarioAdivinar, int numRandom, int numMaqAdivinar) {
        String txt = "";

        JOptionPane.showMessageDialog(null,
                """
                    Has elegido el n??mero %d y el n??mero a adivinar que has 
                    elegido es el %d.
                       """.formatted(numUsuario, numUsuarioAdivinar));
        JOptionPane.showMessageDialog(null,
                """
                    La m??quiana ha elegido el n??mero %d y el n??mero a adivinar 
                    que ha elegido es el %d.
                       """.formatted(numRandom, numMaqAdivinar));

        return txt;

    }

    public static int elegirGanador(int sumaNumero, int numUsuarioAdivinar, int numMaqAdivinar) {
        int ganador = 0;
        
        if (sumaNumero == numUsuarioAdivinar) {
            int ganadorUsuario = 0;
            ganadorUsuario++;
            JOptionPane.showMessageDialog(null, "Has ganado " + "+" + ganadorUsuario);
            
        } else if (sumaNumero == numMaqAdivinar) {
            int ganadorMaquina = 0;
            ganadorMaquina++;
            JOptionPane.showMessageDialog(null, "Ha ganado la m??quina "  + "+" + ganadorMaquina);
        } else {
            JOptionPane.showMessageDialog(null, "Empate ");
        }
        
        return ganador;
    }
    
}
