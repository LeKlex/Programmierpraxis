
public class App {

    public static void main(String[] args) {

        Train train = new Train(new Locomotive(12.0, 12.0, 12));
        train.add(new PassengerCar(1.1, 1.1, 11));
        train.add(new DiningCar(3.3, 3.3, 100, false));
        train.add(new PassengerCar(2.2, 2.2, 22));
        train.add(new PassengerCar(4.2, 4.2, 44));
        train.hasOpenDiningCar();
        System.out.println(train.toString());

    }

}
