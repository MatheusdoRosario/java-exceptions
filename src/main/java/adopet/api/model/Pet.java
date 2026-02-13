package adopet.api.model;


import adopet.api.dto.CadastroPetDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "pets")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer idade;

    @Enumerated(EnumType.STRING)
    private TipoPet tipo;

    private Boolean adotado;

    private String imagem;

    @OneToOne(mappedBy = "pet", fetch = FetchType.LAZY)
    private Adocao adocao;

    public Pet(CadastroPetDTO dados, String nomeDaImagem)
    {
        this.nome = dados.nome();
        this.idade = dados.idade();
        this.tipo = dados.tipo();
        this.imagem = nomeDaImagem;
        this.adotado = false;
    }

    public void marcarComoAdotado(){
        this.adotado = true;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public TipoPet getTipo() {
        return tipo;
    }

    public Boolean getAdotado() {
        return adotado;
    }

    public String getImagem() {
        return imagem;
    }

    public Adocao getAdocao() {
        return adocao;
    }
}

