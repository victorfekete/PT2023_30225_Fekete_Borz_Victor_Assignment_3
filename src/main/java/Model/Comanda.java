public class Comanda {
    private int comandaId;
    private int idclient;
    private int idprodus;
    private int nrproduse;

    public Comanda(int comandaId, int idclient, int idprodus, int nrproduse) {
        this.comandaId = comandaId;
        this.idclient = idclient;
        this.idprodus = idprodus;
        this.nrproduse = nrproduse;
    }

    public int getComandaId() {
        return comandaId;
    }

    public int getIdclient() {
        return idclient;
    }

    public int getIdprodus() {
        return idprodus;
    }

    public int getNrproduse() {
        return nrproduse;
    }

    public void setComandaId(int comandaId) {
        this.comandaId = comandaId;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public void setIdprodus(int idprodus) {
        this.idprodus = idprodus;
    }

    public void setNrproduse(int nrproduse) {
        this.nrproduse = nrproduse;
    }
}
