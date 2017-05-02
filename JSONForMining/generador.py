
"""
Se espera poder producir un archivo con el siguiente formato:

{
“nombre”: “Abdel Antillon Perez”,
“identificación”: 104060574,
“edad”: “65 años”,
“sexo: “masculino”,
“marginal”: “no”,
“nombre de madre”: “Carmen Perez Carballo”,
“nombre de padre”: “Gonzalo Antillon Perez”,
“Lugar de nacimiento”: “San Jose”.
}

Nombre: Un String con 3 palabras generadas desde 3 listas.
Identificacion: Un int de 9 digitos generado aleatoriamente.
Edad: Un int de 18 a 108 años.
Sexo: masculino o femenino de manera aleatoria.
Nombre madre: Un String con 3 palabras generadas desde 3 listas.
Nombre padre: Un String con 3 palabras generadas desde 3 listas.
Marginal: Un 80% de que no sea marginal, aleatoriamente.
Lugar de nacimiento: Las 7 provincias de manera aleatoria.


"""

from random import randint
import json
import io

# declaracion de arreglos

def generador():
    nombres_fem = [
        "ana",
        "maria",
        "fabiola",
        "alejandra",
        "daniela",
        "andrea",
        "paula",
        "marisol",
        "mariana",
        "gabriela",
        "cristina",
        "isabel",
        "xiomara",
        "elga",
        "natalia",
        "lucia",
        "yotleny",
        "josselin",
        "shakira"
    ]

    nombres_masc = [
        "leonardo",
        "manuel",
        "rodrigo",
        "juan",
        "esteban",
        "daniel",
        "pablo",
        "mario",
        "luis",
        "carlos",
        "adrian",
        "josue",
        "jose",
        "eduardo",
        "william",
        "keylor",
        "bryan",
        "edgar",
        "oscar"
    ]

    apellidos = [
        "araya",
        "arguedas",
        "arias",
        "echeverri",
        "elizondo",
        "escobar",
        "ibanez",
        "izaguirre",
        "iglesias",
        "oller",
        "oliveira",
        "oviedo",
        "urena",
        "urbina",
        "uribe"
    ]

    provincias = [
        "san jose", "limon", "alajuela", "heredia", "guanacaste", "cartago", "puntarenas"
    ]

    # generacion de variables

    edad = randint(18, 108)
    sexo = ""
    marginal = ""
    nombre = ""

    true_false = randint(0, 1)
    true_false_greater = randint(0, 100)
    true_false_provincias = randint(0, 6)

    if (true_false == 0):
        sexo = "masculino"
    else:
        sexo = "femenino"

    if (true_false_greater > 80):
        marginal = "si"
    else:
        marginal = "no"

    apellido_paterno = apellidos[(randint(0, 10))]
    if (sexo == "masculino"):
        nombre = nombres_masc[(randint(0, 10))] + " " + nombres_masc[(randint(0, 10))] + " " + apellido_paterno
    else:
        nombre = nombres_fem[(randint(0, 10))] + " " + nombres_fem[(randint(0, 10))] + " " + apellido_paterno

    nombre_madre = nombres_fem[(randint(0, 10))] + " " + nombres_fem[(randint(0, 10))] + " " + apellidos[(randint(0, 10))]
    nombre_padre = nombres_masc[(randint(0, 10))] + " " + nombres_masc[(randint(0, 10))] + " " + apellido_paterno

    lugar_nacimiento = provincias[true_false_provincias]

    identificacion = ""
    for i in range(0, 9):
        new_number = randint(0, 9)
        identificacion = identificacion + str(new_number)


    data = {"nombre": nombre,
            "identificacion":  identificacion,
            "edad": true_false_greater,
            "sexo": sexo,
            "marginal": marginal,
            "nombre de madre": nombre_madre,
            "nombre de padre": nombre_padre,
            "lugar de nacimiento": lugar_nacimiento
    }

    with io.open('data.json', 'w', encoding='utf8') as outfile:
        str_ = json.dumps(data,
                          indent=4, sort_keys=True,
                          separators=(',', ': '), ensure_ascii=False)
        outfile.write((str_))
    with open('data.json') as data_file:
        data_loaded = json.load(data_file)

    return data_loaded
