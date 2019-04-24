"# planet-service" 

JAVA_VERSION : 1.8

Iniciar aplicacao

Executar o arquivo na raiz do projeto Executavel : planet-service\mvnw.cmd


API



VERBO : GET
URL : /v1/planet
Headers = [Content-Type:"application/json;charset=UTF-8"]

BODY :
{  
   "name":"Hetory",
   "climate":"temperate",
   "terrain":"terrain",
   "quantity":5
}

___________________________________________________________________________________________________

VERBO : POST
URL : /v1/planet
Headers = [Content-Type:"application/json;charset=UTF-8"]

BODY :
{  
   "name":"Hetory",
   "climate":"temperate",
   "terrain":"terrain"
}

___________________________________________________________________________________________________

VERBO : GET
URL : v1/planets/star-wars
Headers = [Content-Type:"application/json;charset=UTF-8"]

{  
   "results":[  
      {  
         "name":"Alderaan",
         "films":[  
            "https://swapi.co/api/films/6/",
            "https://swapi.co/api/films/1/"
         ]
      },
      {  
         "name":"Yavin IV",
         "films":[  
            "https://swapi.co/api/films/1/"
         ]
      },
      {  
         "name":"Hoth",
         "films":[  
            "https://swapi.co/api/films/2/"
         ]
      },
      {  
         "name":"Dagobah",
         "films":[  
            "https://swapi.co/api/films/2/",
            "https://swapi.co/api/films/6/",
            "https://swapi.co/api/films/3/"
         ]
      },
      {  
         "name":"Bespin",
         "films":[  
            "https://swapi.co/api/films/2/"
         ]
      },
      {  
         "name":"Endor",
         "films":[  
            "https://swapi.co/api/films/3/"
         ]
      },
      {  
         "name":"Naboo",
         "films":[  
            "https://swapi.co/api/films/5/",
            "https://swapi.co/api/films/4/",
            "https://swapi.co/api/films/6/",
            "https://swapi.co/api/films/3/"
         ]
      },
      {  
         "name":"Coruscant",
         "films":[  
            "https://swapi.co/api/films/5/",
            "https://swapi.co/api/films/4/",
            "https://swapi.co/api/films/6/",
            "https://swapi.co/api/films/3/"
         ]
      },
      {  
         "name":"Kamino",
         "films":[  
            "https://swapi.co/api/films/5/"
         ]
      },
      {  
         "name":"Geonosis",
         "films":[  
            "https://swapi.co/api/films/5/"
         ]
      }
   ]
}

___________________________________________________________________________________________________


VERBO : GET
URL : /v1/planet/id/{id}
Headers = [Content-Type:"application/json;charset=UTF-8"]

BODY :
{  
   "name":"Hetory",
   "climate":"temperate",
   "terrain":"terrain",
   "quantity":5
}

___________________________________________________________________________________________________

VERBO : GET
URL : /v1/planet/name/{name}
Headers = [Content-Type:"application/json;charset=UTF-8"]

BODY :
{  
   "name":"Hetory",
   "climate":"temperate",
   "terrain":"terrain",
   "quantity":5
}

___________________________________________________________________________________________________


VERBO : GET
URL : /v1/planets
Headers = [Content-Type:"application/json;charset=UTF-8"]

Body

[  
   {  
      "name":"Hoth",
      "climate":"temperate",
      "terrain":"terrain",
      "quantity":1
   },
   {  
      "name":"Endor",
      "climate":"temperate",
      "terrain":"terrain",
      "quantity":1
   }
]

___________________________________________________________________________________________________


VERBO : GET
URL : /v1/planets
Headers = [Content-Type:"application/json;charset=UTF-8"]

Body

[  
   {  
      "name":"Hoth",
      "climate":"temperate",
      "terrain":"terrain",
      "quantity":1
   },
   {  
      "name":"Endor",
      "climate":"temperate",
      "terrain":"terrain",
      "quantity":1
   }
]


___________________________________________________________________________________________________

VERBO : GET
URL : /v1/planet/{id}
Headers = [Content-Type:"application/json;charset=UTF-8"]

