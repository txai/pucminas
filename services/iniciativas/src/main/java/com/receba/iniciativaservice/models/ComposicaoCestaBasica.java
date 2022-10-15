package com.receba.iniciativaservice.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Value;

@Value
public class ComposicaoCestaBasica {

    @Getter(AccessLevel.NONE)
    Map<ItemCestaBasica, Integer> items = new HashMap<>();

    public Integer getQtdItem(ItemCestaBasica item) {
        Objects.requireNonNull(item);

        return this.items.getOrDefault(item, 0);
    }

    public Integer getQtdItem(String nome) {
        Objects.requireNonNull(nome);

        return this.items.entrySet().stream()
                .filter(e -> nome.equals(e.getKey().getNome()))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(0);
    }

    public Boolean itemJaExistente(ItemCestaBasica item) {
        Objects.requireNonNull(item);

        return this.items.containsKey(item);
    }

    public Boolean itemJaExistente(String nome) {
        Objects.requireNonNull(nome);

        return this.items.entrySet().stream()
                .anyMatch(e -> nome.equals(e.getKey().getNome()));
    }
}
