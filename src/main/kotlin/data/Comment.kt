package data

data class Comment(
    // Идентификатор комментария.
    val id: Long = 0,
    // Идентификатор автора комментария.
    val from_id: Long = 0,
    //Время публикации записи в формате unixtime.
    val date: Long= System.currentTimeMillis(),
    // Текст комментария.
    val text: String = "",
    // Идентификатор пользователя или сообщества, в ответ которому оставлен текущий комментарий (если применимо).
    val reply_to_user: Long = 0,
    // Идентификатор комментария, в ответ на который оставлен текущий (если применимо).
    val reply_to_comment: Long = 0,
)
