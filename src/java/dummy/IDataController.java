/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dummy;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author adamv_000
 */
public interface IDataController<E> {
    public Collection<E> getCollection();
    public void setElement(E element);
    public E getElement(int index);
    public int getSize();
    
}
