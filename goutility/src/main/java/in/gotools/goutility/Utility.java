package in.gotools.goutility;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.RequiresPermission;

import java.util.regex.Pattern;

/**
 * Go Tools(in.gotools.goutility) <br />
 * Created by <b><a href="http://about.me/SutharRohit">Suthar Rohit</a></b>  <br />
 * on 13/01/2016.
 *
 * @author Suthar Rohit
 */
public class Utility {

    private static final String TAG = "Utility";

    /**
     * This function check <u>Mobile Data</u> or <u>WiFi</u> is switched on or not..<br />
     * It will be return <b>true</b> when switched on and return <b>false</b> when switched off.<br />
     * <br />
     * Created By <b><a href="http://about.me/SutharRohit">Suthar Rohit</a></b>
     *
     * @param context {@link Context} of activity
     * @return true if <u>Mobile Data</u> or <u>WiFi</u> is switched on.
     */
    @RequiresPermission(allOf = {Manifest.permission.INTERNET, Manifest.permission.ACCESS_NETWORK_STATE})
    public static boolean isOnline(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cm.getActiveNetworkInfo();
            return nInfo != null && nInfo.isConnected();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * This function check {@link Package} is Installed or not on current device.<br />
     * It will be return <b>true</b> when package is installed
     * and
     * return <b>false</b> when package is not installed.<br />
     * <br />
     * Created By <b><a href="http://about.me/SutharRohit">Suthar Rohit</a></b>
     *
     * @param activity Current {@link Activity}
     * @param uri      Package Name as {@link String}
     * @return true if package available.
     */
    public static boolean isInstalled(Activity activity, String uri) {
        PackageManager pm = activity.getPackageManager();
        boolean app_installed;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed;
    }

    /**
     * Returns true if the <u>string is not null</u> and <u>length > 0</u>.<br />
     * <br />
     * Created By <b><a href="http://about.me/SutharRohit">Suthar Rohit</a></b>
     *
     * @param str the string to be examined
     * @return true if str is not null and length > 0
     */
    public static boolean isNotNull(String str) {
        return !(str == null || str.equalsIgnoreCase("null") || str.trim().length() == 0);
    }

    /**
     * Check Email Address is valid or not.?<br />
     * <br />
     * Created By <b><a href="http://about.me/SutharRohit">Suthar Rohit</a></b>
     *
     * @param emailAddress {@link String} Email Address
     * @return true if Email Address is valid
     */
    public static boolean checkEmail(String emailAddress) {
        Pattern EMAIL_ADDRESS_PATTERN = Pattern
                .compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        return EMAIL_ADDRESS_PATTERN.matcher(emailAddress).matches();
    }

    /**
     * Check Mobile Number is valid or not.?<br />
     * <br />
     * Created By <b><a href="http://about.me/SutharRohit">Suthar Rohit</a></b>
     *
     * @param mobileNumber {@link String} mobile number
     * @return true if mobile number is valid
     */
    public static boolean checkMobileNumber(String mobileNumber) {
        Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile("^([1-9])*([0-9]{9})$");
        return EMAIL_ADDRESS_PATTERN.matcher(mobileNumber).matches();
    }

    /**
     * Check date is proper in following format : <b>DD MMM, YYYY</b><br />
     * <br />
     * Created By <b><a href="http://about.me/SutharRohit">Suthar Rohit</a></b>
     *
     * @param date {@link String} date time
     * @return true if date is valid
     */
    public static boolean isValidDate(String date) {
        Pattern DATE_PATTERN = Pattern.compile("^([0-9]{2})* ([A-Z,a-z]{3})*(, )([0-9]{4})$");
        return DATE_PATTERN.matcher(date).matches();
    }

    /**
     * Check Device is Tablet ?<br />
     * <br />
     * Created By <b><a href="http://about.me/SutharRohit">Suthar Rohit</a></b>
     *
     * @param context {@link Context} of activity
     * @return true if Current Device is Tablet.
     */
    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

}
