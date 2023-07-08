package org.example;

import static org.junit.jupiter.api.Assertions.*;

class SCRAMBLETest {

    @org.junit.jupiter.api.Test

    void scramble() {

            String s1 = "abcdefghijklmnopqrstuvwxyz".repeat(10_000);
            String s2 = "zyxcba".repeat(9_000);

            SCRAMBLE scramble = new SCRAMBLE(s1, s2);

            assertEquals(false, scramble.scramble());
    }
}