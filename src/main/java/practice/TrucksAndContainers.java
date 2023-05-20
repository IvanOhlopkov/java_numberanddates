package practice;

import java.util.Scanner;

public class TrucksAndContainers {
    public static final int BOXES_PER_CONTAINER = 27;
    public static final int CONTAINER_PER_TRUCK = 12;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //получение количество коробок от пользователя
        int boxes = scanner.nextInt();

        // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
        // пример вывода при вводе 2
        // для отступа используйте табуляцию - \t
        int containersCount = boxes / BOXES_PER_CONTAINER +
                (boxes % BOXES_PER_CONTAINER == 0 ? 0 : 1);
        int trucksCount = containersCount /  CONTAINER_PER_TRUCK +
                (containersCount % CONTAINER_PER_TRUCK == 0 ? 0 : 1);
        int container = 1;
        int box = 1;

        for (int truck = 1; truck <= trucksCount; truck++){
            System.out.println("Грузовик: " + truck);
            for (; container <= containersCount; container++){
                System.out.println("\tКонтейнер: " + container);
                for (; box <= boxes; box++){
                    System.out.println("\t\tЯщик: " + box);
                    if (box % BOXES_PER_CONTAINER == 0){
                        box = BOXES_PER_CONTAINER * container + 1;
                        break;
                    }
                }
                if (container % CONTAINER_PER_TRUCK == 0){
                container = CONTAINER_PER_TRUCK * truck + 1;
                break;
                }
            }

        }
        System.out.println("Необходимо:\nгрузовиков - " +
                trucksCount + " шт.\nконтейнеров - " +
                containersCount + " шт.");
        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */
    }

}
