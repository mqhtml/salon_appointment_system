import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Services {
    private JComboBox cmbxHairStyle;
    private JTextField txtCutPrice;
    private JRadioButton rdbtnCutStylist1;
    private JRadioButton rdbtnCutStylist2;
    private JRadioButton rdbtnCutStylist3;
    private JButton btnAddCut;
    private JComboBox cmbxHairColor;
    private JComboBox cmbxColorLength;
    private JTextField txtColorPrice;
    private JRadioButton rdbtnColorStylist1;
    private JRadioButton rdbtnColorStylist2;
    private JRadioButton rdbtnColorStylist3;
    private JButton btnAddColor;
    private JComboBox cmbxHairTreatment;
    private JComboBox cmbxTreatmentLength;
    private JTextField txtTreatmentPrice;
    private JRadioButton rdbtnTreatmentStylist1;
    private JRadioButton rdbtnTreatmentStylist2;
    private JRadioButton rdbtnTreatmentStylist3;
    private JButton btnAddTreatment;
    private JTable table1;
    private JButton btnConfirm;
    private JScrollPane tblServices;
    private JTabbedPane servicesPanel;

    private ArrayList<Services> hairStyles = new ArrayList<>();
    private ArrayList<Services> hairColors = new ArrayList<>();
    private ArrayList<Services> hairTreatments = new ArrayList<>();

    public Services() {
        DefaultTableModel tableServices = (DefaultTableModel) table1.getModel();

        tableServices.addColumn("No.");
        tableServices.addColumn("Service");
        tableServices.addColumn("Stylist");
        tableServices.addColumn("Price");

        btnAddCut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnAddColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnAddTreatment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("SERVICE APPOINTMENT");
        Services form = new Services();

        frame.setContentPane(form.servicesPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
