import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Main {
    private static final List<String> buyers = List.of(
            "Tom",
            "Eva",
            "Adam",
            "Ron",
            "Felix",
            "Sam",
            "Anna",
            "Derek",
            "Don Carleone",
            "Bobby");

    public static void main(String[] args) {
        Queue<String> queue_1 = new ArrayDeque<>(5);
        Queue<String> queue_2 = new ArrayDeque<>(5);
        addRandomBuyer(queue_1);
        addRandomBuyer(queue_2);
        System.out.println("Первая очередь: " + queue_1);
        System.out.println("Вторая очередь: " + queue_2);
        System.out.println();

        add("Bella", queue_1, queue_2);
        System.out.println("Первая очередь: " + queue_1);
        System.out.println("Вторая очередь: " + queue_2);
        System.out.println();

        removeBuyer(queue_1, queue_2);
        System.out.println("Первая очередь: " + queue_1);
        System.out.println("Вторая очередь: " + queue_2);
    }

    private static void add(String name, Queue<String> queue_1, Queue<String> queue_2) {
        if (queue_1.size() == 5 && queue_2.size() == 5) {
            System.out.println("Сотрудник супермаркета вызывает Галю, которая может открыть дополнительную кассу");
            return;
        }
        if (queue_1.size() < queue_2.size()) {
            System.out.println("Покупатель " + name + " встал в первую очередь.");
            queue_1.offer(name);
        }
        if (queue_2.size() < queue_1.size()) {
            System.out.println("Покупатель " + name + " встал во вторую очередь.");
            queue_2.offer(name);
        }
        //Здесь хотел смоделировать выбор из двух равных очередей
        //Если обе очереди одинаковы, то покупатель выбирает любую случайным образом
        if (queue_1.size() == queue_2.size()) {
            int selectRandomQueue = 1 + (int) (Math.random() * 2);
            switch (selectRandomQueue) {
                case 1:
                    queue_1.offer(name);
                    System.out.println("Покупатель " + name + " встал в первую очередь.");
                    break;

                case 2:
                    queue_2.offer(name);
                    System.out.println("Покупатель " + name + " встал во вторую очередь.");
                    break;
            }
        }
    }

    public static void removeBuyer(Queue<String> queue_1, Queue<String> queue_2) {
        int selectRandomQueue = 1 + (int) (Math.random() * 2);
        switch (selectRandomQueue) {
            case 1:
                    queue_1.poll();
                    System.out.println("Покупатель ушел из кассы №1.");
                    break;

            case 2:
                    queue_2.poll();
                    System.out.println("Покупатель ушел из кассы №2.");
                    break;
        }
    }

    private static void addRandomBuyer(Queue<String> queue) {
        int size = 1 + (int) (Math.random() * 5);
        for (int i = 0; i < size; i++) {
            int index = (int) (Math.random() * buyers.size());
            queue.offer(buyers.get(index));
        }
    }
}
