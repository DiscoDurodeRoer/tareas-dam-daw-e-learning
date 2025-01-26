package com.mycompany.tarea_psp_7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Tarea_PSP_7 {

    public static void main(String[] args) {

        try {
            
            Security.addProvider(new BouncyCastleProvider());
            
            String username = "discoduroderoer";
            String password = "123456";
            String semilla = username + password;

            SecretKey secretKey = generarSecretKey(semilla);

            String texto = "Hola Mundo!";

            byte[] textoEncriptado = encriptarTexto(texto, secretKey);
            
            String fichero = "fichero.cifrado";
            escribirFichero(fichero, textoEncriptado);
            System.out.println("Texto encriptado ha sido almacenado");
            
            byte[] bytesFichero = leerFichero(fichero);
            
            String textoDesencriptado = desencriptarTexto(bytesFichero, secretKey);
            System.out.println("El texto desencriptado es " + textoDesencriptado);
            
        } catch (NoSuchAlgorithmException | NoSuchProviderException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static SecretKey generarSecretKey(String semilla) {
        SecureRandom random = new SecureRandom(semilla.getBytes(StandardCharsets.UTF_8));
        byte[] bytes = new byte[16];
        random.nextBytes(bytes);
        return new SecretKeySpec(bytes, "Rijndael");
    }

    public static byte[] encriptarTexto(String texto, SecretKey secretKey) throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("Rijndael/ECB/PKCS5Padding", "BC");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(texto.getBytes(StandardCharsets.UTF_8));
    }
    
    public static void escribirFichero(String fichero, byte[] bytes) throws FileNotFoundException, IOException{
        try (FileOutputStream fos = new FileOutputStream(fichero)) {
            fos.write(bytes);
        }
    }
    
    public static byte[] leerFichero(String fichero) throws FileNotFoundException, IOException{
        try (FileInputStream fis = new FileInputStream(fichero)) {
            return fis.readAllBytes();
        }
    }
    
    public static String desencriptarTexto(byte[] bytes, SecretKey secretKey) throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        Cipher cipher = Cipher.getInstance("Rijndael/ECB/PKCS5Padding", "BC");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new String(cipher.doFinal(bytes), StandardCharsets.UTF_8);
    }

}
