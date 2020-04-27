package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.LinkedList;

public class jframe implements ActionListener {
    int index;
    public int f;
    private double width=Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private double height=Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    int x=612,y=395;
    int x1= (int) ((width-x)/2);
    int y1= (int) ((height-y)/2);
    private int k = 0;
    private JLabel jLabel;
    private JComboBox jComboBox;
    private ms music;
    private JFrame jFrame;
    private JButton button1, button2;
    private Container container;
    private ImageIcon icon1, icon2, icon3,icon4;
    private String[] t;
    //    本地路径歌曲的路径
    private String path = "D:\\CloudMusic\\";
    private String gequ = "";
    private LinkedList<String> list;
    private String[] ico = {"./music/src/image/play.png", "./music/src/image/mute.png",
            "./music/src/image/beijing.jpg","./music/src/image/nigh.png"};

    jframe() {
        init1();
        init();
        lister();
    }

    private void init1() {
        list = new LinkedList<String>();
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            list.add(f.getName());
        }
        t = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            t[i] = list.get(i);
        }
        gequ=path+list.get(0);
    }

    private void lister() {
        button1.addActionListener(this);
        button2.addActionListener(this);
        jComboBox.addActionListener(this);
    }

    private void init() {
        jFrame = new JFrame("音乐");
        container = jFrame.getContentPane();
//        设置没有布局就是绝对布局
        jFrame.setLayout(null);
        //        相对路径的设置
        button1 = new JButton();
        button1.setBounds(40, 100, 50, 50);
        icon1 = new ImageIcon(ico[0]);
//根据按钮大小改变图片大小
        Image temp = icon1.getImage().getScaledInstance(button1.getWidth(), button1.getHeight(), icon1.getImage().SCALE_DEFAULT);
        icon1 = new ImageIcon(temp);
        button1.setIcon(icon1);
        button2 = new JButton();
        button2.setBounds(110, 100, 50, 50);
        icon2 = new ImageIcon(ico[1]);
//根据按钮大小改变图片大小
        Image temp2 = icon2.getImage().getScaledInstance(button2.getWidth(), button2.getHeight(), icon2.getImage().SCALE_DEFAULT);
        icon2 = new ImageIcon(temp2);
        button2.setIcon(icon2);
        jComboBox = new JComboBox(t);
        jComboBox.setBounds(x/2, 20, x/2-20, 30);
        jComboBox.setFont(new Font("微软雅黑",Font.PLAIN,15));
        jLabel = new JLabel();
        jLabel.setSize(600, 360);
        icon3 = new ImageIcon(ico[2]);
        Image temp3 = icon3.getImage().getScaledInstance(jLabel.getWidth(), jLabel.getHeight(), icon3.getImage().SCALE_DEFAULT);
        icon3 = new ImageIcon(temp3);
        jLabel.setIcon(icon3);
        button1.setContentAreaFilled(false);
        button2.setContentAreaFilled(false);
        container.add(button2);
        container.add(button1);
        container.add(jComboBox);
        container.add(jLabel);
        jFrame.setResizable(false);
        jFrame.setBounds(x1, y1, x, y);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            System.out.println();
//            判断线程是否正在运行
            if (k == 0) {
                music = new ms(gequ);
                music.start();
                k = 1;
            } else if (k == 1) {
                music.stop();
                music = new ms(gequ);
                music.start();
                k = 1;
            }
            System.out.println("开始");
        } else if (e.getSource() == button2) {
            music.stop();
            System.out.println("暂停");
            k = 0;
        } else if (e.getSource() == jComboBox) {
             index = jComboBox.getSelectedIndex();
             gequ = path + list.get(index);
        }
    }
}
