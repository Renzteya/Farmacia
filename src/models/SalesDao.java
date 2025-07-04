
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalesDao {
    //Instanciar la conexión
    ConnectionMySQL cn = new ConnectionMySQL();
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
    //Rgistrar venta
    public boolean registerSaleQuery(int customer_id, int employee_id, double total){
    
        String query= "INSERT INTO sales(customer_id, employee_id, total, sales_date) VALUES(?,?,?,?)";
        Timestamp datetime = new Timestamp(new Date().getTime());
        try{
        
            conn= cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setInt(1, customer_id);
            pst.setInt(2, employee_id);
            pst.setDouble(3, total);
            pst.setTimestamp(4, datetime);
            pst.execute();
            return true;
        }catch(SQLException e){
        
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
        
    }
    
    //Regisrar detalles de la venta
    public boolean registerSaleDetailQuery(int product_id, double sale_id, int sale_quantity, double sale_price, double sale_subtotal){
    
        String query= "INSERT INTO sales_details(product_id, sale_id, sale_quantity,sales_price, sale_subtotal) VALUES(?,?,?,?,?)";
        Timestamp datetime = new Timestamp(new Date().getTime());
        try{
        
            conn= cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setInt(1, product_id);
            pst.setDouble(2, sale_id);
            pst.setInt(3, sale_quantity);
            pst.setDouble(4, sale_price);
            pst.setDouble(5, sale_subtotal);
            pst.execute();
            return true;
        }catch(SQLException e){
        
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

    //Obetner id de la venta
    
    public int saleId(){
    
        int id=0;
        String query = "SELECT MAX(id) AS is FROM sales";
        try{
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            
            if(rs.next()){
                id = rs.getInt("id");
            }
        
        }catch (SQLException e){
        
            System.out.println(e.getMessage());
        }
        return id;
    }
    
    //Obtener la lista de las ventas
    
    public List listAllSalesQuery(){
    
        List<Sales> list_sales = new ArrayList();
        
        String query = "SELECT s.id AS invoice, c.full_name AS customer, e.full_name AS employee, s.total, s.sales_date FROM sales INNER JOIN customers c ON s.customer_id = c.id INNER JOIN employees e ON s.employee_id = e.id ORDER BY s.id ASC";
        try{
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            
            //Recorrer
            while(rs.next()){
                Sales sale = new Sales();
                sale.setId(rs.getInt("invoice"));
                sale.setCustomer_name(rs.getString("customer"));
                sale.setEmployee_name(rs.getString("employee"));
                sale.setTotal_to_pay(rs.getDouble("total"));
                sale.setSale_date(rs.getString("sale_date"));
            }
        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, toString());
        }
        return list_sales;
    }
}
