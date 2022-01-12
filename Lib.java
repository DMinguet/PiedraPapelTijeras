import java.util.Random;
import java.util.Scanner;

public class Lib {

    static final String ESCAPE = "\u001B[";
    static final Scanner lector = new Scanner(System.in);

    public static int aleatorioEntero(int min, int max) {
        Random rd = new Random();
        int numeroAleatorio = rd.nextInt(max - min + 1) + min;

        return numeroAleatorio;
    }

    public static double aleatorioReal(double min, double max) {
        Random rd = new Random();
        double numeroAleatorio = min + (max - min) * rd.nextDouble();

        return numeroAleatorio;
    }

    static public void presionarIntroParaContinuar() {
        String seguir;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Pulsa Intro para continuar ...");
        try
        {
            seguir = teclado.nextLine();
            limpiarPantalla();
        }
        catch(Exception e)
        {}
    }

    public static void limpiarPantalla() {
        System.out.print(ESCAPE + "H");
        System.out.print(ESCAPE + "2J");
        System.out.flush();
    }

    public static void espera(int x){
        try{
            Thread.sleep(x);
        }catch(InterruptedException ie) {

        }
    }

    public static String leerLinea(String linea){
        System.out.println(linea);
        return lector.nextLine();
    }

    public static int leerInt(String linea){
        System.out.println(linea);
        return Integer.parseInt(lector.nextLine());
    }

    public static float leerFloat(String linea){
        System.out.println(linea);
        return Float.parseFloat(lector.nextLine());
    }

    public static double leerDouble(String linea){
        System.out.println(linea);
        return Double.parseDouble(lector.nextLine());
    }

    public static char leerChar(String linea){
        System.out.println(linea);
        return lector.next().charAt(0);
    }

    public static void rellenarArrayEnteros(int[] array, int min, int max) {
        for(int i = 0; i < array.length; i++) {
            array[i] = aleatorioEntero(min, max);
        }
    }

    public static double[] crearArrayReal(double[] array, int min, int max) {
        for(int i = 0; i < array.length; i++) {
            array[i] = aleatorioReal(min, max);
        }

        return array;
    }

    public static void visualizarArrayEntero(int[] array) {
        System.out.printf("{ ");
        for(int i = 0; i < array.length; i++) {
            System.out.printf("%d ", array[i]);
        }
        System.out.printf("}\n");
    }

    public static void visualizarArrayReales(double[] array) {
        System.out.print("{ ");
        for(int i = 0; i < array.length; i++) {
            System.out.printf("%.2f ", array[i]);
        }
        System.out.println(" }");
    }

    public static void visualizarArrayChar(char[] array) {
        System.out.print("{");
        for(int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println(" }");
    }

    public static int[][] rellenarMatrizEnteros(int[][] matriz, int min, int max) {
        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = aleatorioEntero(min, max);
            }
        }

        return matriz;
    }

    public static double[][] rellenarMatrizReales(double[][] matriz, double min, double max) {
        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = aleatorioReal(min, max);
            }
        }

        return matriz;
    }

    public static void visualizarMatrizEnteros(int[][] m) {
        for(int i = 0; i < m.length; i++) {
            System.out.print("Fila " + i + ": ");
            for(int j = 0; j < m[i].length; j++) {
                if(j!=0) {
                    System.out.print(", ");
                }
                System.out.print(m[i][j]);
            }
            System.out.println("");
        }
    }

    public static void visualizarMatrizReales(double[][] m) {
        for(int i = 0; i < m.length; i++) {
            System.out.print("Fila " + i + ": ");
            for(int j = 0; j < m[i].length; j++) {
                if(j!=0) {
                    System.out.print("- ");
                }
                System.out.printf("%.2f", m[i][j]);
            }
            System.out.println("");
        }
    }
}