# LDTS_l05gr06 - TETRIS RUNNER

### Game Description

![](imagens/uml.png)
![](imagens/state.png) ![](imagens/gif.gif)


In this new exciting multiplayer version of a game we all are familiar with - tetris - there's a vast sea of fun ways to play it.
The game is basically the tetris everyone knows, but there's a little man down there, where the pieces fall, trying to avoid them. 

This makes it so there's a lot of options for the users - let's call the user controlling the pieces player1 and the other one
player2 - to choose:

- **"Classic"** - While player1 is playing normal tetris, player2 is just avoiding the falling pieces;
- **Co-op** - Player1 is trying to get player2 up top as fast as possible;
- **1v1** - Player1 is purposefully trying to make player2 loose.

This project was developed by *Francisco Campos* (*up202108735*@up.pt), *João Figueiredo* (*up202108829*@up.pt) and *João Longras* (*up202108780*@up.pt) for LDTS 2022⁄23.

### IMPLEMENTED FEATURES

> This section should contain a list of implemented features and their descriptions. In the end of the section, include two or three screenshots that illustrate the most important features.

**Menu**: Working menu with multiple options, such as 'Game Mode', to select the intended variant of the game and 'Instructions', to read the instructions of each
mode. We also implemented the tetris theme song running on the background, therefore there's an additional option 'Settings' in which you can mute and change the music's volume.

Although the pause menu isn't working totally by now, it's already possible to pause the game by pressing ESC. 


**Player2**:

- **Jumping** - The game character will jump when the arrow-up key is pressed.
- **Moving** - The player will move, sideways, when the user presses arrow-left or arrow-right.



### PLANNED FEATURES

Currently, there's a block class implemented, which is 100% temporary and its purpose is to test player2's dynamics 
regarding the shapes. In the future, we will implement, instead, the shapes itself (you can get an idea of what we planned
observing the UML). Shape will be an abstract class with ShapeSquare, ShapeT, ShapeS, ShapeZ, ShapeL, ShapeJ and ShapeLine extending it.

As pause isn't yet returning to the game, we will need some form of saving the game state when pausing, we will do that with a specific pattern, more on that later.

We also need to implement Player1's inputs.

**Player1**:

- **Moving the shape** - The shape will move, sideways, when the user presses 'A' or 'D' (left or right, respectively).
- **Rotating the shape** - The shape will rotate, when the user presses 'W' or 'S' (clockwise or anti-clockwise, respectively).

We also need to create the GameOverState, which will differ from game mode to game mode. Each game mode, mechanically speaking, is exactly the same, therefore
the GameState is the same, but who wins and the leaderboards change according to the chosen mode. For this we will also need to implement a new pattern, maybe the same as the pause one.


### DESIGN

#### PROBLEM OF ORGANIZATION OF CODE

**Problem in Context**

It is hard to first decide what main method to organize our code, but it is very important to decide how are we going to do it early on 
because that allows us to start building our project in a structured, and avoid organizational errors in the future of the project.

**The Pattern**

To accomplish this, we decided to use the **MVC (Model-Viewer-Controller)** architectural pattern. This architectural pattern
is commonly used for developing user interfaces that divides an application into three parts. The model represents the data,
the view displays the model data, and sends user actions to the controller, and finally the controller provides model data
to the view, and interprets user actions.

**Implementation**

The UML presented at the beginning of the report shows how we organized our code by that model.

**Consequences**

The use of the MVC Architectural Pattern in the current design allows the following benefits:

- Organize our code logically by its 3 main components: behaviour control, data and media visualization.
- We achieve a more Object-Oriented Programming, by dividing the classes on what they do, rather than how they do it
- There are now more classes and instances to manage, but still in a reasonable number.

Therefore, we considered this to be the best pattern to organize our code.

------

#### IMPLEMENTATION OF SEVERAL MENUS

**Problem in Context**

We needed to implement a lot of Menus (shown in code), so the user may select and traverse through the game.

**The Pattern**

To accomplish this, we decided to use the **Factory** pattern. We created a abstract class Menu, which is the extended
by the other sub-classes.

**Consequences**

The use of the Factory Method Pattern in the current design allows the following benefits:

- Factory methods eliminate the need to bind application-specific classes into our code

Therefore, we considered this to be the best pattern to organize our code.

------

#### PROBLEM OF TRAVERSAL THROUGHOUT THE CODE

**Problem in Context**

We need to know 

**The Pattern**

To accomplish this, we decided to use the **State** pattern. This design pattern is specially helpful when
an object behavior depends on its state, and it must change that state in run-time. Since we have a lot of states of the
program that need to be achieved (Menu States, Game States, ...), then this pattern is ideal to us.

**Implementation**

The UML presented at the beginning of the report shows how we organized our code by that model.

**Consequences**

The use of the MVC Architectural Pattern in the current design allows the following benefits:


- Localizes and partitions behavior for different states.
- Makes state transitions explicit.
- We don’t need to have a long set of conditional if or switch statements associated with the various states; instead, polimorphism is used to activate the right behavior.
- There are now more classes and instances to manage, but still in a reasonable number.

Therefore, we considered this to be the best pattern to organize our code.

-----

#### KNOWN CODE SMELLS AND REFACTORING SUGGESTIONS

The biggest code smell we encountered during this first phase of the project was the usage of a static element in the class `Setting`, used
on another class `Pause`. We decided to do that to solve the conflict between the return of the `Settings` to either `Pause` 
or `StartMenu`. We expect to solve this problem until the final delivery of the project, by using the **Strategy Pattern** to
improve our code.

We also are aware that there are other code smells in our project, but since they are minor ones, due to time constrains we are
not going to talk about them in this delivery, and we expect to have them solved until the release of the demo.

### TESTING

![](imagens/coverage.png)


### SELF-EVALUATION

- Francisco Campos: 33.3%
- João Figueiredo: 33.3%
- João Longras: 33.3%