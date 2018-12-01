package com.bloodcrown.bw.list.standar;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.bloodcrown.bw.BR;

public class Cat extends BaseObservable {

    public String name;
    public int price;

    public Cat() {
    }

    public Cat(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
        notifyPropertyChanged(BR.price);
    }

}
