package ru.common.Utils;

public class Utils {
    public static String byteArrayToFormattedHex(byte[] bytes){
        String hex = javax.xml.bind.DatatypeConverter.printHexBinary(bytes);
        String[] hexBytes = hex.split("(?<=\\G.{" + 2 + "})");
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for(String s : hexBytes){
            stringBuilder.append(s);
            stringBuilder.append(" ");
            if(i++>=9){
                stringBuilder.append(System.lineSeparator());
                i=0;
            }
        }
        return stringBuilder.toString();
    }
}
