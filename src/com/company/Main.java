package com.company;

import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
public static final int StartFloor = 0;
public static final int EndFloor = 25;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> qu = new PriorityQueue();
        System.out.println("Привет, на данный момент вы находитесь на 0-ом этаже.");

        while (true) {
            System.out.println("Введите номер этажа от 0 до 25 (Для завершения введите 0)");
            int floor;
         try{
             floor = sc.nextInt();
             if (floor < StartFloor || floor > EndFloor) {
                 System.err.println("Вы ввели  неправильный этаж, попробуйте снова");
                 continue;
             }
             qu.add(floor);
             if(floor == 0){
                 break;
             }
         }catch (InputMismatchException e) {
             System.err.println("Ошибка! Введите номер этажа");
             sc.nextLine();
            }
        }
        System.out.println();
        System.out.println("Лифт поехал!");

        while(!qu.isEmpty()){
            Integer floor = qu.poll();
            System.out.println("Этаж:"  + floor);

        }
        }
        }

