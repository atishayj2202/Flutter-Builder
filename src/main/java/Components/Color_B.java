package Components;

import com.google.firebase.database.DataSnapshot;

import java.awt.*;

public class Color_B {
    public int blue;
    public int green;
    public int red;
    public Color_B(Color xy){
        blue = xy.getBlue();
        green = xy.getGreen();
        red = xy.getRed();
    }
    public Color_B(DataSnapshot Data){
        blue = Integer.parseInt(Data.child("blue").getValue().toString());
        red = Integer.parseInt(Data.child("red").getValue().toString());
        green = Integer.parseInt(Data.child("green").getValue().toString());
    }
    public Color getColor(){
        Color xy = new Color(red,green,blue);
        return xy;
    }
}
