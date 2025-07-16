package controllers;

import models.Lancamento;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CaixaController {

    private ArrayList<Lancamento> lancamentos = new ArrayList<>();

    public void adicionarLancamento(String descricao, Double valor, String tipo) {
        lancamentos.add(new Lancamento(descricao, valor, tipo));
    }

    public double calcularSaldo() {
        double saldo = 0;
        for (Lancamento l : lancamentos) {
            if (l.getTipo().equalsIgnoreCase("Entrada")) {
                saldo += l.getValor();
            }
            else if (saldo < l.getValor()) {
                saldo -= l.getValor();
            }
        }
        return saldo;
    }

    public ArrayList<Lancamento> getLancamentos() {
        return lancamentos;
    }
}
