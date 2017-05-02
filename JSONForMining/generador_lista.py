"""
Este archivo genera una lista de 9999 personas en formato json
segun la informacion que despliega el registro nacional
las personas son generadas con nombres aleatorios y vinculadas
a un apellido de padre.

Este ejercicio se realizo por la dificultad de obtener grandes
cantidades de informacion de HTTP de parte del registro nacional

"""

import generador
import json
import io

def generador_lista():
    y = ""

    for i in range(0, 9999):
        x = generador.generador()
        str_ = json.dumps(x,
                          indent=4, sort_keys=True,
                          separators=(',', ': '), ensure_ascii=False)

        if (i == 9998):
            y = y + str_
        else:
            y = y + str_  +  ", "

    with io.open('lista.json', 'a+', encoding='utf8') as outfile:
        outfile.write("[" + y + "]")
    print("Your file was created")