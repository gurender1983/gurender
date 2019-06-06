package com.APB.Appium.TestUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

import org.openqa.selenium.internal.FindsById;

import android.R;

import android.app.Application;
import android.app.Fragment;
import android.content.ContentResolver;
import android.content.Context;

//import com.beust.jcommander.JCommander.Builder;

import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.widget.TextView;
import io.appium.java_client.Setting;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

public class DeviceDetail  extends Fragment{
	
	TextView textview;
	
	public   void deviceDetail()
	{
		/*StringBuilder builder = new StringBuilder();
		
		//builder.append("android : ").append(Build.VERSION.RELEASE);
		
		builder.append("android : ").append(Build.)*/
		
//		StringBuilder builder = new StringBuilder();
//        builder.append("android: ").append(Build.VERSION.RELEASE);
//
//        Field[] fields = Build.VERSION_CODES.class.getFields();
//        for (Field field : fields) {
//            String fieldName = field.getName();
//            int fieldValue = -1;
//
//            try {
//                fieldValue = field.getInt(new Object());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            if (fieldValue == Build.VERSION.SDK_INT) {
//                builder.append(", ").append(fieldName).append(", ");
//                builder.append("sdk=").append(fieldValue);
//            }
//       }
//        return builder.toString();
		
		

	}
	
	public static String getDeviceId()
	{
		StringBuilder deviceBuilder = new StringBuilder();
		String command ="adb devices";
		InputStream deviceStream = null;
		try 
		{
			Process child = Runtime.getRuntime().exec(command);
			deviceStream = child.getInputStream();
            int streamChunk;
			while((streamChunk =deviceStream.read()) != -1)
			{
				deviceBuilder.append((char)streamChunk);
			}
			deviceStream.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		//System.out.println(""+deviceBuilder.toString());
		
		String device_id_string = deviceBuilder.toString();
		String[] device_id= device_id_string.split("\\s");
		
		//System.out.println(""+device_id[0].toString());
		
		
		return deviceBuilder.toString();		
	}

	/*
	public String getUUID(Context context) {
		return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
	}*/
	
	public void onCreate(Bundle savedInstanceState)
	{
		//super.onCreate(savedInstanceState);
		
		//textview = (TextView)findViewById(R.id.text1);
		
		//String id = Settings.Secure.getString(, Settings.Secure.ANDROID_ID);
		
	}
}
