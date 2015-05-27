/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capturadepersonas;

import java.util.Scanner;

/**
 *
 * @author MrAlex6204<engineer.vera@yahoo.com>
 */
public class CapturaDePersonas {

    public class Persona {

        private java.util.Scanner _input = new java.util.Scanner(System.in);
        public String nombre = "";
        public int edad = -1;
        public int sexo = -1;
        public String cargo = "";
        public float sueldo = -1;

        private int _CapturarSexo() {
            int opcion = -1;
            do {//===>Repetir hasta que seleccione la opcion correcta.
                System.out.print("Sexo [Femenino = 1 Masculino = 2]:");
                opcion = _input.nextInt();
                if (opcion != 1 & opcion != 2) {
                    System.out.println("Opcion incorrecta!");
                }

            } while (opcion != 1 & opcion != 2);

            return opcion;
        }

        public void Capturar() {

            System.out.print("Nombre  :");
            this.nombre = _input.nextLine();
            
            System.out.print("Cargo   :");
            this.cargo = _input.nextLine();
            
            System.out.print("Edad    :");
            this.edad = _input.nextInt();

            System.out.print("Sexo    :");
            this.sexo = _CapturarSexo();

            System.out.print("Sueldo  :$ ");
            this.sueldo = _input.nextFloat();
        }

        public void Mostrar() {
            System.out.println("Nombre  :" + this.nombre);
            System.out.println("Edad    :" + this.edad);
            System.out.println("Sexo    :" + this.sexo);
            System.out.println("Cargo   :" + this.cargo);
            System.out.println("Sueldo  :$ " + this.sueldo);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CapturaDePersonas.Persona[] lstPersonas = new CapturaDePersonas.Persona[10];
        
        for(int idx= 0;idx<10;idx++){
          lstPersonas[idx] = new CapturaDePersonas().new Persona();
          lstPersonas[idx].Capturar();
          
          //===>TODO HERE: agregar aqui tu conteo
          if(lstPersonas[idx].sexo == 'M'){
          //===>Si es masculino
          }else{
          //===>Si es femnino
          }
          
        }
        
        
    }

}
