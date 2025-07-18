import java.util.*;

public class ArrayPBL
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int row; //rows
        int col; // columns

        System.out.print("Enter the Size of rows in 2D Array : ");
        row = sc.nextInt();
        // number of rows

        System.out.print("Enter the Size of Columns in 2D Array : ");
        col = sc.nextInt();
        // Columns

        // 2D array
        int numbers[][] = new int[row][col];

        //taking input from users
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                System.out.print(" 2D array input at index : [" + i + "][" + j + "] ::");
                numbers[i][j] = sc.nextInt();
            }
        }

        // displaying 2D array data
        System.out.println("\n\n<==========-> Displaying 2D Array <-============>");
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                System.out.print(numbers[i][j]+"\t");
            }
            System.out.println("\n");
        }

        // sum of all elements
        int sum=0;
        System.out.println("\n\n<==========-> Sum of 2D Array <-============>");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sum = sum + numbers[i][j];
            }
           
        }
        System.out.println("Sum of All elements is : " + sum );


        //Row Sum
        int RowSum[]= new int[row];
        System.out.println("\n\n<==========-> Rows Sum of 2D Array <-============>");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                 RowSum[i]=RowSum[i]+numbers[i][j];
            }
            System.out.println("Sum of All elements in Row : [" + i + "] ::" + RowSum[i]);
        }
        

        // Column Wise Sum
        int ColSum[] = new int[col];
        System.out.println("\n\n<==========-> Columns Sum of 2D Array <-============>");
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                ColSum[i] = ColSum[i] + numbers[j][i];
            }
            System.out.println("Sum of All elements in Column : [" + i + "] ::" + ColSum[i]);
        }


        // Search number in matrix
        System.out.println("\n\n<==========-> Searched Element in  2D Array <-============>");
        int target;
        System.out.print("Enter the Searching Element in 2D Array : ");
        target = sc.nextInt();
        int index = -1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(target == numbers[i][j])
                {
                    index = numbers[i][j];
                    System.out.println("Searched Number is at index :: [" + i + "]["+j+"]");
                }
            }
             
        }

         
       if(index == -1)
        {
            System.out.println("Not Found....");
        }

    }

}