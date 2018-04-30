package br.com.sja.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.sja.connect.ConnectionFactory;
import br.com.sja.model.Segmento;

public class SegmentoDao {

	// a conexão com o banco de dados
	private static Connection connection;

	public SegmentoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Segmento seg) {

		// cria um preparedStatement
		String sql = "INSERT INTO SEGMENTO (DATA_SEGMENTO, ORIGEM, DESTINO, VOO,"
				+ "CIA, CLASSE, HORA_SAIDA, HORA_CHEGADA, LOCALIZADOR) values (?,?,?,?,?,?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setDate(1, new Date(seg.getDataSegmento().getTimeInMillis()));
		//	stmt.setDate(1, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
			stmt.setString(2, seg.getOrigem());
			stmt.setString(3, seg.getDestino());
			stmt.setString(4, seg.getVoo());
			stmt.setString(5, seg.getCia());
			stmt.setString(6, seg.getClasse());
			stmt.setDate(7, new Date(seg.getHoraChegada().getTimeInMillis()));
			stmt.setDate(8, new Date(seg.getHoraChegada().getTimeInMillis()));
	//		stmt.setDate(7,  new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
	//		stmt.setDate(8,  new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
			stmt.setString(9, seg.getLocalizador());
			
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Segmento> getLista() {
		try {
			List<Segmento> segmentos = new ArrayList<Segmento>();
			PreparedStatement stmt = connection.prepareStatement("select * from SEGMENTO");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Segmento segmento = new Segmento();
				
				segmento.setSegmento(rs.getInt("ID_SEGMENTO"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("DATA_SEGMENTO"));
				segmento.setDataSegmento(data);
				
				segmento.setOrigem(rs.getString("ORIGEM"));
				segmento.setDestino(rs.getString("DESTINO"));
				segmento.setVoo(rs.getString("VOO"));
				segmento.setCia(rs.getString("CIA"));
				segmento.setClasse(rs.getString("CLASSE"));

				Calendar data1 = Calendar.getInstance();
				data1.setTime(rs.getDate("HORA_SAIDA"));
				segmento.setHoraSaida(data1);
				
				Calendar data2 = Calendar.getInstance();
				data2.setTime(rs.getDate("HORA_CHEGADA"));
				segmento.setHoraChegada(data2);
				
				segmento.setLocalizador(rs.getString("LOCALIZADOR"));
				
				segmentos.add(segmento);
			}

			rs.close();
			stmt.close();
			return segmentos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(Segmento segmento) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from segmento where id_segmento=?");
			stmt.setInt(1, segmento.getSegmento());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
