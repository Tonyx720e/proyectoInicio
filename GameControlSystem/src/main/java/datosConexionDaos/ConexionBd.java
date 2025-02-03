/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datosConexionDaos;

import java.sql.Connection;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author tonym
 */
public class ConexionBd {

    private static final String JDBC_URL = "jdbc:mysql://localhost";
    private static final String BASE_DATOS = "bd_mistergaming";
    private static final String USER = System.getenv("DB_USER_PRUEBA");
    private static final String PASS = System.getenv("DB_PASS_PRUEBA");
    private static final String URL_FINAL = JDBC_URL + "/" + BASE_DATOS + "/" + "?useSSL=false&allowPublicKeyRetrieval=true";
    private static BasicDataSource dataSource;

    /*Metodo DataSource*/
    public static DataSource obtenerConexion() {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl(JDBC_URL);
            dataSource.setUsername(USER);
            dataSource.setPassword(PASS);
            /*Inicializa el pool de cantidades de conexiones
            a la base de datos*/
            dataSource.setInitialSize(10);
            dataSource.setMaxTotal(50);
        }
        return dataSource;

    }
}
