package com.duanyu.demo;

import com.duanyu.utils.DuanyuArrayUtils;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Description 稀疏数组之间转换
 * @Author 段誉 Start
 * @Date 2021-07-27 15:34
 * @Email z-houjie@qq.com / zkanan21@gmail.com
 */
public class Demo01 {
    /**
     * 思路：
     * <p>1.遍历数组，得到有效数组的个数sum
     * 2.根据sum就可以创建稀疏数组(sparseArray int[sum+1][3])
     * 3.将二维数组的有效数据存到稀疏数组中</>
     * 稀疏数组 -> 原始数组思路：
     * <p>1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，如上面的
     * chessArray = int[11][11]
     * 2.再读取稀疏数组后几行的数据，并赋值给原始的二维数组即可</>
     * @param args
     */
    public static void main(String[] args) {
        int[][] fiveInARow = new int[11][11];
        fiveInARow[1][2] = 1;
        fiveInARow[2][3] = 2;
        fiveInARow[3][3] = 2;


        //将数组储存到磁盘
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(new File("array\\src\\com\\duanyu\\txt\\five-in-a-row_01.txt"));
            int[][] sparseArray = DuanyuArrayUtils.toSparseArray(fiveInARow);

            for (int i = 0; i < sparseArray.length; i++) {
                for (int j = 0; j < sparseArray[0].length; j++) {
                    fileWriter.write(sparseArray[i][j]+"\t");
                }
                fileWriter.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            if (fileWriter != null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
