package com.uninter.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if((requestCode == 123) && (resultCode == RESULT_OK))
        {
            Uri photoUri = data.getData();
            ImageView iv = (ImageView) findViewById(R.id.logotype);
            iv.setImageURI(photoUri);
        }
    }

    public void swapImg(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(intent, 123);
        }
    }

    /**
     * Cool comment by christoph
     * 
     * @param view
     */
    public void login(View view) {
               /* Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Hola mundo");
                sendIntent.setType("text/plain");
                if(sendIntent.resolveActivity(getPackageManager()) != null)
                {
                    startActivity(sendIntent);
                }*/
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:18.957020, -99.234795"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        Toast.makeText(MainActivity.this, "Hola mundo 2", Toast.LENGTH_SHORT).show();

    }
}
