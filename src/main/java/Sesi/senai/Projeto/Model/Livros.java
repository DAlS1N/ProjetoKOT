package Sesi.senai.Projeto.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "livros")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Livros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String genero;

    @Column(nullable = false)
    private String autor;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    public Usuario usuario;

}