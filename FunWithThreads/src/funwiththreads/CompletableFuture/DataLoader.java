/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwiththreads.CompletableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class DataLoader implements Supplier<List<Integer>> {

    private List<Integer> numbers;

    public DataLoader() {
    }

    @Override
    public List<Integer> get() {
        try {
            TimeUnit.SECONDS.sleep(10);
            numbers = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                numbers.add(i);
            }
        } catch (Exception e) {
        }
        return numbers;
    }

}
