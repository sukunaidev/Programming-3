import com.sun.net.httpserver.Authenticator
import jdk.internal.net.http.common.Pair.pair

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

data class WebResponse(val statusCode: Int, val statusMessage: String, val body: String?)


fun routeRequest(path: String, user:String?)
{
    when
    {
        path.endsWith("/home", true) -> println("Welcome to the Lehman Homepage, ${user ?: "Guest"}!")
        path.endsWith("/grades", true) && user != null -> println("Loading grades for $user...")
        path.endsWith("/grades", true) && user == null -> println("Error: Unauthorized access to grades.")
        else -> println("404: Path $path not found.")



    }

}

fun describeStatus(code: Int)
{
    when(code)
    {
        in 200..299 -> println("Success: The request was fulfilled.")
        in 400..499 -> println("Client Error: Check your URL or parameters.")
        in 500..599 ->  println("Server Error: The Lehman Server is having trouble.")
        else -> print("Unknown status code.")
    }

}




fun main() {
    val success = WebResponse(200, "Success", null)
    val notFound = WebResponse(404, "Not Found", null)
    println(success)
    println(notFound)

    describeStatus(201)
    describeStatus(404)
    describeStatus(503)

    routeRequest("ohh miii /grades", "brown")
    routeRequest("ohh miii /grades", null)
    routeRequest("ohh miii /home", "brown")
    routeRequest("ohh miii /home", null)
    routeRequest("ohh miii ", null)


}