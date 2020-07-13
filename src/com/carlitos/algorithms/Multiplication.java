import java.util.ArrayList;
import java.util.Collections;

public class Multiplication {

    public static final long multiplication(int a, int b) {
        long result = ((long) a) * ((long) b);
        return result;
    }

    public static final long multiplyUsingLoop(int a, int b) {
        int absB = Math.abs(b);
        long result = a;
        for (int i = 1; i < absB; i++) {
            result += a;
        }
        return (b < 0) ? -result : result;
    }

    public static final long multiplyUsingRecursion(int a, int b) {
        int absB = Math.abs(b);
        long result = a;
        if (absB == 1)
            return result;

        result += multiplyUsingRecursion(a, absB - 1);
        return (b < 0) ? -result : result;
    }

    public static final long multiplyUsingShift(int a, int b) {
        int absA = Math.abs(a);
        int absB = Math.abs(b);

        long result = 0L;
        while (absA > 0) {
            if ((absA & 1) > 0)
                result += absB; // Is odd
            absA >>= 1;
            absB <<= 1;
        }

        return (a > 0 && b > 0 || a < 0 && b < 0) ? result : -result;
    }

    public static final long multiplyUsingLogs(int a, int b) {
        long absA = Math.abs(a);
        long absB = Math.abs(b);
        long result = Math.round(Math.pow(10, (Math.log10(absA) + Math.log10(absB))));
        return (a > 0 && b > 0 || a < 0 && b < 0) ? result : -result;
    }

    public static String multiplyUsingLoopWithStringInput(String a, String b) {
        int k,i,j,carry=0,rem,flag=0,lim1,lim2,mul;

        boolean aIsNegative = false;
        ArrayList<Integer> first = new ArrayList<Integer>();
        for (char n : a.toCharArray()){
            if (n=='-') {
                aIsNegative = true;
                continue;
            }
            first.add(n-'0');
        }

        boolean bIsNegative = false;
        ArrayList<Integer> second = new ArrayList<Integer>();
        for (char n : b.toCharArray()){
            if (n=='-') {
                bIsNegative = true;
                continue;
            }
            second.add(n-'0');
        }

        lim1=first.size()-1;
        lim2=second.size()-1;

        ArrayList<Integer> res = new ArrayList<Integer>(Collections.nCopies(first.size()+second.size(), 0));
        for (i=0;i<=lim1;i++) {
            k=i;
            for (j=0;j<=lim2;j++) {
                int f = first.get(i);
                int s = second.get(j);
                mul=f*s;
                res.set(k,res.get(k)+(mul/10));
                k++;
                res.set(k,res.get(k)+(mul%10));
            }
        }

        for (i=(lim1+lim2)+1;i>=0;i--) {
            if (flag==1){
                res.set(i,res.get(i)+carry);
                flag=0;
            }

            if (res.get(i)>=10 && i!=0) {
                rem=res.get(i)%10;
                carry=res.get(i)/10;
                res.set(i,rem);
                flag++;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (aIsNegative ^ bIsNegative)
            sb.append('-');
        boolean zeroCheck = true;
        for (Integer s : res) {
            if (zeroCheck && s.equals(0))
                continue;
            zeroCheck = false;
            sb.append(s);
        }
        return sb.toString();
    }

    public static int multiplyUsingLoopWithIntegerInput(int a, int b) {
        boolean aIsNegative = a<0;
        boolean bIsNegative = b<0;
        a = Math.abs(a);
        b = Math.abs(b);

        // Find the largest multiple of ten which is larger than 'a'
        int largerMultipleA=1;
        int numberOfDigitsInA=0;
        while (largerMultipleA<a){
            largerMultipleA *= 10;
            numberOfDigitsInA++;
        }

        // Find the largest multiple of ten which is larger than 'b'
        int largerMultipleB = 1;
        int numberOfDigitsInB=0;
        while (largerMultipleB<b){
            largerMultipleB *= 10;
            numberOfDigitsInB++;
        }

        // Store the results
        int[] res = new int[numberOfDigitsInA+numberOfDigitsInB];

        // Reduce the digits to the first digit on the left
        largerMultipleA /= 10;
        numberOfDigitsInA--;
        largerMultipleB /= 10;
        numberOfDigitsInB--;

        // Store original 'q' and 'b', to reset
        int originalMultipleB = largerMultipleB;
        int originalB = b;

        int carry=0,rem,flag=0,mul;
        for (int i=numberOfDigitsInA; i>=0; i--) {
            int k=numberOfDigitsInA-i;
            // reset
            largerMultipleB = originalMultipleB;
            b = originalB;
            for (int j=numberOfDigitsInB; j>=0; j--) {
                int f = a/largerMultipleA;
                int s = b/largerMultipleB;

                b %= largerMultipleB;
                largerMultipleB /= 10;

                mul=f*s;
                res[k] = res[k]+(mul/10);
                k++;
                res[k] = res[k]+(mul%10);
            }
            a %= largerMultipleA;
            largerMultipleA /= 10;
        }

        for (int i=(numberOfDigitsInA+numberOfDigitsInB)+1; i>=0; i--) {
            if (flag==1){
                res[i] = res[i]+carry;
                flag=0;
            }

            if (res[i] >=10 && i!=0) {
                rem = res[i]%10;
                carry = res[i] /10;
                res[i] = rem;
                flag++;
            }
        }

        int result = 0;
        int m = 1;
        for (int idx=res.length-1; idx>=0; idx--) {
            int s = res[idx];
            result += s*m;
            m *= 10;
        }
        // adjust for negatives
        if (aIsNegative ^ bIsNegative)
            result *= -1;
        return result;
    }
}