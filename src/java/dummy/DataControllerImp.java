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
public class DataControllerImp<E> implements IDataController<E> {

    private ArrayList<E> collection;

    public DataControllerImp() {
        collection = new ArrayList<E>();
    }

    @Override
    public Collection<E> getCollection() {
        return collection;
    }

    @Override
    public void setElement(E element) {
        if (collection.indexOf(element) != -1) {
            collection.add(element);
        }
    }

    @Override
    public E getElement(int index) {
        return collection.get(index);
    }

    @Override
    public int getSize() {
        return collection.size();
    }
    
    

}
