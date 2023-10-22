package com.example.lista1estudiantes
fun main(){
    val crudEst : CRUDEstudiante = CRUDEstudiante()
    //Aqui se haría la captura del registro para después enviar los datos
    //en el metodo crearEstudiante

    crudEst.crearEstudiante("1234","Sandra","Ramos Ramos",3)
    crudEst.crearEstudiante("1235","Daniel","Cortes Cruz",2)
    crudEst.crearEstudiante("1236","Carmen","Paz Toledo",7)
    println(crudEst.obtenerListaEstudiantes())




       while (true) {
            crudEst.mostrarMenu()

            val opcion = readLine()?.toIntOrNull()

            when (opcion) {
                1 -> {
                    println("Ingrese el número de control:")
                    val numControl = readLine() ?: ""
                    println("Ingrese el nombre:")
                    val nombre = readLine() ?: ""
                    println("Ingrese los apellidos:")
                    val apellidos = readLine() ?: ""
                    println("Ingrese el semestre:")
                    val semestre = readLine()?.toIntOrNull() ?: 0
                    crudEst.crearEstudiante(numControl, nombre, apellidos, semestre)
                    println("Estudiante agregado con éxito.")
                }
                2 -> {
                    println("Ingrese el número de control del estudiante a editar:")
                    val numControl = readLine() ?: ""
                    crudEst.editarEstudianteConsola(numControl)
                }
                3 -> {
                    println("Ingrese el número de control del estudiante a eliminar:")
                    val numControl = readLine() ?: ""

                    crudEst.eliminarEstudiante(numControl)
                }

                4 -> {
                    var nc:String=""
                    var cadena:String=""
                    print("Introduce el numero de control del estudiante ");
                    nc= readln()
                    cadena=crudEst.buscarestudiante(nc)
                    println(cadena)
                }
                5 -> {
                    val listaEstudiantes = crudEst.obtenerListaEstudiantes()
                    println(listaEstudiantes)
                }
                6 -> return
                else -> println("Opción no válida. Intente de nuevo.")
            }
        }
    }





