package enumes;

public enum WatchesSubcat {

    SEE_ALL_WATCHES("VOIR TOUTES LES MONTRES"),
    PILOTS_WATCHES("MONTRES D’AVIATEUR"),
    OLD_COLLECTION("ANCIENNES COLLECTIONS");



    ////SET watches subcat one more

    private final String watch;

     WatchesSubcat(String watch){
        this.watch = watch;
    }
    public String getValue(){
         return watch;
    }
}
