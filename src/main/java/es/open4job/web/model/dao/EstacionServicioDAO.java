package es.open4job.web.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import es.open4job.web.model.vo.EstacionServicio;

public class EstacionServicioDAO {
	
			
			//Devuelve la la estacion de servicio por el id
			
			public  EstacionServicio getListadoEstacionServicio(int id, Connection conexion) throws SQLException {
				
				EstacionServicio idLista = null;
				PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM ESTACION_SERVICIO WHERE id = ?");
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()){
					idLista = new EstacionServicio(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getFloat(4),rs.getFloat(5),rs.getString(6));
				}
				if (rs != null) {
					try {
						rs.close();
					} catch (Exception e) {
					}
				}
				if (stmt != null) {
					try {
						stmt.close();
					} catch (Exception e) {
					}
				}
			return idLista;
			
			}
			

}
