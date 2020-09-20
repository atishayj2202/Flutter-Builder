package Index;

import BuildHelp.Component_B;
import BuildHelp.newProClass;
import com.google.firebase.database.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewPro {
    private JPanel Panel;
    private JFrame Frame;
    private String UID;
    private String UNAME;
    private int numb;
    private JTextField name;
    private JLabel ErrorM;
    private JButton button;
    public NewPro(JFrame frame, String Uid, String Name, int num){
        Frame = frame;
        this.numb = num;
        this.UNAME = Name;
        this.UID = Uid;
        Panel = Component_B.Paneleditor(Color.yellow, this.Frame, "Create a Project");
        GridBagConstraints c = Component_B.Gridsetup();
        c.gridx = 0;
        c.gridy = 0;
        JButton backbutton = Component_B.button("Back", Color.green, Color.BLUE, 20, 8);
        backbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProjectSelect(Frame, UNAME, UID, numb);
            }
        });
        Panel.add(backbutton, c);
        c.gridx = 1;
        c.gridy = 0;
        button = Component_B.button("Next", Color.green, Color.BLUE, 20, 8);
        Panel.add(button,c);
        ErrorM = new JLabel("", JLabel.CENTER);
        c.gridx = 0;
        c.gridwidth = 2;
        //Error Message
        ErrorM.setForeground(Color.RED);
        c.gridy=1;
        Panel.add(ErrorM, c);
        c.gridy = 2;
        name = Component_B.TextG("Enter Project Name");
        Panel.add(name,c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(name.getForeground() == Color.lightGray){
                    ErrorM.setText("Please Enter A Project Name");
                }
                else{
                    create_new();
                }
            }
        });
        frame.setVisible(true);
    }
    private void create_new(){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(this.UID);
        ref.child("Info").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(final DataSnapshot dataSnapshot) {
                button.setEnabled(false);
                numb = Integer.parseInt(dataSnapshot.child("Data").getValue().toString());
                numb++;
                FirebaseDatabase.getInstance().getReference(UID).child("Info").child("Data").setValue(numb, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                        FirebaseDatabase.getInstance().getReference(UID).child(String.valueOf(numb)).setValueAsync(new newProClass(name.getText()));
                        new ProContinue(Frame, numb, UID, name.getText(), numb, UNAME);
                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
