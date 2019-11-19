package ru.house.manager.Hash;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class HashFunction {

    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }

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

    public static String getHash(String passw, String salt1, String salt2) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String input = passw + salt1 + salt2;
        String hashValue = "";
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
        messageDigest.update(input.getBytes("UTF-8"));
        byte[] hash = messageDigest.digest();
        return bytesToHex(hash);
    }
}

