import java.util.*;

class Main {
    public static void main(String... args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String[]in=s.nextLine().split(" ");
            int k = Integer.parseInt(in[0]);
            long n = Long.parseLong(in[1]);
            if (k == 0 && n == 0) return;
            long res[][]=new long[k][k];
            long aux[][]=new long[k][k];
            for(int counter = 0; k > counter; counter++){
                res[counter][counter] = 1;
                aux[0][counter] = 1;
            }
            for(int counter = 1; k > counter; counter++){
                aux[counter][counter - 1] = 1;
            }
            while (n > 0){
                if (n % 2 != 0)
                    res = ar(res, aux);
                aux = ar(aux, aux);
                n = n / 2;
            }
            System.out.println(res[0][0]);
        }
    }

    static long[][] ar(long res[][], long aux[][]) {
        int size = res.length;
        long a[][]=new long[size][size];
        for(int x = 0; size > x; x++){
            for(int y = 0; size > y; y++){
                for(int z = 0; size > z; z++){
                    a[x][y] = (a[x][y] + res[x][z] * aux[z][y]) % 1000000009;
                }
            }
        }
        return a;
    }
}