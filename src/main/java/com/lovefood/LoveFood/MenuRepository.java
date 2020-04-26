package com.lovefood.LoveFood;

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;

public class MenuRepository implements IMenuItemRepository{
      public static void main(String args[]) {
    	  
      }

        public MenuItem getMenuItems(int id) {

            MenuItem item = null;
        	
            try {
                String query = "select * from menu_items.food_items where ItemID = " + id;
                Class.forName("com.mysql.cj.jdbc.Driver");
                String connectionString = "jdbc:mysql://localhost:3306/menu_items";
                Connection dbConnection = DriverManager.getConnection(connectionString, "root", "");
                Statement statement = dbConnection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                if(resultSet.next()) {
                    item = createmenuItemObject(resultSet);
                }
                dbConnection.close();
            }
            catch (SQLException | ClassNotFoundException e )
            {
                e.printStackTrace();
            }
            return item;
        }

    private MenuItem createmenuItemObject(ResultSet resultSet) {
        MenuItem item = null;
        try {
        		item = new MenuItem(resultSet.getInt("ItemId"), resultSet.getDouble("Price"), resultSet.getString("Food"), resultSet.getString("Description"), resultSet.getBlob("Picture"));
        		
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
        
    }

}