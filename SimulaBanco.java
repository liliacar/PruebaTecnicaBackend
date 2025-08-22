import java.util.Calendar;

import java.util.Date;
import java.util.HashMap;

import org.generation.util.ReciboSaldo;
import org.generation.util.banco.Cuenta;
import org.generation.util.banco.CuentaCredito;
import org.generation.util.banco.CuentaDebito;

public class SimulaBanco {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2025, Calendar.MAY, 1);
		
		Calendar calendarCorte = Calendar.getInstance();
		calendar.set(2025, Calendar.MAY, 31);
		
		HashMap<Integer, Cuenta> cuentas = new HashMap<>();
		
		cuentas.put(1001, new CuentaDebito(2000, "D8001", calendar.getTime(), 1000, "Juan Pérez"));
		cuentas.put(1002, new CuentaCredito(0, "C7001", calendarCorte.getTime(), calendar.getTime(), 0.35f, 3000.00, "María Díaz"));
		cuentas.put(1003, new CuentaDebito(1500, "D8002", calendar.getTime(), 1000, "Jorge Martínez"));
		cuentas.put(1004, new CuentaCredito(0, "C7002", calendarCorte.getTime(),	calendar.getTime(), 0.35f, 4500.00, "Mónica Hernández"));
		
		 ((CuentaDebito) cuentas.get(1001)).deposito(500);   
	     ((CuentaCredito) cuentas.get(1002)).retiro(1000);   
	     ((CuentaDebito) cuentas.get(1003)).retiro(200);     
	     ((CuentaCredito) cuentas.get(1004)).deposito(1500);
		
	     for (Cuenta cuenta : cuentas.values()) {
	            System.out.println(cuenta);
	            ReciboSaldo.Imprimir(cuenta);
	        }//for
		
	}//main
}//class Banco
