public class HaircutDetails extends ServiceDetails {

    HaircutDetails(String inputService, double inputPrice){
        super(inputService, inputPrice);
    }

    public String showDescription(){
        return "HAIRCUT - " + getService().toUpperCase();
    }
}
