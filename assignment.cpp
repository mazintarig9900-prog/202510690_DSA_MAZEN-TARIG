#include <iostream>
#include <vector>

using namespace std;

int main() {
    // 1. Variable to store the chosen number
    int chosenNumber = 7;
    
    // 2. Variable to store the user's input
    int userGuess;
    
    // 3. Empty array (vector) to keep all numbers entered by the user
    vector<int> guesses;
    
    cout << "===== Number Guessing Game =====" << endl;
    cout << "Guess a number between 1 and 10" << endl << endl;
    
    // While loop that continues as long as the user's guess is not equal to the chosen number
    while (userGuess != chosenNumber) {
        cout << "Enter your guess: ";
        cin >> userGuess;
        
        // Store the value in the array/list
        guesses.push_back(userGuess);
        
        // If / else statements to compare the user's guess with the chosen number
        if (userGuess > chosenNumber) {
            cout << "Too high" << endl << endl;
        }
        else if (userGuess < chosenNumber) {
            cout << "Too low" << endl << endl;
        }
        else {
            cout << "Correct!" << endl << endl;
        }
    }
    
    // Use a for loop to display all guesses stored in the array/list
    cout << "===== All Your Guesses =====" << endl;
    cout << "Total attempts: " << guesses.size() << endl << endl;
    
    for (int i = 0; i < guesses.size(); i++) {
        cout << "Attempt " << (i + 1) << ": " << guesses[i] << endl;
    }
    
    cout << "\nCongratulations! You guessed the correct number!" << endl;
    
    return 0;
}
