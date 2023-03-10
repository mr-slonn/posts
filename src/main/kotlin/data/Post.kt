package data

data class Post(
    //Идентификатор записи.
    val id: Long = 0,
    //Идентификатор владельца стены, на которой размещена запись.
    //Идентификатор автора записи (от чьего имени опубликована запись).
    val fromId: Long,
    val ownerId: Long? = fromId,
    //Идентификатор администратора, который опубликовал запись (возвращается только для сообществ при запросе
    // с ключом доступа администратора). Возвращается в записях, опубликованных менее 24 часов назад.
    val createdBy: Long? = null,
    //Время публикации записи в формате unixtime.
    val date: Long = System.currentTimeMillis(),
    //Текст записи.
    val text: String,
    //Идентификатор владельца записи, в ответ на которую была оставлена текущая.
    val replyOwnerId: Long? = null,
    //Идентификатор записи, в ответ на которую была оставлена текущая.
    val replyPostId: Long? = null,
    //true, если запись была создана с опцией «Только для друзей».
    val friendsOnly: Boolean = false,
    //Информация о комментариях к записи, объект с полями:
    val comments: Comments? = null,
    //Источник материала, объект с полями:
    val copyright: Copyright? = null,
    //Информация о лайках к записи, объект с полями:
    val likes: Likes = Likes(),
    //Информация о репостах записи («Рассказать друзьям»), объект с полями:
    val reposts: Reposts = Reposts(),
    //Информация о просмотрах записи. Объект с единственным полем:
    val views: Views = Views(),
    //ип записи, может принимать следующие значения: post, copy, reply, postpone, suggest.
    val postType: String = "post",
)