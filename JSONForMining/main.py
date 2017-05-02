import generador_lista
import limpiador

def main():
    print("Se estan creando los registros")
    generador_lista.generador_lista()
    print("Una lista de 9999 registros se ha creado")
    print("Ahora se hara la limpieza de los registros")
    limpiador.limpiador()
    print("Se han borrado los datos innecesarios de los registros")

main()
input("Presione cualquier tecla para salir")

def dots():
    dot = 0
    if (dot == 2):
        dot = 2
    while (dot != 2):
        print(".")
        dot = dot + 1