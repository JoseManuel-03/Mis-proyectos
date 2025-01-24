import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;
import java.util.Base64;

public class RSAExample {
    
    public static KeyPair generarClavesRSA() throws Exception {
        KeyPairGenerator generador = KeyPairGenerator.getInstance("RSA");
        generador.initialize(2048);
        return generador.generateKeyPair();
    }

    public static String cifrar(String mensaje, PublicKey clavePublica) throws Exception {
        Cipher cifrador = Cipher.getInstance("RSA");
        cifrador.init(Cipher.ENCRYPT_MODE, clavePublica);
        byte[] mensajeCifrado = cifrador.doFinal(mensaje.getBytes());
        return Base64.getEncoder().encodeToString(mensajeCifrado);
    }

    public static String descifrar(String mensajeCifrado, PrivateKey clavePrivada) throws Exception {
        Cipher descifrador = Cipher.getInstance("RSA");
        descifrador.init(Cipher.DECRYPT_MODE, clavePrivada);
        byte[] mensajeDescifrado = descifrador.doFinal(Base64.getDecoder().decode(mensajeCifrado));
        return new String(mensajeDescifrado);
    }

    public static void main(String[] args) {
        try {
            KeyPair claves = generarClavesRSA();
            PublicKey clavePublica = claves.getPublic();
            PrivateKey clavePrivada = claves.getPrivate();

            String mensajeOriginal = "Hola, este es un mensaje secreto.";
            System.out.println("Mensaje original: " + mensajeOriginal);

            String mensajeCifrado = cifrar(mensajeOriginal, clavePublica);
            System.out.println("Mensaje cifrado: " + mensajeCifrado);

            String mensajeDescifrado = descifrar(mensajeCifrado, clavePrivada);
            System.out.println("Mensaje descifrado: " + mensajeDescifrado);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

