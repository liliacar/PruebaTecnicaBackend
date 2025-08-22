package org.generation.util.banco;

import java.util.Date;

public class CuentaCredito extends Cuenta {
    private double limite;
    private double tasa;
    private Date fechaCorte;
    private Date fechaLimitePago;

    public CuentaCredito(double saldo, String numeroCliente, Date fechaApertura,
                         String nombreCliente, double limite, double tasa,
                         Date fechaCorte, Date fechaLimitePago) {
        super(saldo, numeroCliente, fechaApertura, nombreCliente);
        this.limite = limite;
        this.tasa = tasa;
        this.fechaCorte = fechaCorte;
        this.fechaLimitePago = fechaLimitePago;
    }

    public double getLimite() { return limite; }
    public void setLimite(double limite) { this.limite = limite; }

    public double getTasa() { return tasa; }
    public void setTasa(double tasa) { this.tasa = tasa; }

    public Date getFechaCorte() { return fechaCorte; }
    public void setFechaCorte(Date fechaCorte) { this.fechaCorte = fechaCorte; }


    @Override
    public double getSaldo() {
        saldo -= 3; 
        return saldo;
    }

    @Override
    public double retiro(double cantidad) {
        if ((limite - saldo) >= cantidad) {
            double comision = cantidad * 0.05;
            saldo += cantidad + comision;
        } else {
            saldo += 5; 
        }
        return saldo;
    }

    @Override
    public double deposito(double cantidad) {
        saldo -= cantidad;
        return saldo;
    }

    @Override
	public String toString() {
		return "Cuenta Crédito [" + super.toString() +
				" Tasa=" + getTasa() + "%, Límite="
				+ getLimite() + "]";
	}//toString

}
