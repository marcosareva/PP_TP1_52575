public class taller extends actividad {
    public boolean requiereNotebook;

    public taller(int idAct, String tituloAct, int cupo, boolean requiereNetbook) {
        super(tituloAct, cupo);
        this.requiereNotebook = requiereNetbook;
    }


    public double calcularCostoMateriales(){
        return (requiereNotebook?5000:2000);
    }

    public String getTipo(){
        return this.getClass().getSimpleName();
    };
}
