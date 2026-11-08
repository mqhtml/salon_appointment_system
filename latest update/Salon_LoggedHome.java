import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Salon_LoggedHome {
    private JTabbedPane loggedTab;
    private JPanel loggedPanel;
    private JButton LOGOUTButton;
    private JLabel labelLogo;
    private JButton BOOKNOWButton;
    private JTextArea a1ClassicBobCutTextArea;
    private JTextArea naturalBrownP1000TextArea;
    private JTextArea keratinTreatmentP2500TextArea;

    public Salon_LoggedHome() {
        LOGOUTButton.addActionListener(new ActionListener() {
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

                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(loggedPanel);
                    if (currentFrame != null) {
                        currentFrame.dispose();
                    }
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        BOOKNOWButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(loggedPanel);
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

    public JPanel getLoggedPanel() {return loggedPanel;}
    public static void main(String[] args) {
        JFrame frame = new JFrame("Salon Site");
        Salon_LoggedHome myForm = new Salon_LoggedHome();
        frame.setContentPane(myForm.loggedPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(750, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
