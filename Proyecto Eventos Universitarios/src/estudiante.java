public class estudiante {
    public String legajo;
    public String nom_ape;

    public estudiante(String legajo, String nom_ape){
        this.legajo = legajo;
        this.nom_ape = nom_ape;
    }

    //PEDIR NOMBRE
    public String getNombre (){return nom_ape;};
    //PEDIR LEGAJO
    public String getLegajo (){return legajo;}

}
