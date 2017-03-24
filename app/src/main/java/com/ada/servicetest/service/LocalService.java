package com.ada.servicetest.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Ada on 2017/3/24.
 * Desc:绑定服务检点实例——服务器端
 */

public class LocalService extends Service {
    private final static String TAG="LocalService";
    private int count;
    private boolean quite;
    private Thread thread;
    private LocalBinder binder=new LocalBinder();

    /**
     * 创建Binder对象，返回给客户端即Activity使用，提供数据交换的接口
     */
    public class LocalBinder extends Binder{
        //声明一个方法，getService.（提供给客户端调用）
        LocalService getService(){
            //返回当前对象LocalService，这样我们就可在客户端调用Service的公用方法了
            return LocalService.this;
        }

    }

    /**
     * 把Binder类返回给客户端
     * @param intent
     * @return
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"========Service is invoke Created");
        thread=new Thread(new Runnable() {
            @Override
            public void run() {
                //每隔一秒count+1；直到quite为true
                while(!quite){
                    try {
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
