package com.loperals.forochallenge.domain.publicaciones;

import com.loperals.forochallenge.domain.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Publicacion")
@Table(name = "publicaciones")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;

    @Column(name="fechaCreacion")
    private LocalDateTime fechaCreacion;
    private Boolean estado;

    @JoinColumn(name="usuario_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    private Curso curso;
}
