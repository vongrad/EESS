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
public interface IDataController {
    public Collection<Elective> getFirstRound();
    public Collection<ElectiveSecond> getSecondRound();
    public boolean setFirsttRndEle(Elective element);
    public boolean setSecondRndEle(ElectiveSecond element);
    public Elective getFirstRndEle(int index);
    public ElectiveSecond getSecondRndEle(int index);
    public int getFirstRndSize();
    public int getSecondRndSize();
    public Elective getLastFirstRndEle();
    public ElectiveSecond getLastSecondRndEle();
    public void generateFirstRndEle();
    public void generateSecondRndEle();
    
}
