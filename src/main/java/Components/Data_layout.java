package Components;

import BuildHelp.Component_B;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Data_layout {
    public JFrame MCase;
    public JPanel Added;
    public JPanel properties;
    public Data_layout(JPanel xy){
        this.Added = rPanel();
        this.properties = rPanel();
        xy.add(rScrollPanel(Added));
        xy.add(rScrollPanel(properties));
        this.MCase = new JFrame();
        this.MCase.setTitle("Demo UI");
        this.MCase.setMinimumSize(new Dimension(400,650));
        this.MCase.setResizable(false);
        this.MCase.getContentPane().setBackground(Color.DARK_GRAY);
        this.MCase.setVisible(true);
    }
    private JScrollPane rScrollPanel(JPanel xy){
        JScrollPane abc = new JScrollPane(xy);
        abc.setBorder(new EmptyBorder(0,0,0,0));
        abc.setBackground(Color.red);
        return abc;
    }
    private JPanel rPanel(){
        JPanel Components = new JPanel();
        Components.setLayout(new BoxLayout(Components, BoxLayout.Y_AXIS));
        Components.setBorder(new EmptyBorder(0,0,0,0));
        Components.setBackground(Color.red);
        JPanel xyz = Component_B.rEmptyPanel();
        JButton Head = Component_B.buttonadd("hello", Color.BLACK, Color.blue, 15,5);
        Components.add(Head);
        return Components;
    }

}
