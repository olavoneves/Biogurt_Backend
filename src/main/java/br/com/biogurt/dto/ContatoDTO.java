package br.com.biogurt.dto;

import br.com.biogurt.model.Contato;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;

public record ContatoDTO(@NotBlank String nome,
                         @NotBlank @Email String email,
                         @NotBlank @Pattern(regexp = "^(\\d{10,11})$", message = "Telefone inválido") String telefone,
                         @NotBlank String mensagem) {
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
