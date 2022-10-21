package com.receba.iniciativaservice.models;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.annotation.PersistenceCreator;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Value;

@Value
public class ComposicaoCestaBasica {

    @Getter(AccessLevel.NONE)
    Set<ItemCestaBasica> items = new HashSet<>();

    @PersistenceCreator
    public ComposicaoCestaBasica(Set<ItemCestaBasica> items) {
        this.items.addAll(items);
    }

    public ComposicaoCestaBasica(Map<String, Integer> map) {
        this.items.addAll(map.entrySet().stream()
                .map(e -> new ItemCestaBasica(e.getKey(), e.getValue()))
                .collect(Collectors.toList())
                );
    }

    public Integer getQtdItem(ItemCestaBasica item) {
        Objects.requireNonNull(item);

        return this.items.stream()
            .filter(i -> item.equals(i))
            .map(ItemCestaBasica::getQtd)
            .findFirst().orElse(0);
    }

    public Integer getQtdItem(String nome) {
        Objects.requireNonNull(nome);

        return this.items.stream()
                .filter(i -> nome.equals(i.getNome()))
                .map(ItemCestaBasica::getQtd)
                .findFirst().orElse(0);
    }

    public Boolean itemJaExistente(ItemCestaBasica item) {
        Objects.requireNonNull(item);

        return this.items.contains(item);
    }

    public Boolean itemJaExistente(String nome) {
        Objects.requireNonNull(nome);

        return this.items.stream()
                .anyMatch(i -> nome.equals(i.getNome()));

    }

    public Map<String, Integer> toMap() {
        return this.items.stream()
                .collect(Collectors.toMap(ItemCestaBasica::getNome, ItemCestaBasica::getQtd));
    }
}
