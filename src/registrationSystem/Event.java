package registrationSystem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Event {

    private final int guestsCapacity;
    private final ArrayList<Guest> guestList;
    private final ArrayList<Guest> waitList;

    public Event(int guestsCapacity) {
        this.guestsCapacity = guestsCapacity;
        guestList = new ArrayList<>(guestsCapacity);
        waitList = new ArrayList<>();
    }

    /**
     * Add a new, unique guest to the list.
     *
     * @param g the guest to be added
     * @return '-1' if the guest is already present, '0' if is a guest, or the
     *         number on the waiting list
     */
    public int add(Guest g) {
        if(isOnTheListAlready(g)) {
            return -1;
        }
        if(guestList.size() >= guestsCapacity) {
            waitList.add(g);
            System.out.printf("[%s %s] Te-ai înscris cu succes in lista de " +
                            "așteptare si ai primit numărul de ordine <%d>. " +
                            "Te vom notifica dacă un loc devine disponibil.%n",
                    g.getLastName(), g.getFirstName(), waitList.indexOf(g) + 1);
            return (waitList.indexOf(g) + 1);
        }
        guestList.add(g);
        g.setIsRegistered(true);
        System.out.printf("[%s %s] Felicitări! Locul tău la eveniment este " +
                "confirmat. Te așteptăm!%n", g.getLastName(), g.getFirstName());
        return 0;
    }

    /**
     * Check if someone is already registered ( as a guest, or on the waiting
     * list).     *
     *
     * @param g the guest we are searching for
     * @return true if present, false if not
     */
    private boolean isOnTheListAlready(Guest g) { // _isOnTheListAlready
        for(Guest currentGuest : guestList) {
            if(currentGuest.equals(g)) {
                return true;
            }
        }
        for(Guest currentGuest : waitList) {
            if(currentGuest.equals(g)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Search for a guest based on first and last name. Return the first result.
     *
     * @param firstName first name of the guest
     * @param lastName  last name of the guest
     * @return the guest if found, null if not
     */
    public Guest search(String firstName, String lastName) {
        for(Guest currentGuest : guestList) {
            if(currentGuest.getFirstName().equalsIgnoreCase(firstName) &&
                    currentGuest.getLastName().equalsIgnoreCase(lastName)) {
                return currentGuest;
            }
        }
        for(Guest currentGuest : waitList) {
            if(currentGuest.getFirstName().equalsIgnoreCase(firstName) &&
                    currentGuest.getLastName().equalsIgnoreCase(lastName)) {
                return currentGuest;
            }
        }
        System.out.println("Eroare: Persoana nu este înscrisă la eveniment.");
        return null;
    }

    /**
     * Search for a guest based on email or phone number. Return the first result.
     *
     * @param opt option to use for searching: 2 for email, 3 for phone number
     * @param match what is searched for
     * @return the guest if found, null if not
     */
    public Guest search(int opt, String match) {
        if(opt == 2) {
            for(Guest currentGuest : guestList) {
                if(currentGuest.getEmail().equalsIgnoreCase(match)) {
                    return currentGuest;
                }
            }
            for(Guest currentGuest : waitList) {
                if(currentGuest.getEmail().equalsIgnoreCase(match)) {
                    return currentGuest;
                }
            }
        }
        if(opt == 3) {
            for(Guest currentGuest : guestList) {
                if(currentGuest.getPhoneNumber().equals(match)) {
                    return currentGuest;
                }
            }
            for(Guest currentGuest : waitList) {
                if(currentGuest.getPhoneNumber().equals(match)) {
                    return currentGuest;
                }
            }
        }
        System.out.println("Eroare: Persoana nu este înscrisă la eveniment.");
        return null;
    }

    /**
     * Remove a guest based on first and last name. Remove the first result.
     *
     * @param firstName first name of the guest
     * @param lastName  last name of the guest
     * @return true if removed, false if not
     */
    public boolean remove(String firstName, String lastName) {
        Guest current = search(firstName, lastName);
        if(current != null && !current.isRegistered()) {
            waitList.remove(current);
            System.out.println("Listă așteptare: Ștergerea persoanei s-a realizat cu succes.");
            return true;
        }
        if(current != null && current.isRegistered()) {
            guestList.remove(current);
            current.setIsRegistered(false);
            if(!waitList.isEmpty()) {
                current = waitList.get(0);
                waitList.remove(0);
                this.add(current);
            }
            System.out.println("Ștergerea persoanei s-a realizat cu succes.");
            return true;
        }
        return false;
    }

    /**
     * Remove a guest based on email or phone number. Remove the first result.
     *
     * @param opt   option to use for searching: 2 for email, 3 for phone number
     * @param match the match we are searching for
     * @return true if removed, false if not
     */
    public boolean remove(int opt, String match) {
        Guest current = search(opt, match);
        if(current != null && !current.isRegistered()) {
            waitList.remove(current);
            System.out.println("Listă așteptare: Ștergerea persoanei s-a realizat cu succes.");
            return true;
        }
        if(current != null && current.isRegistered()) {
            guestList.remove(current);
            current.setIsRegistered(false);
            if(!waitList.isEmpty()) {
                current = waitList.get(0);
                waitList.remove(0);
                this.add(current);
            }
            System.out.println("Ștergerea persoanei s-a realizat cu succes.");
            return true;
        }
        return false;
    }

    /**
     * Displays participants on the registration list
     */
    public void showGuestsList() {
        if(guestList.isEmpty()) {
            System.out.println("Niciun participant înscris...");
            return;
        }
        System.out.println("Guest list:");
        for(Guest current : guestList) {
            System.out.print((guestList.indexOf(current) + 1) + ". ");
            System.out.print("Nume: " + current.fullName());
            System.out.print(", Email: " + current.getEmail());
            System.out.print(", Telefon: " + current.getPhoneNumber());
            System.out.println();
        }
    }

    /**
     * Displays participants on the waiting list
     */
    public void showWaitingList() {
        if(waitList.isEmpty()) {
            System.out.println("Lista de așteptare este goală...");
            return;
        }
        System.out.println("Waiting list:");
        for(Guest current : waitList) {
            System.out.print((waitList.indexOf(current) + 1) + ". ");
            System.out.print("Nume: " + current.fullName());
            System.out.print(", Email: " + current.getEmail());
            System.out.print(", Telefon: " + current.getPhoneNumber());
            System.out.println();
        }
    }

    /**
     * Show how many free spots are left.
     *
     * @return the number of spots left for guests
     */
    public int numberOfAvailableSpots() {
        return (guestsCapacity - guestList.size());
    }

    /**
     * Show how many guests there are.
     *
     * @return the number of guests
     */
    public int numberOfGuests() {
        return guestList.size();
    }

    /**
     * Show how many people are on the waiting list.
     *
     * @return number of people on the waiting list
     */
    public int numberOfPeopleWaiting() {
        return waitList.size();
    }

    /**
     * Show how many people there are in total, including guests.
     *
     * @return how many people there are in total
     */
    public int numberOfPeopleTotal() {
        return guestList.size() + waitList.size();
    }

    /**
     * Find all people based on a partial value search.
     *
     * @param match the match we are looking for
     * @return a list of people matching the criteria
     */
    public List<Guest> partialSearch(String match) {
        match = match.toLowerCase();
        LinkedList<Guest> found = new LinkedList<>();
        for(Guest current : guestList) {
            if(current.getLastName().toLowerCase().contains(match) ||
                    current.getFirstName().toLowerCase().contains(match) ||
                    current.getEmail().toLowerCase().contains(match) ||
                    current.getPhoneNumber().contains(match)) {
                found.add(current);
            }
        }
        for(Guest current : waitList) {
            if(current.getLastName().toLowerCase().contains(match) ||
                    current.getFirstName().toLowerCase().contains(match) ||
                    current.getEmail().toLowerCase().contains(match) ||
                    current.getPhoneNumber().contains(match)) {
                found.add(current);
            }
        }
        return found;
    }

    @Override
    public String toString() {
        return "registrationSystem.Guest list:\n" + guestList +
                "Waiting list:\n" + waitList;
    }
}