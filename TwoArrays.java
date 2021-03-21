/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.algorithmization;
import java.util.*;
/**
 *
 * @author Владислав
 */
public class TwoArrays {
    private int[][] fillIntArray(int n, int m){
    
        int[][] array = new int[n][m];
         
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int)(Math.random() * 20);
            }
        }
        return array;
    } 
    
    private void  printArray(int[][] array){    
         
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    } 
    
    public void task1(int n, int m){
        System.out.println("task1");        
        int[][] array = fillIntArray(n, m);
        printArray(array);
        System.out.println("==========================");
        
        for (int i = 0; i < array.length; i++){
            for(int j = 0;  j < array[i].length; j++){
                if (j % 2 == 0 && array[0][j] > array[n - 1][j]){
                    System.out.print(array[i][j] + "\t");
                }
            }
            System.out.println();
        }              
    }
    
    public void task2(int n){
        System.out.println("task2");        
        int[][] array = fillIntArray(n, n);
        printArray(array);
        System.out.println("==========================");
        
        for (int i = 0; i < array.length; i++){
            for(int j = 0;  j < array[i].length; j++){
                if (i == j){
                    System.out.print(array[i][j] + "\t");
                }
                else {
                    System.out.print(0 + "\t");
                }
            }
            System.out.println();
        }    
    
    }
    
    public void task3(int n, int m, int k, int p){
        System.out.println("task3");        
        int[][] array = fillIntArray(n, m);
        printArray(array);
        System.out.println("==========================");
        
        for (int i = 0; i < array.length; i++){
            for(int j = 0;  j < array[i].length; j++){
                if (i == k || j == p){
                    System.out.print(array[i][j] + "\t");
                }
                else {
                    System.out.print(0 + "\t");
                }
            }
            System.out.println();
        }        
    }  
    
    public void task4(int n){
        System.out.println("task4");  
        if (n % 2 == 0){ 
            int[][] array = new int[n][n];
            int k = 1;
        
            for (int i = 0; i < array.length; i++){
                for(int j = 0;  j < array[i].length; j++){
                    if (i % 2 == 0){
                        array[i][j] = j + 1;
                        System.out.print(array[i][j] + "\t");
                    }
                    else{
                        array[i][j] = n - j;
                        System.out.print(array[i][j] + "\t");
                    }
                }
                System.out.println();
            }        
        }
        else {
        System.out.println("Введите четное значение");
        }        
    }
    
    public void task5(int n){
        System.out.println("task5");
        if (n % 2 == 0){ 
            int[][] array = new int[n][n];
            int k = 1;
        
            for (int i = 0; i < array.length; i++){
                for(int j = 0;  j < array[i].length; j++){
                    if (i + j + 1 == n){
                        array[i][j] = i + 1 ;
                        System.out.print(array[i][j] + "\t");
                    }
                    else if (i + j + 1 < n){
                        array[i][j] = i + 1 ;
                        System.out.print(array[i][j] + "\t");
                    }
                    else {
                        array[i][j] = 0 ;
                        System.out.print(array[i][j] + "\t");
                    }
                }
                System.out.println();
            }        
        }
        else {
        System.out.println("Введите четное значение");
        }         
    }
    
    public void task6(int n){
        System.out.println("task6");   
        if (n % 2 == 0){       
            int[][] array = new int[n][n];       
            for (int i = 0; i < array.length; i++){
                for(int j = 0;  j < array[i].length; j++){
                    if (i + j + 1 == n || i == j){
                        array[i][j] = 1 ;
                        System.out.print(array[i][j] + "\t");
                    }
                    else if (i + j + 1 < n && i<=j || i + j + 1 > n && i>=j){
                        array[i][j] = 1 ;
                        System.out.print(array[i][j] + "\t");
                    }
                    else {
                        array[i][j] = 0 ;
                        System.out.print(array[i][j] + "\t");
                    }
                }
                System.out.println();
            } 
        }
        else {
        System.out.println("Введите четное значение");
        }    
    }
    
    public void task7(int n){
        System.out.println("task7");        
        double[][] array = new double[n][n];
        //printArray(array);
        System.out.println("==========================");
        int k = 0;
        
        for (int i = 0; i < array.length; i++){
            for(int j = 0;  j < array[i].length; j++){
                array[i][j] = 
                        Math.sin(
                            (Math.pow(i, 2) - Math.pow(j, 2) ) / n 
                        );
                if (array[i][j] > 0){
                    k++;
                }
                //System.out.print(array[i][j] + "   ");
            }
            //System.out.println();
        }
        System.out.println("Количество положительных элементов: " + k);   
        
    }  
        
    public void task8(int n, int m){
        System.out.println("task8");        
        int[][] array = fillIntArray(n, m);        
        printArray(array);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер первого столбца");
        
        int k = scanner.nextInt() - 1;
        
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Введите номер второго столбца");
        
        int p = scanner2.nextInt() - 1;
        
        System.out.println("==========================");
        int temp;
        
        for (int i = 0; i < array.length; i++){
            for(int j = 0;  j < array[i].length; j++){
                if (j == k){
                    temp = array[i][k];
                    array[i][k] = array[i][p];
                    array[i][p] = temp;
                    
                }
                //System.out.print(array[i][j] + "\t");
            }
            //System.out.println();
        }
        printArray(array);  
    } 
    
    public void task9(int n, int m){
        System.out.println("task9");        
        int[][] array = new int[n][m]; 
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int)(Math.random() * 5);
            }
        }
        
        for (int i = 0; i < array.length; i++) {
            sum = 0;
            for (int j = 0; j < array[i].length; j++) {  
                
                sum += array[j][i];
            }
            System.out.println ("========");
            map.put(i, sum);            
        }
        printArray(array);
        
        int max = map.get(0);
        int iMax = 0;
        
        for (int i : map.keySet()){
            System.out.println("Столбец: " + (i + 1) + " : " + map.get(i));
            if (map.get(i) >  max){
                max = map.get(i);
                iMax = i + 1;
            }
        }
            System.out.println();
            System.out.println("Максимальная сумма находится в: " + iMax + " столбце");
    }
    
    public void task10(int n){
        System.out.println("task10");        
        int[][] array = new int[n][n];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int)(Math.random() * 20 - 10);
            }
        }
        printArray(array);
        System.out.println("==========================");
        
        ArrayList<Integer> al = new ArrayList<Integer>();
        
        for (int i = 0; i < array.length; i++){
            for(int j = 0;  j < array[i].length; j++){
                if (i == j && array[i][j] > 0){
                    al.add(array[i][j]);
                }
            }
        }  
        
        for (int i : al){
            System.out.println(i + " ");
        }
    }
    
    public void task11(){
        System.out.println("task11");        
        int[][] array = new int[10][20];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        
        for (int i = 0; i < array.length; i++) {
            ArrayList al = new ArrayList();
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int)(Math.random() * 15);
                al.add(array[i][j]);
                map.put(i, al);
            }
        }
        
        printArray(array);
        System.out.println("============================================");  
        
        HashMap<Integer, Integer> mapFreq = new HashMap<Integer, Integer>();      
        for (int i : map.keySet()){
            ArrayList<Integer> al = map.get(i);
            for (int k = 0; k < al.size(); k++){
                if (!mapFreq.containsKey(i) && al.get(k) == 5){
                    mapFreq.put(i, 1);
                }
                else if (al.get(k) == 5){
                    mapFreq.put(i, mapFreq.get(i)+1);
                }                
            }           
        }
        
        for (int i : mapFreq.keySet()) {
            if (mapFreq.get(i) >= 3){
                System.out.println("В строке: " + (i + 1) + " цифра 5 появилась: " +
                        mapFreq.get(i));
            }
        }   
    }
    
    public void task12(int n, int m){
        System.out.println("task12");        
        int b;
        int[][] array = fillIntArray(n, m);
        printArray(array);
        System.out.println("==========================");

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                for (int k = j + 1; k < array[i].length; k++) {
                    if (array[i][j] > array[i][k]) {
                        b = array[i][j];
                        array[i][j] = array[i][k];
                        array[i][k] = b;
                    }
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
    public void task13(int n, int m){
        System.out.println("task13");        
        int b;
        int[][] array = fillIntArray(n, m);
        printArray(array);
        System.out.println("==========================");
            
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                for (int k = col + 1; k < array.length; k++) {
                    if (array[col][row] > array[k][row]) {
                        b = array[col][row];
                        array[col][row] = array[k][row];
                        array[k][row] = b;
                    }
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
    public void task14(int n, int m){
        System.out.println("task14");        
        int b;
        if (n < m){
            b = n;
            n = m;
            m = b;
        }
        int[][] array = new int[n][m];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j>=i) array[i][j] = 1;
                else array[i][j] = 0;
                
            }
        }               
        printArray(array);
        
        System.out.println("==========================");
    
        ArrayList<Integer> al = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                al.add(array[j][i]);
            }
            Collections.shuffle(al);
            for (int j = 0; j < n; j++) {
                array[j][i] = al.get(j);
            }
            al.clear();
        }
        
        System.out.println();
        printArray(array);
    }

    public void task15(int n, int m){
        System.out.println("task15");        
        int[][] array = fillIntArray(n, m);
        printArray(array);
        System.out.println("==========================");
        int max = array[0][0];
        int index = 0;
        for (int i = 0; i < array.length; i++){
            for(int j = 0;  j < array[i].length; j++){
                if (array [i][j] > max){
                    max = array [i][j];
                }
            }
        }
        System.out.println("Max = " + max);
        System.out.println("==========================");
        for (int i = 0; i < array.length; i++){
            for(int j = 0;  j < array[i].length; j++){
                if (index % 2 == 0){
                    array [i][j] = max;
                    
                }
                index++;
            }
        } 
        printArray(array);
    }        
      
    public  void task16(int n) {
        System.out.println("task16"); 
        int[][] magicSquare = new int[n][n];
        int i = n / 2;
        int j = n - 1;

        for (int num = 1; num <= n * n;) {
            if (i == -1 && j == n){
                j = n - 2;
                i = 0;
            }
            else {
                if (j == n)
                    j = 0;
                if (i < 0)
                    i = n - 1;
            }
            if (magicSquare[i][j] != 0) {
                j -= 2;
                i++;
                continue;
            }
            magicSquare[i][j] = num++;
            j++;
            i--;        
        }
        printArray(magicSquare);
        
    }
}