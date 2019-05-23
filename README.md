# Game of Life

## Preview stage 1: Let there be light!

### Description

This not a game in the usual meaning of a game. The human player’s input just creates the initial state of the “universe.” After that, the game is completely deterministic, and one just observes the evolution of life forms, migration, and even socialization of primitive organisms.

The Game of Life was described by John Conway in 1970. It came from a mathematical problem, and since 1970 it has attracted the interest of scientists in various fields: physics, biology, economics, and so on.

The most amazing feature of this game is its simplicity, leading to many more complex patterns.

Who knows, maybe this game touches something fundamental in this world?

By completing this project, you will make an application with multithreading and a graphical user interface. Also, the MVC pattern is very suitable for this application.

In the first stage, you need to create a “map” of the universe in its first moment of existence ― the first generation.
The universe in this game looks like a grid in which each cell has one of two possible states: populated (alive) or not populated (dead).
Before the game starts, the player should define the state of each cell. To make the first state of the universe, we will use randomness.

To move from the first cell to the last, use the nextBoolean() method of java.util.Random to define its state. Populate the cell as alive if nextBoolean returns true, and dead if false.

We’ll begin with the console version of the application and add GUI later.

The first program should output a square matrix NxN: there must be N lines with N characters in each line. If there is an alive cell, place the letter ‘O’, otherwise, whitespace.

Input data is two numbers in one line. First is N (N>0): the size of the universe. The second is S: a number that you should use as the seed for your Random object.

### Output examples
The lines that start with > represent the user input.

> 4 4
OOOO
O O 
   O
OOO 


> 4 120
OO	 
O  O
 OO 
 O 


> 10 10
O    O  O 
 OOOO   O 
 O   OO O 
OO OO  OO 
   O      
OO OOOOOOO
OO O O  OO
    O O  O
OO       O
OOOO    O 


