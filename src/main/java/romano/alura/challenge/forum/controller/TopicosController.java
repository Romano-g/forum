package romano.alura.challenge.forum.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import romano.alura.challenge.forum.domain.topico.*;

import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping @Transactional
    public ResponseEntity cadastrar(@RequestHeader("Authorization") String token, @RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder) {
        var topico = new Topico(token, dados);
        repository.save(topico);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
    }

    @GetMapping
    public ResponseEntity listar() {
        var topicos = repository.findAll();

        return ResponseEntity.ok(topicos);
    }

    @PutMapping @Transactional
    public ResponseEntity atualizarTopico(@RequestHeader("Authorization") String token, @RequestBody @Valid DadosAtualizacaoTopico dados) {
        var topico = repository.getReferenceById(dados.id());

        topico.atualizarInformações(token, dados);

        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharTopico(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarTopico(@RequestHeader("Authorization") String token, @PathVariable Long id) {
        Optional<Topico> topico = Optional.of(repository.getReferenceById(id));

        if (topico.isPresent()) {
            topico.get().deletar(token);
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
