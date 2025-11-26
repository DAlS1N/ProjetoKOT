package Sesi.senai.Projeto.Model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false,unique = true, length = 150)
    private String email;

    @Column(nullable = false,length = 150)
    private String senha;

    @OneToMany(mappedBy = "usuario")
    public List<Livros> livros;

}
