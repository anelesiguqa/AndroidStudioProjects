package za.co.anelesiguqa.theshamelessself_promoapp2

import java.io.Serializable

data class Message(
    val contactName: String,
    val contactNumber: String,
    val myDisplayName: String,
    val includeJunior: Boolean?,
    val jobTitle: String,
    val immediateStart: Boolean?,
    val startDate: String
) : Serializable