package br.com.local.advanced_httpurlconnection;

import static com.google.android.material.textfield.TextInputLayout.END_ICON_PASSWORD_TOGGLE;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    TextView txtCadLogin;
    TextInputLayout txtUsuario, txtSenha;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtCadLogin = findViewById(R.id.txtCadLogin);

        txtUsuario = findViewById(R.id.txtUsuario);
        txtSenha = findViewById(R.id.txtSenha);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            String usuario, senha;

            usuario = txtUsuario.getEditText().getText().toString();
            senha = txtSenha.getEditText().getText().toString();


            if (TextUtils.isEmpty(usuario)) {
                txtUsuario.setError("Por favor insira o nome do usuário");
                txtUsuario.requestFocus();
            }
            if (TextUtils.isEmpty(senha)) {
                txtSenha.setError("Por favor insira a senha do usuário");
                txtSenha.setPasswordVisibilityToggleEnabled(true);
                txtSenha.requestFocus();
            }

            if (usuario.equals("usuario") && senha.equals("senha")) {
                startActivity(new Intent(getApplicationContext(), MenuPrincipalActivity.class));
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "Usuário ou senha inválidos", Toast.LENGTH_SHORT).show();
            }


        });


        txtCadLogin.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), CadastrarUsuarioActivity.class));
            finish();
        });
    }
}