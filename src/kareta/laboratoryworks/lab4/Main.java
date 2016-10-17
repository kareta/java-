package kareta.laboratoryworks.lab4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Subscriber[] subscribers = inputSubscribers();

        if (subscribers == null) {
            System.out.println("There are no subscribers.");
            return;
        }

        printSubscribers(subscribers);

        long cityTalksLimit = inputCityTalksLimit();
        printSubscribers(subscribers, cityTalksLimit);

        printUsedIntercityTalks(subscribers);
    }

    public static long inputCityTalksLimit() {
        Scanner reader = new Scanner(System.in);
        System.out.println("City talks time limit:");

        long cityTalksLimit = 0;
        boolean correct = false;
        while (!correct) {
            try {
                cityTalksLimit = Long.parseLong(reader.nextLine());
                correct = true;
            } catch (Exception e) {
                System.out.println("Wrong city talks limit. Try again.");
            }
        }

        return cityTalksLimit;
    }

    public static Subscriber[] inputSubscribers() {
        Scanner reader = new Scanner(System.in);

        System.out.println("How many subscribers do you want to input?");
        int subscriberNumber = Integer.parseInt(reader.nextLine());

        if (subscriberNumber <= 0) {
            return null;
        }

        Subscriber[] subscribers = new Subscriber[subscriberNumber];

        for (int i = 0; i < subscriberNumber; i++) {
            try {
                subscribers[i] = inputSubscriber(reader);
            } catch (AddressException | SubscriberException e) {
                System.out.println(e.getMessage());
                System.out.println("Try again");
                i--;
            } catch (Exception e) {
                System.out.println("Wrong data. Try again.");
                i--;
            }
        }
        return subscribers;
    }

    public static Subscriber inputSubscriber(Scanner reader) throws Exception {

        System.out.println("Name:");
        String name = reader.nextLine();
        SubscriberValidator.verifyName(name);

        System.out.println("Surname:");
        String surname = reader.nextLine();
        SubscriberValidator.verifySurname(surname);

        System.out.println("Country:");
        String country = reader.nextLine();
        AddressValidator.verifyCountry(country);

        System.out.println("City:");
        String city = reader.nextLine();
        AddressValidator.verifyCity(city);

        System.out.println("Street:");
        String street = reader.nextLine();
        AddressValidator.verifyStreet(street);

        System.out.println("Building:");
        String building = reader.nextLine();
        AddressValidator.verifyBuilding(building);

        System.out.println("City talks time in seconds:");
        long cityTalksSeconds = Long.parseLong(reader.nextLine());
        SubscriberValidator.verifyCityTalkSeconds(cityTalksSeconds);

        System.out.println("Intercity talks time in seconds:");
        long intercityTalksSeconds = Long.parseLong(reader.nextLine());
        SubscriberValidator.verifyIntercityTalkSeconds(intercityTalksSeconds);

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

    public static void printSubscribers(Subscriber[] subscribers, long cityTalksLimit) {
        System.out.println("\nList of all subscribers which exceeded time limit:");
        for (Subscriber subscriber : subscribers) {
            if (subscriber.getCityTalkSeconds() > cityTalksLimit) {
                System.out.println(subscriber);
            }
        }
    }

    public static void printUsedIntercityTalks(Subscriber[] subscribers) {
        System.out.println("\nList of subscribers who used intercity communication:");
        for (Subscriber subscriber : subscribers) {
            if (subscriber.getIntercityTalkSeconds() >  0) {
                System.out.println(subscriber);
            }
        }
    }
}
