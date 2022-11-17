import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static Queue<String> kassa_1 = new LinkedList<>();
    static Queue<String> kassa_2 = new LinkedList<>();
    static Queue<String> kassa_3 = new LinkedList<>();
    static LinkedList<String> buyersList_1 = new LinkedList<>();
    static LinkedList<String> buyersList_2 = new LinkedList<>();


    public static void main(String[] args) {
        buyersList_1.add("Tom");
        buyersList_1.add("Eva");
        buyersList_1.add("Adam");
        buyersList_1.add("Ron");
        buyersList_1.add("Felix");

        buyersList_2.add("Sam");
        buyersList_2.add("Anna");
        buyersList_2.add("Derek");
        buyersList_2.add("Don Carleone");

        kassa_1 = buyersList_1;
        kassa_2 = buyersList_2;

        String newBuyer_1 = "Ivan";

        addToSmallQueue(kassa_1, kassa_2, newBuyer_1);

        String newBuyer_2 = "Mike";

        addToSmallQueue(kassa_1, kassa_2, newBuyer_2);

        String newBuyer_3 = "Linda";

        addToSmallQueue(kassa_1, kassa_2, newBuyer_3);

        String newBuyer_4 = "Frank";

        addToSmallQueue(kassa_1, kassa_2, newBuyer_4);
    }

    public static void addToSmallQueue(Queue<String> kassa_1, Queue<String> kassa_2, String newBuyer) {
        System.out.println("kassa_1.size() = " + kassa_1.size());
        System.out.println("kassa_2.size() = " + kassa_2.size());
        System.out.println("kassa_3.size() = " + kassa_3.size());
        System.out.println("Покупатель " + newBuyer);

        if (kassa_1.size() == 5 && kassa_2.size() == 5) {
            if (kassa_3.size() == 0) {
                System.out.println("Кассир вызывает Галю, которая открыла дополнительную кассу");
            }
        }

        if (kassa_1.size() < 5 && kassa_1.size() < kassa_2.size()) {
            System.out.println(newBuyer + " выбрал кассу №1");
            kassa_1.add(newBuyer);
            return;
        }
        if (kassa_2.size() < 5 && kassa_2.size() < kassa_1.size()) {
            System.out.println(newBuyer + " выбрал кассу №2");
            kassa_2.add(newBuyer);
            return;
        }

        if (kassa_3.size() < 5 && (kassa_3.size() < kassa_1.size() || kassa_3.size() < kassa_2.size())) {
            System.out.println(newBuyer + " выбрал кассу №3");
            kassa_3.add(newBuyer);
        }
    }
}
