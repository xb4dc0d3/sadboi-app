package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NetworkReceiver extends BroadcastReceiver {

    Toast mToast;
    String currentStatus = "";

    @Override
    public void onReceive(final Context context, final Intent intent) {
        String status = NetworkStatus.getConnectivityStatusString(context);

        if (mToast != null) {
            mToast.cancel();
        }

        if (!currentStatus.equals(status)) {
            mToast = Toast.makeText(context, status, Toast.LENGTH_LONG);
            mToast.show();
            currentStatus = status;
        }
    }
}
