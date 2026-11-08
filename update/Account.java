public class Account extends AccountStatus {

    private String firstName, lastName, username, password;

    void setFirstName(String inputFirstName){
        firstName = inputFirstName;
    }
    void setLastName(String inputLastName){
        lastName = inputLastName;
    }
    void setUserName(String inputUserName){
        username = inputUserName;
    }
    void setPassword(String inputPassword){
        password = inputPassword;
    }

    String getFirstName(){ return firstName;}
    String getLastName(){
        return lastName;
    }
    String getUserName(){ return username;}
    String getPassword(){
        return password;
    }
}
