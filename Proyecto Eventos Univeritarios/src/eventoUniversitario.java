import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class eventoUniversitario {
    private String tituloEvento;
    private String id = "EVT";
    private double costoBase;
    private boolean gratuito;
    public static int cantEventos;

    //CONTADOR DE IDs
    public static int proxId;

    //CLASES RELACIONADAS
    private List<actividad> actividades; //COMPUESTA
    private sala sala; //AGREGADA

    //CONTADOR DE CANTIDAD DE EVENTOS
    static {
        cantEventos = 0;
        proxId = 1;
    }

    //CONSTRUCTOR
    public eventoUniversitario(
            String nombre,
            double costo,
            boolean esGratuito
            ) {
        setTitulo(nombre);
        this.id = id + proxId++;
        this.gratuito = esGratuito;
        this.costoBase = gratuito ? 0 : costo;
        cantEventos++;
        this.actividades = new ArrayList<>(); //COMPOSICIÓN DE ACTIVIDADES
    }

    //CONSTRUCTOR COPIA
    public eventoUniversitario (eventoUniversitario otroEvento){
        this(otroEvento.tituloEvento, otroEvento.costoBase, otroEvento.gratuito);
        this.id = otroEvento.id + "COPIA";
        proxId--;
    }

    //VALIDACIÓN DE TITULO PARA QUE NO QUEDE EN BLANCO
    public void setTitulo(String nombre){
        if (nombre != null && !nombre.isBlank()){
            this.tituloEvento = nombre;
        }
    }

    //AGREGACIÓN DE SALA
    public void asignarSala(sala sala){
        this.sala = sala;
    }

    //COMPOSICION DE ACTIVIDADES
    public void crearActividad(String titulo, int cupo, String tipoAct){
        Scanner scanner = new Scanner(System.in);
        switch(tipoAct){
            case "charla":
                System.out.print("Ingrese el nombre del disertante de la charla " + titulo + ": ");
                String disertante = scanner.nextLine();
                actividad charla = new charla(proxId++, titulo, cupo, disertante);
                this.actividades.add(charla);
                break;
            case "taller":
                System.out.print("¿El taller requiere notebook?: ");
                String reqNote = scanner.nextLine().trim().toLowerCase();
                boolean respNote = (reqNote.equals("si")||reqNote.equals("sí")||reqNote.equals("s"));
                actividad taller = new taller(proxId++, titulo, cupo, respNote);
                this.actividades.add(taller);
                break;

        }
    }

    //MOSTRAR ACTIVIDADES
    public List<actividad> getActividades(){return Collections.unmodifiableList(actividades);
    }

    //MOSTRAR LOS DATOS DEL EVENTO
    public void  mostrarDatos() {
        if (cantEventos == 1){
            System.out.println("________________________________________");}
        System.out.println("Evento codigo: " + id);
        System.out.println("Titulo: " + tituloEvento);
        System.out.println("Costo: " + calcularCostoEstimado());
        System.out.println("Sala: " + (sala != null? sala.getNombre() : "Sin sala"));
        System.out.println("________________________________________");
    }

    //PEDIR ID
    public String getId(){
        return id;
    }

    //PEDIR TITULO
    public String getTitulo(){
        return tituloEvento;
    }

    //PEDIR LA CANTIDAD DE EVENTOS
    public static int getCantEventos(){
        return cantEventos;
    }

    //CALCULAR EL COSTO
    public double calcularCostoEstimado(){
        if (this.gratuito){
            return 0;
        }
        return (costoBase * actividades.size()) * 1.21;
    }
}