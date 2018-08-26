/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import static java.time.LocalDate.now;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author DAWUD
 */
public class mainController implements Initializable {
    
    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField username;    
    @FXML
    private TextField adminUser;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField adminPass;
    @FXML
    private TextField product_name;

    @FXML
    private TextField product_price;

    @FXML
    private TextField product_subcate;

    @FXML
    private TextField product_cate;

    @FXML
    private TextArea product_details;
     @FXML
    private TableView<ProductTable> productTable;

    @FXML
    private TableColumn<ProductTable, String> pId;

    @FXML
    private TableColumn<ProductTable, String> pProduct;

    @FXML
    private TableColumn<ProductTable, String> pPrice;

    @FXML
    private TableColumn<ProductTable, String> pCategory;

    @FXML
    private TableColumn<ProductTable, String> pSubcategory;

    @FXML
    private TableColumn<ProductTable, String> pDetails;

    @FXML
    private TableColumn<ProductTable, String> pDate_Added;
    
    @FXML
    private TableView<AdminTable> adminTable;
    @FXML
    private TableColumn<AdminTable, String> adId;
    @FXML
    private TableColumn<AdminTable, String> adUsername;
    @FXML
    private TableColumn<AdminTable, String> adPassword;
    @FXML
    private TableColumn<AdminTable, String> adLast_log;
    

    
    
    private Connection connection = null; 
    private ResultSet resultSet = null; 
    
   ObservableList<ProductTable> plist=  FXCollections.observableArrayList();
   ObservableList<AdminTable> alist=  FXCollections.observableArrayList();
    
    /** 
       Returns the Home page after a successful login
     */
     @FXML
    private void LoginAction(ActionEvent event) throws IOException, SQLException { 
        if(username.getText().equals("user") && password.getText().equals("pass")){
         
         pageReturn("Home.fxml"); 
       
        }else{
        System.out.println("Login failed|");
        }
    }
    
    /** 
       Displays the Home page after a successful login, withe the last set of updates
     */
     @FXML
    private void HomeAction(ActionEvent event) throws IOException { 
         
      pageReturn("Home.fxml");
    }
    
     /** 
       Returns all the products in the database into a table
     */
     @FXML
    private void AllProductsAction(ActionEvent event) throws IOException { 
         pageReturn("all_Products.fxml"); 
          try{   
            connection=DbConnect.getConnection();
            Statement statement=connection.createStatement();
          System.out.println("product DB Connect success"); 
          resultSet=statement.executeQuery("SELECT * FROM product");
            while(resultSet.next()){ 
                plist.add(new ProductTable( resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7)
                                           ));
                System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\n",
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7));
            }
      }catch(SQLException ex){} 
        System.out.println(plist);
        
            pId.setCellValueFactory(new PropertyValueFactory<>("id"));
            pProduct.setCellValueFactory(new PropertyValueFactory<>("product_name"));
            pPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
            pDetails.setCellValueFactory(new PropertyValueFactory<>("details"));
            pCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
            pSubcategory.setCellValueFactory(new PropertyValueFactory<>("subcategory"));
            pDate_Added.setCellValueFactory(new PropertyValueFactory<>("date_added")); 
            pId.setCellValueFactory(new PropertyValueFactory<>("id"));
            productTable.setItems(plist); 
         }
     /** 
       This page gives a form for the products to be inserted into the database
     */
     @FXML
    private void AddProductAction(ActionEvent event) throws IOException{ 
          pageReturn("add_Product.fxml");
       	}
    /** 
       This page gives a form for new admin (users) to be inserted into the database
     */
     @FXML
    private void AddAdminAction(ActionEvent event) throws IOException { 
       pageReturn("add_Admin.fxml");
    }
    /** 
       This page gives a form for the products to be inserted into the database
     */
     @FXML
    private void DeveloperAction(ActionEvent event) throws IOException { 
        pageReturn("developer.fxml");
        adminPopulate();
     }
    
    
    /** 
       This function returns a  page thrown as a parameter    
     */
    private void pageReturn(String fx) throws IOException{
        
        AnchorPane pane = FXMLLoader.load(getClass().getResource(fx));
         rootPane.getChildren().setAll(pane);
    }
     
   
    
    /**
     * Add an admin after clicking thae add admin button and filling the form
     * @param event
     * @throws SQLException 
     */
     @FXML
    private void AddAdmin(ActionEvent event) throws IOException,SQLException{ 
                 try{  
              String username1= adminUser.getText();
             String password1= adminPass.getText();
             LocalDate ds= now();
             
            connection=DbConnect.getConnection();
            Statement statement=connection.createStatement();
            String insert = "insert into admin " + "(username, password,last_log) " + "values ( \"" + username1 + "\", \"" + password1 + "\", \"" + ds + "\")";
            int i = statement.executeUpdate(insert);   
            if(i==1){
              System.out.println("User Added Successfully!");
            }else{
              System.out.println("User Not Added !");
            }
             
            }catch(SQLException ex){
        }finally{
            try {  
                connection.close();
            } catch (SQLException ex) {
            }
        }	
    
    }
    
    /**
     * Add a product after clicking the add product button and filling the form
     * @param event
     * @throws SQLException 
     */
     @FXML
    private void AddProduct(ActionEvent event) throws IOException,SQLException{  
                 try{  
              String product_name1= product_name.getText();
              String product_price1= product_price.getText();
              String product_cate1= product_cate.getText();
              String product_subcate1= product_subcate.getText();
              String product_details1 = product_details.getText();
              LocalDate ds= now();
             
            connection=DbConnect.getConnection();
            Statement statement=connection.createStatement();
          
        System.out.println("success");
String inser = "INSERT INTO product " + "(product_name, price,details,category,subgategory,date_added) " + 
              "VALUES ( \"" + product_name1 + "\", \"" + product_price1 + "\",\"" + product_details1 + "\",\"" +
               product_cate1 + "\",\"" + product_subcate1 + "\",\"" + ds + "\")";
         //System.out.println(inser);
            int i = statement.executeUpdate(inser);   
            if(i==1){
              System.out.println("Product added Successfully !");
            }else{
              System.out.println("Product Not Added !");
            }
             
          }catch(SQLException ex){
        }finally{
            try {  
                
                connection.close();
            } catch (SQLException ex) {
            }
        }	
    
    }
    
    
     public void adminPopulate(){
          try{   
            connection=DbConnect.getConnection();
            Statement statement=connection.createStatement();
          System.out.println("admin DB Connect success"); 
          resultSet=statement.executeQuery("SELECT * FROM admin");
            while(resultSet.next()){ 
                alist.add(new AdminTable( 
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4) 
                                           ));
                System.out.printf("%s\t%s\t%s\t%s\n",
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                         );
            }
      }catch(SQLException ex){}  
           System.out.println("am here");
            adId.setCellValueFactory(new PropertyValueFactory<>("id"));
            adUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
            adPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
            adLast_log.setCellValueFactory(new PropertyValueFactory<>("last_log"));
            //pCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
            System.out.println("and here");
            adminTable.setItems(alist);
            System.out.println("am here toooooooooooo");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            
    }    
    
}
