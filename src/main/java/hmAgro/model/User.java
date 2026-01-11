package hmAgro.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users") // ou usuario, tb_user, etc
public class User {

    // Construtor vazio obrigatório do JPA
    public User() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    private String role;  // ex.: admin, cliente
}
