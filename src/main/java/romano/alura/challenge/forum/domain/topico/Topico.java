package romano.alura.challenge.forum.domain.topico;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensagem;
    private LocalDate data;
    private String autor;
    private String curso;

    public Topico(String token, DadosCadastroTopico dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.autor = getUsernameOfToken(token);
        this.curso = dados.curso();
        this.data = LocalDate.now();
    }

    private String getUsernameOfToken(String tokenJwt) {
        var tokenJwtReplaced = tokenJwt.replace("Bearer ", "");

        Algorithm algorithm = Algorithm.HMAC256(System.getenv("API_SECRET"));
        return JWT.require(algorithm)
                .withIssuer("API forum")
                .build()
                .verify(tokenJwtReplaced)
                .getSubject();
    }

    public void atualizarInformações(String token, DadosAtualizacaoTopico dados) {
        var user = getUsernameOfToken(token);

        if (autor.equalsIgnoreCase(user)) {

            if (dados.titulo() != null) {
                this.titulo = dados.titulo();
            }

            if (dados.mensagem() != null) {
                this.mensagem = dados.mensagem();
            }

            if (dados.curso() != null) {
                this.curso = dados.curso();
            }
        } else {
            throw new RuntimeException("Usuário inválido");
        }
    }
}
