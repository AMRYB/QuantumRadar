# Quantum Radar

Quantum Radar is a simple Java console application that demonstrates
object-oriented programming by processing vehicle observations and generating
traffic fines.

## Features

- Receives a vehicle plate number, observation date, car type, speed, and
  seatbelt status.
- Checks every observation against a configurable collection of rules.
- Generates zero or more violations for each observation.
- Issues a fine containing every violation and its fee.
- Prints all issued fines with their total amounts.
- Counts how many times each rule was violated.
- Supports adding new rules without modifying the `Radar` class.

## Current Rules

| Rule | Limit | Fee |
|---|---:|---:|
| Private car speed | Maximum 80 | 300 EGP |
| Truck speed | Maximum 60 | 300 EGP |
| Seatbelt | Must be fastened | 100 EGP |

## OOP Design

Every traffic rule implements the `ViolationRule` interface. The `Radar` class
stores a collection of these rules and applies all of them to each
`VehicleObservation`. A new rule can therefore be added through `addRule()`
without changing the radar logic.

## Project Structure

```text
src/
├── Main.java
├── Radar.java
├── VehicleObservation.java
├── CarType.java
├── ViolationRule.java
├── SpeedRule.java
├── SeatBeltRule.java
├── Violation.java
└── Fine.java
```

## Requirements

- Java Development Kit (JDK) 9 or later
- IntelliJ IDEA or another Java IDE

## Run in IntelliJ IDEA

1. Open the project in IntelliJ IDEA.
2. Open `src/Main.java`.
3. Click the Run button beside the `main` method.

## Run from the Command Line

```bash
javac -d out src/*.java
java -cp out Main
```

## Example Output

```text
Traffic fine for car ABC1234
Total amount: 400 EGP
Violations:
- Seatbelt not fastened : 100 EGP
- speed of 94 exceeded max allowed 80 : 300 EGP
```
