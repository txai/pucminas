package com.receba.iniciativaservice.models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import lombok.Value;

@Value
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
        final DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        this.dataDistribuicao = formatter.format(iniciativa.getDataDistribuicao());
        this.endereco = iniciativa.getEndereco();
        this.telefone = iniciativa.getTelefone();
        this.email = iniciativa.getEmail();
        this.composicaoCesta = iniciativa.getComposicaoCesta().toMap();
        this.userId = iniciativa.getUserId();

    }

    public Iniciativa toIniciativa() {
        final String id = this.id;
        final String nome = this.nome;
        Date dataDistribuicao = new Date();
        try {
            dataDistribuicao = new SimpleDateFormat("dd/MM/yyyy").parse(this.dataDistribuicao);
        } catch (ParseException ex) {
        }
        final String endereco = this.endereco;
        final String telefone = this.telefone;
        final String email = this.email;
        ComposicaoCestaBasica composicaoCesta = new ComposicaoCestaBasica(this.composicaoCesta);
        String userId = this.userId;

        return new Iniciativa(id, nome, dataDistribuicao, endereco, telefone, email, composicaoCesta, userId);
    }
}
