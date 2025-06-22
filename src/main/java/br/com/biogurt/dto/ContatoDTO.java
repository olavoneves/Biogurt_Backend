package br.com.biogurt.dto;

import br.com.biogurt.model.Contato;

import java.time.LocalDateTime;

public record ContatoDTO(String nome,
                         String email,
                         String telefone,
                         String mensagem) {
    public Contato toEntity() {
        Contato contato = new Contato();
        contato.setNome(this.nome);
        contato.setEmail(this.email);
        contato.setTelefone(this.telefone);
        contato.setMensagem(this.mensagem);
        contato.setDataEnvio(LocalDateTime.now());
        return contato;
    }
}
