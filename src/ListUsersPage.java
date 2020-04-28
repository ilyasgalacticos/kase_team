import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListUsersPage extends Container {

    private MainFrame parent;
    private JTextArea textArea;
    private ApplicationButton backButton;
    private JTable table;
    private JPanel panel;
    private JScrollPane pane;

    public ListUsersPage(MainFrame parent){

        this.parent = parent;

        setSize(600,500);
        setLayout(null);

        panel = new JPanel();
        panel.setSize(600, 380);
        panel.setLocation(0,0);
        panel.setLayout(new FlowLayout());
        add(panel);

        table = new JTable();
        table.setPreferredScrollableViewportSize(new Dimension(530, 350));
        table.setRowHeight(20);

        pane = new JScrollPane(table);
        panel.add(pane);

        textArea = new JTextArea();
        textArea.setSize(568,350);
        textArea.setLocation(10, 10);
        add(textArea);

        backButton = new ApplicationButton("BACK");
        backButton.setLocation(200,400);
        add(backButton);

        String text = "Daniyar";

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.openMainMenuPage(parent.getListUsersPage());
            }
        });

    }

    public void updateTable(ArrayList<Users> users){
        UserTableModel model = new UserTableModel(users);
        table.setModel(model);
        parent.setSize((int)parent.getSize().getWidth(), (int)parent.getSize().getHeight()+1);
        parent.setSize((int)parent.getSize().getWidth(), (int)parent.getSize().getHeight());
        repaint();
    }

}
