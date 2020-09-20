package Components;

import com.google.firebase.database.*;

import java.awt.*;

public class appbar {
    public String title;
    public Color_B backcolor;
    public Color_B forecolor;
    public appbar (DataSnapshot Data){
        this.title = Data.child("title").getValue().toString();
        this.backcolor = new Color_B(Data.child("backcolor"));
        this.forecolor = new Color_B(Data.child("forecolor"));
    }
    public appbar(){
        title = "APPBAR";
        backcolor = new Color_B(Color.BLUE);
        forecolor = new Color_B(Color.white);
    }
    //private
}
