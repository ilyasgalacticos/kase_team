import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUserPage extends Container {

    private MainFrame parent;
    private ApplicationField nameField;
    private ApplicationField surnameField;
    private ApplicationComboBox cityBox;

    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel cityLabel;

    private String[] cities = {"Almaty", "Astana", "Shymkent", "Karaganda"};

    private ApplicationButton backButton;
    private ApplicationButton addButton;

    public AddUserPage(MainFrame parent){

        this.parent = parent;
        setSize(600,500);
        setLayout(null);

        nameLabel = new JLabel("NAME : ");
        nameLabel.setSize(100,30);
        nameLabel.setLocation(100, 100);
        nameLabel.setFont(new Font("Calibri", 1, 16));
        add(nameLabel);

        nameField = new ApplicationField();
        nameField.setLocation(200,100);
        add(nameField);

        surnameLabel = new JLabel("SURNAME : ");
        surnameLabel.setSize(100,30);
        surnameLabel.setLocation(100, 150);
        surnameLabel.setFont(new Font("Calibri", 1, 16));
        add(surnameLabel);

        surnameField = new ApplicationField();
        surnameField.setLocation(200,150);
        add(surnameField);

        cityLabel = new JLabel("CITY : ");
        cityLabel.setSize(100,30);
        cityLabel.setLocation(100, 200);
        cityLabel.setFont(new Font("Calibri", 1, 16));
        add(cityLabel);

        cityBox = new ApplicationComboBox(cities);
        cityBox.setLocation(200,200);
        add(cityBox);

        addButton = new ApplicationButton("ADD USER");
        addButton.setLocation(200,350);
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String name = nameField.getText();
                String surname = surnameField.getText();
                String city = (String) cityBox.getSelectedItem();

                Users user = new Users(null, name, surname, city);
                parent.addUser(user);

                nameField.setText("");
                surnameField.setText("");
                cityBox.setSelectedIndex(0);

            }
        });

        backButton = new ApplicationButton("BACK");
        backButton.setLocation(200,400);
        add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.openMainMenuPage(parent.getAddUserPage());
            }
        });

    }

}
