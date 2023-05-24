public class Produs {
    private int produsId;
    private String produsNume;

    public Produs(int produsId, String produsNume) {
        this.produsId = produsId;
        this.produsNume = produsNume;
    }

    public int getProdusId() {
        return produsId;
    }

    public String getProdusNume() {
        return produsNume;
    }

    public void setProdusId(int produsId) {
        this.produsId = produsId;
    }

    public void setProdusNume(String produsNume) {
        this.produsNume = produsNume;
    }
}
