import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyStore {
    private List<Toy> toys;

    public ToyStore() {
        toys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public String infoToys() {
        String str = String.format(
                "%5s %20s %10s %30s",
                "id", "Название игрушки", "Кол-во", "Вероятность выйгрыша, %") + "\n";
        for (Toy toy : toys) {
            str = str + String.format(
                    "%5s %20s %10s %30s",
                    toy.getId(),
                    toy.getName(),
                    toy.getQuantity(),
                    toy.getWeight())
                    + "\n";
        }
        return str;
    }

    public int SearchNewId() {
        int id = 0;
        for (Toy toy : toys) {
            if (toy.getId() > id) id = toy.getId();
        }
        return ++id;
    }

    public Toy SearchToy(int id) {
        for (Toy toy : toys) {
            if (toy.getId() == id) return toy;
        }
        return null;
    }

    public String drawToys() {

        if (toys.isEmpty()) {
            return "Игрушек нет";
        }

        double sumWeight = 0;
        for (Toy toy : toys) {
            sumWeight += toy.getWeight();
        }

        Random random = new Random();
        double randomNumber = random.nextDouble() * sumWeight;

        double currentWeight = 0;
        for (Toy toy : toys) {
            currentWeight += toy.getWeight();
            if (randomNumber <= currentWeight) {
                if (toy.getQuantity() > 0) {
                    toy.setQuantity(toy.getQuantity() - 1);
                    return "Поздравляем! Вы выйграли игрушку: " + toy.getName();
                } else {
                    return "Поздравляем! Вы выйграли игрушку: " + toy.getName()
                            + " (Игрушки нет в наличии!)";
                }
            }
        }
        return "Ничего не выйграли.";
    }
}
