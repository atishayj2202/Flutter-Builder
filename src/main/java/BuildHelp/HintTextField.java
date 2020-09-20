package BuildHelp;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

class HintTextField extends JTextField implements FocusListener {

    private final String hint;

    public HintTextField(final String hint) {
        super(hint);
        super.setForeground(Color.lightGray);
        super.setText(hint);
        Border line = new LineBorder(Color.white, 3);
        Border empty = new EmptyBorder(4, 8, 4, 8);
        CompoundBorder border = new CompoundBorder(line, empty);
        super.setBorder(border);
        super.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));
        this.hint = hint;
        super.addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if(this.getText().equals(hint)) {
            super.setText("");
            super.setForeground(Color.white);
        }
    }
    @Override
    public void focusLost(FocusEvent e) {
        if(this.getText().equals("")) {
            super.setText(hint);
            super.setForeground(Color.lightGray);
        }
    }
}
