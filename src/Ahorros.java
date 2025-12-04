public class Ahorros implements OperacionesBancarias{
    private String numCuenta, titular;
    private double saldo;

    public Ahorros(String numCuenta, String titular, double saldo) {
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
        if (monto <0){
            throw new IllegalArgumentException("Monto negativo");
        }
        saldo += monto;
        System.out.println("-- DEPOSITO CON EXITO -- ");
        System.out.println("Monto: " + monto + "\nNuevo saldo: " + saldo);
    }

    @Override
    public boolean retirar(double monto) {
        if (monto < 0) {
            throw new IllegalArgumentException("Monto negativo");
        }
        if (saldo >= monto) {
            saldo -= monto;
            if (saldo < 100) {
                saldo -= 5;
                System.out.println("Comisión aplicada: $5.0");
            }
            return true;
        }
        return false;
    }


    @Override
    public double consultarSaldo() {
        return saldo;
    }
}
