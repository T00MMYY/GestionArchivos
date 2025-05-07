package view.console;

import java.util.Scanner;
import static model.Funciones.countChars;
import static model.Funciones.countWords;
import static model.Funciones.createFile;
import static model.Funciones.createFolder;
import static model.Funciones.deleteFile;
import static model.Funciones.overWriteFile;
import static model.Funciones.showFile;
import static model.Funciones.showListFiles;
import static model.Funciones.swapWords;

/**
 *
 * @author tommyfigjim
 */
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean salir = false;

        do {
            System.out.println("Menu de opciones:");
            System.out.println("1. Crear Carpeta");
            System.out.println("2. Crear Archivo");
            System.out.println("3. Listar Archivos");
            System.out.println("4. Mostrar Contenido de un Archivo");
            System.out.println("5. Modificar Archivo");
            System.out.println("6. Eliminar Archivo");
            System.out.println("7. Contar Caracteres");
            System.out.println("8. Contar Palabras");
            System.out.println("9. Reemplazar Palabras");
             System.out.println("10. Salir");

            System.out.print("Elige una opcion: ");
            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Introduce la ruta de la carpeta a crear: ");
                    String carpeta = scan.nextLine();
                    createFolder(carpeta);
                    break;

                case 2:
                    System.out.print("Introduce la ruta de la carpeta donde quieres crear el archivo: ");
                    String rutaArchivo = scan.nextLine();
                    System.out.print("Introduce el nombre del archivo: ");
                    String fileName = scan.nextLine();
                    System.out.print("Introduce el contenido del archivo: ");
                    String contenido = scan.nextLine();
                    createFile(rutaArchivo, fileName, contenido);
                    break;

                case 3:
                    System.out.print("Introduce la ruta de la carpeta para mostrar una lista de los archivos: ");
                    rutaArchivo  = scan.nextLine();
                    String[] files = showListFiles(rutaArchivo);
                    System.out.println("Archivos en la carpeta:");
                    for (String file : files) {
                        System.out.println(file);
                    }
                    break;

                case 4:
                    System.out.print("Introduce la ruta de la carpeta donde esta el archivo: ");
                    rutaArchivo = scan.nextLine();
                    System.out.print("Introduce el nombre del archivo: ");
                    String showFileName = scan.nextLine();
                    String fileContent = showFile(rutaArchivo, showFileName);
                    System.out.println("Contenido del archivo:");
                    System.out.println(fileContent);
                    break;

                case 5:
                    System.out.print("Introduce la ruta de la carpeta donde esta el archivo: ");
                    rutaArchivo = scan.nextLine();
                    System.out.print("Introduce el nombre del archivo: ");
                    String modifyFileName = scan.nextLine();
                    System.out.print("Introduce el nuevo contenido para el archivo: ");
                    String newContent = scan.nextLine();
                    if (overWriteFile(rutaArchivo, modifyFileName, newContent)) {
                        System.out.println("Archivo modificado con exito.");
                    } else {
                        System.out.println("No se pudo modificar el archivo.");
                    }
                    break;

                case 6:
                    System.out.print("Introduce la ruta de la carpeta donde esta el archivo: ");
                    rutaArchivo = scan.nextLine();
                    System.out.print("Introduce el nombre del archivo a eliminar: ");
                    String deleteFileName = scan.nextLine();
                    deleteFile(rutaArchivo, deleteFileName);
                    break;

                case 7:
                    System.out.print("Ruta de la carpeta: ");
                    rutaArchivo = scan.nextLine();
                    System.out.print("Nombre del archivo: ");
                    String archivoChars = scan.nextLine();
                    int caracteres = countChars(rutaArchivo, archivoChars);
                    System.out.println("Numero de caracteres: " + caracteres);
                    break;

                case 8:
                    System.out.print("Ruta de la carpeta: ");
                    rutaArchivo = scan.nextLine();
                    System.out.print("Nombre del archivo: ");
                    String archivoPalabras = scan.nextLine();
                    int palabras = countWords(rutaArchivo, archivoPalabras);
                    System.out.println("Numero de palabras: " + palabras);
                    break;

                case 9:
                    System.out.print("Ruta de la carpeta: ");
                    rutaArchivo = scan.nextLine();
                    System.out.print("Nombre del archivo: ");
                    String archivoReemplazar = scan.nextLine();
                    System.out.print("Palabra a reemplazar: ");
                    String palabraVieja = scan.nextLine();
                    System.out.print("Nueva palabra: ");
                    String palabraNueva = scan.nextLine();
                    String nuevoContenido = swapWords(rutaArchivo, archivoReemplazar, palabraVieja, palabraNueva);
                    System.out.println("Contenido actualizado:");
                    System.out.println(nuevoContenido);
                    break;

                case 10:
                    salir = true;
                    System.out.println("Saliendo del menu");
                    break;

                default:
                    System.out.println("Opcion no valida. Elige otra opcion.");
                    break;
            }
        } while (!salir);

        scan.close();
    }
}
