package ru.itmo.sd.bash.res.utils;


import java.util.HashMap;

public class Token {
    private final Type type;
    private final String inside;
    private static final HashMap<Character, Type> typesStorage = new HashMap<>() {
        {
            put('\'', Type.SINGLE_Q_TEXT);
            put('|', Type.PIPE_SYMBOL);
            put('"', Type.DOUBLE_Q_TEXT);
            // rest will be processed manually
        }
    };

    public Token(String inside, Type type) {
        this.inside = inside;
        this.type = type;
    }

    public static Type getType(char el) {
        return typesStorage.get(el);
    }

    // instance related methods
    public Type getType() {
        return type;
    }

    public String getInside() {
        return inside;
    }


    public enum Type {
        JUST_TEXT,
        PIPE_SYMBOL,
        SINGLE_Q_TEXT,
        DOUBLE_Q_TEXT,
        ASSIGN,
        SUBST
    }
}