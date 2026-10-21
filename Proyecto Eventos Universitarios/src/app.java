import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class app {
    public static void main (String[] arg) {
        boolean continuar = true;
        //INICIO
        System.out.println("EVENTOS UNIVERSITARIOS\n=========================================");
        eventoUniversitario evento1 = new eventoUniversitario("eventoPrueba",5000,false);
        eventoUniversitario evento1copia = new eventoUniversitario(evento1);
        evento1.mostrarDatos();
        evento1copia.mostrarDatos();
        Scanner scanner = new Scanner(System.in);
        List<estudiante> estudiantes = new ArrayList<>();


                while (continuar) {
                    System.out.println("REGISTRO DE ESTUDIANTES AL SISTEMA");
                    System.out.println("Ingrese el legajo del estudiante: ");
                    String legajo = scanner.nextLine();
                    System.out.println("Ingrese el nombre y apellido: ");
                    String nom_ape = scanner.nextLine();
                    estudiantes.add(new estudiante(legajo, nom_ape));
                    System.out.println("¿Desea agregar otro estudiante?: ");
                    String resp = scanner.nextLine().trim().toLowerCase();
                    continuar = (resp.equals("s") || resp.equals("si") || resp.equals("sí"));
                }
                continuar = true;
                while (continuar) {
                    //INGRESO DE DATOS DEL EVENTO
                    System.out.println("REGISTRO DE EVENTOS");
                    System.out.println("Ingrese el nombre del evento: ");
                    String titulo = scanner.nextLine();
                    System.out.println("Ingrese el costo base del avento: ");
                    double costoBase = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("¿El evento será gratuito para los participantes?: ");
                    boolean esGratuito = false;
                    String resp = scanner.nextLine().trim().toLowerCase();
                    if (resp.equals("s") || resp.equals("si") || resp.equals("sí")) {
                        esGratuito = true;
                    }
                    //CONSTRUCCIÓN DEL EVENTO
                    eventoUniversitario evento = new eventoUniversitario(titulo,costoBase,esGratuito);

                    //INGRESO DE LA SALA DEL EVENTO
                    System.out.println("Ingese el nombre de la sala donde se realizará el evento: ");
                    String nombreSala= scanner.nextLine();
                    sala sala = new sala(nombreSala);
                    evento.asignarSala(sala);

                    //CREAR ACTIVIDADES DEL EVENTO
                    while (continuar) {
                        System.out.println("REGISTRAR ACTIVIDADES DEL EVENTO");
                        System.out.println("Ingrese el título de la actividad: ");
                        String tituloAct = scanner.nextLine();
                        System.out.println("Ingrese el cupo máximo de estudiantes: ");
                        int cupo = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("¿La actividad es una Charla o un Taller?: ");
                        String tipo = scanner.nextLine().trim().toLowerCase();
                        evento.crearActividad(tituloAct, cupo, tipo);
                        System.out.println("¿Desea agregar otra actividad?");
                        String respuesta = scanner.nextLine().trim().toLowerCase();
                        continuar = (respuesta.equals("s") || respuesta.equals("si") || respuesta.equals("sí"));
                    }

                    //SE INSCRIBEN ESTUDIANTES A LA ACTIVIDAD
                    continuar = true;
                    int i = 0;
                    while (continuar) {
                        System.out.println("INSCRIPCIÓN DE ESTUDIANTES");
                        System.out.println("Ingrese el legajo: ");
                        String legajo = scanner.nextLine();
                        System.out.println("Ingrese el ID de la actividad: ");
                        int idAct = scanner.nextInt();
                        scanner.nextLine();

                        //BUSCAR LA ACTIVIDAD POR ID
                        actividad elegida = null;
                        for (actividad a : evento.getActividades()) {
                            if (a.getIdAct() == idAct) {
                                elegida = a;
                                break;
                            }
                        }
                        if (elegida == null) {
                            System.out.println("No existe una actividad con ese ID");
                        }
                        else {
                            //BUSCAR AL ESTUDIANTE POR LEGAJO
                            boolean encontrado = false;
                            for (estudiante est : estudiantes) {
                                if (est.getLegajo().equals(legajo)) {
                                    elegida.inscribir(est);
                                    encontrado = true;
                                    break;
                                }
                            }
                            if (!encontrado) {
                                System.out.println("Legajo no encontrado");
                            }
                        }
                        System.out.println("¿Desea inscribir otro estudiante?: ");
                        resp = scanner.nextLine().trim().toLowerCase();
                        continuar  = (resp.equals("s") || resp.equals("si") || resp.equals("sí"));
                    }

                    //SE MUESTRAN DATOS DEL EVENTO
                    System.out.println("DATOS DEL EVENTO");
                    evento.mostrarDatos();
                    System.out.println("Desea crear otro evento?");
                    resp = scanner.nextLine().trim().toLowerCase();
                    continuar  = (resp.equals("s") || resp.equals("si") || resp.equals("sí"));

                    //SE MUESTRA EL TOTAL DE EVENTOS CREADO
                    System.out.println("TOTAL DE EVENTOS CREADOS\n"+ eventoUniversitario.getCantEventos());
                }
        }
    }
