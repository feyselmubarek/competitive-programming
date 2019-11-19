#include <iostream> 
#include <string>
#include<bits/stdc++.h> 

using namespace std; 

string performAddition(string number1, string number2, string sign) 
{ 
    if (number1.length() > number2.length()) 
        swap(number1, number2); 

    string operationResult = ""; 

    int smallerLength = number1.length(), largerLength = number2.length(); 

    reverse(number1.begin(), number1.end()); 
    reverse(number2.begin(), number2.end());

    int carry = 0; 

    for (int i = 0; i < smallerLength; i++) 
    {
        int sum = ((number1[i] - '0') + ( number2[i] - '0') + carry); 
        operationResult.push_back(sum % 10 + '0');
        carry = sum > 9? 1: 0; 
    } 


    for (int i = smallerLength; i < largerLength; i++)
    { 
        int sum = ((number2[i] - '0') + carry); 
        operationResult.push_back(sum %10 + '0'); 
        carry = sum > 9? 1 : 0; 
    } 

    if (carry > 0){ operationResult.push_back(carry + '0'); }
    
    if(sign.compare("-") == 0){
        operationResult.push_back('-');
    }

    reverse(operationResult.begin(), operationResult.end()); 
    return operationResult; 
}

// string performSubstraction(string number1, string number2, string sign) 
// { 
//     if (number1.length() > number2.length()) 
//         swap(number1, number2); 

//     string operationResult = ""; 

//     int smallerLength = number1.length(), largerLength = number2.length(); 

//     reverse(number1.begin(), number1.end()); 
//     reverse(number2.begin(), number2.end());

//     int carry = 0; 

//     for (int i = 0; i < smallerLength; i++) 
//     {
//         // if((number1[i] - '0') - ( number2[i] - '0') < 0){
//         //     ("1" + number1[i]) - '0' - ( number2[i] - '0')
//         // }
//         int sum = ((number1[i] - '0') + ( number2[i] - '0') + carry); 
//         operationResult.push_back(sum % 10 + '0');
//         carry = sum > 9? -1: 0; 
//     } 


//     for (int i = smallerLength; i < largerLength; i++)
//     { 
//         int sum = ((number2[i] - '0') + carry); 
//         operationResult.push_back(sum %10 + '0'); 
//         carry = sum > 9? -1 : 0; 
//     } 

//     if (carry > 0){ operationResult.push_back(carry + '0'); }

//     if(sign.compare("-") == 0){
//         operationResult.push_back('-');
//     }

//     reverse(operationResult.begin(), operationResult.end()); 
//     return operationResult; 
// } 

int main() 
{ 
    string number1 = "12345678", number2 = "123456789";

    string number3 = "-1234", number4 = "-123456789";
    
    string sign = "";

    if ( number4[0] == *"-" && number3[0] == *"-")
    {
        cout << performAddition(number4.substr(1), number3.substr(1), "-") << endl;
        
    } else {
        sign = "+";
        cout << performAddition(number4, number3, sign) << endl; 
    }

    // }else if( number4[0] == *"-" && number3[0] != *"-" ){

    //     if((number4.length() - 1) >  number3.length()){
    //         cout << performSubstraction(number4.substr(1), number3, "-") << endl;
    //     }else if((number4.length() - 1) < number3.length()){
    //         cout << performSubstraction(number3, number4.substr(1), "+") << endl;
    //     }else{
    //         if((number4[1] + '0') > (number3[0] + '0')){
    //             cout << performSubstraction(number4.substr(1), number3, "-") << endl;
    //         }else{
    //             cout << performSubstraction(number3, number4.substr(1), "+") << endl;
    //         }
    //     }

    // }else if( (number4[0] != *"-" && number3[0] == *"-")){

    //     if(number4.length() > ( number3.length() - 1 )){
    //         cout << performSubstraction(number4, number3.substr(1), "+") << endl;
    //     }else if(number4.length() < ( number3.length() - 1 )){
    //         cout << performSubstraction(number3.substr(1), number4, "-") << endl;
    //     }else{
    //         if((number4[0] + '0') > (number3[1] + '0')){
    //             cout << performSubstraction(number4, number3.substr(1), "+") << endl;
    //         }else{
    //             cout << performSubstraction(number3.substr(1), number4, "-") << endl;
    //         }
    //     }

    // }else{
    //     sign = "+";
    //     cout << performAddition(number4, number3, sign) << endl; 
    // }
    

    return 0; 
} 