package proyecto;
import java.util.Scanner;
/**
 *
 * @author Bastiaan
 */

public class ExamDemo{
    public static void main(String[] args){
        //System.out.println("creando examen");

        try (Scanner scanner= new Scanner(System.in)){
            Exam examen = new Exam();
            
            //crear preguntas en el examen nuevo
            Pregunta pregunta1= new TFpregunta("la capital de chile es santiago?", true, 5);
            Pregunta pregunta2= new TFpregunta("la capital de chile es serena?", false, 5);
            String[] opcionesPregunta3= {"Santiago", "Valparaiso", "Concepcion", "Magallanes", "Arica"};
            Pregunta pregunta3= new Selec_Mul_Pregunta("¿Cuál es la capital de region metropolitana?", opcionesPregunta3, 0, 10);
            Pregunta pregunta4= new Resp_Cortas_Pregunta("Cual es la capital de la IV region", "Coquimbo", 10);
            //para agregar las preguntas al examen
            examen.agregaPregunta(pregunta1);
            examen.agregaPregunta(pregunta2);
            examen.agregaPregunta(pregunta3);
            examen.agregaPregunta(pregunta4);
            
            System.out.println("Responde las sgtes preguntas del examen:");
            examen.darExam();
            
            //para ir registrando el examen
            int puntajeMaximo = pregunta1.getPeso() + pregunta2.getPeso() + pregunta3.getPeso() + pregunta4.getPeso();
            int puntajeUsuario = calcularPuntaje(examen);
            System.out.println("\n El puntaje maximo es: " + puntajeMaximo);
            System.out.println("Tu puntaje es " + puntajeUsuario);
        }
    }
    public static int calcularPuntaje(Exam examen){
        int puntajeTotal= 0;
        int respuestasCorrectas= 0;
        Pregunta[] preguntas= examen.getPreguntas();
        for (Pregunta pregunta: preguntas){
            if (pregunta != null && pregunta.buscar()){
                puntajeTotal += pregunta.getPeso();
                respuestasCorrectas++;
            }
        }
        double porcentaje= (double) respuestasCorrectas/preguntas.length * 100;//calculo
        System.out.printf("\nContestaste %d de %d preguntas correctas (%.2f%%)\n", respuestasCorrectas, preguntas.length, porcentaje);
        return puntajeTotal;
    }
}
