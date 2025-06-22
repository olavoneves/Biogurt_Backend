package br.com.biogurt.service;

import br.com.biogurt.dto.ContatoDTO;
import br.com.biogurt.model.Contato;
import br.com.biogurt.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository repository;
    private EmailService emailService;

    public void processarContato(ContatoDTO dto) {
        Contato contato = repository.save(dto.toEntity());
        emailService.enviarEmail(dto); // envia o email com os dados
    }
}
