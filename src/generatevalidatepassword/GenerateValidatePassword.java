/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package generatevalidatepassword;

import java.util.Scanner;

/**
 *
 * @author giord
 */
public class GenerateValidatePassword {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ValidadorGenerador validador = new ValidadorGenerador();
        Scanner scaner = new Scanner(System.in);
        
        
        while(true){
            
            System.out.println("Menú");
            System.out.println("1- Generar Contraseña\n2-Validar Contraseña\n3-salir");
            int opcion = scaner.nextInt();
            
            if(opcion == 1){
                System.out.println("Ingrese el máximo que puede tener su contraseña");
                int max = scaner.nextInt();
                try {
                    System.out.println("Su contraseña es: ");
                    System.out.println(validador.generarPassword(max));
                } catch (Exception ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
            
            if(opcion == 2){
                System.out.println("Ingrese la contraseña para validar si es segura: ");
                String password = scaner.next();
                if(!validador.validarContrasena(password)){
                    System.out.println("Su contraseña es insegura");
                }else{
                    System.out.println("Su contraseña es segura");
                }
                
            }
            
            if(opcion == 3){
                System.out.println("Hasta Luego");
                 break;
            }
            
        }
       
        
    }
    
}
