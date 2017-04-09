package br.usjt.ftce.desmob.clientev1;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Hygor 09/04/2017.
 */

public class ClienteAdapter extends BaseAdapter {
    private Cliente [] clientes;
    Activity context;

    public ClienteAdapter(Activity context, Cliente[] clientes) {
        this.clientes = clientes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return clientes.length;
    }

    @Override
    public Object getItem(int position) {
        if( position >= 0 && position < clientes.length){
            return clientes[position];
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View viewReciclada, ViewGroup viewGroup) {
       View view = viewReciclada;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater)  context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.linha_cliente, viewGroup,false);

            ImageView fotoCliente = (ImageView) view.findViewById(R.id.foto_cliente);
            TextView nomeCliente = (TextView) view.findViewById(R.id.nome_cliente);
            TextView detalheCliente = (TextView) view.findViewById(R.id.detalhe_cliente);

            view.setTag( new ViewHolder(fotoCliente,nomeCliente,detalheCliente));
        }
        //usar os widgets cacheados na tag da view reciclado
        ViewHolder holder = (ViewHolder) view.getTag();
        //carrega os novos valores
        Drawable foto = Imagem.getDrawable(context);
        holder.getFotoCliente().setImageDrawable(foto);
        holder.getNomeCliente().setText(clientes[position].getNome());
        holder.getDetalheCliente().setText(clientes[position].getFone()+" - "+clientes[position].getEmail());

        return view;
    }
}
