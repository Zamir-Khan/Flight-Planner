# Flight Planner Project

Welcome to the Flight Planner project developed for the Data Structures and Algorithms course in Fall 2022. This project focuses on creating a dynamic flight planner that efficiently determines the most cost-effective and expeditious routes for flights. The planner employs Dijkstra's algorithm in conjunction with LinkedList data structures to achieve heightened optimization. The project is implemented using Java and showcases strong skills in Object-Oriented Programming.

## Features

- Efficient Route Determination: The project utilizes Dijkstra's algorithm to calculate the most optimal routes between destinations, considering factors such as cost and travel time.

- Data Structures: LinkedList data structures are used to manage and organize flight information, contributing to the efficiency of the planner.

- Object-Oriented Programming: The project demonstrates a solid grasp of Object-Oriented Programming principles, making the codebase organized, modular, and easy to understand.

## Classes

### `Flights.java`

This class represents individual flights between different destinations. It contains relevant information about each flight, such as source, destination, cost, and travel time.

### `Path.java`

The `Path` class defines a path or route between multiple destinations. It encapsulates a sequence of flights that make up the path, along with the total cost and travel time for that path.

## Usage

1. **Input Data Preparation**: Prepare two input files, namely "FlightPlan.txt" and "FlightInfo.txt". The "FlightPlan.txt" file contains the flight plans, while "FlightInfo.txt" holds the necessary information about the flights.

2. **Compilation**: Compile the `Main.java`, `Flights.java`, and `Path.java` files to generate the executable.

3. **Execution**: Run the compiled program. It will read the flight plans from "FlightPlan.txt" and utilize information from "FlightInfo.txt" to generate optimized routes.

4. **Output**: The generated routes will be written to the "Output.txt" file.

## Files

- `Main.java`: This is the main program file that orchestrates the entire flight planning process. It reads flight plans from "FlightPlan.txt" and flight information from "FlightInfo.txt" to create optimized routes.

- `Flights.java`: This class represents individual flights and contains information about each flight.

- `Path.java`: The `Path` class defines a route between destinations, including the sequence of flights and associated information.

- `FlightPlan.txt`: Input file containing flight plans. This is where you specify the source and destination for each flight.

- `FlightInfo.txt`: Input file containing detailed information about the flights. This includes costs, travel times, and any other relevant data.

- `Output.txt`: The output file where the optimized routes will be written by the program.

## Getting Started

1. Clone or download the repository to your local machine.

2. Place the "FlightPlan.txt" and "FlightInfo.txt" files in the same directory as the `Main.java`, `Flights.java`, and `Path.java` files.

3. Compile the `Main.java`, `Flights.java`, and `Path.java` files using a Java compiler.

4. Run the compiled program.

5. Check the "Output.txt" file for the generated optimized routes.

## Acknowledgments

This project was developed as part of the Data Structures and Algorithms course in Fall 2022. The implementation showcases the application of Dijkstra's algorithm, LinkedList data structures, and Object-Oriented Programming principles.

## Contact

For any questions or feedback regarding this project, please contact Zamir Khan at khanzamirhossain@yahoo.com

---
