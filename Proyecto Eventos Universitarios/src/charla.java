public class charla extends actividad {
    public String disertante;

    //CONSTRUCTOR
    public charla(int id, String titulo, int cupo, String disertante){
        super(titulo, cupo);
        this.disertante = disertante;
    }

    //PEDIR COSTO
    public double calcularCosto(){
        return 0;
    }

}
