package com.example.add_update_alertrecyclerviewpractice_java;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerPracticeAdapter extends RecyclerView.Adapter<RecyclerPracticeAdapter.ViewHolder> {
    Context context;
    ArrayList<ContextInfoPractice> arrContact;
    int currentView = -1;
    public RecyclerPracticeAdapter(Context context,ArrayList<ContextInfoPractice> arrContact){
        this.context = context;
        this.arrContact = arrContact;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_practice_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,int position) {
        ContextInfoPractice model = (ContextInfoPractice) arrContact.get(position);
        holder.Image.setImageResource(model.ContactImage);
        holder.Name.setText(model.ContactName);
        holder.Number.setText(model.ContactNumber);
        setAnimation(holder.itemView,position);
        holder.LlContactInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_view_lay);
                dialog.show();

                TextView title = dialog.findViewById(R.id.txtTitle);
                EditText name = dialog.findViewById(R.id.updateName);
                EditText number = dialog.findViewById(R.id.updateNumber);
                Button actionBtn = dialog.findViewById(R.id.actionBtn);

                title.setText(" Update Contact ");
                actionBtn.setText("Update");
                name.setText(model.ContactName);
                number.setText(model.ContactNumber);
                actionBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String addName = "",addNumber="";
                        if (!name.getText().toString().equals("") || !number.getText().toString().equals("")){
                            addName = name.getText().toString();
                            addNumber = number.getText().toString();
                            arrContact.set(position,new ContextInfoPractice(model.ContactImage,addName,addNumber));
                            notifyItemChanged(position);
                        }
                        else {
                            Toast.makeText(context," Please enter data ",Toast.LENGTH_SHORT).show();
                        }

                        dialog.dismiss();
                    }
                });
            }
        });
        holder.LlContactInfo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Delete Contact");
                builder.setMessage("Are you sure want to delete this contact?");
                builder.setIcon(R.drawable.baseline_delete_24);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        arrContact.remove(position);
                        notifyItemRemoved(position);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrContact.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView Image;
        TextView Name,Number;
        LinearLayout LlContactInfo;
        public ViewHolder(View itemView){
            super(itemView);

            Image = itemView.findViewById(R.id.contactImage);
            Name = itemView.findViewById(R.id.contactName);
            Number = itemView.findViewById(R.id.contactNumber);
            LlContactInfo = itemView.findViewById(R.id.LlContactInfo);
        }
    }
    public void setAnimation(View view,int position){
        if (position>currentView) {
            Animation slindIn = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            view.startAnimation(slindIn);
            currentView = position;
        }
    }
}
