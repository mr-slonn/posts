package data

data class Likes(
    //число пользователей, которым понравилась запись;
    val count: Int = 0,
    //наличие отметки «Мне нравится» от текущего пользователя (1 — есть, 0 — нет);
    val userLikes: Boolean = false,
    // информация о том, может ли текущий пользователь поставить отметку «Мне нравится» (1 — может, 0 — не может);
    val canLike: Boolean = true,
    // информация о том, может ли текущий пользователь сделать репост записи (1 — может, 0 — не может).
    val canPublish: Boolean = true,


    )
