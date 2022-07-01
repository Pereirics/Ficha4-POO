package Main;

public class Lampada {

    // Variáveis de instância
    int estado; // 0 - OFF, 1 - ON, 2 - ECO
    double consumo;
    long start;
    long reset;

    // Construtor por omissão
    public Lampada() {
        this.estado = 0;
        this.consumo = 0;
        this.start = System.currentTimeMillis();
        this.reset = this.start;
    }

    // Construtor parametrizado
    public Lampada(int estado, double consumo) {
        this.estado = estado;
        this.consumo = consumo;
    }

    // Construtor por cópia
    public Lampada(Lampada l) {
        this.estado = l.getEstado();
        this.consumo = l.getConsumo();
        this.start = l.getStart();
        this.reset = l.getReset();
    }

    // Métodos de instância
    public int getEstado() {
        return this.estado;
    }

    public int getConsumo() {
        if (this.estado == 0) return 0;
        else if (this.estado == 1) return 22;
        else if (this.estado == 2) return 11;
        else return 0;
    }

    public Long getStart() {
        return this.start;
    }

    public Long getReset() {
        return this.reset;
    }

    public void setEstado(int estado) {
        this.estado = estado;
        setConsumo(getConsumo());
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public void setReset(Long reset) {
        this.reset = reset;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o == null) || (o.getClass() != this.getClass()))
            return false;
        Lampada lampada = (Lampada) o;
        return getEstado() == lampada.getEstado() && Double.compare(lampada.getConsumo(), getConsumo()) == 0;
    }

    public String toString() {
        return "Lampada{" +
                "estado=" + estado +
                ", consumo=" + consumo +
                ", start=" + start +
                '}';
    }

    public void lampON() {
        this.setEstado(1);
        this.reset = System.currentTimeMillis();
    }

    public void lampOFF() {
        this.setEstado(0);
    }

    public void lampECO() {
        this.setEstado(2);
    }

    public double totalConsumo() {
        long end = System.currentTimeMillis();
        long tempo = end - this.start;
        this.reset = System.currentTimeMillis();
        return tempo*this.consumo;
    }

    public double periodoConsumo() {
        long end = System.currentTimeMillis();
        long tempo = end - this.reset;
        return tempo*this.consumo;
    }
}
