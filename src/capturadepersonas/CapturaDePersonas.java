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

    public static final int MASCULINO = 2, FEMENINO = 1;

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

            } while (opcion != MASCULINO & opcion != FEMENINO);

            return opcion;
        }

        public void Capturar() {

            System.out.print("Nombre  :");
            this.nombre = _input.nextLine();

            System.out.print("Cargo   :");
            this.cargo = _input.nextLine();

            System.out.print("Edad    :");
            this.edad = _input.nextInt();

            this.sexo = _CapturarSexo();

            System.out.print("Sueldo  :$ ");
            this.sueldo = _input.nextFloat();
        }

        public void Mostrar() {
            System.out.println("\t Nombre  :" + this.nombre);
            System.out.println("\t Edad    :" + this.edad);
            System.out.println("\t Sexo    :" + this.sexo);
            System.out.println("\t Cargo   :" + this.cargo);
            System.out.println("\t Sueldo  :$ " + this.sueldo);
        }

        @Override
        public String toString() {
            return "Nombre : " + this.nombre;
        }

    }

    private static void Buscar(Persona[] lstDePersonas) {
        String Nombre = "";
        Scanner input = new Scanner(System.in);
        System.out.println("\n Teclee el nombre a buscar:");
        Nombre = input.nextLine();

        System.out.println("Resultados:");
        System.out.println("============================================");
        for (int idx = 0; idx < lstDePersonas.length - 1; idx++) {//===>Inicializar busqueda
            if (lstDePersonas[idx].nombre.contains(Nombre)) {
                lstDePersonas[idx].Mostrar();//===>Mostrar datos en pantalla
                System.out.println("********************************************");
            }
        }
        System.out.println("============================================");
    }

    private static boolean Continuar(String msg) {
        Scanner input = new Scanner(System.in);
        int opcion = -1;
        do {
            System.out.print("\n" + msg + " [Si=1 | No=0] :");
            opcion = input.nextInt();
            if (opcion != 0 & opcion != 1) {
                System.out.println("*OPCION INVALIDA*");
            }
        } while (opcion != 0 & opcion != 1);
        if (opcion == 1) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CapturaDePersonas.Persona[] lstPersonas = new CapturaDePersonas.Persona[4];

        char opcion = 'N';
        int totalMasculino = 0,
                totalFemenino = 0,
                totalMayoresDe20Masculino = 0,
                totalMayoresDe20Femenino = 0;
        float sueldPromedio = 0, totalDeSueldos = 0;
        Persona personaConMayorSueldo = new CapturaDePersonas().new Persona();

        for (int idx = 0; idx < lstPersonas.length - 1; idx++) {
            System.out.println("\n");
            lstPersonas[idx] = new CapturaDePersonas().new Persona();
            lstPersonas[idx].Capturar();

            //===>TODO HERE: agregar aqui tu conteo
            if (lstPersonas[idx].sexo == MASCULINO) {
                //===>Si es masculino
                totalMasculino++;
                if (lstPersonas[idx].edad >= 20) {
                    totalMayoresDe20Masculino++;
                }

            } else {
                //===>Si es femnino
                totalFemenino++;
                if (lstPersonas[idx].edad >= 20) {
                    totalMayoresDe20Femenino++;
                }

            }
            if (lstPersonas[idx].sueldo > personaConMayorSueldo.sueldo) {
                personaConMayorSueldo = lstPersonas[idx];//===>Guardar la informacion de la persona con mayor sueldo.
            }
            totalDeSueldos += lstPersonas[idx].sueldo;//===>Realizar la suma total de los sueldos
        }

        System.out.println("Resultados Totales:");
        System.out.println("============================================");
        System.out.println("Mujeres               :" + totalFemenino);
        System.out.println("Hombres               :" + totalMasculino);
        System.out.println("Total en sueldo       :$" + totalDeSueldos);
        System.out.println("Mujes mayores de 20   :" + totalMayoresDe20Femenino);
        System.out.println("Hombres mayores de 20 :" + totalMayoresDe20Masculino);
        System.out.println("============================================");



        while (Continuar("Desea realizar una busqueda.")) {
            Buscar(lstPersonas);
        }

    }

}




