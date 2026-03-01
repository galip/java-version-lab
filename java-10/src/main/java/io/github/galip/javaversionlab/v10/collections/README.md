## Java 10 – Unmodifiable Collection Enhancements

## Background

Java 9 introduced JEP 269 (Convenience Factory Methods for Collections),
which added `List.of()`, `Set.of()`, and `Map.of()`.

Java 10 introduced `copyOf()` methods and `Collectors.toUnmodifiableX()`.

These methods create truly immutable collections,
unlike `Collections.unmodifiableX()` which only creates a view.

Key differences:
- `copyOf()` makes a defensive immutable copy
- Rejects null elements
- Prevents accidental mutation

Java 10 extended this idea by introducing:

- `List.copyOf()`
- `Set.copyOf()`
- `Map.copyOf()`
- `Collectors.toUnmodifiableList()`
- `Collectors.toUnmodifiableSet()`
- `Collectors.toUnmodifiableMap()`
