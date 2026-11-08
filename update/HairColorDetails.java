public class HairColorDetails extends ServiceDetails {
    private String length;

    HairColorDetails(String inputService, double inputPrice, String inputLength){
        super(inputService, inputPrice);
        length = inputLength;
    }

    public String showDescription(){
        return "HAIR COLOR - " + getService().toUpperCase() + " (" + length.toUpperCase() + ")";
    }
}
