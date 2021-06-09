Expeditors Take Home Assignment
-------------------------------

This maven project consists of two classes and a (brief) test suite. Running the Driver class as an application will print the results to the console. For the sake of simplicity, I hard-coded the 10 input data strings into a two-dimensional array. I understand that these could be passed as arguments in the String[] args parameter in the main class.

The 'mvn clean test' will run the included tests. The output of the test running should be 3 passed and 0 failed tests.

Some aspects of note are the use of the comparator class to sort, the inclusion of JUnit tests, the test suite, javadoc and the logger in the PrintHelper class. At present, it simply prints a warning in case of an issue with printing the contents.

The output printed to the console is patterned after the following directive:
"Each household and number of occupants, followed by:
Each First Name, Last Name, Address and Age sorted by Last Name then First Name where the occupant(s) is older than 18"

Assumptions made: 
- "older than 18" mean someone who is 18 years old or older. The result is one occupant omitted, but noted at end of printout.
- Tacoma, FL was intended to be Tacoma, WA. I changed all states to 'WA' using the standardCityAndState method.
- "234 2nd Ave.","XXXXXXXXXX","WA" could be an address in Seattle or Tacoma, WA. Thus both are listed in the printout for separate occupants.
- Ave,St and Blvd are to be appended with a period. Thus the standardizeAddresses method resolves this.
- Proper names should be capitalized and consist of lowercase letters after the first.


The expected output is the following:
================================================================================================== 
=============================== Expeditors Take Home Assignment ================================== 
==================================================================================================

Household Address:  234 2nd Ave., Tacoma, WA
Occupancy At Address:   3
---------------------------------------------
Frank, Jones, 234 2nd Ave., Tacoma, WA, 23
Eve, Smith, 234 2nd Ave., Tacoma, WA, 25
Bob, Williams, 234 2nd Ave., Tacoma, WA, 26


Household Address:  345 3rd Blvd. Apt. 200, Seattle, WA
Occupancy At Address:   2
---------------------------------------------
George, Brown, 345 3rd Blvd. Apt. 200, Seattle, WA, 18
Helen, Brown, 345 3rd Blvd. Apt. 200, Seattle, WA, 18


Household Address:  123 Main St., Seattle, WA
Occupancy At Address:   3
---------------------------------------------
Alice, Smith, 123 Main St., Seattle, WA, 45
Dave, Smith, 123 Main St., Seattle, WA, 43
Ian, Smith, 123 Main St., Seattle, WA, 18


Household Address:  234 2nd Ave., Seattle, WA
Occupancy At Address:   1
---------------------------------------------
Carol, Johnson, 234 2nd Ave., Seattle, WA, 67


Omitted 
--------------------------------------------- 
Jane, Smith, 123 Main St., Seattle, WA, 13

================================================================================================== 
============================================ End ================================================= 
==================================================================================================

