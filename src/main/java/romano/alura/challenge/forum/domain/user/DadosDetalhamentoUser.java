package romano.alura.challenge.forum.domain.user;

public record DadosDetalhamentoUser(
        String login
) {

    public DadosDetalhamentoUser(User user) {
        this(user.getLogin());
    }

}
