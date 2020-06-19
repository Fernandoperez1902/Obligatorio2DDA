package utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ManejoDeFechas {

    public static Date tomarFechaSistema() {
        return new Date();
    }

    public static String formatearFecha(Date d, String formato) {
        if (formato == null) {
            formato = "dd/MM/yyyy HH:mm:ss EEEE";
        }
        SimpleDateFormat sdf
                = new SimpleDateFormat(formato);
        return sdf.format(d);

    }

    public static String formatearFecha(Date d) {
        return formatearFecha(d, null);
    }

    public static Date stringAfecha(String fecha, String formato) {
        if (formato == null) {
            formato = "dd/MM/yyyy";
        }
        SimpleDateFormat fSimple
                = new SimpleDateFormat(formato);

        Date retorno = null;
        try {
            retorno = fSimple.parse(fecha);
        } catch (ParseException e) {

        }
        return retorno;
    }

    public static Date stringAfecha(String fecha) {
        return stringAfecha(fecha, null);
    }

    public static Date crearFecha(int dia, int mes, int anio) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.set(Calendar.YEAR, anio);
        cal.set(Calendar.MONTH, mes);//enero=0 diciembre=11
        cal.set(Calendar.DAY_OF_MONTH, dia);
		//Nota: con el metodo get (y las constantes) 
        //se obtienen los valores de un calendar
        return cal.getTime();
    }

    public static long tiempoEnMilisegundos(Date d) {
        return d.getTime();
    }

    public static Date tomarFechaSistemaSinHora() {
        GregorianCalendar cal = new GregorianCalendar();
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        return cal.getTime();
    }
}
