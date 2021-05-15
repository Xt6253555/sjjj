package JOffice;
//51.数组中的逆序对
public class demo51 {
    public static void main(String[] args) {
        int arr[] = {7,5,6,4};
        System.out.println(reversePairs(arr));
    }
    static int[] tmp;
    public static int reversePairs(int[] nums) {
        tmp = new int[nums.length];
        return mergeSort(0, nums.length - 1,nums);
    }
    private static int mergeSort(int l, int r,int[] nums) {
        // 终止条件
        if (l >= r) return 0;
        // 递归划分
        int m = (l + r) / 2;
        int res = mergeSort(l, m,nums) + mergeSort(m + 1, r,nums);
        // 合并阶段
        int i = l, j = m + 1;
        for (int k = l; k <= r; k++)
            tmp[k] = nums[k];
        for (int k = l; k <= r; k++) {
            if (i == m + 1)
                nums[k] = tmp[j++];
            else if (j == r + 1 || tmp[i] <= tmp[j])
                nums[k] = tmp[i++];
            else {
                nums[k] = tmp[j++];
                res += m - i + 1; // 统计逆序对
            }
        }
        return res;
    }
}
