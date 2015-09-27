package by.home.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import by.home.clientcardclass.ClientCard;

public class DBClientCardRepository implements IClientCardrepository {

	@Override
	public void addClientCard(ClientCard cc) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost/servicestation", "root", "password1234567chimneY");
			PreparedStatement st=c.prepareStatement("INSERT INTO `servicestation`.`clientcard` (`Client_id`,`FirstName`, `LastName`, `DateofBirth`, `Adress`, `EmailAdress`, `PhoneNumber`) VALUES (?, ?, ?, ?, ?, ?, ?);");
			
			st.setInt(1,cc.getId());
			st.setString(2,cc.getName());
			st.setString(3,cc.getSurName());
			st.setString(4,cc.getDateOfBirth());
			st.setString(5,cc.getAdress());
			st.setString(6,cc.getEmail());
			st.setString(7,cc.getPhoneNumber());
			
			
			st.executeUpdate();
			st.close();
			c.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void findAllClientCards() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost/servicestation", "root", "password1234567chimneY");
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("select * from clientcard");
			while(rs.next()){
				System.out.println("client id "+ rs.getInt(1)+" name: "+rs.getString(2)+" surname: "+rs.getString(3)+" DateofBirth: "+rs.getString(4)+" Adress: "+rs.getString(5)+" EmailAdress: "+rs.getString(6)+" PhoneNumber: "+rs.getString(7));
			}
			rs.close();
			s.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
		
	}


