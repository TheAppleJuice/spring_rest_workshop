Project setup:
1. Create a Spring Boot project using spring initializer like this: a. Define Group as se.lexicon.[your name]
   b. Artifact as registeration
   c. Java 8
   d. Spring Boot DevTools, lombok, Spring Web, Spring Data JPA, MySQL Driver and H2 Database.
2. Make sure you change scope of H2 Database to test in the pom.xml.
3. In application.properties configure JPA and create an empty database in MySQL.
4. Test Run application.
5. Commit.

Defining Entity:
1. Define a package for entities (entity)
2. Create a Student Entity (use UUID for id variable).
3. Using Lombok annotation create setter, getter, equal and hashCode.
4. Implement Unit test.
5. Push and Commit.

Creating repositories / Dao classes:
1. Make a new package for your data layer.
2. Inside the package create repositories / Dao classes that are able to do basic CRUD.
3. Integration test findById, findAll, save and delete for each of your classes / repositories.
   a. Make sure that you test the relationship in loan works as expected.
   Add additional functionality to repositories / Dao classes:
1. Student repository / dao:
   a. Add ability to find by email.
   b. Add ability to find by first name and last name.
   c. Unit test method
   d. Commit
   Clean up your code:
1. Make sure you have no unused imports and commented out code.
2. Commit and push

Creating controllers:
1. Create a new package under the root package called “controller”.
2. Create a new class inside the controller package called “StudentController”.
   a. Inside “StudentController” class inject StudentRepository in order to access it’s functionality.
   b. Annotate the class with @RestController.
3. Define the following functionality inside StudentController:

