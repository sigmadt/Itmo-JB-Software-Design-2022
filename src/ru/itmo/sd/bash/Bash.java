package ru.itmo.sd.bash;


import ru.itmo.sd.bash.res.utils.EnvManager;
import ru.itmo.sd.bash.res.utils.Executor;
import ru.itmo.sd.bash.res.utils.Parser;
import ru.itmo.sd.bash.res.utils.Replacer;
import ru.itmo.sd.bash.res.utils.exceptions.WrongSyntaxException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Bash {
    private static final String bashSymbol = ">> ";
    private static final List<String> stopWords = Arrays.asList("quit", ":q", "exit");


    private static final EnvManager env = new EnvManager();
    private static final Parser parser = new Parser();
    private static final Replacer replacer = new Replacer();
    private static final Executor executor = new Executor();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(bashSymbol);
            try {
                String userInput = scanner.nextLine();
                if (userInput.trim().equals("")) {
                    continue;
                }

                if (stopWords.contains(userInput)) {
                    break;
                }
                // delete after
                var tokens = parser.run(userInput);
                var tokensReplaced = replacer.apply(tokens, env);
                executor.run(tokensReplaced, env);

            } catch (WrongSyntaxException e) {
                e.printStackTrace();
            }

        }

    }

    private void translate(String input) throws WrongSyntaxException {
        var tokens = parser.run(input);
        var tokensReplaced = replacer.apply(tokens, env);
        // finish this part
//        var inpStream = executor.run(tokensReplaced, env);
    }
}