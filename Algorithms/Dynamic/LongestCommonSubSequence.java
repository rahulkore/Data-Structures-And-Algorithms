package Algorithms.Dynamic;

public class LongestCommonSubSequence {

    public static char X[];
    public static char Y[];
    public static int n;
    public static int m;
    public static int l[][]; // length matrix
    public static char d[][]; // direction matrix
    public static void main(String[] args) {
        String x = "ACBAACBACBAC";
        String y = "BACBBACB";
        X = x.toCharArray();
        Y = y.toCharArray();
        n = X.length;
        m = Y.length;
        l = new int[n+1][m+1];
        d = new char[n+1][m+1];
        for(int i=0;i<=n;i++){
            l[i][0] = 0;
        }
        for(int i=0;i<=m;i++){
            l[0][i] = 0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(X[i-1] == Y[j-1]){
                    l[i][j] = l[i-1][j-1] + 1;
                    d[i][j] = 'd';
                }else if(l[i-1][j] > l[i][j-1]){
                    l[i][j] = l[i-1][j];
                    d[i][j] = 'u';
                }else{
                    l[i][j] = l[i][j-1];
                    d[i][j] = 'l';
                }
            }
        }
        int i = n;
        int j = m;
        String res="";
        while(i!=0 && j!=0){
            if(d[i][j] == 'd'){
                //System.out.print(X[i-1]);
                res += X[i-1];
                i--;
                j--;
            }else if(d[i][j] == 'u'){
                i--;
            }else{
                j--;
            }
        }
        StringBuffer str = new StringBuffer(res);
        res = str.reverse().toString();
        System.out.println(res);
    }
    
}
