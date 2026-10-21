import java.time.LocalDate;

public class inscripcion {
    private estudiante estudiante;
    private actividad actividad;
    private LocalDate fecha;
    private String estado;

    public inscripcion(estudiante estudiante, actividad actividad, LocalDate fecha, String estado){
        this.estudiante = estudiante;
        this.actividad = actividad;
        this.fecha = fecha;
        this.estado = estado;
    }

    public estudiante getEstudiante() {
        return estudiante;
    }

    public actividad getActividad() {
        return actividad;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    public String getEstado() {
        return estado;
    }

    public String toString() {
        return estudiante.getNombre();
    }
}