#include <iostream> 
#include <string>
#include<bits/stdc++.h>

using namespace std;

string performSubtraction(string number1, string number2);
/**
 * Subtraction testing area
 */
int main()
{
    // This function call works only for parameter one greater than parameter two
    // in which both of them should be positive
    string output = performSubtraction("323", "123");
    cout << "Performed Subtraction: " + output + "\n" << endl;
    return 0;
}

string performSubtraction(string number1, string number2)
{
    reverse(number1.begin(), number1.end());
    reverse(number2.begin(), number2.end());

    string operationResult = "";

    int control = 0;
    
    while(control < number2.length()){

        int currentDifference = (number1[control] - '0') - (number2[control] - '0');

        if (currentDifference < 0)
        {
            currentDifference += 10;

            if ((number1[control + 1] - '0') != 0)
            {
                number1[control + 1] = ((number1[control + 1] - '0') - 1) + '0';
            }
            else
            {
                int nextNumberIndex = control + 1;
                
                while (nextNumberIndex < number1.length())
                {
                    if ((number1[nextNumberIndex] - '0') == 0)
                    {
                        number1[nextNumberIndex] = (9 + '0');
                        nextNumberIndex++;
                    }
                    else
                    {
                        number1[nextNumberIndex] = ((number1[nextNumberIndex] - '0') - 1) + '0';
                        break;
                    }
                }
            }
        }

        operationResult.push_back(currentDifference + '0');

        control++;
    }

    for (int i = number2.length(); i < number1.length(); i++)
    {
        operationResult.push_back(number1[i]);
    }
    reverse(operationResult.begin(), operationResult.end());

    return operationResult;
}