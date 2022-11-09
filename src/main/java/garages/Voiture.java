package garages;

import java.io.PrintStream;
import java.util.*;

public class Voiture {

    private final String immatriculation;
    private final List<Stationnement> myStationnements = new LinkedList<>();

    public Voiture(String i) {
        if (null == i) {
            throw new IllegalArgumentException("Une voiture doit avoir une immatriculation");
        }

        immatriculation = i;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    /**
     * Fait rentrer la voiture au garage
     * Précondition : la voiture ne doit pas être déjà dans un garage
     *
     * @param g le garage où la voiture va stationner
     * @throws java.lang.Exception Si déjà dans un garage
     */
    public void entreAuGarage(Garage g) throws Exception {
        if (estDansUnGarage()) {
            throw new java.lang.Exception("Une voiture ne peut pas entrer d'un garage si elle est  stationnée");
        }
        Stationnement s = new Stationnement(this, g);  // Si elle n'est pas déjà stationnée elle rentre dans un garage pour se stationner
        myStationnements.add(s);

    }




    /**
     * Fait sortir la voiture du garage
     * Précondition : la voiture doit être dans un garage
     *
     * @throws java.lang.Exception si la voiture n'est pas dans un garage
     */
    public void sortDuGarage() throws Exception {
        //throw new UnsupportedOperationException("Pas encore implémenté");
        // TODO: Implémenter cette méthode
        if (!estDansUnGarage()) {
            throw new java.lang.Exception("Une voiture ne peut pas sortir d'un garage si elle n'est pas stationnée");
        } else {
            int index = myStationnements.size() - 1;
            Stationnement sta = myStationnements.get(index);
            sta.terminer();
        }
    }

    /**
     * @return l'ensemble des garages visités par cette voiture
     */




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voiture voiture = (Voiture) o;
        return Objects.equals(immatriculation, voiture.immatriculation) && Objects.equals(myStationnements, voiture.myStationnements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(immatriculation, myStationnements);
    }

    public Set<Garage> garagesVisites() {
		Set<Garage> resultat = new HashSet<>();
        // TODO: Implémenter cette méthode
        //throw new UnsupportedOperationException("Pas encore implémenté");
        for (Stationnement sta : myStationnements) {
            Garage gar = sta.getGarage();
            resultat.add(gar);
        }
        //System.out.println(myGarages);
        return resultat;
    }


    /**
     * @return vrai si la voiture est dans un garage, faux sinon
     */
    public boolean estDansUnGarage() {
        // TODO: Implémenter cette méthode
        //throw new UnsupportedOperationException("Pas encore implémenté");
        // Vrai si le dernier stationnement est en cours
        boolean stationnement = false;
        for (Stationnement sta : myStationnements) {
            if (sta.estEnCours()) {
                stationnement = true;
            }
        }
        return stationnement;
    }

    /**
     * Pour chaque garage visité, imprime le nom de ce garage suivi de la liste des
     * dates d'entrée / sortie dans ce garage
     * <br>
     * Exemple :
     *
     * <pre>
     * Garage Castres:
     * 		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
     * 		Stationnement{ entree=28/01/2019, en cours }
     *  Garage Albi:
     * 		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
     * </pre>
     *
     * @param out l'endroit où imprimer (ex: System.out)
     */
    public void imprimeStationnements(PrintStream out) {
        // TODO: Implémenter cette méthode
        //throw new UnsupportedOperationException("Pas encore implémenté");
        for (Garage gar : garagesVisites()) {
            out.println(gar + ":");
            for (Stationnement sta : myStationnements) {
                if (gar == sta.getGarage()) {
                    out.println("	" + sta);
                }
            }
        }
    }

}
