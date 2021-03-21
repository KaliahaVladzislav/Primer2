/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.algorithmization;
import java.util.*;
import java.text.DecimalFormat;
/**
 *
 * @author Владислав
 */
public class Sorting {
    private ArrayList<Integer> fillIntArray(int n){    
        ArrayList<Integer> array = new ArrayList<Integer>();         
        for (int i = 0; i < n; i++) {
            array.add((int)(Math.random() * 20));
        }
        return array;
    }   
    
    private int[] fillIntArrayN(int n){    
        int[] array = new int[n];         
        for (int i = 0; i < n; i++) {
            array[i] = (int)(Math.random() * 10) + 1;
        }
        return array;
    } 
    
    private double[] fillDoubleArray(int n){    
        double[] array = new double[n];         
        for (int i = 0; i < n; i++) {
            array[i] = ((double)(Math.random() * 20));
        }
        return array;
    } 

    private double[] fillDoubleArrayNonDecreasing(int n){    
        double[] array = new double[n];         
        for (int i = 0; i < n; i++) {
            if (i == 0){
                array[i] = (double)(Math.random() * 20) - 10;
            }
            else {
                double currRandValue = (double)(Math.random() * 20) - 10;
                while(array[i - 1] > currRandValue){
                    currRandValue  = (double)(Math.random() * 20) - 10;
                }
                array[i] = currRandValue;
            }             
        }
        return array;
    } 
    
    private ArrayList<Integer> fillIntArrayNonDecreasing(int n){    
        ArrayList<Integer> array = new ArrayList<Integer>();         
        for (int i = 0; i < n; i++) {
            if (i == 0){
                array.add((int)(Math.random() * 200) - 100);
            }
            else {
                int currRandValue = (int)(Math.random() * 800) - 400;
                while(array.get(i - 1) > currRandValue){
                    currRandValue  = (int)(Math.random() * 800) - 400;
                }
                array.add(currRandValue);
            }    
        }
        return array;
    }   
    
    private void print(ArrayList<Integer> al){
        al.forEach(i -> {
            System.out.print(i + " ");
        });
        System.out.println();
    }
    
    private void print(double[] al){
        DecimalFormat df = new DecimalFormat("#.##");
        for (double i : al) {
            System.out.print(df.format(i) + " ");
        }
        System.out.println();
    }
    
