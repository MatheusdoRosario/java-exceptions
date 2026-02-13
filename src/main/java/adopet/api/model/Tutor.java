package adopet.api.model;

import adopet.api.dto.CadastroTutorDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tutores")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;

    @NotBlank
    private String email;

    @OneToMany(mappedBy = "tutor")
    private List<Adocao> adocoes = new ArrayList<>();

    public Tutor(CadastroTutorDTO dados){
        this.nome = dados.nome();
        this.email = dados.email();
    }

    public Long getId() {
        return id;
    }

    public @NotBlank String getNome() {
        return nome;
    }

    public @NotBlank String getEmail() {
        return email;
    }

    public List<Adocao> getAdocoes() {
        return adocoes;
    }
}
