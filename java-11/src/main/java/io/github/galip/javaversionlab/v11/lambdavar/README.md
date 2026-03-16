Java Version: 11

JEP: 323

Local-Variable Syntax for Lambda Parameters
--

This feature introduces the ability to use **var** in lambda parameters.

Before Java 11, we used lambda parameters as type inference or explicit type.

Type Inference
--

```bash
(x,y) -> x + y
```

Explicit Type
--

```bash
(Integer x, Integer y) -> x + y
```

And we could only annotate lambda parameters if the types were explicitly declared.

```bash
(@Nonnull String name) -> name.length()
```

With Java 11 
--

we can write lambda parameters using **var**.

```bash
(var x, var y) -> x + y
```

So, annotations can be used while still we use type inference. 
This allows annotations on lambda parameters. That improves integration with static analysis tools, 
annotation-driven frameworks and validation frameworks.

We can use it;

```bash
(@NotNull var x, @NotNull var y) -> x + y
```

Invalid usage examples;

```bash
(var x, y) -> x + y
```

```bash
(var x, Integer y) -> x + y
```

