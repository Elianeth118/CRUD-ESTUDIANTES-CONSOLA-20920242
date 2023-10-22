package com.example.lista1estudiantes

class CRUDEstudiante {
    var listaEstudiantes : MutableList<Estudiante> = mutableListOf()

    fun crearEstudiante(numControl: String, nombre:String, apellidos:String, semestre:Int){
        val estudiante : Estudiante = Estudiante(numControl,nombre,apellidos,semestre)
        listaEstudiantes.add( estudiante)
    }

    fun obtenerListaEstudiantes():String{
        var cadena="N.C.\tNombre\tApellidos\tSemestre\n"
        listaEstudiantes.forEach(){
            cadena+=it.numControl+"\t"+ it.nombre+"\t"+it.apellidos+"\t"+it.semestre+"\n"
        }
        return  cadena
    }
    //buscar un estudiante
    fun buscarestudiante(numControl: String):String{
        var cadena:String="No se encontro el usuario"
        var i=0
        var objEst:Estudiante
        while(i<listaEstudiantes.size) {
            objEst = listaEstudiantes[i]
            if (objEst.numControl.equals(numControl)) {
                cadena =
                    objEst.numControl + "\t" + objEst.nombre + "\t" + objEst.apellidos + "\t" + objEst.semestre
                break

            }

           i++
        }

        return cadena

    }



    fun eliminarEstudiante(numControl: String) {
        val estudianteAEliminar = listaEstudiantes.find { it.numControl == numControl }

        if (estudianteAEliminar != null) {
            println("Estudiante a eliminar")
            println("NoControl: ${estudianteAEliminar.numControl}")
            println("Estudiante: ${estudianteAEliminar.nombre}")

            println("¿Desea eliminar a este estudiante(SI/NO)")

            val respuesta= readLine()
            if(respuesta.equals("SI", ignoreCase = true)==true){
                listaEstudiantes.remove(estudianteAEliminar)
                println("Estudiante eliminado con éxito.")
            }else{
                println("Eliminacion cancelada ")
            }


        } else {
            println("Estudiante no encontrado.")
        }
    }

    fun editarEstudianteConsola(numControl: String) {
        println("Ingrese el número de control del estudiante que desea editar:")
        val numControl = readLine() ?: return

        val estudianteEditar = listaEstudiantes.find { it.numControl == numControl }

        if (estudianteEditar != null) {
            println("Estudiante encontrado. Ingrese los nuevos datos:")

            print("Nuevo nombre: ")
            val nuevoNombre = readLine() ?: estudianteEditar.nombre

            print("Nuevos apellidos: ")
            val nuevosApellidos = readLine() ?: estudianteEditar.apellidos

            print("Nuevo semestre: ")
            val nuevoSemestre = readLine()?.toIntOrNull() ?: estudianteEditar.semestre

            // Actualiza los datos del estudiante
            estudianteEditar.nombre = nuevoNombre
            estudianteEditar.apellidos= nuevosApellidos
            estudianteEditar.semestre = nuevoSemestre

            println("Estudiante editado con éxito.")
        } else {
            println("Estudiante no encontrado.")
        }
    }
    fun mostrarMenu() {
        println("Menú:")
        println("1. Agregar estudiante")
        println("2. Editar estudiante")
        println("3. Eliminar estudiante")
        println("4. Buscar estudante")
        println("5. Listar estudiantes")

        println("6. Salir")
        print("Seleccione una opción: ")
    }


}







