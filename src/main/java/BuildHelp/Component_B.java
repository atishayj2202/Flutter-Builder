package BuildHelp;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Component_B {
    public Component_B(){}
    public static JPanel Paneleditor(Color color, JFrame MainF, String Title){
        JPanel Panel = new JPanel();
        Panel.setLayout(new GridBagLayout());
        Panel.setBackground(color);
        Panel.setOpaque(true);
        MainF.getContentPane().removeAll();
        MainF.repaint();
        MainF.setTitle(Title);
        MainF.add(Panel, BorderLayout.CENTER);
        return Panel;
    }
    public static JLabel HeadC(String head){
        JLabel Heading = new JLabel(head, JLabel.CENTER);
        Heading.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
        Heading.setForeground(Color.DARK_GRAY);
        return Heading;
    }
    public static GridBagConstraints Gridsetup(){
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(2, 5, 2, 5);
        c.weightx=0.5;
        c.fill = GridBagConstraints.BOTH;
        c.ipadx = 14;
        c.ipady = 12;
        return c;
    }
    public static JTextField TextG(String hint){
        HintTextField TextF;
        TextF = new HintTextField(hint);
        TextF.setMargin(new Insets(10,10,10,10));
        TextF.setBackground(Color.DARK_GRAY);
        return TextF;
    }
    public static JPasswordField PassG(String hint){
        PasswordTextField TextF;
        TextF = new PasswordTextField(hint);
        TextF.setMargin(new Insets(10,10,10,10));
        TextF.setBackground(Color.DARK_GRAY);
        return TextF;
    }
    public static JButton button(String CAPTION, Color BGColor, Color FGColor, int fi, int bi){
        JButton Button = new JButton(CAPTION);
        Border line = new LineBorder(Color.white, bi);
        Border empty = new EmptyBorder(5, 1, 5, 1);
        CompoundBorder border = new CompoundBorder(line, empty);
        Button.setBorder(border);
        Button.setBackground(BGColor);
        Button.setForeground(FGColor);
        Button.setOpaque(true);
        Button.setFont(new Font(Font.DIALOG, Font.BOLD, fi));
        return Button;
    }
    public static JButton buttonadd(String CAPTION, Color BGColor, Color FGColor, int fi, int bi){
        JButton Button = new JButton(CAPTION);
        Border line = new LineBorder(Color.blue, bi);
        Border empty = new EmptyBorder(10, 10, 10, 10);
        CompoundBorder border = new CompoundBorder(line, empty);
        Button.setBorder(border);
        Button.setBackground(BGColor);
        Button.setForeground(FGColor);
        Button.setOpaque(true);
        Button.setFont(new Font(Font.DIALOG, Font.BOLD, fi));
        return Button;
    }
    public static JButton buttonlist (String Caption){
        JButton rbutton = new JButton(Caption);
        rbutton.setForeground(Color.DARK_GRAY);
        rbutton.setBackground(Color.cyan);
        rbutton.setHorizontalAlignment(2);
        rbutton.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 17));
        Border line = new LineBorder(Color.black, 5);
        Border empty = new EmptyBorder(5, 5, 5, 5);
        rbutton.setOpaque(true);
        CompoundBorder border = new CompoundBorder(line, empty);
        rbutton.setBorder(border);
        return rbutton;
    }
    public static JPanel rEmptyPanel(){
        JPanel Panel = new JPanel();
        Panel.setBackground(Color.red);
        Panel.setLayout(new BoxLayout(Panel, BoxLayout.Y_AXIS));
        Panel.setBorder(new EmptyBorder(0,0,0,0));
        Panel.setBackground(Color.white);
        return Panel;
    }
}