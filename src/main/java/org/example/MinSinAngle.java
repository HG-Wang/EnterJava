package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class MinSinAngle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] triangleSides = new int[3];
        System.out.println("请输入三个整数（勾股数），用空格分隔：");
        for (int i = 0; i < 3; i++) {
            triangleSides[i] = scanner.nextInt();
        }
        scanner.close();

        // 检查是否为勾股数
        if (!isPythagorean(triangleSides)) {
            System.out.println("输入的数不构成勾股数。");
            return;
        }

        // 排序以确定较小的直角边和斜边
        Arrays.sort(triangleSides);
        int a = triangleSides[0];
        int c = triangleSides[2];

        // 计算最大公约数以约分
        int gcd = gcd(a, c);
        String sinValue = a / gcd + "/" + c / gcd;

        // 输出结果
        System.out.println("较小锐角的正弦值为：" + sinValue);
    }

    // 检查是否为勾股数
    private static boolean isPythagorean(int[] sides) {
        Arrays.sort(sides);
        return sides[0] * sides[0] + sides[1] * sides[1] == sides[2] * sides[2];
    }

    // 计算最大公约数
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}