package br.com.biogurt.controller;

import br.com.biogurt.dto.ContatoDTO;
import br.com.biogurt.model.Contato;
import br.com.biogurt.service.ContatoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/contato")
public class ContatoController {

    @Autowired
    private ContatoService service;

    public ContatoController(ContatoService contatoService) {
        this.service = contatoService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity receberContato(@RequestBody @Valid ContatoDTO dto) {
        service.processarContato(dto);
        return ResponseEntity.ok(Map.of(
                "message", "Contato enviado com sucesso",
                "status", "ok"
        ));
    }

    @GetMapping("/listar")
    public List<Contato> listarContatos() {
        return service.listarContatos();
    }
}
