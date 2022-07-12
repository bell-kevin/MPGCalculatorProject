# Miles Per Gallon Calculator
SDEV 1060 Project. 

This project calculates miles per gallon (MPG) for a single trip, and for all trips entered. There is a class for MPG for a single trip, with instance variables for miles, gallons, and MPG for that trip. In addition, there are class (static) variables for total miles, total gallons, total MPG, and number of trips. In the main class, several trips are created and the values are displayed. At the end, the total MPG (total miles / total gallons) is displayed.

Trip 1: miles = 320, gallons = 29
Trip 2: miles = 325.8, gallons = 32.1
Trip 3: miles = 412.5, gallons = 35

Trip 4: miles = 345, gallons = 32.6

In this assignment, you will walk through adding unit testing to that project. All the numbers will be hard-coded, to test the methods without any concern about user input.  Create a new project; add a class called MPG; add the code for the Main class.
 
 The class needs 2 display methods, one for a single trip, one for all of the combined trips.
 
 The main class must begin with the header that says "MPG Testing by Student Name", written as needed for the language of your project.
 
 In C#, at the bottom of the main method, be sure to include the coding to pause until any key is pressed.

Once you have created this project and written the code, run it and make sure the results match those above.

Now add unit testing. When you look at the class for MPG, what methods can be tested? There are 2 display methods, which are easy to test with visual inspection of just a few test cases. Those methods should be tested, but we will focus on testing variables and the result of calculations here. The constructor does a lot of work, that would be a good place to test that the MPG object was created correctly and that its calculations were correct.

Add a testing file / project. In Java: You can start with one that tests an existing class, or an empty one. The empty ones have all you need to get started here; if you test an existing class (the MPG class), it will generate shells for testing all methods in the class, and you can simply delete them.

Remember that the basic pattern for a unit test is Arrange-Act-Assert. What needs to be arranged to make the test work? An MPG object has to be instantiated, so that the constructor will assign data to the class and instance variables. This is typical instantiation of an object, with specific parameters.

Those numbers of 300 and 10 are test case values, which result in an MPG of 30. When the object was instantiated with miles = 300 and gallons = 10, the constructor should have stored 300 in the miles variable, 10 in the gallons variable, 30 in the MPG variable, 300 in the total miles variable, 10 in the total gallons variable, 30 in the total MPG variable, and 1 in the number of trips. That is what we will test.

Once the object exists, we can check if the variables were assigned correctly. Is the miles variable correctly assigned 300? If you try to write an assertion, you would begin with "assertEquals(300, ..." -- how do you get the value of the miles variable? There is no method currently in the class, because it was not written with testing in mind. So you have to add a method to "getMiles" that can return the value of the miles variable. The same applies to all of the variables in the object -- if we want to test them, we have to have a way to "get" those values. 

Add methods to get miles, gallons, MPG, total miles, total gallons, total MPG, and number of trips -- the test needs to check all of them. Where do you write these methods? In the MPG class. This is an example of refactoring, where you make changes to the code to get successful tests. In the Java or C# courses, you learned about accessor and mutator methods, also known as getters and setters. The best way to protect the data of an object is to make its instance variables private; that means you must provide a method that allows access to that data if it is appropriate. Sometimes there is a very good reason not to have a getter for some piece of data; that is a business logic decision. In general, best practice is to have getters and setters for each instance and class variable in the class. But it's so easy to get lazy and not include that code if the specific project doesn't seem to need it. That was the case here -- the original project did not need to access the variables because the display methods handled everything. But now that we want to add testing, the test methods do need access to the variables, so now we will refactor the code to add those methods.

Now that we have these methods available in the class, we can go back to the test method that asserts the miles variable was correctly set to 300. We can also add assertions that all the other variables also have the correct values.

Remember that most of the variables are doubles. An assert statement using doubles needs the delta parameter, how many places to check for equality. The final test, for number of trips, is an integer, so it doesn't need that third parameter.

