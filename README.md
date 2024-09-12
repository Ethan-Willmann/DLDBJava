# DLDBJava
Drivers license database that uses basic GUI to retrieve license plate data input from user and store by writing to a file.

This project uses Object-Oriented Programming to store license plate data as objects and has functions to check the validity of data input. This project was done for a class to test knowledge of OOP in java, as well as introduce GUI.

How it works:
1. Takes user input in text boxes for storing license plate data
2. Data is checked to see if corrisponding license plate is in the right format and is from either Kansas or Missouri
3. If data is incorrect or state is not right, a message appears that tells the user what input is wrong, along with the correct format for their respective state's license plate
4. If the data is correct and hasn't already been entered, it will be stored as an object and written to a file
5. If the user wishes to print all of the data entered, they can print the list using the "print list" button to return all of the data that has been written to the writing file
