package br.com.sja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sja.connect.ConnectionFactory;
import br.com.sja.model.Contato;

public class ContatoDao {

	// a conexão com o banco de dados
		private static Connection connection;

		public ContatoDao() {
			this.connection = new ConnectionFactory().getConnection();
		}

		public void adiciona(Contato contato) {

			// cria um preparedStatement
			String sql = "INSERT INTO contact (name) values (?)";

			try {
				// prepared statement para inserção
				PreparedStatement stmt = connection.prepareStatement(sql);

				// seta os valores
				stmt.setString(1, contato.getNome());

				// executa
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		public List<Contato> getLista() {
			try {
				List<Contato> contatos = new ArrayList<Contato>();
				PreparedStatement stmt = connection.prepareStatement("select * from contact");
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					// criando o objeto Contato
					Contato contato = new Contato();
					contato.setId(rs.getInt("ID_CONTACT"));
					contato.setNome(rs.getString("NAME"));

					// montando a data através do Calendar
					// Calendar data = Calendar.getInstance();
					// data.setTime(rs.getDate("dataNascimento"));
					// contato.setDataNascimento(data);

					// adicionando o objeto à lista
					contatos.add(contato);
				}

				rs.close();
				stmt.close();
				return contatos;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		public void altera(Contato contato) {
			String sql = "update contact set name=? where id_contact=?";
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setInt(1, contato.getId());
				stmt.setString(2, contato.getNome());
				// stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		public void remove(Contato contato) {
			try {
				PreparedStatement stmt = connection.prepareStatement("delete from contact where id_contact=?");
				stmt.setLong(1, contato.getId());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
}
