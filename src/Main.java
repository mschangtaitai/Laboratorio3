import java.util.Scanner;

public class Main {
    private static String getMenu1() {
        return "" +
                "Menu:\n" +
                "1. Crear lista \n" +
                "2. Salir";
    }

    private static String getMenu2() {
        return "" +
                "Menu:\n" +
                "1. Crear lista \n" +
                "2. Ver todas las listas de tareas\n" +
                "3. Seleccionar una lista de tareas\n" +
                "4. Salir";
    }

    private static String getMenu3() {
        return "" +
                "Menu:\n" +
                "1. Deseleccionar lista actual \n" +
                "2. Agregar una tarea\n" +
                "3. Completar una tarea\n" +
                "4. Ver todas las tareas\n" +
                "5. Salir";
    }

    public static void main(String[] args) {
        int n = 1;
        Listados listados = new Listados("Listados de tareas");
        boolean continuar = true;
        do {
            if (listados.getListas().isEmpty()) {
                // Mostrar menu
                System.out.println(getMenu1());

                // Leer del teclado
                System.out.println("Ingrese una opcion: ");
                Scanner input = new Scanner(System.in);
                int option = input.nextInt();
                switch (option) {

                    case 1:
                        System.out.println("Ingrese un nombre para la lista: ");
                        String nameLista = input.next();
                        List list = new List(nameLista);
                        listados.addList(list);
                        break;

                    case 2:
                        continuar = false;
                        break;

                    default:
                        System.out.println("Esta opcion no es valida!");
                        break;

                }
            } else if (!listados.getListas().isEmpty()) {
                // Mostrar menu
                System.out.println(getMenu2());

                // Leer del teclado
                System.out.println("Ingrese una opcion: ");
                Scanner input = new Scanner(System.in);
                int option = input.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Ingrese un nombre para la lista: ");
                        String nameLista = input.next();
                        List list = new List(nameLista);
                        listados.addList(list);
                        break;
                    case 2:
                        System.out.println("Listas: ");
                        n = 1;
                        for (List i : listados.getListas()) {
                            System.out.println(n + ".) " + i.getName());
                            n++;
                        }
                        break;
                    case 3:
                        System.out.println("Que lista desea seleccionear?: ");
                        n = 1;
                        for (List i : listados.getListas()) {
                            System.out.println(n + ".) " + i.getName());
                            n++;
                        }
                        System.out.println("Ingrese una opcion: ");
                        int lista = input.nextInt();
                        boolean salir = false;
                        do {
                            System.out.println("Lista: " + listados.getListas().elementAt(lista - 1).getName());
                            // Mostrar menu
                            System.out.println(getMenu3());

                            // Leer del teclado
                            System.out.println("Ingrese una opcion: ");
                            Scanner opcion = new Scanner(System.in);
                            int opcionlista = opcion.nextInt();
                            switch (opcionlista) {
                                case 1:
                                    salir = true;
                                    break;
                                case 2:
                                    System.out.println("Ingrese un nombre para la tarea: ");
                                    String nameTarea = input.next();
                                    Tarea tarea = new Tarea(nameTarea);
                                    listados.getListas().elementAt(lista - 1).addTarea(tarea);
                                    break;
                                case 3:
                                    System.out.println("Tareas: ");
                                    n = 1;
                                    for (Tarea i : listados.getListas().elementAt(lista - 1).getTareas()) {
                                        System.out.println(n + ".) " + i.getTarea());
                                        n++;
                                    }
                                    System.out.println("Ingrese el numero de tarea que desea completar: ");
                                    Scanner numTarea = new Scanner(System.in);
                                    int Tarea = numTarea.nextInt();
                                    listados.getListas().elementAt(lista - 1).getTareas().elementAt(Tarea - 1).complete();
                                case 4:
                                    System.out.println("Tareas: ");
                                    n = 1;
                                    for (Tarea i : listados.getListas().elementAt(lista - 1).getTareas()) {
                                        System.out.println(n + ".) " + i.getTarea());
                                        n++;
                                    }
                                case 5:
                                    salir = true;
                                    continuar = false;
                                    break;
                                default:
                                    System.out.println("Esta opcion no es valida!");
                                    break;
                            }
                        } while (!salir);
                        break;
                    case 4:
                        continuar = false;
                        break;
                }
            }
            System.out.println("---------------------------------------");
        } while (continuar);
        System.out.println("Adios");
    }
}