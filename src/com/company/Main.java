package com.company;

import java.util.*;

public class Main {
    public static final int StartFloor = 0;
    public static final int EndFloor = 25;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> floors = new ArrayDeque<>();
        floors.add(0);

        System.out.printf("Привет, вы начинаете с: %d этажа\n", floors.getFirst());
        int waitDoorsInSeconds = 10;
        int waitMoveInSeconds = 5;

        while (true) {
            System.out.println("Введите номер этажа (для завершения введите 0)");
            String input = scanner.nextLine();
            int x = Integer.parseInt(input);
            if (x > EndFloor || x < StartFloor) {
                System.err.println("Такого этажа нет!");
            } else if (x == 0) {
                System.out.println("Лифт поехал:");
                floors.poll();
                System.out.println("Этажи: " + floors);

                int previousFloor = -1;
                int totalSeconds = 0;
                while (floors.size() > 0) {
                    int currentFloor = floors.remove();
                    if (previousFloor != -1) {
                        totalSeconds += Math.abs(currentFloor - previousFloor) * waitMoveInSeconds;
                        totalSeconds += waitDoorsInSeconds;
                    }
                    previousFloor = currentFloor;
                }
                System.out.println("Время затраченное лифтом на маршрут: " + totalSeconds + " с.");
                break;
            } else {
                floors.add(x);
            }
        }
    }
}



