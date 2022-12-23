### DESIGN

#### PROBLEM OF ORGANIZATION OF CODE

**Problem in Context**

It is hard to first decide how are we going to organize our code, but it is very important to decide how are we going to do it early on
because that allows us to start building our project in a structured manner, and helps us avoid organizational errors in the future of the project.
That is, if we don't take the initiative to compartmentalize our code into its functional logic, later on it's really hard
to add new features, or work with previous features, because everything is in a "tangled thread" of random classes and methods,
making it hard to look for we want to find.

**The Pattern**

To solve this problem, we decided to use the **MVC (Model-Viewer-Controller)** architectural pattern. This architectural pattern
allows us to divide our project into three integral parts: the model, the viewer, and the controller. The model contains the data
of the objects, the viewer displays the model data, and sends user actions to the controller, and finally the controller provides model data
to the view, interprets user actions. By organizing the code this way, we're sure that when we need to change with the display of
data of a certain model, we just need to access the viewer, and when we need to execute the inputs done by the user and change the
model data, we use the controller.

**Implementation**

The UML presented at the beginning of the report shows how we organized our code by that model.

However, to see a simpler way of the implementation of the MVC Architectural Pattern, you can check
the following diagram, or the packages that contain the Model, Controller and Viewer classes.

![MVC Diagram](images/mvc.png)

- [Model](../src/main/java/tetrisRunner/model)
- [Viewer](../src/main/java/tetrisRunner/viewer)
- [Controller](../src/main/java/tetrisRunner/controller)

**Consequences**

The use of the MVC Architectural Pattern in the current design allows the following benefits:

- Organize our code logically by its 3 main components: behaviour control, data and media visualization.
- We achieve a more Object-Oriented Programming, by dividing the classes on what they do, rather than how they do it
- There are now more classes and instances to manage, but still in a reasonable number
- In the long term, this model allows us to make the maintenance of the project easier

Therefore, we considered this to be the best pattern to organize our code.

------

#### IMPLEMENTATION OF SEVERAL MENUS

**Problem in Context**

We need to implement a lot of menus in our game. That is because, as we said above, want the user to select different
options before he can start the game. It can be the Game Mode, or he maybe doesn't want to hear the music playing, so
he wishes to mute it, or hen doesn't want to play the game at all, and he wishes to quit. Therefore, it is necessary that
we provide different Menus, according to the user wishes.

**The Pattern**

To accomplish this, we decided to use the **Factory** pattern. We created an abstract class Menu, which is then extended
by the other sub-classes (other sub-menus).

**Implementation**

As it can be seen in the UML, there is a Menu that is being extended by other sub-menus.

**Consequences**

The use of the Factory Method Pattern in the current design allows the following benefits:

- Factory methods eliminate the need to bind application-specific classes into our code

Therefore, we considered this to be the best pattern to implement new sub-menus easily, since they share a lot of features
with each other.

------

#### PROBLEM OF TRAVERSAL THROUGHOUT THE CODE

**Problem in Context**

We need to know how are we going to achieve the different states of the game. What usually happens (and is a bad programming
practice in OOP) is the usage of if-else clauses to achieve different stages of the game. However, that just makes
the code harder to decipher in the future, and harder to modify (because we would have to search all the if-else clauses)
to find the change we need to do.

**The Pattern**

To accomplish this, we decided to use the **State** pattern. This design pattern is specially helpful when
an object behavior depends on its state, and it must change that state in run-time. Since we have a lot of states of the
program that need to be achieved (Menu States, Game States, ...), then this pattern is ideal to us.

**Implementation**

The UML presented at the beginning of the report shows how we organized our code by that model (creation of an abstract class
State<T>, that takes as arguments the different states we wish to achieve).

**Consequences**

The use of the State Pattern in the current design allows the following benefits:


- Localizes and partitions behavior for different states.
- Makes state transitions explicit.
- We don’t need to have a long set of conditional if or switch statements associated with the various states; instead, polimorphism is used to activate the right behavior.
- There are now more classes and instances to manage, but still in a reasonable number.

Therefore, we considered this to be the best pattern to achieve different sections of our game, keeping a good OOP
practices, and making it easier to implement the state diagram shown above.