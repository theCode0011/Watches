package enumes;

public enum AccessoriesCategory {

    BRACELETS("BRACELETS");

    private final String accesSubcat;

    AccessoriesCategory(String accesSubcat){
        this.accesSubcat=accesSubcat;
    }

    public String getValue(){
        return accesSubcat;
    }
}
