//FINAL CODE FOR QR CODE WHICH WILL BE THE SECOND ACTIVITY (SOME CHANGES ARE YET TO BE MADE LIKE REMOVING THE 'GENERATE' BTN ETC. '
package com.sfit.torpid;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.WriterException;
import com.google.zxing.common.StringUtils;

import java.util.Calendar;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import androidmads.library.qrgenearator.QRGSaver;

public class QRCode extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    // private EditText editText;
    private ImageView imageView;
    private QRGEncoder qrgEncoder;
    private Bitmap bitmapResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);

        imageView = (ImageView) findViewById(R.id.QR_Image);
        //   editText = (EditText) findViewById(R.id.edt_value);
        //Button btnStart = (Button) findViewById(R.id.start);
        final Button btnSave = (Button) findViewById(R.id.save);


        //KEWIN is the key, typically a passcode which should be same in both activities. only then the string would be passed. wow.
        Intent i = getIntent();
        Calendar cal = Calendar.getInstance();
        String min1;
        String min = Integer.toString(cal.get(Calendar.MINUTE));
        if(min.length()<2)
            min1 = "0"+min;
        else min1 = min;
        String a = "TIMESTAMP: "+Integer.toString(cal.get(Calendar.HOUR_OF_DAY))+":"+min1+" "+Integer.toString(cal.get(Calendar.DAY_OF_MONTH))+"/"+Integer.toString(cal.get(Calendar.MONTH)+1)+"/"+Integer.toString(cal.get(Calendar.YEAR))+"\nUser ID: "+i.getStringExtra("KEWIN");
        Toast.makeText(this, a, Toast.LENGTH_LONG).show();


        //final String vr = "Hopes held high! Cmon Torpid!";
        //btnStart.setOnClickListener(new View.OnClickListener() {
        //@Override
        //public void onClick(View view) {
        if (a.trim().length() > 0) {

            //calculating bitmap dimension
            WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
            Display display = manager.getDefaultDisplay();
            Point point = new Point();
            display.getSize(point);
            int width = point.x;
            int height = point.y;
            int smallerDimension = width < height ? width : height;
            smallerDimension = smallerDimension * 3 / 4;

            qrgEncoder = new QRGEncoder(a.trim(), null, QRGContents.Type.TEXT, smallerDimension);
            try {
                bitmapResult = qrgEncoder.encodeAsBitmap();
                imageView.setImageBitmap(bitmapResult);
                ///btnSave.setVisibility(View.VISIBLE);
            } catch (WriterException e) {
                Log.v(TAG, e.toString());
            }
        } else {
            //editText.setError("Enter some text");
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean save;
                String result;
                try {
                    String savePath = Environment.getExternalStorageState() + "/Alarms/";
                    save = QRGSaver.save(savePath, "Torpid QR code", bitmapResult, QRGContents.ImageType.IMAGE_PNG);
                    result = save ? "Image Saved" : "Image Not Saved";
                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}