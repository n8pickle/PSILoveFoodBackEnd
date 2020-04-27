package com.lovefood.LoveFood;

import org.springframework.stereotype.Repository;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.List;

@Repository
public class MenuRepository implements IMenuItemRepository{
      public static void main(String args[]) {
    	  
      }

        public List<MenuItem> getMenuItems() {

            List<MenuItem> item = null;
        	
            try {
                String query = "select * from menu_items.food_items";
                Class.forName("com.mysql.cj.jdbc.Driver");
                String connectionString = "jdbc:mysql://localhost:3306/menu_items";
                Connection dbConnection = DriverManager.getConnection(connectionString, "root", "");
                Statement statement = dbConnection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next()){
                    item.add(createmenuItemObject(resultSet));
                }
                dbConnection.close();
            }
            catch (SQLException | ClassNotFoundException e )
            {
                e.printStackTrace();
            }
            return (List<MenuItem>)item;
        }

    private MenuItem createmenuItemObject(ResultSet resultSet) {
        MenuItem item = null;
        try {
        		item = new MenuItem(resultSet.getInt("ItemId"), resultSet.getDouble("Price"), resultSet.getString("Food"), resultSet.getString("Description"), getPicture(resultSet.getBlob("Picture")));
        		
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
        
    }

    private BufferedImage getPicture(Blob blob)
    {
        InputStream in = null;
        BufferedImage image = null;
        try {
            in = blob.getBinaryStream();
            image = ImageIO.read(in);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return image;
    }

}