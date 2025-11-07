# 953201 Algorithms Design and Analysis

This repository contains Java implementations of various algorithms and data structures covered in the 953201 Algorithms Design and Analysis course.

## Repository Structure

### Dynamic Programming
Solutions demonstrating dynamic programming techniques for optimization problems.

- **`CatalanNumber.java`** - Computes Catalan numbers using both recursive and dynamic programming approaches with performance comparison
- **`CoinChange.java`** - Solves the coin change problem to find the number of ways to make change for a given amount
- **`CoinChangeFromClass.java`** - Alternative coin change implementation using 2D array approach with visual output
- **`DepositInterest.java`** - Calculates compound interest over time using dynamic programming
- **`Frog.java`** - Solves the frog jump problem with performance comparison between HashMap and ArrayList approaches

### Graph Algorithms
Implementations of fundamental graph traversal and shortest path algorithms.

#### Traversal
- **`BFS.java`** - Breadth-First Search implementation using adjacency list
- **`BFSwithTestcases.java`** - BFS with multiple test cases including edge cases
- **`DFS.java`** - Depth-First Search implementation using stack

#### Shortest Path Algorithms
- **`DijkstrasAlgorithm.java`** - Dijkstra's algorithm for finding shortest paths in weighted graphs
- **`DijkstraAlgorithmWithTestcases.java`** - Dijkstra's algorithm with comprehensive test cases including negative weights and disconnected graphs
- **`BellmanFordAlgorithm.java`** - Bellman-Ford algorithm for graphs with negative edge weights
- **`FloydWarshallAlgorithm.java`** - All-pairs shortest path algorithm using dynamic programming

#### Graph Representations
- **`TreasureGraph.java`** - Graph representation using adjacency matrix for a grid-based treasure game
- **`TreasureLinkedList.java`** - Graph representation using adjacency list for the same treasure game

### Greedy Algorithms
Solutions using greedy approaches for optimization.

- **`MaxSumArray.java`** - Maximizes the sum of array elements multiplied by their indices
- **`MinSquarePaperCutting.java`** - Finds minimum number of square cuts needed for a rectangle
- **`Heritage.java`** - Determines fair estate distribution using greedy partitioning
- **`TreasureGame.java`** - Finds the best route in a grid to maximize treasure collection

#### With Test Cases
- **`MaxSumArrayTestcase.java`** - Extended version with comprehensive test cases
- **`MinSquarePaperCuttingTestcase.java`** - Extended version with edge case handling

### LeetCode Solutions
Selected LeetCode problem implementations.

- **`IntegerToRoman.java`** - Converts integers to Roman numerals
- **`RomanToInteger.java`** - Converts Roman numerals to integers
- **`LongestPalindromicSubstring.java`** - Finds the longest palindromic substring using center expansion
- **`PascalTriangle.java`** - Generates Pascal's Triangle
- **`Triangle.java`** - Finds minimum path sum in a triangle (LeetCode #120)
- **`UniquePath.java`** - Counts unique paths in a grid using dynamic programming
- **`ValidParentheses.java`** - Validates balanced parentheses using stack
- **`PowerOfTwoLeetcode.java`** - Checks if a number is a power of two
- **`SkylineProblem.java`** - Solves the skyline problem using sweep line algorithm

### Recurrence Relations
Problems solved using recursive approaches.

- **`TilesLaying.java`** - Calculates number of ways to lay tiles of different sizes
- **`TowersOfHanoi.java`** - Classic Tower of Hanoi puzzle solution

### Loop Exercises
Basic pattern printing exercises.

- **`AsteriskPattern.java`** - Prints diamond pattern using asterisks
- **`NumberSpacePattern.java`** - Prints numbered pattern with spaces

### Time and Space Complexity
Analysis of algorithm efficiency.

- **`CountAsCorner.java`** - Computes prefix sums for 2D arrays to count elements efficiently

### Other
- **`BeeReproduction.java`** - Models bee population growth over generations

## Key Concepts Covered

- **Dynamic Programming**: Memoization, tabulation, optimal substructure
- **Graph Algorithms**: BFS, DFS, shortest paths (Dijkstra, Bellman-Ford, Floyd-Warshall)
- **Greedy Algorithms**: Optimal local choices, activity selection
- **Data Structures**: Stacks, queues, priority queues, adjacency lists/matrices
- **Algorithm Analysis**: Time and space complexity evaluation
- **Problem-Solving Patterns**: Recursion, iteration, divide and conquer

## Running the Code

Each Java file contains a `main` method and can be compiled and run independently:

```bash
# For files in default package
javac FileName.java
java FileName

# For files in packages (e.g., Leetcode, Graph.ShortestPathAlgorithm)
javac packagename/FileName.java
java packagename.FileName
```

## Course Information

**Course Code**: 953201 (SE201)
**Course Name**: Algorithms Design and Analysis

This repository serves as a comprehensive collection of algorithm implementations demonstrating various problem-solving techniques and optimization strategies taught throughout the course.
