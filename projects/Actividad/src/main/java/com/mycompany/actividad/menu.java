package com.mycompany.actividad;

import java.util.Scanner;

public class menu {
    public static Scanner scanner = new Scanner(System.in);
    public static short x;
    public static int vm[];
    public static void main(String[] args) {
        int f,pos_ini,c;
        boolean af = false, llenado = false;
        byte option;
        String menu = "1- Llenar la matriz\n" + 
                "2-Mostrar Matriz\n" + 
                "3-Posicion matricial\n"
                + "4-Suma de dos matrices\n"
                + "5-Total de una fila\n"
                + "6-Columna Mayor\n"
                + "7-Columna Mayor entre 0 - 2\n"
                + "0-Salir";
        System.out.println("Numero de filas");
        f = scanner.nextInt();
        System.out.println("Numero de columnas");
        c = scanner.nextInt();
        System.out.println("Posición inicial");
        pos_ini = scanner.nextInt();
        vm = new int[pos_ini + f * c];
        do {         
            System.out.println(menu);
            System.out.println("Escoja la opción");
            option = scanner.nextByte();
            switch (option) {
            case 1:
                llenar(f, pos_ini, c, vm);
                llenado = true;
                break;
            case 2:
                if (llenado == true) {
                    mostrar(f, pos_ini, c, vm);
                }
                break;
            case 3:
                if (llenado == true) {
                    pos_matriz(f,pos_ini,c,vm);
                }
                break;
            case 4:
                if (llenado == true){
                    suma_vm(f, pos_ini, c, vm);
                }
                break;
            case 5:
                if (llenado == true ) {
                    total_fila(f, pos_ini, c, vm);
                }
                break;
            case 6:
                if (llenado == true) {
                    columna_mayor(f, pos_ini, c, vm);
                }
                break;
            case 7:
                if (llenado == true) {
                    columna_mayor_de_2(f, pos_ini, c, vm);
                }
                break;
            case 0:
                af = true;
                break;
            default:
                System.out.println("Error");
                throw new AssertionError();
        }
        } while (af == false);
        
    }
    public static void llenar(int f, int posini, int c, int v[]){
          for (int i = 0; i < f; i++) {
              for (int j = 0; j < c; j++) {
                  System.out.println("Escribe el numero del vector matriz " + i + j);
                  vm[posini + c * i + j] = scanner.nextInt();
              }
        }
    }
    public static void mostrar(int f, int posini, int c, int v[]){
        String str= "";
          for (int i = 0; i < f; i++) {
              for (int j = 0; j < c; j++) {
                  str += vm[posini + c * i + j] + " ";
              }
              str+= "\n";
        }
        System.out.print(str);
    }
    public static void pos_matriz (int f, int posini, int c, int v[]){
        int x;
        System.out.println("Escribe la fila de la matriz");
        short a = scanner.nextShort();
        System.out.println("Escribe la columna de la matriz");
        short b = scanner.nextShort();
        x = posini + c * a + b;
        System.out.println("La posicion de la matriz es: " + x);
    }
    public static void suma_vm (int f, int posini, int c, int v[]){
        System.out.println("Escribe la fila del primer vector matriz");
        short a = scanner.nextShort();
        System.out.println("Escribe la columna del primer vector matriz");
        short b = scanner.nextShort();
        System.out.println("Escribe la fila del segundo vector matriz");
        short e = scanner.nextShort();
        System.out.println("Escribe la columna del segundo vector matriz");
        short d = scanner.nextShort();
        int x;
        x = v[posini + f * a + b] + v[posini + f * e + d];
        System.out.println(x);
    }
    public static void total_fila (int f, int posini, int c, int v[]){
        int x = 0;
        System.out.println("Escribe la fila:");
        short a = scanner.nextShort();
        for (int j = 0; j < f; j++) {
            x = v[posini + f * j + a] + x;
        }
        System.out.print( "La suma del total de la fila " + a + " es: " + x);
    }
    public static void columna_mayor(int f, int posini, int c, int v[]){
        int x[] = new int[c];
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < f; j++) {
                x[i] += v[posini + f * i + j] ;
            }
        }
        bubbleSort(x,x);
    }
    public static void columna_mayor_de_2(int f, int posini, int c, int v[]){
        int x[] = new int[c];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < f; j++) {
                x[i] += v[posini + f * i + j] ;
            }
        }
        bubbleSort(x,x);
    }
    public static void bubbleSort(int arr[], int v[]){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - i - 1; j++){
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
            if (v[i] == arr[n-1]) {
                System.out.println( "La columna " + (i+1) + " es la mayor ");
            }
        }
    }
}
