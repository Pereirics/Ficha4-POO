package Main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CasaInteligente {

    // Variáveis de instância
    private ArrayList<Lampada> lampadas;

    // Construtor por omissão
    public CasaInteligente() {
        this.lampadas = new ArrayList<Lampada>();
    }

    // Construtor parametrizado
    public CasaInteligente(ArrayList<Lampada> lampadas) {
        this.lampadas = lampadas;
    }

    // Construtor cópia
    public CasaInteligente(CasaInteligente c) {
        this.lampadas = c.getLampadas();
    }

    // Métodos de instância
    public ArrayList<Lampada> getLampadas() {
        return this.lampadas;
    }

    public void setLampadas(ArrayList<Lampada> lampadas) {
        this.lampadas = lampadas;
    }

    public void addLampada(Lampada l) {
        this.lampadas.add(l);
    }

    public void ligaLampadaNormal(int index) {
        if (0 <= index && index < this.lampadas.size()) {
            this.lampadas.get(index).lampON();
        }
    }

    public void ligaLampadaEco(int index) {
        if (0 <= index && index < this.lampadas.size()) {
            this.lampadas.get(index).lampECO();
        }
    }

    public int qtEmEco() {
        int count = 0;
        for (Lampada l: this.lampadas) {
            if (l.getEstado() == 2) count++;
        }
        return count;
    }

    public void removeLampada(int index) {
        if (0 <= index && index < this.lampadas.size()) {
            this.lampadas.remove(index);
        }
    }

    public void ligaTodasEco() {
        for (Lampada l: this.lampadas) {
            l.lampECO();
        }
    }

    public void ligaTodasMax() {
        for (Lampada l: this.lampadas) {
            l.lampON();
        }
    }

    public double consumoTotal() { // Ou usar lampadas.stream().mapToDouble(Lampada::getConsumoTotal).sum()
        double total = 0;
        for (Lampada l: this.lampadas) {
            total += l.totalConsumo();
        }
        return total;
    }

    public Lampada maisGastadora() { // Ou usar (lampadas.stream().max(Comparator.comparingDouble(Lampada::getConsumoTotal))).get()
        Lampada res = new Lampada();
        for (Lampada l: this.lampadas) {
            if (l.totalConsumo() > res.totalConsumo()) {
                res = l;
            }
        }
        return res;
    }

    public Set<Lampada> podiumEconomia() {
        double consumo = this.lampadas.get(0).totalConsumo();
        double menor = consumo, menor1 = consumo, menor2 = consumo;
        Lampada l1 = new Lampada(), l2 = new Lampada(), l3 = new Lampada();
        for (Lampada l: this.lampadas) {
            if (l.totalConsumo() < menor) {
                menor = l.totalConsumo();
                l1 = l;
            }
            else if (l.totalConsumo() > menor1) {
                menor1 = l.totalConsumo();
                l2 = l;
            }
            else if (l.totalConsumo() > menor2) {
                menor2 = l.totalConsumo();
                l3 = l;
            }
        }
        Set<Lampada> res = new HashSet<>();
        res.add(l1);
        res.add(l2);
        res.add(l3);
        return res;
    }

    public void reset() {
        for (Lampada l: this.lampadas) {
            l.setReset(System.currentTimeMillis());
        }
    }

}
