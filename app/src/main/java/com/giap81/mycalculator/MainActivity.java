package com.giap81.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView tvInPut;
    private TextView tvOutPut;
    private ArrayList<Double> arrNumInPut =new ArrayList<Double>();
    private ArrayList<String> arrMathInput = new ArrayList<String>();
    private String strInput;
    private int indexMath = 0;
    private Double result = 0.0;
    private boolean addZezo = false;
    private ListView lvResult;
    private  ArrayList<String> arrResult = new ArrayList<String>();
    private void addText(String txt, boolean addzz){
        if(strInput == null)
            strInput = txt;
        else
        {
            if(!addZezo)
            {
                StringBuilder str = new StringBuilder(strInput);
                str.setCharAt(strInput.length()-1,txt.charAt(0));
                strInput = str.toString();
            }
            else
                strInput = strInput + txt;
        }
        addZezo =addzz;
        tvInPut.setText(strInput);
    }
    private void addTextMath(String txt)
    {
        if(strInput == null)
            strInput = "0" + txt;
        else
        if(strInput.charAt(strInput.length()-1) == '+' || strInput.charAt(strInput.length()-1) == '-' || strInput.charAt(strInput.length()-1) == 'x' || strInput.charAt(strInput.length()-1) == '/'|| strInput.charAt(strInput.length()-1) == ',')
        {
            StringBuilder str = new StringBuilder(strInput);
            str.setCharAt(strInput.length()-1,txt.charAt(0));
            strInput = str.toString();
        }
        else
            strInput = strInput + txt;
        addZezo = true;
        indexMath = strInput.length()-1;
        tvInPut.setText(strInput);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInPut = (TextView)findViewById(R.id.tvInPut);
        tvOutPut = (TextView)findViewById(R.id.tvOutPut);
        Button btnNum1 = (Button)findViewById(R.id.btnNum1);
        Button btnNum2 = (Button)findViewById(R.id.btnNum2);
        Button btnNum3 = (Button)findViewById(R.id.btnNum3);
        Button btnNum4 = (Button)findViewById(R.id.btnNum4);
        Button btnNum5 = (Button)findViewById(R.id.btnNum5);
        Button btnNum6 = (Button)findViewById(R.id.btnNum6);
        Button btnNum7 = (Button)findViewById(R.id.btnNum7);
        Button btnNum8 = (Button)findViewById(R.id.btnNum8);
        Button btnNum9 = (Button)findViewById(R.id.btnNum9);
        Button btnNum0 = (Button)findViewById(R.id.btnNum0);
        Button btnSum = (Button)findViewById(R.id.btnSum);
        Button btnSub = (Button)findViewById(R.id.btnSub);
        Button btnMultip = (Button)findViewById(R.id.btnMultip);
        Button btnDivis = (Button)findViewById(R.id.btnDivis);
        Button btnDec = (Button)findViewById(R.id.btnDec);
        Button btnClear = (Button)findViewById(R.id.btnClear);
        Button btnAllClear = (Button)findViewById(R.id.btnAllClear);
        Button btnResult = (Button)findViewById(R.id.btnResult);
        Button btnDelResult = (Button)findViewById(R.id.btnDelResult);
        lvResult = (ListView)findViewById(R.id.lvResult);

        btnNum1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addText("1", true);
            }
        });
        btnNum2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addText("2", true);
            }
        });
        btnNum3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addText("3", true);
            }
        });
        btnNum4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addText("4", true);
            }
        });
        btnNum5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addText("5", true);
            }
        });
        btnNum6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addText("6", true);
            }
        });
        btnNum7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addText("7", true);
            }
        });
        btnNum8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addText("8", true);
            }
        });
        btnNum9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addText("9", true);
            }
        });
        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTextMath("+");
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTextMath("-");
            }
        });
        btnMultip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTextMath("x");
            }
        });
        btnDivis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTextMath("/");
            }
        });
        btnDelResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrResult =new ArrayList<String>();
                lvResult.setAdapter(null);
            }
        });
        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(strInput == null)
                    strInput = "0,";
                else
                {
                    if(strInput.charAt(strInput.length()-1) == '+' || strInput.charAt(strInput.length()-1) == '-' || strInput.charAt(strInput.length()-1) == 'x' || strInput.charAt(strInput.length()-1) == '/')
                    {
                        strInput = strInput + "0,";
                    }
                    else
                    {
                        String str;
                        if(indexMath==0)
                            str = strInput.substring(indexMath,strInput.length());
                        else
                            str = strInput.substring(indexMath-1,strInput.length());
                        if(str.indexOf(",")==-1)
                            strInput = strInput + ",";
                    }
                }
                addZezo = true;
                tvInPut.setText(strInput);
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(strInput!=null)
                {
                    if(strInput.charAt(strInput.length()-1) == '+' || strInput.charAt(strInput.length()-1) == '-' || strInput.charAt(strInput.length()-1) == 'x' || strInput.charAt(strInput.length()-1) == '/')
                    {
                        int flg = 0;
                        for(int i=0;i< strInput.length()-1; i++)
                        {
                            if(strInput.charAt(i)== '+'||strInput.charAt(i)== '-'||strInput.charAt(i)== 'x'||strInput.charAt(i)== '/')
                                flg = i;
                        }
                        indexMath = flg;
                    }
                    strInput = strInput.substring(0,strInput.length()-1);
                    if(strInput.length()==0) {
                        indexMath =0;
                        strInput = null;
                        tvInPut.setText("0");
                    }
                    else
                        tvInPut.setText(strInput);
                }
                else
                {
                    indexMath =0;
                    strInput = null;
                    tvInPut.setText("0");
                }
            }
        });
        btnAllClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    strInput = null;
                    indexMath =0;
                    addZezo = true;
                    result=0.0;
                    tvInPut.setText("0");
                    tvOutPut.setText("=0");
                    arrNumInPut = new ArrayList<Double>();
                    arrMathInput = new ArrayList<String>();
            }
        });
        btnNum0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(strInput == null)
                {
                    tvInPut.setText("0");
                }
                else
                {
                    if(addZezo)
                    {
                        strInput = strInput + "0";
                        String str1;
                        String str2;
                        if(indexMath ==0)
                        {
                             str1 = strInput.substring(indexMath,strInput.length());
                             str2 = strInput.substring(indexMath,indexMath+1);
                        }
                        else
                        {
                            str1 = strInput.substring(indexMath+1,strInput.length());
                            str2 = strInput.substring(indexMath+1,indexMath+2);
                        }
                        if(str1.indexOf(",") !=-1)
                            addZezo =true;
                        else
                        {
                            if (Integer.parseInt(str2) !=0)
                                addZezo =true;
                            else
                                addZezo =false;
                        }

                    }
                    tvInPut.setText(strInput);
                }
            }
        });
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int pointSta = 0;
                int pointSto = 0;
                if(strInput != null)
                {
                    if(strInput.charAt(strInput.length()-1)=='+' || strInput.charAt(strInput.length()-1)=='-'||strInput.charAt(strInput.length()-1)=='x'||strInput.charAt(strInput.length()-1)=='/'||strInput.charAt(strInput.length()-1)==',')
                    {
                        strInput = strInput.substring(0,strInput.length()-1);
                        tvInPut.setText(strInput);
                    }
                    for(int i = 0; i < strInput.length(); i++)
                    {
                        if(strInput.charAt(i)=='+' || strInput.charAt(i)=='-'||strInput.charAt(i)=='x'||strInput.charAt(i)=='/')
                        {
                            pointSto = i;
                            arrNumInPut.add(Double.parseDouble(strInput.substring(pointSta,pointSto).replace(",",".")));
                            arrMathInput.add(String.valueOf(strInput.charAt(i)));
                            pointSta = i + 1;
                        }
                        if(i==strInput.length()-1)
                        {
                            pointSto = i+1;
                            arrNumInPut.add(Double.parseDouble(strInput.substring(pointSta,pointSto).replace(",",".")));
                            pointSta = 0;
                            pointSto = 0;
                            addZezo =false;
                            indexMath = 0;
                        }
                    }
                    if(arrMathInput.size()==0)
                    {
                        tvOutPut.setText("=" + arrNumInPut.get(0).toString());
                        strInput = null;
                        arrNumInPut = new ArrayList<Double>();
                        arrMathInput = new ArrayList<String>();
                        result=0.0;
                        return;
                    }
                    for(int i =0; i< arrMathInput.size() ; i++)
                    {
                        if(arrMathInput.get(i).charAt(0) =='x')
                        {
                            Double fg = arrNumInPut.get(i)*arrNumInPut.get(i+1);
                            arrNumInPut.set(i,0.0);
                            arrNumInPut.set(i+1,fg);
                            if(i!=0)
                            {
                                if(arrMathInput.get(i-1).charAt(0)=='-')
                                    arrMathInput.set(i,"-");
                                else
                                    arrMathInput.set(i,"+");
                            }
                            else
                                arrMathInput.set(i,"+");
                        }
                        if(arrMathInput.get(i).charAt(0) =='/')
                        {
                            Double fg1 = arrNumInPut.get(i)/arrNumInPut.get(i+1);
                            arrNumInPut.set(i,0.0);
                            arrNumInPut.set(i+1,fg1);
                            if(i!=0)
                            {
                                if(arrMathInput.get(i-1).charAt(0)=='-')
                                    arrMathInput.set(i,"-");
                                else
                                    arrMathInput.set(i,"+");
                            }
                            else
                                arrMathInput.set(i,"+");
                        }
                    }
                    for(int j =0 ; j< arrMathInput.size() ; j++)
                    {
                        if(j==0)
                        {
                            result = arrNumInPut.get(j);
                        }
                        if(arrMathInput.get(j).charAt(0) =='+')
                            result = result+arrNumInPut.get(j+1);
                        if(arrMathInput.get(j).charAt(0) =='-')
                            result = result-arrNumInPut.get(j+1);
                    }
                    String displayRes = "0";

                    if(Long.parseLong(result.toString().split("\\.")[1])!=0)
                        displayRes = "=" + result.toString().replace(".",",");
                    else
                        displayRes ="=" + result.toString().split("\\.")[0];
                                tvOutPut.setText(displayRes);
                    String res = strInput + displayRes;
                    arrResult.add(res);
                    ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,arrResult);
                    lvResult.setAdapter(arrayAdapter);
                    strInput = null;
                    arrNumInPut = new ArrayList<Double>();
                    arrMathInput = new ArrayList<String>();
                    result=0.0;
                }
                else
                {
                    tvInPut.setText("0");
                    tvOutPut.setText("=0");
                }
            }
        });
        lvResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String val = parent.getAdapter().getItem(position).toString().split("\\=")[1];
                if(strInput == null || strInput.charAt(strInput.length()-1)=='+' || strInput.charAt(strInput.length()-1)=='-'||strInput.charAt(strInput.length()-1)=='x'||strInput.charAt(strInput.length()-1)=='/')
                {
                    if(strInput != null)
                        strInput = strInput+val;
                    else
                        strInput = val;
                    tvInPut.setText(strInput);
                }

            }
        });
    }
}