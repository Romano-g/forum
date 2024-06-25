package romano.alura.challenge.forum.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroTopico(

        @NotNull
        String titulo,

        @NotNull
        String mensagem,

        @NotNull
        String curso

) {

}
