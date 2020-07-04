let url;

// Evenement apres chargement du DOM
document.addEventListener('DOMContentLoaded', function (evt) {


    // Evenement a la soumission du formulaire
    document.addEventListener('submit',  function (ev) {

        // block submit
        ev.preventDefault();

        // teste donnée d'entré user
        const villeUser = document.getElementById('ville').value;

        console.log("value : "+ villeUser );

        if (villeUser && villeUser.trim() !== ''){

            // creation de l'url vers l'API nominatim
            url = `https://nominatim.openstreetmap.org/search/ ${villeUser} ?format=json`;

            /**
             * Recherche les données correspondant a la ville demander
             * les ajoute au champs Hidden.
             * Cacher les champs dans le formulaire permet de les recupéres
             * lors de la soumission du formulaire dans l'url.
             *
             * @param url vers API nominatim
             */
            fetch(url)
                .then( response =>{return response.json() })
                .then(donnee =>{

                    console.log(donnee[0].lon)
                    console.log(donnee[0].lat)

                    // ajout des valeurs au champs cacher (hidden)
                    document.getElementById('longitude-hidden').value = donnee[0].lon;
                    document.getElementById('latitude-hidden').value = donnee[0].lat;
                    ev.target.submit();

                })

        }


    })

})
