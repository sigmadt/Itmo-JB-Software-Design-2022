package ru.itmo.sd.bash.res.commands;

import ru.itmo.sd.bash.res.utils.EnvManager;
import ru.itmo.sd.bash.res.utils.exceptions.WrongSyntaxException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LsCommand implements Command {
    @Override
    public InputStream run(InputStream input, List<String> arguments, EnvManager envManager) throws IOException, WrongSyntaxException {
        Path dir = Paths.get(envManager.get(EnvManager.PWD));
        Set<String> fileList = new HashSet<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path path : stream) {
                if (!Files.isDirectory(path)) {
                    fileList.add(path.getFileName().toString());

                }
            }
        }

        return new ByteArrayInputStream((String.join("\n", fileList) + "\n").getBytes());
    }
}
