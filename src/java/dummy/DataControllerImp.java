/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dummy;

import dto.Elective;
import dto.ElectiveSecond;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author adamv_000
 */
public class DataControllerImp implements IDataController {
    
    private ArrayList<Elective> firstRound;
    private ArrayList<ElectiveSecond> secondRound;

    public DataControllerImp() {
        this.firstRound = new ArrayList<>();
        this.secondRound = new ArrayList<>();
    }
    
    @Override
    public ArrayList<Elective> getFirstRound() {
        return firstRound;
    }

    @Override
    public ArrayList<ElectiveSecond> getSecondRound() {
        return secondRound;
    }

    @Override
    public boolean setFirsttRndEle(Elective element) {
        if (!firstRound.contains(element)){
            return firstRound.add(element);
        }
        return false;
        
    }

    @Override
    public boolean setSecondRndEle(ElectiveSecond element) {
        if (!secondRound.contains(element)){
            return secondRound.add(element);
        }
        return false;
    }

    @Override
    public Elective getFirstRndEle(int index) {
        return firstRound.get(index);
    }

    @Override
    public ElectiveSecond getSecondRndEle(int index) {
        return secondRound.get(index);
    }

    @Override
    public int getFirstRndSize() {
        return firstRound.size();
    }

    @Override
    public int getSecondRndSize() {
       return secondRound.size();
    }

    @Override
    public Elective getLastFirstRndEle() {
        if (!firstRound.isEmpty()){
            return firstRound.get(getFirstRndSize() - 1);
        }
        return null;
    }

    @Override
    public ElectiveSecond getLastSecondRndEle() {
        if (!secondRound.isEmpty()){
            return secondRound.get(getSecondRndSize() - 1);
        }
        return null;
    }

    @Override
    public Collection<Elective> generateFirstRndEle() {
        firstRound = GenerateDummyData.generateFirstRndEle();
    }

    @Override
    public Collection<ElectiveSecond> generateSecondRndEle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    

}