package th.mfu;

public class UserRegistrationDetail {
    private String email;
    private String firstName;
    private String lastName;

    private String Telephone;
    private String ID_card;
    private String password;

    private String country;
    private String dateOfBirth;
    private String gender;
    private String interest;

    

    public UserRegistrationDetail(String email, String firstName, String lastName, String telephone, String iD_card,
            String password, String country, String dateOfBirth, String gender, String interest) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        Telephone = telephone;
        ID_card = iD_card;
        this.password = password;
        this.country = country;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.interest = interest;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public String getID_card() {
        return ID_card;
    }

    public void setID_card(String iD_card) {
        ID_card = iD_card;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    
    
}
