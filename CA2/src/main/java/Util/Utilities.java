package Util;

public class Utilities {

    public static String truncateString(String stringToTruncate, int length){
        if (stringToTruncate.length() <= length) {
            return stringToTruncate;
        }
        else{
            return stringToTruncate.substring(0, length);
        }
    }

    public static boolean validateStringLength(String strToCheck, int maxLength){
        return strToCheck.length() <= maxLength;
    }

    public static boolean validRange(double numberToCheck, double min, double max) {
        return ((numberToCheck >= min) && (numberToCheck <= max));
    }

}
