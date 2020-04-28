import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class UserTableModel extends AbstractTableModel {

    private ArrayList<Users> users;

    public UserTableModel(ArrayList<Users> users) {
        super();
        this.users = users;
    }

    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column){
            case 0:
                return users.get(row).getId();
            case 1:
                return users.get(row).getName();
            case 2:
                return users.get(row).getSurname();
            case 3:
                return users.get(row).getCity();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        String result = "";
        switch (columnIndex) {
            case 0:
                result = "ID";
                break;
            case 1:
                result = "NAME";
                break;
            case 2:
                result = "SURNAME";
                break;
            case 3:
                result = "CITY";
                break;
        }
        return result;
    }
}
