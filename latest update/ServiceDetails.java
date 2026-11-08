//Abstraction - abstract class cannot be instantiated with the new operator
//Encapsulation - all variables are private, accessed only through the setter and getter methods
//Inheritance - use the extends keyword to extend ServiceCheck
public abstract class ServiceDetails extends ServiceCheck {
    private String service, stylist;
    private double price;

    public ServiceDetails(String inputService, double inputPrice){
        service = inputService;
        price = inputPrice;
        stylist = "";
    }

    public abstract String showDescription();

    void setStylist(String inputStylist) {
        stylist = inputStylist;
    }

    String getService() {
        return service;
    }

    String getStylist() {
        return stylist;
    }

    double getPrice() {
        return price;
    }
}
