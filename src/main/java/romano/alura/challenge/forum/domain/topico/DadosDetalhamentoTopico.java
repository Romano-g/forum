package romano.alura.challenge.forum.domain.topico;

import java.time.LocalDate;

public record DadosDetalhamentoTopico(
        Long id,
        String titulo,
        String mensagem,
        LocalDate data,
        String autor,
        String curso,
        EstadoDoTopico estado
) {

    public DadosDetalhamentoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getData(), topico.getAutor(), topico.getCurso(), topico.getEstado());
    }

}
