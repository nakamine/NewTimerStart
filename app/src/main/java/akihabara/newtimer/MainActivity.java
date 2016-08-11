package akihabara.newtimer;



        import android.os.Bundle;
        import android.os.CountDownTimer;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //MainActivityクラスの直下は、変数の宣言エリアです。
    EditText nanPun;								//EditText型の変数 "nanPun" を宣言(EditTextは画面から文字を入力するエリア)
    String nFunDayo;								//String(文字列)型の変数 "nFunDayo" を宣言
    int nFun =0;									//int(整数)型の変数 "nFun" を宣言
    Long byou;										//Long(数値)型の変数 "byou" を宣言
    MyCountDownTimer taimaa;				//MyCountDownTimer型の変数 "taimaa" を宣言

    ImageView iv00;
    ImageView iv01;
    ImageView iv02;
    ImageView iv03;
    ImageView iv04;
    ImageView iv05;

    @Override
    protected void onCreate(Bundle savedInstanceState) {		//アプリ起動時の動作を定義
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);						// activity_mainレイアウトを画面に表示

        nanPun = (EditText) findViewById(R.id.editText1);			// EditText型の変数 "nanPun" をレイアウト上のeditText1に紐付け

        iv00 = (ImageView)findViewById(R.id.imageView);
        iv01 = (ImageView)findViewById(R.id.imageView2);
        iv02 = (ImageView)findViewById(R.id.imageView3);
        iv03 = (ImageView)findViewById(R.id.imageView4);
        iv04 = (ImageView)findViewById(R.id.imageView5);
        iv05 = (ImageView)findViewById(R.id.imageView6);

    }

    public void onClickStart(View v) {						//[Start]ボタンタップ時の動作を定義
        nFunDayo = nanPun.getText().toString();			//nanPunに入力された内容を文字列として取得し、nFunDayoに格納

        nFun = Integer.parseInt(nFunDayo);				//nFunDayo (String) を整数に変換してnFun (int) に格納
        taimaa = new MyCountDownTimer(nFun * 1000, 1000);	        //デバッグ用。本来は "分" を "秒" に解釈（" * 60" が無い）
        //taimaa = new MyCountDownTimer(nFun * 60 * 1000, 1000);	//実行用

        taimaa.start();        										// カウントダウン開始
        iv00.setImageResource(R.drawable.kiri1);
        iv01.setImageResource(R.drawable.kiri2);
        iv02.setImageResource(R.drawable.honoka1);
        iv03.setImageResource(R.drawable.ikuno1);
        iv04.setImageResource(R.drawable.ikuno2);
        iv05.setImageResource(R.drawable.tougenkyo);
    }

    public void onClickCancel(View v) {		     			//[Cansel]ボタンタップ時の動作を定義
        taimaa.cancel();											// カウントダウン中止
        nanPun.setText("0");							 // 設定した時間を改めて表示する
    }

    public class MyCountDownTimer extends CountDownTimer{			// "MyCountDownTime" メソッド の動作を定義:開始

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {	           							 // カウントダウン完了後の処理を定義
      //      nanPun.setText(nFunDayo);							 // 設定した時間を改めて表示する
            nanPun.setText("0");							 // 設定した時間を改めて表示する
            Toast.makeText(getApplicationContext(), "時間です♪", Toast.LENGTH_LONG).show();	//ポップアップ画面にメッセージ表示
        }

        @Override
        public void onTick(long millisUntilFinished) {            // インターバル(countDownInterval)毎に実行される処理を定義
            byou = millisUntilFinished/1000;
            nanPun.setText(Long.toString(byou/60) + ":" + Long.toString(byou%60));
        }
    }																						// "MyCountDownTime" メソッド の動作を定義:終了
}



/*
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
*/