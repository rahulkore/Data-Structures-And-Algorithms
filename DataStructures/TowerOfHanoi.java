package DataStructures;

public class TowerOfHanoi {

    static void tower(int n, char source, char destination, char auxillary){
        if(n==1){
            System.out.println("Move a disc from "+ source + " to " + destination);
        }else{
            tower(n-1, source, auxillary, destination);
            tower(1, source, destination, auxillary);
            tower(n-1, auxillary, destination, source);
        }
    }

    public static void main(String[] args) {

        tower(3, 'A', 'B', 'C');
        
    }
    
}
