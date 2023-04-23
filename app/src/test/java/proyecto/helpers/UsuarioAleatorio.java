package proyecto.helpers;

import java.util.Random;

public class UsuarioAleatorio {

    public static String generarUsernameAleatorio() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder sb = new StringBuilder();
        Random rnd = new Random();
        while (sb.length() < 20) {
            int index = rnd.nextInt(caracteres.length());
            sb.append(caracteres.charAt(index));
        }
        String username = sb.toString();
        return username;
    }

}