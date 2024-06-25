package romano.alura.challenge.forum.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import romano.alura.challenge.forum.domain.user.*;
import romano.alura.challenge.forum.infra.DadosTokenJWT;
import romano.alura.challenge.forum.infra.TokenService;

@RestController
public class AutenticacaoController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @RequestMapping("/cadastrar") @PostMapping @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastramentoUser dados, UriComponentsBuilder uriBuilder) {
        var user = new User(dados);
        repository.save(user);

        var uri = uriBuilder.path("/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoUser(user));
    }

    @RequestMapping("/login") @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.password());

        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }

}
