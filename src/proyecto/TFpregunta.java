/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;
import java.util.Scanner;



/**
 *
 * @author pedro
 */
public class TFpregunta extends Pregunta{
    boolean respuesta;
    
    TFpregunta(String pregunta, boolean respuesta, int peso){
        super(peso, pregunta);
        this.respuesta = respuesta;   
    }
    
    @Override
   public boolean buscar(){
        Scanner teclado= new Scanner(System.in);
        String respuestaUsuario;
        char caracterRespuesta;
        System.out.println(super.text);
        do{
            System.out.println("Ingrese su respuesta: f | F | t | T :\n");
            respuestaUsuario= teclado.next();
            caracterRespuesta= respuestaUsuario.charAt(0);
        }while(caracterRespuesta != 'f' && caracterRespuesta != 'F' && 
                 caracterRespuesta != 't' && caracterRespuesta != 'T');
        teclado.close();
        //comparar respuestas
        boolean esFalso= caracterRespuesta == 'f' || caracterRespuesta == 'F';
        return esFalso == !this.respuesta;      
    }
}
