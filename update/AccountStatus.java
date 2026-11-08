import java.util.ArrayList;

public class AccountStatus  {
    boolean status;
    static ArrayList<Account> accountList = new ArrayList<Account>();

    public static void addAccount(String firstName, String lastName, String username, String password) {
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
