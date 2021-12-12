package br.dev.brunoxkk0.bc.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtils {

    static MessageDigest messageDigest;

    static {
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {e.printStackTrace();}
    }

    public static String calculateHash(Object... data){
        String hash = "";

        try {

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(data);

            byte[] hashBytes =  HashUtils.calculateHash(byteArrayOutputStream.toByteArray());
            hash = HashUtils.writeToHex(hashBytes);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return hash;
    }

    public static byte[] calculateHash(byte[] rawData){
        byte[] data = messageDigest.digest(rawData);
        messageDigest.reset();
        return data;
    }

    public static String writeToHex(byte[] data){

        StringBuilder hexString = new StringBuilder();

        for (byte b : data) {
            hexString.append(String.format("%02X", 0xFF & b));
        }

        return hexString.toString();
    }

    public static String genString(char character, int times){
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < times; i++)
            result.append(character);

        return result.toString();
    }


}
