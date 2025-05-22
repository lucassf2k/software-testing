# 🐾 Bouncing Creatures Simulation – Evaluation 1 (Software Testing)

This project involves implementing a Java simulator for the **Software Testing** course (Unit 1), focusing on **test-driven development (TDD)**, **structural analysis**, and **100% MC/DC (Modified Condition/Decision Coverage)** code coverage.

## 🧪 Objective

Develop a graphical simulation of **bouncing creatures**, following the defined requirements, and design a **systematic and efficient test suite** with full coverage. Evaluation will consider specification, originality, documentation, technical quality, and traceability.

## 📝 Simulation Description

The simulation includes:

- A set of `n` creatures, numbered from 1 to `n`.
- Each creature has:
    - A **horizontal position** represented by a floating-point number (`xi`).
    - An **amount of gold coins (`gi`)**, initially set to **1,000,000**.

- At each **simulation iteration**:
    1. The creature updates its position according to the formula:  
       `xi ← xi + r * gi`  
       where `r` is a random number between -1 and 1.
    2. Then, the creature **steals half of the gold coins** from the nearest creature on one side and adds that value to its own `gi`.

## 🎯 Requirements

- Iterative visual simulation for a defined number of creatures.
- Support for:
    - Domain tests
    - Boundary tests
    - Structural tests with **100% MC/DC coverage**
- Code must include **clear internal documentation**.
- Project must be submitted as a `.zip` file using the naming pattern:  
  `Name1Name2-Evaluation1-ST.zip`

## 🧪 Tests and Coverage

The project includes a **Java unit test suite** using JUnit, focused on:

- Validating creature movement rules.
- Correct detection of the nearest creature.
- Safe handling of gold coins.
- Demonstrating MC/DC logical coverage.

## 📅 Schedule

- **Start:** 05/02/2025 at 17:42
- **Final Delivery:** 05/22/2025 at 23:59

## 🗂 Project Structure

The project will consist of several classes, organized clearly to ensure modularity and traceability between requirements and implementations.

### Main components (to be detailed):

# Class `Creature` – Summary of Functionality
## Corresponding test class: `CreatureTest`

The `Creature` class represents a creature with an identifier (`id`), a horizontal position (`X`), and a number of coins. It simulates movements and interactions in a controlled environment.

---

### Attributes

- `int id`: unique creature identifier.
- `float X`: horizontal position, ranges from -1.0 to 1.0.
- `int coins`: amount of coins, starts at 1,000,000 by default.

---

### Constructors

- `Creature(int id)`: creates a creature with ID and default values.
- `Creature(int id, float x)`: sets ID and initial position.
- `Creature(int id, int coins)`: sets ID and amount of coins.
- `Creature(int id, float x, int coins)`: sets all attributes.

---

### Main Methods

#### `addCoins(int value)`
Adds coins to the total **only if the value is greater than or equal to zero**.

#### `getHalfCoins()`
- Returns half of the current coins (integer division).
- Subtracts that amount from the total.

#### `updatePosition()`
- Updates the `X` position based on:
    - A random number `r` between -1 and 1.
    - The number of coins.
- Formula: `X += r * coins / 1_000_000`
- The new position is rounded to two decimal places and clamped between -1 and 1.

#### `setX(float x)`
- Rounds `x` to two decimal places.
- Sets the new position only if `x` is between -1 and 1.

---

### Helper Methods

#### `loseCoins(int value)`
- Subtracts `value` from total coins **if more than 1 coin remains**.

#### `toTwoDecimalPlaces(float value)`
- Rounds a `float` value to two decimal places.

---

### Getters and Setters

- `getId()`: returns the `id`.
- `getX()`: returns the `X` position.
- `getCoins()`: returns the current number of coins.
- `setCoins(int coins)`: sets the number of coins (only if ≥ 0).
- `setId(int id)`: sets the ID (throws exception if negative).

---

# Class `Match` – Summary of Functionality
## Corresponding test class: `MatchTest`

The `Match` class manages a simulation with multiple `Creature` objects, allowing interactions between them based on proximity.

---

