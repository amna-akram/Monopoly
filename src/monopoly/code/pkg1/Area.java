/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.code.pkg1;

/**
 *
 * @author Admin
 */
public abstract class Area {
    public Area(int id, String name)
    {
        ID=id;
       Area_Name=name;
    }

    public int ID;

    private String Area_Name;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getArea_Name() {
        return Area_Name;
    }

    public void setArea_Name(String Area_Name) {
        this.Area_Name = Area_Name;
    }
    public int GetSellingPrice(){
        return 0;
    }
    public abstract void action(Player[] p, Bank[] b, Area[] a, int turn, int num_players, int dice);

}
