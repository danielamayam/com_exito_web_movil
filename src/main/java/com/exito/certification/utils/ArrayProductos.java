package com.exito.certification.utils;

import com.exito.certification.models.ProductoModel;
import java.util.ArrayList;

public class ArrayProductos {

    private static ArrayList<ProductoModel> productoModelsList = new ArrayList<>();

    public static void setArrayProductos(String nombre, String cantidad, String precio){
        ProductoModel productoModel = new ProductoModel();
        productoModel.setNombre(nombre);
        productoModel.setCantidad(cantidad);
        productoModel.setPrecio(precio);
        productoModelsList.add(productoModel);
    }

    public static ArrayList<ProductoModel> getArrayProductos(){
        return productoModelsList;
    }

    public static int getCantidad(){
        return productoModelsList.size();
    }

}
