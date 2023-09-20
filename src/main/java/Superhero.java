public class Superhero {
    //Attributer
    private String superName;
    private String civilName;
    private double powerLevel;
    private int creationYear;
    private String specialPower;

    //Konstruktør1
    public Superhero(
            String superName,
            String civilName,
            String specialPower,
            int creationYear,
            double powerLevel)
    {
        this.superName = superName;
        this.civilName = civilName;
        this.powerLevel = powerLevel;
        this.creationYear = creationYear;
        this.specialPower = specialPower;
    }
    //Get metoder

    public String getSuperName() {
        return superName;
    }

    public String getCivilName() {
        return civilName;
    }

    public double getPowerLevel() {
        return powerLevel;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public String getSpecialPower() {
        return specialPower;
    }

    //Set metoder

    public void setSuperName(String superName) {
        this.superName = superName;
    }

    public void setCivilName(String civilName) {
        this.civilName = civilName;
    }

    public void setSpecialPower(String specialPower) {
        this.specialPower = specialPower;
    }

    public void setPowerLevel(double powerLevel) {
        this.powerLevel = powerLevel;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    public String toString() {
        String string = "";
        string += "Superhelte navn: " + superName + '\n';
        string += "Civil navn: " + civilName + '\n';
        string += "Specielle evner: " + specialPower + '\n';
        string += "Oprindelsesår: " + creationYear + '\n';
        string += "Powerlevel: " + powerLevel + '\n' + '\n';
        return string;
    }

}