### Attributes

- `List<Creature> creatures`: list of creatures in the simulation.
- `float maxDistanceStealCoins`: maximum distance allowed to steal coins. Default: 0.3.

---

### Constructor

#### `Match(int n)`
- Creates up to 30 creatures with unique IDs (from 1 to `n`).
- Throws an exception if `n <= 1`.

---

### Main Method

#### `iterate()`
Runs one iteration of the simulation:
1. Updates all creatures' positions (`updatePosition()`).
2. For each creature:
    - Finds the closest creature (within `maxDistanceStealCoins`).
    - If one is found and has a higher ID, the current creature steals half of its coins.

---

### Helper Methods

#### `findClosestWithinDistance(int idx, double maxDistance)`
- Returns the closest creature to the one at index `idx`, if within the max distance.
- Returns `null` if none are within range.

#### `hasHalfElementsReachedOneCoin()`
- Returns `true` if **at least half** the creatures have exactly 1 coin.

---

### Distance Configuration

#### `setMaxDistanceStealCoins(float value)`
- Sets the maximum coin-stealing distance.
- Accepts only values between `0.01f` and `2.0f`, rounded to two decimal places.

#### `getMaxDistanceStealCoins()`
- Returns the current maximum distance for stealing coins.

---

### Other Methods

#### `getCreatures()`
- Returns the list of creatures in the simulation.

---

# Class `VisualizationPanel`
## `Mock` use is required for testing

The `VisualizationPanel` class is responsible for visually displaying the creature simulation on a `JPanel`. It uses Java's Swing library to render visual elements.

### Main Responsibilities

- **Render creatures**: Draws each creature as a blue circle based on horizontal position.
- **Jump animation**: Each creature "jumps" vertically using a sine function to simulate dynamic movement.
- **Baseline**: A black line is drawn at the bottom as a jump reference.
- **Info panel**: A panel in the top-right corner shows each creature’s coins, in descending order.

### Important Methods

#### `paintComponent(Graphics graphics)`
- Overridden to draw visual elements:
    - Positions creatures based on `x`, converting from `[-1, 1]` to screen coordinates.
    - Applies vertical offset animation (jump) based on current time.
    - Displays a sidebar with formatted coin counts (Brazilian format).

#### `normalizesCreaturePositionScreen(float positionX)`
- Converts a creature’s `x` from `[-1, 1]` to `[0.0, 1.0]` (normalized to screen coordinates).

#### `formatterCoins(int coins)`
- Formats a creature’s coin count using Brazilian number format (`pt-BR`), no decimal places (e.g., `2500` → `"2.500"`).

### Fields
- `Match match`: The current simulation object providing access to the creatures.

---

# Class `App`
## `Mock` use is likely required for testing

The `App` class represents the entry point of the graphical bouncing creature simulation application.

### Purpose

Starts the simulation with a graphical interface (`JFrame`) and updates the simulation logic periodically using a `Timer`.

### Behavior

#### Constants

- `TIMER_MS = 1000`: Time between updates (1 second).
- `MAXIMUM_MATCH_DURATION = 100`: Max simulation duration in iterations.

#### `main(String[] args)`
1. **Simulation creation**:
    - Instantiates a `Match` object with 30 creatures.
    - Creates a `VisualizationPanel` to display creatures.
    - Adds the panel to a `JFrame` with title and basic settings.

2. **Timer**:
    - Uses `javax.swing.Timer` to execute actions every second.
    - At each tick:
        - Calls `match.iterate()` to update simulation state.
        - Calls `panel.repaint()` to redraw the screen.
        - Increases iteration counter.
        - Stops simulation if:
            - Reaches the max iteration count (`100`), or
            - Half of the creatures have at least one coin (`match.hasHalfElementsReachedOneCoin()`).

3. **Termination**:
    - At the end of the simulation, shows a termination message (`JOptionPane`).

### Used Components

- `Match`: Represents the simulation state.
- `VisualizationPanel`: Graphical panel to display creatures.
- `JFrame`: Main graphical interface window.
- `Timer`: Periodically updates the simulation.
