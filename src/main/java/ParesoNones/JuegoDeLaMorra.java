/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParesoNones;

import javax.swing.JOptionPane;

/**
 *
 * @author eduar
 */
public class JuegoDeLaMorra {
    public static void main(String[] args) {
        int menuJuego;
        
        menuJuego = menuJuegoMorra();
    }
    
    public static int menuJuegoMorra(){
         int menu =JOptionPane.showOptionDialog(null,"JUEGO DE LA MORRA ","Selector",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null, 
                new Object[]{"JUGAR","¿CÓMO SE JUEGA?","SALIR "});
     
         return menu;
    }
    
    public static String explicacionJuego(){
        
    }
}
