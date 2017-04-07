/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsynchronized;

/**
 *
 * @author Adamino
 */
public class FunWithSynchronized {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LostUpdateSolver solver = new LostUpdateSolver();
        solver.go();
    }

}
