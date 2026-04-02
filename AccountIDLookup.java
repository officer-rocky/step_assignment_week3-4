import java.util.*;

public class AccountIDLookup {

    static int linearFirst(String[] logs, String target) {
        int comparisons = 0;
        for (int i = 0; i < logs.length; i++) {
            comparisons++;
            if (logs[i].equals(target)) {
                System.out.println("Linear first " + target + ": index " + i + " (" + comparisons + " comparisons)");
                return i;
            }
        }
        System.out.println(target + " not found in linear search (" + comparisons + " comparisons)");
        return -1;
    }

    static int linearLast(String[] logs, String target) {
        int comparisons = 0;
        int lastIndex = -1;
        for (int i = 0; i < logs.length; i++) {
            comparisons++;
            if (logs[i].equals(target)) lastIndex = i;
        }
        if (lastIndex != -1) System.out.println("Linear last " + target + ": index " + lastIndex + " (" + comparisons + " comparisons)");
        else System.out.println(target + " not found in linear search (" + comparisons + " comparisons)");
        return lastIndex;
    }

    static void binarySearchCount(String[] logs, String target) {
        Arrays.sort(logs);
        int comparisons = 0;
        int low = 0, high = logs.length - 1;
        int foundIndex = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;
            int cmp = logs[mid].compareTo(target);
            if (cmp == 0) {
                foundIndex = mid;
                break;
            } else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }

        int count = 0;
        if (foundIndex != -1) {
            int i = foundIndex;
            while (i >= 0 && logs[i].equals(target)) { count++; i--; }
            i = foundIndex + 1;
            while (i < logs.length && logs[i].equals(target)) { count++; i++; }
            System.out.println("Binary " + target + ": index " + foundIndex + ", count=" + count + " (" + comparisons + " comparisons)");
        } else {
            System.out.println(target + " not found in binary search (" + comparisons + " comparisons)");
        }
    }

    public static void main(String[] args) {
        String[] logs = {"accB", "accA", "accB", "accC"};

        linearFirst(logs, "accB");
        linearLast(logs, "accB");
        binarySearchCount(logs, "accB");
    }
}