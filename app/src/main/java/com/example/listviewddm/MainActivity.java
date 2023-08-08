package com.example.listviewddm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listviewddm.src.model.AdapterContatos;
import com.example.listviewddm.src.model.Contato;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private EditText txtNome;
    private EditText txtEmail;
    private EditText txtTelefone;
    private Button btnAdiciona;
    private ListView listaContatos;
    private ArrayList<Contato> contatos = new ArrayList<>();
    private AdapterContatos adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtNome = findViewById(R.id.txtNome);
        txtEmail = findViewById(R.id.txtEmail);
        txtTelefone = findViewById(R.id.txtTelefone);
        btnAdiciona = findViewById(R.id.btnAdiciona);
        listaContatos = findViewById(R.id.listaContatos);

        btnAdiciona.setOnClickListener(new EscutadorBotao());

        adaptador = new AdapterContatos(this, contatos);
        listaContatos.setAdapter(adaptador);

        EscutadorLista el = new EscutadorLista();
        listaContatos.setOnItemClickListener( el );
        listaContatos.setOnItemLongClickListener( el );
    }

    private class EscutadorBotao implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String nome;
            String email;
            String telefone;

            nome = txtNome.getText().toString();
            email = txtEmail.getText().toString();
            telefone = txtTelefone.getText().toString();

            Contato c = new Contato(nome, email, telefone);

            contatos.add(c);

            txtNome.setText("");
            txtEmail.setText("");
            txtTelefone.setText("");

            adaptador.notifyDataSetChanged();
        }

    }

    private class EscutadorLista implements AdapterView.OnItemClickListener,
            AdapterView.OnItemLongClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Contato c = contatos.get(i);

            String msg = c.getNome() + "\n";
            msg = msg + c.getEmail() + "\n";
            msg = msg + c.getTelefone();

            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
        }

        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
            contatos.remove( i );

            adaptador.notifyDataSetChanged();

            Toast.makeText(MainActivity.this, "Item apagado!", Toast.LENGTH_LONG).show();
            return true;

        }
    }
}