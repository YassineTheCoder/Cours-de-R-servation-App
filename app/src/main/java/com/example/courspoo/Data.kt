package com.example.courspoo


enum class TypeCours(val description: String, val duree: Int, val tarif: Double) {
    YOGA("Cours de relaxation ef flexibilite.",60,400.00),
    PILATES("Cours de renforcement musculaire",50,350.00),
    CARDIO("Cours pour ameliorer l'endurance",45,300.00),
    MUSCULATION("Cours de renforcement avec poids",40,450.00),
    ZUMBA("Cours de danse et fitness",55,380.00);

    fun afficherDescription():String{
        return "$name - $description pendant une période de  $duree min à un prix de $tarif MAD."
    }

    fun tarifMesuel():String{
        return "Cours de $name à un prix mensuel de $tarif MAD"
    }
}

data class Utilisateur(val id:Int, val nom: String, val coursReserves:MutableList<TypeCours> = mutableListOf()){

    fun ajeuterCours(cours: TypeCours){
        if(coursReserves.size>=5){
            println("Limite de réservations atteinte ! Vous ne pouvez pas réserver plus de 5 cours.")
            return
        }
        if(coursReserves.any{it.name== cours.name}){
            println("Le cours ${cours.name} est déjà réservé. Impossible d'ajouter.")
            return
        }else{
            coursReserves.add(cours)
            println("Le cours ${cours.name} a été ajouté avec succès.")

        }

    }

    fun supprimerCours(cours: TypeCours){
        if(coursReserves.any{it.name==cours.name}){
            println("Cours with nom ${cours.name} ete Supprimer.")
            coursReserves.remove(cours)
        }else{
            println("Cours with nom ${cours.name}  n'exists pas. Cannot supprimer.")

        }
    }

    fun afficherCoursReserves(){
           if(coursReserves.isEmpty()){
               println("Aucun cours réservé.")

           }else{
               println("Cours réservés pour $nom:")
               coursReserves.forEach { cours ->
                   println(cours.afficherDescription())
               }

           }
    }

    fun calculerCoutTotal(){
        val coutTotal = coursReserves.sumOf { it.tarif }
        println("Le coût total des cours réservés pour $nom est de $coutTotal.")

    }
}

fun main(){
        val utilisateur = Utilisateur(id = 1, nom = "Yassine")

        utilisateur.ajeuterCours(TypeCours.YOGA)
        utilisateur.ajeuterCours(TypeCours.PILATES)
        utilisateur.ajeuterCours(TypeCours.CARDIO)
        utilisateur.ajeuterCours(TypeCours.MUSCULATION)
        utilisateur.ajeuterCours(TypeCours.ZUMBA)

    println()
        utilisateur.ajeuterCours(TypeCours.YOGA)
        utilisateur.ajeuterCours(TypeCours.CARDIO)

        println()
        utilisateur.supprimerCours(TypeCours.CARDIO)

    println()
        utilisateur.afficherCoursReserves()

    println()
        utilisateur.calculerCoutTotal()
    }