    private void print(int[] al){
        for (int i : al) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
    
    public void task1(int n, int m, int k){
        ArrayList<Integer> arrayN = fillIntArray(n);
        ArrayList<Integer> arrayM = fillIntArray(m);
        print(arrayN);
        print(arrayM);
        if (k > arrayN.size()){
            System.out.println("Значение 'k' превосходим длинну первого массива:("); 
        }
        else{
            for (int i = arrayM.size()-1; i >= 0; i-- ){
                arrayN.add(k, arrayM.get(i));
            }
        }        
        print(arrayN);
        
    }
    
    private void getUnionArray (ArrayList<Integer> alWithMaxValue, ArrayList<Integer> alSmal){
        int k = 0;
        for (int i = 0; i < alWithMaxValue.size(); i++){
                while (k < alSmal.size() && alWithMaxValue.get(i) > alSmal.get(k)){
                        alWithMaxValue.add(i, alSmal.get(k));        
                        k++;
                }
            }           
        print(alWithMaxValue);
    }
    
    private int findMaxValue(ArrayList<Integer> al){
        int value = al.get(0);
        for (int i : al){
            if (i > value){
                value = i;
            }
        }
        return value;
    }
    
    private int findMinValue(ArrayList<Integer> al){
        int value = al.get(0);
        for (int i : al){
            if (i < value){
                value = i;
            }
        }
        return value;
    }
    
    public void task2(int n, int m){
        ArrayList<Integer> arrayN = fillIntArrayNonDecreasing(n);
        ArrayList<Integer> arrayM = fillIntArrayNonDecreasing(m);
        print(arrayN);
        print(arrayM);
        int valueN = findMaxValue(arrayN);
        int valueM = findMaxValue(arrayM);
        if (valueN > valueM){
            getUnionArray(arrayN, arrayM);
        }
        else {
            getUnionArray(arrayM, arrayN);
        }       
    }
    
    public void task3(int n){
        ArrayList<Integer> array = fillIntArrayNonDecreasing(n);
        print(array);
        int maxValue;
        int indexMaxValue;
        for (int i = 0; i < array.size()/2; i++){            
            maxValue = array.get(array.size() - 1 - i);
            indexMaxValue = array.size() - 1 - i;
            int temp = maxValue;
            array.set(indexMaxValue, array.get(i));
            array.set(i, temp);
        }
        print(array);        
    }
    
    public void task4(int n){
        ArrayList<Integer> array = fillIntArray(n);
        print(array);
        int valueI;
        int indexI;
        int temp;
        int count = 0;
        for (int i = 0; i < array.size(); i++){
            for (int k = 1; k < array.size(); k++){
                int valueK = array.get(k);
                valueI = array.get(k - 1);
                indexI = k - 1;
                if (valueI > valueK){
                    temp = valueK;
                    array.set(k, valueI);
                    array.set(indexI, temp);
                    count++;
                }
            }
        }
        print(array);
        System.out.println("Количество перестановок: " + count);
    } 
    
    public int binarySearch(ArrayList<Integer> sortedArray, int key) {
        int index = -1;
        int low  = 0;
        int high = sortedArray.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray.get(mid) < key){
                if (sortedArray.size() != mid + 1 && sortedArray.get(mid + 1) > key){
                    return mid + 1;
                }
                else if (sortedArray.size() == mid + 1){
                    return mid + 1;
                }
                else {
                    low = mid + 1;
                }                
            } 
            else if (sortedArray.get(mid) > key) {
                if (mid != 0 && sortedArray.get(mid - 1) < key){
                    return mid;
                }
                else if (mid == 0) {
                    return mid;
                }  
                else {
                    high = mid - 1;
                }
            } 
            else {
                return mid;
            }       
        }
        return 0;
    }
    
    public void task5(int n){
        ArrayList<Integer> array = fillIntArray(n);
        print(array);
        ArrayList<Integer> sortedArray = new ArrayList<Integer> ();
        sortedArray.add(Math.min(array.get(0), array.get(1)));
        sortedArray.add(Math.max(array.get(1), array.get(0)));
        
        for (int i = 2; i < array.size(); i++){
            int index = binarySearch(sortedArray, array.get(i));
            sortedArray.add(index, array.get(i));
        }        
        print(sortedArray);
    }
    
    public void task6(int n){
        double[] array = fillDoubleArray(n);        
        print(array);
        double temp;
        for (int i = 0; i < array.length; i++){
            for (int k = 0; k < array.length - 1; k++){
                if (array[k] > array[k + 1]){
                    temp = array[k];
                    array[k] = array[k + 1];
                    array[k + 1] = temp;
                }
            }
        }        
        print(array);
    } 

    public int binarySearch(double[] sortedArray, double key) {
        int index = -1;
        int low  = 0;
        int high = sortedArray.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] < key){
                if (sortedArray.length != mid + 1 && sortedArray[mid + 1] > key){
                    return mid + 1;
                }
                else if (sortedArray.length == mid + 1){
                    return mid + 1;
                }
                else {
                    low = mid + 1;
                }                
            } 
            else if (sortedArray[mid] > key) {
                if (mid != 0 && sortedArray[mid - 1] < key){
                    return mid;
                }
                else if (mid == 0) {
                    return mid;
                }  
                else {
                    high = mid - 1;
                }
            } 
            else {
                return mid;
            }       
        }
        return 0;
    }
    
    public void task7(int n, int m){
        DecimalFormat df = new DecimalFormat("#.##");
        double[] arrayFirst = fillDoubleArrayNonDecreasing(n);        
        print(arrayFirst);
        double[] arraySecond = fillDoubleArrayNonDecreasing(m);        
        print(arraySecond);
        int k = 0;
        for (double i : arraySecond){ 
            int needPossition = binarySearch(arrayFirst, i) + k;
            System.out.println("Элемент: " + df.format(i) + " позиция: " + needPossition);
            k++;
        }
    } 

    public int nok(int x, int n){     
        int j;
        if (x < n) {
            j = n;
        }
        else {
            j=x;
        }
        while (true){        
            if ((j % x == 0) && (j % n == 0)) {
                break;
            }
            else j+=1;
        }
        return j; 
    }     
    
    public void sortArray(int[] array){       
        int temp;
        for (int i = 0; i < array.length; i++){
            for (int k = 0; k < array.length - 1; k++){
                if (array[k] > array[k + 1]){
                    temp = array[k];
                    array[k] = array[k + 1];
                    array[k + 1] = temp;
                }
            }
        }        
        print(array);
    } 
    
    public void task8(int n){
        //DecimalFormat df = new DecimalFormat("#.##");
        int[] arrayP = fillIntArrayN(n);
        int[] arrayQ = fillIntArrayN(n);
        print(arrayP);
        print(arrayQ);
        int nok = nok(arrayQ[0], arrayQ[1]);        
        for (int i = 2; i < arrayQ.length; i++){
            nok = nok(arrayQ[i], nok);
        }
        System.out.println("Наименьшее общее кратное: " + nok);
        for (int i = 0; i < arrayQ.length; i++){
            arrayP[i]= arrayP[i] * nok / arrayQ[i];
            arrayQ[i] = nok;
        }
        
        sortArray(arrayP);
        print(arrayQ);
        //System.out.println("Элемент: " + df.format(i) + " позиция: " + needPossition);
            

    }
}
