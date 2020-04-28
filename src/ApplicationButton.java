import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ApplicationButton extends JButton {

    public ApplicationButton(String text){
        super(text);
        setSize(200,30);
        setForeground(Color.BLACK);
        setBackground(Color.WHITE);
        setBorder(new LineBorder(Color.GRAY));
    }

}
