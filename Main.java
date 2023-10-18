import java.util.ArrayList;
import java.util.Random;

public class Main {

    static int linearSteps = 0;
    static int binarySteps = 0;

    public static void main(String[] args) {
        int size = 100;
        ArrayList<Integer> numbers = new ArrayList<>(size);
        Random random = new Random(31);

        for (int i = 0; i < size; i++) {
            numbers.add(random.nextInt(200));
        }
        // System.out.println(numbers.toString());

        int[] tests = { 32, 70, 140, -1 };

        // se préparer pour la recherche binaire
        numbers.sort(null);
        // System.out.println(numbers.toString());

        // tests de recherche linéaire
        // System.out.println("RECHERCHES LINÉAIRES");
        // for (int t : tests) {
        //     linearSearch(numbers, t);
        //     System.out.println("Étapes = " + linearSteps);
        //     linearSteps = 0;
        // }

        // tests de recherche binaire
        System.out.println("RECHERCHES BINAIRES");
        for (int t : tests) {
            binarySearch(numbers, t, 0, numbers.size() - 1);
            System.out.println("Étapes = " + binarySteps);
            binarySteps = 0;
        }
    }

    /** retourne true si target est trouvé ou false si target est absent */
    private static boolean linearSearch(ArrayList<Integer> items, int target) {
        for (int n : items) {
            linearSteps++;
            if (n == target) {
                return true;
            }
        }
        return false;
    }

    /**
     * retourne l'index dans items si target est trouvé ou -1 si target est absent
     */
    private static int linearSearchIndex(ArrayList<Integer> items, int target) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) == target) {
                return i;
            }
        }
        return -1;
    }

    /** retourne true si target est trouvé ou false si target est absent */
    private static boolean binarySearch(ArrayList<Integer> items, int target, int min, int max) {
        binarySteps++;
        if (min > max) {
            return false;
        }
        int milieu = (min + max) / 2;
        int value = items.get(milieu);
        if (target > value) {
            return binarySearch(items, target, milieu + 1, max);
        }
        if (target < value) {
            return binarySearch(items, target, min, milieu - 1);
        }
        return true; // value == target
    }

    /**
     * retourne l'index dans items si target est trouvé ou -1 si target est absent
     */
    private static int binarySearchIndex(ArrayList<Integer> items, int target, int min, int max) {
        if (min > max) {
            return -1;
        }
        int milieu = (min + max) / 2;
        int value = items.get(milieu);
        if (target > value) {
            return binarySearchIndex(items, target, milieu + 1, max);
        }
        if (target < value) {
            return binarySearchIndex(items, target, min, milieu - 1);
        }
        return milieu; // value == target
    }

}