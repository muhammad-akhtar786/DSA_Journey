#include<iostream>
using namespace std;

class ArrayOPs
{
private:
    int* arr;
    int size;

public:
    ArrayOPs(int n)
    {
        size = n;
        arr = new int[size];
        cout<<"Enter "<< size << " Elements "<<endl;
        for (int i = 0; i < size; i++)
        {
             
            cout<<"Element at "<<i+1 <<" :";
            cin>>arr[i];
        }
        
    }

    ~ArrayOPs()
    {
       delete[] arr;
    }

    int findLargestNumber()
    {
        int largest = arr[0];
        for(int i=0; i<size; i++)
        {
              
            if(largest < arr[i])
            {
                largest = arr[i];
            }

        }
        return largest;
    }
   
    int smallestNumber()
    {
        int smallest = arr[0];
        for(int i=0; i<size; i++)
        {
            if(smallest > arr[i])
            {
                smallest = arr[i];
            }
        }
        return smallest;
    }
   
};

int main()
{
    int size;
  
    cout<<"Enter the size of Array:: ";
    cin>>size;

    ArrayOPs obj(size);

    cout<<"Largest Number is : "<<obj.findLargestNumber()<<endl;
    cout<<"Smallest Number is : "<<obj.smallestNumber();
    return 0;
    
}