public class Main {
    public static void main(String[] args) {
        ToyStore store = new ToyStore();

        store.addNewToy(new Toy(1, "Кукла", 10, 50));
        store.addNewToy(new Toy(2, "Машинка", 20, 30));
        store.addNewToy(new Toy(3, "Мячик", 15, 20));
        store.addNewToy(new Toy(4, "Кубик-Рубик", 5, 10));
        store.addNewToy(new Toy(5, "Самолетик", 7, 17));
        store.changeWeight(1, 40);
        store.changeWeight(2, 10);
        for (int i = 0; i < 10; i++) {
            Toy prize = store.drawPrize();
            if (prize != null) {
                System.out.println("Вы выиграли: " + prize.getName());
            }
        }
        store.writeLotteryResultToFile("Toys.txt");
    }
}