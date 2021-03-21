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
public class OneArrays {
    
    private int[] fillIntArray(int n){
    
        int[] array = new int[n];
         
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 20);
        }
        return array;
    }   
    
    private double[] fillDoubleArray(int n){
    
        double[] array = new double[n];
         
        for (int i = 0; i < array.length; i++) {
            array[i] = (double)(Math.random() * 20) - 10;
        }
        return array;
    }   
    
    
    
    public void task1(int k){
        System.out.println("task1");
        int sum = 0;
        
        int[] array = fillIntArray(20);
        
        for (int i = 0; i < array.length; i++) {
            //System.out.println(array[i]);
            if (array[i] % k ==0){
            System.out.print(array[i] + " ");
                sum += array[i];  
            }
        }
        System.out.println();
        System.out.println(sum);
        
    }
    
    public void task2(int k){
        System.out.println("task2");
        int m = 0;
        
        double[] array = fillDoubleArray(20);
        for (int i = 0; i < array.length; i++) {
            if (array[i] > k){
                array[i] = k;
                m++;
            }
        }
        
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%.3f %n", array[i], " ");
        }
        
        System.out.println();
        System.out.println("Количество замен: " + m);
    }
    
    public void task3(int n){
        System.out.println("task3");
        int plus = 0;
        int minus = 0;
        int zero = 0;
        
        double[] array = fillDoubleArray(n);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0){
                zero++;
            }
            else if (array[i] < 0){
                minus++;
            }
            else {
                plus++;
            }
        }
        
        System.out.println("+: " + plus);
        System.out.println("0: " + zero);
        System.out.println("-: " + minus);
        
    }
    
    public void task4(int n){
        System.out.println("task4");
        double[] array = fillDoubleArray(n);
        double min = 0;
        double max = 0;
        int iMin = 0;
        int iMax = 0;
        
        
        
        
        for (int i = 0; i < array.length; i++) {
            System.out.printf ("%.3f %n", array[i]);
            if (array[i] > max){
                max = array[i];
                iMax = i;
            }
            else if (array[i] < min){
                min = array[i];
                iMin = i;       
            }
        }
        System.out.println("================");
        for (int i = 0; i < array.length; i++) {
            if (iMin == i){
                array[iMin] = max;
            }
            else if (iMax == i){
                array[iMax] = min;
            }
            
            System.out.printf ("%.3f %n", array[i]);
        }        
    }
    
    public void task5(int n){
        System.out.println("task5");
        
        int[] array = fillIntArray(10);
        
        for (int i = 0; i < array.length; i++){
            if (array[i] > i){
                System.out.print (array[i] + " ");
            }
        }
    }
    
    private boolean isPrime(int i){
        if (i < 2) return false;
        int temp;
        for (int k = 2; k <= i / 2; k++) {
            temp = i % k;
            if (temp == 0) {
                return false;
            }
        }
        return true;        
    }
    
    public void task6(int n){
        System.out.println("task5");
        double[] array = fillDoubleArray(n);  
        
        double sum = 0;
        for (int i = 1; i < array.length; i++){
            System.out.printf ("%.3f %n", array[i]);
                if (isPrime(i)) {
                sum+=array[i];
                }
        }
        System.out.println("==========");
        System.out.println(sum);
    }
    
    public void task7(int n){
        System.out.println("task7");
        double[] array = new double[n];

        for (int i = 0; i < array.length; i++) {
            array[i] = (double)(Math.random() * 20) - 10;
        }
        
        double maxSum = array[0] + array[array.length - 1];
        for (int i = 1; i < array.length / 2; i++) {
            if ((array[i] + array[array.length - i - 1]) > maxSum) {
                maxSum = array[i] + array[array.length - i - 1];
            }
        }
        
        System.out.println(maxSum);
        
    }
    
    public void task8(int n){
        System.out.println("task8");
        int[] array = fillIntArray(n);
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
            if (array[i] < min){
                min = array[i];
            }
        }
        System.out.println();
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != min){
                al.add(array[i]);
            }
        }
        System.out.println("===========");
        for(int i : al){
            System.out.print(i + " ");
        }
    }
    
    public void task9(int n){
        System.out.println("task9");
        int[] array = fillIntArray(n);        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < array.length; i++){
            System.out.print (array[i] + " ");
        }
        
        System.out.println ();
        System.out.println ("========");
        
        for(int i = 0; i < array.length; i++){
            if (!map.containsKey(array[i])){
                map.put(array[i], 1);
            }
            else {
                map.put(array[i], map.get(array[i]) + 1);
            }
        }   
        
        int max = 0;
        
        for (int i : map.keySet()){
            System.out.println(i + " " + map.get(i));
            int currVal = map.get(i);
            if (currVal > max){
                max = currVal;
            }
        }
        
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int i : map.keySet()){
            int currVal = map.get(i);
            if (currVal == max){
                al.add(i);
            }
        }
        
        int min = al.get(0);
        for (int i = 0; i < al.size(); i++){
            if (al.get(i) < min){
                min = al.get(i);
            }
        }
        System.out.println("=========");
        System.out.println(min);
        
    }
    
    public void task10(int n){
        System.out.println("task10");
        int[] array = fillIntArray(n);
        int pivot = (array.length + 1) / 2;
        
        for(int i = 0; i < array.length; i++){
            System.out.print (array[i] + " ");
        } 
        
        System.out.println ();
        System.out.println ("=======");
        
        for (int i = 1; i < pivot; i++) {
            array[i] = array[2 * i];
        }
        
        for (int i = pivot; i < array.length; i++) {
            array[i] = 0;
        }
        
        for(int i = 0; i < array.length; i++){
            System.out.print (array[i] + " ");
        } 
    }
}
