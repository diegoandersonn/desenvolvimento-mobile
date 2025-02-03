package com.example.ddm;

import androidx.annotation.NonNull;

public class Jogador {
    String nome;
    String time;
    int idade;
    public Jogador ( String nome, String time, int idade) {
        this.nome = nome;
        this.time = time;
        this.idade = idade;
    }

    @NonNull
    @Override
    public String toString() {
        return "Nome: " + nome + " Time: " + time + " Idade: " + idade + " anos";
    }
}