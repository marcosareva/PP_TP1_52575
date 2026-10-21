import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//CLASE ABSTRACTA
public abstract class actividad {
    public String tituloAct;
    public int idAct;
    private int cupoMaximo;
    private List<inscripcion> inscripciones;

    //VARIABLE DE CLASE
    public static final int cupoMinimo;

    //CONTADOR DE IDs
    public static int proxId = 1000;

    //BLOQUE ESTÁTICO QUE SE EJECUTA AL CARGAR LA CLASE
    static {
        cupoMinimo = 5;
        System.out.print("Se cargó la clase Actividad");
    }

    //CONSTRUCTOR
    public actividad(String tituloAct, int cupo) {
        this.idAct = proxId++;
        this.tituloAct = tituloAct;
        this.cupoMaximo = Math.max(cupo, cupoMinimo); //DEVUELVE EL MAYOR DE LOS DOS
        this.inscripciones = new ArrayList<>();
    }

    public inscripcion inscribir(estudiante estudiante) {
        inscripcion i1 = new inscripcion(estudiante, this, LocalDate.now(), "INS");
        inscripciones.add(i1);
        return i1;
    }

    public List<inscripcion> getInscripciones() {
        return inscripciones;
    }


    public final int getIdAct() {
        return idAct;
    }

    public String getTituloAct() {
        return tituloAct;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public int getCupoMinimo() {
        return cupoMinimo;
    }

    //MÉTODOS ABSTRACTOS
    public abstract double calcularCostoMateriales();

    public abstract String getTipo();
}
