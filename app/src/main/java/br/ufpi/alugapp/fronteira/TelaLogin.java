package br.ufpi.alugapp.fronteira;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.ufpi.alugapp.R;
import br.ufpi.alugapp.controle.Fachada;
import br.ufpi.alugapp.entidades.Cliente;
import br.ufpi.alugapp.entidades.Corretor;
import br.ufpi.alugapp.entidades.Usuario;

public class TelaLogin extends AppCompatActivity {

    private Fachada controles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        this.controles = new Fachada();
    }

    public void login(View view){

        EditText edtUsuario = ((EditText) findViewById(R.id.edtUsuario));
        EditText edtSenha = ((EditText) findViewById(R.id.edtSenha));

        String usuario = edtUsuario.getText().toString();
        String senha = edtSenha.getText().toString();

        Usuario user = controles.controladorUsuarios.login(usuario, senha);

        if(user != null && (usuario != "" && senha != "")){

            Intent intent;

            if(user instanceof Cliente){
                intent  = new Intent(this, TelaCliente.class);
            }else if(user instanceof Corretor){
                intent = new Intent(this, TelaCorretor.class);
            }else{
                intent  = new Intent(this, TelaDonoImobiliaria.class);
            }

            intent.putExtra("user", user);
            startActivity(intent);

        }else{
            Toast.makeText(this, "Usuário ou senha inválido!", Toast.LENGTH_LONG).show();
        }
    }

    public void cadastrar(View view){
        Intent intent = new Intent(this, TelaCadastrar.class);
        startActivity(intent);
    }
}