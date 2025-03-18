__author__ = "Aitor Novoa Alonso"

def mostrar_alumnos(alumnos, dicionario_alumnos):
    """
    Muestra todos los alumnos.

    Args:
        alumnos (list): Lista de índices de los alumnos.
        dicionario_alumnos (dict): Diccionario con los datos de los alumnos, donde la clave es el índice
                                   del alumno y el valor es otro diccionario con 'nombre', 'apellidos' y 'nota'.
    
    Returns:
        list: Lista de cadenas con los datos de los alumnos (índice, apellidos, nombre y nota).
    """
    result = []
    for indice in alumnos:
        alumno = dicionario_alumnos[indice]
        result.append(f"{indice}. {alumno['apellidos']}, {alumno['nombre']}: {alumno['nota']}")
    return result

def ingresar_alumno(nombre, apellidos, nota, alumnos, diccionario_alumnos):
    """
    Solicita los datos del alumno y lo añade a la lista de alumnos y al diccionario.

    Args:
        nombre (str): Nombre del alumno.
        apellidos (str): Apellidos del alumno.
        nota (float): Nota del alumno.
        alumnos (list): Lista de índices para mantener el orden de los alumnos.
        diccionario_alumnos (dict): Diccionario que almacena los datos de los alumnos con el índice como clave.
    
    Returns:
        tuple: La lista de alumnos actualizada y el diccionario de alumnos actualizado.
    """
    indice = len(alumnos)
    alumnos.append(indice)
    diccionario_alumnos[indice] = {'nombre': nombre, 'apellidos': apellidos, 'nota': nota}
    return alumnos, diccionario_alumnos

def eliminar_alumno(indice, alumnos, dicionario_alumnos):
    """
    Elimina un alumno de la lista y el diccionario.

    Args:
        indice (int): El índice del alumno a eliminar.
        alumnos (list): Lista de índices de los alumnos.
        dicionario_alumnos (dict): Diccionario con los datos de los alumnos.
    
    Returns:
        tuple: La lista de alumnos y el diccionario de alumnos actualizados.
    """
    if indice in dicionario_alumnos:
        dicionario_alumnos.pop(indice)
        alumnos.remove(indice)
    return alumnos, dicionario_alumnos

def modificar_nota_alumno(indice, nueva_nota, alumnos, dicionario_alumnos):
    """
    Modifica la nota de un alumno.

    Args:
        indice (int): Índice del alumno cuyo dato se va a modificar.
        nueva_nota (float): Nueva nota del alumno.
        alumnos (list): Lista de índices de los alumnos.
        dicionario_alumnos (dict): Diccionario con los datos de los alumnos.
    
    Returns:
        dict: Diccionario de alumnos actualizado.
    """
    if indice in dicionario_alumnos:
        dicionario_alumnos[indice]['nota'] = nueva_nota
    return dicionario_alumnos

def mostrar_aprobados(alumnos, dicionario_alumnos):
    """
    Muestra los alumnos aprobados (nota >= 5).

    Args:
        alumnos (list): Lista de índices de los alumnos.
        dicionario_alumnos (dict): Diccionario con los datos de los alumnos.
    
    Returns:
        list: Lista de cadenas con los alumnos aprobados (índice, apellidos, nombre y nota).
    
    Raises:
        ValueError: Si 'alumnos' no es una lista.
    """
    if not type(alumnos) is list:
        raise ValueError("'alumnos' debe ser una lista.")
    
    aprobados = []
    for indice in alumnos:
        alumno = dicionario_alumnos[indice]
        if alumno['nota'] >= 5:
            aprobados.append(f"{indice}. {alumno['apellidos']}, {alumno['nombre']}: {alumno['nota']}")
    return aprobados

def mostrar_alfabeticamente(alumnos, dicionario_alumnos):
    """
    Muestra a los alumnos ordenados alfabéticamente por apellidos y nombre.

    Args:
        alumnos (list): Lista de índices de los alumnos.
        dicionario_alumnos (dict): Diccionario con los datos de los alumnos.
    
    Returns:
        list: Lista de cadenas con los datos de los alumnos ordenados alfabéticamente (índice, apellidos, nombre y nota).
    
    Raises:
        ValueError: Si 'alumnos' no es una lista.
    """
    if not type(alumnos) is list:
        raise ValueError("'alumnos' debe ser una lista.")

    for i in range(len(alumnos)):
        for j in range(0, len(alumnos) - i - 1):
            alumno_j = dicionario_alumnos[alumnos[j]]
            alumno_j1 = dicionario_alumnos[alumnos[j + 1]]
            if (alumno_j['apellidos'], alumno_j['nombre']) > (alumno_j1['apellidos'], alumno_j1['nombre']):
                alumnos[j], alumnos[j + 1] = alumnos[j + 1], alumnos[j]
    
    ordenados = []
    for indice in alumnos:
        alumno = dicionario_alumnos[indice]
        ordenados.append(f"{indice}. {alumno['apellidos']}, {alumno['nombre']}: {alumno['nota']}")
    return ordenados

def calcular_media(alumnos, dicionario_alumnos):
    """
    Calcula y muestra la nota media de los alumnos.

    Args:
        alumnos (list): Lista de índices de los alumnos.
        dicionario_alumnos (dict): Diccionario con los datos de los alumnos.
    
    Returns:
        str: La nota media de los alumnos en formato de texto con dos decimales.
    
    Raises:
        ValueError: Si 'alumnos' no es una lista, está vacía o no hay alumnos para calcular la media.
    """
    if not type(alumnos) is list:
        raise ValueError("'alumnos' debe ser una lista.")
    
    if not alumnos:
        raise ValueError("No hay alumnos para calcular la media.")
    
    total_notas = 0
    for indice in alumnos:
        total_notas += dicionario_alumnos[indice]['nota']
    
    media = total_notas / len(alumnos)
    return f"Nota media: {media:.2f}"

