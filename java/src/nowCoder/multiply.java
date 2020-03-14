package nowCoder;

public class multiply {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        int[] arr0 = new int[A.length];
        int[] arr1 = new int[A.length];
        arr0[0] = A[0];
        arr1[arr1.length - 1] = A[A.length - 1];
        for (int i = 1; i < arr0.length; i++) {
            if (A[i] == 0) {
                break;
            }
            arr0[i] = arr0[i - 1] * A[i];
        }
        for (int i = arr1.length - 2; i >= 0; i--) {
            if (A[i] == 0) {
                break;
            }
            arr1[i] = arr1[i + 1] * A[i];
        }
        for (int i = 0; i < B.length; i++) {
            if (i == 0) {
                B[i] = arr1[i + 1];
                continue;
            }
            if (i == B.length - 1) {
                B[i] = arr0[i - 1];
                continue;
            }
            B[i] = arr0[i - 1] * arr1[i + 1];
        }
        return B;
    }
}
