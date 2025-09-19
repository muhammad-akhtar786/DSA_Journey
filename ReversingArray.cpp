#include<iostream>
using namespace std;

class Array
{
private:

    int* arr;
    int size;
public:
    Array(int n)
    {
        size =n;
        arr = new int[size];
        cout<<"---Enter "<<size <<" Elements for reversing Array---"<<endl;
        for(int i=0; i<size; i++)
        {
            cout<<"Element at "<<i+1<<" : ";
            cin>>arr[i]; 

        }
    }

    void reversingArray()
    { 
        int start = 0;
        int end = size -1;
        int temp;
        while(start < end)
        {
            for(int i=0; i<size; i++)
            {
                temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

       
        
    }

    void display()
    {
        for (int i = 0; i < size; i++)
        {
            cout << arr[i];
        }
    }


};

int main()
{
    int size;
    cout<<"Enter the size of Array:: ";
    cin>>size;

    Array obj(size);
    obj.reversingArray();
    obj.display();
    return 0;
}