package br.ufpi.alugapp.fronteira;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.widget.Button;
import android.widget.TextView;

import java.net.InterfaceAddress;

import br.ufpi.alugapp.R;
import br.ufpi.alugapp.controle.Fachada;

public class TelaDonoImobiliaria extends AppCompatActivity {

    private Fachada controles;
    private TextView tQuantidadeImoveis;
    private TextView tQuantidadeCorretores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_dono_imobiliaria);

        controles = new Fachada();
        
    }
}
