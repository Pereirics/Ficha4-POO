package Main;

import java.util.Objects;

public class LinhaEcomenda {

    // Variáveis de instância
    private String referencia;
    private String descricao;
    private double precoAImp;
    private int quantidadeEnc;
    private int imposto;
    private int descontoAImp;

    // Construtor por omissão
    public LinhaEcomenda() {
        this.referencia = "";
        this.descricao = "";
        this.precoAImp = 0;
        this.quantidadeEnc = 0;
        this.imposto = 0;
        this.descontoAImp = 0;
    }

    // Construtor parametrizado
    public LinhaEcomenda(String referencia, String descricao, double precoAImp, int quantidadeEnc, int imposto, int descontoAImp) {
        this.referencia = referencia;
        this.descricao = descricao;
        this.precoAImp = precoAImp;
        this.quantidadeEnc = quantidadeEnc;
        this.imposto = imposto;
        this.descontoAImp = descontoAImp;
    }

    // Construtor de cópia
    public LinhaEcomenda(LinhaEcomenda l) {
        this.referencia = l.getReferencia();
        this.descricao = l.getDescricao();
        this.precoAImp = l.getPrecoAImp();
        this.quantidadeEnc = l.getQuantidadeEnc();
        this.imposto = l.getImposto();
        this.descontoAImp = l.getDescontoAImp();
    }

    // Métodos de instância
    public String getReferencia() {
        return this.referencia;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public double getPrecoAImp() {
        return this.precoAImp;
    }

    public int getQuantidadeEnc() {
        return this.quantidadeEnc;
    }

    public int getImposto() {
        return this.imposto;
    }

    public int getDescontoAImp() {
        return this.descontoAImp;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPrecoAImp(double precoAImp) {
        this.precoAImp = precoAImp;
    }

    public void setQuantidadeEnc(int quantidadeEnc) {
        this.quantidadeEnc = quantidadeEnc;
    }

    public void setImposto(int imposto) {
        this.imposto = imposto;
    }

    public void setDescontoAImp(int descontoAImp) {
        this.descontoAImp = descontoAImp;
    }

    public boolean equals(Object l) {
        if (this == l)
            return true;
        if ((l == null) || (this.getClass() != l.getClass()))
            return false;
        LinhaEcomenda l1 = (LinhaEcomenda) l;
        return (Objects.equals(this.referencia, l1.getReferencia()) && Objects.equals(this.descricao, l1.getDescricao()) && this.precoAImp == l1.getPrecoAImp() && this.quantidadeEnc == l1.getQuantidadeEnc() && this.imposto == l1.getImposto() && this.descontoAImp == l1.getDescontoAImp());
    }

    public String toString() {
        return "Linha encomenda{" +
                "\nReferência: " + this.referencia +
                "\nDescrição: " + this.descricao +
                "\nPreço antes Imposto: " + this.precoAImp +
                "\nQuantidade encomendada: " + this.quantidadeEnc +
                "\nImposto em percentagem: " + this.imposto + "%" +
                "\nDesconto antes imposto: " + this.descontoAImp + "%" +
                "\n}";
    }

    public LinhaEcomenda clone() {
        return new LinhaEcomenda(this);
    }

    public double calculaValorLinhaEnc() {
        return (this.precoAImp * (1 - (double)this.descontoAImp/100) * (1 + (double)this.imposto/100)) * this.quantidadeEnc;
    }

    public double calculaValorDesconto() {
        return (this.precoAImp - (this.precoAImp * (1 - (double)this.descontoAImp/100))) * this.quantidadeEnc;
    }


}
