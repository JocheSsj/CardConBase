package com.example.menuapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class EstablecimientoAdapter extends RecyclerView.Adapter<EstablecimientoAdapter.ViewHolder> {

    private List<Establecimiento> establecimientos;

    public EstablecimientoAdapter(List<Establecimiento> establecimientos) {
        this.establecimientos = establecimientos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_establecimiento, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Establecimiento establecimiento = establecimientos.get(position);
        holder.tvNombre.setText(establecimiento.getNombre());
        holder.tvDireccion.setText(establecimiento.getDireccion());
        holder.tvTipo.setText(establecimiento.getTipo());
        holder.tvDescripcion.setText(establecimiento.getDescripcion());
    }

    @Override
    public int getItemCount() {
        return establecimientos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvDireccion, tvTipo, tvDescripcion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvDireccion = itemView.findViewById(R.id.tvDireccion);
            tvTipo = itemView.findViewById(R.id.tvTipo);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcion);
        }
    }
}
