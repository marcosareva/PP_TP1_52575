public class sala {
    public int idSala;
    public String nombre;

    //CONTADOR DE IDs
    public static int proxId = 1999;

    //CONSTRUCTOR
    public sala(String salaExistente){
        this.idSala = idSala + proxId++;
        this.nombre = salaExistente;
    }

    //PEDIR NOMBRE
    public String getNombre(){
        return nombre;
    }
}
