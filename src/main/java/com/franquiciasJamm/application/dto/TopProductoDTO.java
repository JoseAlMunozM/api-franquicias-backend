package com.franquiciasJamm.application.dto;

public class TopProductoDTO {
    public String sucursal;
    public String producto;
    public Integer stock;

    public TopProductoDTO(String s, String p, Integer st) {
        this.sucursal = s;
        this.producto = p;
        this.stock = st;
    }
}