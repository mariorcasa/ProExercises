import java.util.*;

class Main {
    final static int constPrimes = (int) 10000000;
    public static void main(String... args) {
        Integer[] primes = CribaEratostenes();
        Scanner s = new Scanner(System.in);
        long n;
        while (s.hasNextLong()){
            n = s.nextLong();
            if (n==1) break;
            int res = 0;
            long auxlong = 1;
            for(int p = 0; auxlong * primes[p] * primes[p] <= n; p++){
                while(n % primes[p] == 0){
                    n /= primes[p];
                    res++;
                }
            }
            if (n != 1){
                res++;
            }
            System.out.println(res);
        }
    }

    static Integer[] CribaEratostenes() {
        Integer[] primes = new Integer[constPrimes];
        Integer[] validate = new Integer[constPrimes];
        Arrays.fill(primes, 0);
        Arrays.fill(validate, 0);
        int counter = 0;
        for (int p = 2; p < constPrimes; p++){
            if (validate[p] == 0)
                primes[counter++] = p;
            for (int i = 0; i < counter && p * primes[i] < constPrimes; i++){
                validate[p * primes[i]] = 1;
                if (p % primes[i] == 0)
                    break;
            }
        }
        return primes;
    }
}