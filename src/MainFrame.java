import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    private MainMenu mainMenu;
    private AddUserPage addUserPage;
    private ListUsersPage listUsersPage;

    private Connection connection;

    public MainFrame(){

        connect();

        setSize(600,500);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(null);
        setResizable(true);

        mainMenu = new MainMenu(this);
        mainMenu.setLocation(0,0);
        add(mainMenu);

        addUserPage = new AddUserPage(this);
        addUserPage.setLocation(0,0);
        add(addUserPage);
        addUserPage.setVisible(false);

        listUsersPage = new ListUsersPage(this);
        listUsersPage.setLocation(0,0);
        add(listUsersPage);
        listUsersPage.setVisible(false);

    }

    public void openAddUserPage(){
        mainMenu.setVisible(false);
        addUserPage.setVisible(true);
    }

    public void openListUserPage(){
        mainMenu.setVisible(false);
        listUsersPage.setVisible(true);
    }

    public void openMainMenuPage(Container currentPage){
        currentPage.setVisible(false);
        mainMenu.setVisible(true);
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }

    public AddUserPage getAddUserPage() {
        return addUserPage;
    }

    public ListUsersPage getListUsersPage() {
        return listUsersPage;
    }

    private void connect(){
        try{

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kase_db?useUnicode=true&serverTimezone=UTC","root", "");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addUser(Users user){
        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO users (name, surname, city) " +
                    "VALUES (?, ?, ?)");

            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getCity());

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Users> getAllUsers(){

        ArrayList<Users> result = new ArrayList<>();

        try{

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users ORDER BY id ASC");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                result.add(new Users(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("city")
                ));
            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return result;

    }

}
