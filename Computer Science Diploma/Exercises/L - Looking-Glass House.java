import java.util.*;

class Main{
    public static void main(String... args){
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()){
            int res = 1061109567, 
            base = 2;
            int x = Integer.parseInt(s.nextLine());
            if(x <= 2){
                res = x + 1;
            }
            else{
                while (base * base <= x) {
                    if(isPalindrome(baseConvert(x, base))){
                        res = base;
                        break;
                    }
                    int baseaux = (int) x / base -1;
                    if(baseaux > 2 && isPalindrome(baseConvert(x, baseaux))){
                        res = baseaux;
                    }
                    base += 1;
                }
                if(res == 1061109567){
                    res = x - 1;
                }
            }
            System.out.println(res);
        }
    }

    static int[] baseConvert(int n, int base) {
        LinkedList<Integer> sol = new LinkedList<Integer>();
        while(n > 1){
            sol.addFirst(n%base);
            n /= base;
        }
        if(n == 1){
            sol.addFirst(n);
        }
        int [] numbers = new int [sol.size()];
        int counter = 0;
        for (int x : sol){
            numbers[counter++] = x;
        }
        return numbers;
    }

    static boolean isPalindrome(int[] is) {
        for (int x = 0; x < is.length/2; x++) {
            if (is[x] != is[is.length-1-x]) {
                return false;
            }
        }
        return true;
    }
}