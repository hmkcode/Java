public class IdentityMatrix     
{    
    public static void main(String[] args) {    
        int rows, cols;    
        boolean flag = true;    
            
        //Initialize matrix a    
        int a[][] = {       
                        {1, 0, 0},    
                        {0, 1, 0},    
                        {0, 0, 1}    
                    };    
            
        //Calculates the number of rows and columns present in the given matrix    
    
          rows = a.length;    
        cols = a[0].length;    
            
        //Checks whether given matrix is a square matrix or not    
        if(rows != cols){    
            System.out.println("Matrix should be a square matrix");    
        }    
        else {    
            //Checks if diagonal elements are equal to 1 and rest of elements are 0    
            for(int i = 0; i < rows; i++){    
                for(int j = 0; j < cols; j++){    
                  if(i == j && a[i][j] != 1){    
                      flag = false;    
                      break;    
                  }    
                  if(i != j && a[i][j] != 0){    
                      flag = false;    
                      break;    
                  }    
                }    
            }    
                
            if(flag)    
                System.out.println("Given matrix is an identity matrix");    
            else    
                System.out.println("Given matrix is not an identity matrix");    
        }    
    }    
}    
