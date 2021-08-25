import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        boolean salir = false;
        String valores_Ingresados_Usuario = "";
        String valores_Separados[];
        HashMap<String, Double> valoresGuardados = new HashMap<>();
        double x = 0;
        double y = 0;

        String regex = ".*[a-zA-Z].*";

        while (salir == false) {
            System.out.println("Escoge una de las siguientes opciones:");

            System.out.println("1. sumar");
            System.out.println("2. restar");
            System.out.println("3. multiplicar");
            System.out.println("4. dividir");
            System.out.println("5. Mostrar");
            System.out.println("6. Salir");
            int opcionEscogida = sc.nextInt();

            switch (opcionEscogida) {
                case 1:
                    System.out.println("ingrese los valores a sumar, y opcionalmente el nombre de la variable donde almacenar el resultado ");
                    System.out.println("Seguir el orden numero, numero y por último (Opcional) el nombre sin separar letras");
                    System.out.println("por ejemplo \"23'15'nombreSuma\" :");
                    valores_Ingresados_Usuario = sc.next();
                    break;
                case 2:
                    System.out.println("ingrese los valores a restar, y opcionalmente el nombre de la variable donde almacenar el resultado ");
                    System.out.println("Seguir el orden numero, numero a restar y por último (Opcional) el nombre sin separar letras");
                    System.out.println("por ejemplo \"23'15'nombrerResta\" :");
                    valores_Ingresados_Usuario = sc.next();
                    break;
                case 3:
                    System.out.println("ingrese los valores a multiplicar, y opcionalmente el nombre de la variable donde almacenar el resultado ");
                    System.out.println("Seguir el orden numero, numero y por último (Opcional) el nombre sin separar letras");
                    System.out.println("por ejemplo \"23'15'nombreMultiplicacion\" :");
                    valores_Ingresados_Usuario = sc.next();
                    break;
                case 4:
                    System.out.println("ingrese los valores a dividir, y opcionalmente el nombre de la variable donde almacenar el resultado ");
                    System.out.println("Seguir el orden Numerador, Denominador y por último (Opcional) el nombre sin separar letras");
                    System.out.println("por ejemplo \"23'15'nombreDivision\" :");
                    valores_Ingresados_Usuario = sc.next();
                    break;
                case 5:
                    System.out.println("ingrese el nombre de la variable, sin separar letras, que contiene el resultado que quiere validar:");
                    System.out.println("por ejemplo \"nombreOperacion\":");
                    valores_Ingresados_Usuario = sc.next();
                    break;
                case 6:
                    System.out.println("Seleccionó salir.");
                    salir = true;
                    sc.close();
                    break;
                default:
                    System.out.println("Escogió un valor inválido.");


            }

            valores_Separados = valores_Ingresados_Usuario.split("\'", 3);


            if (valores_Separados.length > 1) {
                if (opcionEscogida < 5) {
                    if (valores_Separados[0].matches(regex) && valores_Separados[1].matches(regex) == false) {
                        try {
                            x = valoresGuardados.get(valores_Separados[0]);
                            y = Double.parseDouble(valores_Separados[1]);
                        } catch (Exception e) {
                            System.out.println("No existia un valor guardado dentro de la variable: " + valores_Separados[0]);
                            e.printStackTrace();
                        }

                    } else if (valores_Separados[0].matches(regex) == false && valores_Separados[1].matches(regex)) {
                        try {
                            x = Double.parseDouble(valores_Separados[0]);
                            y = valoresGuardados.get(valores_Separados[1]);
                        } catch (Exception e) {
                            System.out.println("No existia un valor guardado dentro de la variable: " + valores_Separados[1]);
                            e.printStackTrace();
                        }


                    } else if (valores_Separados[0].matches(regex) && valores_Separados[1].matches(regex)) {

                        try {
                            x = valoresGuardados.get(valores_Separados[0]);
                            y = valoresGuardados.get(valores_Separados[1]);
                        } catch (Exception e) {
                            System.out.println("No existia un valor guardado dentro alguna de las variables");
                            e.printStackTrace();
                        }

                    } else {
                        x = Double.parseDouble(valores_Separados[0]);
                        y = Double.parseDouble(valores_Separados[1]);
                    }
                }
            }


            double resultado = -1;

            switch (valores_Separados.length) {
                case 1:
                    if (opcionEscogida == 5) {
                        System.out.println("el resultado de la variable "+ valores_Separados[0] + " es: " + valoresGuardados.get(valores_Separados[0]));

                    } else if (opcionEscogida == 6) {

                    } else {
                        System.out.println("no ingresaste un valor válido para la operación escogida!");
                    }
                    break;
                case 2:

                    if (opcionEscogida == 1) {

                        resultado = Operation.suma(x, y);
                        System.out.println("el resultado es: " + resultado);

                    } else if (opcionEscogida == 2) {

                        resultado = Operation.resta(x, y);
                        System.out.println("el resultado es: " + resultado);

                    } else if (opcionEscogida == 3) {
                        resultado = Operation.multiplicacion(x, y);
                        System.out.println("el resultado es: " + resultado);
                    } else if (opcionEscogida == 4) {
                        if (y != 0) {
                            resultado = Operation.division(x, y);
                            System.out.println("el resultado es: " + resultado);
                        } else {
                            System.out.println("escogiste 0 en el denominador y esto no es posible en división");
                        }
                    } else {

                        System.out.println("no ingresaste un valor válido para la opción escogida!");
                    }
                    break;
                case 3:

                    if (opcionEscogida == 1) {
                        resultado = Operation.suma(x, y);
                        System.out.println("El resultado es: " + resultado);
                        valoresGuardados.put(valores_Separados[2], resultado);
                        System.out.println("valor guardado");

                    } else if (opcionEscogida == 2) {
                        resultado = Operation.resta(x, y);
                        System.out.println("El resultado es: " + resultado);
                        valoresGuardados.put(valores_Separados[2], resultado);
                        System.out.println("valor guardado");
                    } else if (opcionEscogida == 3) {
                        resultado = Operation.multiplicacion(x, y);
                        System.out.println("El resultado es: " + resultado);
                        valoresGuardados.put(valores_Separados[2], resultado);
                        System.out.println("valor guardado");
                    } else if (opcionEscogida == 4) {
                        if (y != 0) {
                            resultado = Operation.division(x, y);
                            System.out.println("El resultado es: " + resultado);
                            valoresGuardados.put(valores_Separados[2], resultado);
                            System.out.println("valor guardado");
                        } else {
                            System.out.println("escogiste 0 en el denominador y esto no es posible en división");
                        }
                    } else {
                        System.out.println("no ingresaste un valor válido para la opción escogida!");
                    }
                    break;
                default:
                    System.out.println("Ingresaste unos valores inválidos, intenta de nuevo");
            }
        }


        System.out.println("Que tenga un bonito día!");


    }


}
