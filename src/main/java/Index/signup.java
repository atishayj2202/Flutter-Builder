package Index;
import BuildHelp.Component_B;
import BuildHelp.UserInfo;
import com.google.firebase.auth.*;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.FirebaseDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class signup {
    private JFrame FrameUp;
    private JPanel Panel;
    private JTextField Name;
    private JTextField email;
    private JPasswordField pass;
    private JPasswordField Rpass;
    private GridBagConstraints c = Component_B.Gridsetup();
    public signup(JFrame GUI){
        FrameUp = GUI;
        Panel = Component_B.Paneleditor(Color.GRAY, FrameUp, "Sign Up to access Flutter Builder");
        addElements();
        FrameUp.setVisible(true);
    }
    private void addElements(){

        final JLabel ErrorM = new JLabel("", JLabel.CENTER);
        //Error Message
        ErrorM.setForeground(Color.RED);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        Panel.add(ErrorM,c);
        //Heading
        JLabel Heading = Component_B.HeadC("Sign Up To Use");
        c.gridx = 0;
        c.gridy = 1;
        Panel.add(Heading,c);
        //Name
        Name = Component_B.TextG("Name?");
        c.gridx = 0;
        c.gridy = 2;
        Panel.add(Name,c);
        //Email
        email = Component_B.TextG("Email ID?");
        c.gridx = 0;
        c.gridy = 3;
        Panel.add(email,c);
        //Password
        pass = Component_B.PassG("Password?");
        c.gridx = 0;
        c.gridy = 4;
        Panel.add(pass,c);
        //Retype Password
        Rpass = Component_B.PassG("Retype Password?");
        c.gridx = 0;
        c.gridy = 5;
        Panel.add(Rpass,c);
        //Signup
        JButton Signin = Component_B.button("Sign In Instead", Color.lightGray, Color.black, 15, 0);
        c.insets = new Insets(20,5,0,5);
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 1;
        Signin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new signin(FrameUp);
            }
        });
        Panel.add(Signin,c);
        //Signup
        JButton Signup = Component_B.button("Sign Up", Color.black, Color.lightGray,20, 3);
        c.gridx = 1;
        c.gridy = 6;
        c.weightx=3;
        Signup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String Rp = new String(Rpass.getPassword());
                String p = new String(pass.getPassword());
                if(Rp.equals("Retype Password?") || p.equals("Password?") || Rp.length() < 8 || p.length() < 8){
                    ErrorM.setText("Password cannot be less than 8");
                }
                else if(Name.getText().equals("Name?")){
                    ErrorM.setText("Name cannot be less than 3");
                }
                else if(email.getText().equals("Email ID?")){
                    ErrorM.setText("Email cannot be empty");
                }
                else {
                    if (Rp.equals(p)) {
                        String CR = "";
                        try {
                            UserRecord.CreateRequest request = new UserRecord.CreateRequest().setEmail(email.getText()).setPassword(p).setDisplayName(Name.getText());
                            UserRecord Record = FirebaseAuth.getInstance().createUser(request);
                            CR = Record.getUid();
                            final FirebaseDatabase database = FirebaseDatabase.getInstance();
                            database.getReference(Record.getUid()).child("Info").setValueAsync(new UserInfo(Name.getText(), email.getText(), p));
                            ErrorM.setText("Made User: " + Record.getDisplayName());
                        } catch (FirebaseAuthException b) {
                            ErrorM.setText("ID already exists");
                        } catch (DatabaseException x){
                            ErrorM.setText("Unexpected Error");
                            try{
                                FirebaseAuth.getInstance().deleteUser(CR);
                            } catch (FirebaseAuthException firebaseAuthException) {
                                System.out.println("done");
                            } {

                            }
                        } catch (Exception d) {
                            ErrorM.setText("Please Check Your Details");
                        }
                    } else {
                        ErrorM.setText("Password didn't matched, Something is Wrong");
                    }
                }
            }
        });
        Panel.add(Signup,c);
    }
}
