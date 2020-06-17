package dy03;

public class HomeWork {
    public static void main(String[] args) {


        //打印等腰三角形
        //法1 -- 直接输出
//        System.out.println("    *");
//        System.out.println("   ***");
//        System.out.println("  *****");
//        System.out.println(" *******");
        //法2 -- 有点问题的方案
//        int i;
//        int j;
//        int k;
//        for (i = 1; i < 7; i++){
//            for (j = 1; j < 7 - i; j++){
//                System.out.print(" ");
//            }
//            for (k = 0;k < 2 * i - 1; k++){
//                System.out.print("*");
//            }
//            for (k = 0; k <= i; k++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }
        //不成熟的方案
//        for (i = 1; i < 8; i++) {
//            for (j = 4; j < 4+i; j++) {
//                System.out.print(" ");
//                for (k=1;k<=j/2;k++){
//                    System.out.print("*");
//                }
//            }
//            System.out.println();
//        }
        //最终方案
        for (int x = 1; x <= 5; x++) {
            //当行输出的" "数
            int kong = 5 - x;
            for (int y = kong; y > 0; y--) {
                System.out.print("  ");
            }
            int star;
            //当行输出的*数
            star = x * 2 - 1;
            for (int z = 1; z <= star; z++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("等腰三角形打印成功！");

        System.out.println("------------------------------");

        //求100以内质数的和

        //从2开始找100以内质数
        int a = 2;
        //是否为质数，初始值设为非质数
        boolean prime = false;
        //设置变量sum来接收质数的和
        int sum = 0;

        while (true){

            //每次循环都初始化变量no值为2
            int no = 2;
            while (true){

                //避免除以本身
                if (a == no){
                    //no值加1，跳过本次循环
                    no++;
                    continue;
                }

                //筛去合数
                if (a % no == 0) {
                    break;
                }

                //为质数设置结束条件，避免无限循环
                if (no == 100){
                    //将此数标明为质数
                    prime = true;
                    break;
                }
                no++;
            }

            //如果为质数，则加入sum
            if (prime){
                //输出质数
                System.out.println(a);
                sum += a;
            }

            //重置变量prime为false
            prime = false;

            //设置结束条件，避免无限循环
            if(a == 100){
                break;
            }
            a++;
        }
        //输出
        System.out.println("求得100以内质数的和是："+sum);


    }
}
