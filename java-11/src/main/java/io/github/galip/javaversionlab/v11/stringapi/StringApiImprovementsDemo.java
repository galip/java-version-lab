package io.github.galip.javaversionlab.v11.stringapi;

public class StringApiImprovementsDemo {
    public static void main(String[] args) {

        String str = "";
        System.out.println(str.isBlank());

        str = "  ";
        System.out.println(str.isBlank());

        str = "İstanbul";
        System.out.println(str.isBlank());

        str = "Hello World";
        System.out.println(str.repeat(3));

        str = "Hello\nWorld";
        str.lines().forEach(System.out::println);

        str = "  Hello World  ";
        System.out.println(str.strip());
        System.out.println(str.stripLeading());
        System.out.println(str.stripTrailing());
    }
}

/*
true
true
false
Hello WorldHello WorldHello World
Hello
World
Hello World
Hello World
  Hello World
 */
