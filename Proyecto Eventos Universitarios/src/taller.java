public class taller extends actividad {
    public boolean requiereNotebook;

    public taller(int idAct, String tituloAct, int cupo, boolean requiereNetbook) {
        super(tituloAct, cupo);
        this.requiereNotebook = requiereNetbook;
    }

    public boolean requiereNotebook() {
        return requiereNotebook;
    }

    public double calcularCosto(){
        return requiereNotebook ? 5000 : 2000;
    }
}