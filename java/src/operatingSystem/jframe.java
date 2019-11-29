package operatingSystem;
import java.awt.*;

import javax.swing.*;

public class jframe extends JFrame{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public jframe(){
        this.setTitle("test");
        Container con = this.getContentPane();
        this.setLayout(new GridLayout(10,5,5,5));        //设置7行3列垂直水平间隔为5
        con.add(new JButton("进程名"));
        con.add(new JButton("服务时间"));
        con.add(new JButton("到达时间"));
        con.add(new JButton("完成时间"));
        con.add(new JButton("周转时间"));
        for (int i = 0; i < 40; i++) {
            con.add(new JButton());
        }
        this.setVisible(true);
        this.setBounds(25, 25, 1500, 1000);
    }
    public static void main(String[] args) {
        new jframe();
    }
}