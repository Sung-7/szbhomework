package dy06;

import java.io.*;

public class Copy {

    public static void main(String[] args) throws Exception {

        int i=0;
        String [] str = new String[100];

        //输入流
        FileInputStream fis = new FileInputStream("a.txt");
        InputStreamReader isr =new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        //输出流
        FileOutputStream fos =new FileOutputStream("b.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        PrintWriter pw = new PrintWriter(osw,true);

        while (true) {
            str[i] = br.readLine();
            if (str[i]==null)break;
            i++;
        }

        System.out.println("读成功！");

        for (String s :str) {
            if (s==null) break;
            pw.println(s);
        }

        System.out.println("写成功！");

        br.close();
        pw.close();
    }
}
