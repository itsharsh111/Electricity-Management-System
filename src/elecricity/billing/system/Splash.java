package elecricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Splash extends JFrame{
    Splash(){
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/splash/Splash.jpg"));//loads image
        Image imageOne = imageIcon.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);// .getImage extracts raw image from ImageIcon, other one resizes the image and uses default image scaling algorithm
        ImageIcon imageIcon2 = new ImageIcon(imageOne);
        JLabel imageLabel= new JLabel(imageIcon2);//to display
        add(imageLabel);//adds JLabel to JFrame

        setSize(600,400);//width and height of frame
        setLocation(500,200);//x-axis and y-axis to shift frame
        setVisible(true);// by default it is false, code shd be written above setVisible

        //to hold frame only for 3 seconds
        try{
            Thread.sleep(3000);
            setVisible(false);

            //jumps to login page after 3 seconds
            new Login();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Splash();
    }
}
