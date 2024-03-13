package com.pollo.utilities;

import java.util.List;


public interface ProveedorDatosPaginacion<T> {
    int getTotalRowCount();
    List<T> getRows(int starIndex,int endIndex);
}
