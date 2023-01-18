package data

data class Comments (
    // количество комментариев;
    val count: Int = 0,
    //информация о том, может ли текущий пользователь комментировать запись (true — может, false — не может);
    val canPost: Boolean = true,
    //информация о том, могут ли сообщества комментировать запись;
    val groupsCanPost : Boolean = true,
    // может ли текущий пользователь закрыть комментарии к записи;
    val canClose : Boolean = true,
    //  может ли текущий пользователь открыть комментарии к записи.
    val canOpen : Boolean = true,
)
