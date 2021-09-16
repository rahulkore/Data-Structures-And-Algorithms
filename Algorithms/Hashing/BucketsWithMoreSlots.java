package Algorithms.Hashing;

/**
 * In hashing , the element(key) is stored on hash table using hash key
 * Hash function is used to compute hash key of the given key
 * if two or more keys have same hash key then it is called collision
 * collision can be handled using appropriate collision handling technique
 */

public class BucketsWithMoreSlots {

    public static final int N = 11;

    /**
     * Hash function  => modulo N(N=11)
     * collision handling technique => bunckets with more slot (2D array)
     */

    static void fillHashTable(int x[], int h[][], int count[]){

        for (int ele : x) {
            int hashKey = ele % N;
            h[hashKey][count[hashKey]++] = ele;
        }

    }

    static boolean hashSearch(int x[], int h[][], int count[], int ele){

        int hashKey = ele % N;
        for(int i=0;i<count[hashKey];i++){
            if(h[hashKey][count[i]] == ele){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int count[] = new int[N];
        int h[][] = new int[N][10];
        int elements[]= {59,23,65,12,38,80,30,45,35};
        fillHashTable(elements, h, count);

        System.out.println(hashSearch(elements, h, count, 39));
    }
    
}
