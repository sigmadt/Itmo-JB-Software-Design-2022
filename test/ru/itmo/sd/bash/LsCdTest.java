package ru.itmo.sd.bash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LsCdTest {
    @Test
    void testLs() {
        var bash = new BashTranslateHelper();
        String expected = "test.txt\n" +
                "grep.cpp\n" +
                "zmej.py\n" +
                "forth.fs\n" +
                "dir\n";

        bash.run("cd test/ru/itmo/sd/bash/temp");

        assertEquals(expected, bash.run("ls"));
    }

    @Test
    void testCd() {
        var bash = new BashTranslateHelper();
        assertEquals(
                "This command can not be processed.\n" +
                        " Here is the message : Not a directory",
                bash.run("cd test/ru/itmo/sd/bash/temp/forth.fs")
        );
    }
}
