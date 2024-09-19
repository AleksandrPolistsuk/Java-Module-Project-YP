import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
      CarRace carRaces = new CarRace();
      carRaces.start();
      carRaces.displayWinner();
    }
}
class CarRace {
    Scanner scanner = new Scanner(System.in);
    ArrayList <Car> carList = new ArrayList<>();
    String leadingCar = ""; // строка для победителя
    int maxDistance = 0; // строка для пройденой дистанции
    // Метод расчета дистанции и сохранения лучших данных
    public void distance(String nameCar, int speedCar) {
        int distance = speedCar * 24;
        if (distance > maxDistance) {
            leadingCar = nameCar;
            maxDistance = distance;
        }
    }
    // Метод объявлния победителя, если поле не пустое
    public void displayWinner() {
        if (!leadingCar.isEmpty()) {
            System.out.println("Наш победитель " + leadingCar + " проехал дистанцию " + maxDistance + " км");
        } else {
            System.out.println("Нет данных о победителе.");
        }
    }
    // метод сбора данных и передачи их
public void start () {
    System.out.println("Добро пожаловать на гонку 24 часа Ле-Мана!");
    System.out.println("Для начала гонки, введите название и скорость 3 автомобилей.");
    for (int i=1;i<=3;i++){
        System.out.println("Введите название автомобиля номер " +i +":");
        String nameCar = scanner.nextLine();
        int speedCar;
        while (true) {
            System.out.println("Введите скорость (от 0 до 250) автомобиля номер " + i + ":");
            String input = scanner.nextLine();  // считываем ввод как строку

            try {
                               speedCar = Integer.parseInt(input);

                if (speedCar >= 0 && speedCar <= 250) {
                    break;
                } else {
                    System.out.println("Скорость должна быть в диапазоне от 0 до 250. Попробуйте снова.");
                }
            } catch (NumberFormatException e) {
              System.out.println("Скорость введена некорректно. Пожалуйста, введите целое число от 0 до 250.");
            }
        }
        carList.add(new Car(nameCar, speedCar));
        distance(nameCar, speedCar);
    }
   scanner.close();
}
}
// обьект Car, который имеет название и скорость.
class Car {
    String name;
    int speed;
    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }}