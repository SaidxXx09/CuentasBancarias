public class Corriente implements OperacionesBancarias, Transferible{
    private String numCuenta, titular;
    private double saldo;
    private double sobregiro = - 500;

    public Corriente(String numCuenta, String titular, double saldo) {
        if (numCuenta == null || numCuenta.isEmpty()){
            throw new IllegalArgumentException("Numero de cuenta vacio");
        }
        if (titular == null || titular.isEmpty()){
            throw new IllegalArgumentException("Titular vacio");
        }
        if(saldo < 0){
            throw new IllegalArgumentException("Saldo negativo");
        }
        this.numCuenta = numCuenta;
        this.titular = titular;
        this.saldo = saldo;
    }

    @Override
    public void depositar(double monto) {
        if (monto <= 0){
            throw new IllegalArgumentException("Monto negativo");
        }
        saldo += monto;
        System.out.println("-- DEPOSITO CON EXITO -- ");
        System.out.println("Monto: " + monto + "\nNuevo saldo: " + saldo);
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
            System.out.println("-- TRANSFERENCIA -- " + "\nMonto: " + monto + " Cuenta: " + cuentaDestino);
            return true;
        }
        System.out.println("Transferencia fallada");
        return false;
    }
}
