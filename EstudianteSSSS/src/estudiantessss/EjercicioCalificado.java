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
                
