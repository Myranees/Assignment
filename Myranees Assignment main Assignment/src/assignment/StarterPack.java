/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

public class StarterPack {
    public static int fib(int n) {
        if (n <= 1)
            return n;
        return fib(n-1) + fib(n-2);
    }

    public static boolean isPrime(long n) {
        if (n <= 1)
            return false;

        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

    public static String longestPalSubstr(String str) {
        int n = str.length();

        boolean table[][] = new boolean[n][n];

        int maxLength = 1;
        for (int i = 0; i < n; ++i)
            table[i][i] = true;

        int start = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        for (int k = 3; k <= n; ++k) {
            for (int i = 0; i < n - k + 1; ++i)
            {
                int j = i + k - 1;

                if (table[i + 1][j - 1] && str.charAt(i) ==
                        str.charAt(j)) {
                    table[i][j] = true;

                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        return str.substring(start, start + maxLength);
    }

    public static int sumOfDigitsFrom1ToN(int n) {
        int result = 0;

        for (int x = 1; x <= n; x++)
            result += sumOfDigits(x);

        return result;
    }

    public static int sumOfDigits(int x) {
        int sum = 0;
        while (x != 0)
        {
            sum += x % 10;
            x   = x / 10;
        }
        return sum;
    }

    public static int maxDivide(int a, int b)
    {
        while(a % b == 0)
            a = a/b;
        return a;
    }

    public static int isUgly(int no)
    {
        no = maxDivide(no, 2);
        no = maxDivide(no, 3);
        no = maxDivide(no, 5);

        return (no == 1)? 1 : 0;
    }


    public static int getNthUglyNo(int n)
    {
        int i = 1;
        int count = 1;

        while(n > count)
        {
            i++;
            if(isUgly(i) == 1)
                count++;
        }
        return i;
    }
    public static Integer executeTask(Task task){
        String methodName = task.getMethodName();
        String inputType = task.getInputType();
        String input = task.getInput();  
        
         switch (methodName) {
            case "fib":
                if (inputType.equals("int")) {
                    int n = Integer.parseInt(input);
                    return fib(n);
                }
                break;

            case "isPrime":
                if (inputType.equals("long")) {
                    long num = Long.parseLong(input);
                    return isPrime(num)?1:0;
                }
                break;

            case "longestPalSubstr":
                if (inputType.equals("String")) {
                    return longestPalSubstr(input).length();
                }
                break;

            case "sumOfDigitsFrom1ToN":
                if (inputType.equals("int")) {
                    int n = Integer.parseInt(input);
                    return sumOfDigitsFrom1ToN(n);
                }
                break;

            case "getNthUglyNo":
                if (inputType.equals("int")) {
                    int n = Integer.parseInt(input);
                    return getNthUglyNo(n);
                }
                break;

            case "sumOfDigits":
                if (inputType.equals("int")) {
                    int x = Integer.parseInt(input);
                    return sumOfDigits(x);
                }
                break;

            case "maxDivide":
                if (inputType.equals("int")) {
                    String[] inputs = input.split(" ");
                    int a = Integer.parseInt(inputs[0]);
                    int b = Integer.parseInt(inputs[1]);
                    return maxDivide(a, b);
                }
                break;

            case "isUgly":
                if (inputType.equals("int")) {
                    int no = Integer.parseInt(input);
                    return isUgly(no);
                }
                break;

            default:
                System.out.println("Unsupported method: " + methodName);
                break;
        }

        return 0;
    }
}
