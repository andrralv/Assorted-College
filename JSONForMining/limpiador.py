import json

def limpiador():
    with open('lista.json', 'r') as data_file:
        data = json.load(data_file)
        for element in data:
            if 'nombre de madre' in element:
                del element['nombre de madre']
            if 'nombre de padre' in element:
                del element['nombre de padre']
            if 'marginal' in element:
                del element['marginal']



    with open('lista.json', 'w') as data_file:
        str_ = json.dumps(data,
                          indent=4, sort_keys=True,
                          separators=(',', ': '), ensure_ascii=False)
        data_file.write((str_))
