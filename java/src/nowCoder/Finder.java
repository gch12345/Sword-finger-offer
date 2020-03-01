package nowCoder;

public class Finder {
    public int findKth(int[] a, int n, int K) {
        qSort(a, 0, n - 1, K);
        return a[K - 1];
    }
    private void qSort(int[] a, int left, int right, int K) {
        if (left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int base = a[left];
        while (left < right) {
            while (left < right && a[right] >= base) {
                right--;
            }
            while (left < right && a[left] <= base) {
                left++;
            }
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
        }
        int temp = a[l];
        a[l] = a[left];
        a[left] = temp;
        if (left == K - 1) {
            return;
        } else if (left > K - 1) {
            qSort(a, l, left - 1, K);
        } else {
            qSort(a, left + 1, r, K);
        }
    }

    public static void main(String[] args) {
        Finder f = new Finder();
        int[] a = {3,1,4,6,5,9,2};
        System.out.println(f.findKth(a, a.length, 7));
    }
}
