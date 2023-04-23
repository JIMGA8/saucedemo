package proyecto.helpers;

import java.util.ArrayList;
import java.util.List;

public class Helpers {

    public List<String> convertirStringEnLista(String string) {
        String[] myArray = string.split(", ");
        List<String> myList = new ArrayList<String>();
        for (String str : myArray) {
            myList.add(str);
        }
        return myList;
    }

    public double eliminarCaracteresDeUnMonto(String montoConCaracteres) {
        String patron = "[^\\d.]"; // Patron que busca cualquier caracter que no sea un digito o un punto
        String limpio = montoConCaracteres.replaceAll(patron, "");
        double valor = Double.parseDouble(limpio);
        return valor;
    }
}
