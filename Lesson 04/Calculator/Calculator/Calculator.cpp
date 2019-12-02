// Calculator.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <string>

using namespace std;

// declaring the function for given operation
string performAddition(string number1, string number2, string sign);
string performSubtraction(string number1, string number2, string sign);

string performAdditionForMultiplication(string number1, string number2);
string performMultiplication(string number1, string number2, string sign);

string performDivision(string number1, string number2);
string getDecimalPoint(string number1, string number2);

bool checkSize(string number1, string number2);
string parser(string number);
string rounder(string number);

int main()
{
	// check divsion
	cout << performDivision("1", "8") << endl;
}

string performAddition(string number1, string number2, string sign)
{
	// checking the bigger number in size
	if (number1.length() > number2.length())
		swap(number1, number2);

	// string for result of operation
	string operationResult = "";

	// finding smaller length  for loop control
	int smallerLength = number1.length(), largerLength = number2.length();

	// reversig for loop manipulation
	reverse(number1.begin(), number1.end());
	reverse(number2.begin(), number2.end());

	// carry variable
	int carry = 0;

	// adding upto smaller length
	for (int i = 0; i < smallerLength; i++)
	{
		int sum = ((number1[i] - '0') + (number2[i] - '0') + carry);
		operationResult.append(to_string(sum % 10));
		carry = sum > 9 ? 1 : 0;
	}

	// adding the remaning ones
	for (int i = smallerLength; i < largerLength; i++)
	{
		int sum = ((number2[i] - '0') + carry);
		operationResult.append(to_string(sum % 10));
		carry = sum > 9 ? 1 : 0;
	}

	// if any carry avaliable
	if (carry > 0)
	{
		operationResult.append(to_string(carry));
	}

	// back-reversing the result, since we made operation using reversing
	reverse(operationResult.begin(), operationResult.end());

	return sign == "+" ? operationResult : ("-" + operationResult);
}

string performSubtraction(string number1, string number2, string sign)
{
	// reversing both numbers for looping
	reverse(number1.begin(), number1.end());
	reverse(number2.begin(), number2.end());

	// stores result of the operation
	string operationResult = "";

	// contrrols the loops until the samller lengtth is coverd
	size_t control = 0;

	while (control < number2.length())
	{

		// calculating the current difference bewtween the digits
		int currentDifference = (number1[control] - '0') - (number2[control] - '0');

		// if thier differenece is leass than zero we need some maths
		if (currentDifference < 0)
		{
			// finding the real difference
			currentDifference += 10;

			// if the next elements are one zero followed by non zero elements
			if ((number1[control + 1] - '0') != 0)
			{
				number1[control + 1] = ((number1[control + 1] - '0') - 1) + '0';
			}
			else
			{
				// for multiple zeros until non zero element is found
				size_t nextNumberIndex = control + 1;

				while (nextNumberIndex < number1.length())
				{
					if ((number1[nextNumberIndex] - '0') == 0)
					{
						// making zeros nine
						number1[nextNumberIndex] = (9 + '0');
						nextNumberIndex++;
					}
					else
					{
						// making the non zero element, element - 1
						number1[nextNumberIndex] = ((number1[nextNumberIndex] - '0') - 1) + '0';
						break;
					}
				}
			}
		}

		// adding at the back of the operationResult
		operationResult.append(to_string(currentDifference));

		// updating control for while loop
		control++;
	}

	// for remaning elemnts of the larger number
	for (size_t i = number2.length(); i < number1.length(); i++)
	{
		operationResult.push_back(number1[i]);
	}

	// reversing back the operationResult since all operation are done in reverse manner
	reverse(operationResult.begin(), operationResult.end());

	sign == "+" ? operationResult.append("") : operationResult.append(sign);

	return parser(operationResult);
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

string getDecimalPoint(string number1, string number2) {
	int counter = 0;
	string decimal;

	string temp = performMultiplication(to_string(counter), number2, "+");

	while (checkSize(number1, temp))
	{
		counter++;
		temp = performMultiplication(to_string(counter), number2, "+");
	}

	if (checkSize(temp, number1))
	{
		counter--;
		temp = performMultiplication(to_string(counter), number2, "+");
	}

	decimal = to_string(counter);

	return rounder(decimal);
}

string performDivision(string number1, string number2) {
	int counter = 0;
	string beforeDecimal = "0";
	string afterDecimal = "";

	// needs modification
	if (number2.length() > number1.length())
	{
		//TODO -- consider the case for 1/80 
		// modify this if block the remaining is done
		int size1 = number1.length();
		int size2 = number2.length();

		cout << size2 - size1 << endl;

		for (int i = 0; i < size2 - size1; i++)
		{
			number1.append("00");
		}
		number1.append("000");

		afterDecimal = getDecimalPoint(number1, number2);
		//reverse(afterDecimal.begin(), afterDecimal.end());

		return beforeDecimal + "." + afterDecimal;
	}

	string temp = performMultiplication(to_string(counter), number2, "+");

	while (checkSize(number1, temp))
	{
		counter++;
		temp = performMultiplication(to_string(counter), number2, "+");
	}

	if (checkSize(temp, number1))
	{
		counter--;
		temp = performMultiplication(to_string(counter), number2, "+");
		string number = performSubtraction(number1, temp, "+");

		number.append("0000");
		afterDecimal = getDecimalPoint(number, number2);
	}

	beforeDecimal = to_string(counter);

	return beforeDecimal + "." + afterDecimal;
}

bool checkSize(string number1, string number2) {
	if (number1.length() > number2.length())
	{
		return true;
	}
	else if (number1.length() < number2.length())
	{
		return false;
	}
	else {
		size_t c = 0;

		// making control by one of the number length
		while (c < number2.length())
		{
			if ((number1[c] + '0') > (number2[c] + '0'))
			{
				// if number 4 is greater
				return true;
			}
			else if ((number1[c] + '0') < (number2[c] + '0'))
			{
				// if number 3 is greater
				return false;
			}

			// increameting control
			c++;
		}

		return false;
	}
}

string parser(string number) {
	int i = 0;
	string parsedNumber = "";

	for (int i = 0; i < number.length(); i++)
	{
		if (number[i] != *"0")
		{
			parsedNumber.push_back(number[i]);
		}
	}

	return parsedNumber;
}

string rounder(string number) {
	int i = 0;
	string roundedNumber = "";

	for (int i = 0; i < number.length(); i++)
	{
		if (i == number.length() - 2)
		{
			char n = number[i + 1];

			if (n - '0' >= 5)
			{
				roundedNumber.append(to_string((number[i] - '0') + 1));

				return roundedNumber;
			}
			else if (n - '0' >= 0)
			{
				roundedNumber.append(to_string((number[i] - '0')));
				return roundedNumber;
			}
			else
			{
				roundedNumber.push_back('0');
			}
			return roundedNumber;
		}
		else {
			roundedNumber.push_back(number[i]);
		}
	}

	return roundedNumber;
}


