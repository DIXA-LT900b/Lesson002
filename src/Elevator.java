import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Elevator {
    ArrayDeque<Integer> floorsList = new ArrayDeque<>();
    Scanner scanner = new Scanner(System.in);
    int nextFloor;

    Elevator(){
        while(true){
            nextFloor = showDialog();

            if (nextFloor != 0 ){
                floorsList.offer(nextFloor);
            } else {
                break;
            }
        }

        System.out.println();
        showQueue();
    }


    private Integer showDialog(){
        int floor = -1;
        while (floor == -1) {

            System.out.println("Ожидаю ввода этажа: (для завершения введите 0)");
            floor = scanner.nextInt();

            if (floor < 0 || floor > 25) {
                System.out.println("Такого этажа нет в доме");
                System.out.println();
                floor = -1;
            }
        }
        return floor;

    }
    private void showQueue(){
        int lastFloor = -1;
        int currentFloor = -1;
        int MOVE_TIME = 5;
        int STAY_TIME = 10;
        int totalTime = 0;

        System.out.println("Лифт проследовал по следующим этажам:");

        while (!floorsList.isEmpty()){
            lastFloor = currentFloor;
            currentFloor = floorsList.poll();

            if (lastFloor != -1) {
                totalTime += Math.abs(lastFloor - currentFloor) * MOVE_TIME + STAY_TIME;
            }
            System.out.print("Этаж " + currentFloor + " -> ");
        }

        // Считаем спуск с последнего введенного этажа до "Этажа 0" + Открытие дверей 10 сек.
        totalTime += Math.abs(currentFloor - 0 ) * MOVE_TIME + STAY_TIME;

        System.out.println("Этаж 0");
        System.out.println("Перемещения лифта заняли " + totalTime + " секунд.");
    }

}
