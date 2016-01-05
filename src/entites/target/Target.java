package entites.target;

import entites.Skin;

/**
 *  Un aspect abstrait de se qu'est une target
 */
public abstract class Target {
    
    int rayonDeLaForce;
    
    int rayonCentral;
    
    public abstract Skin draw(Skin s,int centreX, int centreY, int mouseX, int mouseY);

    public int getRayonDeLaForce() {
        return rayonDeLaForce;
    }

    public void setRayonDeLaForce(int rayonDeLaForce) {
        this.rayonDeLaForce = rayonDeLaForce;
    }

    public int getRayonCentral() {
        return rayonCentral;
    }

    public void setRayonCentral(int rayonCentral) {
        this.rayonCentral = rayonCentral;
    }
    
    
}
