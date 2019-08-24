## Fragments / Kotlin ##

### Screenshots ###
<p float="left">
  <img src="/screenshots/1.png" width="200" />
</p>

### Code ###
1. Create a multi pane app (add two fragment to the activity in a sequence)
2. Fragment one should have a list of celebrity names.
3. Fragment two should have the detail of the celebrity selected.
	1. should be updated on each list item clicked
	2. should have at least a picture of the celebrity (you can save all the images in the drawable folder), short description. But be creative to add more if you like.
* Use different attributes to make the design better.
* Do not use EventBus
* MUST USE KOTLIN!!!!

### Research ###
1. <b>What is static, inferred and dynamic typing?</b>
* Static
	* Variable can only be assigned to objects of one fixed type.
	* Kotlin is statically typed.
* Inferred
	* When a programming language can detect the type of a variable, therefore, the type does not need to be typed out.
	* Kotlin can detect the type of a variable name.
* Dynamic
	* The same variable name can be assigne dto all kinds of different types.
	* Languages like Python or JavaScript are dynamically typed.
2. <b>How does stringiest pools work in JAVA?</b>
3. <b>What is functional Programming and how does it differ from pure object oriented?</b>
* Functional 
	* Can be translated well into an interactive environment which makes code more readable.
	* Provides advantages in efficiency, lazy evaluation, nested functions, bug-free code and parallel programming.
	* A function can be easily invoked and resused at any point.
* OOP
	* Abstraction, inheritance, polymorphism and pncapsulation.
	* Memory management which is beneficial for desiging large programs with the ability to execute or plan different components ina  specific way.
4. <b>What is  lambda function?</b>
* Anonymous functions that can be treated as values.
* Can be treated like an object, such as passing them as arguments to methods.
5. <b>What are some ways Kotlin achieves null safety?</b>
* An explicit call to throw NullPointerException()
* Usage of the !! operator that throws an exception if a null value is set to a variable.
* When dealing with Java interoperation, the ? operator shoud be used for initializing variables that can be null.
* Elvis operator (?:) checks if a variable is not null and use it, otherwise use some other non-null value to the right of the colon.
