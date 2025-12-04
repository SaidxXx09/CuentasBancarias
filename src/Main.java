public class Main {
    public static void main(String[] args) {
        try {
            Ahorros a = new Ahorros("1234", "Said", 200);
            Corriente c = new Corriente("5678", "Said", 1000);

            System.out.println("=== CUENTA DE AHORROS ===");
            a.depositar(300);
            a.retirar(450);

            System.out.println("\n=== CUENTA CORRIENTE ===");
            c.retirar(1200); // usa sobregiro
            c.transferir(300, "9876");

            System.out.println("\n=== SALDOS FINALES ===");
            System.out.println("Cuenta Ahorros: $" + a.consultarSaldo());
            System.out.println("Cuenta Corriente: $" + c.consultarSaldo());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
