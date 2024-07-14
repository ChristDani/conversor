import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String menu = """
                1.- ARS - Peso argentino
                2.- BOB - Boliviano boliviano
                3.- BRL - Real brasileño
                4.- CLP - Peso chileno
                5.- COP - Peso colombiano
                6.- USD - Dólar estadounidense
                7.- PEN - Sol peruano
                8.- AUD - Dólar australiano
                """;
        Scanner x = new Scanner(System.in);
        ConsultarMoneda c = new ConsultarMoneda();
        Valores v = new Valores();
        try {
            System.out.println("Seleccione el código de la moneda base:");
            System.out.println(menu);
            int BaseCode = x.nextInt();
            String BC = values(BaseCode);
            System.out.println("Ingrese el monto:");
            Double monto = x.nextDouble();
            System.out.println("Seleccione el código de moneda a cambiar:");
            System.out.println(menu);
            int ChangeCode = x.nextInt();
            String CC = values(ChangeCode);

            String coin = c.buscarMoneda(BC);

            v.setValues(coin, BC, monto, CC);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String values(int op) {
        switch (op) {
            case 1:
                return "ARS";
            case 2:
                return "BOB";
            case 3:
                return "BRL";
            case 4:
                return "CLP";
            case 5:
                return "COP";
            case 6:
                return "USD";
            case 7:
                return "PEN";
            case 8:
                return "AUD";
            default:
                return "Opción inválida!";

        }
    }
}
