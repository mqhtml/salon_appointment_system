import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class SignUp {
    private JTextField txtSignUser;
    private JTextField txtSignPass;
    private JButton SIGNUPButton;
    private JButton HOMEButton;
    private JPanel signUpPanel;
    private JTextField txtFirstName;
    private JTextField txtLastName;

    String firstName, lastName, user, pass;

    public SignUp() {
        HOMEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JFrame homeFrame = new JFrame("HOMEPAGE");
                    Salon_Home salonHome = new Salon_Home();

                    JPanel panel = salonHome.getHomePanel();
                    if (panel == null) {
                        JOptionPane.showMessageDialog(null, "Error: getHomePanel() returned null. Check Salon_Home.java!", "Null Panel Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    homeFrame.setContentPane(panel);
                    homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    homeFrame.pack();
                    homeFrame.setSize(750, 400);
                    homeFrame.setLocationRelativeTo(null);
                    homeFrame.setVisible(true);



                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(signUpPanel);
                    if (currentFrame != null) {
                        currentFrame.dispose();
                    }
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        SIGNUPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                while(true) {
                    if (txtFirstName.getText().isEmpty() || txtLastName.getText().isEmpty() || txtSignUser.getText().isEmpty() || txtSignPass.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please input your information, text fields cannot be empty.", "WARNING", JOptionPane.WARNING_MESSAGE);
                        return;
                    } else {
                        firstName = txtFirstName.getText().toUpperCase();
                        lastName = txtLastName.getText().toUpperCase();
                        user = txtSignUser.getText();
                        pass = txtSignPass.getText();

                        AccountStatus.addAccount(firstName, lastName, user, pass);

                        JOptionPane.showMessageDialog(null, "Account Successfully Created!", "ACCOUNT SUCCESS\n", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                }

                    try {
                        JFrame loggedFrame = new JFrame("HOMEPAGE");
                        Salon_LoggedHome loggedHome = new Salon_LoggedHome();

                        JPanel panel = loggedHome.getLoggedPanel();
                        if (panel == null) {
                            JOptionPane.showMessageDialog(null, "Error: getLoggedPanel() returned null, Check Salon_LoggedHome.java!", "Null Panel Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        loggedFrame.setContentPane(panel);
                        loggedFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        loggedFrame.pack();
                        loggedFrame.setSize(750, 400);
                        loggedFrame.setLocationRelativeTo(null);
                        loggedFrame.setVisible(true);

                        JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(signUpPanel);
                        if (currentFrame != null) {
                            currentFrame.dispose();
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
            }
        });
    }

    public JPanel getSignUpPanel(){ return signUpPanel; }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ACCOUNT CREATION");
        SignUp myForm = new SignUp();
        frame.setContentPane(myForm.signUpPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(350, 350);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
