public class Primes {
    public static void main(String[] args) {
        final int N = Integer.parseInt(args[0]);
        boolean[] primes = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            primes[i] = true;
        }

        int count1 = 2;
        int increment = 2;

        int count2 = 0;
        int index = 1;
        System.out.println("Prime numbers up to " + N + ":");
        while (increment <= N && increment != -1) {
            System.out.println(increment);
            while (count1 <= N) {
                if (primes[count1] == false || count1 % increment != 0 || count1 == increment) {
                } else {
                    primes[count1] = false;
                }
                count1++;
            }
            increment = nextTrue(primes, increment);
            count1 = increment;
        }

        // }

        while (index < N && index != -1) {
            index = nextTrue(primes, index);
            if (index == -1) {
                break;
            }
            count2++;
        }
        System.out.println("There are " + count2 + " primes between 2 and " + N + "(" +
                (int) (((double) count2 / N) * 100) + "% are primes)");

    }

    // gives the index of the next true value in the given boolean array
    // if there isn't one it returns a -1
    public static int nextTrue(boolean[] arr, int index) {
        if (arr[index] == true) {
            index++;
        }
        while (index < arr.length) {
            if (arr[index] == true) {
                return index;
            }
            index++;
        }
        return -1;
    }

}