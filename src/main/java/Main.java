import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ToyStore store = new ToyStore();
        store.addToy(new Toy(1, "Конструктор", 2, 20));
        store.addToy(new Toy(2, "Робот", 2, 20));
        store.addToy(new Toy(3, "Кукла", 6, 60));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в магазин игрушек!");
        int mode = 0;
        while(mode != 5){
            System.out.println("Выберите действие: ");
            System.out.println("1 - показать список игрушек");
            System.out.println("2 - добавить игрушку");
            System.out.println("3 - изменить вероятность выйгрыша игрушки");
            System.out.println("4 - запустить розыгрышь 10-ти игрушек");
            System.out.println("5 - закрыть программу");

            mode = scanner.nextInt();

            switch (mode){
                case 1:
                    System.out.println(store.infoToys());
                    break;
                case 2:
                    System.out.println("Введите название игрушки: ");
                    String name = scanner.next();
                    System.out.println("Введите количество игрушук: ");
                    int quantity = scanner.nextInt();
                    System.out.println("Введите вероятность выйгрыша: ");
                    double weight = scanner.nextDouble();
                    store.addToy(new Toy(
                            store.SearchNewId(),
                            name,
                            quantity,
                            weight));
                    System.out.println("Игрушка добавления.\n");
                    break;
                case 3:
                    System.out.println(
                            "Введите id игрушки для изменения вероятности выйгрышка: ");
                    Toy searchToy = store.SearchToy(scanner.nextInt());
                    System.out.println(
                            "Введите новое значение вероятности выйгрышка: ");
                    searchToy.setWeight(scanner.nextDouble());
                    break;
                case 4:
                    String str = "";
                    String info = "";
                    for(int i = 0; i < 10; i++){
                        str = store.drawToys();
                        System.out.println(str);
                        info = info + str + "\n";
                    }
                    FileDrawToys saveFile = new FileDrawToys(
                            "src/main/java/data.txt", info);
                    saveFile.writeFile();
                    break;
                case 5:
                    System.out.println("Завершение работы");
                    break;
                default:
                    System.out.println("Ошибка ввода!");
            }
        }
    }
}