package ru.itmo.sd.bash.res.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {

    private Utils() {
    }

    public static Path getCurrentDir() {
        return Paths.get(System.getProperty("user.dir"));
    }

    public static InputStream emptyInputStream() {
        return new InputStream() {
            @Override
            public int read() throws IOException {
                return -1;
            }
        };
    }
}