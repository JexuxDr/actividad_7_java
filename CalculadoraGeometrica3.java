import java.util.Scanner;

public class CalculadoraGeometrica3 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Seleccione la unidad de medida:");
            System.out.println("1. Metros");
            System.out.println("2. Centímetros");
            System.out.println("3. Milímetros");
            System.out.print("Ingrese el número de la unidad (1-3): ");
            int unidadSeleccionada = obtenerOpcionValida(entrada, 1, 3);
            String unidad = obtenerUnidad(unidadSeleccionada);

            System.out.println("Calculadora de Área, Perímetro y Potencia de Figuras Geométricas");
            System.out.println("Seleccione una figura:");
            System.out.println("1. Círculo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Triángulo");
            System.out.println("4. Rectángulo");
            System.out.println("5. Pentágono");
            System.out.print("Ingrese el número de la figura (1-5): ");
            int figuraSeleccionada = obtenerOpcionValida(entrada, 1, 5);

            System.out.println("Seleccione la operación:");
            System.out.println("1. Área");
            System.out.println("2. Perímetro");
            System.out.println("3. Potencia");
            System.out.print("Ingrese el número de la operación (1-3): ");
            int operacionSeleccionada = obtenerOpcionValida(entrada, 1, 3);

            double resultado = 0;
            switch (figuraSeleccionada) {
                case 1:
                    resultado = calcularCirculo(entrada, unidad, operacionSeleccionada);
                    break;
                case 2:
                    resultado = calcularCuadrado(entrada, unidad, operacionSeleccionada);
                    break;
                case 3:
                    resultado = calcularTriangulo(entrada, unidad, operacionSeleccionada);
                    break;
                case 4:
                    resultado = calcularRectangulo(entrada, unidad, operacionSeleccionada);
                    break;
                case 5:
                    resultado = calcularPentagono(entrada, unidad, operacionSeleccionada);
                    break;
                default:
                    System.out.println("Opción de figura no válida.");
                    break;
            }

            if (resultado != 0) {
                String operacion = obtenerOperacion(operacionSeleccionada);
                System.out.println(operacion + " calculada: " + resultado + " " + unidad);
            }

            System.out.print("¿Desea realizar el cálculo de otra figura? (s/n): ");
            entrada.nextLine();
            String respuesta = entrada.nextLine();
            if (respuesta.equalsIgnoreCase("n")) {
                continuar = false;
                System.out.println("Programa finalizado.");
            }
        }

        entrada.close();
    }

    private static int obtenerOpcionValida(Scanner entrada, int min, int max) {
        int opcion;
        while (true) {
            opcion = entrada.nextInt();
            if (opcion >= min && opcion <= max) {
                break;
            } else {
                System.out.print("Opción no válida. Ingrese un número entre " + min + " y " + max + ": ");
            }
        }
        return opcion;
    }

    private static String obtenerUnidad(int unidadSeleccionada) {
        switch (unidadSeleccionada) {
            case 1:
                return "metros";
            case 2:
                return "centímetros";
            case 3:
                return "milímetros";
            default:
                return "unidades";
        }
    }

    private static String obtenerOperacion(int operacionSeleccionada) {
        switch (operacionSeleccionada) {
            case 1:
                return "Área";
            case 2:
                return "Perímetro";
            case 3:
                return "Potencia";
            default:
                return "Operación no válida";
        }
    }

    private static double calcularCirculo(Scanner entrada, String unidad, int operacionSeleccionada) {
        System.out.print("Ingrese el radio del círculo en " + unidad + ": ");
        double radioCirculo = entrada.nextDouble();
        if (operacionSeleccionada == 1) {
            return Math.PI * Math.pow(radioCirculo, 2);
        } else if (operacionSeleccionada == 2) {
            return 2 * Math.PI * radioCirculo;
        } else if (operacionSeleccionada == 3) {
            System.out.print("Ingrese el exponente para la potencia del radio: ");
            int exponente = entrada.nextInt();
            return calcularPotencia(radioCirculo, exponente);
        }
        return 0;
    }

    private static double calcularCuadrado(Scanner entrada, String unidad, int operacionSeleccionada) {
        System.out.print("Ingrese la longitud del lado del cuadrado en " + unidad + ": ");
        double ladoCuadrado = entrada.nextDouble();
        if (operacionSeleccionada == 1) {
            return Math.pow(ladoCuadrado, 2);
        } else if (operacionSeleccionada == 2) {
            return 4 * ladoCuadrado;
        } else if (operacionSeleccionada == 3) {
            System.out.print("Ingrese el exponente para la potencia del lado: ");
            int exponente = entrada.nextInt();
            return calcularPotencia(ladoCuadrado, exponente);
        }
        return 0;
    }

    private static double calcularTriangulo(Scanner entrada, String unidad, int operacionSeleccionada) {
        if (operacionSeleccionada == 1) {
            System.out.print("Ingrese la base del triángulo en " + unidad + ": ");
            double baseTriangulo = entrada.nextDouble();
            System.out.print("Ingrese la altura del triángulo en " + unidad + ": ");
            double alturaTriangulo = entrada.nextDouble();
            return 0.5 * baseTriangulo * alturaTriangulo;
        } else if (operacionSeleccionada == 2) {
            System.out.print("Ingrese la longitud de los tres lados del triángulo en " + unidad + ": ");
            double ladoTriangulo1 = entrada.nextDouble();
            double ladoTriangulo2 = entrada.nextDouble();
            double ladoTriangulo3 = entrada.nextDouble();
            return ladoTriangulo1 + ladoTriangulo2 + ladoTriangulo3;
        } else if (operacionSeleccionada == 3) {
            System.out.print("Ingrese el exponente para la potencia de un lado: ");
            int exponente = entrada.nextInt();
            double ladoTriangulo = entrada.nextDouble();
            return calcularPotencia(ladoTriangulo, exponente);
        }
        return 0;
    }

    private static double calcularRectangulo(Scanner entrada, String unidad, int operacionSeleccionada) {
        System.out.print("Ingrese la longitud del rectángulo en " + unidad + ": ");
        double longitudRectangulo = entrada.nextDouble();
        System.out.print("Ingrese el ancho del rectángulo en " + unidad + ": ");
        double anchoRectangulo = entrada.nextDouble();
        if (operacionSeleccionada == 1) {
            return longitudRectangulo * anchoRectangulo;
        } else if (operacionSeleccionada == 2) {
            return 2 * (longitudRectangulo + anchoRectangulo);
        } else if (operacionSeleccionada == 3) {
            System.out.print("Ingrese el exponente para la potencia de la longitud: ");
            int exponente = entrada.nextInt();
            return calcularPotencia(longitudRectangulo, exponente);
        }
        return 0;
    }

    private static double calcularPentagono(Scanner entrada, String unidad, int operacionSeleccionada) {
        System.out.print("Ingrese la longitud del lado del pentágono en " + unidad + ": ");
        double ladoPentagono = entrada.nextDouble();
        if (operacionSeleccionada == 1) {
            return 0.25 * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * Math.pow(ladoPentagono, 2);
        } else if (operacionSeleccionada == 2) {
            return 5 * ladoPentagono;
        } else if (operacionSeleccionada == 3) {
            System.out.print("Ingrese el exponente para la potencia del lado: ");
            int exponente = entrada.nextInt();
            return calcularPotencia(ladoPentagono, exponente);
        }
        return 0;
    }

    private static double calcularPotencia(double base, int exponente) {
        if (exponente == 0) {
            return 1;
        } else {
            return base * calcularPotencia(base, exponente - 1);
        }
    }
}
