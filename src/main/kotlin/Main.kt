import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.enhanced.dynamodb.TableSchema
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import java.net.URI

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    val dynamoDbClient = DynamoDbClient
            .builder()
            .region(Region.AP_EAST_1)
            .endpointOverride(URI.create("http://localhost:8000"))
            .build()
    val enhancedClient = DynamoDbEnhancedClient.builder().dynamoDbClient(dynamoDbClient).build()

    println(dynamoDbClient.describeLimits())

    val user = UserBasicInformation(
        "gabriel.flores@pedidosya.com",
        "Gabriel",
        "Flores",
        "Principal Eng",
        "PeYa"
    )
    val password = UserPassword(
        "gabriel.flores@pedidosya.com",
        "my_password"
    )
    val rol = UserRol(
        "gabriel.flores@pedidosya.com",
        "SuperAdmin"
    )
    val user_juan = UserBasicInformation(
        "juan.rosales@pedidosya.com",
        "Juan",
        "Rosales",
        "Principal Eng",
        "PeYa"
    )
    val password_juan = UserPassword(
        "juan.rosales@pedidosya.com",
        "juan_password"
    )
    val rol_juan = UserRol(
        "juan.rosales@pedidosya.com",
        "CountryAdmin"
    )
    val rol_juan_2 = UserRol(
        "juan.rosales@pedidosya.com",
        "SuperAdmin"
    )
    val userBasicInformationTable = TableSchema.fromClass(UserBasicInformation::class.java)
    val userPasswordTable = TableSchema.fromClass(UserPassword::class.java)
    val UserRolTable = TableSchema.fromClass(UserRol::class.java)

    var tableUserBasicInformation = enhancedClient.table("User", userBasicInformationTable)
    var tableUserPassword = enhancedClient.table("User", userPasswordTable)
    var tableUserRol = enhancedClient.table("User", UserRolTable)

    try {
        tableUserBasicInformation.createTable()
    } catch (e: Exception) {

    }
    tableUserBasicInformation.putItem(user)
    tableUserPassword.putItem(password)
    tableUserRol.putItem(rol)
    tableUserBasicInformation.putItem(user_juan)
    tableUserPassword.putItem(password_juan)
    tableUserRol.putItem(rol_juan)
    tableUserRol.putItem(rol_juan_2)

}