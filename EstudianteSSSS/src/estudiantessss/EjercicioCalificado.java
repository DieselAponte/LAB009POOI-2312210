package EstudianteSSSS;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class EjercicioCalificado {

    public static void main(String[] args) {
        Estudiantes2023 listaEstudiantes = new Estudiantes2023();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("****** BIENVENIDOS AL SISTEMA DE GESTION DE ESTUDIANTES ******");

        do {
            System.out.println("1-NUEVO ESTUDIANTE");
            System.out.println("2-BUSCAR ESTUDIANTE");
            System.out.println("3-ELIMINAR ESTUDIANTE");
            System.out.println("4-MODIFICAR ESTUDIANTE");
            System.out.println("5-MODIFICAR APELLIDOS EN MINÚSCULAS");
            System.out.println("6-VER TODOS LOS ESTUDIANTES");
            System.out.println("7-VER TODOS LOS ESTUDIANTES POR APELLIDOS");
            System.out.println("8-VER TODOS LOS ESTUDIANTES POR PENSIÓN");
            System.out.println("9-TOTAL DE PENSIONES");
            System.out.println("10-SALIR");
            System.out.print("¿QUÉ ACTIVIDAD DESEA EJECUTAR? ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("****** REGISTRAR A UN NUEVO ESTUDIANTE ******");
                    System.out.print("INGRESE NOMBRES: ");
                    String nombres = scanner.next();
                    System.out.print("INGRESE APELLIDOS: ");
                    String apellidos = scanner.next();
                    System.out.print("INGRESE CICLO: ");
                    int ciclo = scanner.nextInt();
                    System.out.print("INGRESE PENSION: ");
                    double pension = scanner.nextDouble();

                    // Crea un nuevo estudiante y agrégalo a la lista de estudiantes
                    Estudiante nuevoEstudiante = new Estudiante(listaEstudiantes.tamano() + 1, nombres + " " + apellidos, ciclo, pension);
                    listaEstudiantes.adicionar(nuevoEstudiante);
                    System.out.println("¡Se añadió con éxito!");
                    break;
                case 2:
                    System.out.println("****** BUSCAR A UN ESTUDIANTE ******");
                    System.out.println("PUEDE BUSCAR POR NOMBRE O CÓDIGO. ELEGIR UNA OPCIÓN:");
                    System.out.println("A – APELLIDO");
                    System.out.println("B – CÓDIGO");
                    System.out.print("ELEGIR UNA OPCIÓN: ");
                    char opcionBusqueda = scanner.next().charAt(0);

                    if (opcionBusqueda == 'A') {
                        System.out.print("INGRESE EL APELLIDO DEL ALUMNO: ");
                        String apellidoBusqueda = scanner.next();

                        // Buscar estudiantes por apellido
                        boolean encontrado = false;
                        for (Estudiante estudiante : listaEstudiantes.getEstudiantes()) {
                            if (estudiante.getNombre().toLowerCase().contains(apellidoBusqueda.toLowerCase())) {
                                System.out.println(estudiante.toString());
                                encontrado = true;
                            }
                        }
                        if (!encontrado) {
                            System.out.println("(*) Si no existe indicar el alumno no está registrado.");
                        }
                    } else if (opcionBusqueda == 'B') {
                        System.out.print("INGRESE EL CÓDIGO DEL ALUMNO: ");
                        int codigoBusqueda = scanner.nextInt();

                        // Buscar estudiantes por código
                        boolean encontrado = false;
                        for (Estudiante estudiante : listaEstudiantes.getEstudiantes()) {
                            if (estudiante.getCodigo() == codigoBusqueda) {
                                System.out.println(estudiante.toString());
                                encontrado = true;
                                break; // Puedes detener la búsqueda una vez que encuentres el estudiante.
                            }
                        }
                        if (!encontrado) {
                            System.out.println("(*) Si no existe indicar el alumno no está registrado.");
                        }
                    } else {
                        System.out.println("Opción no válida.");
                    }

                    break;
                case 3:
                    System.out.print("INGRESE EL CÓDIGO DEL ESTUDIANTE QUE DESEA ELIMINAR: ");
                    int codigoEliminar = scanner.nextInt();

                    // Buscar el estudiante por código y eliminarlo si se encuentra
                    boolean eliminado = false;
                    for (Estudiante estudiante : listaEstudiantes.getEstudiantes()) {
                        if (estudiante.getCodigo() == codigoEliminar) {
                            listaEstudiantes.eliminar(estudiante);
                            eliminado = true;
                            System.out.println("Estudiante eliminado con éxito.");

                            // Actualizar el archivo estudiantes.txt eliminando al estudiante
                            listaEstudiantes.actualizarArchivo();

                            break; // Puedes detener la búsqueda una vez que elimines el estudiante.
                        }
                    }
                    if (!eliminado) {
                        System.out.println("No se encontró ningún estudiante con ese código.");
                    }
                    break;
                case 4:
                    System.out.print("INDIQUE EL CÓDIGO DEL ESTUDIANTE A MODIFICAR: ");
                    int codigoModificar = scanner.nextInt();

                    // Buscar el estudiante por código y modificar sus datos si se encuentra
                    boolean modificado = false;
                    for (Estudiante estudiante : listaEstudiantes.getEstudiantes()) {
                        if (estudiante.getCodigo() == codigoModificar) {
                            System.out.println("Datos actuales del estudiante:");
                            System.out.println(estudiante.toString());

                            System.out.print("INGRESE NUEVOS NOMBRES: ");
                            String nuevosNombres = scanner.next();
                            System.out.print("INGRESE NUEVOS APELLIDOS: ");
                            String nuevosApellidos = scanner.next();
                            System.out.print("INGRESE NUEVO CICLO: ");
                            int nuevoCiclo = scanner.nextInt();
                            System.out.print("INGRESE NUEVA PENSION: ");
                            double nuevaPension = scanner.nextDouble();

                            // Modificar los datos del estudiante
                            estudiante.setNombre(nuevosNombres + " " + nuevosApellidos);
                            estudiante.setCiclo(nuevoCiclo);
                            estudiante.setPension(nuevaPension);

                            // Actualizar el archivo estudiantes.txt con los datos modificados
                            listaEstudiantes.actualizarArchivo();

                            System.out.println("¡Se modificó con éxito!");
                            modificado = true;
                            break; // Puedes detener la búsqueda una vez que modifiques el estudiante.
                        }
                    }
                    if (!modificado) {
                        System.out.println("No se encontró ningún estudiante con ese código.");
                    }
                case 5:
                    System.out.println("****** MODIFICACIÓN ESTUDIANTE MINÚSCULA ********");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("CODIGO DE ESTUDIANTE NOMBRE Y APELLIDOS CICLO PENSION");
                    System.out.println("-------------------------------------------------------------");

                    // Mostrar lista antes de la modificación
                    for (Estudiante est : listaEstudiantes.getEstudiantes()) {
                        System.out.println(est.getCodigo() + " " + est.getNombre() + " " + est.getCiclo() + " " + est.getPension());
                    }

                    System.out.println("-------------------------------------------------------------");

                    // Modificar automáticamente todos los apellidos a mayúsculas
                    for (Estudiante estudiante : listaEstudiantes.getEstudiantes()) {
                        String[] nombresApellidos = estudiante.getNombre().split(" ");
                        if (nombresApellidos.length > 1) {
                            String nombre = nombresApellidos[0];
                            String apellidosMinus = nombresApellidos[1];
                            if (nombresApellidos.length > 2) {
                                for (int i = 2; i < nombresApellidos.length; i++) {
                                    apellidosMinus += " " + nombresApellidos[i];
                                }
                            }
                            // Convertir la primera letra de cada apellido a mayúscula
                            String[] apellidosArray = apellidosMinus.split(" ");
                            for (int i = 0; i < apellidosArray.length; i++) {
                                apellidosArray[i] = apellidosArray[i].substring(0, 1).toUpperCase() + apellidosArray[i].substring(1);
                            }
                            apellidos = String.join(" ", apellidosArray);

                            estudiante.setNombre(nombre + " " + apellidos);
                        }
                    }

                    // Mostrar lista después de la modificación
                    System.out.println("****** MODIFICACIÓN ESTUDIANTE MAYÚSCULA ********");
                    System.out.println("La nueva lista después de la modificación:");
                    System.out.println("-------------------------------------------------------------");

                    for (Estudiante est : listaEstudiantes.getEstudiantes()) {
                        System.out.println(est.getCodigo() + " " + est.getNombre() + " " + est.getCiclo() + " " + est.getPension());
                    }

                    System.out.println("-------------------------------------------------------------");
                    System.out.println("¡Se modificaron los apellidos a mayúsculas con éxito.");
                    break;
                case 6:
                    System.out.println("****** LISTA DE ESTUDIANTES ********");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("CODIGO DE ESTUDIANTE NOMBRE Y APELLIDOS CICLO PENSION");
                    System.out.println("-------------------------------------------------------------");

                    for (Estudiante est : listaEstudiantes.getEstudiantes()) {
                        System.out.println(est.getCodigo() + " " + est.getNombre() + " " + est.getCiclo() + " " + est.getPension());
                    }

                    System.out.println("-------------------------------------------------------------");
                    break;
                case 7:
                    System.out.println("****** LISTA DE ESTUDIANTES POR APELLIDOS ********");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("CODIGO DE ESTUDIANTE NOMBRE CICLO PENSION");
                    System.out.println("-------------------------------------------------------------");

                    // Ordenar la lista de estudiantes por nombre (que contendrá apellidos)
                    List<Estudiante> estudiantesPorApellidos = new ArrayList<>(listaEstudiantes.getEstudiantes());
                    Collections.sort(estudiantesPorApellidos, new Comparator<Estudiante>() {
                        @Override
                        public int compare(Estudiante est1, Estudiante est2) {
                            return est1.getNombre().compareTo(est2.getNombre());
                        }
                    });

                    // Mostrar la lista ordenada
                    for (Estudiante est : estudiantesPorApellidos) {
                        System.out.println(est.getCodigo() + " " + est.getNombre() + " " + est.getCiclo() + " " + est.getPension());
                    }

                    System.out.println("-------------------------------------------------------------");
                    break;

                case 8:
                    System.out.println("****** VER TODOS LOS ESTUDIANTES POR PENSIÓN  ******");

                    // Clonar la lista de estudiantes para no modificar la original
                    List<Estudiante> estudiantesPorPension = new ArrayList<>(listaEstudiantes.getEstudiantes());

                    // Ordenar la lista de estudiantes por pensión de manera ascendente
                    Collections.sort(estudiantesPorPension, new Comparator<Estudiante>() {
                    @Override
                    public int compare(Estudiante est1, Estudiante est2) {
                    return Double.compare(est1.getPension(), est2.getPension());
                    }
                    });

                    // Mostrar la lista ordenada con pensión y nombre
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("PENSION NOMBRE");
                    System.out.println("-------------------------------------------------------------");

                    for (Estudiante est : estudiantesPorPension) {
                    System.out.println(est.getPension() + " " + est.getNombre());
                    }

                    System.out.println("-------------------------------------------------------------");
                    break;
                case 9:
                    System.out.println("****** SUMA TOTAL DE LAS PENSIONES ******");
                    double sumaPensiones = 0;

                    for (Estudiante estudiante : listaEstudiantes.getEstudiantes()) {
                    sumaPensiones += estudiante.getPension();
                    }

                    System.out.println("La suma total de las pensiones es: " + sumaPensiones);
                    break;
                case 10:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }

            if (opcion != 10) {
                System.out.print("¿DESEA INGRESAR OTRA OPCIÓN? (1-SÍ, 0-NO): ");
                int continuar = scanner.nextInt();
                if (continuar != 1) {
                    opcion = 10; // Terminar el bucle
                }
            }
        } while (opcion != 10);
    }
}
