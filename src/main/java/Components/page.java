package Components;

import BuildHelp.Component_B;
import com.google.firebase.database.*;

import javax.swing.*;
import java.awt.*;

public class page {
    private String name;
    private int pid;
    private String uid;
    private int proid;
    private appbar topbar;
    private JPanel Panel;
    private JFrame layout;
    private DatabaseReference ref;
    private Data_layout DL;
    public page(String Uid, int projectid, int pid, Data_layout dl){
        this.DL = dl;
        this.pid = pid;
        this.uid = Uid;
        this.proid = projectid;
        ref = FirebaseDatabase.getInstance().getReference(this.uid).child(String.valueOf(proid)).child(String.valueOf(this.pid));
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                name = dataSnapshot.child("Name").getValue().toString();
                DL.Added.add(header(name));
                if(dataSnapshot.hasChild("app")){
                    topbar = new appbar(dataSnapshot.child("app"));
                }
                if(dataSnapshot.hasChild("body")){
                    System.out.println("Here");
                }
                if(dataSnapshot.hasChild("bottom")){
                    System.out.println("Here");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("Here");
            }
        });
    }
    private JPanel header(String Name){
        JPanel xyz = Component_B.rEmptyPanel();
        JButton Head = Component_B.buttonadd(Name, Color.BLACK, Color.blue, 15,5);
        xyz.add(Head);
        //JPanel headP = Component_B.rEmptyPanel();
        return xyz;
    }
    private void create_bar(){
        System.out.println("hereC");
        topbar = new appbar();
        try{
            ref.child("app").setValueAsync(topbar);
        }catch(Exception e){
            System.out.println("Error");
        }
    }
}
