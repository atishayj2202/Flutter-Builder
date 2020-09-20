package Index;

import BuildHelp.Component_B;
import com.google.firebase.database.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ProjectSelect {
    private JPanel projects;
    private JFrame Frame;
    private String Uname;
    private String UID;
    private int num;
    private JPanel Panel;
    private JButton[] Buttonlist = new JButton[100];
    private String[] Pnames = new String[100];
    public ProjectSelect(JFrame frame, String UName, String UID, int num){
        this.Frame = frame;
        this.UID = UID;
        this.Uname = UName;
        this.num = num;
        Panel = Component_B.Paneleditor(Color.white, frame, "Select Project");
        BorderLayout layout = new BorderLayout();
        layout.setHgap(0);
        layout.setVgap(0);
        Panel.setLayout(layout);
        JLabel Heading = new JLabel("<html>Hello, " + this.Uname + ".<br>Please select your Project</html>");
        Heading.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
        Heading.setBorder(new EmptyBorder(5,0,0,0));
        Heading.setHorizontalAlignment(JLabel.CENTER);
        Heading.setForeground(Color.BLUE);
        Panel.add(Heading, BorderLayout.PAGE_START);
        Panel.add(addP(), BorderLayout.CENTER);
        frame.setVisible(true);
    }
    private JScrollPane addP (){
        JScrollPane abc = new JScrollPane();
        projects = new JPanel(new GridBagLayout());
        projects.setBackground(Color.white);
        projects.setBorder(new EmptyBorder(0,0,0,0));
        GridBagConstraints lays = Component_B.Gridsetup();
        lays.gridx = 0;
        JButton vu;
        int xy = 0;
        while(xy < num){
            lays.gridy = xy + 2;
            Buttonlist[xy] = Component_B.buttonlist("");
            Buttonlist[xy].setActionCommand(String.valueOf(xy));
            projects.add(Buttonlist[xy], lays);
            xy++;
        }
        vu = Component_B.buttonlist("Create New Project");
        vu.setActionCommand(String.valueOf("ADD"));
        vu.addActionListener(new ButtonClickListener());
        lays.gridy = 106;
        projects.add(vu, lays);
        abc = new JScrollPane(projects);
        abc.setBorder(new EmptyBorder(0,0,5,0));
        makeData();
        return abc;

    }
    private boolean makeData(){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(this.UID);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int x = 0;
                while(x < Integer.parseInt(dataSnapshot.child("Info").child("Data").getValue().toString())){
                    x++;
                    Pnames[(x-1)] = dataSnapshot.child(String.valueOf(x)).child("Name").getValue().toString();
                    Buttonlist[x-1].setText(Pnames[x-1]);
                    Buttonlist[x-1].addActionListener(new ButtonClickListener());
                    System.out.println(Pnames[x-1]);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return true;
    }
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand().toString();
            if(command.equals("ADD")){
                new NewPro(Frame,UID, Uname, num);
            }
            else{
                new ProContinue(Frame, Integer.parseInt(e.getActionCommand())+1, UID, Pnames[Integer.parseInt(e.getActionCommand())], num, Uname);
            }
        }
    }
}
