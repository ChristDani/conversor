
import com.google.gson.*;

import java.util.Map;

public class Valores {

    public void setValues(String string, String baseCode, Double monto, String changeCode) {

        try {
            JsonObject json = JsonParser.parseString(string).getAsJsonObject();
            JsonElement changeListElement = json.get("conversion_rates");

            if (changeListElement != null && changeListElement.isJsonObject()) {
                JsonObject changeList = changeListElement.getAsJsonObject();

                if (changeList.has(changeCode)) {
                    JsonElement valueElement = changeList.get(changeCode);

                    if (valueElement.isJsonPrimitive()) {
                        JsonPrimitive valuePrimitive = valueElement.getAsJsonPrimitive();
                        if (valuePrimitive.isNumber()) {
                            double value = valuePrimitive.getAsDouble();
                            double result = monto * value;
                            System.out.printf("El monto de %.2f %s es igual a %.2f %s",monto,baseCode, result,changeCode);
                        } else {
                            System.out.println("Value for key '" + changeCode + "' is not a number.");
                        }
                    } else {
                        System.out.println("Value for key '" + changeCode + "' is not a primitive.");
                    }
                } else {
                    System.out.println("Key '" + changeCode + "' not found in conversion_rates.");
                }

//                for (Map.Entry<String, JsonElement> entry : changeList.entrySet()) {
//                    String key = entry.getKey();
//                    JsonElement valueElement = entry.getValue();
//
//                    // Asegúrate de que el valor sea un tipo primitivo (String, Number, Boolean)
//                    if (valueElement.isJsonPrimitive()) {
//                        JsonPrimitive valuePrimitive = valueElement.getAsJsonPrimitive();
//                        if (valuePrimitive.isNumber()) {
//                            double value = valuePrimitive.getAsDouble();
//                            System.out.println("Key: " + key + ", Value: " + value);
//                        }
//                    }
//                }
            } else {
                System.out.println("\"conversion_rates\" no es un objeto JSON.");
            }
        } catch (JsonSyntaxException e) {
            System.out.println("Error al parsear el JSON: " + e.getMessage());
        }
    }
}
