import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Schedule {
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JRadioButton cashRadioButton;
    private JRadioButton eWalletRadioButton;
    private JRadioButton creditDebitCardRadioButton;
    private JButton BOOKButton;
    private JPanel schedulePanel;

    public Schedule() {
        BOOKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("SCHEDULE APPOINTMENT");
        Schedule form = new Schedule();

        frame.setContentPane(form.schedulePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
