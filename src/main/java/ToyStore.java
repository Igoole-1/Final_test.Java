import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class ToyStore {
    private List<Toy> toys;
    private List<Toy> prizes;

    public ToyStore() {
        toys = new ArrayList<>();
        prizes = new ArrayList<>();
    }

    public void addNewToy(Toy toy) {
        toys.add(toy);
    }

    public void changeWeight(int id, double weight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(weight);
                return;
            }
        }
        System.out.println("Toy with ID " + id + " was not found.");
    }

    public Toy drawPrize() {
        double totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }
        double rand = Math.random() * totalWeight;
        for (Toy toy : toys) {
            if (rand < toy.getWeight()) {
                Toy prize = new Toy(toy.getId(), toy.getName(), 1, toy.getWeight());
                prizes.add(prize);
                toy.decreaseQuantity();
                return prize;
            }
            rand -= toy.getWeight();
        }
        return null;
    }

    public void writeLotteryResultToFile(String filename) {
        try {
            FileWriter writer = new FileWriter(filename);
            for (Toy prize : prizes) {
                writer.write(prize.getName() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}