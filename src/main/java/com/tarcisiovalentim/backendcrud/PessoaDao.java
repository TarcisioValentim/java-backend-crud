package com.tarcisiovalentim.backendcrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PessoaDao {

	@Autowired
	private DataSource dataSource;
	
	public void salvar(Pessoa pessoa) {
		try (Connection con = dataSource.getConnection()){
			PreparedStatement pstmt = con.prepareStatement("insert into pessoa (id, nome, endereco) values (?, ?, ?) on conflict (id) do update set nome = ?, endereco = ?");
			int idx = 1;
			pstmt.setInt(idx++, pessoa.getId());
			pstmt.setString(idx++, pessoa.getNome());
			pstmt.setString(idx++, pessoa.getEndereco());
			pstmt.setString(idx++, pessoa.getNome());
			pstmt.setString(idx++, pessoa.getEndereco());
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Pessoa> listar(){
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		try (Connection con = dataSource.getConnection()){
			PreparedStatement pstmt = con.prepareStatement("select * from pessoa");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				pessoas.add(mapear(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pessoas;
	}

	public List<Pessoa> excluir(int id){
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		try (Connection con = dataSource.getConnection()){
			PreparedStatement pstmt = con.prepareStatement("delete from pessoa where id = ?");
			pstmt.setInt(1, id);
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pessoas;
	}

	private Pessoa mapear(ResultSet rs) throws SQLException {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(rs.getInt("id"));
		pessoa.setNome(rs.getString("nome"));
		pessoa.setEndereco(rs.getString("endereco"));
		return pessoa;
	}
	
}
