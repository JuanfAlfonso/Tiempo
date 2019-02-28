package com.example.organizadorultradia.Presentador;

import android.view.View;
import android.widget.EditText;
import com.example.organizadorultradia.Interface.Interface;

public class presentador {
private Interface.View view;
private Interface.Model model;
    public void presentador(Interface.View view, Interface.Model model){
      this.view = view;
      this.model=model;
    }
}
