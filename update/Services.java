import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Services {

    private JTabbedPane mainTab;
    private JComboBox cmbHairStyle;
    private JTextField txtCutPrice;
    private JRadioButton rdbtnCutStylist1;
    private JRadioButton rdbtnCutStylist2;
    private JRadioButton rdbtnCutStylist3;
    private JButton btnAddCut;
    private JComboBox cmbHairColor;
    private JComboBox cmbColorLength;
    private JTextField txtColorPrice;
    private JRadioButton rdbtnColorStylist1;
    private JRadioButton rdbtnColorStylist2;
    private JRadioButton rdbtnColorStylist3;
    private JButton btnAddColor;
    private JComboBox cmbHairTreatment;
    private JComboBox cmbTreatmentLength;
    private JTextField txtTreatmentPrice;
    private JRadioButton rdbtnTreatmentStylist1;
    private JRadioButton rdbtnTreatmentStylist2;
    private JRadioButton rdbtnTreatmentStylist3;
    private JButton btnAddTreatment;

    private JTable tblServices;
    private JTextField txtTotal;
    private JButton btnConfirm;

    DefaultTableModel tableServices = new DefaultTableModel();

    ServiceBill bill = new ServiceBill();

    double cutPrice[] = {550, 600, 750, 850, 950};
    double colorPrice[] = {1000, 1800, 1400, 3000, 4500};
    double treatmentPrice[] = {2500, 1800, 1700, 3000, 4500};

    ArrayList<ServiceDetails> bookedServices = new ArrayList<>();

    int count = 0;

    public Services() {

        tableServices.addColumn("NO.");
        tableServices.addColumn("SERVICE");
        tableServices.addColumn("STYLIST");
        tableServices.addColumn("PRICE");

        tblServices.setModel(tableServices);

        tblServices.getColumnModel().getColumn(0).setPreferredWidth(10);  // NO.
        tblServices.getColumnModel().getColumn(1).setPreferredWidth(200); // SERVICE
        tblServices.getColumnModel().getColumn(2).setPreferredWidth(120); // STYLIST
        tblServices.getColumnModel().getColumn(3).setPreferredWidth(80); // PRICE

        txtCutPrice.setText(String.format("%.2f", cutPrice[0]));
        txtColorPrice.setText(String.format("%.2f", colorPrice[0]));
        txtTreatmentPrice.setText(String.format("%.2f", treatmentPrice[0]));

        txtTotal.setText(String.format("%.2f", bill.computeBill()));


        cmbHairStyle.addActionListener(e -> {
            int index = cmbHairStyle.getSelectedIndex();
            txtCutPrice.setText(
                    String.format("%.2f", cutPrice[index]));
        });

        cmbHairColor.addActionListener(e -> {
            int index = cmbHairColor.getSelectedIndex();
            txtColorPrice.setText(String.format("%.2f", colorPrice[index]));
        });

        cmbHairTreatment.addActionListener(e -> {
            int index = cmbHairTreatment.getSelectedIndex();

            txtTreatmentPrice.setText(String.format("%.2f", treatmentPrice[index]));
        });


        btnAddCut.addActionListener(e -> {
            String stylist = getSelectedStylist(rdbtnCutStylist1, rdbtnCutStylist2, rdbtnCutStylist3);

            ServiceDetails service = new HaircutDetails(
                    cmbHairStyle.getSelectedItem().toString(),
                    cutPrice[cmbHairStyle.getSelectedIndex()]
            );

            service.setStylist(stylist);
            addService(service);

        });

        btnAddColor.addActionListener(e -> {

            String stylist = getSelectedStylist(rdbtnColorStylist1, rdbtnColorStylist2, rdbtnColorStylist3);

            ServiceDetails service = new HairColorDetails(
                    cmbHairColor.getSelectedItem().toString(),
                    colorPrice[cmbHairColor.getSelectedIndex()],
                    cmbColorLength.getSelectedItem().toString()
            );

            service.setStylist(stylist);
            addService(service);
        });

        btnAddTreatment.addActionListener(e -> {

            String stylist = getSelectedStylist(rdbtnTreatmentStylist1, rdbtnTreatmentStylist2, rdbtnTreatmentStylist3);

            ServiceDetails service = new HairTreatmentDetails(
                    cmbHairTreatment.getSelectedItem().toString(),
                    treatmentPrice[cmbHairTreatment.getSelectedIndex()],
                    cmbTreatmentLength.getSelectedItem().toString()
            );

            service.setStylist(stylist);
            addService(service);
        });

        btnConfirm.addActionListener(e -> {
            if (bookedServices.isEmpty()) {
                JOptionPane.showMessageDialog(mainTab,
                        "You have not added any services yet!",
                        "WARNING",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            int response = JOptionPane.showConfirmDialog(mainTab,
                    "Do you want to proceed to appointment scheduling?",
                    "CONFIRMATION",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (response == JOptionPane.YES_OPTION) {

                Schedule schedule = new Schedule(getServicesBooked(), getStylistsBooked(), getTotal());

                JFrame frame = new JFrame("SCHEDULE APPOINTMENT");

                frame.setContentPane(schedule.getSchedulePanel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(600, 300);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(mainTab);

                if (currentFrame != null) {
                    currentFrame.dispose();
                }
            }
        });
    }

    public String getSelectedStylist(
            JRadioButton stylist1,
            JRadioButton stylist2,
            JRadioButton stylist3) {

        if (stylist1.isSelected()) {
            return stylist1.getText();
        }
        else if (stylist2.isSelected()) {
            return stylist2.getText();
        }
        else if (stylist3.isSelected()) {
            return stylist3.getText();
        }

        return "";
    }

    public void addService(ServiceDetails service) {
        if (service.checkStylistValidity(service.getStylist())
                .equals("Valid Stylist")) {
            count++;

            Object[] row = {count, service.showDescription(), service.getStylist().toUpperCase(),
                    String.format("%.2f", service.getPrice())
            };

            tableServices.addRow(row);
            bookedServices.add(service);

            bill.computeBill(service.getPrice());
            txtTotal.setText(String.format("%.2f", bill.computeBill()));

            JOptionPane.showMessageDialog(null,
                    "Service successfully added!");
        } else {
            JOptionPane.showMessageDialog(mainTab,
                    "Please choose a stylist!",
                    "STYLIST SELECTION",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }

    public String getServicesBooked() {
        StringBuilder result = new StringBuilder();

        for (ServiceDetails service : bookedServices) {
            result.append(service.showDescription()).append("\n");
        }

        return result.toString();
    }

    public String getStylistsBooked() {
        ArrayList<String> uniqueStylists = new ArrayList<>();

        for (ServiceDetails service : bookedServices) {
            String stylist = service.getStylist();

            if (!uniqueStylists.contains(stylist)) {
                uniqueStylists.add(stylist);
            }
        }

        StringBuilder result = new StringBuilder();

        for (String stylist : uniqueStylists) {
            result.append(stylist).append("\n");
        }

        return result.toString();
    }

    public double getTotal() {
        return bill.computeBill();
    }

    public JTabbedPane getMainTab() {
        return mainTab;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SERVICE APPOINTMENT");
        Services form = new Services();

        frame.setContentPane(form.mainTab);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}