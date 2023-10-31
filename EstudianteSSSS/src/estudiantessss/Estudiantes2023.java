package EstudianteSSSS;

import java.util.*;
import javax.swing.*;
import java.io.*;

public class Estudiantes2023 {

    private static ArrayList<Estudiante> estudiantes;

    public Estudiantes2023() {
        estudiantes = new ArrayList<>();
        cargarArchivo();
    }

    public void adicionar(Estudiante estudiante) {
        estudiantes.add(estudiante);
        try {
            FileWriter writer = new FileWriter("estudiantes.txt", true);
            writer.write(estudiante.getCodigo() + "," + estudiante.getNombre() + "," + estudiante.getCiclo() + "," + estudiante.getPension() + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo estudiantes.txt.");
        }
    }

    public void eliminar(Estudiante estudiante) {
        //Introduce codigo
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void actualizarArchivo() {
        try {
            FileWriter writer = new FileWriter("estudiantes.txt");
            for (Estudiante estudiante : estudiantes) {
                writer.write(estudiante.getCodigo() + "," + estudiante.getNombre() + "," + estudiante.getCiclo() + "," + estudiante.getPension() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al actualizar el archivo estudiantes.txt.");
        }
    }

    public Estudiante obtener(int pos) {
        //Introduce codigo
        return null;
    }

    public Estudiante buscar(int codigo) {
        //Introduce codigo        
        return null;
    }

    public int tamano() {
        //Introduce codigo        
        return 0;
    }

    public void listarEstudiantes() {
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante.toString());
        }
    }

    // M?todos para manipular el archivo de texto
    private void readFromInputStream(InputStream inputStream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String linea;
        while ((linea = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(linea, ",");
            createStudent(st);
        }
        br.close();
    }

    // Metodo que añadir a los estudiantes del archivo .txt en el arrayList estudiantes.
    private void createStudent(StringTokenizer st) {
        int codigo = Integer.parseInt(st.nextToken().trim());
        String nombre = st.nextToken().trim();
        int ciclo = Integer.parseInt(st.nextToken().trim());
        double pension = Double.parseDouble(st.nextToken().trim());
        Estudiante estudiante = new Estudiante(codigo, nombre, ciclo, pension);
        adicionar(estudiante);
    }

    // M?todos para manipular el archivo de texto
    private void cargarArchivo() {
        try {
            File file = new File("./src/EstudianteSSSS/estudiantes.txt");
            Class<Estudiantes2023> clazz = Estudiantes2023.class;
            InputStream inputStream = clazz.getResourceAsStream("/EstudianteSSSS/estudiantes.txt");
            if (file.exists()) {
                readFromInputStream(inputStream);
            } else {
                JOptionPane.showMessageDialog(null,
                        "El archivo estudiantes.txt no existe");
            }
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Se produjo un error= " + x);
        }
    }
}
