/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PromedioNotas;

import java.util.Scanner;

/**
 *
 * @author visitante
 */
public class Promedio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado= new Scanner(System.in);

        // se define un vector llamado prome
        int [] prome =new int[20];//se define el tamaño de prome

        int i = 0;//(declaración subinidce del recorrido del vector)contador
        float total=0;//declaración de la variable que contendra el promedio de notas (acumulador)
        for(i=0;i<20;++i)//ciclo for que recorre desde cero hasta que sea menor a 20
        //recorrido del vector para la asignación de calificaciones o notas
        {
            System.out.print("ingrese calificacion del alumno "+i+": ");
            prome[i]=teclado.nextInt(); //prome en la posición i va a ser lo que se digitara
           total=total+prome[i]; //se acumula en la variable total 
        }
        //Despliegue del promedio de notas o calificaciones
        System.out.println("La suma de las notas es: "+total);
        total= total/20;//sacando promedio
        System.out.println("promedio general es: "+total);
        //Despliegue de notas por alumno ingresado del último al primero
        for(i=19;i>=0;--i)
            System.out.println("alumno "+i+" su promedio es: "+prome[i]);  
    }        
        
}
