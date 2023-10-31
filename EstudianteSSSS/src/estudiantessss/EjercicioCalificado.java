package EstudianteSSSS;

public class EjercicioCalificado {
    public static void main(String[] args) {
        Estudiantes2023 listaEstudiantes = new Estudiantes2023();
        System.out.println("Total de estudiantes cargados: " + listaEstudiantes.tamano());
        listaEstudiantes.listarEstudiantes();
    }
}