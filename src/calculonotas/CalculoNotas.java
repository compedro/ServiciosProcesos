package calculonotas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

class Alumno {

    private String nombre;
    private double nota;

    public Alumno(String nombre, double nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public double getNota() {
        return nota;
    }
}

public class CalculoNotas {

    public static void main(String[] args) {

        // creación del fichero
        File fichero = new File("notas.txt");
        try {
            fichero.createNewFile();
        } catch (IOException ex) {
            System.out.println("Problemas con el fichero...");
        }

        //creacion lista de datos Alumnos
        List<Alumno> listaAlumnos = new ArrayList<>();

        //lectura del archivo y almacenado de datos en la lista Alumnos.
        try (Scanner lector = new Scanner(fichero)) {
            lector.useLocale(Locale.US);
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                String[] partes = linea.split("\t");
                if (partes.length == 2) {
                    String nombre = partes[0];
                    double nota = Double.parseDouble(partes[1]);
                    listaAlumnos.add(new Alumno(nombre, nota));
                }
                System.out.println(linea);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Problemas de lectura...");
        }

        //Procesado de los datos
        if (!listaAlumnos.isEmpty()) {

            double sumaNotas = 0;
            int contador = 0;
            double minimo = 0;
            String alumnoMinimo = null;
            double maximo = 0;
            String alumnoMaximo = null;
            for (Alumno listaAlumno : listaAlumnos) {
                sumaNotas = sumaNotas + listaAlumno.getNota();
                contador++;
                if (listaAlumno.getNota()>=listaAlumnos.get(0).getNota()) {maximo=listaAlumno.getNota(); alumnoMaximo=listaAlumno.getNombre();}                
                 if (listaAlumno.getNota()<=listaAlumnos.get(0).getNota()) {minimo=listaAlumno.getNota();alumnoMinimo = listaAlumno.getNombre(); }
            }
            System.out.println("sumaNotas: " + sumaNotas);
            System.out.println("contador: " + contador);
            System.out.println("media: " + sumaNotas / contador);
            System.out.println("nota mínima: "+ alumnoMinimo+ " : " +minimo);
            System.out.println("nota maxima: "+ alumnoMaximo+ " : " +maximo);
        } else {
            System.out.println("No hay alumnos en el archivo");
        }

    }

}
