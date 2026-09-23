package version3;

import java.util.Objects;

public class Name implements Cloneable{
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    public Name() {
        this.firstName = "N/A";
        this.middleName = "N/A";
        this.lastName = "N/A";
        this.suffix = "";
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.middleName = "";
        this.lastName = lastName;
        this.suffix = "";
    }

    public Name(String firstName, String middleName, String lastName) {
        this(firstName, middleName, lastName, "");
    }

    public Name(String firstName, String middleName, String lastName, String suffix) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
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

    public String getSuffix() {
        return suffix;
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

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void displayName() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        String formatted = lastName + ", " + firstName;
        if (middleName != null && !middleName.isEmpty()) {
            formatted += " " + middleName.charAt(0) + ".";
        }
        if (suffix != null && !suffix.isEmpty()) {
            formatted += " " + suffix;
        }
        return formatted;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Name otherName = (Name) obj;
        return Objects.equals(firstName, otherName.firstName)
                && Objects.equals(middleName, otherName.middleName)
                && Objects.equals(lastName, otherName.lastName)
                && Objects.equals(suffix, otherName.suffix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName, suffix);
    }

    @Override   
    public Name clone() throws CloneNotSupportedException {
        Name cloned = (Name) super.clone();
        cloned.firstName = new String(firstName);
        cloned.middleName = new String(middleName);
        cloned.lastName = new String(lastName);
        cloned.suffix = new String(suffix);
        return cloned;
    }

}
