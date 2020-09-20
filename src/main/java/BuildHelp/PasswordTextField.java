package BuildHelp;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

class PasswordTextField extends JPasswordField implements FocusListener {

    private final String hint;

    public PasswordTextField(final String hint) {
        super(hint);
        super.setForeground(Color.lightGray);
        super.setText(hint);
        Border line = new LineBorder(Color.white, 3);
        Border empty = new EmptyBorder(4, 8, 4, 8);
        CompoundBorder border = new CompoundBorder(line, empty);
        super.setBorder(border);
        super.setFont(new Font(Font.MONOSPACED ,Font.PLAIN, 15));
        super.setEchoChar((char)0);
        this.hint = hint;
        super.addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        String pass = new String(this.getPassword());
        if(pass.equals(hint) == true) {
            super.setText("");
            super.setForeground(Color.white);
            super.setEchoChar('*');
        }
    }
    @Override
    public void focusLost(FocusEvent e) {
        String pass = new String(this.getPassword());
        if(pass.equals("")) {
            super.setEchoChar((char)0);
            super.setText(hint);
            super.setForeground(Color.lightGray);
        }
    }
}
