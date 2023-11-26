public class Guest {

    private String lastName;
    private String firstName;
    private String email;
    private String phoneNumber;
    private boolean isRegistered;

    public Guest(String lastName, String firstName, String email, String phoneNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.isRegistered = false;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public boolean isRegistered() {
        return this.isRegistered;
    }

    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }

    public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public void setPhoneNumber(String newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }

    public void setIsRegistered(boolean value) {
        this.isRegistered = value;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 0;
        result = prime * result + ((this.lastName == null) ? 0 : this.lastName.hashCode());
        result = prime * result + ((this.firstName == null) ? 0 : this.firstName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null) {
            return false;
        }
        if(this.getClass() != obj.getClass()) {
            return false;
        }
        Guest guestObj = (Guest) obj;
        return this.lastName.equals(guestObj.lastName) &&
                this.firstName.equals(guestObj.firstName);
    }

    @Override
    public String toString() {
        return "Nume: " + this.fullName() +
                ", Email: " + this.getEmail() +
                ", Telefon: " + this.getPhoneNumber();
    }

    public String fullName() {
        return this.lastName + " " + this.firstName;
    }
}