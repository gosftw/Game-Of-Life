# Game of Life

This is a project from hyperskill.org

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
```
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
```

## Stage #2: Adding model

### Description

The progress of the game is evolution: one generation changes another. Each generation is fully determined by the previous generation. The future of each cell depends on its neighbours (adjacent cells).

As you can notice, each cell has eight neighbours. We consider the universe to be periodic: border cells also have eight neighbours. For example:

If cell is right-border, its right (east) neighbour is leftmost cell in the same row.
If cell is bottom-border, its bottom (south) neighbour is topmost cell in the same column.

Corner cells use both solutions.

Evolution is controlled by two rules:

An alive cell survives if has two or three alive neighbours; otherwise, it dies of boredom (<2) or overpopulation (>3)

A dead cell is reborn if it has exactly three alive neighbours

The program should apply these rules to each cell in order to compute the next generation.

At this stage you should make several consecutive generations. For this you have to store the state of the universe in memory.

Use 2-dimensional arrays for this task. You need two arrays: one for the current generation and one for the next. Add these arrays to the program and implement the algorithm of getting the next generation.

NOTE: it will be better to encapsulate the state of the universe and the generation algorithm in separate classes. You will understand why soon.
The input data is three numbers in one line. The first is N (N>0), the size of the universe; the second is S, a long, that you should use as seed for your Random object; the third is M (M≥0), the number of generations your program should create.

Output data: a square matrix NxN: there must be N lines with N characters in each line. If there is an alive cell, place the letter ‘O’, otherwise, whitespace. The matrix should describe the generation after M steps from the beginning. So if M==8, you should find generation #9 (first is #1).

### Output examples

The lines that start with > represent the user input.
```
> 4 4 0
OOOO
O O
   O
OOO

> 8 1 10
 O  OO
OO   OO
O     O

  O
  O O
     OO
O   OO O

> 10 10 100


    O
   O O
    O
```
## Stage #3: Watch the evolution
   
### Description
   
   Well, now the universe is created, and its laws work properly.
   
   Let’s visualize the evolution. In the previous stage, we could see only one generation. It would be better if each generation was displayed. But our perception is not as fast as a computer’s, so our application should sleep a little after each generation. 
   
   
   Use methods of the class java.lang.Thread to achieve this goal.
   
   You can do this in two ways:
   
   output every generation to the console, one after one
   
   clear the console output before next generation appears
   
   Due to the cross-platform nature of Java, the second way can be complicated. You can use this code to clear the console output.
   ```java
   try {
       if (System.getProperty("os.name").contains("Windows"))
           new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
       else
           Runtime.getRuntime().exec("clear");
   }
   catch (IOException | InterruptedException e) {}
   ```
   
   ** You only read the size of the universe**, the seed and number of generations are defined by yourself. You may pass system time into the constructor of Random object from now on.
   
   The launched application must show evolution in progress.
   

## Stage #4: Adding GUI

### Description

Now you are ready to put aside the console and make your application look like this: 

Just create a window that displays the field of the game and counters (current generation and number of alive cells). For displaying the field, you can use methods that draw lines and fill rectangles. For counters, use simple text labels. 

It may look like you need to make a different application, but if you’re using the MVC pattern, you can add one or two classes to your code. 

The application should start and begin to update its look with every new generation in the game. For this stage no any interaction with the user is necessary.

## Stage #5: Adding GUI controller
   
## Description
   
   As we did in the previous stage, we are going to make application interactive. Just add two buttons: one should toggle pause/resume, another should start evolution over again, with a different initial state. 
   
   After this you will have an application that provides a comfortable experience of the Game of Life. Optionally you can add more features:
   
   1. increasing/decreasing evolution speed (use buttons or JSlider)
   
   2. color of cells (use JColorChooser or JComboBox)
   
   3. setting size of the new field (use JTextField or JDialog)
   
   4. save/load (use JFileChooser)
   
   5. and so on. 