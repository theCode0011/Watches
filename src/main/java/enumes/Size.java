package enumes;

public enum Size {

    OVER_44("Over 44 mm"),
    SIZE_40_43mm("40-43 mm"),
    SIZE_34_39("34-39 mm");

    private final String size;

    Size(String size){
        this.size=size;
    }

    public String getValue(){
        return size;
    }
}
