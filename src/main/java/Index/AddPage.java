package Index;

import BuildHelp.Component_B;
import com.google.firebase.database.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPage {
    private JFrame FRAME;
    private int gid;
    private String UID;
    private String PNAME;
    private int num;
    private String UNAME;
    private JPanel Panel;
    private JButton button;
    private JTextField name;
    private JLabel ErrorM;
    private int x;
    public AddPage(JFrame frame, int id, String xUID, String Pname, int number, String Uname){
        this.FRAME = frame;
        this.gid = id;
        this.UID = xUID;
        this.PNAME = Pname;
        this.num = number;
        this.UNAME = Uname;
        Panel = Component_B.Paneleditor(Color.yellow, this.FRAME, "Create a Page - " + PNAME);
        GridBagConstraints c = Component_B.Gridsetup();
        c.gridx = 0;
        c.gridy = 0;
        JButton backbutton = Component_B.button("Back", Color.green, Color.BLUE, 20, 8);
        backbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProContinue(FRAME, gid, UID, PNAME, num, UNAME);
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
        name = Component_B.TextG("Enter Page Name");
        Panel.add(name,c);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(name.getForeground() == Color.lightGray){
                    ErrorM.setText("Please Enter A Page Name");
                }
                else{
                    create_new();
                }
            }
        });
        frame.setVisible(true);
    }
    private void create_new(){
        name.setEnabled(false);
        FirebaseDatabase.getInstance().getReference(UID).child(String.valueOf(gid)).child("Data").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                x = Integer.parseInt(dataSnapshot.getValue().toString());
                x++;
                FirebaseDatabase.getInstance().getReference(UID).child(String.valueOf(gid)).child(String.valueOf(x)).child("Name").setValue(name.getText(), new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                        FirebaseDatabase.getInstance().getReference(UID).child(String.valueOf(gid)).child("Data").setValue(x, new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                                ErrorM.setText("Done");
                            }
                        });
                        ErrorM.setText("Done");
                    }
                });

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
