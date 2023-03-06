import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey

@DynamoDbBean
data class UserBasicInformation(
    @get:DynamoDbPartitionKey var email: String? = null,
    var name: String? = null,
    var lastname: String? = null,
    var title: String? = null,
    var company: String? = null,
    @get:DynamoDbSortKey var sk: String? = "BASIC_INFO"
)

@DynamoDbBean
data class UserPassword(
    @get:DynamoDbPartitionKey var email: String? = null,
    var hashed_password: String? = null,
    @get:DynamoDbSortKey var sk: String? = "PASSWORD"
)

@DynamoDbBean
data class UserRol(
    @get:DynamoDbPartitionKey var email: String? = null,
    var rol: String? = null,
    @get:DynamoDbSortKey var sk: String? = "ROL#$rol"
)

//
//@DynamoDbSortKey
//public int getSubId() { return this.subId; }
//public void setSubId(int subId) { this.subId = subId; }
//
//// Defines a GSI (customers_by_name) with a partition key of 'name'
//@DynamoDbSecondaryPartitionKey(indexNames = "customers_by_name")
//public String getName() { return this.name; }
//public void setName(String name) { this.name = name; }
