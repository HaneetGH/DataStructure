package com.technorapper.datastructure.ds;

import java.util.HashMap;
import java.util.Map;

public class FloodFilling {

    // Dimentions of paint screen
    static int M = 8;
    static int N = 8;

    // A recursive function to replace previous color 'prevC' at '(x, y)'
// and all surrounding pixels of (x, y) with new color 'newC' and
    static void floodFillUtil(int screen[][], int x, int y,
                              int prevC, int newC) {
        // Base cases
        if (x < 0 || x >= M || y < 0 || y >= N)
            return;
        if (screen[x][y] != prevC)
            return;

        // Replace the color at (x, y)
        screen[x][y] = newC;

        // Recur for north, east, south and west
        floodFillUtil(screen, x + 1, y, prevC, newC);
        floodFillUtil(screen, x - 1, y, prevC, newC);
        floodFillUtil(screen, x, y + 1, prevC, newC);
        floodFillUtil(screen, x, y - 1, prevC, newC);
    }

    // It mainly finds the previous color on (x, y) and
// calls floodFillUtil()
    static void floodFill(int screen[][], int x, int y, int newC, int prevC) {

        floodFillUtil(screen, x, y, prevC, newC);
    }

    // Driver code
    public static void main(String[] args) {

        int[] arr = {1, 1, 7, 7, 5, 3};
        int anyNumber = 20;
        System.out.println(idPrimeWithRoot(anyNumber));

    }


    public static int valM = 2;

    public static boolean isPrime(int anyNumber) {



        if (anyNumber == 0 || anyNumber == 1) return false;
        if (anyNumber == valM) return true;
        if (anyNumber % valM == 0) return false;
        valM++;

        return isPrime(anyNumber);

    }

    public static boolean idPrimeWithRoot(int anyNumber)
    {


        for (int i = 2; i <=Math.sqrt(anyNumber); i++) {
            if(anyNumber%i==0)
                return false;
        }
        return true;
    }


    public  HashMap<Integer, Integer> checkOcc(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (hashMap.containsKey(arr[i])) {
                hashMap.put(arr[i], hashMap.get(arr[i]) + 1);
            } else {
                hashMap.put(arr[i], 1);
            }
        }

        return hashMap;
    }
}