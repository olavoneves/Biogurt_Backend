package br.com.biogurt.service;

import br.com.biogurt.dto.ContatoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarEmail(ContatoDTO dto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("biogurt544@gmail.com");
        message.setSubject("Novo contato pelo site");
        message.setText(
                "Nome: " + dto.nome() + "\n" +
                    "Email: " + dto.email() + "\n" +
                        "Telefone: " + dto.telefone() + "\n" +
                            "Mensagem: " + dto.mensagem()
        );
        mailSender.send(message);
    }
}
