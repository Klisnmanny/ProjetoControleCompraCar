/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compracarros.acesso;
import java.sql.*;
/**
 *
 * @author Klisnmanny
 */
public class conexao {
    public static  Connection conectar(){
        java.sql.Connection ligar = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String banco ="jdbc:mysql://127.0.0.1:3306/compracarros?useSSL=false";
        String usuario = "root";
        String senha = "123456";
    
        
        try {
            Class.forName(driver);
            ligar = DriverManager.getConnection(banco,usuario,senha);
            return ligar;
           
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
