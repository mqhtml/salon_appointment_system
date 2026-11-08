import javax.swing.*;

public class Appointment {

    private String month;
    private int day;
    private String time;
    private String paymentMethod;

    private String servicesBooked;
    private String stylistsBooked;
    private double total;

    public Appointment(String month, int day, String time, String paymentMethod, String servicesBooked,
                       String stylistsBooked, double total) {

        this.month = month;
        this.day = day;
        this.time = time;
        this.paymentMethod = paymentMethod;
        this.servicesBooked = servicesBooked;
        this.stylistsBooked = stylistsBooked;
        this.total = total;
    }

    // Getters

    public String getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getServicesBooked() {
        return servicesBooked;
    }

    public String getStylistsBooked() {
        return stylistsBooked;
    }

    public double getTotal() {
        return total;
    }

    // Validate appointment date

    public boolean isValidDate() {

        if (day < 1) {
            return false;
        }

        if (month.equals("January") || month.equals("March") ||
                month.equals("May") || month.equals("July") ||
                month.equals("August") || month.equals("October") ||
                month.equals("December")) {

            return day <= 31;

        } else if (month.equals("April") || month.equals("June") ||
                month.equals("September") || month.equals("November")) {

            return day <= 30;

        } else if (month.equals("February")) {

            return day <= 28;
        }

        return false;
    }

    // Display final receipt

    public void displayReceipt() {
        Account name = new Account();

        JOptionPane.showMessageDialog(null,
                        "Customer Name: " + name.getCurrentUserFullName() +
                        "\n\nServices Booked:\n" + servicesBooked +
                        "\nStylists Booked:\n" + stylistsBooked +
                        "\nDate: " + month + " " + day +
                        "\nTime: " + time +
                        "\nPayment Method: " + paymentMethod +
                        "\n\nTotal: PHP " + String.format("%.2f", total) +
                        "\n\nThank you for booking! See you!",
                "SALES INVOICE",
                JOptionPane.INFORMATION_MESSAGE);
    }
}