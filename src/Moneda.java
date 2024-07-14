public class Moneda {
    String codigoB;
    String CodigoC;
    Double ValorB;
    Double ValorC;

    public Moneda(String cb, String cc, Double vb, Double vc) {
        this.codigoB = cb;
        this.CodigoC = cc;
        this.ValorB = vb;
        this.ValorC = vc;
    }

    @Override
    public String toString() {
        return String.format("%.2f %s es igual a %.2f %s",ValorB,codigoB,ValorC,CodigoC);
    }
}
