package ru.house.manager.Hash;


import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;
import java.util.Random;
import ru.house.manager.Hash.MagicString.magicString;

public class HashFunction {

    public static String getSalt1() {
        String alphabet = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random r = new Random();
        String result = "";
        for (int i = 0; i < 8; i++) {
            result += alphabet.charAt(r.nextInt(alphabet.length()));
        }
        return result;
    }

    public static String getSalt2() {
        return magicString.MAGIC_STRING;
    }

    public static String getHash(String passw, String salt1, String salt2) {
        String input = passw + salt1 + salt2;
        String hashValue = "";
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.update(input.getBytes());
            byte[] digestedBytes = messageDigest.digest();
            hashValue = DatatypeConverter.printHexBinary(digestedBytes).toLowerCase();
        }
        catch (Exception e){

        }
        return hashValue;
    }

}
