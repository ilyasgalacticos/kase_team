import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainMenu extends Container {

    private ApplicationButton addUserPageButton;
    private ApplicationButton listUserPageButton;
    private ApplicationButton exitButton;
    private MainFrame parent;

    public MainMenu(MainFrame parent){

        this.parent = parent;

        setSize(600,500);
        setLayout(null);

        addUserPageButton = new ApplicationButton("ADD USER");
        addUserPageButton.setLocation(200,100);
        add(addUserPageButton);

        listUserPageButton = new ApplicationButton("LIST USERS");
        listUserPageButton.setLocation(200,200);
        add(listUserPageButton);

        exitButton = new ApplicationButton("EXIT");
        exitButton.setLocation(200,300);
        add(exitButton);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        addUserPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.openAddUserPage();
            }
        });

        listUserPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ArrayList<Users> allUsers = parent.getAllUsers();
                parent.getListUsersPage().updateTable(allUsers);
                parent.openListUserPage();
            }
        });

    }

}