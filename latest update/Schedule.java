import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Schedule {

    private JComboBox cmbxMonth;
    private JComboBox cmbxDay;
    private JComboBox cmbxTime;
    private JRadioButton rdbtnCash;
    private JRadioButton rdbtnEWallet;
    private JRadioButton rdbtnCard;
    private JButton btnBook;
    private JPanel schedulePanel;
    private Appointment appointment;

    private String servicesBooked;
    private String stylistsBooked;
    private double total;

    public Schedule(String servicesBooked, String stylistsBooked, double total) {

        this.servicesBooked = servicesBooked;
        this.stylistsBooked = stylistsBooked;
        this.total = total;

        btnBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String month = cmbxMonth.getSelectedItem().toString();

                int day = Integer.parseInt(cmbxDay.getSelectedItem().toString());
                String time = cmbxTime.getSelectedItem().toString();

                String paymentMethod = getPaymentMethod();

                if (paymentMethod.isEmpty()) {
                    JOptionPane.showMessageDialog(
                            schedulePanel,
                            "Please select a payment method.",
                            "BOOKING ERROR",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                appointment = new Appointment(month, day, time, paymentMethod, servicesBooked,
                        stylistsBooked, total);

                if (appointment.isValidDate()) {

                    appointment.displayReceipt();

                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(schedulePanel);

                    if (currentFrame != null) {
                        currentFrame.dispose();
                    }

                } else {
                    JOptionPane.showMessageDialog(
                            schedulePanel,
                            "Invalid appointment date!",
                            "DATE ERROR",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public String getPaymentMethod() {

        if (rdbtnCash.isSelected()) {
            return "Cash";
        }
        else if (rdbtnEWallet.isSelected()) {
            return "E-Wallet";
        }
        else if (rdbtnCard.isSelected()) {
            return "Card";
        }

        return "";
    }

    public JPanel getSchedulePanel() {
        return schedulePanel;
    }
}