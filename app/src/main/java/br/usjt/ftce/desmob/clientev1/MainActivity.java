package br.usjt.ftce.desmob.clientev1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends Activity {
    EditText textNome;
    ArrayList<Cliente> lista;
    ClienteRequester clienteRequester;
    Intent intent;
    String chave;
    public static final String LISTA = "br.usjt.ftce.desmob.clientev1.lista";
    public static final String SERVIDOR = "http://10.71.4.28:8080";
    public static final String APP_STRING = "arqdesis_poetas";
    public static final String RECURSO = "/cliente";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textNome = (EditText) findViewById(R.id.buscar_clientes);
    }

    public void buscarCliente(View view){
        intent = new Intent(this,Class.class);
        chave = textNome.getText().toString();

        clienteRequester = new ClienteRequester();

        if (clienteRequester.isConnected(this)) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {

                        lista = clienteRequester.get(SERVIDOR + APP_STRING + RECURSO, chave);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                intent.putExtra(LISTA, lista);
                                startActivity(intent);
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } else {
            Toast toast = Toast.makeText(this, "Rede indisponivel", Toast.LENGTH_LONG);
            toast.show();
        }
    }

}
