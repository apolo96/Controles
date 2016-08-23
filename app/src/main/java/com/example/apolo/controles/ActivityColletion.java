package com.example.apolo.controles;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Apolo on 19/08/2016.
 */
public class ActivityColletion {
    public Collection objList;

    public Object getActividad(String nameClass){
        objList = new ArrayList<Object>();
        objList.add(new ControlText());
        return objList;
    }
}
