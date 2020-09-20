package Index;

import BuildHelp.Component_B;
import com.google.firebase.database.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProContinue {
    private int pid;
    private JPanel Panel;
    private JFrame Frame;
    private String UID;
    private String UNAME;
    private int UNUM;
    private JButton[] Buttonlist = new JButton[100];
    private String[] Pnames = new String[100];
    public ProContinue(JFrame frame, int id, String xUID, final String Pname, int number, String Uname){
        Frame = frame;
        this.pid = id;
        this.UNAME = Uname;
        this.UNUM = number;
        this.UID = xUID;
        Panel = Component_B.Paneleditor(Color.green, this.Frame, Pname);BorderLayout layout = new BorderLayout();
        JPanel localP = new JPanel(new GridBagLayout());
        layout.setHgap(0);
        layout.setVgap(0);
        Panel.setLayout(layout);
        GridBagConstraints c = Component_B.Gridsetup();
        JButton ButtonBack = Component_B.buttonlist("< Go Back To Select Project");
        c.gridx = 0;
        c.gridy = 0;
        ButtonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProjectSelect(Frame,UNAME, UID, UNUM);
            }
        });
        localP.add(ButtonBack, c);
        JButton ButtonAdd = Component_B.buttonlist("Add a Page");
        c.gridx = 0;
        c.gridy = 1;
        localP.add(ButtonAdd, c);
        ButtonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddPage(Frame, pid, UID, Pname, UNUM, UNAME);
            }
        });
        int x = 0;
        while( x < 100){
            Buttonlist[x] = Component_B.buttonlist("");
            Buttonlist[x].setVisible(false);
            c.gridy = x + 2;
            localP.add(Buttonlist[x], c);
            x++;
        }
        localP.setOpaque(true);
        localP.setBackground(Color.green);
        JScrollPane abc = new JScrollPane(localP);
        abc.setOpaque(true);
        abc.setBackground(Color.green);
        abc.setBorder(new EmptyBorder(0,0,0,0));
        Panel.add(abc, BorderLayout.CENTER);
        makeData();
        frame.setVisible(true);
    }
    public void makeData(){
        FirebaseDatabase.getInstance().getReference(UID).child(String.valueOf(pid)).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int x = Integer.parseInt(dataSnapshot.child("Data").getValue().toString());
                int y = 0;
                while(y < x){
                    y++;
                    Pnames[y-1] = dataSnapshot.child(String.valueOf(y)).child("Name").getValue().toString();
                    Buttonlist[y-1].setText(Pnames[y-1]);
                    Buttonlist[y-1].setVisible(true);
                    Buttonlist[y-1].setActionCommand(String.valueOf(y-1));
                    Buttonlist[y-1].addActionListener(new ButtonClickListener());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            new PageEdit(Frame, UID, UNAME, UNUM, pid, Pnames[Integer.parseInt(command)], Integer.parseInt(command));
        }
    }
}
