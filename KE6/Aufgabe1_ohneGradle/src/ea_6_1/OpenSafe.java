package ea_6_1;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class OpenSafe {
    static Method decode;

    public static void main(String[] args) {
        Safe safe = new Safe();

        System.out.println(safe.manual());

        // Alle Methoden der Klasse ausgeben lassen
        printAllMethods();

        // Alle Felder des Safes ausgeben lassen
        printAllFields();

        // HiddenInformation vom Safe ausgeben lassen
        printSafeHiddenInformation(safe);

        // HiddenInformation decoded ausgeben lassen
        printDecodedHiddenInformation(safe);

        // Annotations zur Beschreibung des Zustands ausgeben lassen
        printAnnotations();

        // decodedAnnotations ausgeben lassen
        printDecodedAnnotations();

        // Safe öffnen
        openSafe(safe);
    }

    private static void printAllMethods() {

        System.out.println("Safe: ");
        for (Method method : Safe.class.getDeclaredMethods()) {
            System.out.println(method.toGenericString());
        }

        System.out.println();
        System.out.println("Decoder: ");
        for (Method method : Decoder.class.getDeclaredMethods()) {
            System.out.println(method.toGenericString());
        }
    }

    private static void printAllFields() {
        System.out.println();

        for (Field field : Safe.class.getDeclaredFields()) {
            System.out.println(field);
        }
    }

    private static void printSafeHiddenInformation(Safe safe) {
        System.out.println();

        try {
            for (Method method : Safe.class.getDeclaredMethods()) {
                method.setAccessible(true);
                if (method.getName().contains("hiddenInformations")) {
                    System.out.println(method.invoke(safe, new Object[]{}));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printDecodedHiddenInformation(Safe safe) {
        System.out.println();

        try {

            decode = Decoder.class.getDeclaredMethod("decodeForReal", String.class);
            decode.setAccessible(true);

            for (Method method : Safe.class.getDeclaredMethods()) {
                method.setAccessible(true);
                if (method.getName().contains("hiddenInformations")) {
                    System.out.println(decode.invoke(null, method.invoke(safe, new Object[] {})));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printAnnotations() {
        System.out.println();

        for (Annotation annotation : Safe.class.getAnnotations()) {
            System.out.println(annotation);
        }
    }

    private static void printDecodedAnnotations() {
        System.out.println();

        for (Annotation annotation : Safe.class.getAnnotations()) {
            try {
                System.out.println(decode.invoke(null, ((Inscription)annotation).value()));

            } catch (Exception e ) {
                e.printStackTrace();
            }
        }
    }

    private static void openSafe(Safe safe) {
        System.out.println();

        String key = "";

        try {
            int[] buttons = (int[])Safe.class.getDeclaredField("buttons").get(safe);

            for (int i : buttons)  {
                int state = (Integer)Safe.class.getDeclaredField("state").get(safe);
                int button = (buttons[state] - 1 + state) % 5 + 1;
                key += invokeButton(safe, button);
            }

            System.out.println(decode.invoke(null, safe.open(key)));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static String invokeButton(Safe safe, int button) {
        try {
            Method method = Safe.class.getDeclaredMethod("button" + button);
            method.setAccessible(true);
            return (String)method.invoke(safe);
        } catch (Exception e ) {
            e.printStackTrace();
        }
        return "";
    }
}
