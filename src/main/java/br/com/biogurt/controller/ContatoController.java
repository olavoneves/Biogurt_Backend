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
    public ResponseEntity<Void> receberContato(@RequestBody @Valid ContatoDTO dto) {
        service.processarContato(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Contato> listarContatos() {
        return service.listarContatos();
    }
}
