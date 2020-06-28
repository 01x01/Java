/*
 * @Description: Date and Calendar
 * @author: johnw;
 * @Created: 6/28/2020;
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeTest {
    public static void main(String[] args) {
        /*
        * Calendar 只能通过 getInstance 获取
        * 因为getInstance 只能获取当前时间，如果要设置时间，我们需要清除当前时间
        *
        * */
        Calendar c = Calendar.getInstance();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getTime()));
        // 设置时间
        c.clear();
        c.set(Calendar.YEAR, 2020);

        // Date
        Date d = new Date();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(d));
    }
}
