import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonas {

    public static void main(String[] args) {

        //
        Scanner scann = new Scanner(System.in);
        List<Persona> personas = new ArrayList<>();
        var salir = false;
        while (!salir){
            mostrarMenu();
            try {
                salir = ejecutarSeleccion(scann, personas);
            }catch (Exception e){
                System.out.println("Ingrese una opcion del menu = " + e);
                System.out.println();
            }
        }
    }

    public static void mostrarMenu(){
        System.out.print("""
                ***** Listado de Personas APP *****
                1. Agregar
                2. Listar
                3. Sair
                """);
        System.out.print("Seleccione la opcion deseada: ");
    }

    public static boolean ejecutarSeleccion(Scanner scann, List<Persona> personas){
        //
        var opcion = Integer.parseInt(scann.nextLine());
        boolean salir = false;
        switch (opcion) {
            case 1 -> { //Agrega el objeto persona a la lista de objetos persona

                System.out.print("Ingrese el nombre de la persona: ");
                var nombre = scann.nextLine();
                System.out.print("Ingrese el telefono de la persona: ");
                var telefono = scann.nextLine();
                System.out.print("Ingrese el email de la persona: ");
                var email = scann.nextLine();

                var persona = new Persona(nombre, telefono, email);
                personas.add(persona);
                System.out.println("La lista tiene: " + personas.size() + " persona(s");
            }
            case 2 -> {// Lista los objetos personas almacenados
                System.out.println("Listado de personas: ");
                //Usando expresiones lambda
                    //personas.forEach(persona -> System.out.println("persona = " + persona));
                //Usando metodo de referencia ( usa los :: )
                personas.forEach(System.out::println);
            }
            case 3 -> {// Sale de la APP
                //
                System.out.println("Hasta pronto!!!");
                salir = true;
            }
            default -> System.out.println("Opcion invalida: " + opcion);
        }
        System.out.println();
        return salir;
    }

}
