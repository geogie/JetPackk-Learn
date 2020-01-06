package cn.george.mylearn.customLiveData;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.util.Log;

import androidx.lifecycle.LiveData;

import java.lang.ref.WeakReference;

/**
 * Created By George
 * Description:
 * 继承LiveData-->资源共享
 * 单例类
 * 通过onActivity()和onInactive()中注册和反注册Wifi信号强度的广播
 * 通过observe()方法添加观察者对象，订阅Wifi信号强度变化。
 */
public class MyLiveData extends LiveData<Integer> {
    private static final String TAG = "MyLiveData-";
    private static MyLiveData sData;
    private WeakReference<Context> mContextWeakReference;

    public static MyLiveData getInstance(Context context){
        if (sData==null){
            sData = new MyLiveData(context);
        }
        return sData;
    }

    private MyLiveData(Context context){
        mContextWeakReference = new WeakReference<>(context);
    }

    @Override
    protected void onActive() {
        super.onActive();
        registerReceiver();
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        unregisterReceiver();
    }

    private void registerReceiver(){
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.RSSI_CHANGED_ACTION);
        mContextWeakReference.get().registerReceiver(mReceiver,intentFilter);
    }

    private void unregisterReceiver(){
        mContextWeakReference.get().unregisterReceiver(mReceiver);
    }

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Log.d(TAG,"action = "+action);
            if (WifiManager.RSSI_CHANGED_ACTION.equals(action)){
                int wifiRssi = intent.getIntExtra(WifiManager.EXTRA_NEW_RSSI,-200);// 新的网络参与进来
                int wifiLevel = WifiManager.calculateSignalLevel(wifiRssi,4);
                sData.setValue(wifiLevel);
            }
        }
    };
}
