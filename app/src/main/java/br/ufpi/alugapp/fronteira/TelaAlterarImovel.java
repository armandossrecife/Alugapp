package br.ufpi.alugapp.fronteira;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.ufpi.alugapp.R;
import br.ufpi.alugapp.controle.Fachada;
import br.ufpi.alugapp.entidades.Imovel;

public class TelaAlterarImovel extends AppCompatActivity {

    private Fachada controladores;
    EditText edtValor, edtEndereco, edtDescricao;
    Imovel imv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_alterar_imovel);

        this.imv = (Imovel) getIntent().getSerializableExtra("imovel");

        this.controladores = new Fachada(this);
        this.edtValor = (EditText) findViewById(R.id.edtValor);
        this.edtEndereco = (EditText) findViewById(R.id.edtEndereco);
        this.edtDescricao = (EditText) findViewById(R.id.edtDescricao);

        this.edtValor.setText(Float.toString(imv.getPreco()));
        this.edtEndereco.setText(imv.getEndereco());
        this.edtDescricao.setText(imv.getDescricao());
    }

    public void submeterAlteracoes(View view){

        float valorAlterado = Float.parseFloat(edtDescricao.getText().toString());
        String enderecoAlterado = edtEndereco.getText().toString();
        String descricaoAlterado = edtDescricao.getText().toString();

        if (valorAlterado != 0.0f && !enderecoAlterado.isEmpty() && !descricaoAlterado.isEmpty()) {

            Imovel imv2 = controladores.controladorImoveis.alterarImovel(descricaoAlterado, enderecoAlterado, valorAlterado, imv.getIdImovel());

            if(imv2 != null){
                Intent intent = new Intent(this, TelaDetalhesImovelCorretor.class);
                intent.putExtra("imovel", imv2);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Erro. Tente novamente!", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Entrada Inválida!", Toast.LENGTH_SHORT).show();
        }
    }
}
