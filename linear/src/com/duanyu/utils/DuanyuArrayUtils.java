package com.duanyu.utils;

/**
 * @Description 自定义数组工具类
 * @Author 段誉 Start
 * @Date 2021-07-27 17:50
 * @Email z-houjie@qq.com / zkanan21@gmail.com
 */
public class DuanyuArrayUtils {

    /**
     * 稀疏数组转换思路：
     * <p>1.遍历数组，得到有效数组的个数sum
     * 2.根据sum就可以创建稀疏数组(sparseArray int[sum+1][3])
     * 3.将二维数组的有效数据存到稀疏数组中</>
     * 稀疏数组 -> 原始数组思路：
     * <p>1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，如上面的
     * chessArray = int[11][11]
     * 2.再读取稀疏数组后几行的数据，并赋值给原始的二维数组即可</>
     * @param args
     */

    /**
     * 原始数据转换为稀疏数组
     * @param chessArray
     * @return
     */
    public static int[][] toSparseArray(int[][] chessArray){
        //1.遍历数组，得到有效数组的个数sum
        int sum = 0;
        for (int i = 0;i < chessArray.length;i++){
            for (int j = 0;j< chessArray[0].length;j++){
                if (chessArray[i][j] != 0) sum ++;
            }
        }
        //2.根据sum就可以创建稀疏数组(sparseArray int[sum+1][3])
        int[][] sparseArray = new int[sum + 1][3];

        //3.将二维数组的有效数据存到稀疏数组中
        sparseArray[0][0] = chessArray.length;
        sparseArray[0][1] = chessArray[0].length;
        sparseArray[0][2] = sum;

        int count = 0;
        for (int i = 0;i < chessArray.length;i++){
            for (int j = 0;j< chessArray[0].length;j++){
                if (chessArray[i][j] != 0) {
                    count ++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray[i][j];
                    break;
                }
            }
        }
        return sparseArray;
    }

    /**
     * 稀疏数组转换为原始数组
     * @param sparseArray
     * @return
     */
    public static int[][] toChessArray(int[][] sparseArray){
        //1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int[][] chessArray = new int[sparseArray[0][0]][sparseArray[0][1]];

        //2.再读取稀疏数组后几行的数据，并赋值给原始的二维数组即可
        for (int i = 1;i < sparseArray.length;i ++){
            chessArray[sparseArray[i][0]][sparseArray[i][1]] =sparseArray[i][2];
        }
        return chessArray;
    }
}
