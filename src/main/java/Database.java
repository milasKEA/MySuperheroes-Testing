import java.util.ArrayList;

public class Database {

    public ArrayList<Superhero> heroList = new ArrayList<>();

    public void addSuperhero
            (Superhero superhero) {
        heroList.add(superhero);
    }

    public void addRandomHero(Superhero heroPrint) {
        heroList.add(new Superhero(
                heroPrint.getSuperName(),
                heroPrint.getCivilName(),
                heroPrint.getSpecialPower(),
                heroPrint.getCreationYear(),
                heroPrint.getPowerLevel()));
    }

    public ArrayList<Superhero> getHeroList() {
        return heroList;
    }

    public ArrayList<Superhero> findSuperhero(String superHeroName) {
        ArrayList<Superhero> superheroes = new ArrayList<>();

        for (Superhero superhero : heroList) {
            if (superhero.getSuperName().toLowerCase().contains(superHeroName.toLowerCase())) {
                if (!superHeroName.contains(superhero.getSuperName())) {
                    superheroes.add(superhero);
                }
            }
        }
        return superheroes;

    }
}
