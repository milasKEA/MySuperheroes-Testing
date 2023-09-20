import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
public class UserInterface {
    //Loop fra start til slut
    public void startProgram() {

        String kør = "y";
        Database database = new Database();
        Scanner scanner = new Scanner(System.in);
        printStartMessage();
        while (kør.equalsIgnoreCase("y")) {
            System.out.println("Tryk 1 for at tilføje endnu en helt.");
            System.out.println("Tryk 2 for at se alle dine superhelte.");
            System.out.println("Tryk 3 for at tilføje 4 random helte.");
            System.out.println("Tryk 4 for at søge efter superhelte");
            System.out.println("Tryk 5 for at redigere en superhelt");
            System.out.println("Tryk 6 for at slette en superhelt");
            System.out.println("Tryk 9 for at afslutte programmet.");

            //Opret ny Superhero
            try {
                int input = scanner.nextInt();
                //Opret ny Superhelt
                if (input == 1) {

                    System.out.println("Indtast superheltens navn: ");
                    String getFucked = scanner.nextLine();
                    String mySuperName = scanner.nextLine();
                    System.out.println("Hvad er din helts civile navn?");
                    String myCivilName = scanner.nextLine();
                    System.out.println("Hvad er din helts superkraft?");
                    String mySuperPower = scanner.nextLine();
                    System.out.println("Hvilket år blev din helt skabt?");
                    while (!scanner.hasNextInt()) {
                        String text = scanner.next();
                        System.out.println("'" + text + "'" + " er ikke et gyldigt svar. Du skal bruge nummeriske værdier.");
                    }
                    int myCreationYear = scanner.nextInt();
                    System.out.println("Hvad er din helts powerlevel?");
                    while (!scanner.hasNextDouble()) {
                        String text = scanner.next();
                        System.out.println("'" + text + "'" + " er ikke et gyldigt svar. Du skal bruge nummeriske værdier.");
                    }
                    double myPowerLevel = scanner.nextDouble();

                    Superhero mySuperHero = new Superhero(mySuperName, myCivilName, mySuperPower, myCreationYear, myPowerLevel);
                    database.addSuperhero(mySuperHero);

                    System.out.println("Din helts information: " + '\n' + mySuperHero);

                    System.out.println("Vil du tilbage til menuen? (y/n)");
                    kør = scanner.next();
                }
                //Print ArrayList over alle Superhelte
                if (input == 2) {
                    System.out.println(database.getHeroList());
                    System.out.println("Vil du tilbage til menuen? (y/n)");
                    kør = scanner.next();
                }
                //Tilføj 4 random Superhelte (not really random)
                if (input == 3) {
                    Superhero super1 = new Superhero(
                            "Blanket Lord",
                            "Lars Larsen",
                            "Har altid et godt tilbud til dig",
                            1959,
                            9.99);
                    Superhero super2 = new Superhero(
                            "DJ Blyatman",
                            "Stanislav Bodkovich",
                            "Russian Hardbass",
                            1993,
                            420);
                    Superhero super3 = new Superhero(
                            "Johnny Bravo",
                            "John Bravo",
                            "Tiltproof",
                            1970,
                            500);
                    Superhero super4 = new Superhero(
                            "Bodega Bent",
                            "Bent Børge Bumsen",
                            "Kan drikke 80 øl på i hvert fald et par timer",
                            1954,
                            14);
                    database.addRandomHero(super1);
                    database.addRandomHero(super2);
                    database.addRandomHero(super3);
                    database.addRandomHero(super4);
                    System.out.println("Der er nu tilføjet 4 helte til databasen");

                }
                //Søg efter Superhelte i Databasen
                if (input == 4) {
                    System.out.println("Indtast navnet på den superhelt du vil finde");
                    String søgning = scanner.next();
                    System.out.println(database.findSuperhero(søgning));
                    System.out.println("Vil du tilbage til menuen? (y/n)");
                    kør = scanner.next();

                }
                //Rediger en Superhelt
                if (input == 5) {
                    System.out.println("Vælg den superhelt, som du vil redigere");
                    String brugerInput = scanner.nextLine();

                    // Find person(er)
                    ArrayList<Superhero> søgeResultat = database.findSuperhero(brugerInput);
                    Superhero superheroEditor = null;

                    // Søgning finder ingen personer

                    boolean selection = true;
                    int heroChoice = 0;

                    while (selection) {
                        boolean choice = true;
                        if (søgeResultat.isEmpty()) {
                            System.out.println("Der findes ingen personer i databasen");
                            System.out.println("Vil du tilbage til menuen? (y/n)");
                            kør = scanner.next();
                        }
                        if (søgeResultat.size() > 1) {
                            // Vælg en person i søgeresultat med flere personer
                            System.out.println("Vælg en Superhelt ved at indtaste deres nummer");
                            int tæller = 1;
                            for (Superhero person : søgeResultat) {
                                System.out.println(tæller++ + " " +
                                        person.getSuperName()/* + " " +
                                    person.getCivilName() + " " +
                                    person.getSpecialPower() + " " +
                                    person.getCreationYear() + " " +
                                    person.getPowerLevel()*/);
                            }
                            while (choice) {
                                try {
                                    heroChoice = scanner.nextInt();
                                    choice = false;
                                } catch (InputMismatchException e) {
                                    System.out.println("Du skal indtaste en nummerisk værdi.");
                                    scanner.nextLine();
                                }
                            }
                            if (heroChoice < 0 || heroChoice > søgeResultat.size()) {
                                System.out.println("Forkert input - vælg et tal fra listen");
                                scanner.nextLine();
                            } else {
                                selection = false;
                            }
                        }
                    }
                    scanner.nextLine(); // Håndterer Scanner Bug
                    superheroEditor = søgeResultat.get(heroChoice - 1);

                    // Redigering af valgte personer
                    if (superheroEditor != null) {
                        System.out.println("Rediger personinformation. Tryk ENTER hvis information ikke skal redigeres.");
                        String nyVærdi;
                        System.out.println("Supernavn: " + superheroEditor.getSuperName());
                        nyVærdi = scanner.nextLine();
                        if (!nyVærdi.isEmpty()) {
                            superheroEditor.setSuperName(nyVærdi);
                        }
                        System.out.println("Civil navn: " + superheroEditor.getCivilName());
                        nyVærdi = scanner.nextLine();
                        if (!nyVærdi.isEmpty()) {
                            superheroEditor.setCivilName(nyVærdi);
                        }
                        System.out.println("Specielle evner: " + superheroEditor.getSpecialPower());
                        nyVærdi = scanner.nextLine();
                        if (!nyVærdi.isEmpty()) {
                            superheroEditor.setSpecialPower(nyVærdi);
                        }
                        System.out.println("Skabelsesår: " + superheroEditor.getCreationYear());
                        nyVærdi = scanner.nextLine();
                        if (!nyVærdi.isEmpty()) {
                            superheroEditor.setCreationYear(Integer.parseInt(nyVærdi));
                        }
                        System.out.println("Power level: " + superheroEditor.getPowerLevel());
                        nyVærdi = scanner.nextLine();
                        if (!nyVærdi.isEmpty()) {
                            superheroEditor.setPowerLevel(Double.parseDouble(nyVærdi));
                        }
                        System.out.println(superheroEditor + " er opdateret.");
                    }
                }
                //Slet en Superhelt
                if (input == 6) {

                    int tæller = 1;
                    for (Superhero test1 : database.heroList) {
                        System.out.println(tæller++ + " ) " +
                                test1.getSuperName());}
                        System.out.println("Indtast nummeret på den helt du vil slette ");

                        int deleteThisHero = scanner.nextInt();

                        try {
                            database.heroList.remove(deleteThisHero - 1);
                            System.out.println("Helten er nu slettet");
                            System.out.println("Vil du tilbage til menuen? (y/n)");
                            kør = scanner.next();
                        } catch (java.util.NoSuchElementException e) {
                            System.out.println("Helten blev ikke fundet");
                            System.out.println("Vil du tilbage til menuen? (y/n)");
                            kør = scanner.next();
                        }
                        //Slut programmet
                        if (input == 9) {
                            System.out.println("Tak for i dag - programmet lukker ned nu");
                            System.exit(0);
                        }
                    }

                    } catch(java.util.InputMismatchException a){
                        String text = scanner.next();
                        System.out.println("'" + text + "'" + " er ikke et gyldigt svar. Du skal bruge nummeriske værdier.");

                    }

                }
        }

    public void printStartMessage () {
        System.out.println("Velkommen til MySuperheroes");
    }

    }