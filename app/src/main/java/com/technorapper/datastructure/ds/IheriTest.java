package com.technorapper.datastructure.ds;

public class IheriTest {

    public static void main(String[] args) {
        System.out.println(1);
        getFibina(1);
    }

    public static int last = 0;

    private static void getFibina(int n) {
        System.out.println(1);
        last = n;
        while (last > 30)
            getFibina(last + n);

    }
}



