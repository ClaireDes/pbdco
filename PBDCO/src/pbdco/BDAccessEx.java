/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco;

/**
 *
 * @author Antoine
 */
public class BDAccessEx extends Exception {

    /**
     * Creates a new instance of <code>BDAccessEx</code> without detail message.
     */
    public BDAccessEx() {
    }

    /**
     * Constructs an instance of <code>BDAccessEx</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public BDAccessEx(String msg) {
        super(msg);
    }
}
