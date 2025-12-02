public class Corriente implements OperacionesBancarias, Transferible{
    private String numCuenta, titular;
    private double saldo;
    private double sobregiro = - 500;

    public Corriente(String numCuenta, String titular, double saldo, double sobregiro) {
        if (numCuenta == null || numCuenta.isEmpty()){
            throw new IllegalArgumentException("Numero de cuenta vacio");
        }
        if (titular == null || titular.isEmpty()){
            throw new IllegalArgumentException("Titular vacio");
        }
        if(saldo < 0){
            throw new IllegalArgumentException("Saldo negativo");
        }
        if(sobregiro < 0){
            throw new IllegalArgumentException("Sobregiro negativo");
        }
        this.numCuenta = numCuenta;
        this.titular = titular;
        this.saldo = saldo;
        this.sobregiro = sobregiro;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSobregiro() {
        return sobregiro;
    }

    public void setSorbegiro(double sobregiro) {
        this.sobregiro = sobregiro;
    }

    @Override
    public void depositar(double monto) {
        if (monto <= 0){
            throw new IllegalArgumentException("Monto negativo");
        }
        System.out.println("Monto despositado con exito");
        saldo += monto;
    }

    @Override
    public boolean retirar(double monto) {
        if (monto <= 0){
            throw new IllegalArgumentException("Monto negativo");
        }
        double saldito = saldo - monto;
        if(saldito < sobregiro){
            System.out.println("Limite excedido de sobregiro");
            return false;
        }
        saldo = saldito;
        return true;
    }

    @Override
    public double consultarSaldo() {
        return saldo;
    }

    @Override
    public boolean transferir(double monto, String cuentaDestino) {
        if(retirar(monto)){

        }
    }
}
