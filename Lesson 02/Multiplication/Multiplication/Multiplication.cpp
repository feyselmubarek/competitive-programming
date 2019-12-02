// Multiplication.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <string.h>
#include <string>

using namespace std;

// declaring the function for given operation
string performAdditionForMultiplication(string number1, string number2);
string performMultiplication(string number1, string number2, string sign);

// starting point of the program
// determines the smaller and larger number to pass to declared functions
int main()
{
	// sample big nnumbers
	string number3 = "267347364367430", number4 = "-787823728783273825";

	// for determinig sign of the operation
	string sign = "";

	// for storing the result returned from functions
	string output;

	if (number4[0] == *"-" && number3[0] == *"-")
	{
		// case 1: if both numbers are negative
		output = performMultiplication(number4.substr(1), number3.substr(1), "+");
	}
	else if (number4[0] != *"-" && number3[0] != *"-") 
	{
		// case 2: if both numbers are positive
		output = performMultiplication(number4, number3, "+");
	}
	else if (number4[0] == *"-" && number3[0] != *"-")
	{
		// case 3: if the first one is only negative
		
		if ((number4.length() - 1) > number3.length())
		{
			// 1.inner case: the first one is bigger
			output = performMultiplication(number4.substr(1), number3, "-");
		}
		else if ((number4.length() - 1) < number3.length())
		{
			// 3.inner case: the second one is bigger
			output = performMultiplication(number3, number4.substr(1), "-");
		}
		else
		{
			// 3.inner case: Both are equal in length
			output = performMultiplication(number3, number4.substr(1), "-");
		}
	}
	else
	{
		// case 4: if the second one is only bigger
		
		if ((number3.length() - 1) > number4.length())
		{
			// 1.inner case: the first one is bigger
			output = performMultiplication(number3.substr(1), number4, "-");
		}
		else if ((number3.length() - 1) < number4.length())
		{
			// 3.inner case: the second one is bigger
			output = performMultiplication(number4, number3.substr(1), "-");
		}
		else
		{
			// 3.inner case: Both are equal in length
			output = performMultiplication(number4, number3.substr(1), "-");
		}
	}

	// printing answer
	cout << "Answer: " + output << endl;

	// exiting
	return 0;
}

string performAdditionForMultiplication(string number1, string number2)
{
	// checking the bigger number in size
	if (number1.length() > number2.length())
		swap(number1, number2);

	// string for result of operation
	string operationResult = "";

	// finding smaller length  for loop control
	int smallerLength = number1.length(), largerLength = number2.length();

	// carry variable
	int carry = 0;

	// adding upto smaller length
	for (int i = 0; i < smallerLength; i++)
	{
		int sum = ((number1[i] - '0') + (number2[i] - '0') + carry);
		operationResult.push_back(sum % 10 + '0');
		carry = sum > 9 ? 1 : 0;
	}

	// adding the remaning ones
	for (int i = smallerLength; i < largerLength; i++)
	{
		int sum = ((number2[i] - '0') + carry);
		operationResult.push_back(sum % 10 + '0');
		carry = sum > 9 ? 1 : 0;
	}

	// if any carry avaliable
	if (carry > 0)
	{
		operationResult.push_back(carry + '0');
	}

	return operationResult;
}

string performMultiplication(string number1, string number2, string sign) {
	
	// for storing the whole summations
	string sumationResult = "0";

	// reversing numbers for loop manipulattion
	reverse(number1.begin(), number1.end());
	reverse(number2.begin(), number2.end());

	// looping using the smaller one assimuing the parameters are passed in that manner
	for (size_t i = 0; i < number2.length(); i++)
	{
		// for storing single loop summation
		string operationResult = "";

		// carry for carry and offsets for adding zeros to revome the indentation
		int carry = 0; string offset = "";

		// for looping throw the larger number and multiply with current smaller one
		for (size_t j = 0; j < number1.length(); j++)
		{
			int product = ((number2[i] - '0') * (number1[j] - '0') + carry);
			
			// if any carry setting it to zero
			carry = 0;
			
			// converting the double figure number
			string p = to_string(product);

			// if product of them is double digits
			if (product > 9) {
				// pushing at the back of single loop sumation var
				operationResult.push_back(p[1]);
				// updating carry
				carry = (p[0] - '0');
			}
			else {
				// normal condition
				operationResult.push_back(p[0]);
			}
		}

		if (carry > 0)
		{
			// if any remaining carry value
			operationResult.push_back(carry + '0');
		}

		for (size_t k = 0; k < i; k++)
		{
			// adding offsets to avoid indentation
			offset.append("0");
		}

		// getting the full signle loop result
		operationResult = offset.append(operationResult);

		// calculating summation of multiplication of signle loop result and  total summation
		sumationResult = performAdditionForMultiplication(sumationResult, operationResult);
	}

	sign == "-" ? sumationResult.append(sign) : sumationResult.append("");
	
	reverse(sumationResult.begin(), sumationResult.end());

	return sumationResult;
}
