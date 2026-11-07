import java.util.ArrayList;

public class AccountStatus  {
    boolean status;
//    static ArrayList<String> name = new ArrayList<>();
//    static ArrayList<String> user = new ArrayList<>();
//    static ArrayList<String> pass = new ArrayList<>();
    static ArrayList<Account> accountList = new ArrayList<Account>();

    //public int getCurrentUser() {

    //}

    public static void addAccount(String firstName, String lastName, String username, String password) {
//        String fullName = firstName + " " + lastName;
//        name.add(fullName);
//        user.add(username);
//        pass.add(password);
        Account newAccount = new Account();
        newAccount.setFirstName(firstName);
        newAccount.setLastName(lastName);
        newAccount.setUserName(username);
        newAccount.setPassword(password);

        accountList.add(newAccount);
    }



   public boolean checkLogInStatus (String username, String password) {
       for (int i = 0; i < accountList.size(); i++) {
           if (username.equals(accountList.get(i).getUserName()) && password.equals(accountList.get(i).getPassword())) {
               status = true;
               break;
           }
           else{
               status = false;
           }

       }
       return status;
   }


}
