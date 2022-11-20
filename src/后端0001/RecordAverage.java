package 后端0001;

import java.util.Scanner;

public class RecordAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入班级数：");
        int class_num = sc.nextInt();//提示用户输入班级数并从键盘读入放置在class_num变量中
        System.out.println("请输入班级人数(用空格间隔)：");
        int[] students_num = new int[class_num];
        students_num[0] = sc.nextInt();//提示用户输入班级人数并从键盘读入后放置在students_num变量中
        int largest = students_num[0];
        for (int i = 1; i < class_num; i++) {
            students_num[i] = sc.nextInt();
            if (students_num[i] >= largest) {
                largest = students_num[i];
            }
        }//这一步是为了将用户输入的所有班级中的人数中的最大值选出作为一维数组中元素的个数
        double[] class_sum = new double[class_num];
        int students = 0;
        double grade_sum = 0, class_average = 0, grade_average = 0;
        double[][] grade = new double[class_num][largest];//以班级数作为一维数组的个数，以最大班级人数作为一维数组中元素的个数。
        for (int i = 0; i < class_num; i++) {
            System.out.println("输入第"+(i+1)+"个班级的所有人的成绩（用空格间隔开）:");
            for (int j = 0; j < students_num[i]; j++) {
                grade[i][j] = sc.nextDouble();
            }
        }//读取每个班级中所有人的成绩
        for (int i = 0; i < class_num; i++) {
            for (int j = 0; j < students_num[i]; j++) {
                class_sum[i] += grade[i][j];
            }//计算各个班级的总成绩
            class_average = class_sum[i] / students_num[i];//计算班级平均成绩
            System.out.println("第" + (i + 1) + "个班级的平均成绩:" + class_average);//计算各个班级的平均成绩，并且输出到屏幕上
        }
        for (int i = 0; i < class_num; i++) {
            grade_sum += class_sum[i];//求年级中所有班的总成绩
            students += students_num[i];//求年级中所有班级人数的总和
        }
        grade_average = grade_sum / students;//计算年级平均成绩
        System.out.println("全年级的平均成绩："+grade_average);
    }
}