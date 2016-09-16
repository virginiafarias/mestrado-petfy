package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import cap7.petfy.R;
import model.Medicacao;
import model.Vacina;

/**
 * Created by Virginia Farias on 12/09/2016.
 */
public class AdapterListViewMed extends ArrayAdapter<Medicacao> {

    public AdapterListViewMed(Context context, List<Medicacao> itens) {
        super(context, 0, itens);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Medicacao medicacao = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_list_medicacao, parent, false);
        }

        TextView txtNome = (TextView) convertView.findViewById(R.id.txt_item_med_nome);
        txtNome.setText(medicacao.getNome());
        TextView txtData = (TextView) convertView.findViewById(R.id.txt_item_med_data);
        txtData.setText(medicacao.getData());
        return convertView;
    }
}
