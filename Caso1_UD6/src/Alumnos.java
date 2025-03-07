/*
 * Aplicación sin interfaz gráfica solo usando la instrucción System.out.println() de Java,
 *  que permite gestionar la información de estudiantes utilizando primero un array 
 * convencional y luego un ArrayList. Los estudiantes serán almacenados con su nombre, 
 * edad y nota media. Hay un menú principal y un submenú.
 */

// Importamos las clases necesarias
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// Clase principal
public class Alumnos {
    public static void main(String[] args) {
        // Variables de control
        boolean salir = true;
        boolean salirArray = false;
        boolean salirArrayList = false;
        // Creación de un array de objetos de la clase Estudiante
        Estudiante[] estudianteArray = new Estudiante[5];
        int numEstArray = 0;
        // Creación de un ArrayList de objetos de la clase Estudiante
        List<Estudiante> EstudianteArrayList = new ArrayList<Estudiante>();
        // Bucle principal
        while (salir) {

            try {
                // Menú principal
                System.out.println("\nMenú Pricipal:");
                System.out.println("1. Usar Array");
                System.out.println("2. Usar ArrayList");
                System.out.println("3. Salir");
                System.out.println("Selecciona una opción: ");
                // Captura de la opción seleccionada
                Scanner sc = new Scanner(System.in);
                int opcion;
                opcion = sc.nextInt();
                // Switch para seleccionar la opción
                switch (opcion) {
                    case 1:
                        int opcion2;
                        salirArray = true;
                        while (salirArray) {

                            try {
                                // Menú Array
                                System.out.println("\nMenú Array:");
                                System.out.println("1. Agregar un estudiante al array");
                                System.out.println("2. Ver estudiantes en el array");
                                System.out.println("3. Volver al menú principal");
                                System.out.println("Selecciona una opción: ");

                                opcion2 = sc.nextInt();
                                // Switch para seleccionar la opción
                                switch (opcion2) {
                                    // Opción para añadir un estudiante al array
                                    case 1:
                                        // Comprobamos que no se añadan más de 5 estudiantes
                                        if (numEstArray > 4) {
                                            System.out.println("\nNo se pueden agregar más estudiantes");
                                            break;
                                        }
                                        System.out.println("\nNombre del estudiante: ");
                                        String nombre = sc.next();
                                        System.out.println("Edad del estudiante: ");
                                        int edad = sc.nextInt();
                                        System.out.println("Nota final del estudiante: ");
                                        double nota = sc.nextDouble();
                                        estudianteArray[numEstArray] = new Estudiante(nombre, edad, nota);
                                        System.out.println("Estudiante agregado correctamente.");
                                        numEstArray++;
                                        break;
                                    case 2:
                                        // Opción para ver los estudiantes en el array
                                        System.out.println("\nLista de estudiantes en el Array:");
                                        for (int i = 0; i < numEstArray; i++) {
                                            System.out.print("Nombre: " + estudianteArray[i].getNombre() + ", ");
                                            System.out.print("Edad: " + estudianteArray[i].getEdad() + ", ");
                                            System.out.println("Nota: " + estudianteArray[i].getNota());
                                        }
                                        break;
                                    case 3:
                                        // Opción para volver al menú principal
                                        salirArray = false;
                                        break;
                                    default:
                                        // Opción por defecto, indica que se debe ingresar un número del 1 al 3
                                        System.out.println("Por favor, ingrese un número del 1 al 3");
                                        break;
                                }
                            } catch (Exception e) {
                                // Captura de excepciones e indicación de que se debe ingresar un número válido
                                System.out.println("Por favor, ingrese un número válido.\n");
                                sc.nextLine();
                            }
                        }
                        break;
                    case 2:
                        // Menú ArrayList
                        salirArrayList = true;
                        while (salirArrayList) {

                            try {
                                // Menú ArrayList
                                System.out.println("\nMenú ArrayList:");
                                System.out.println("1. Agregar un estudiante al ArrayList");
                                System.out.println("2. Ver estudiantes en el ArrayList");
                                System.out.println("3. Eliminar un estudiante del ArrayList");
                                System.out.println("4. Buscar un estudiante en el ArrayList");
                                System.out.println("5. Volver al menú principal");
                                System.out.println("Selecciona una opción: ");
                                int opcion3 = sc.nextInt();
                                switch (opcion3) {
                                    case 1:
                                        // Opción para añadir un estudiante al ArrayList
                                        System.out.println("\nNombre del estudiante: ");
                                        String nombre = sc.next();
                                        System.out.println("Edad del estudiante: ");
                                        int edad = sc.nextInt();
                                        System.out.println("Nota final del estudiante: ");
                                        double nota = sc.nextDouble();
                                        EstudianteArrayList.add(new Estudiante(nombre, edad, nota));
                                        System.out.println("Estudiante agregado correctamente");
                                        break;
                                    case 2:
                                        // Opción para ver los estudiantes en el ArrayList
                                        System.out.println("\nLista de estudiantes en el ArrayList:");
                                        for (int i = 0; i < EstudianteArrayList.size(); i++) {
                                            System.out.print("Nombre: " + EstudianteArrayList.get(i).getNombre() + ", ");
                                            System.out.print("Edad: " + EstudianteArrayList.get(i).getEdad() + ", ");
                                            System.out.println("Nota: " + EstudianteArrayList.get(i).getNota());
                                        }
                                        break;
                                    case 3:
                                        // Opción para eliminar un estudiante del ArrayList
                                        System.out.println("Nombre del estudiante a eliminar: ");
                                        String nombreEliminar = sc.next();
                                        for (int i = 0; i < EstudianteArrayList.size(); i++) {
                                            if (EstudianteArrayList.get(i).getNombre().equalsIgnoreCase(nombreEliminar)) {
                                                EstudianteArrayList.remove(i);
                                                System.out.println("\nEstudiante eliminado correctamente\n");
                                            }
                                        }
                                        break;
                                    case 4:
                                        // Opción para buscar un estudiante en el ArrayList
                                        System.out.println("Nombre del estudiante a buscar: ");
                                        String nombreBuscar = sc.next();
                                        for (int i = 0; i < EstudianteArrayList.size(); i++) {
                                            if (EstudianteArrayList.get(i).getNombre().equalsIgnoreCase(nombreBuscar)) {
                                                System.out.print("\nNombre: " + EstudianteArrayList.get(i).getNombre() + ", ");
                                                System.out.print("Edad: " + EstudianteArrayList.get(i).getEdad() + ", ");
                                                System.out.println("Nota: " + EstudianteArrayList.get(i).getNota());
                                            }
                                        }
                                        break;
                                    case 5:
                                        // Opción para volver al menú principal
                                        salirArrayList = false;
                                        break;
                                    default:
                                        // Opción por defecto, indica que se debe ingresar un número del 1 al 5
                                        System.out.println("Por favor, ingrese un número del 1 al 5");
                                        break;
                                }
                            } catch (Exception e) {
                                // Captura de excepciones e indicación de que se debe ingresar un número válido
                                System.out.println("Por favor, ingrese un número válido.\n");
                                sc.nextLine();
                            }
                        }
                        break;
                    case 3:
                        // Opción para salir del programa
                        System.out.println("\nSaliendo del programa...");
                        sc.close();
                        salir = false;
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                // Captura de excepciones e indicación de que se debe ingresar un número válido
                System.out.println("Por favor, ingrese un número válido.\n");
                continue;
            }
        }

    }
}

// Clase Estudiante
class Estudiante {
    private String nombre;
    private int edad;
    private double nota;

    public Estudiante(String nombre, int edad, double nota) {
        this.nombre = nombre;
        this.edad = edad;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String toString() {
        return "Nombre: " + nombre + " Edad: " + edad + " Nota: " + nota;
    }
}
