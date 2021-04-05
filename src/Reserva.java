import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Stream;

public class Reserva {
    private int idReserva;
    private Date dataReserva;
    public ArrayList<Integer> listMesas = new ArrayList<Integer>();
    private int nPessoas;
    private String CPFReservista;

    public void geraReserva(Reserva reserva) {
    }

    public int getIdReserva() {
        return this.idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Date getDataReserva() {
        return this.dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    public int getnPessoas() {
        return this.nPessoas;
    }

    public void setnPessoas(int nPessoas) {
        this.nPessoas = nPessoas;
    }

    public String getCPFReservista() {
        return this.CPFReservista;
    }

    public void setCPFREservista(String CPF) {
        this.CPFReservista = CPF;
    }
}
