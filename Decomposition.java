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
public class Decomposition {
    public Decomposition (){}
    
    private int nod (int a, int b){
        if (a == 0) {
            return b;
        }        
        while (b != 0) {
        if (a > b)
            a = a - b;
        else
            b = b - a;
        }
        return a;
    }
    
    public void task1 (int a, int b){
        if (a == 0 && b == 0){
            System.out.println("Введите хотя бы одно не нулеваое числов");
        }
        int nok = a * b / nod(a, b);
        System.out.println("НОД = " + nod(a, b));
        System.out.println("НОК = " + nok);
    }
    
    public void task2 (int a, int b, int c, int d){
        if (a == 0 && b == 0 && c == 0 && d == 0){
            System.out.println("Введите хотя бы одно не нулеваое числов");
        }
        int nodAB = nod(a, b);
        int nodCD = nod(c, d);
        int nodABCD = nod(nodAB, nodCD);
        System.out.println("НОД = " + nodABCD);
    }
    
    private double sTreug(int a){
        return (double)a * a * Math.sqrt(3)/4;
    }
    
    public void task3 (int a){
        DecimalFormat df = new DecimalFormat("#.##");
        if (a <= 0){
            System.out.println("Введите натуральное число");
        }        
        System.out.println("Площадь шестиугольника со стороной" +
                    a + " равна: " + df.format(sTreug(a) * 6));
    }
    
    private int randomValue(){
        return (int)(Math.random() * 10);
    }
    
    private void printPoint(ArrayList<Integer> x, ArrayList<Integer> y){
        for (int i = 0; i < x.size(); i++ ){
            System.out.print("(" + x.get(i) + "; " + y.get(i) + ") ");
        }
        System.out.println();
    }  
    
    private void printPoint(int x,int y){
            System.out.println("(" + x + "; " + y + ")");
    }  
    
    private double distance(int x1, int y1, int x2, int y2){
        return (double) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    } 
    
    private HashMap<Integer, List<Double>> distanceAll (ArrayList<Integer> x, ArrayList<Integer> y){
        HashMap<Integer, List<Double>> map = new HashMap<Integer, List<Double>>();              
        for (int i = 0; i < x.size(); i++ ){
            ArrayList list = new ArrayList<Double>();  
            for (int k = 0; k < x.size(); k++){
                list.add(distance(x.get(i), y.get(i), x.get(k), y.get(k)));
            }
            System.out.println("Точка " + (i + 1) + ": " + list);
            map.put(i, list);
        }
        return map;
    }
    
    private double maxDistanceInList(List<Double> list){
        double max = list.get(0);
        for (double i : list){
            if (i > max){
                max = i;                
            }
        }  
        return max;
    }
    
    private int getIndexFirstPoint(HashMap<Integer, List<Double>> map){
        double max = map.get(0).get(0);
        int indexFirstPoint = 0;
        for (int i : map.keySet()){
            double currDistance = maxDistanceInList(map.get(i));
            if (currDistance > max){
                indexFirstPoint = i;
                max = currDistance;
            }
        }
        return indexFirstPoint;
    }
    
    private int getIndexSecondPoint(List<Double> list){
        double max = list.get(0);
        int index = 0;
        int k = 0;
        for (double i : list){
            if (i > max){
                max = i; 
                index = k;
            }
            k++;
        }  
        return index;
    }
    
    
    public void task4 (int n){
        ArrayList<Integer> x = new ArrayList<Integer>();
        ArrayList<Integer> y = new ArrayList<Integer>();
        for (int i = 0; i < n; i++ ){
            x.add(randomValue());
            y.add(randomValue());           
        }
        printPoint(x, y);
        HashMap<Integer, List<Double>> map = distanceAll(x, y);
        int indexFirstPoint = getIndexFirstPoint(map);
        int indexSecondPoint = getIndexSecondPoint(map.get(indexFirstPoint));
        System.out.println("Самое большое растояние между точками: ");
        printPoint(x.get(indexFirstPoint), y.get(indexFirstPoint));
        printPoint(x.get(indexSecondPoint), y.get(indexSecondPoint));
    }
    
    private ArrayList<Integer> fillIntArray(int n){    
        ArrayList<Integer> array = new ArrayList<Integer>();         
        for (int i = 0; i < n; i++) {
            array.add((int)(Math.random() * 20));
        }
        return array;
    } 
    
