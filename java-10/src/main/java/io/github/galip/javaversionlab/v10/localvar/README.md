Java Version: 10

JEP: 286

Local Variable Type Inference (var)

Can we reduce verbosity without losing readability?
-

This feature allows variables to be declared without explicit type.
It is inferred ar compile time.

Where to use it?

* For loops
* Local variables
* try-with-resources

Where not to use it?
* Fields
* Return types
* Method parameters

This is compile time feature. So, ZERO runtime impact.