Is it appropriate to have all these assertions in one test? Some definitions of unit testing say no -- each test should check one thing only. Some writers of unit test say yes -- the arrange step created this object with multiple fields, so test all of them immediately. Here, we will go for testing them all at once, and this will provide some extra value, as you will see in a moment.

Run this test -- it should pass. So we know the constructor works. Or do we? The constructor does some calculations with the class variables when additional MPG objects are instantiated. Have we checked those calculations yet? We checked the operation of assigning the original value, but to really test it, we have to add a second object and see if the total miles, total gallons, total MPG, and number of trips change as expected.

The first test case is the one we looked at above. The second test case shows the result of calculations -- the number of trips increased by 1, the total miles is the sum of the miles for the two test cases, the total gallons is the sum of the gallons from each test case, and the total MPG is calculated with the total miles and total gallons values. To test the result of instantiating that second case, the test method has to instantiate a second object. That is part of the Arrange step -- the environment must be set up so that it allows more testing.

Create a new test in the test file.

Create a new test in the test file. It needs to arrange 2 MPG objects, like this:

    MPG first = new MPG(300, 10);
    MPG second = new MPG(400, 20);

Now we can test the individual miles, gallons, and MPG for each instance, and then test if the total miles, total gallons, and total MPG are correct for 2 objects. You already have the tests for the first object from the other test method to test a single object. You need to test those, and add tests for the "second" object's variables as well. 

Notice that there are 2 asserts for getMiles(), one for "first" (the first object) and one for "second" (the second object). We have already tested that the miles are assigned correctly in the constructor, in the previous test method, so you could leave that test out, right? Perhaps, but we haven't tested how a second instantiation behaves, if it works properly. Test that miles, gallons, and MPG are correctly assigned in both instantiated objects. Because two objects are instantiated, the total values should have changed, the result of calculations, so they need to be tested. These are class variables and class methods (total miles and getTotalMiles(), for example), there is only 1 shared by all objects, so you can access those variables and methods through any object. Here, the code in the first test method, the one testing a single object named "first", was copied for adding the second object named "second". Since the class variables were already referenced using "first", you can leave them, or change them to "second" if you wish -- either way, the single class variable and class method for the total miles, or total gallons, or total MPG, or number of trips is accessible through either "first" or "second".

Run the test -- it fails! Depending on which test runs or completes first, it reports that the total miles, or total gallons, or total MPG, or number of trips did not pass the test.  Remember that there are static variables in the MPG class, and those are the values we are trying to test. The test file now has one test that creates an object to test the assignment of values to the instance variables in the constructor (the first one we wrote), and a second test that creates two objects to test the calculations in the constructor. There are 3 objects in the two tests. Since all 3 were instantiated during the run of the test file, there are 3 objects, with 2 versions of the first test object ("first") and 1 version of the second test object ("second"). With 3 objects, the class values are all too high for what we wrote as the expected results. When the test file is running, tests can interact with each other like this. Do we need both test methods? The first one tests a single instantiation; the second one has two instantiations. The data we checked in the first one is also being checked in the second one, so we can verify that the miles, gallons, and MPG are correct for each instance. The existence of the second one allows us to check the calculations in the constructor. So the second test seems more thorough than the first. Delete the first test method that created only a single object -- its work is done in the second one and we won't end up with extra objects that mess up the test. Run the test again -- it should pass this time.

For this assignment, create a new test case table with 4 trips in it -- do NOT use the 4 trips that were shown above. Fill out the test case table as shown here. In the test method, instantiate all 4 trip objects. The assertions testing the instance variables (miles, gallons, MPG) should test all 4 cases. The assertions testing the class variables (total miles, total gallons, total MPG, number of trips) can be tested by referencing any of the 4 objects; these variables only exist once, shared by all objects, so you can access those variables through any object. Make sure all tests pass.

Take a screenshot of the test results screen showing success. Take screenshots of the test method.

Submission: Word document or text file with table of test cases; screenshots; root folder for the project
