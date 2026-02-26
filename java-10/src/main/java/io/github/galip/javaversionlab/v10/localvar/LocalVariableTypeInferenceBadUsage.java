package io.github.galip.javaversionlab.v10.localvar;

public class LocalVariableTypeInferenceBadUsage {

    // Cannot use var without initializer
    // var x;

    // Cannot infer type from null
    // var y = null;

    // Compund declarations not allowed
    // var op1 = 1, op2 = 2;

    // array initializer needs explicit target-type
    // var array = {1,2,3}

    // not allowed in method paramerter
    // public void test(var param) {}

    // not allowed in generics
    // class Example<var T> {}

    // avoid to use this - type is not obvious here
    // var result = process();

}
