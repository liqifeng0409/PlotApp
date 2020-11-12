package cn.edu.bistu.se.android.plotapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtFunction=null;
    CustomView customView=null;
    String strFunction="";
    String str="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtFunction=(TextView)findViewById(R.id.txtFunction);
        customView=(CustomView)findViewById(R.id.plotview);
        Button buttonPlot=(Button)findViewById(R.id.buttonPlot);
        Button buttonBig=(Button)findViewById(R.id.buttonBig);
        Button buttonSmall=(Button)findViewById(R.id.buttonSmall);
        Button buttonClear=(Button)findViewById(R.id.buttonClear);
        customView.setStrFunction("");
        customView.setStr("");
        customView.setLargen(0.5);
        customView.invalidate();
        buttonPlot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(customView!=null){
//                    String strFunction=txtFunction.getText().toString();
                    if(strFunction=="")
                        strFunction=txtFunction.getText().toString();
                    else {
                        str = strFunction;
                        strFunction = txtFunction.getText().toString();
                    }
                    customView.setStrFunction(strFunction);
                    customView.setStr(str);

                    customView.invalidate();
                }
            }
        });

        buttonBig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(customView!=null){
//                    String strFunction=txtFunction.getText().toString();
//                    customView.setStrFunction(strFunction);
                    if(customView.getLargen()<=1 && customView.getLargen()-0.2>=0.2) {
                        customView.setLargen(customView.getLargen()-0.2);
                        if(customView.getLargen()<=0.5)
                            customView.setChange(2);
                        customView.invalidate();
                    }
                    else {
                        customView.setLargen(0.2);
                        customView.invalidate();
                        Toast.makeText(MainActivity.this, "不能再放大", Toast.LENGTH_LONG).show();

                    }
                }
            }
        });
        buttonSmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(customView!=null){
//                    String strFunction=txtFunction.getText().toString();
//                    customView.setStrFunction(strFunction);
                    if(customView.getLessen()>=1 && customView.getLessen()+0.2<=1.2) {
                        customView.setLessen(customView.getLessen()+0.2);
                        customView.invalidate();
                    }
                    else if(customView.getLargen()<1){
                        customView.setLargen(customView.getLargen()+0.2);
                        customView.invalidate();
                    }
                    else {
                        customView.setLessen(1.2);
                        customView.invalidate();
                        Toast.makeText(MainActivity.this, "不能再缩小", Toast.LENGTH_LONG).show();

                    }
                }
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(customView!=null){
                    str="";
                    strFunction="";
                    customView.setStrFunction("");
                    customView.setStr("");
                    customView.invalidate();
                }
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.meau, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        switch (id) {
            case R.id.Help:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("这是一个帮助");
                builder.setTitle("HELP");
                builder.show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}