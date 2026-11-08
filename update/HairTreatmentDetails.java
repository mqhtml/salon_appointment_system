public class HairTreatmentDetails extends ServiceDetails {
    private String length;

    HairTreatmentDetails(String inputService, double inputPrice, String inputLength){
        super(inputService, inputPrice);
        length = inputLength;
    }

    public String showDescription(){
        return "HAIR TREATMENT - " + getService().toUpperCase() + " (" + length.toUpperCase() + ")";
    }
}
