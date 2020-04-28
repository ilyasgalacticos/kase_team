import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ApplicationField extends JTextField {

    public ApplicationField(){
        setSize(260,30);
        setForeground(Color.BLACK);
        setBackground(Color.WHITE);
        setBorder(new LineBorder(Color.GRAY));
        setFont(new Font("Calibri", 1, 16));
    }

}
