package com.example.diamondcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private Spinner scope;
    private Spinner sp_jjc;
    private Spinner sp_up;
    private TextView display;
    private EditText grade;
    private Button btn_one;
    private int rank_index;
    private int[] rank_arr={1200,1000,800,600};
    private int grade_index;
    private int[] grade_arr={150,300,450,600};

    private int jjc_index;
    private int[] jjc_arr={45,40,35,30,25,20,18,16,14,12,10};
    private int activities=0;//期间活动所得
    private int[] act_arr={0,0,0,360,360,360,2280,2280,2280,2280,2280,2280,2280,2280,2880};
    private int act_index;
    private int t_grade;//总力战分数
    private long total=0;//石头总量
    int max=-1;
    Date date = new Date();
    Date deaddate;
    Date dateOne;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Activetiy activety[]=new Activetiy[14];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取控件
        scope = findViewById(R.id.sp_total);
        sp_jjc= findViewById(R.id.sp_jjc);
        btn_one=findViewById(R.id.btn_one);
        sp_up=findViewById(R.id.sp_up);
        grade = findViewById(R.id.tv_grade);
        display = findViewById(R.id.tv_display);

        display.setText("你的青辉石预计有："+total);
        //获取总力战档位
        scope.setSelection(3);
        scope.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    rank_index=0;
                }
                else if(position==1){
                    rank_index=1;
                }
                else if(position==2){
                    rank_index=2;
                }
                else if(position==3){
                    rank_index=3;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //获取竞技场数据
        sp_jjc.setSelection(10);
        sp_jjc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    jjc_index=0;
                }
                else if(position==1){
                    jjc_index=1;
                }
                else if(position==2){
                    jjc_index=2;
                }
                else if(position==3){
                    jjc_index=3;
                }
                else if(position==4){
                    jjc_index=4;
                }
                else if(position==5){
                    jjc_index=5;
                }
                else if(position==6){
                    jjc_index=6;
                }
                else if(position==7){
                    jjc_index=7;
                }
                else if(position==8){
                    jjc_index=8;
                }
                else if(position==9){
                    jjc_index=9;
                }
                else if(position==10){
                    jjc_index=10;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //获取目标卡池
        //温泉：5/30-6/7
        //圣诞：6/14-6/28
        //一番胜负：6/28-7/11
        //情人节：7/11-7/24
        //夏莱回忆录：7/11-8/22（7/17拿满）
        //最终篇第一章：7/22
        //第二章：7/24
        //FSCT攻略战：7/24-8/10
        //复刻图书馆：8/10-8/22
        //A.H.A：8/22-9/8
        //第三章：8/22
        //第四章：9/8
        //白亚的预告：10/26-11/10
        //龙武同舟：11/24-12/7
        //P.H.T：9/8-9/22
        //便利屋68：9/22-10/05
        //不忍之心：10/12-10-19
        //甜品部：11/10-11-17
        sp_up.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {



            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                activety[0]=new Activetiy("温泉","2023-05-30",1680);
                activety[1]=new Activetiy("圣诞","2023-06-14",3040);
                activety[2]=new Activetiy("一番胜负","2023-06-28",1540);
                activety[3]=new Activetiy("情人节","2023-07-11",1850);
                activety[4]=new Activetiy("夏莱回忆录","2023-07-11",1200);
                activety[5]=new Activetiy("FSCT攻略战","2023-07-24",6920);
                activety[6]=new Activetiy("图书馆","2023-08-10",1820);
                activety[7]=new Activetiy("A.H.A","2023-08-22",2095);
                activety[8]=new Activetiy("P.H.T","2023-09-08",2600);
                activety[9]=new Activetiy("便利屋68","2023-09-22",1970);
                activety[10]=new Activetiy("不忍之心","2023-10-12",1810);
                activety[11]=new Activetiy("白亚的预告","2023-10-26",1710);
                activety[12]=new Activetiy("甜品部","2023-11-10",2420);
                activety[13]=new Activetiy("龙武同舟","2023-11-24",0);
                if(position==0){
                    //圣诞小护士
                    act_index=position;
                    try{
                        deaddate=dateFormat.parse("2023-06-27");
                    }catch (Exception e){
                        deaddate=null;
                    }
                }
                else if(position==1){
                    //春晴奈
                    act_index=position;
                    try{
                        deaddate=dateFormat.parse("2023-07-11");
                    }catch (Exception e){
                        deaddate=null;
                    }
                }
                else if (position==2){
                    //医院团长
                    act_index=position;
                    try{
                        deaddate=dateFormat.parse("2023-07-25");
                    }catch (Exception e){
                        deaddate=null;
                    }
                }
                else if (position==3){
                    //mika（fes）
                    act_index=position;
                    try{
                        deaddate=dateFormat.parse("2023-08-01");
                    }catch (Exception e){
                        deaddate=null;
                    }

                }
                else if (position==4){
                    //喷火龙
                    act_index=position;
                    try{
                        deaddate=dateFormat.parse("2023-08-11");
                    }catch (Exception e){
                        deaddate=null;
                    }

                }
                else if (position==5){
                    //樱子
                    act_index=position;
                    try{
                        deaddate=dateFormat.parse("2023-08-22");
                    }catch (Exception e){
                        deaddate=null;
                    }

                }
                else if (position==6){
                    //渚
                    act_index=position;
                    try{
                        deaddate=dateFormat.parse("2023-09-05");
                    }catch (Exception e){
                        deaddate=null;
                    }

                }
                else if (position==7){
                    //小雪
                    act_index=position;
                    try{
                        deaddate=dateFormat.parse("2023-09-19");
                    }catch (Exception e){
                        deaddate=null;
                    }

                }
                else if (position==8){
                    //正月便利屋
                    act_index=position;
                    try{
                        deaddate=dateFormat.parse("2023-10-03");
                    }catch (Exception e){
                        deaddate=null;
                    }

                }
                else if (position==9){
                    //小狐狸
                    act_index=position;
                    try{
                        deaddate=dateFormat.parse("2023-10-10");
                    }catch (Exception e){
                        deaddate=null;
                    }
                }
                else if (position==10){
                    //伊吕波
                    act_index=position;
                    try{
                        deaddate=dateFormat.parse("2023-10-17");
                    }catch (Exception e){
                        deaddate=null;
                    }

                }
                else if (position==11){
                    //斯大萝
                    act_index=position;
                    try{
                        deaddate=dateFormat.parse("2023-10-24");
                    }catch (Exception e){
                        deaddate=null;
                    }

                }
                else if (position==12){
                    //女仆爱丽丝
                    act_index=position;
                    try{
                        deaddate=dateFormat.parse("2023-11-07");
                    }catch (Exception e){
                        deaddate=null;
                    }

                }
                else if (position==13){
                    //宇泽玲纱
                    act_index=position;
                    try{
                        deaddate=dateFormat.parse("2023-11-14");
                    }catch (Exception e){
                        deaddate=null;
                    }
                }
                else if (position==14){
                    //水梓
                    act_index=position;
                    try{
                        deaddate=dateFormat.parse("2023-11-21");
                    }catch (Exception e){
                        deaddate=null;
                    }

                }

                long days=0;
                do{
                    max++;
                    try {
                        dateOne=dateFormat.parse(activety[max].getTime());
                    }catch (Exception e){
                        dateOne=null;
                    }
                   days=((deaddate.getTime()-dateOne.getTime())/(1000*60*60*24));

                }while (days>0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //点击计算开始
        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total=0;
                activities=0;
                t_grade=Integer.parseInt(grade.getText().toString());
                if(t_grade>=4000000){
                    grade_index=0;
                }
                if(t_grade>=10000000){
                    grade_index=1;
                }
                if(t_grade>=26000000){
                    grade_index=2;
                }
                if(t_grade>=47000000){
                    grade_index=3;
                }
                //算活动累计奖励
                long days = ((deaddate.getTime()-date.getTime())/(1000*60*60*24));
                for(int i=0;i<max;i++){
                    try {
                        dateOne=dateFormat.parse(activety[i].getTime());
                    }catch (Exception e){
                        dateOne=null;
                    }
                    long days1=((dateOne.getTime()-date.getTime())/(1000*60*60*24));
                    if(days1>0) {
                        activities += activety[i].getValue();
                        System.out.println("活动"+i+"的奖励有："+activety[i].getValue());
                        System.out.println("活动"+i+"被执行，此时activities为："+activities);
                    }
                }
                activities+=act_arr[act_index];
                total=days*jjc_arr[jjc_index]+grade_arr[grade_index]*(days/21)+activities+rank_arr[rank_index]*(days/21)+150*(days/10);
                //display.setText("total="+total+"\ndays*day_jjc="+days*jjc_arr[jjc_index]+"\ntotal_grade="+grade_arr[grade_index]*(days/21)+"\nactivities="+activities+"\ntotal_rank="+rank_arr[rank_index]*(days/21)+"\n"+150*(days/10));
                display.setText("到该池子结束还有"+days+"天。\n你的青辉石预计有："+total);
            }
        });
    }

    public void flush(View view) {
        finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}