import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Salon_Home {
    private JPanel mainPanel;
    private JTabbedPane mainTab;
    private JButton SIGNINButton;
    private JButton LOGINButton;
    private JLabel labelLogo;
    private JTextArea a1ClassicBobCutTextArea;
    private JTextArea naturalBrownP1000TextArea;
    private JTextArea keratinTreatmentP2500TextArea;

    public Salon_Home() {
        SIGNINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JFrame signUpFrame = new JFrame("Account Creation");
                    SignUp signUp = new SignUp();

                    JPanel panel = signUp.getSignUpPanel();
                    if (panel == null) {
                        JOptionPane.showMessageDialog(null, "Error: getSignInPanel() returned null, Check SignUp.java!", "Null Panel Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    signUpFrame.setContentPane(panel);
                    signUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    signUpFrame.pack();
                    signUpFrame.setSize(350, 350);
                    signUpFrame.setLocationRelativeTo(null);
                    signUpFrame.setVisible(true);

                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
                    if (currentFrame != null) {
                        currentFrame.dispose();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                }
        });

        LOGINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JFrame logInFrame = new JFrame("Account Log in");
                    LogIn logIn = new LogIn();

                    JPanel panel = logIn.getLogInPanel();
                    if (panel == null) {
                        JOptionPane.showMessageDialog(null, "Error: getLogInPanel() returned null, Check LogIn.java!", "Null Panel Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    logInFrame.setContentPane(panel);
                    logInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    logInFrame.pack();
                    logInFrame.setSize(350, 250);
                    logInFrame.setLocationRelativeTo(null);
                    logInFrame.setVisible(true);

                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
                    if (currentFrame != null) {
                        currentFrame.dispose();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });
    }


    public JPanel getHomePanel(){
        return mainPanel;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Salon Site");
        Salon_Home myForm = new Salon_Home();
        frame.setContentPane(myForm.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(750, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
