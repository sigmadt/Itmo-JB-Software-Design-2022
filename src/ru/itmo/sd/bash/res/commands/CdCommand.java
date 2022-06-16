package ru.itmo.sd.bash.res.commands;

import ru.itmo.sd.bash.res.utils.EnvManager;
import ru.itmo.sd.bash.res.utils.exceptions.WrongSyntaxException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static ru.itmo.sd.bash.res.utils.EnvManager.PWD;

public class CdCommand implements Command{
    @Override
    public InputStream run(InputStream input, List<String> arguments, EnvManager envManager) throws IOException, WrongSyntaxException {
        if (!arguments.isEmpty()) {
            String current = envManager.get(PWD);
            Path newPath = Path.of(current, arguments.get(0));
            if (Files.exists(newPath)) {
                envManager.set(PWD, newPath.normalize().toAbsolutePath().toString());
            } else {
                throw new WrongSyntaxException("No such folder");
            }
        }
        return new ByteArrayInputStream(new byte[]{});
    }
}
