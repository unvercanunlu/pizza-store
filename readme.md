# Pizza Store - Factory Pattern Demo

A modular Java-based pizza ordering system implemented using the **Factory Design Pattern**.  
It demonstrates clean separation of construction logic and encapsulates the creation of both **predefined** and **custom pizzas**.

---

## Features

- `PizzaFactory` class with:
    - `margarita(Size)` – creates a Margherita pizza
    - `pepperoni(Size)` – creates a Pepperoni pizza
    - `custom(...)` – builds a fully customizable pizza
- Fluent `PizzaBuilder` for flexible composition
- `ValidationService` for:
    - Checking size, components, and topping limits
- `CalculatePriceHelper` for dynamic pricing based on size and ingredients
- Well-structured exception handling with meaningful error messages

---

## Technologies

- Java 17
- Maven
- Lombok (for clean enum/DTO boilerplate)

---

## Design Pattern

### Factory Pattern

This project uses the **Simple Factory Pattern** to encapsulate pizza creation.  
The factory provides pre-configured objects (e.g., Margherita) or allows fine-grained control over all pizza components via a builder.
