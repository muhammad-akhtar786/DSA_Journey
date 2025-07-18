import java.util.*;

public class Array2DPIL 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int Mrow_1 = 0;
        int Mcol_1 = 0;
        int Mrow_2 = 0;
        int Mcol_2 = 0;
       

        //User input 
        System.out.println("<====> User Input Matrix_1 <====>");
        System.out.print("Enter the Size of Row : ");
        Mrow_1 = sc.nextInt();
        System.out.print("Enter the size of Column : ");
        Mcol_1 = sc.nextInt();
        
        int Matrix_1[][] = new int[Mrow_1][Mcol_1];
        for(int i=0; i< Mrow_1; i++)
        {
            for(int j=0; j<Mcol_1; j++)
            {
                System.out.print("Enter Element of Matrix at index ["+i+"]["+j+"] : ");
                Matrix_1[i][j] = sc.nextInt();
            }
        }

        // User input matrix_2
        System.out.println("<====> User Input Matrix_2 <====>");
        System.out.print("Enter the Size of Row : ");
        Mrow_2 = sc.nextInt();
        System.out.print("Enter the size of Column : ");
        Mcol_2 = sc.nextInt();

        int Matrix_2[][] = new int[Mrow_2][Mcol_2];
        for (int i = 0; i < Mrow_2; i++) {
            for (int j = 0; j < Mcol_2; j++) {
                System.out.print("Enter Element of Matrix at index [" + i + "][" + j + "] : ");
                Matrix_2[i][j] = sc.nextInt();
            }
        }


        //Displaying Matrix_1

        System.out.println("\n<====> Displaying Matrix_1 <====>");
        for (int i = 0; i < Mrow_1; i++) {
            for (int j = 0; j < Mcol_1; j++) {
                System.out.print(Matrix_1[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("\n<====> Displaying Matrix_2 <====>");
        for (int i = 0; i < Mrow_2; i++) {
            for (int j = 0; j < Mcol_2; j++) {
                System.out.print(Matrix_2[i][j] + "\t");
            }
            System.out.println();
        }


        //TransPosing Matrix_1
        int transPoseMatrix_1[][] = new int[Mcol_1][Mrow_1];
        for (int i = 0; i < Mrow_1; i++) {
            for (int j = 0; j < Mcol_1; j++) {
                transPoseMatrix_1[j][i] = Matrix_1[i][j];
            }
        }



        // TransPosing Matrix_2
        int transPoseMatrix_2[][] = new int[Mcol_2][Mrow_2];
        for (int i = 0; i < Mrow_2; i++) {
            for (int j = 0; j < Mcol_2; j++) {
                transPoseMatrix_2[j][i] = Matrix_2[i][j];
            }
        }


        // Displaying Transpose Matrix_1
        System.out.println("\n<====> Displaying TransPose Matrix_1 <====>");
        for (int i = 0; i < Mcol_1; i++) {
            for (int j = 0; j < Mrow_1; j++) {
                System.out.print(transPoseMatrix_1[i][j] + "\t");
            }
            System.out.println();
        }


        //Displaying Transpose Matrix_2
        System.out.println("\n<====> Displaying TransPose Matrix_2 <====>");
        for (int i = 0; i < Mcol_2; i++) {
            for (int j = 0; j < Mrow_2; j++) {
                System.out.print(transPoseMatrix_2[i][j] + "\t");
            }
            System.out.println();
        }

        // Multiplying Matrixes 
        if(Mcol_1 == Mrow_2)
    {
        int P_Matrix[][] = new int[Mrow_1][Mcol_2];        
            for(int i=0; i<Mrow_1; i++)
            {
                for (int j = 0; j < Mcol_2; j++)
                {
                P_Matrix[i][j] = 0;
                for (int k = 0; k < Mcol_1; k++)
                {
                    P_Matrix[i][j] +=  Matrix_1[i][k] * Matrix_2[k][j];
                }
            }
        }

            // Displaying Product of Matrixes
            System.out.println("\n<====> Displaying Product Of Two Matrix <====>");
            for (int i = 0; i < Mrow_1; i++) {
                for (int j = 0; j < Mcol_2; j++) {
                    System.out.print(P_Matrix[i][j] + "\t");
                }
                System.out.println();
            }
        }
        else 
        {
            System.out.println("Both Matrix cannot be multiplied \n becuase they are implementing mulplication rules");

        }


        // Diagonal Sum of Matrix_1
        System.out.println("\n<====> Displaying Diagonal Sum of Matrix_1 <====>");
        int PDSO_Matrix_1 = 0;
        int SDSO_Matrix_1 = 0;
        if(Mrow_1 == Mcol_1)
        {
            for(int i=0; i<Mcol_1; i++)
            {
                PDSO_Matrix_1 = PDSO_Matrix_1 + Matrix_1[i][i];
                SDSO_Matrix_1 = PDSO_Matrix_1 + Matrix_1[i][Mcol_1-1-i];
            }
            
        }
       else 
       {
           System.out.println("Matrix_1 is not a square matrix.....");
       }
        // Diagonal Sum of Matrix_1
        System.out.println("\n<====> Displaying Diagonal Sum of Matrix_2 <====>");
        int PDSO_Matrix_2 = 0;
        int SDSO_Matrix_2 = 0;
        if(Mrow_2 == Mcol_2)
        {
            for(int i=0; i<Mcol_2; i++)
            {
                PDSO_Matrix_2 = PDSO_Matrix_2 + Matrix_2[i][i];
                SDSO_Matrix_2 = PDSO_Matrix_2 + Matrix_2[i][Mcol_2-1-i];
            }
            System.out.println("Sum of Primary Diagonal is " + PDSO_Matrix_2);
            System.out.println("Sum of Secondary Diagonal is " + SDSO_Matrix_2);
        }  else 
        {
            System.out.println("Matrix_1 is not a square matrix.....");
        }
         
        // To find Largest Element in 2D Matrixes
        System.out.println("\n<====> Displaying Largest Element in  Matrix_1 <====>");
        int largest = Matrix_1[0][0];
        for(int i=0; i<Mrow_1; i++)
        {
            for(int j=1; j<Mcol_1; j++)
            {
                if(Matrix_1[i][j]>largest)
                {
                    largest=Matrix_1[i][j];
                }
            }
        }
        System.out.println("Largest Number in the matrix is " + largest);


        // To find Largest Element in 2D Matrixes
        System.out.println("\n<====> Displaying Largest Element in  Matrix_2 <====>");
        largest = Matrix_2[0][0];
        for (int i = 0; i < Mrow_2; i++) {
            for (int j = 1; j < Mcol_2; j++) {
                if (Matrix_2[i][j]>largest) {
                    largest = Matrix_2[i][j];
                }  
            }
        }
        System.out.println("Largest Number in the matrix is " + largest);

        //Checking matrix identity...
        System.out.println("\n<====> Checking if Matrix_1 is Identity Matrix <====>");
        boolean isIdentity1 = true;
        if (Mrow_1 == Mcol_1) {
            for (int i = 0; i < Mrow_1; i++) {
                for (int j = 0; j < Mcol_1; j++) {
                    if (i == j && Matrix_1[i][j] != 1) {
                        isIdentity1 = false;
                    } else if (i != j && Matrix_1[i][j] != 0) {
                        isIdentity1 = false;
                    }
                }
            }
            if (isIdentity1)
                System.out.println("Matrix_1 is an Identity Matrix.");
            else
                System.out.println("Matrix_1 is NOT an Identity Matrix.");
        } else {
            System.out.println("Matrix_1 is not a square matrix.");
        }        

        System.out.println("\n<====> Checking if Matrix_2 is Identity Matrix <====>");
        boolean isIdentity2 = true;
        if (Mrow_2 == Mcol_2) {
            for (int i = 0; i < Mrow_2; i++) {
                for (int j = 0; j < Mcol_2; j++) {
                    if (i == j && Matrix_2[i][j] != 1) {
                        isIdentity2 = false;
                    } else if (i != j && Matrix_2[i][j] != 0) {
                        isIdentity2 = false;
                    }
                }
            }
            if (isIdentity2)
                System.out.println("Matrix_2 is an Identity Matrix.");
            else
                System.out.println("Matrix_2 is NOT an Identity Matrix.");
        } else {
            System.out.println("Matrix_2 is not a square matrix.");
        }        
        
       
        sc.close();
    }
    
}
