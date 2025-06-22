package br.com.biogurt.controller;

import br.com.biogurt.dto.ContatoDTO;
import br.com.biogurt.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contato")
public class ContatoController {

    @Autowired
    private ContatoService service;

    public ContatoController(ContatoService contatoService) {
        this.service = contatoService;
    }

    @PostMapping
    public ResponseEntity<Void> receberContato(@RequestBody ContatoDTO dto) {
        service.processarContato(dto);
        return ResponseEntity.ok().build();
    }
}
