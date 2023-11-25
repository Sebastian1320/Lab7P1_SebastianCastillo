//fila 3 silla 1
package lab7p1_sebastiancastillo;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Asus
 */
public class Lab7P1_SebastianCastillo {

    static Scanner leer = new Scanner(System.in);
    static Random random = new Random();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("***** M E N U *****");
        System.out.println("1.Tres en raya");
        System.out.println("2.Puntos de silla");
        System.out.println("3.Para salir");
        int opcion = leer.nextInt();
        while (opcion != 3) {
            switch (opcion) {
                case 1:
                    int n = 3;
                    int m = 3;
                    char resp = 's';
                    System.out.println("--- Bienvenido al tres en raya ---");
                    System.out.println("Tablero actual");
                    int posx = 0;
                    int posy = 0;
                    while (resp == 's' || resp == 'S') {
                        char[][] tablero = generarTablero(n, m);
                        int cont = 0;
                        imprimir (tablero);
                        while (cont<9) {
                            if (cont % 2 == 0) {
                                char identificador = 'X';
                                System.out.println("Es el turno de X");
                                System.out.println("Ingrese el numero de la fila(0,1,2)");
                                posx = leer.nextInt();
                                while (posx > 2 || posx < 0) {
                                    System.out.println("Su numero esta fuera de la matriz ingrese un numero valido");
                                    posx = leer.nextInt();
                                }
                                System.out.println("Ingrese el numero de la columna(0,1,2)");
                                posy = leer.nextInt();
                                while (posy > 2 || posy < 0) {
                                    System.out.println("Su numero esta fuera de la matriz ingrese un numero valido");
                                    posx = leer.nextInt();
                                }
                                boolean verificar = verificarPosicionValida(tablero, posx, posy);
                                while (verificar == false) {
                                    System.out.println("Posicion ya tomada");
                                    System.out.println("Ingrese el numero de la fila(0,1,2)");
                                    posx = leer.nextInt();
                                    while (posx > 2 || posx < 0) {
                                        System.out.println("Su numero esta fuera de la matriz ingrese un numero valido");
                                        posx = leer.nextInt();
                                    }
                                    System.out.println("Ingrese el numero de la columna(0,1,2)");
                                    posy = leer.nextInt();
                                    while (posy > 2 || posy < 0) {
                                        System.out.println("Su numero esta fuera de la matriz ingrese un numero valido");
                                        posx = leer.nextInt();
                                    }
                                    verificar = verificarPosicionValida(tablero, posx, posy);
                                }
                                System.out.println("El x ha elegido la posicion: ("+posx+","+posy+")");
                                tablero = posicion(tablero, posx, posy, identificador);
                                imprimir(tablero);
                                boolean vic = verificarVictoria(tablero, identificador);
                                if (vic == true) {
                                    System.out.println("X ha ganado");
                                    break;
                                }
                            } else {
                                char identificador = 'O';
                                System.out.println("Es el turno de O");
                                int rng = random.nextInt((2 - 0) + 1) + 0;
                                int rng2 = random.nextInt((2 - 0) + 1) + 0;
                                posx = rng;
                                posy = rng2;
                                boolean verificar = verificarPosicionValida(tablero, posx, posy);
                                while (verificar == false) {
                                    rng = random.nextInt((2 - 0) + 1) + 0;
                                    rng2 = random.nextInt((2 - 0) + 1) + 0;
                                    posx = rng;
                                    posy = rng2;
                                    verificar = verificarPosicionValida(tablero, posx, posy);
                                }
                                System.out.println("El O ha elegido la posicion (" + posx + "," + posy + ")");
                                tablero = posicion(tablero, posx, posy, identificador);
                                imprimir(tablero);
                                boolean vic = verificarVictoria(tablero, identificador);
                                if (vic == true) {
                                    System.out.println("O ha ganado");
                                    break;
                                }
                            }
                            cont++;
                        }
                        if(cont>=9){
                            System.out.println("Es un empate");
                        }
                        System.out.println("Desea volvera jugar [S/N]");
                        resp = leer.next().charAt(0);
                    }
                    break;

                case 2:
                    System.out.println("Ingrese el nuemro de filas y columnas");
                    int filas=leer.nextInt();
                    int columnas=filas;
                    int[][]matriz2=Random(filas,columnas);
                    imprimir2(matriz2);
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
                    break;
            }
            System.out.println("***** M E N U *****");
            System.out.println("1.Tres en raya");
            System.out.println("2.Puntos de silla");
            System.out.println("3.Para salir");
            opcion = leer.nextInt();
        }

    }

    public static char[][] generarTablero(int n, int m) {
        char[][] tablero = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
            }
        }
        return tablero;
    }

    public static char[][] posicion(char[][] matriz, int posx, int posy, char identificador) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i == posx && j == posy && identificador == 'X') {
                    matriz[i][j] = 'X';
                    break;
                } else if (i == posx && j == posy && identificador == 'O') {
                    matriz[i][j] = 'O';
                    break;
                }
            }
        }
        return matriz;
    }

    public static boolean verificarPosicionValida(char[][] matriz, int posx, int posy) {
        boolean valido = false;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[posx][posy] == 'X' || matriz[posx][posy] == 'O') {
                    valido = false;
                    break;
                } else {
                    valido = true;
                }
            }
        }
        return valido;
    }

    public static boolean verificarVictoria(char[][] matriz, char identificador) {
        boolean vic = false;
        for (int i = 0; i < matriz.length; i++) {
            if ((matriz[i][0] == identificador && matriz[i][1] == identificador && matriz[i][2] == identificador) || (matriz[0][i] == identificador && matriz[1][i] == identificador && matriz[2][i] == identificador)) {
                vic = true;
            }
        }
        if ((matriz[0][0] == identificador && matriz[1][1] == identificador && matriz[2][2] == identificador) || (matriz[0][2] == identificador && matriz[1][1] == identificador && matriz[2][0] == identificador)) {
            vic = true;
        } 

        return vic;
    }

    public static void imprimir(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("[");
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 'X') {
                    System.out.print(matriz[i][j]);
                } else if (matriz[i][j] == 'O') {
                    System.out.print(matriz[i][j]);
                } else {
                    System.out.print(" ");
                }
                if (j < 2) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            System.out.println();
        }
    }
     public static int[][] Random(int n, int m) {
        int[][] tablero = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tablero[i][j]=random.nextInt((99-0)+1)+0;
                
            }
        }
        return tablero;
    }
     
    public static void imprimir2(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("["+matriz[i][j]+"]");
            }
            System.out.println();
        }
    }
    
 }
