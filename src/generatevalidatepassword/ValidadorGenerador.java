/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package generatevalidatepassword;

import static generatevalidatepassword.Parametros.*;

/**
 *
 * @author giord
 */
public class ValidadorGenerador {
    
    private final Integer lengthPass = 8;
    
    public ValidadorGenerador() {
    }
    
    private  Integer random(Integer valorInicial, Integer valorFinal){
        return (int) (Math.floor(Math.random() * (valorFinal - valorInicial + 1) + valorInicial));
    }

    
    public String generarPassword(Integer tamanoPassword) throws Exception{
        if(tamanoPassword < lengthPass){
            throw new Exception("La contrasena no puede ser menor a " + lengthPass);
        } 
        int maxLength = random(lengthPass, tamanoPassword);
        int n = 0;
        int j = 0;
        String password = "";
        
        while(maxLength > n){
            Integer especial1Aleatoria = random(CARACTER_ESPECIAL1[0], CARACTER_ESPECIAL1[1]);
            Integer numeroAleatorio = random(NUMEROS[0], NUMEROS[1]);
            Integer especial2Aleatorio = random(CARACTER_ESPECIAL2[0], CARACTER_ESPECIAL1[1]);
            Integer mayusculaAleatorio = random(MAYUSCULA[0], MAYUSCULA[1]);
            Integer especial3Aleatorio = random(CARACTER_ESPECIAL3[0], CARACTER_ESPECIAL3[1]);
            Integer minusculaAleatorio = random(MINUSCULA[0], MINUSCULA[1]);
            Integer especial4Aleatorio = random(CARACTER_ESPECIAL4[0], CARACTER_ESPECIAL4[1]);
            
            Integer[] caracteres = {especial1Aleatoria, numeroAleatorio, mayusculaAleatorio, minusculaAleatorio, especial2Aleatorio, especial3Aleatorio, especial4Aleatorio};
            if(j == 6){
                j = 0;
            }
            password += Character.toString(caracteres[j]);
            n++;
            j++;
        }
        return password;
    }
    
    public Boolean validarContrasena(String password){
        if(password.length() < lengthPass){
            return false;
        }
        int mayuscula = 0;
        int minuscula = 0;
        int numero = 0;
        int simbolo = 0;
        
        int auxiliar = 0;
        for(int i = 0; i < password.length() ; i++){
            auxiliar = (int) password.charAt(i);
            
            if(auxiliar >= NUMEROS[0] && auxiliar <= NUMEROS[1]){
                numero ++;
            }
            if(auxiliar >= MINUSCULA[0] && auxiliar <= MINUSCULA[1]){
                minuscula ++;
            }
            if(auxiliar >= MAYUSCULA[0] && auxiliar <= MAYUSCULA[1]){
                mayuscula ++;
            }
            if(auxiliar >= CARACTER_ESPECIAL1[0] && auxiliar <= CARACTER_ESPECIAL1[1]){
                simbolo ++;
            }
            if(auxiliar >= CARACTER_ESPECIAL2[0] && auxiliar <= CARACTER_ESPECIAL2[1]){
                simbolo ++;
            }
            if(auxiliar >= CARACTER_ESPECIAL3[0] && auxiliar <= CARACTER_ESPECIAL3[1]){
                simbolo ++;
            }
            if(auxiliar >= CARACTER_ESPECIAL4[0] && auxiliar <= CARACTER_ESPECIAL4[1]){
                simbolo ++;
            }
            
        }
        return (mayuscula != 0 && minuscula != 0 && numero != 0 && simbolo != 0);
    }
    
}
