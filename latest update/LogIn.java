import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LogIn {
    private JButton HOMEButton;
    private JTextField txtLogUser;
    private JTextField txtLogPass;
    private JButton LOGINButton;
    private JPanel logInPanel;

    Account accStatus = new Account();

    public LogIn() {
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

                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(logInPanel);
                    if (currentFrame != null) {
                        currentFrame.dispose();
                    }
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        LOGINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                while(true){
                    if(txtLogUser.getText().isEmpty() || txtLogPass.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Please input your information, text fields cannot be empty.", "WARNING", JOptionPane.WARNING_MESSAGE);
                        return;
                    }else{

                        boolean stat = accStatus.checkLogInStatus(txtLogUser.getText(), txtLogPass.getText());
                        if(stat){
                            JOptionPane.showMessageDialog(null, "Log In Successful!", "LOGIN", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Account does not exist or Information is incorrect", "LOGIN", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                }
                try {
                    JFrame servicesFrame = new JFrame("SERVICES");
                Services salonServices = new Services();

                JTabbedPane pane = salonServices.getMainTab();
                if (pane == null) {
                    JOptionPane.showMessageDialog(null, "Error: getMainTab() returned null. Check Services.java!", "Null Panel Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                servicesFrame.setContentPane(pane);
                servicesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                servicesFrame.pack();
                servicesFrame.setSize(600, 400);
                servicesFrame.setLocationRelativeTo(null);
                servicesFrame.setVisible(true);

                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(logInPanel);
                if (currentFrame != null) {
                    currentFrame.dispose();
                }
            }
                catch (Exception ex) {
                ex.printStackTrace();
            }
            }
        });
    }

    public JPanel getLogInPanel(){
        return logInPanel;
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Account Creation");
        LogIn myForm = new LogIn();
        frame.setContentPane(myForm.logInPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(350, 250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
