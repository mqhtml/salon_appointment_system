import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Salon_LoggedHome {
    private JTabbedPane loggedTab;
    private JPanel loggedPanel;
    private JButton BOOKNOWButton;
    private JButton LOGOUTButton;

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
        /*BOOKNOWButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // services tab
            }
        });*/
    }

    public JPanel getLoggedPanel() {return loggedPanel;}
    public static void main(String[] args) {
        JFrame frame = new JFrame("Salon Site");
        Salon_LoggedHome myForm = new Salon_LoggedHome();
        frame.setContentPane(myForm.loggedPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
