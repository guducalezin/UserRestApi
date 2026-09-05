package com.gudu.api.repository;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.gudu.api.model.Usuario;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UsuarioRepository {

    private final JdbcTemplate jdbcTemplate;

    public UsuarioRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Usuario> listar() {
        String sql = "Select * from Usuarios";
        return jdbcTemplate.query(sql, (rs, rowNum)
                -> new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("mensagem")
                )
        );
    }

    public void inserir(Usuario usuario) {
        String sql = "insert into Usuarios (nome, email, mensagem) values (?, ?, ?)";

        jdbcTemplate.update(
                sql,
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getMensagem()
        );
    }
}
