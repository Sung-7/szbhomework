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
        int [] baShu = new int[8];
        Scanner input=new Scanner(System.in);
        for (int i=0;i<baShu.length;i++){
            baShu[i] = input.nextInt();
        }
        int [] jiOu = new int [2];
        jiOu = panDuan(baShu);
        int [] jiShu = new int[jiOu[0]];
        int [] ouShu = new int[jiOu[1]];

        jiShu = fenCun(baShu,jiOu)[0];
        ouShu = fenCun(baShu,jiOu)[1];

        shuChu(jiShu,ouShu);

    }

    private static void shuChu(int[] jiShu, int[] ouShu) {
        int max=0;
        int min=0;
//        int max= jiShu.length>ouShu.length?jiShu.length:ouShu.length;
//        int min= jiShu.length<ouShu.length?jiShu.length:ouShu.length;
        if (jiShu.length>ouShu.length){
            max=jiShu.length;
            min=ouShu.length;
        }else {
            max=ouShu.length;
            min=jiShu.length;
        }
        for (int i =0;i<min;i++){
            System.out.println(jiShu[i]);
            System.out.println(ouShu[i]);
        }
        if (jiShu.length>ouShu.length){
            for (int i=min;i<max;i++){
                System.out.println(jiShu[i]);
            }
        }else {
            for (int i=min;i<max;i++){
                System.out.println(ouShu[i]);
            }
        }
    }

    private static int[] [] fenCun(int[] baShu,int [] jiOu) {
        int [] jiShu = new int[jiOu[0]];
        int [] ouShu = new int[jiOu[1]];
        int a=0;
        int b=0;
        int jiAndOu[][]=new int[2][];

        for (int i=0;i<baShu.length;i++){
            if (baShu[i]%2==0){
                ouShu[a]=baShu[i];
                a++;
            }else {
                jiShu[b]=baShu[i];
                b++;
            }
        }
        jiAndOu[0]=jiShu;
        jiAndOu[1]=ouShu;
        return jiAndOu;
    }

    private static int[] panDuan(int[] baShu) {
        int [] jiOu = new int[2];
        for (int i=0;i<baShu.length;i++){
            if (baShu[i]%2==0){
                jiOu[1]++;
            }else {
                jiOu[0]++;
            }
        }
        return jiOu;
    }
}
