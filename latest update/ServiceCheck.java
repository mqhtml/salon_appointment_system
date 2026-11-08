//Inheritance - this is the parent class, the other classes use the extends keyword to get its methods
public class ServiceCheck {
    String checkStylistValidity(String stylist){
        if (stylist.equals(""))
            return "Invalid Stylist";
        else
            return "Valid Stylist";
    }
}
