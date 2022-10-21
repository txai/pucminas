package com.receba.iniciativaservice.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Stack;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IniciativaDTO {
    String id;

    String nome;

    String dataDistribuicao;

    String endereco;

    String telefone;

    String email;

    Map<String, Integer> composicaoCesta;

    String userId;

    public IniciativaDTO(final Iniciativa iniciativa) {
        this.id = iniciativa.getId();
        this.nome = iniciativa.getNome();
        this.dataDistribuicao = iniciativa.getDataDistribuicao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.endereco = iniciativa.getEndereco();
        this.telefone = iniciativa.getTelefone();
        this.email = iniciativa.getEmail();
        this.composicaoCesta = iniciativa.getComposicaoCesta().toMap();
        this.userId = iniciativa.getUserId();

    }

    public Iniciativa toIniciativa() {
        final String id = this.id;
        final String nome = this.nome;
        LocalDate dataDistribuicao = LocalDate.parse(this.dataDistribuicao, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        final String endereco = this.endereco;
        final String telefone = this.telefone;
        final String email = this.email;
        ComposicaoCestaBasica composicaoCesta = new ComposicaoCestaBasica(this.composicaoCesta);
        String userId = this.userId;

        return new Iniciativa(id, nome, dataDistribuicao, endereco, telefone, email, new Stack<>(), composicaoCesta, userId);
    }
}
