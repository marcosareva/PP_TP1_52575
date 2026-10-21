public class charla extends actividad {
    public String disertante;

    //CONSTRUCTOR
    public charla(int id, String titulo, int cupo, String disertante){
        super(titulo, cupo);
        this.disertante = disertante;
    }

    public double calcularCostoMateriales(){
        return 0;
    };

    public String getTipo(){
        return this.getClass().getSimpleName();
    };
}
