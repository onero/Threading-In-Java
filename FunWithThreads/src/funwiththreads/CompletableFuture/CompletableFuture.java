/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwiththreads.CompletableFuture;

import java.util.Scanner;

public class CompletableFuture {

    public static void main(String[] args) {

        java.util.concurrent.CompletableFuture
                .supplyAsync(new DataLoader())
                .thenAccept(new DataPrinter<>());
        System.out.println("Press<Enter> to continue...");
        new Scanner(System.in).nextLine();
        System.out.println("Done!");

    }

}
