package kareta.laboratoryworks.lab4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Subscriber[] subscribers = inputSubscribers();
        printSubscribers(subscribers);
    }

    public static Subscriber[] inputSubscribers() {
        Scanner reader = new Scanner(System.in);

        System.out.println("How many subscribers do you want to input?");
        int subscriberNumber = Integer.parseInt(reader.nextLine());
        Subscriber[] subscribers = new Subscriber[subscriberNumber];

        for (int i = 0; i < subscriberNumber; i++) {
            subscribers[i] = inputSubscriber(reader);
        }
        return subscribers;
    }

    public static Subscriber inputSubscriber(Scanner reader) {
        System.out.println("Name:");
        String name = reader.nextLine();

        System.out.println("Surname:");
        String surname = reader.nextLine();

        System.out.println("Country:");
        String country = reader.nextLine();

        System.out.println("City:");
        String city = reader.nextLine();

        System.out.println("Street:");
        String street = reader.nextLine();

        System.out.println("Building:");
        String building = reader.nextLine();

        System.out.println("City talks time in seconds:");
        long cityTalksSeconds = Long.parseLong(reader.nextLine());

        System.out.println("Intercity talks time in seconds:");
        long intercityTalksSeconds = Long.parseLong(reader.nextLine());

        Address address = new Address(country, city, street, building);
        Subscriber subscriber = new Subscriber(name, surname, address);
        subscriber.setCityTalkSeconds(cityTalksSeconds);
        subscriber.setIntercityTalkSeconds(intercityTalksSeconds);

        return subscriber;
    }

    public static void printSubscribers(Subscriber[] subscribers) {
        System.out.println("\nList of all subscribers:");
        for (Subscriber subscriber : subscribers) {
            System.out.println(subscriber);
        }
    }
}
