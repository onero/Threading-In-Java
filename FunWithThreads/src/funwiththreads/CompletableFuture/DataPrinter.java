/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwiththreads.CompletableFuture;

import java.util.List;
import java.util.function.Consumer;

public class DataPrinter<T> implements Consumer<List<T>> {

    public DataPrinter() {
    }

    @Override
    public void accept(List<T> dataList) {
        for (T data : dataList) {
            System.out.println(data.toString());
        }
    }

}
