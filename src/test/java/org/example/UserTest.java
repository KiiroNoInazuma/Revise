package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class UserTest {
    private static final String[] LOGIN = {"", "    ", "John_Rey", "Roma_N"};
    private static final String[] MAIL = {"", "        ", "test.test@ru", "back@test!ru"};
    private static final String VALID_LOGIN = "John_Rey";
    private static final String VALID_MAIL = "adioskid@mail.ru";


    public static Stream<Arguments> manyArg() {
        List<Arguments> list = new ArrayList<>();
        for (String l : LOGIN) {
            for (String p : MAIL) {
                list.add(Arguments.of(l, p));
            }
        }
        return list.stream();

    }

    @ParameterizedTest
    @MethodSource("manyArg")
    public void checkCreateObjectNullBlankEmptyInValid(String login, String mail) {
        Assertions.assertThrows(IdentificationException.class, () -> new User(login, mail));
    }

    @Test
    public void identicalLoginMail() {
        String login = "adioskid@mail.ru";
        String mail = "adioskid@mail.ru";
        Assertions.assertThrows(IdentificationException.class, () -> new User(login, mail));
    }

    @Test
    public void nullArguments() {
        Assertions.assertThrows(IdentificationException.class, User::new);
    }

    @Test
    public void validValue() {
        Assertions.assertDoesNotThrow(() -> new User(VALID_LOGIN, VALID_MAIL));
    }

}