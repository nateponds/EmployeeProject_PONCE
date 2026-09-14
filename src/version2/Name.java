package version2;

public class Name {
    private String firstName;
    private String middleName;
    private String lastName;

    public Name() {
        this.firstName = "";
        this.middleName = "";
        this.lastName = "";
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.middleName = "";
        this.lastName = lastName;
    }

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void display(){
        System.out.println(this.lastName + ", " + this.firstName + " " + this.middleName.charAt(0) + ".");
    }

    @Override
    public String toString() {
        return this.lastName + ", " + this.firstName + " " + this.middleName.charAt(0) + ".";
    }
}
