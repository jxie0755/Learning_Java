import java.util.*;

/**
 * This is to learn customized sort by creating new Comparator sub-class
 */


/**
 * Create a customized sort for absolute value
 * if abs value the same, still put negative smaller than positive
 */
class absComparator implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {

        int ans = a * a - b * b;
        if (ans < 0) {
            return -1;
        } else if (ans > 0) {
            return 1;
        } else {
            if (a < b) {
                return -1;
            } else if (a > b) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}

/**
 * Practicing customized Comparator using another customized comparator
 */
class absGridCompartor implements Comparator<List<Integer>> {
    public int compare(List<Integer> l1, List<Integer> l2) {
        Comparator<Integer> abs_check = new absComparator();

        int min_lenth = Math.min(l1.size(), l2.size());
        if (min_lenth == 0) {
            return 0;
        }

        for (int i = 0; i < min_lenth; i += 1) {
            if (abs_check.compare(l1.get(i), l2.get(i)) < 0) {
                return -1;
            } else if (abs_check.compare(l1.get(i), l2.get(i)) > 0) {
                return 1;
            }
        }

        if (l1.size() == l2.size()) {
            return 0;
        } else if (l1.size() < l2.size()) {
            return -1;
        } else {
            return 1;
        }
    }
}

/**
 * Comparing a list of integers based on sequence comparison
 * python like
 */
class IntGridComparator implements Comparator<List<Integer>> {
    public int compare(List<Integer> l1, List<Integer> l2) {
        int min_lenth = Math.min(l1.size(), l2.size());
        if (min_lenth == 0) {
            return 0;
        }

        for (int i = 0; i < min_lenth; i += 1) {
            if (l1.get(i) < l2.get(i)) {
                return -1;
            } else if (l1.get(i) > l2.get(i)) {
                return 1;
            }
        }

        if (l1.size() == l2.size()) {
            return 0;
        } else if (l1.size() < l2.size()) {
            return -1;
        } else {
            return 1;
        }
    }
}


/**
 * Essentially the same method to compare char, but created for Character
 */
class CharacterComparator implements Comparator<Character> {
    public int compare(Character c1, Character c2) {
        return c1.compareTo(c2);
    }
}

/**
 * Create a customized sort for List<String>
 * python like
 */
class StringListComparator implements Comparator<List<String>> {

    public int compare(List<String> l1, List<String> l2) {
        int min_lenth = Math.min(l1.size(), l2.size());
        if (min_lenth == 0) {
            return 0;
        }

        for (int i = 0; i < min_lenth; i += 1) {
            String word_1 = l1.get(i);
            String word_2 = l2.get(i);
            if (word_1.compareTo(word_2) < 0) {
                return -1;
            } else if (word_1.compareTo(word_2) > 0) {
                return 1;
            }
        }

        if (l1.size() == l2.size()) {
            return 0;
        } else if (l1.size() < l2.size()) {
            return -1;
        } else {
            return 1;
        }
    }
}


public class Customized_Comparator_Test {

    public static void main(String[] args) {

        // Customized single compare
        System.out.println(-2 > 1); // >>> false
        // No way to direct compare to get boolean
        // STOF: https://stackoverflow.com/a/64501254/8435726
        Comparator<Integer> abs_check = new absComparator();
        System.out.println(abs_check.compare(-2, 1) > 0); // >>> true

        // Test absComparator by sortng
        List<Integer> list_1 = new ArrayList<>(Arrays.asList(-3, -2, -1, 0, 1, 2));
        list_1.sort(new absComparator());
        System.out.println(list_1);
        // >>>  [0, -1, 1, -2, 2, -3]

        // Test absGridComparator by sorting
        List<List<Integer>> abs_grid_1 = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(3, -2, 1)),
                new ArrayList<>(Arrays.asList(3, 2, 1)),
                new ArrayList<>(Arrays.asList(-1, 3, 2)),
                new ArrayList<>(Arrays.asList(-2, 3, 1)),
                new ArrayList<>(Arrays.asList(2, -1, 3)),
                new ArrayList<>(Arrays.asList(1, -2, 3)),
                new ArrayList<>(Arrays.asList(-3, 1, 2))
        ));
        Collections.sort(abs_grid_1, new absGridCompartor());
        System.out.println(abs_grid_1);
        // >>> [[-1, 3, 2], [1, -2, 3], [-2, 3, 1], [2, -1, 3], [-3, 1, 2], [3, -2, 1], [3, 2, 1]]

        // Test intGridComparator by sorting
        List<List<Integer>> grid_1 = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(3, 2, 1)),
                new ArrayList<>(Arrays.asList(1, 3, 2)),
                new ArrayList<>(Arrays.asList(2, 3, 1)),
                new ArrayList<>(Arrays.asList(2, 1, 3)),
                new ArrayList<>(Arrays.asList(1, 2, 3)),
                new ArrayList<>(Arrays.asList(3, 1, 2))
        ));
        grid_1.sort(new IntGridComparator());
        System.out.println(grid_1);
        // >>> [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
        // Sort based on first element comparison, and move to next if equal


        // Test CharacterComparator
        List<Character> character_list = new ArrayList<>(Arrays.asList('c', 'b', 'a', 'A'));
        character_list.sort(new CharacterComparator());
        System.out.println(character_list); // >>> [A, a, b, c]


        // Test StringComparator
        List<String> string_list = new ArrayList<>(Arrays.asList("apple", "Apple", "A[]le"));
        System.out.println("Apple".compareTo("apple"));
        System.out.println(string_list); // >>> [A[]le, Apple, apple]


        // Test StringListComparator by sorting
        List<List<String>> a3 = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList("eat", "tea", "ate")),
                new ArrayList<>(Arrays.asList("tan", "nat")),
                new ArrayList<>(Arrays.asList("bat"))
        ));
        Collections.sort(a3, new StringListComparator());
        System.out.println(a3); // >>> [[bat], [eat, tea, ate], [tan, nat]]
    }
}
