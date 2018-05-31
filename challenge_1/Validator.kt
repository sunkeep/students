
fun validateInputIsValidUrl(input : String) : Boolean {
    val maxLength = 100
    if(input.length > maxLength) {
        return false
    }

    val URL_PATTERN = Pattern.compile("(https?://)?[0-9_\\-a-zA-Z]+[\\.(0-9_\\-a-zA-Z)+]+\\.[0-9_\\-a-zA-Z]+\\S*")
    //return regex check is true
}
