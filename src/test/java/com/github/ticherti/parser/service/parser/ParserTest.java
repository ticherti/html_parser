package com.github.ticherti.parser.service.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserTest {
    private Parser parser;
    private final static String expectedText = """
            Java class HelloWorld {
                    public static void main (String args[]) {
                    for (;;) {
                             System.out.print("Hello World ");
                             }
                    }
            }
             submitted by: dan@engr.latech.edu (Danny Schales)""";

    public ParserTest() {
        parser = new JsoupParser();
    }

    @Test
    void parseAllWords() {
        String actual = parser.parseAllWords("http://www2.latech.edu/~acm/helloworld/java.html");
        assertEquals(expectedText, actual);
    }
}