    private ArrayList<Integer> sortArray(ArrayList<Integer> array){      
        int temp;
        for (int i = 0; i < array.size(); i++){
            for (int k = 0; k < array.size() - 1; k++){
                if (array.get(k) > array.get(k + 1)){
                    temp = array.get(k);
                    array.set(k, array.get(k + 1));
                    array.set(k + 1, temp);
                }
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
    
    public void task5 (int n){
        ArrayList<Integer> array = fillIntArray(n);
        print(array);
        array = sortArray(array);
        print(array);
        System.out.println("Второе по величине число: " + array.get(array.size() - 2));       
    }
    
    public void task6 (int a, int b, int c){
        int[] array = new int[3];
        array[0] = a;
        array[1] = b;
        array[2] = c;
        int modMax = 0;
        for (int i = 0; i < array.length; i++){
            for (int k = 0; k < array.length; k++){
                if (i != k){
                    int modCurr = nod(array[i], array[k]);
                    if (modCurr > modMax){
                        modMax = modCurr;
                    }
                }
            }
        }
        
        if (modMax != 1){
            System.out.println("Числа не взаимно простые");
        }
        else {
            System.out.println("Числа взаимнопростые");
        }
    }

    private int factorial (int i){
        int proizv = 1;
        for (int k = 1; k <= i; k++){
            proizv *= k;
        }
        return proizv;
    }
    
    public void task7 (){
        int sum = 0;
        for (int i = 1; i <= 9; i += 2){
            sum += factorial(i);
        }
        System.out.println("Сумма факториалов от 1 до 9 = " + sum);
    } 
    
    public void task8 (int k, int m){
        ArrayList<Integer> array = fillIntArray(6);
        print(array);
        int sum = 0;
        if (m - k + 1 != 3){
            System.out.println("Введите 3 числа от 1 до 6, например: '3, 5'");
        }
        else {
            for (int i = 0; i < array.size(); i++){
                if (i >= k - 1 && i <= m - 1){
                    sum += array.get(i);
                }
            }
            System.out.println("Сумма чисел = " + sum);
        }        
    }
    
    private int getSide(int z, int t){
        if (z > t && z > 0){
            return z;
        }
        else if (t > 0){
            return t;
        }
        else {
            return -1;
        }
    }
    
    public void task9 (int x, int y, int z, int t){
        double sXYZT;
        if (x > 0 && y > 0){
            sXYZT = (x + getSide(z, t)) / 2 * y;
            System.out.println("Площадь четырёх угольника = " + sXYZT);
        }
        else {
            System.out.println("Введите натуральные числа");
        }        
    }
    
    private int[] getValue(int value){
        int[] array = new int[2];
        array[0] = value / 10;
        array[1] = value % 10;
        return array;
    }
    
    private ArrayList<Integer> arrayRightOrder(ArrayList<Integer> array){
        ArrayList<Integer> arrayRightOrder = new ArrayList<Integer>();
        for (int i : array){
            arrayRightOrder.add(0, i);
        }
        return arrayRightOrder;
    }
    
    private ArrayList<Integer> getArray (int n){
        ArrayList<Integer> array = new ArrayList<Integer>();
        int wholePart = n;
        while(true){            
            if (wholePart > 0){
                array.add(getValue(wholePart)[1]);
            }
            else {
                break;
            }
            wholePart = getValue(wholePart)[0];
        }
        return arrayRightOrder(array);
    }
    
    public void task10(int n){
        ArrayList<Integer> array = getArray(n);
        System.out.println("Вы ввели: " + n);
        print(array);
    }
    
    public void task11 (int n, int k){
        ArrayList<Integer> arrayN = getArray(n);
        ArrayList<Integer> arrayK = getArray(k);        
        System.out.println("Вы ввели числа: " + n + " и " + k);
        if (arrayN.size() > arrayK.size()){
            System.out.println("Цифр больше в " + n);
        }
        else if (arrayK.size() > arrayN.size()){
            System.out.println("Цифр больше в " + k);          
        }
        else {
            System.out.println("В числах одинаковое количество цифр"); 
        }
    }
    
    private int getSumArray (ArrayList<Integer> array){
        int sum = 0;
        for (int i : array){
            sum += i;
        }
        return sum;
    }
    
    private void printArray(ArrayList<Integer> al){        
        int k = 1;
        for (int i : al){           
            System.out.print(i + " ");
            if (k == 15){
                System.out.println();
                k = 0;
            }
            k++;
        }
        System.out.println();
    }    
    
    public void task12(int k, int n){
        ArrayList<Integer> arrayRightValue = new ArrayList<Integer>();
        for (int i = 0; i < n; i++){
            ArrayList<Integer> array = getArray(i);
            if (getSumArray(array) == k){
                arrayRightValue.add(i);
            }
        }
        printArray(arrayRightValue);
    }
    
    private boolean isPrime(int number){
        int k = 0;
        for (int i = 2; i < number; i++){
            if (number % i == 0){
                k++;
            }
        }
        if (k ==0){
            return true;
        }
        else {
            return false;
        }
    }
    
    public void task13 (int n){
        for (int i = n; i <= 2*n - 2; i++){
            if (isPrime(i) && isPrime(i + 2)){
                System.out.println("Пара простых чисел: " + i + " " + (i + 2) + " является 'близнецами'");
            }
        }
    }
    
    private int getSumNumberWithPowerN (ArrayList<Integer> array){
        int sum = 0;
        for (int i : array){
            sum += Math.pow(i, array.size());
        }
        return sum;
    }
    
    public void task14 (int k){
        //Ошибка в условии задачи 
        if (k < 1){
            System.out.println("Введите натурально число");        
        }
        else{
            for (int i = 1; i <= k; i++){
                ArrayList<Integer> array = getArray(i);
                if (getSumNumberWithPowerN(array) == i){
                    System.out.println("Число " + i + " является числом 'Армстронга'");
                }
            }
        }
    }
    
    private boolean isIncreasingSequence (ArrayList<Integer> array){
        int inc = array.get(1) - array.get(0);
        int isIncreasing = 0;
        for (int i = 0; i < array.size() - 1; i++){
            if (inc > 0 && array.get(i) + inc == array.get(i + 1)){
                isIncreasing++;
            }
        }
        if (isIncreasing + 1 == array.size()){
            return true;
        }
        else {
            return false;
        }
    }
    
    public void task15 (int n){
        for (int i = (int)Math.pow(10, n - 1); i < Math.pow(10, n); i++){
            ArrayList<Integer> array = getArray(i);
            if (isIncreasingSequence(array)){
                System.out.println("Цифры числа: " + i + " образуют "
                        + " возрастающую прогрессию");
            }
        }
    }
    
    private boolean isArrayWithOddNumbers (ArrayList<Integer> array){
        int countOdd = 0;
        for (int number : array){
            if (number % 2 == 1){
                countOdd++;
            }
        }
        if (countOdd == array.size()){
            return true;
        }
        else {
            return false;
        }
    }
    
    private int countEvenNumbers(ArrayList<Integer> array){
        int countEvenNumbers = 0;
        for (int i : array){
            if (i % 2 == 0){
                countEvenNumbers++;
            }
        }
        return countEvenNumbers;
    }
    
    public void task16 (int n){
        ArrayList<Integer> arrayOnlyOddNumbers = new ArrayList<Integer>();
        for (int i = (int)Math.pow(10, n - 1) + 1; i < Math.pow(10, n); i += 2){
            ArrayList<Integer> array = getArray(i);
            if (isArrayWithOddNumbers(array)){
                arrayOnlyOddNumbers.add(i);
            }
        }
        printArray(arrayOnlyOddNumbers);
        int sumArrayWithOddNumbers = getSumArray(arrayOnlyOddNumbers);
        System.out.println("Сумма массива: " + sumArrayWithOddNumbers); 
        int count = countEvenNumbers(getArray(sumArrayWithOddNumbers));
        System.out.println("Количество чётных цифр в сумме: " + count);      
    }
    
    public void task17 (int n){
        int inc = 0; 
        System.out.println("Число: " + n);
        while(n != 0){
            ArrayList<Integer> array = getArray(n);
            int sum = getSumArray(array);
            n = n - sum;           
            inc++;
            System.out.println(inc + ": " + n);
        }
       System.out.println("Количество действий: " + inc);        
    }
    
    
}
