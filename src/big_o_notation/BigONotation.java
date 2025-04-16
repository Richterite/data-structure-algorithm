package big_o_notation;

public class BigONotation {

    public static void worstCaseN(int n){
        // this is O(n)
        for (int i = 0; i < n; i++){
            System.out.println("1. index number: " + i);
        }


        // this is O(n)
        for (int j = 0; j < n; j++){
            System.out.println("2. index number: " + j);
        }

        // so the worst case is
        // n + n = 2 or O(2n)
        // we apply drop constant because the constant doesn't affect in higher value
        // the final resul is O(n)
    }

    public static void worstCaseNSquare(int n){
        // this is O(n)
        for (int i = 0; i < n;  i++ ){
            // this is O(n) and it's inside of loop
            for (int j = 0; j < n; j++){
                System.out.println(i + " " + j);
            }
        }
        // so the worst case is
        // n * n = n^2 or O(n^2)
        // if there is other loop, perform drop non-dominant.

        // this is O(n)
        for (int k = 0; k < n; k++){
            System.out.println(k);
        }

        // just look the biggest value of Big-O
        // If we add both notation together we get
        // O(n^2 + n)
        // when the n value high, the n give slightly impact (Non-dominant), compared to n^2 (Dominant)
        // so we can just drop O(n)
    }


    public static int arithmeticCase(int a, int b, int c){
        return a + b * c;
        // in this case, we perform addition and multiplication
        // for every math operation performed (+,-,*,/), it count as 1
        // so for the case above the big-o is O(2)
        // but since it's constant we can write it as one
        // therefore O(1)
    }

    public static void worstCaseLogN(){
        // this case use binary-search implementation
    }
    public static void worstCaseNLogN(){
        // this case use sorting algorithm implementation
    }


}
