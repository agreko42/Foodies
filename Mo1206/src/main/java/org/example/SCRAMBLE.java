package org.example;

import java.util.Arrays;

public class SCRAMBLE {




    String str1;
    String str2;

    public SCRAMBLE(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }

    public boolean scramble() {

        return Arrays.asList(str2.split("")).stream()
                .map( (letter) -> letterCheck(letter, str1))
                .filter( aBoolean -> aBoolean==false)
                .findFirst()
                .orElse(true);
    }

    public boolean letterCheck(String letter, String string1){
        if(!string1.contains(letter)) {
            return false;
        }
        else{
            str1 = str1.replaceFirst(letter, "");
            return true;

        }
    }
}
