package com.ag.timesheet.helper;
 import android.content.Context;  
 import android.os.Handler;  
 import android.os.Message;  
 import android.os.AsyncTask;

 import com.ag.timesheet.activities.SnoopyActivity;

public class Timer extends AsyncTask<Void, Void, Void> {
   Context mContext;  
      private Handler threadHandler;  
   public Timer(Context context,Handler threadHandler) {  
     super();  
     this.threadHandler=threadHandler;  
     mContext = context;  
       }  
   @Override  
      protected Void doInBackground(Void...params) {   
        try {  
                Thread.sleep(SnoopyActivity.PERIOD);
           } catch (InterruptedException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
           }   
        Message.obtain(threadHandler, SnoopyActivity.DONE, "").sendToTarget();
         return null;  
   }  
 }