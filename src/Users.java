public class Users {

    private Long id;
    private String name;
    private String surname;
    private String city;

    public Users(){

    }

    public Users(Long id, String name, String surname, String city) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.surname + " " + this.city;
    }
}
