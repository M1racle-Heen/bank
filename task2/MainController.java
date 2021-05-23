package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class MainController implements Initializable {

    @FXML
    private TextField idField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField yearField;

    @FXML
    private TextField ageField;

    @FXML
    private TextField genderField;

    @FXML
    private TextField statusField;

    @FXML
    private Button insertButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TableView<Customer> TableView;

    @FXML
    private TableColumn<Customer, Integer> idColumn;

    @FXML
    private TableColumn<Customer, String> nameColumn;

    @FXML
    private TableColumn<Customer, String> lastNameColumn;

    @FXML
    private TableColumn<Customer, Integer> addressColumn;

    @FXML
    private TableColumn<Customer, String> phoneColumn;

    @FXML
    private TableColumn<Customer, Integer> yearColumn;

    @FXML
    private TableColumn<Customer, Integer> ageColumn;

    @FXML
    private TableColumn<Customer, String> genderColumn;

    @FXML
    private TableColumn<Customer, String> statusColumn;

    @FXML
    private void insertButton() {
        String str = " " + idField.getText() + ",'" + nameField.getText() + "','" +  lastNameField.getText()
                + "'," + addressField.getText() + ",'" + phoneField.getText() + "'," + yearField.getText()
                + "," + ageField.getText() + ",'" +  genderField.getText() + "','" + statusField.getText() + "'";
        String query = "exec insert_customer " + str;
        executeQuery(query);
        showBooks();
    }


    @FXML
    private void updateButton() {
        String str = " " + idField.getText() + ",'" + nameField.getText() + "','" +  lastNameField.getText()
                + "'," + addressField.getText() + ",'" + phoneField.getText() + "'," + yearField.getText()
                + "," + ageField.getText() + ",'" +  genderField.getText() + "','" + statusField.getText() + "'";
        String query = "exec update_customer1 " + str;
        executeQuery(query);
        showBooks();
    }

    @FXML
    private void deleteButton() {
        String str = " " + idField.getText();
        String query = "exec delete_customer " + str;
        executeQuery(query);
        showBooks();
    }
    public void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showBooks();
    }

    public Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;" +  "databaseName=Assignment3;user=user123;password=password111;");
            return conn;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public ObservableList<Customer> getBooksList(){
        ObservableList<Customer> CustomerList = FXCollections.observableArrayList();
        Connection connection = getConnection();
        String query = "SELECT * FROM Customer ";
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Customer customer;
            while(rs.next()) {
                customer = new Customer(rs.getInt("CustomerId"), rs.getString("FirstName"),
                        rs.getString("LastName"), rs.getInt("AddressID"), rs.getString("Phone"),
                        rs.getInt("YearUses"), rs.getInt("Age"), rs.getString("Gender"),
                        rs.getString("Status1"));
                CustomerList.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CustomerList;
    }
    public void showBooks() {
        ObservableList<Customer> list = getBooksList();

        idColumn.setCellValueFactory(new PropertyValueFactory<Customer,Integer>("CustomerID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("FirstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("LastName"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<Customer,Integer>("AddressID"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("Phone"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<Customer,Integer>("YearOfUses"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<Customer,Integer>("Age"));
        genderColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("Gender"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("Status"));

        TableView.setItems(list);
    }

}