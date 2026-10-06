package rutaalumnos;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class RutaAlumnos {

    public static void recorrerCarpetasAlumnos(String rutaBase) {
        File directorioBase = new File(rutaBase);

        if (!directorioBase.exists() || !directorioBase.isDirectory()) {
            System.out.println("La ruta base no existe o no es un directorio: " + rutaBase);
            return;
        }

        File[] carpetasAlumnos = directorioBase.listFiles(File::isDirectory);

        if (carpetasAlumnos == null || carpetasAlumnos.length == 0) {
            System.out.println("No se encontraron carpetas de alumnos en: " + rutaBase);
            return;
        }

        for (File carpetaAlumno : carpetasAlumnos) {
            String nombreAlumno = carpetaAlumno.getName();
            File archivoNotas = new File(carpetaAlumno, "notas.txt");

            if (archivoNotas.exists()) {
                System.out.println("\n=== Alumno: \" + nombreAlumno + \" ===");
                        leerArchivoNotas(archivoNotas);
            } else {
                System.out.println("No se encontró archivo notas.txt en la carpeta: " + nombreAlumno);
            }
        }
    }

    private static void leerArchivoNotas(File archivo) {
        try (Scanner lector = new Scanner(archivo)) {
            lector.useLocale(Locale.US);
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                String[] partes = linea.split("\t");
                if (partes.length == 2) {
                    String asignatura = partes[0];
                    double nota = Double.parseDouble(partes[1]);
                    System.out.println(asignatura + ": " + nota);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Problemas de lectura del archivo: " + archivo.getName());
        }
    }

        public static void main(String[] args) {

            recorrerCarpetasAlumnos("RutaAlumnos");
            //creacion lista de datos Alumnos
            List<Alumno> listaAlumnos = new ArrayList<>();

            //lectura del archivo y almacenado de datos en la lista Alumnos.


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
                    if (listaAlumno.getNota() >= listaAlumnos.get(0).getNota()) {
                        maximo = listaAlumno.getNota();
                        alumnoMaximo = listaAlumno.getNombre();
                    }
                    if (listaAlumno.getNota() <= listaAlumnos.get(0).getNota()) {
                        minimo = listaAlumno.getNota();
                        alumnoMinimo = listaAlumno.getNombre();
                    }
                }
                System.out.println("sumaNotas: " + sumaNotas);
                        System.out.println("contador: " + contador);
                                System.out.println("media: " + sumaNotas / contador);
                                        System.out.println("nota m?nima: " + alumnoMinimo + " : " + minimo);
                                                System.out.println("nota maxima: " + alumnoMaximo + " : " + maximo);
            } else {
                System.out.println("No hay alumnos en el archivo");
            }

        }

    }

