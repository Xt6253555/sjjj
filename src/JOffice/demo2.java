package JOffice;

public class demo2 {
    public static void main(String[] args) {
        int[][] nums = new int[1][1];
        System.out.println(findNumberIn2DArray(nums,5));
    }
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(target == matrix[i][j]){
                    return true;
                }
            }
        }
        return false;
    }
}
