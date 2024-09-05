import java.util.HashMap;

public class test {
    private static boolean checkIfCharExists(String[] array, String target) {
        for (String c : array) {
            if (c.equals(target)) {
                return true;
            }
        }

        return false;
    }

    private static int findVietNamese(String str) {
        String newStr = str.replaceAll("[^a-zA-Z0-9]", "");

        HashMap<String, String[]> combine = new HashMap<>();
        combine.put("a", new String[] { "a", "w" });
        combine.put("o", new String[] { "o", "w" });
        combine.put("e", new String[] { "e" });
        combine.put("d", new String[] { "d" });
        combine.put("w", new String[] { "w" });

        int result = 0;

        for (int i = 0; i < newStr.length(); i++) {
            char currentChar = newStr.charAt(i);
            String currentCharToString = String.valueOf(currentChar);

            Character nextChar = null;
            if (i + 1 < newStr.length()) {
                nextChar = newStr.charAt(i + 1);
            }
            String nexCharToString = String.valueOf(nextChar);

            if (combine.containsKey(String.valueOf(currentChar))
                    && checkIfCharExists(combine.get(currentCharToString), nexCharToString)) {
                result += 1;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        String str = "aahdfuwddcx oopawereeoww*(*)";
        System.out.println(findVietNamese(str));
    }
}