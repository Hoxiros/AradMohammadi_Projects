package ir.kourosh.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private String current = "";
    private String operator = "";
    private double first = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);

        // گرفتن همه دکمه‌ها
        int[] btnIds = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
                R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7,
                R.id.btn8, R.id.btn9, R.id.btnDot
        };

        View.OnClickListener numberListener = v -> {
            Button b = (Button) v;
            current += b.getText().toString();
            tvResult.setText(current);
        };

        for (int id : btnIds) {
            findViewById(id).setOnClickListener(numberListener);
        }

        // عملگرها
        findViewById(R.id.btnAdd).setOnClickListener(v -> setOperator("+"));
        findViewById(R.id.btnSub).setOnClickListener(v -> setOperator("-"));
        findViewById(R.id.btnMul).setOnClickListener(v -> setOperator("*"));
        findViewById(R.id.btnDiv).setOnClickListener(v -> setOperator("/"));

        // مساوی
        findViewById(R.id.btnEq).setOnClickListener(v -> calculate());
    }

    private void setOperator(String op) {
        if (!current.isEmpty()) {
            first = Double.parseDouble(current);
            operator = op;
            current = "";
        }
    }

    private void calculate() {
        if (!current.isEmpty() && !operator.isEmpty()) {
            double second = Double.parseDouble(current);
            double result = 0;
            switch (operator) {
                case "+": result = first + second; break;
                case "-": result = first - second; break;
                case "*": result = first * second; break;
                case "/":
                    if (second != 0) result = first / second;
                    else tvResult.setText("خطا تقسیم بر صفر");
                    break;
            }
            tvResult.setText(String.valueOf(result));
            current = String.valueOf(result);
            operator = "";
        }
    }
}
