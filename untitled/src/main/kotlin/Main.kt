package org.example
import org.jsoup.Jsoup
import java.io.File

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var somme = 0

    for (i in 3..25){
        somme= somme + i

    }
    print( somme)


}

fun courriel (){
    // URL de la page donnée
    val url = "https://info.cegepmontpetit.ca/3N5-Prog3/testbot/courrielsDansA.html"

    // Récupérer le document HTML avec Jsoup
    val doc = Jsoup.connect(url).get()

    // Sélectionner toutes les balises <a>
    val links = doc.select("a")

    // Parcourir chaque lien
    for (link in links) {
        val email = link.attr("href")
        if (email.startsWith("mailto:")) {
            val adresse = email.removePrefix("mailto:") // retirer "mailto:"

            // Extraire prénom et nom à partir de l’adresse
            val partieNom = adresse.substringBefore("@")
            val morceaux = partieNom.split(".")
            if (morceaux.size == 2) {
                val prenom = morceaux[0].replaceFirstChar { it.uppercase() }
                val nom = morceaux[1].replaceFirstChar { it.uppercase() }

                println("$prenom $nom a pour courriel $adresse")
            }
        }
    }
}

fun sommeCumulative(tabEntiers: Array<Int>): Array<Int> {
    for (i in 1 until tabEntiers.size) {
        tabEntiers[i] += tabEntiers[i - 1]
    }
    return tabEntiers
}

fun joursParMois(n: Int): List<Int> {
    val jours = listOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

    if (n < 1 || n > 12) {
        throw IllegalArgumentException("Le nombre de mois doit être entre 1 et 12")
    }

    return jours.take(n)
}

fun tri(liste: List<Double>): List<Double> {
    return liste.sorted()
}


//En utilisant la librairie standard, ton programme doit :
//
//Créer un fichier vide dans le dossier courant appelé vide.txt.
//Créer un fichier texte contenant ton nom et ton prénom dans le dossier parent du dossier courant.
fun ecrireFichier() {
    // 1. Créer un fichier vide dans le dossier courant
    val fichierVide = File("vide.txt")
    fichierVide.createNewFile() // crée le fichier s'il n'existe pas

    // 2. Créer un fichier contenant ton nom et prénom dans le dossier parent
    val fichierNom = File("../nom_prenom.txt")
    fichierNom.writeText("TonNom TonPrenom")

    println("Fichiers créés avec succès !")
}


//En utilisant la librairie standard, ton programme doit :
//
//prendre un ou plusieurs noms de fichiers en arguments de ligne de commande;
//afficher le contenu de chaque fichier passé en argument dans la console en les séparant par une ligne de -------------.
fun LireFichier(args: Array<String>) {
    if (args.isEmpty()) {
        println("Veuillez fournir un ou plusieurs fichiers en arguments.")
        return
    }

    for ((index, nomFichier) in args.withIndex()) {
        val fichier = File(nomFichier)

        if (fichier.exists() && fichier.isFile) {
            println("=== Contenu de $nomFichier ===")
            println(fichier.readText())
        } else {
            println("Erreur : le fichier $nomFichier n'existe pas ou n'est pas valide.")
        }

        // Séparateur sauf après le dernier fichier
        if (index != args.lastIndex) {
            println("-------------")
        }
    }
}


//Ton programme doit contenir :
//
//une fonction repete(n: Int, nombreFois: Int) qui renvoie une liste d'entiers avec tous les nombres de 1 à n répétés nombreFois.
//Par exemple, pour repete(4, 2), on doit obtenir [1, 1, 2, 2, 3, 3, 4, 4];
//une fonction main qui teste la fonction précédente avec plusieurs valeurs de paramètres, et affiche les listes retournées avec println().
fun repete(n: Int, nombreFois: Int): List<Int> {
    val resultat = mutableListOf<Int>()
    for (i in 1..n) {
        repeat(nombreFois) {
            resultat.add(i)
        }
    }
    return resultat
}

//Ton programme doit contenir :
//
//une fonction triInverseALaMain(liste: List<Double>) qui renvoie la liste triée par ordre inverse.
//Par exemple, si on passe [0.1, 12.34, -0.1234, 3.1416] on doit obtenir [3.1416, -0.1234, 12.34, 0.1].
//Tu dois utiliser une liste mutable et une boucle;
//une fonction triInverse(liste: List<Double>) qui fait la même chose, mais sans boucle et en utilisant une méthode de l'objet List reçu en paramètre;
//une fonction main qui teste les deux fonctions précédentes avec plusieurs listes.
fun triInverseALaMain(liste: List<Double>): List<Double> {
    val resultat = mutableListOf<Double>()
    val copie = liste.toMutableList() // on fait une copie pour pouvoir retirer les éléments

    while (copie.isNotEmpty()) {
        // Trouver le max dans la copie
        val max = copie.maxOrNull()!!
        resultat.add(max)
        copie.remove(max) // retirer pour éviter de le reprendre
    }

    return resultat
}

fun triInverse(liste: List<Double>): List<Double> {
    // Utilisation directe d'une méthode de List
    return liste.sortedDescending()
}

//une fonction trouveALaMain(element: Int, liste: List<Int>): Boolean qui renvoie si la liste contient l'élément fourni ou pas.
//Tu dois parcourir la liste avec une boucle;
//une fonction trouve(element: Int, liste: List<Int>): Boolean qui fait la même chose, mais sans boucle et en utilisant une méthode de l'objet List;
//une fonction compteALaMain(element: Int, liste: List<Int>): Int qui renvoie le nombre d'apparitions de l'element dans la liste.
//Tu dois parcourir la liste avec une boucle;
//une fonction compte(element: Int, liste: List<Int>): Int qui fait la même chose, mais sans boucle et en utilisant une méthode de l'objet List;
//une fonction main qui teste les 4 fonctions sur plusieurs exemples.

fun trouveALaMain(element: Int, liste: List<Int>): Boolean {
    for (x in liste) {
        if (x == element) {
            return true
        }
    }
    return false
}

fun trouve(element: Int, liste: List<Int>): Boolean {
    return liste.contains(element)
}

fun compteALaMain(element: Int, liste: List<Int>): Int {
    var compteur = 0
    for (x in liste) {
        if (x == element) {
            compteur++
        }
    }
    return compteur
}

fun compte(element: Int, liste: List<Int>): Int {
    return liste.count { it == element }
}


//Crée un programme pour gérer une liste de mots reçue en ligne de commande.
//Tu dois t'assurer qu’il n’y a pas de doublons (utilise un Set).
//Affiche ensuite les mots triés par ordre alphabétique dans la console.
fun ensemble(args: Array<String>) {
    if (args.isEmpty()) {
        println("Veuillez fournir des mots en arguments.")
        return
    }

    // Supprimer les doublons
    val motsUniques = args.toSet()

    // Trier par ordre alphabétique
    val motsTries = motsUniques.sorted()

    // Afficher chaque mot sur une ligne
    for (mot in motsTries) {
        println(mot)
    }
}

//En utilisant une Map, crée un programme qui compte les occurences de chacun des mots reçus en ligne de commande.
//Par exemple, si ces mots sont passés en ligne commande :
fun Compteur(args: Array<String>) {
    if (args.isEmpty()) {
        println("Veuillez fournir des mots en arguments.")
        return
    }

    val compteurMots = mutableMapOf<String, Int>()

    for (mot in args) {
        compteurMots[mot] = compteurMots.getOrDefault(mot, 0) + 1
    }

    println(compteurMots)
}
