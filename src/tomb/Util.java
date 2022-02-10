package tomb;

public class Util {
    public static String processTermString(String term) { //Turn fast_cruise_performance_for_warrior > Fast Cruise Performance For Warrior
        String underscoreRemoved = term.replaceAll("_", " ");
        char[] chars = underscoreRemoved.toLowerCase().toCharArray();
        boolean found = false;
        for (int i = 0; i < chars.length; i++) {
            if (!found && Character.isLetter(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
                found = true;
            } else if (Character.isWhitespace(chars[i]) || chars[i]=='.' || chars[i]=='\'') { // You can add other chars here
                found = false;
            }
        }
        return String.valueOf(chars);
    }
}
