package com.example.barbie;

public class GuardaRoupa {

    private double orcamento;

    public GuardaRoupa(double orcamento) {
        this.orcamento = orcamento;
    }

    public double precoComDesconto(double preco, double percentual) {
        if(percentual < 0 || percentual > 100) {
            throw new IllegalArgumentException("O desconto deve ser entre 0 e 100");
        }
        return preco - (preco * percentual / 100);
    }

    public boolean cabeNoOrcamento(double preco) {
        return preco <= orcamento;
    }

    public boolean ehDeGala(double preco) {
        return preco > 200.0;
    }

    public void registrarCompra(double preco) {
        this.orcamento = this.orcamento - preco;
    }

    public double getOrcamento() {
        return orcamento;
    }
}
