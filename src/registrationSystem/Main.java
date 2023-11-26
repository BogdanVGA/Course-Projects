package registrationSystem;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static void showCommands() {
        System.out.println("help         - Afișează aceasta listă de comenzi");
        System.out.println("add          - Adaugă o noua persoana (înscriere)");
        System.out.println("check        - Verifică daca o persoana este înscrisă la eveniment");
        System.out.println("remove       - Șterge o persoana existenta din lista");
        System.out.println("update       - Actualizează detaliile unei persoane");
        System.out.println("guests       - Lista de persoane care participa la eveniment");
        System.out.println("waitlist     - Persoanele din lista de așteptare");
        System.out.println("available    - Numărul de locuri libere");
        System.out.println("guests_no    - Numărul de persoane care participa la eveniment");
        System.out.println("waitlist_no  - Numărul de persoane din lista de așteptare");
        System.out.println("subscribe_no - Numărul total de persoane înscrise");
        System.out.println("search       - Caută toți invitații conform șirului de caractere introdus");
        System.out.println("quit         - Închide aplicația");
    }

    /**
     * Adds a new guest to event
     * @param sc read input data from System.in
     * @param event the current event
     */
    private static void addNewGuest(Scanner sc, Event event) {
        System.out.println("Se adaugă o nouă persoană...");
        System.out.print("Introduceți numele de familie: ");
        String lastName = sc.nextLine();
        System.out.print("Introduceți prenumele: ");
        String firstName = sc.nextLine();
        System.out.print("Introduceți email: ");
        String email = sc.nextLine();
        System.out.print("Introduceți număr de telefon (format \"+40733386463\"): ");
        String phoneNumber = sc.nextLine();
        Guest newGuest = new Guest(lastName, firstName, email, phoneNumber);
        if(event.add(newGuest) == -1) {
            System.out.println("Participant deja existent.");
        }
    }

    private static void checkGuest(Scanner sc, Event event) {
        System.out.println("Se verifică prezența unei persoane... ");
        System.out.println("Alege modul de căutare, tastând:");
        System.out.println("\t'1' - după nume și prenume");
        System.out.println("\t'2' - după adresa de email");
        System.out.println("\t'3' - după numărul de telefon");
        System.out.print("Opțiune: ");
        char option = sc.nextLine().charAt(0);
        if(option < 49 || option > 51) {
            System.out.println("Opțiune invalidă.");
            return;
        }
        Guest toCheck;
        if(option == '1') {
            System.out.print("Introduceți numele de familie: ");
            String lastName = sc.nextLine();
            System.out.print("Introduceți prenumele: ");
            String firstName = sc.nextLine();
            toCheck = event.search(firstName, lastName);
        } else if(option == '2') {
            System.out.print("Introduceți email: ");
            String email = sc.nextLine();
            toCheck = event.search(Character.getNumericValue(option), email);
        } else {
            System.out.print("Introduceți număr de telefon (format \"+40733386463\"): ");
            String phoneNumber = sc.nextLine();
            toCheck = event.search(Character.getNumericValue(option), phoneNumber);
        }
        if(toCheck == null) {
            System.out.println("Nimic de afișat.");
            return;
        }
        System.out.println(toCheck);
    }

    private static void removeGuest(Scanner sc, Event event) {
        System.out.println("Se șterge o persoană existentă din listă...");
        System.out.println("Alege modul de căutare, tastând:");
        System.out.println("\t'1' - după nume si prenume");
        System.out.println("\t'2' - după adresa de email");
        System.out.println("\t'3' - după numărul de telefon");
        System.out.print("Opțiune: ");
        char option = sc.nextLine().charAt(0);
        if(option < 49 || option > 51) {
            System.out.println("Opțiune invalidă.");
            return;
        }
        boolean wasRemoved;
        if(option == '1') {
            System.out.print("Introduceți numele de familie:: ");
            String lastName = sc.nextLine();
            System.out.print("Introduceți prenumele: ");
            String firstName = sc.nextLine();
            wasRemoved = event.remove(firstName, lastName);
        } else if(option == '2') {
            System.out.print("Introduceți email: ");
            String email = sc.nextLine();
            wasRemoved = event.remove(Character.getNumericValue(option), email);
        } else {
            System.out.print("Introduceți număr de telefon (format \"+40733386463\"): ");
            String phoneNumber = sc.nextLine();
            wasRemoved = event.remove(Character.getNumericValue(option), phoneNumber);
        }
        if(!wasRemoved) {
            System.out.println("Ștergerea persoanei nu a putut fi efectuată.");
        }
    }

    private static void updateGuest(Scanner sc, Event event) {
        System.out.println("Se actualizează detaliile unei persoane... ");
        System.out.println("Alege modul de căutare, tastând:");
        System.out.println("\t'1' - după nume si prenume");
        System.out.println("\t'2' - după adresa de email");
        System.out.println("\t'3' - după numărul de telefon");
        System.out.print("Opțiune: ");
        char option = sc.nextLine().charAt(0);
        if(option < 49 || option > 51) {
            System.out.println("Opțiune invalidă.");
            return;
        }
        Guest toUpdate;
        if(option == '1') {
            System.out.print("Introduceți numele de familie: ");
            String lastName = sc.nextLine();
            System.out.print("Introduceți prenumele: ");
            String firstName = sc.nextLine();
            toUpdate = event.search(firstName, lastName);
        } else if(option == '2') {
            System.out.print("Introduceți email email: ");
            String email = sc.nextLine();
            toUpdate = event.search(Character.getNumericValue(option), email);
        } else {
            System.out.print("Introduceți număr de telefon (format \"+40733386463\"): ");
            String phoneNumber = sc.nextLine();
            toUpdate = event.search(Character.getNumericValue(option), phoneNumber);
        }
        if(toUpdate == null) {
            System.out.println("Nimic de actualizat.");
            return;
        }
        System.out.println("A fost găsit: " + toUpdate);
        System.out.println("Alege câmpul de actualizat, tastând:");
        System.out.println("\t'1' - pentru nume");
        System.out.println("\t'2' - pentru prenume");
        System.out.println("\t'3' - pentru adresa de email");
        System.out.println("\t'4' - pentru numărul de telefon");
        System.out.print("Opțiune: ");
        option = sc.nextLine().charAt(0);
        if(option < 49 || option > 52) {
            System.out.println("Opțiune invalidă.");
            return;
        }
        if(option == '1') {
            System.out.print("Introduceți numele de familie: ");
            String newLastName = sc.nextLine();
            toUpdate.setLastName(newLastName);
        } else if(option == '2') {
            System.out.print("Introduceți prenumele: ");
            String newFirstName = sc.nextLine();
            toUpdate.setFirstName(newFirstName);
        } else if(option == '3') {
            System.out.print("Introduceți email: ");
            String newEmail = sc.nextLine();
            toUpdate.setEmail(newEmail);
        } else {
            System.out.print("Introduceți număr de telefon (format \"+40733386463\"): ");
            String newPhoneNumber = sc.nextLine();
            toUpdate.setPhoneNumber(newPhoneNumber);
        }
    }

    private static void searchList(Scanner sc, Event event) {
        System.out.print("Introduceți cheia de căutare: ");
        String match = sc.nextLine();
        List<Guest> results = event.partialSearch(match);
        if(results.isEmpty()) {
            System.out.println("Nu a fost găsit niciun rezultat.");
            return;
        }
        System.out.println("Rezultatele căutării:");
        for(Guest current : results) {
            System.out.println(current.toString());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bun venit! Introduceți numărul de locuri disponibile: ");
        int size = scanner.nextInt();
        scanner.nextLine();

        Event event = new Event(size);

        boolean running = true;
        while (running) {
            System.out.print("Așteaptă comanda: (help - Afișează lista de comenzi) ");
            String command = scanner.nextLine();

            switch (command) {
                case "help" -> showCommands();
                case "add" -> addNewGuest(scanner, event);
                case "check" -> checkGuest(scanner, event);
                case "remove" -> removeGuest(scanner, event);
                case "update" -> updateGuest(scanner, event);
                case "guests" -> event.showGuestsList();
                case "waitlist" -> event.showWaitingList();
                case "available" -> System.out.println("Numărul de locuri ramase: " +
                        event.numberOfAvailableSpots());
                case "guests_no" -> System.out.println("Numărul de participanți: " +
                        event.numberOfGuests());
                case "waitlist_no" ->
                        System.out.println("Dimensiunea listei de așteptare: " +
                                event.numberOfPeopleWaiting());
                case "subscribe_no" -> System.out.println("Numărul total de persoane: " +
                        event.numberOfPeopleTotal());
                case "search" -> searchList(scanner, event);
                case "quit" -> {
                    System.out.println("Aplicația se închide...");
                    scanner.close();
                    running = false;
                }
                default -> {
                    System.out.println("Comanda introdusă nu este validă.");
                    System.out.println("Încercați încă o data.");
                }
            }
        }
    }
}