fun main() {
    println(agoToText(3599))
}


fun agoToText(howTimeAgo: Int) = when (howTimeAgo){
    in 1..60 -> "был(а) только что"
    in 61..3599 -> "был(а) ${howManyMinutes(howTimeAgo)} назад"
    in 3600..86400 -> "был(а) ${howManyHours(howTimeAgo)} назад"
    in 86401..172800 -> "был(а) вчера"
    in 172801..259200 -> "был(а) позавчера"
    else -> "был(а) давно"
}

fun howManyMinutes(howTimeAgo: Int): String {
    return when (val minutes = howTimeAgo / 60) {
        1, 21, 31, 41, 51 -> "$minutes минуту"
        in 2..4, in 22..24, in 32..34, in 42..44, in 52..54 -> "$minutes минуты"
        in 5..20, in 25..30, in 35..40, in 45..50, in 55..59 -> "$minutes минут"
        in 11..14 -> "$minutes минут"
        else -> howManyHours(howTimeAgo)
    }
}

fun howManyHours(howTimeAgo: Int): String {
    return when (val hours = howTimeAgo / 3600) {
        1, 21 -> "$hours час"
        2, 3, 4, 22, 23, 24 -> "$hours часа"
        in 5..20 -> "$hours часов"
        else -> "был(а) давно"
    }
}