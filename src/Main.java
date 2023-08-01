import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("MÉTODOS DE VALORACIÓN DE STOCK:");
        System.out.println("1. Precio Medio Ponderado Móvil");
        System.out.println("2. Precio Medio Ponderado Fijo");
        System.out.print("Seleccione el método (1 o 2): ");
        int metodo = scanner.nextInt();

        double valoracionStock = 0;

        if (metodo == 1) {
            valoracionStock = precioMedioPonderadoMovil();
        } else if (metodo == 2) {
            valoracionStock = precioMedioPonderadoFijo();
        } else {
            System.out.println("Opción inválida. Seleccione 1 o 2 para el método.");
            System.exit(1);
        }

        System.out.println("La valoración del stock es: " + valoracionStock);

    }

    private static double precioMedioPonderadoFijo() {
        System.out.print("Ingrese el número de dias de adquisicion de productos: ");
        Scanner scanner;
        scanner = new Scanner(System.in);

        int n= scanner.nextInt();

        List<Integer> listCantidad = new ArrayList<>();
        List<Double> listPrecUnit = new ArrayList<>();
        List<Double> listTotal = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese el precio unitario de compra del día " + (i+1) + ": ");
            double precioUnitCompra = scanner.nextDouble();
            listPrecUnit.add(precioUnitCompra);

            System.out.print("Ingrese la cantidad comprada del producto del día " + (i+1) + ": ");
            int cantidad = scanner.nextInt();
            listCantidad.add(cantidad);

            System.out.println("El precio total del dia es de: " + (precioUnitCompra*cantidad));
            double precioTotalCompra = precioUnitCompra*cantidad;
            listTotal.add(precioTotalCompra);
        }

        double sumaTotalCompras = 0.0;
        double sumaCantidadComprasT = 0.0;
        double sumaCantidadCompras = 0.0;

        for (int i = 0; i < n; i++) {
            sumaTotalCompras += listTotal.get(i);
            sumaCantidadComprasT += listCantidad.get(i);
        }

        for (int i = 0; i < n-1; i++) {
            sumaCantidadCompras += listCantidad.get(i);
        }

        double precioFijoConsumo = sumaTotalCompras / sumaCantidadComprasT;
        System.out.println("El precio fijo es: " + precioFijoConsumo);

        System.out.print("Ingrese la cantidad de consumo: ");
        int cantidadConsumo = scanner.nextInt();

        System.out.println("El valor del consumo es: " + (precioFijoConsumo*cantidadConsumo));
        double valorConsumo = precioFijoConsumo*cantidadConsumo;

        System.out.println("La cantidad de stock es: " + (sumaCantidadCompras-cantidadConsumo));
        int cantidadStock = (int) (sumaCantidadCompras-cantidadConsumo);

        double valorStock = cantidadStock*precioFijoConsumo;

        return valorStock;
    }

    public static double precioMedioPonderadoMovil() {
        System.out.print("Ingrese el número de dias de adquisicion de productos: ");
        Scanner scanner;
        scanner = new Scanner(System.in);

        int n= scanner.nextInt();

        List<Integer> listCantidad = new ArrayList<>();
        List<Double> listPrecUnit = new ArrayList<>();
        List<Double> listTotal = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese el precio unitario de compra del día " + (i+1) + ": ");
            double precioUnitCompra = scanner.nextDouble();
            listPrecUnit.add(precioUnitCompra);

            System.out.print("Ingrese la cantidad comprada del producto del día " + (i+1) + ": ");
            int cantidad = scanner.nextInt();
            listCantidad.add(cantidad);

            System.out.println("El precio total del dia es de: " + (precioUnitCompra*cantidad));
            double precioTotalCompra = precioUnitCompra*cantidad;
            listTotal.add(precioTotalCompra);
        }

        double sumaTotalCompras = 0.0;
        double sumaCantidadCompras = 0.0;

        for (int i = 0; i < n; i++) {
            sumaTotalCompras += listTotal.get(i);
            sumaCantidadCompras += listCantidad.get(i);
        }

        double precioMedioConsumo = sumaTotalCompras / sumaCantidadCompras;
        System.out.println("El precio medio es: " + precioMedioConsumo);

        System.out.print("Ingrese la cantidad de consumo: ");
        int cantidadConsumo = scanner.nextInt();

        System.out.println("El valor del consumo es: " + (precioMedioConsumo*cantidadConsumo));
        double valorConsumo = precioMedioConsumo*cantidadConsumo;

        System.out.println("La cantidad de stock es: " + (sumaCantidadCompras-cantidadConsumo));
        int cantidadStock = (int) (sumaCantidadCompras-cantidadConsumo);

        double valorStock = cantidadStock*precioMedioConsumo;

        return valorStock;
    }


}