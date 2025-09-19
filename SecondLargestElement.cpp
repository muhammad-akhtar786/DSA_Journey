#include <iostream>
using namespace std;

class Array
{
private:
    int *arr;
    int size;

public:
    
    Array(int n)
    {
        size = n;
        arr = new int[size];
        cout << "=== Enter " << size << " Elements ===" << endl;
        for (int i = 0; i < size; i++)
        {
            cout << "Array[" << i + 1 << "] = ";
            cin >> arr[i];
        }
    }

    
    int SecondLargestElement()
    {
        if (size < 2)
        {
            cout << "Second Largest does not exist (array too small)." << endl;
            return -1;
        }

        int largest = arr[0];
        int secondLargest = INT_MIN;

        // Find largest and second largest
        for (int i = 1; i < size; i++)
        {
            if (arr[i] > largest)
            {
                secondLargest = largest;
                largest = arr[i];
            }
            else if (arr[i] > secondLargest && arr[i] < largest)
            {
                secondLargest = arr[i];
            }
        }

        if (secondLargest == INT_MIN)
        {
            cout << "Second Largest Number does not exist (all elements equal)." << endl;
            return -1;
        }

        return secondLargest;
    }

  
    void DisplaySecondLargest()
    {
        int result = SecondLargestElement();
        if (result != -1)
        {
            cout << "Second Largest Number in the array is :: " << result << endl;
        }
    }

     
    ~Array()
    {
        delete[] arr;
    }
};

int main()
{
    int size;
    cout << "Enter the size of Array: ";
    cin >> size;

    Array obj(size);
    obj.DisplaySecondLargest();

    return 0;
}
