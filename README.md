# 🏦 Cuentas Bancarias

Proyecto en Java que modela dos tipos de cuentas bancarias — Ahorros y Corriente — con operaciones básicas de depósito, retiro y transferencia. Cada tipo de cuenta tiene reglas propias, como comisiones por saldo bajo o límite de sobregiro.

---

## ¿Qué hace este proyecto?

- Crea cuentas de **Ahorros** y **Corriente** con validaciones al momento de crearlas
- Permite **depositar** y **retirar** dinero con reglas distintas por tipo:
  - Ahorros aplica una **comisión de $5** si el saldo cae por debajo de $100
  - Corriente permite **sobregiro** hasta un límite de -$500
- La cuenta Corriente puede hacer **transferencias** a otras cuentas
- Consulta el saldo actual de cualquier cuenta

---

## Estructura del proyecto

```
CuentasBancarias/
└── src/
    ├── Main.java                    # Punto de entrada y pruebas
    ├── OperacionesBancarias.java    # Interfaz: depositar, retirar, consultarSaldo
    ├── Transferible.java            # Interfaz: transferir
    ├── Ahorros.java                 # Implementa OperacionesBancarias
    └── Corriente.java               # Implementa OperacionesBancarias + Transferible
```

---

## Reglas de negocio

| Cuenta | Comisión | Sobregiro | Transferencias |
|---|---|---|---|
| Ahorros | $5 si saldo < $100 | No permitido | No |
| Corriente | Sin comisión | Hasta -$500 | Sí |

---

## ¿Cómo ejecutarlo en IntelliJ IDEA?

1. Abre **IntelliJ IDEA**
2. Ve a **File → Open** y selecciona la carpeta del proyecto
3. Espera a que IntelliJ indexe el proyecto
4. Abre el archivo `src/Main.java`
5. Haz clic en el botón ▶ verde o presiona `Shift + F10`
6. El resultado aparecerá en la consola de **Run**

---

## Tecnologías

- **Java** — sin librerías externas
- **POO**: interfaces, implementación múltiple, validaciones con excepciones

---

## Autor

| Nombre |
|--------|
| Said Quinto |
