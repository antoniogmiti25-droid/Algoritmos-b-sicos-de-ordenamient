
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    // Ordenamiento de burbuja
    public static void burbuja(int[] numeros) {
        for (int i = 0; i < numeros.length - 1; i++) {
            for (int j = 0; j < numeros.length - 1 - i; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    int auxiliar = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = auxiliar;
                }
            }
        }
    }

    // Ordenamiento por inserción
    public static void insercion(int[] numeros) {
        for (int i = 1; i < numeros.length; i++) {
            int actual = numeros[i];
            int j = i - 1;

            while (j >= 0 && numeros[j] > actual) {
                numeros[j + 1] = numeros[j];
                j--;
            }

            numeros[j + 1] = actual;
        }
    }

    // Ordenamiento QuickSort
    public static void quickSort(int[] numeros, int inicio, int fin) {
        if (inicio < fin) {
            int posicion = particion(numeros, inicio, fin);

            quickSort(numeros, inicio, posicion - 1);
            quickSort(numeros, posicion + 1, fin);
        }
    }

    public static int particion(int[] numeros, int inicio, int fin) {
        int pivote = numeros[fin];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (numeros[j] <= pivote) {
                i++;

                int auxiliar = numeros[i];
                numeros[i] = numeros[j];
                numeros[j] = auxiliar;
            }
        }

        int auxiliar = numeros[i + 1];
        numeros[i + 1] = numeros[fin];
        numeros[fin] = auxiliar;

        return i + 1;
    }

    // Busqueda lineal
    public static int busquedaLineal(int[] numeros, int buscado) {
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == buscado) {
                return i;
            }
        }

        return -1;
    }

    // Busqueda binaria: necesita datos ordenados
    public static int busquedaBinaria(int[] numeros, int buscado) {
        int inicio = 0;
        int fin = numeros.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            if (numeros[medio] == buscado) {
                return medio;
            }

            if (numeros[medio] < buscado) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int[] numeros = {8, 3, 6, 1, 9, 2};

        System.out.println("Numeros originales: "
                + Arrays.toString(numeros));

        System.out.println("\nElige un algoritmo:");
        System.out.println("1. Burbuja");
        System.out.println("2. Insercion");
        System.out.println("3. QuickSort");
        System.out.println("4. Busqueda lineal");
        System.out.println("5. Busqueda binaria");
        System.out.print("Opcion: ");

        int opcion = entrada.nextInt();

        switch (opcion) {
            case 1:
                burbuja(numeros);
                System.out.println("Ordenados: "
                        + Arrays.toString(numeros));
                break;

            case 2:
                insercion(numeros);
                System.out.println("Ordenados: "
                        + Arrays.toString(numeros));
                break;

            case 3:
                quickSort(numeros, 0, numeros.length - 1);
                System.out.println("Ordenados: "
                        + Arrays.toString(numeros));
                break;

            case 4:
                System.out.print("Numero a buscar: ");
                int buscadoLineal = entrada.nextInt();

                int resultadoLineal =
                        busquedaLineal(numeros, buscadoLineal);

                if (resultadoLineal != -1) {
                    System.out.println("Encontrado en la posicion: "
                            + resultadoLineal);
                } else {
                    System.out.println("Numero no encontrado.");
                }
                break;

            case 5:
                Arrays.sort(numeros);

                System.out.println("Datos ordenados: "
                        + Arrays.toString(numeros));

                System.out.print("Numero a buscar: ");
                int buscadoBinario = entrada.nextInt();

                int resultadoBinario =
                        busquedaBinaria(numeros, buscadoBinario);

                if (resultadoBinario != -1) {
                    System.out.println("Encontrado en la posicion: "
                            + resultadoBinario);
                } else {
                    System.out.println("Numero no encontrado.");
                }
                break;

            default:
                System.out.println("Opcion no valida.");
        }

        entrada.close();
    }
}
