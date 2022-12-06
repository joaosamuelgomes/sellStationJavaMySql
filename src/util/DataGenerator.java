package util;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;

/**
 *
 * @author Joao Samuel Gomes
 */
public class DataGenerator {
    
    public java.sql.Date corverterDataParaDateUS(Date pData) throws Exception {
        SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy/MM/dd");
        String dataString = formatarDate.format(pData);
        if (pData == null || pData.equals(""))
            return null;
        
        java.sql.Date date = null;
        
        try{
            DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            date = new java.sql.Date( ((java.util.Date)formatter.parse(dataString)).getTime());
        } catch (ParseException e) {
            throw e;
        }
        return date;
    }
}
