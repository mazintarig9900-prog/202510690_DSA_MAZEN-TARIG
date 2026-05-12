#include <iostream>
using namespace std;

int main()
{
    long keyNumber = 999;
    int phoneNumbers[3];
    int i = 0;
    
    // Input phone numbers
    do
    {
        cout << "Enter phone number: ";
        cin >> phoneNumbers[i];
        i = i + 1;
    } while (i < 3);

    cout << "\nSearching for number: " << keyNumber << endl;
    
    // Linear search
    bool found = false;
    for (int i = 0; i < 3; i++)
    {
        if (phoneNumbers[i] == keyNumber)
        {
            cout << "Number found at position: " << i << endl;
            found = true;
            break;
        }
    }
    
    if (!found)
    {
        cout << "Number not found" << endl;
    }

    return 0;
}
