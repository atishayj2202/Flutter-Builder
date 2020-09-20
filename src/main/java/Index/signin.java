package Index;

import BuildHelp.Component_B;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.database.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signin {
    private JFrame FrameIn;
    private JPanel Panel;
    private JTextField email;
    private JPasswordField pass;
    private GridBagConstraints c = Component_B.Gridsetup();
    public signin(JFrame GUI){
        FrameIn = GUI;
        Panel = Component_B.Paneleditor(Color.GRAY, FrameIn, "Sign In to access Flutter Builder");
        addElements();
        FrameIn.setVisible(true);
    }
    private void addElements() {
        final JLabel ErrorM = new JLabel("", JLabel.CENTER);
        //Error Message
        ErrorM.setForeground(Color.RED);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        Panel.add(ErrorM, c);
        //Heading
        JLabel Heading = Component_B.HeadC("Sign In To Use");
        c.gridx = 0;
        c.gridy = 1;
        Panel.add(Heading, c);
        //Email
        email = Component_B.TextG("Email ID?");
        c.gridx = 0;
        c.gridy = 2;
        Panel.add(email,c);
        //Password
        pass = Component_B.PassG("Password?");
        c.gridx = 0;
        c.gridy = 3;
        Panel.add(pass,c);
        //Signup
        final JButton Signin = Component_B.button("Sign Up Instead", Color.lightGray, Color.black, 15, 0);
        c.insets = new Insets(20,5,0,5);
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1;
        Signin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                signup abc = new signup(FrameIn);
            }
        });
        Panel.add(Signin,c);
        //Signup
        JButton Signup = Component_B.button("Sign In", Color.black, Color.lightGray,20, 3);
        c.gridx = 1;
        c.gridy = 4;
        c.weightx=3;
        Signup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    final String p = new String(pass.getPassword());
                    if(email.getText().equals("Email ID?")){
                        ErrorM.setText("Email cannot be empty");
                    }
                    else{
                        UserRecord Record = FirebaseAuth.getInstance().getUserByEmail(email.getText());
                        System.out.println(Record.getUid());

                        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Record.getUid()).child("Info");
                        ref.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {

                                if(dataSnapshot.child("Pass").getValue().toString().equals(p)){
                                    ErrorM.setText("Welcome, " + dataSnapshot.child("Name").getValue().toString());
                                }
                                else {
                                    ErrorM.setText("Your Password is not matching");
                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {
                            }
                        });
                    }
                }catch (FirebaseAuthException y){
                    ErrorM.setText("Cannot Find Email");
                }
                catch(Exception x){
                    ErrorM.setText("Unexpected Error");
                }
            }
        });
        Panel.add(Signup,c);
    }
}
