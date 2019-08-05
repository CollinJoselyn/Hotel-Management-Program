package application;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main extends Application {
	private static TableView<Customer> table = new TableView<Customer>();
	private static TableView<Room> table2 = new TableView<Room>();
	private static TableView<Customer> table3 = new TableView<Customer>();
	private static ObservableList<Customer> list;
	private static ObservableList<Room> list2;
	private static ObservableList<Customer> list3;
	@Override
	public void start(Stage primaryStage) {
		try {
			//main page scene setup
			
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,1200,620);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Hotel Management System");
			
			
			
			//customer page scene setup
			VBox vbox = new VBox();
			vbox.setSpacing(5);
			vbox.setPadding(new Insets(10,0,0,10));
			Text cpName = new Text();
			cpName.setFont(new Font(12));
			cpName.setText("Name");
			Text cpEmail = new Text();
			cpEmail.setFont(new Font(12));
			cpEmail.setText("Email");
			Text cpPhone = new Text();
			cpPhone.setFont(new Font(12));
			cpPhone.setText("Phone");
			Text cpAddress = new Text();
			cpAddress.setFont(new Font(12));
			cpAddress.setText("Address");
			Text cpCheckin = new Text();
			cpCheckin.setFont(new Font(12));
			cpCheckin.setText("Check-in");
			Text cpCheckout = new Text();
			cpCheckout.setFont(new Font(12));
			cpCheckout.setText("Check-out");
			Text cpRoomnum = new Text();
			cpRoomnum.setFont(new Font(12));
			cpRoomnum.setText("Room Number");
			Text cpBill = new Text();
			cpBill.setFont(new Font(12));
			cpBill.setText("Bill");
			Text cpID = new Text();
			cpID.setFont(new Font(12));
			cpID.setText("ID");
			Text custPageTitle = new Text();
			custPageTitle.setFont(new Font(30));
			custPageTitle.setUnderline(true);
			custPageTitle.setText("Update");
			TextField cpNameFd = new TextField();
			TextField cpEmailFd = new TextField();
			TextField cpPhoneFd = new TextField();
			TextField cpAddressFd = new TextField();
			TextField cpCheckinFd = new TextField();
			TextField cpCheckoutFd = new TextField();
			TextField cpRoomnumFd = new TextField();
			TextField cpBillFd = new TextField();
			TextField cpIDFd = new TextField();
			cpIDFd.setEditable(false);
			TextArea ta3 = new TextArea();
			VBox tArea3 = new VBox(ta3);
			tArea3.setPrefHeight(10);
			tArea3.setPrefWidth(5);
			ta3.setEditable(false);
			GridPane custLeftGrid = new GridPane();
			custLeftGrid.setHgap(5);
			custLeftGrid.setVgap(5);
			custLeftGrid.setPadding(new Insets(0, 0, 0, 5));
			Button backBtn = new Button("Back");
			backBtn.setMaxSize(55, 35);
			backBtn.setMinSize(55, 35);
			Button updateBtn = new Button("Update");
			updateBtn.setMaxSize(55, 35);
			updateBtn.setMinSize(55, 35);
			custLeftGrid.add(custPageTitle, 0, 0);
			custLeftGrid.add(cpName,0 ,3 );
			custLeftGrid.add(cpEmail, 0,4 );
			custLeftGrid.add(cpPhone, 0, 5);
			custLeftGrid.add(cpAddress,0 ,6 );
			custLeftGrid.add(cpCheckin, 0, 7);
			custLeftGrid.add(cpCheckout,0 , 8);
			custLeftGrid.add(cpRoomnum, 0,9 );
			custLeftGrid.add(cpBill, 0, 10);
			custLeftGrid.add(cpID, 0, 11);
			custLeftGrid.add(cpNameFd, 2, 3);
			custLeftGrid.add(cpEmailFd, 2, 4);
			custLeftGrid.add(cpPhoneFd, 2, 5);
			custLeftGrid.add(cpAddressFd,2 ,6 );
			custLeftGrid.add(cpCheckinFd, 2, 7);
			custLeftGrid.add(cpCheckoutFd, 2, 8);
			custLeftGrid.add(cpRoomnumFd,2 , 9);
			custLeftGrid.add(cpBillFd,2 , 10);
			
			custLeftGrid.add(cpIDFd, 2, 11);
			custLeftGrid.add(updateBtn, 2, 12);
			custLeftGrid.add(tArea3, 2, 13);
			custLeftGrid.add(backBtn, 2, 50);
			Main.customerAr();
			vbox.getChildren().addAll(table);
			BorderPane root2 = new BorderPane();
			root2.setLeft(custLeftGrid);
			root2.setRight(vbox);
			Scene custScene = new Scene(root2,1200,620);
			//end customer page setup
			
			//customer page table click event
		    table.setOnMouseClicked((MouseEvent event) -> {
			    if (event.getClickCount() > 1) {
			        //onEdit();
			    	// check the table's selected item and get selected item
				    if (table.getSelectionModel().getSelectedItem() != null) {
				        Customer selectedCustomer = table.getSelectionModel().getSelectedItem();
				        cpNameFd.setText(selectedCustomer.getName());
				        cpEmailFd.setText(selectedCustomer.getEmail());
				        cpPhoneFd.setText(selectedCustomer.getPhoneNumber());
				        cpAddressFd.setText(selectedCustomer.getAddress());
				        cpCheckinFd.setText(selectedCustomer.getCheckInDate());
				        cpCheckoutFd.setText(selectedCustomer.getCheckOutDate());
				        cpRoomnumFd.setText(selectedCustomer.getNumber());
				        cpBillFd.setText(selectedCustomer.getBill());
				        cpIDFd.setText(selectedCustomer.getCustID());
				    }
			    }
			});
			//end of customer page table click event
		    
		    //update button
		    updateBtn.setOnAction(e -> {
		    	String name, email, phone, address, checkin, checkout, rn, bill, id;
		    	
		    	name = cpNameFd.getText();
		    	email = cpEmailFd.getText();
		    	phone = cpPhoneFd.getText();
		    	address = cpAddressFd.getText();
		    	checkin = cpCheckinFd.getText();
		    	checkout = cpCheckoutFd.getText();
		    	rn = cpRoomnumFd.getText();
		    	bill = cpBillFd.getText();
		    	id = cpIDFd.getText();
		    	
		    	Connection conn = dbConnection();
		    	
		    	String query = "UPDATE customer SET name = ?, email = ?, phone = ?, "
		    			+ "address = ?, checkIn = ?, checkOut = ?, number = ?, bill = ? "
		    			+ "WHERE custID = ?";
		    	
		    	try {
		    		PreparedStatement preparedStmt = conn.prepareStatement(query);
		    		
		    		preparedStmt.setString(1, name);
		    		preparedStmt.setString(2, email);
		    		preparedStmt.setString(3, phone);
		    		preparedStmt.setString(4, address);
		    		preparedStmt.setString(5, checkin);
		    		preparedStmt.setString(6, checkout);
		    		preparedStmt.setString(7, rn);
		    		preparedStmt.setString(8, bill);
		    		preparedStmt.setString(9, id);
		    		
		    		preparedStmt.execute();
		    		ta3.setText("Update Successful");
		    	}catch(SQLException e3) {
		    		e3.printStackTrace();
		    		ta3.setText("Update Failed");
		    	}
		    });
		    
			//available rooms page setup
			VBox vbox2 = new VBox();
			vbox2.setSpacing(5);
			vbox2.setPadding(new Insets(10,0,0,10));
			GridPane aRoomGrid = new GridPane();
			aRoomGrid.setHgap(5);
			aRoomGrid.setVgap(5);
			aRoomGrid.setPadding(new Insets(0,0,0,5));
			Button backBtn2 = new Button("Back");
			backBtn2.setMaxSize(55, 35);
			backBtn2.setMinSize(55, 35);
			aRoomGrid.add(vbox2, 0, 0);
			aRoomGrid.add(backBtn2,0,30);
			Main.availableRooms();
			vbox2.getChildren().addAll(table2);
			BorderPane root3 = new BorderPane();
			root3.setLeft(aRoomGrid);
			//root3.setRight(vbox2);
			Scene aRoomScene = new Scene(root3,1200,620);
			//end availabe rooms page setup
			
			//check out page setup
			VBox vbox3 = new VBox();
			vbox3.setSpacing(5);
			vbox3.setPadding(new Insets(10,0,0,10));
			GridPane checkOutLeftGrid = new GridPane();
			checkOutLeftGrid.setHgap(5);
			checkOutLeftGrid.setVgap(5);
			checkOutLeftGrid.setPadding(new Insets(0, 0, 0, 5));
			Button backBtn3 = new Button("Back");
			backBtn3.setMaxSize(55, 35);
			backBtn3.setMinSize(55, 35);
			Text enterIDTxt = new Text();
			Text enterRn = new Text();
			Text checkOutTitle = new Text();
			checkOutTitle.setFont(new Font(30));
			checkOutTitle.setUnderline(true);
			checkOutTitle.setText("Check-Out");
			enterRn.setFont(new Font(12));
			enterRn.setText("Enter Room Number");
			enterIDTxt.setFont(new Font(12));
			enterIDTxt.setText("Enter Customer ID");
			TextField enterIDFd = new TextField();
			TextField enterRnFd = new TextField();
			Button checkOutBtn = new Button("Check-Out");
			checkOutBtn.setMaxSize(75, 35);
			checkOutBtn.setMinSize(75, 35);
			TextArea ta2 = new TextArea();
			VBox tArea2 = new VBox(ta2);
			tArea2.setPrefHeight(10);
			tArea2.setPrefWidth(5);
			checkOutLeftGrid.add(checkOutTitle, 1, 1);
			checkOutLeftGrid.add(enterIDTxt, 1, 3);
			checkOutLeftGrid.add(enterIDFd, 2, 3);
			checkOutLeftGrid.add(enterRn, 1, 4);
			checkOutLeftGrid.add(enterRnFd, 2, 4);
			checkOutLeftGrid.add(checkOutBtn, 2, 6);
			checkOutLeftGrid.add(tArea2, 2, 25);
			checkOutLeftGrid.add(backBtn3, 2, 50);
			Main.checkOutCustomerAr();
			vbox3.getChildren().addAll(table3);
			BorderPane root4 = new BorderPane();
			root4.setLeft(checkOutLeftGrid);
			root4.setRight(vbox3);
			Scene checkOutScene = new Scene(root4,1200,620);
			//end of check out page setup
			
			//text labels
			Text nameTxt = new Text();
			Text emailTxt = new Text();
			Text phoneTxt = new Text();
			Text addressTxt = new Text();
			Text custIDTxt = new Text();
			Text paymentTypeTxt = new Text();
			Text cardNumTxt = new Text();
			Text expDateTxt = new Text();
			Text cardTypeTxt = new Text();
			Text cardHolderTxt = new Text();
			Text securityCodeTxt = new Text();
			Text roomNumTxt = new Text();
			Text numOfBedsTxt = new Text();
			Text costTxt = new Text();
			Text checkInTxt = new Text();
			Text checkOutTxt = new Text();
			Text checkInTitle = new Text();
			checkInTitle.setUnderline(true);
			
			nameTxt.setFont(new Font(12));
			emailTxt.setFont(new Font(12));
			phoneTxt.setFont(new Font(12));
			addressTxt.setFont(new Font(12));
			custIDTxt.setFont(new Font(12));
			paymentTypeTxt.setFont(new Font(12));
			cardNumTxt.setFont(new Font(12));
			expDateTxt.setFont(new Font(12));
			cardTypeTxt.setFont(new Font(12));
			cardHolderTxt.setFont(new Font(12));
			securityCodeTxt.setFont(new Font(12));
			roomNumTxt.setFont(new Font(12));
			numOfBedsTxt.setFont(new Font(12));
			costTxt.setFont(new Font(12));
			checkInTxt.setFont(new Font(12));
			checkOutTxt.setFont(new Font(12));
			checkInTitle.setFont(new Font(30));
			
			nameTxt.setText("Name");
			emailTxt.setText("Email");
			phoneTxt.setText("Phone Number");
			addressTxt.setText("Address");
			custIDTxt.setText("Customer ID");
			paymentTypeTxt.setText("Payment Type");
			cardNumTxt.setText("Card Number");
			expDateTxt.setText("Expiration Date");
			cardTypeTxt.setText("Card Type");
			cardHolderTxt.setText("Card Holder");
			securityCodeTxt.setText("Security Code");
			roomNumTxt.setText("Room Number");
			numOfBedsTxt.setText("Number of Beds");
			costTxt.setText("Cost");
			checkInTxt.setText("Check-in Date");
			checkOutTxt.setText("Check-out Date");
			checkInTitle.setText("Check-In");
			
			//create text fields
			TextField nameFd = new TextField();
			TextField emailFd = new TextField();
			TextField phoneFd = new TextField();
			TextField addressFd = new TextField();
			TextField custIDFd = new TextField();
			TextField paymentTypeFd = new TextField();
			TextField cardNumFd = new TextField();
			TextField expDateFd = new TextField();
			TextField cardTypeFd = new TextField();
			TextField cardHolderFd = new TextField();
			TextField securityCodeFd = new TextField();
			TextField roomNumFd = new TextField();
			TextField numOfBedsFd = new TextField();
			TextField costFd = new TextField();
			TextField checkInFd = new TextField();
			TextField checkOutFd = new TextField();
			
			//create submit button
			Button submitBtn = new Button("Submit");
			submitBtn.setMaxSize(55, 35);
			submitBtn.setMinSize(55, 35);
			
			
			
			GridPane leftGrid = new GridPane();
			leftGrid.setHgap(5);
			leftGrid.setVgap(5);
			leftGrid.setPadding(new Insets(0, 0, 0, 5));
			
			TextArea ta = new TextArea();
			VBox tArea = new VBox(ta);
			tArea.setPrefSize(10, 10);
			
			//add text to leftgrid 
			leftGrid.add(nameTxt, 0, 3);
			leftGrid.add(emailTxt,0,4);
			leftGrid.add(phoneTxt,0,5);
			leftGrid.add(addressTxt,0,6);
			leftGrid.add(custIDTxt,0,7);
			leftGrid.add(paymentTypeTxt,0,8);
			leftGrid.add(cardNumTxt,0,9);
			leftGrid.add(expDateTxt,0,10);
			leftGrid.add(cardTypeTxt,0,11);
			leftGrid.add(cardHolderTxt,0,12);
			leftGrid.add(securityCodeTxt,0,13);
			leftGrid.add(roomNumTxt, 25, 3);
			leftGrid.add(costTxt, 25, 4);
			leftGrid.add(checkInTxt, 25, 5);
			leftGrid.add(checkOutTxt, 25, 6);
			leftGrid.add(checkInTitle, 30, 1);
			//add fields to leftgrid
			leftGrid.add(nameFd, 2, 3);
			leftGrid.add(emailFd, 2, 4);
			leftGrid.add(phoneFd, 2, 5);
			leftGrid.add(addressFd, 2, 6);
			leftGrid.add(custIDFd, 2, 7);
			leftGrid.add(paymentTypeFd, 2, 8);
			leftGrid.add(cardNumFd, 2, 9);
			leftGrid.add(expDateFd, 2, 10);
			leftGrid.add(cardTypeFd, 2, 11);
			leftGrid.add(cardHolderFd, 2, 12);
			leftGrid.add(securityCodeFd, 2, 13);
			leftGrid.add(roomNumFd, 30, 3);
			leftGrid.add(costFd, 30, 4);
			leftGrid.add(checkInFd, 30, 5);
			leftGrid.add(checkOutFd, 30, 6);
			leftGrid.add(submitBtn, 30, 7);
			leftGrid.add(tArea, 30, 8);
			
			//create the menu bar
			MenuBar menuBar = new MenuBar();
			Menu checkinBar = new Menu("Check-In");
			Menu customerBar = new Menu("Customers");
			Menu roomBar = new Menu("Room");
			menuBar.getMenus().addAll(checkinBar,customerBar,roomBar);
			MenuItem customerItem = new MenuItem("Show Customers");
			MenuItem roomItem = new MenuItem("Room Info");
			MenuItem checkinItem = new MenuItem("Check-in");
			MenuItem checkOutItem = new MenuItem("Check-out");
			MenuItem availableItem = new MenuItem("Available Rooms");
			
			
			
			customerBar.getItems().add(customerItem);
			roomBar.getItems().addAll(availableItem);
			checkinBar.getItems().addAll(checkinItem, checkOutItem);
			customerItem.setOnAction(e -> primaryStage.setScene(custScene));
			availableItem.setOnAction(e -> primaryStage.setScene(aRoomScene));
			
			//Submit button
			submitBtn.setOnAction(e -> {
				String name, email, phone, address, id, payType, cardNum, exDate;
				String cardType, cardHolder, sCode, roomNum, numBeds, cost, cIn, cOut;
				String inStatus = "in";
				
				name = nameFd.getText();
				email = emailFd.getText();
				phone = phoneFd.getText();
				address = addressFd.getText();
				id = custIDFd.getText();
				payType = paymentTypeFd.getText();
				cardNum = cardNumFd.getText();
				exDate = expDateFd.getText();
				cardType = cardTypeFd.getText();
				cardHolder = cardHolderFd.getText();
				sCode = securityCodeFd.getText();
				roomNum = roomNumFd.getText();
				numBeds = numOfBedsFd.getText();
				cost = costFd.getText();
				cIn = checkInFd.getText();
				cOut = checkOutFd.getText();
				
				if(name != "" || email != "" || phone != "" || address != "" || payType != ""
						|| cardNum != "" || exDate != "" || cardType != "" || cardHolder != ""
						|| sCode != "" || cIn != "" || cOut != "") {
				Connection conn = dbConnection();
				
				String query = "INSERT INTO customer (name, email, phone, address, checkIn, checkOut, number, bill, status)" +
				" values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				String query2 = "INSERT INTO credit (cardNumber, expDate, cardType, holder, securityCode)" +
				" values (?, ?, ?, ?, ?)";
				//String query3 = "INSERT INTO room (number, beds, cost)" + 
				//" values (?, ?, ?)";
				try {
					PreparedStatement preparedStmt = conn.prepareStatement(query);
					PreparedStatement preparedStmt2 = conn.prepareStatement(query2);
					//PreparedStatement preparedStmt3 = conn.prepareStatement(query3);
					
					preparedStmt.setString(1, name);
					preparedStmt.setString(2, email);
					preparedStmt.setString(3, phone);
					preparedStmt.setString(4, address);
					preparedStmt.setString(5, cIn);
					preparedStmt.setString(6, cOut);
					preparedStmt.setString(7, roomNum);
					preparedStmt.setString(8, cost);
					preparedStmt.setString(9, inStatus);
					
					preparedStmt2.setString(1, cardNum);
					preparedStmt2.setString(2, exDate);
					preparedStmt2.setString(3, cardType);
					preparedStmt2.setString(4, cardHolder);
					preparedStmt2.setString(5, sCode);
					
					//preparedStmt3.setString(1, roomNum);
					//preparedStmt3.setString(2, numBeds);
					//preparedStmt3.setString(3, cost);
					
					preparedStmt.execute();
					preparedStmt2.execute();
					//preparedStmt3.execute();
					ta.setText("Successfully added!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					ta.setText("Error, please fill all fields");
				}
				}else {
					ta.setText("Error, please fill all fields");
				}
				
			});
			
			//Check out button
			checkOutBtn.setOnAction(e -> {
				String id, rn;
				
				id = enterIDFd.getText();
				rn = enterRnFd.getText();
				
				Connection conn = dbConnection();
				
				String query = "UPDATE customer SET status = 'out' WHERE custID = ?";
				String query2 = "UPDATE room SET available = 'yes' WHERE number = ?";
				
				try {
					PreparedStatement preparedStmt = conn.prepareStatement(query);
					PreparedStatement preparedStmt2 = conn.prepareStatement(query2);
					
					preparedStmt.setString(1, id);
					preparedStmt2.setString(1, rn);
					
					preparedStmt.execute();
					preparedStmt2.execute();
					
					ta2.setText("Check out successful");
				}catch(SQLException e2) {
					e2.printStackTrace();
					ta2.setText("Check out failed");
				}
				
			});
			
			
			
			
			
			
			//Program Layout
			BorderPane primaryPane = new BorderPane();
			primaryPane.setLeft(leftGrid);
			primaryPane.setTop(menuBar);
			Scene leftScene = new Scene(primaryPane,1200,620);
			primaryStage.setScene(leftScene);
			
			backBtn.setOnAction(e -> primaryStage.setScene(leftScene));
			backBtn2.setOnAction(e -> primaryStage.setScene(leftScene));
			checkOutItem.setOnAction(e -> primaryStage.setScene(checkOutScene));
			backBtn3.setOnAction(e -> primaryStage.setScene(leftScene));
			checkinItem.setOnAction(e -> primaryStage.setScene(leftScene));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//method that connects to the database
	public static Connection dbConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost/hotel", "root", "");
			System.out.println("Database is connected!");
			//conn.close();
			Statement s = conn.createStatement();
			ResultSet rs = null;
			rs = s.executeQuery("SELECT * FROM customer");
			/*while(rs.next()) {
				displayNameRow(rs);
			}*/
			//rs.close();
		}catch(Exception e) {
			System.out.print("Do not connect to DB - Error:"+e);
		}
		return conn;
	}
	
	//method that displays basic customer information
	public static void displayNameRow(ResultSet rs) throws SQLException{
		String name = rs.getString("name");
		String email = rs.getString("email");
		String phone = rs.getString("phone");
		String address = rs.getString("address");
		String id = rs.getString("custID");
		String cIn = rs.getString("checkIn");
		String cOut = rs.getString("checkOut");
		System.out.println("name = " + name + " email = " + email + " Phone = " + phone
				+ " address = " + address + " ID = " + id + " check-in = " + cIn 
				+ " check-out = " + cOut);
	}
	
	//
	public static int tc() {
		Connection conn = dbConnection();
		PreparedStatement ps;
		int total = 0;
		try {
			ps = conn.prepareStatement("SELECT COUNT(name) as number FROM customer");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				total = rs.getInt("number");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}
	
	//This method pulls all the customer information from the database
	//and displays it. 
	public static void customerAr() {
		Connection conn = dbConnection();
		//list = FXCollections.observableArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM customer");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String id = rs.getString("custID");
				String cIn = rs.getString("checkIn");
				String cOut = rs.getString("checkOut");
				String number = rs.getString("number");
				String bill = rs.getString("bill");
				String status = rs.getString("status");
				ObservableList<Customer> row = FXCollections.observableArrayList();
				for(int i = 0; i <= rs.getMetaData().getColumnCount(); i++) {
					//row.add(rs.getString(i));
					list = FXCollections.observableArrayList( new Customer(name, address, email, phone, id, cIn, cOut, number, bill, status));
				}
				
				
				table.getItems().addAll(list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TableColumn<Customer, String> nameCol = new TableColumn("Name");
		nameCol.setMinWidth(100);
		nameCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("name"));
		TableColumn<Customer, String> emailCol = new TableColumn("Email");
		nameCol.setMinWidth(100);
		emailCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("email"));
		TableColumn<Customer, String> phoneCol = new TableColumn("Phone");
		phoneCol.setMinWidth(100);
		phoneCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("phoneNumber"));
		TableColumn<Customer, String> addressCol = new TableColumn("Address");
		addressCol.setMinWidth(100);
		addressCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("address"));
		TableColumn<Customer, String> idCol = new TableColumn("ID");
		idCol.setMinWidth(30);
		idCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("custID"));
		TableColumn<Customer, String> checkinCol = new TableColumn("Check-in");
		checkinCol.setMinWidth(100);
		checkinCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("checkInDate"));
		TableColumn<Customer, String> checkoutCol = new TableColumn("Check-out");
		checkoutCol.setMinWidth(100);
		checkoutCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("checkOutDate"));
		TableColumn<Customer, String> numberCol = new TableColumn("Room Number");
		numberCol.setMinWidth(100);
		numberCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("number"));
		TableColumn<Customer, String> billCol = new TableColumn("Bill");
		billCol.setMinWidth(100);
		billCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("bill"));
		TableColumn<Customer, String> statusCol = new TableColumn("Status");
		statusCol.setMinWidth(100);
		statusCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("status"));
		
		table.getColumns().addAll(nameCol,emailCol,phoneCol,addressCol,idCol,checkinCol,checkoutCol,numberCol,billCol,statusCol);
		
		
	}
	
	//This method finds all available rooms from the database and displays its information. 
	public static void availableRooms() {
		Connection conn = dbConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT number, beds, cost FROM room WHERE available = 'yes'");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String number = rs.getString("number");
				String cost = rs.getString("cost");
				String beds = rs.getString("beds");
				ObservableList<Room> row = FXCollections.observableArrayList();
				for(int i = 0; i <= rs.getMetaData().getColumnCount(); i++) {
					//row.add(rs.getString(i));
					list2 = FXCollections.observableArrayList( new Room(number,beds,cost));
				}
				
				
				table2.getItems().addAll(list2);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		TableColumn<Room, String> roomCol = new TableColumn("Room Number");
		roomCol.setMinWidth(100);
		roomCol.setCellValueFactory(new PropertyValueFactory<Room, String>("roomNumber"));
		TableColumn<Room, String> costCol = new TableColumn("Cost");
		costCol.setMinWidth(100);
		costCol.setCellValueFactory(new PropertyValueFactory<Room, String>("cost"));
		TableColumn<Room, String> bedCol = new TableColumn("Beds");
		bedCol.setMinWidth(100);
		bedCol.setCellValueFactory(new PropertyValueFactory<Room, String>("numOfBeds"));
		
		table2.getColumns().addAll(roomCol, costCol, bedCol);
		
	}
	
	//method that checks out a customer 
	public static void checkOutCustomerAr() {
		Connection conn = dbConnection();
		//list = FXCollections.observableArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM customer");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String id = rs.getString("custID");
				String cIn = rs.getString("checkIn");
				String cOut = rs.getString("checkOut");
				String number = rs.getString("number");
				String bill = rs.getString("bill");
				String status = rs.getString("status");
				ObservableList<Customer> row = FXCollections.observableArrayList();
				for(int i = 0; i <= rs.getMetaData().getColumnCount(); i++) {
					//row.add(rs.getString(i));
					list3 = FXCollections.observableArrayList( new Customer(name, address, email, phone, id, cIn, cOut, number, bill, status));
				}
				
				
				table3.getItems().addAll(list3);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TableColumn<Customer, String> nameCol = new TableColumn("Name");
		nameCol.setMinWidth(100);
		nameCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("name"));
		TableColumn<Customer, String> emailCol = new TableColumn("Email");
		nameCol.setMinWidth(100);
		emailCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("email"));
		TableColumn<Customer, String> phoneCol = new TableColumn("Phone");
		phoneCol.setMinWidth(100);
		phoneCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("phoneNumber"));
		TableColumn<Customer, String> addressCol = new TableColumn("Address");
		addressCol.setMinWidth(100);
		addressCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("address"));
		TableColumn<Customer, String> idCol = new TableColumn("ID");
		idCol.setMinWidth(30);
		idCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("custID"));
		TableColumn<Customer, String> checkinCol = new TableColumn("Check-in");
		checkinCol.setMinWidth(100);
		checkinCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("checkInDate"));
		TableColumn<Customer, String> checkoutCol = new TableColumn("Check-out");
		checkoutCol.setMinWidth(100);
		checkoutCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("checkOutDate"));
		TableColumn<Customer, String> numberCol = new TableColumn("Room Number");
		numberCol.setMinWidth(100);
		numberCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("number"));
		TableColumn<Customer, String> billCol = new TableColumn("Bill");
		billCol.setMinWidth(100);
		billCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("bill"));
		TableColumn<Customer, String> statusCol = new TableColumn("Status");
		statusCol.setMinWidth(100);
		statusCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("status"));
		
		table3.getColumns().addAll(nameCol,emailCol,phoneCol,addressCol,idCol,checkinCol,checkoutCol,numberCol,billCol,statusCol);
		
		
	}
	
	public static void main(String[] args) {
		Main.dbConnection();
		launch(args);
	}
}
