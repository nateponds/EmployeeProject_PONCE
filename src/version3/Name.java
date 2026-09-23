package version3;

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
    public boolean equals(Name otherName) {
        if(this == otherName) {
            return true;
        }
        if(otherName == null) {
            return false;
        }
        if(this.getClass() != otherName.getClass()) {
            return false;
        }
        return this.firstName.equals(otherName.firstName) &&
               this.middleName.equals(otherName.middleName) &&
               this.lastName.equals(otherName.lastName) &&
               this.suffix.equals(otherName.suffix);
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
