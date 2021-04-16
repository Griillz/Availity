public class Enrollee {
    String userId = "";
    String firstName = "";
    String lastName = "";
    int version = -1;
    String insuranceCompany = "";

    public Enrollee(String userID, String firstName, String lastName, int version, String insuranceCompany) {
        this.userId = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.version = version;
        this.insuranceCompany = insuranceCompany;
    }

    public Enrollee() {

    }

    @Override public String toString() {
        StringBuilder result = new StringBuilder();
        String NL = System.getProperty("line.separator");

        result.append("User ID: " + this.userId + NL);
        result.append("First Name: " + this.firstName + NL);
        result.append("Last Name: " + this.lastName + NL);
        result.append("Version: " + this.version + NL);
        result.append("Insurance Company: " + this.insuranceCompany + NL);

        return result.toString();
    }

    public String writeToRows() {
        return this.userId + "," + this.firstName + "," + this.lastName + "," + this.version + "," + this.insuranceCompany;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }
}
