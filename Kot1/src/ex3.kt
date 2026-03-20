sealed class EnrollmentStatus()
{
   class Success(val courseCode: String) : EnrollmentStatus()
    class Error(val message: String): EnrollmentStatus()
    object Loading: EnrollmentStatus()


}



fun printStatus(status: EnrollmentStatus)
{
    when(status)
    {
         is EnrollmentStatus.Success -> println("Congrats into making it into: ${status.courseCode}")
         is EnrollmentStatus.Loading -> println("The Information is being loaded")
        is EnrollmentStatus.Error -> println("Error Message : ${status.message}")

    }


}

fun main()
{


    printStatus(EnrollmentStatus.Loading)
    printStatus(EnrollmentStatus.Success("CMP343"))
    printStatus(EnrollmentStatus.Error("ERROR 55465566"))
}

