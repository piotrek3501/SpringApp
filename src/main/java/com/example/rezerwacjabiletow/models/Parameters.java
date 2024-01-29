package com.example.rezerwacjabiletow.models;

import java.util.ArrayList;

public class Parameters {
    private ArrayList<String>params;
    public Parameters(){
        params=new ArrayList<>();
        for(int i=0;i<5;i++){
            params.add("");
        }
    }

    public ArrayList<String> getParams() {
        return params;
    }

    public void setParams(ArrayList<String> params) {
        this.params = params;
    }
}
