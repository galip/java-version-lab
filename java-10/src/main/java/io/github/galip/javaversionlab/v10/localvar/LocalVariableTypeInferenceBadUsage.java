package io.github.galip.javaversionlab.v10.localvar;

import java.util.ArrayList;

public class LocalVariableTypeInferenceBadUsage {

    public static void main(String[] args) {

        // Cannot use var without initializer
        // var x;

        // Cannot infer type from null
        // var y = null;

        // Compound declarations not allowed
        // var op1 = 1, op2 = 2;

        // array initializer needs explicit target-type
        // var array = {1,2,3}

        // not allowed in method parameter
        // public void test(var param) {}

        // not allowed in generics
        // class Example<var T> {}

        // avoid to use this - type is not obvious here
        // var result = process();

        // Diamond parameter risk
        var list = new ArrayList<>(); // compiler infers this as ArrayList<Object> list = new ArrayList<>();
        list.add("hello");
        list.add(10);

        // We may think it is List<String> but it is Object
        for (var item : list) {
            String value = (String) item; // java.lang.ClassCastException: java.base/java.lang.Integer cannot be cast to java.base/java.lang.String
            System.out.println(item);
        }
    }
}
