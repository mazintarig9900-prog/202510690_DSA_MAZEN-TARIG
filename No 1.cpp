#include <iostream>
using namespace std;

float addNumbers(float a, float b, float c, float d) {
    return a + b + c + d;
}

int main() {
    float num1, num2, num3, num4;

    cout << "Enter 4 numbers: ";
    cin >> num1 >> num2 >> num3 >> num4;

    cout << "Sum = " << addNumbers(num1, num2, num3, num4);

    return 0;
}
