package histoire;

import personnages.Commercant;
import personnages.GrandMere;
import personnages.Humain;
import personnages.Ronin;
import personnages.Samourai;
import personnages.Traitre;
import personnages.Yakuza;

public class HistoireTP5 {

    public static void main(String[] args) {

        // ------- 1) Les humains ont une mémoire -------

        Commercant marco = new Commercant("Marco", 20);
        Commercant chonin = new Commercant("Chonin", 40);
        Commercant kumi = new Commercant("Kumi", 10);
        Yakuza yaku = new Yakuza("Yaku Le Noir", "whisky", 30, "Warsong");
        Ronin roro = new Ronin("Roro", "shochu", 60);

        marco.faireConnaissanceAvec(roro);
        marco.faireConnaissanceAvec(yaku);
        marco.faireConnaissanceAvec(chonin);
        marco.faireConnaissanceAvec(kumi);

        marco.listerConnaissances();
        roro.listerConnaissances();
        yaku.listerConnaissances();

        System.out.println();
        // ------- 3) Les samouraïs -------

        Samourai akimoto = new Samourai("Miyamoto", "Akimoto", "saké", 80);
        akimoto.direBonjour();
        marco.direBonjour();
        akimoto.faireConnaissanceAvec(marco);
        akimoto.listerConnaissances();
        akimoto.boire("thé");

        System.out.println();
        // ------- 4) Les traîtres -------

        Traitre masako = new Traitre("Miyamoto", "Masako", "whisky", 100);

        masako.faireLeGentil(); // au début il ne connaît personne
        masako.ranconner(kumi);
        masako.ranconner(chonin);
        masako.ranconner(marco);

        akimoto.direBonjour();
        masako.direBonjour();

        masako.ranconner(marco); // devrait refuser, niveau de traîtrise >= 3

        masako.direBonjour();
        yaku.direBonjour();
        masako.faireLeGentil();
        masako.direBonjour();

        roro.direBonjour();

        System.out.println();
        // ------- 6) Les grand-mères -------

        GrandMere grandMere = new GrandMere("Grand-Mère", 10);
        grandMere.faireConnaissanceAvec(akimoto);
        grandMere.faireConnaissanceAvec(yaku);
        grandMere.faireConnaissanceAvec(masako);
        grandMere.faireConnaissanceAvec(kumi);
        grandMere.faireConnaissanceAvec(marco);
        grandMere.faireConnaissanceAvec(chonin); // devrait déclencher "Oh ma tête !"

        grandMere.ragoter();
    }
}

