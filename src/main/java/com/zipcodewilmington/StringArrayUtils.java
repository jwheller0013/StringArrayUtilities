package com.zipcodewilmington;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length -1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length -2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        for (int i=1; i < array.length; i++) {
            if (Objects.equals(array[i], value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        for (int i = 0; i < array.length/2; i++) {
            String temp = array[i];
            array[i] = array[array.length -1 - i];
            array[array.length -1 -i] = temp;
        }
        return array;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        int counter = 0;
        int idx = array.length;
                for (int i=0; i <= idx/2 && idx !=0; i++) {
                    if (array[i] != array[idx -i -1]) {
                        counter = 1;
                        break;
                    }
                }

        return counter==0;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        String abc = "abcdefghijklmnopqrstuvwxyz";
        String fullChanged = "";
        int counter = 0;
        StringBuilder stringBuilder = new StringBuilder();

        for (String changed : array) {
            String changedLower = changed.toLowerCase();
            fullChanged = stringBuilder.append(changedLower).toString();
        }

        for (int i=1; i <= abc.length(); i++) {
            if (fullChanged.contains(abc.substring(i-1, i))) {
                counter++;
            }
        }
        return counter == 26;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int counter = 0;
        for (int i= 0; i < array.length; i++) {
            int idx = array[i].indexOf(value);
            while (idx != -1) {
                counter++;
                idx = array[i].indexOf(value, idx + value.length());
            }
        }
        return counter;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        ArrayList <String> removedValue = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals(valueToRemove)) {
                removedValue.add(array[i]);
            }
        }
        String [] valueRemoved = removedValue.toArray(new String[0]);
        return valueRemoved;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        ArrayList <String> removedDups = new ArrayList<>();
        for (int i = 0; i < array.length-1; i++) {
            int j = i +1;
            if (!array[i].equals(array[j])) {
                removedDups.add(array[i]);
            }
            if (array[i].equals(array[j]) && j==array.length-1) {
                removedDups.add(array[i]);
            }
            if (!array[i].equals(array[j]) && j==array.length-1) {
                removedDups.add(array[j]);
            }
        }
        String [] dups = removedDups.toArray(new String[0]);
        return dups;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        ArrayList <String> packDups = new ArrayList<>();
        for (int i = 0; i < array.length-1; i++) {
            int j = i +1;
            if (!array[i].equals(array[j])) {
                packDups.add(array[i]);
            }
            if (array[i].equals(array[j])) {
                String addTo = array[i] + array [j];
                packDups.add(addTo);
            }
            if (array[i].equals(array[j]) && j==array.length-1) {
                String addTo = array[i] + array [j];
                packDups.add(addTo);
            }
            if (!array[i].equals(array[j]) && j==array.length-1) {
                packDups.add(array[j]);
            }
        }
        String [] dups = packDups.toArray(new String[0]);
        return dups;
    }

    //it does not account for instances of triplicate


}
