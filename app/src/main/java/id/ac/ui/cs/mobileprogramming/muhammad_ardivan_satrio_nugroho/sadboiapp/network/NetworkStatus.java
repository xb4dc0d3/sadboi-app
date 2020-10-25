package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkStatus {

    public static int NOT_CONNECTED = 0;
    public static int WIFI = 1;
    public static int MOBILE = 2;

    @Deprecated
    public static int getConnectivityStatus(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (null != activeNetwork) {
            if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
                return WIFI;
            if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
                return MOBILE;
        }
        return NOT_CONNECTED;
    }

    public static String getConnectivityStatusString(Context context) {
        int conn = NetworkStatus.getConnectivityStatus(context);
        String status = null;
        if (conn == NetworkStatus.WIFI || conn == NetworkStatus.MOBILE) {
             status = "Data connection is detected";
        }
        else if (conn == NetworkStatus.NOT_CONNECTED) {
            status = "No internet connection";
        }
        return status;
    }
}
