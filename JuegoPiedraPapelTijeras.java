public class JuegoPiedraPapelTijeras {
    public static void main(String[] args) {
        boolean salir = false;
        int opcion, victoriasPlayer = 0,  victoriasCpu = 0, empates = 0;

        do{
            mostrarMenu();
            opcion = Lib.leerInt("Elige una opción: ");
            switch (opcion) {
                case 1:
                    switch (jugarPartida()) {
                        case 1:
                            victoriasPlayer++;
                            break;
                        case 2:
                            victoriasCpu++;
                            break;
                        case 3:
                            empates++;
                            break;
                    }
                    break;
                case 2:
                    mostrarPuntuaciones(victoriasPlayer, victoriasCpu, empates);
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción introducida no válida, debes de introducir un número entre el 0 y el 2");
                    break;
            }
        }while(salir == false);

        System.out.println("Has salido del juego correctamente!!");
    }

    /**
     * Enumerado con las opciones que existen
     */
    public static enum Opciones{
        PIEDRA, PAPEL, TIJERAS
    }

    /**
     * Metodo principal donde se juega la partida, devuelve un valor el cual indica quien es el ganador o si es empate
     * @return devuelve un número entero por el cual; 1 significa que gana el jugador, 2 significa que gana la CPU y 3 significa empate
     */
    public static int jugarPartida() {
        boolean valido = false;
        int opcion, resultado = 0;
        Opciones eleccionPlayer, eleccionCpu;

        do{
            menuEleccion();
            opcion = Lib.leerInt("Indica tu elección: ");
            switch (opcion) {
                case 1:
                    eleccionPlayer = Opciones.PIEDRA;
                    System.out.println("Player elige " + eleccionPlayer);

                    eleccionCpu = eleccionCpu();

                    System.out.println("CPU elige " + eleccionCpu);
                    System.out.println();

                    if(eleccionCpu == Opciones.PIEDRA) {
                        System.out.println("Empate!");
                        resultado = 3;
                    } else if(eleccionCpu == Opciones.PAPEL) {
                        System.out.println("Has perdido!");
                        System.out.println("El " + eleccionCpu + " envuelve la " + eleccionPlayer);
                        resultado = 2;
                    } else {
                        System.out.println("Has ganado!");
                        System.out.println("La " + eleccionPlayer + " rompe las " + eleccionCpu);
                        resultado = 1;
                    }

                    valido = true;
                    break;
                case 2:
                    eleccionPlayer = Opciones.PAPEL;
                    System.out.println("Player elige " + eleccionPlayer);

                    eleccionCpu = eleccionCpu();

                    System.out.println("CPU elige " + eleccionCpu);
                    System.out.println();

                    if(eleccionCpu == Opciones.PIEDRA) {
                        System.out.println("Has ganado!");
                        System.out.println("El " + eleccionPlayer + " envuelve la " + eleccionCpu);
                        resultado = 1;
                    } else if(eleccionCpu == Opciones.PAPEL) {
                        System.out.println("Empate!");
                        resultado = 3;
                    } else {
                        System.out.println("Has perdido!");
                        System.out.println("Las " + eleccionCpu + " cortan el " + eleccionPlayer);
                        resultado = 2;
                    }

                    valido = true;
                    break;
                case 3:
                    eleccionPlayer = Opciones.TIJERAS;
                    System.out.println("Player elige " + eleccionPlayer);

                    eleccionCpu = eleccionCpu();

                    System.out.println("CPU elige " + eleccionCpu);
                    System.out.println();

                    if(eleccionCpu == Opciones.PIEDRA) {
                        System.out.println("Has perdido!");
                        System.out.println("La " + eleccionCpu + " rompe las " + eleccionPlayer);
                        resultado = 2;
                    } else if(eleccionCpu == Opciones.PAPEL) {
                        System.out.println("Has ganado!");
                        System.out.println("Las " + eleccionPlayer + " cortan el " + eleccionCpu);
                        resultado = 1;
                    } else {
                        System.out.println("Empate!");
                        resultado = 3;
                    }

                    valido = true;
                    break;
                default:
                    System.out.println("Opción introducida no válida, debes de introducir un número entre el 1 y el 3");
                    break;
            }
        }while(valido == false);

        System.out.println();
        Lib.presionarIntroParaContinuar();

        return resultado;
    }

    /**
     * Metodo para la elección de la CPU, devuelve una de las opciones del enumerado aleatoriamente
     * @return devuelve una opcion del enumerado aleatoria
     */
    public static Opciones eleccionCpu() {
        final int VALOR_MIN = 1;
        final int VALOR_MAX = 3;
        int eleccionCpuInt = Lib.aleatorioEntero(VALOR_MIN, VALOR_MAX);
        Opciones eleccionCpuString = Opciones.PIEDRA;

        switch (eleccionCpuInt) {
            case 1:
                eleccionCpuString = Opciones.PIEDRA;
                break;
            case 2:
                eleccionCpuString = Opciones.PAPEL;
                break;
            case 3:
                eleccionCpuString = Opciones.TIJERAS;
                break;
        }

        return eleccionCpuString;
    }

    /**
     * Muestra el menú de elección del jugador
     */
    public static void menuEleccion() {
        System.out.println("***********");
        System.out.println("*  ELIGE  *");
        System.out.println("***********");
        System.out.println("1. Piedra");
        System.out.println("2. Papel");
        System.out.println("3. Tijeras");
    }

    /**
     * Devuelve las puntuaciones totales de la partida
     * @param victoriasPlayer número entero con el número de victorias del jugador
     * @param victoriasCpu número entero con el número de victorias de la CPU
     * @param empates número entero con el número de empates
     */
    public static void mostrarPuntuaciones(int victoriasPlayer, int victoriasCpu, int empates) {
        System.out.println("***** PUNTUACIONES ******");
        System.out.println("Victorias Player:\t\t" + victoriasPlayer);
        System.out.println("Victorias CPU:\t\t\t" + victoriasCpu);
        System.out.println("Empates:\t\t\t\t" + empates);
        System.out.println("");
        Lib.presionarIntroParaContinuar();
    }

    /**
     * Muestra el menú principal
     */
    public static void mostrarMenu() {
        System.out.println("===========================");
        System.out.println("  PIEDRA, PAPEL O TIJERAS  ");
        System.out.println("===========================");
        System.out.println("1. Nueva partida...");
        System.out.println("2. Mostrar puntuaciones...");
        System.out.println("---------------------------");
        System.out.println("0. Salir");
    }
}
