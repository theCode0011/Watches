package enumes;

public enum MenuCategories {

    WATCHES("WATCHES"),
    ACCESSORIES("ACCESSORIES"),
    SERVICES("SERVICES"),
    WATCHMAKING("WATCHMAKING"),
    UNIVERSE("UNIVERSE"),
    SUSTAINABILITY("SUSTAINABILITY"),
    STORES("STORES");

    private final String prodCat;

     MenuCategories(String prodCat){
        this.prodCat=prodCat;
    }

    public String getValue(){
         return prodCat;
    }
}
