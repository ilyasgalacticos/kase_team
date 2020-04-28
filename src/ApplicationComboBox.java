import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;
import java.util.Vector;

public class ApplicationComboBox<E> extends JComboBox{

    public ApplicationComboBox(E elements[]){
        super(elements);
        setForeground(Color.BLACK);
        setBackground(Color.WHITE);
        setBorder(new LineBorder(Color.GRAY));
        setSize(260, 30);
        setFont(new Font("Calibri", 1, 16));
    }

}
