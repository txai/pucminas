package com.receba.iniciativaservice.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Value;

@Value
public class ComposicaoCestaBasica {

    @Getter(AccessLevel.NONE)
    Map<ItemCestaBasica, Integer> items = new HashMap<>();

    public ComposicaoCestaBasica(Map<String, Integer> map) {
        this.items.putAll(map.entrySet().stream()
                .collect(Collectors.toMap(
                    e -> new ItemCestaBasica(e.getKey()),
                    Map.Entry::getValue)
                ));
    }

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

    public Map<String, Integer> toMap() {
        return this.items.entrySet().stream()
                .collect(Collectors.toMap(
                    e -> e.getKey().getNome(),
                    Map.Entry::getValue
                ));
    }
}
