    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit;

import controller.ControllerDaftarPasien;
import java.sql.SQLException;
import model.AplikasiConsole;

/**
 *
 * @author Asus A450CA
 */
public class RumahSakit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here 
        
      AplikasiConsole model = new AplikasiConsole();
      new ControllerDaftarPasien(model);
    }
      
}
