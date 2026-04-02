import java.util.*;

public class RiskThresholdLookup {

    static void linearSearch(int[] risks, int target) {
        int comparisons = 0;
        boolean found = false;
        for (int r : risks) {
            comparisons++;
            if (r == target) {
                found = true;
                break;
            }
        }
        System.out.println("Linear search for " + target + ": " + (found ? "found" : "not found") + " (" + comparisons + " comparisons)");
    }

    static void binaryFloorCeiling(int[] risks, int target) {
        int low = 0, high = risks.length - 1;
        int comparisons = 0;
        int floor = Integer.MIN_VALUE, ceiling = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;
            if (risks[mid] == target) {
                floor = ceiling = risks[mid];
                break;
            } else if (risks[mid] < target) {
                floor = risks[mid];
                low = mid + 1;
            } else {
                ceiling = risks[mid];
                high = mid - 1;
            }
        }
        System.out.println("Binary floor(" + target + "): " + floor + ", ceiling: " + ceiling + " (" + comparisons + " comparisons)");
    }

    public static void main(String[] args) {
        int[] risks = {10, 25, 50, 100};

        linearSearch(risks, 30);
        binaryFloorCeiling(risks, 30);
    }
}