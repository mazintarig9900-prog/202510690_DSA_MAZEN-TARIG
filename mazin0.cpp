#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
using namespace std;

int binary_search(vector<string> sorted_array, string target) {
    int left = 0;
    int right = sorted_array.size() - 1;

    while (left <= right) {
        int mid = (left + right) / 2;

        if (sorted_array[mid] == target) {
            return mid;
        }
        else if (sorted_array[mid] < target) {
            left = mid + 1;
        }
        else {
            right = mid - 1;
        }
    }

    return -1;
}

int main() {
    map<string, int> family_data;

    cout << "Enter family members:" << endl;

    string name;
    int age;

    while (true) {
        cout << "Name (or 'done'): ";
        cin >> name;

        if (name == "done") {
            break;
        }

        cout << "Age: ";
        cin >> age;

        family_data[name] = age;
    }

    vector<string> sorted_names;
    for (auto& pair : family_data) {
        sorted_names.push_back(pair.first);
    }
    sort(sorted_names.begin(), sorted_names.end());

    cout << "\nSorted Members:" << endl;
    for (string name : sorted_names) {
        cout << name << ": " << family_data[name] << endl;
    }

    cout << "\nSearch:" << endl;
    cout << "Enter name: ";
    cin >> name;

    int result = binary_search(sorted_names, name);

    if (result != -1) {
        cout << "Found: " << name << " is " << family_data[name] << " years old" << endl;
    }
    else {
        cout << "Not found" << endl;
    }

    return 0;
}
