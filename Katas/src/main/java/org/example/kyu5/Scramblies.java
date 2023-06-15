package org.example.kyu5;

public class Scramblies {
    public boolean scramble(String str1, String str2) {
        String[] splittedStr1 = str1.split("");
        String[] splittedStr2 = str2.split("");

        for (int i = 0; i < splittedStr2.length; i++) {
            boolean foundMatch = false;
            for (int j = 0; j < splittedStr1.length; j++) {
                if (splittedStr2[i].equals(splittedStr1[j])) {
                    splittedStr1[j] = "";  // Mark the character as used
                    foundMatch = true;
                    break;
                }
            }
            if (!foundMatch) {
                return false;
            }
        }
        return false;
    }
}
