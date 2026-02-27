Java Version: 10

JEP: 286

Local Variable Type Inference (var)

Can we reduce verbosity without losing readability?
-

This feature allows variables to be declared without explicit type.
The compiler infers it at compile time.

var message = "hello"; is compiled as

String message = "hello";

var is not dynamic typing.

Where to use it?

* For loops
* Local variables
* try-with-resources
* Stream transformations

Where not to use it?
* Fields
* Return types
* Method parameters

When the type is not obvious we should avoid to use it.

Diamond operator is risky to use.

var list = new ArrayList<>(); compiler infers this as ArrayList<Object> list = new ArrayList<>();
We may think it is List<String> but it is Object. This causes a ClassCastException.


This feature is a compile time feature. So, ZERO runtime impact.