package Index;

import BuildHelp.Component_B;
import Components.Data_layout;
import Components.page;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

public class PageEdit {
    JFrame Frame;
    String uid;
    String UName;
    int rid;
    int Pid;
    String PName;
    Data_layout mainLay;
    int PAGEn;
    JPanel Panel;
    public PageEdit(JFrame frame, String Uid, String Uname, int num, int pid, String Pname, int Paged){
        this.PAGEn = Paged;
        this.Frame = frame;
        this.uid = Uid;
        this.UName = Uname;
        this.rid = num;
        this.Pid = pid;
        this.PName = Pname;
        Panel = Component_B.Paneleditor(Color.WHITE,this.Frame, this.PName);
        BorderLayout layout = new BorderLayout();
        layout.setHgap(0);
        layout.setVgap(0);
        Panel.setLayout(layout);
        Frame.setSize(new Dimension(1200,600));
        Panel.add(addN(), BorderLayout.NORTH);
        Panel.add(addRow2(), BorderLayout.CENTER);
        Frame.setVisible(true);
    }
    private JPanel addRow2(){
        JPanel xy = new JPanel();
        GridLayout layout  = new GridLayout();
        layout.setRows(1);
        layout.setColumns(3);
        xy.setLayout(layout);
        xy.add(addComponents());
        mainLay = new Data_layout(xy);
        //xy.add(mainLay.Added);
        //xy.add(mainLay.properties);
        new page(this.uid, this.Pid, this.PAGEn, mainLay);
        return xy;
    }
    private JPanel addN(){
        GridBagConstraints c = Component_B.Gridsetup();
        JButton BButton = Component_B.button("< Back", Color.green,Color.white, 15, 2);
        JButton SButton = Component_B.button("Save >", Color.green,Color.white, 15, 2);
        JButton GButton = Component_B.button("Get Dart Code", Color.green,Color.white, 15, 2);
        JPanel N = new JPanel();
        N.setBackground(Color.white);
        N.setBorder(new EmptyBorder(0,0,0,0));
        N.setLayout(new GridBagLayout());
        c.gridx = 0;
        c.gridy = 0;
        BButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProContinue(Frame, Pid, uid, PName, rid, UName);
                mainLay.MCase.setVisible(false);
            }
        });
        N.add(BButton,c);
        c.gridx = 1;
        N.add(GButton, c);
        c.gridx = 2;
        N.add(SButton, c);
        return N;
    }
    private JScrollPane addComponents(){
        JPanel Components = new JPanel();
        Components.setLayout(new BoxLayout(Components, BoxLayout.Y_AXIS));
        Components.setBorder(new EmptyBorder(0,0,0,0));
        Components.setBackground(Color.white);
        JScrollPane abc = new JScrollPane(Components);
        abc.setBorder(new EmptyBorder(0,0,0,0));
        abc.setBackground(Color.white);
        Components.add(addLayout());
        Components.add(addWidgets());
        return abc;
    }
    private JPanel addLayout(){
        GridBagConstraints c = Component_B.Gridsetup();
        JPanel Components = new JPanel(new GridBagLayout());
        Components.setBorder(new EmptyBorder(0,0,0,0));
        Components.setBackground(Color.red);
        c.gridx = 0;
        JLabel head = new JLabel();
        head.setText("Layouts");
        head.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        head.setForeground(Color.blue);
        c.gridy = 0;
        Components.add(head, c);
        JButton[] layouts = new JButton[4];
        layouts[0] = Component_B.buttonadd("Row", Color.BLACK, Color.blue, 15,5);
        layouts[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getClickCount() == 2){

                }
            }
        });
        c.gridy = 1;
        Components.add(layouts[0], c);
        layouts[1] = Component_B.buttonadd("Column", Color.BLACK, Color.blue, 15,5);
        c.gridy = 2;
        Components.add(layouts[1], c);
        layouts[2] = Component_B.buttonadd("Expanded", Color.BLACK, Color.blue, 15,5);
        c.gridy = 3;
        Components.add(layouts[2], c);
        layouts[3] = Component_B.buttonadd("Padding", Color.BLACK, Color.blue, 15,5);
        c.gridy = 4;
        Components.add(layouts[3], c);
        return Components;
    }
    private JPanel addWidgets(){
        GridBagConstraints c = Component_B.Gridsetup();
        JPanel Components = new JPanel(new GridBagLayout());
        Components.setBorder(new EmptyBorder(0,0,0,0));
        Components.setBackground(Color.red);
        c.gridx = 0;
        JLabel head = new JLabel();
        head.setText("Widgets");
        head.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        head.setForeground(Color.blue);
        c.gridy = 0;
        Components.add(head, c);
        JButton[] layouts = new JButton[7];
        layouts[0] = Component_B.buttonadd("Raised Button", Color.BLACK, Color.blue, 15,5);
        c.gridy = 1;
        Components.add(layouts[0], c);
        layouts[1] = Component_B.buttonadd("Icon Button", Color.BLACK, Color.blue, 15,5);
        c.gridy = 2;
        Components.add(layouts[1], c);
        layouts[2] = Component_B.buttonadd("Text Field", Color.BLACK, Color.blue, 15,5);
        c.gridy = 3;
        Components.add(layouts[2], c);
        layouts[3] = Component_B.buttonadd("Slide Bar", Color.BLACK, Color.blue, 15,5);
        c.gridy = 4;
        Components.add(layouts[3], c);
        layouts[4] = Component_B.buttonadd("Image", Color.BLACK, Color.blue, 15,5);
        c.gridy = 5;
        Components.add(layouts[4], c);
        layouts[5] = Component_B.buttonadd("Label", Color.BLACK, Color.blue, 15,5);
        c.gridy = 6;
        Components.add(layouts[5], c);
        layouts[6] = Component_B.buttonadd("Check Box", Color.BLACK, Color.blue, 15,5);
        c.gridy = 7;
        Components.add(layouts[6], c);
        return Components;
    }
}
