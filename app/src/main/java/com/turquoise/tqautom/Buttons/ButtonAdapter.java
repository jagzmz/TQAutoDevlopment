package com.turquoise.tqautom.Buttons;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.turquoise.tqautom.Floors.FloorInterfaceMapping;
import com.turquoise.tqautom.R;
import com.turquoise.tqautom.Server.model.Button;

import java.util.List;


public class ButtonAdapter extends RecyclerView.Adapter<ButtonAdapter.ButtonViewHolder> {

    private final Context context;
    private final LayoutInflater inflater;
    private ButtonClickListener buttonClickListener;
    private View view;
    private ButtonViewHolder buttonViewHolder;
    private List<Button> buttons;
    private List<FloorInterfaceMapping> mappings;
    private long mLastClickTime = System.currentTimeMillis();
    private static final long CLICK_TIME_INTERVAL = 300;
    //    Map<Floor, Map<Room, Button>> mappings;
    private final String TAG = "ButtonAdapter";

    public ButtonAdapter(Context context, ButtonClickListener buttonClickListener) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.buttonClickListener = buttonClickListener;
    }


    @NonNull
    @Override
    public ButtonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = inflater.inflate(R.layout.button_card, parent, false);
        buttonViewHolder = new ButtonViewHolder(view);
        return buttonViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ButtonViewHolder holder, final int position) {

        holder.buttonName.setText(buttons.get(position).getButAlias());
        holder.init();
        final String buttonStatus = buttons.get(position).getButStatus();


    }

    @Override
    public int getItemCount() {
        return buttons.size();
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
        notifyItemRangeChanged(0, buttons.size());
    }

    public void setMappings(List<FloorInterfaceMapping> mappings) {
        this.mappings = mappings;
    }


    class ButtonViewHolder extends RecyclerView.ViewHolder {

        final LinearLayout colorStatus;
        final TextView buttonName;
        final CardView cardView;

        ButtonViewHolder(@NonNull View itemView) {
            super(itemView);
            colorStatus = itemView.findViewById(R.id.colorStatus);
            buttonName = itemView.findViewById(R.id.buttonName);
            cardView = itemView.findViewById(R.id.buttonCard);

        }

        void init() {
            if (getAdapterPosition() != -1) {
                final String buttonStatus = buttons.get(getAdapterPosition()).getButStatus();

                if (buttonStatus.equals("1")) {

                    colorStatus.setBackgroundColor(context.getResources().getColor(R.color.green));
                } else {
                    colorStatus.setBackgroundColor(context.getResources().getColor(R.color.buttonOff));

                }

                cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        long now = System.currentTimeMillis();
                        if (now - mLastClickTime < CLICK_TIME_INTERVAL) {
                            return;
                        }
                        mLastClickTime = now;


                        String b = buttonStatus;
                        if (b.equals("0")) {
                            buttonClickListener.callback(1);
                            buttons.get(getAdapterPosition()).setButStatus("1");
                            colorStatus.setBackgroundColor(context.getResources().getColor(R.color.green));
                        } else {
                            buttons.get(getAdapterPosition()).setButStatus("0");
                            buttonClickListener.callback(0);
                            colorStatus.setBackgroundColor(context.getResources().getColor(R.color.buttonOff));
                        }
                        notifyItemChanged(getAdapterPosition());
                    }
                });
            }
        }


    }

}
