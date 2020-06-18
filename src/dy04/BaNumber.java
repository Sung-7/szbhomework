package dy04;

import java.util.Scanner;

public class BaNumber {
    /*  从键盘输入8个整数存放在一个数组中
    然后将奇数和偶数分别存入两个不同的数组中，
    并按奇数，偶数交替的顺序输出这两个数组中的所有数据
    先交替输出，如果奇数个数多，则再输出剩下的奇数；如果偶数个数多，则再输出剩下的偶数。

    提示与要求：
            （1）定义一个数组存储从键盘输入的8个整数，先判断这8个整数中奇数和偶数的个数，
            才能定义存储奇数和偶数的数组的长度；
            （2）把一个大的数组分别存放在奇数和偶数数组中并交替输出的过程定义为方法

     */
    public static void main(String[] args) {

        //取数部分
        //为八个整数数组声明并分配空间
        int [] baShu = new int[8];
        //使用for循环从键盘接收输入的整数
        Scanner input=new Scanner(System.in);
        for (int i=0;i<baShu.length;i++){
            baShu[i] = input.nextInt();
        }

        //判断部分
        //声明记录数组jiOu用以接收panDuan方法的返回值
        int [] jiOu = new int [2];
        //接收以获取奇偶个数
        jiOu = panDuan(baShu);
        //分别使用j，o变量接收奇数个数，偶数个数
        int j = jiOu[0];
        int o = jiOu[1];

        //分开存储部分
        //声明jiShu，ouShu数组，并为其分配内存空间
        // 同时调用fenCun方法--将奇偶数分开存放
        int [] jiShu = fenCun(baShu,jiOu)[0];
        int [] ouShu = fenCun(baShu,jiOu)[1];
//        jiShu = fenCun(baShu,jiOu)[0];
//        ouShu = fenCun(baShu,jiOu)[1];

        //输出部分
        shuChu(jiShu,ouShu);

    }

    //输出函数--将奇偶数组交替输出
    private static void shuChu(int[] jiShu, int[] ouShu) {
        //声明max，min变量--分别保存最大数组长度，最小数组长度
        int max;
        int min;
//        int max= jiShu.length>ouShu.length?jiShu.length:ouShu.length;
//        int min= jiShu.length<ouShu.length?jiShu.length:ouShu.length;
        if (jiShu.length>ouShu.length){
            max=jiShu.length;
            min=ouShu.length;
        }else {
            max=ouShu.length;
            min=jiShu.length;
        }

        //循环输出--以‘一奇一偶’形式输出
        for (int i =0;i<min;i++){
            System.out.println(jiShu[i]);
            System.out.println(ouShu[i]);
        }
        //奇数过多
        if (jiShu.length>ouShu.length){
            for (int i=min;i<max;i++){
                System.out.println(jiShu[i]);
            }
            //偶数过多
        }else {
            for (int i=min;i<max;i++){
                System.out.println(ouShu[i]);
            }
        }
    }

    //分开存储方法--将奇偶数分别存入奇数数组，偶数数组
    private static int[] [] fenCun(int[] baShu,int [] jiOu) {
        //根据奇偶个数分别定义奇偶数组
        int [] jiShu = new int[jiOu[0]];
        int [] ouShu = new int[jiOu[1]];
        //定义变量a，b--分别作为奇偶数组的动态索引
        int a=0;
        int b=0;
        //定义一个二维数组jiAndOu--接收奇数数组和偶数数组
        int jiAndOu[][]=new int[2][];

        for (int i=0;i<baShu.length;i++){
            //从八个整数中找出偶数存入ouShu数组
            if (baShu[i]%2==0){
                ouShu[a]=baShu[i];
                a++;
                //将非偶数（奇数）存入jiShu数组
            }else {
                jiShu[b]=baShu[i];
                b++;
            }
        }

        //二维数组接收两个一维数组
        jiAndOu[0]=jiShu;
        jiAndOu[1]=ouShu;

        //将二维数组返回主调函数
        return jiAndOu;
    }

    //判断输入的八个数中分别有几个奇数，几个偶数
    private static int[] panDuan(int[] baShu) {
        //定义jiOu数组来接收奇数的个数和偶数的个数
        int [] jiOu = new int[2];
        //对八个整数数组进行遍历，使用jiOu数组来记录奇数偶数个数
        for (int i=0;i<baShu.length;i++){
            if (baShu[i]%2==0){
                jiOu[1]++;
            }else {
                jiOu[0]++;
            }
        }
        //返回记录数组jiOu
        return jiOu;
    }
}
